package com.close.ai.service;

import com.close.ai.dto.HumanDTO;
import com.close.ai.dto.HumanPersonaConversationDTO;
import com.close.ai.dto.HumanPersonaConversationMessagesDTO;
import com.close.ai.dto.PersonaDTO;
import com.close.ai.dto.converter.HumanPersonaConversationDTOConverter;
import com.close.ai.enums.ResponseCode;
import com.close.ai.mapper.HumanPersonaConversationMapper;
import com.close.ai.pojo.HumanPersonaConversation;
import com.close.ai.request.create.HumanPersonaConversationSaveRequest;
import com.close.ai.request.create.MessageSaveRequest;
import com.close.ai.utils.IdUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Service
public class HumanPersonaConversationService {
    private final  HumanPersonaConversationMapper humanPersonaConversationMapper;

    private final HumanService humanService;
    private final PersonaService personaService;
    private final  MessageService messageService;

    private final  HumanPersonaConversationDTOConverter humanPersonaConversationDTOConverter;

    public HumanPersonaConversationService(HumanPersonaConversationMapper humanPersonaConversationMapper,
                                           HumanService humanService,
                                           PersonaService personaService,
                                           MessageService messageService,
                                           HumanPersonaConversationDTOConverter humanPersonaConversationDTOConverter) {
        this.humanPersonaConversationMapper = humanPersonaConversationMapper;
        this.messageService = messageService;
        this.humanPersonaConversationDTOConverter = humanPersonaConversationDTOConverter;
        this.humanService = humanService;
        this.personaService = personaService;
    }

    public List<HumanPersonaConversationMessagesDTO> getHumanPersonaConversationMessages(Long id,
                                                                                         Long humanId,
                                                                                         Long personaId) {
        // 不允许查询所有对话记录
        if(id == null && humanId == null && personaId == null){
            return null;
        }
        HumanPersonaConversation conversation = new HumanPersonaConversation();
        conversation.setId(id);
        conversation.setHumanId(humanId);
        conversation.setPersonaId(personaId);
        return humanPersonaConversationMapper.selectHumanPersonaConversationMessages(conversation);
    }

    /**
     * 保存对话记录
     * @param request 请求体
     * @return ResponseCode
     */
    @Transactional
    public void saveHumanPersonaConversation(HumanPersonaConversationSaveRequest request) {
        if (request == null || request.getHumanId() == null || request.getPersonaId() == null || request.getMessages() == null) {
            throw new IllegalArgumentException("Request parameters cannot be null");
        }

        HumanDTO human = humanService.getHumanById(request.getHumanId(), true);
        if (human == null) {
            throw new IllegalStateException("Human does not exist: " + request.getHumanId());
        }

        PersonaDTO persona = personaService.getPersonaById(request.getPersonaId(), true);
        if (persona == null) {
            throw new IllegalStateException("Persona does not exist: " + request.getPersonaId());
        }

        List<MessageSaveRequest> messages = request.getMessages();
        List<Long> messageIds = messageService.saveMessages(messages);

        HumanPersonaConversationDTO dto = request.toDTO();
        dto.setId(IdUtil.getSnowflake().nextId());
        dto.setMessages(messageIds);

        int res = humanPersonaConversationMapper.insertHumanPersonaConversation(humanPersonaConversationDTOConverter.toEntity(dto));
        if (res != 1) {
            throw new RuntimeException("Failed to insert human persona conversation");
        }
    }
}

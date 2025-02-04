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
import org.springframework.stereotype.Service;

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
    public ResponseCode saveHumanPersonaConversation(HumanPersonaConversationSaveRequest request) {
        if(request == null || request.getHumanId() == null || request.getPersonaId() == null || request.getMessages() == null) {
            return ResponseCode.PARAMETER_NULL;
        }

        HumanDTO human = humanService.getHumanById(request.getHumanId(), true);
        if(human == null) {return ResponseCode.HUMAN_NOT_EXIST;}
        PersonaDTO persona = personaService.getPersonaById(request.getPersonaId(), true);
        if(persona == null) {return ResponseCode.PERSONA_NOT_EXIST;}

        List<MessageSaveRequest> messages = request.getMessages();

        // 调用批量插入方法
        List<Long> messageIds = messageService.saveMessages(messages);

        HumanPersonaConversationDTO dto = request.toDTO();
        dto.setMessages(messageIds);

        Integer res = humanPersonaConversationMapper.insertHumanPersonaConversation(humanPersonaConversationDTOConverter.toEntity(dto));
        if(res != 1) {
            return ResponseCode.HUMAN_PERSONA_CONVERSATION_INSERT_FAILED;
        }
        return ResponseCode.OK;
    }
}

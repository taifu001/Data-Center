package com.close.ai.service;

import com.close.ai.dto.AgentDTO;
import com.close.ai.dto.PersonaDTO;
import com.close.ai.dto.TraitsChangeRecordDTO;
import com.close.ai.dto.converter.PersonaDTOConverter;
import com.close.ai.enums.ResponseCode;
import com.close.ai.enums.pojo.HumanPersonaEnum;
import com.close.ai.enums.pojo.TraitsRecordChangeTypeEnum;
import com.close.ai.mapper.PersonaMapper;
import com.close.ai.pojo.Persona;
import com.close.ai.request.create.PersonaCreateRequest;
import com.close.ai.request.update.PersonaUpdateRequest;
import com.close.ai.utils.IdUtil;
import com.close.ai.utils.JacksonUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Set;

/**
 * @author nbwyctf
 * @since 2025-02-02
 */
@Service
public class PersonaService {
    private final PersonaMapper personaMapper;

    private final AgentService agentService;
    private final TraitsChangeRecordService traitsChangeRecordService;

    private final PersonaDTOConverter personaDTOConverter;

    private static final Set<Integer> VALID_STATES = Set.of(0, 1);

    public PersonaService(PersonaMapper personaMapper,
                          AgentService agentService,
                          TraitsChangeRecordService traitsChangeRecordService,
                          PersonaDTOConverter personaDTOConverter) {
        this.personaMapper = personaMapper;
        this.agentService = agentService;
        this.traitsChangeRecordService = traitsChangeRecordService;
        this.personaDTOConverter = personaDTOConverter;
    }

    public PersonaDTO getPersonaById(Long personaId, boolean isActive) {
        if (personaId == null) {
            return null;
        }
        Persona persona = isActive
                ? personaMapper.selectActivePersonaById(personaId)
                : personaMapper.selectPersonaById(personaId);
        if (persona == null) {
            return null;
        }
        return personaDTOConverter.fromEntity(persona);
    }

    @Transactional
    public void createPersona(PersonaCreateRequest request) {
        if (request == null || request.getAgentId() == null) {
            throw new IllegalArgumentException("Request parameters cannot be null");
        }

        AgentDTO agentDTO = agentService.getAgentById(request.getAgentId(), true);
        if (agentDTO == null) {
            throw new IllegalStateException("Agent does not exist: " + request.getAgentId());
        }

        Persona persona = personaDTOConverter.toEntity(request.toDTO());
        persona.setId(IdUtil.getSnowflake().nextId());

        if (persona.getState() == null) {
            persona.setState(0);
        } else if (!VALID_STATES.contains(persona.getState())) {
            throw new IllegalStateException("Invalid persona state: " + persona.getState());
        }

        int res = personaMapper.insertPersona(persona);
        if (res != 1) {
            throw new RuntimeException("Failed to insert persona");
        }
    }

    @Transactional
    public void updatePersona(PersonaUpdateRequest request) {
        if (request == null || request.getId() == null) {
            throw new IllegalArgumentException("Request parameters cannot be null");
        }

        Persona pastPersona = personaMapper.selectPersonaById(request.getId());
        if (pastPersona == null) {
            throw new IllegalStateException("Persona does not exist: " + request.getId());
        }

        // 解析 JSON
        Map<String, Object> oldTraitsMap = JacksonUtil.parseJsonToMap(pastPersona.getTraitsJson());
        Map<String, Object> newTraitsMap = JacksonUtil.parseJsonToMap(request.getTraitsJson());

        // 统一转换为下划线命名
        oldTraitsMap = JacksonUtil.convertKeysToSnakeCase(oldTraitsMap);
        newTraitsMap = JacksonUtil.convertKeysToSnakeCase(newTraitsMap);

        // 合并 JSON
        oldTraitsMap.putAll(newTraitsMap);

        // 转换回 JSON
        String mergedTraitsJson = JacksonUtil.mapToJson(oldTraitsMap);

        // 记录变更
        TraitsChangeRecordDTO traitsChangeRecordDTO = TraitsChangeRecordDTO.builder()
                .sourceType(HumanPersonaEnum.PERSONA)
                .sourceId(pastPersona.getId())
                .oldTraitsJson(pastPersona.getTraitsJson())
                .newTraitsJson(mergedTraitsJson)
                .changeType(TraitsRecordChangeTypeEnum.UPDATE)
                .build();

        traitsChangeRecordService.saveTraitsChange(traitsChangeRecordDTO);

        Persona persona = personaDTOConverter.toEntity(request.toDTO());
        // 确保存储的是合并后的 JSON
        persona.setTraitsJson(mergedTraitsJson);

        int res = personaMapper.updatePersona(persona);

        if (res != 1) {
            throw new RuntimeException("Failed to update persona");
        }
    }
}

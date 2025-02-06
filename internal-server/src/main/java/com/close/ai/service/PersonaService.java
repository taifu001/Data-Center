package com.close.ai.service;

import com.close.ai.dto.AgentDTO;
import com.close.ai.dto.PersonaDTO;
import com.close.ai.dto.converter.PersonaDTOConverter;
import com.close.ai.enums.ResponseCode;
import com.close.ai.mapper.PersonaMapper;
import com.close.ai.pojo.Persona;
import com.close.ai.request.create.PersonaCreateRequest;
import com.close.ai.request.update.PersonaUpdateRequest;
import com.close.ai.service.utils.SourceCheckService;
import com.close.ai.utils.IdUtil;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author nbwyctf
 * @since 2025-02-02
 */
@Service
public class PersonaService {
    private final PersonaMapper personaMapper;

    private final AgentService agentService;

    private final PersonaDTOConverter personaDTOConverter;

    private static final Set<Integer> VALID_STATES = Set.of(0, 1);

    public PersonaService(PersonaMapper personaMapper,
                          AgentService agentService,
                          PersonaDTOConverter personaDTOConverter) {
        this.personaMapper = personaMapper;
        this.agentService = agentService;
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

    public ResponseCode createPersona(PersonaCreateRequest request) {
        if(request == null || request.getAgentId() == null) {
            return ResponseCode.PARAMETER_NULL;
        }

        AgentDTO agentDTO = agentService.getAgentById(request.getAgentId(), true);
        if(agentDTO == null){
            return ResponseCode.AGENT_NOT_EXIST;
        }

        Persona persona = personaDTOConverter.toEntity(request.toDTO());

        persona.setId(IdUtil.getSnowflake().nextId());
        if (persona.getState() == null) {
            persona.setState(0);
        } else if (!VALID_STATES.contains(persona.getState())) {
            return ResponseCode.DATA_STATUS_INSERT_FAILED;
        }

        Integer res = personaMapper.insertPersona(persona);
        if (res != 1) {return ResponseCode.PERSONA_INSERT_FAILED;}
        return ResponseCode.OK;
    }

    public ResponseCode updatePersona(PersonaUpdateRequest request) {
        if (request == null || request.getId() == null) {
            return ResponseCode.PARAMETER_NULL;
        }

        Persona persona = personaDTOConverter.toEntity(request.toDTO());

        Integer res = personaMapper.updatePersona(persona);
        if (res != 1) {return ResponseCode.PERSONA_UPDATE_FAILED;}
        return ResponseCode.OK;
    }
}

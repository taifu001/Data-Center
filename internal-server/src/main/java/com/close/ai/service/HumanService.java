package com.close.ai.service;

import com.close.ai.dto.HumanDTO;
import com.close.ai.dto.converter.HumanDTOConverter;
import com.close.ai.enums.ResponseCode;
import com.close.ai.mapper.HumanMapper;
import com.close.ai.pojo.Human;
import com.close.ai.request.update.HumanUpdateRequest;
import com.close.ai.utils.IdUtil;
import org.springframework.stereotype.Service;

/**
 * @author nbwyctf
 * @since 2025-01-21
 */
@Service
public class HumanService {
    private final HumanMapper humanMapper;

    private final HumanDTOConverter humanDTOConverter;

    public HumanService(HumanMapper humanMapper,
                        HumanDTOConverter humanDTOConverter) {
        this.humanMapper = humanMapper;
        this.humanDTOConverter = humanDTOConverter;
    }

    public HumanDTO getHumanById(Long humanId, boolean isActive) {
        if (humanId == null) {
            return null;
        }
        Human human = isActive
                ? humanMapper.selectActiveHumanById(humanId)
                : humanMapper.selectHumanById(humanId);
        if (human == null) {
            return null;
        }
        return humanDTOConverter.fromEntity(human);
    }

    public ResponseCode createBlankHumanWithUserId(Long userId) {
        if (userId == null) {
            return ResponseCode.PARAMETER_NULL;
        }
        Human human = new Human();
        human.setId(IdUtil.getSnowflake().nextId());
        human.setUserId(userId);
        Integer res = humanMapper.insertHuman(human);
        if (res != 1) {
            return ResponseCode.HUMAN_INSERT_FAILED;
        }
        return ResponseCode.OK;
    }

    public ResponseCode updateHuman(HumanUpdateRequest request) {
        if (request == null || request.getId() == null) {
            return ResponseCode.PARAMETER_NULL;
        }

        Human human = humanDTOConverter.toEntity(request.toDTO());

        Integer res = humanMapper.updateHuman(human);

        if (res != 1) {return ResponseCode.HUMAN_UPDATE_FAILED;}
        return ResponseCode.OK;
    }
}

package com.close.ai.service;

import com.close.ai.dto.HumanDTO;
import com.close.ai.dto.TraitsChangeRecordDTO;
import com.close.ai.dto.converter.HumanDTOConverter;
import com.close.ai.enums.ResponseCode;
import com.close.ai.enums.pojo.HumanPersonaEnum;
import com.close.ai.enums.pojo.TraitsRecordChangeTypeEnum;
import com.close.ai.mapper.HumanMapper;
import com.close.ai.pojo.Human;
import com.close.ai.request.update.HumanUpdateRequest;
import com.close.ai.utils.IdUtil;
import com.close.ai.utils.JacksonUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @author nbwyctf
 * @since 2025-01-21
 */
@Service
public class HumanService {
    private final HumanMapper humanMapper;

    private final TraitsChangeRecordService traitsChangeRecordService;

    private final HumanDTOConverter humanDTOConverter;

    public HumanService(HumanMapper humanMapper,
                        TraitsChangeRecordService traitsChangeRecordService,
                        HumanDTOConverter humanDTOConverter) {
        this.humanMapper = humanMapper;
        this.traitsChangeRecordService = traitsChangeRecordService;
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
            throw new IllegalArgumentException("Request parameters cannot be null");
        }
        Human human = new Human();
        human.setId(IdUtil.getSnowflake().nextId());
        human.setUserId(userId);
        Integer res = humanMapper.insertHuman(human);
        if (res != 1) {
            throw new RuntimeException("Failed to insert human");
        }
        return ResponseCode.OK;
    }

    @Transactional
    public void updateHuman(HumanUpdateRequest request) {
        if (request == null || request.getId() == null) {
            throw new IllegalArgumentException("Request parameters cannot be null");
        }

        Human pastHuman = humanMapper.selectHumanById(request.getId());
        if (pastHuman == null) {
            throw new IllegalStateException("Human does not exist: " + request.getId());
        }

        // 解析 JSON
        Map<String, Object> oldTraitsMap = JacksonUtil.parseJsonToMap(pastHuman.getTraitsJson());
        Map<String, Object> newTraitsMap = JacksonUtil.parseJsonToMap(request.getTraitsJson());

        // 确保所有键使用下划线
        oldTraitsMap = JacksonUtil.convertKeysToSnakeCase(oldTraitsMap);
        newTraitsMap = JacksonUtil.convertKeysToSnakeCase(newTraitsMap);

        // 合并 JSON
        oldTraitsMap.putAll(newTraitsMap);

        // 转换回 JSON
        String mergedTraitsJson = JacksonUtil.mapToJson(oldTraitsMap);

        TraitsChangeRecordDTO traitsChangeRecordDTO = TraitsChangeRecordDTO.builder()
                .sourceType(HumanPersonaEnum.HUMAN)
                .sourceId(pastHuman.getId())
                .oldTraitsJson(pastHuman.getTraitsJson())
                .newTraitsJson(mergedTraitsJson)
                .changeType(TraitsRecordChangeTypeEnum.UPDATE)
                .build();

        traitsChangeRecordService.saveTraitsChange(traitsChangeRecordDTO);

        Human human = humanDTOConverter.toEntity(request.toDTO());
        // 确保存储的是合并后的 JSON
        human.setTraitsJson(mergedTraitsJson);

        int res = humanMapper.updateHuman(human);

        if (res != 1) {
            throw new RuntimeException("Failed to update human");
        }
    }
}

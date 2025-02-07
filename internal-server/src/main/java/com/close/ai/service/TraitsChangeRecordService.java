package com.close.ai.service;

import com.close.ai.dto.TraitsChangeRecordDTO;
import com.close.ai.dto.converter.TraitsChangeRecordDTOConverter;
import com.close.ai.enums.ResponseCode;
import com.close.ai.mapper.TraitsChangeRecordMapper;
import com.close.ai.pojo.TraitsChangeRecord;
import com.close.ai.utils.IdUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nbwyctf
 * @since 2025-02-07
 */
@Service
public class TraitsChangeRecordService {
    private final TraitsChangeRecordMapper traitsChangeRecordMapper;

    private final TraitsChangeRecordDTOConverter traitsChangeRecordDTOConverter;

    public TraitsChangeRecordService(TraitsChangeRecordMapper traitsChangeRecordMapper,
                                     TraitsChangeRecordDTOConverter traitsChangeRecordDTOConverter) {
        this.traitsChangeRecordMapper = traitsChangeRecordMapper;
        this.traitsChangeRecordDTOConverter = traitsChangeRecordDTOConverter;
    }

    @Transactional
    public void saveTraitsChange(TraitsChangeRecordDTO traitsChangeRecordDTO) {
        if (traitsChangeRecordDTO == null || traitsChangeRecordDTO.getChangeType() == null ||
                traitsChangeRecordDTO.getSourceType() == null || traitsChangeRecordDTO.getSourceId() == null) {
            throw new IllegalArgumentException("Traits change record parameters cannot be null");
        }

        TraitsChangeRecord record = traitsChangeRecordDTOConverter.toEntity(traitsChangeRecordDTO);
        record.setId(IdUtil.getSnowflake().nextId());

        int res = traitsChangeRecordMapper.insertTraitsChangeRecord(record);
        if (res != 1) {
            throw new RuntimeException("Failed to insert traits change record");
        }
    }
}

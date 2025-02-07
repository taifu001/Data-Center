package com.close.ai.dto.converter;

import com.close.ai.dto.TraitsChangeRecordDTO;
import com.close.ai.pojo.TraitsChangeRecord;
import org.mapstruct.Mapper;

/**
 * @author nbwyctf
 * @since 2025-02-07
 */
@Mapper(componentModel = "spring")
public interface TraitsChangeRecordDTOConverter {
    TraitsChangeRecordDTO fromEntity(TraitsChangeRecord traitsChangeRecord);

    TraitsChangeRecord toEntity(TraitsChangeRecordDTO traitsChangeRecordDTO);
}

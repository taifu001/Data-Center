package com.close.ai.dto.converter;

import com.close.ai.dto.HumanDTO;
import com.close.ai.pojo.Human;
import org.mapstruct.Mapper;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Mapper(componentModel = "spring")
public interface HumanDTOConverter {
    HumanDTO fromEntity(Human human);

    Human toEntity(HumanDTO humanDTO);
}

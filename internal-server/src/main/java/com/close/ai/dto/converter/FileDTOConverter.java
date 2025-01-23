package com.close.ai.dto.converter;

import com.close.ai.dto.FileDTO;
import com.close.ai.pojo.File;
import org.mapstruct.Mapper;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Mapper(componentModel = "spring")
public interface FileDTOConverter {
    FileDTO fromEntity(File file);

    File toEntity(FileDTO dto);
}

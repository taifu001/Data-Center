package com.close.ai.dto.converter;

import com.close.ai.dto.ToolDTO;
import com.close.ai.pojo.Tool;
import org.mapstruct.Mapper;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Mapper(componentModel = "spring")
public interface ToolDTOConverter {
    ToolDTO fromEntity(Tool tool);

    Tool toEntity(ToolDTO dto);
}

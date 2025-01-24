package com.close.ai.service;

import com.close.ai.dto.converter.ToolDTOConverter;
import com.close.ai.mapper.ToolMapper;
import org.springframework.stereotype.Service;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Service
public class ToolService {
    private final ToolMapper toolMapper;

    private final ToolDTOConverter toolDTOConverter;

    public ToolService(ToolMapper toolMapper,
                       ToolDTOConverter toolDTOConverter) {
        this.toolMapper = toolMapper;
        this.toolDTOConverter = toolDTOConverter;
    }
}

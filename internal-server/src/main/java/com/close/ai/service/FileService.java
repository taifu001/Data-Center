package com.close.ai.service;

import com.close.ai.dto.converter.FileDTOConverter;
import com.close.ai.enums.ResponseCode;
import com.close.ai.mapper.FileMapper;
import org.springframework.stereotype.Service;

/**
 * @author nbwyctf
 * @since 2025-01-23
 */
@Service
public class FileService {
    private final FileMapper fileMapper;

    private final FileDTOConverter fileDTOConverter;

    public FileService(FileMapper fileMapper,
                       FileDTOConverter fileDTOConverter) {
        this.fileMapper = fileMapper;
        this.fileDTOConverter = fileDTOConverter;
    }


    // todo
    public ResponseCode uploadFile() {
        return null;
    }
}

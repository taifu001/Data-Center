package com.close.ai.service;

import com.close.ai.enums.ResponseCode;
import com.close.ai.mapper.FileMapper;
import org.springframework.stereotype.Service;

/**
 * @author taifu
 * @since 2025-01-23
 */
@Service
public class FileService {
    private final FileMapper fileMapper;

    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }


    // todo
    public ResponseCode uploadFile() {
        return null;
    }
}

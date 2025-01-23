package com.close.ai.pojo;

import com.close.ai.enums.pojo.OwnerTypeEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author nbwyctf
 * @since 2025-1-21
 */
@Data
public class File {
    private Long id;
    private String filename;
    // 文件MIME类型
    private String mimeType;
    // 文件扩展名
    private String extension;
    // 文件大小（字节）
    private Long size;
    // 文件存储路径或URL
    private String storagePath;
    private OwnerTypeEnum ownerType;
    // 拥有者ID
    private Long ownerId;

    private LocalDateTime uploadedTime;
}


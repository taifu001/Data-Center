package com.close.ai.dto;

import com.close.ai.enums.pojo.OwnerTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO {
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

package com.close.ai.dto;

import com.close.ai.enums.pojo.ProductTypeEnum;
import com.close.ai.enums.pojo.ProductUsageTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author nbwyctf
 * @since 2025-01-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private Long id;
    private ProductTypeEnum type;
    private ProductUsageTypeEnum usageType;

    private String name;
    private String version;
    // 0:正常 1:未发布 2:已停产 3:已失效
    private Integer state;
    private String introduction;
    private BigDecimal price;

    private LocalDateTime releasedTime;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}

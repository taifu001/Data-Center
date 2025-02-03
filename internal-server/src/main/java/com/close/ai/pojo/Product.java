package com.close.ai.pojo;

import com.close.ai.enums.pojo.ProductTypeEnum;
import com.close.ai.enums.pojo.ProductUsageTypeEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author nbwyctf
 * @since 2025-01-21
 */
@Data
public class Product {
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

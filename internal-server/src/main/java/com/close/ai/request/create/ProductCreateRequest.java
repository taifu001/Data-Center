package com.close.ai.request.create;

import com.close.ai.dto.ProductDTO;
import com.close.ai.enums.pojo.ProductTypeEnum;
import com.close.ai.enums.pojo.ProductUsageTypeEnum;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author nbwyctf
 * @since 2025-01-25
 */
@Data
public class ProductCreateRequest {
    private ProductTypeEnum type;
    private ProductUsageTypeEnum usageType;

    private String name;
    private String version;
    // 0:正常 1:未发布 2:已停产 3:已失效 创建产品默认为1
    private Integer state;
    private String introduction;
    private BigDecimal price;

    public ProductDTO toDTO() {
        return ProductDTO.builder()
                .type(type)
                .usageType(usageType)
                .name(name)
                .version(version)
                .state(state)
                .introduction(introduction)
                .price(price)
                .build();
    }

}

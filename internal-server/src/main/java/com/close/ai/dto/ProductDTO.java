package com.close.ai.dto;

import com.close.ai.enums.pojo.ProductTypeEnum;
import com.close.ai.enums.pojo.ProductUsageTypeEnum;
import com.close.ai.pojo.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author taifu
 * @since 2025-01-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public static ProductDTO fromEntity(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.id = product.getId();
        dto.type = product.getType();
        dto.usageType = product.getUsageType();
        dto.name = product.getName();
        dto.version = product.getVersion();
        dto.state = product.getState();
        dto.introduction = product.getIntroduction();
        dto.price = product.getPrice();
        dto.releasedTime = product.getReleasedTime();
        dto.createdTime = product.getCreatedTime();
        dto.updatedTime = product.getUpdatedTime();
        return dto;
    }

    public static Product toEntity(ProductDTO dto) {
        Product product = new Product();
        product.setId(dto.id);
        product.setType(dto.type);
        product.setUsageType(dto.usageType);
        product.setName(dto.name);
        product.setVersion(dto.version);
        product.setState(dto.state);
        product.setIntroduction(dto.introduction);
        product.setPrice(dto.price);
        product.setReleasedTime(dto.releasedTime);
        product.setCreatedTime(dto.createdTime);
        product.setUpdatedTime(dto.updatedTime);
        return product;
    }
}

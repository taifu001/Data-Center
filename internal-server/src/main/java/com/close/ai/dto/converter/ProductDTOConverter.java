package com.close.ai.dto.converter;

import com.close.ai.dto.ProductDTO;
import com.close.ai.pojo.Product;
import org.mapstruct.Mapper;

/**
 * @author nbwyctf
 * @since 2025-01-23
 */
@Mapper(componentModel = "spring")
public interface ProductDTOConverter {
    ProductDTO fromEntity(Product product);

    Product toEntity(ProductDTO dto);
}

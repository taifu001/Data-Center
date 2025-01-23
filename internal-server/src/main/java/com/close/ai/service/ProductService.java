package com.close.ai.service;

import com.close.ai.dto.ProductDTO;
import com.close.ai.enums.ResponseCode;
import com.close.ai.mapper.ProductMapper;
import com.close.ai.pojo.Product;
import org.springframework.stereotype.Service;

/**
 * @author taifu
 * @since 2025-01-23
 */
@Service
public class ProductService {
    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public ResponseCode createProduct(ProductDTO productDTO) {
        if (productDTO == null || productDTO.getType() == null || productDTO.getName().isEmpty() ) {
            return ResponseCode.PARAMETER_NULL;
        }
        String inputProductName = productDTO.getName();
        if (productMapper.selectProductByName(inputProductName) != null) {
            return ResponseCode.PRODUCT_NAME_IS_REPEAT;
        }
        Product product = ProductDTO.toEntity(productDTO);
        Integer res = productMapper.insertProduct(product);
        if (res != 1) { return ResponseCode.PRODUCT_INSERT_ERROR; }
        return ResponseCode.OK;
    }

    public ResponseCode releaseProduct(ProductDTO productDTO) {
        if (productDTO == null || productDTO.getId() == null) {
            return ResponseCode.PARAMETER_NULL;
        }

        Product product = ProductDTO.toEntity(productDTO);
        Integer res = productMapper.releaseProduct(product);
        if (res != 1) { return ResponseCode.PRODUCT_RELEASE_ERROR; }
        return ResponseCode.OK;
    }
}

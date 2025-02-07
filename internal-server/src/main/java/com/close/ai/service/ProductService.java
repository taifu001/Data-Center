package com.close.ai.service;

import com.close.ai.dto.ProductDTO;
import com.close.ai.dto.converter.ProductDTOConverter;
import com.close.ai.enums.ResponseCode;
import com.close.ai.mapper.ProductMapper;
import com.close.ai.pojo.Product;
import com.close.ai.request.create.ProductCreateRequest;
import com.close.ai.utils.IdUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @author nbwyctf
 * @since 2025-01-23
 */
@Service
public class ProductService {
    private final ProductMapper productMapper;

    private final ProductDTOConverter productDTOConverter;

    private static final Set<Integer> VALID_STATES = Set.of(0, 1, 2, 3);

    public ProductService(ProductMapper productMapper,
                          ProductDTOConverter productDTOConverter) {
        this.productMapper = productMapper;
        this.productDTOConverter = productDTOConverter;
    }

    @Transactional
    public void createProduct(ProductCreateRequest request) {
        if (request == null || request.getType() == null || request.getName() == null || request.getName().isEmpty()) {
            throw new IllegalArgumentException("Product request parameters cannot be null or empty");
        }

        String inputProductName = request.getName();
        if (productMapper.selectProductByName(inputProductName) != null) {
            throw new IllegalStateException("Product name is already in use: " + inputProductName);
        }

        Product product = productDTOConverter.toEntity(request.toDTO());
        product.setId(IdUtil.getSnowflake().nextId());

        // 默认新创建的产品是 state=1 (未发布)
        if (product.getState() == null) {
            product.setState(1);
        } else if (!VALID_STATES.contains(product.getState())) {
            throw new IllegalStateException("Invalid product state: " + product.getState());
        }

        int res = productMapper.insertProduct(product);
        if (res != 1) {
            throw new RuntimeException("Failed to insert product into database");
        }
    }

    @Transactional
    public void releaseProduct(ProductDTO dto) {
        if (dto == null || dto.getId() == null) {
            throw new IllegalArgumentException("Product release request parameters cannot be null");
        }

        Product product = productDTOConverter.toEntity(dto);
        int res = productMapper.releaseProduct(product);
        if (res != 1) {
            throw new RuntimeException("Failed to release product");
        }
    }
}

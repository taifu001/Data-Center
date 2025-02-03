package com.close.ai.service;

import com.close.ai.dto.ProductDTO;
import com.close.ai.dto.converter.ProductDTOConverter;
import com.close.ai.enums.ResponseCode;
import com.close.ai.mapper.ProductMapper;
import com.close.ai.pojo.Product;
import com.close.ai.request.create.ProductCreateRequest;
import com.close.ai.utils.IdUtil;
import org.springframework.stereotype.Service;

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

    public ResponseCode createProduct(ProductCreateRequest request) {
        if (request == null || request.getType() == null || request.getName().isEmpty() ) {
            return ResponseCode.PARAMETER_NULL;
        }
        String inputProductName = request.getName();
        if (productMapper.selectProductByName(inputProductName) != null) {
            return ResponseCode.PRODUCT_NAME_IS_REPEAT;
        }
        Product product = productDTOConverter.toEntity(request.toDTO());

        product.setId(IdUtil.getSnowflake().nextId());
        // 默认新创建的产品是state=1未发布的产品.
        if(product.getState() == null) {
            product.setState(1);
        } else if (!VALID_STATES.contains(product.getState())) {
            return ResponseCode.DATA_STATUS_INSERT_FAILED;
        }

        Integer res = productMapper.insertProduct(product);
        if (res != 1) { return ResponseCode.PRODUCT_INSERT_FAILED; }
        return ResponseCode.OK;
    }

    public ResponseCode releaseProduct(ProductDTO dto) {
        if (dto == null || dto.getId() == null) {
            return ResponseCode.PARAMETER_NULL;
        }

        Product product = productDTOConverter.toEntity(dto);
        Integer res = productMapper.releaseProduct(product);
        if (res != 1) { return ResponseCode.PRODUCT_RELEASE_FAILED; }
        return ResponseCode.OK;
    }
}

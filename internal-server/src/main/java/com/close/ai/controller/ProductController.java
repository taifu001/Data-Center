package com.close.ai.controller;

import com.close.ai.dto.ProductDTO;
import com.close.ai.enums.ResponseCode;
import com.close.ai.request.create.ProductCreateRequest;
import com.close.ai.response.Response;
import com.close.ai.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nbwyctf
 * @since 2025-01-25
 */
@RestController
@RequestMapping("/close.ai/datacenter/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public Response<ResponseCode> createProduct(@RequestBody ProductCreateRequest request) {
        ProductDTO dto = request.toDTO();
        return Response.response(productService.createProduct(request));
    }
}

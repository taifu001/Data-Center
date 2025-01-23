package com.close.ai.mapper;

import com.close.ai.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author nbwyctf
 * @since 2025-01-22
 */
@Mapper
public interface ProductMapper {
    Product selectProductById(@Param("id") Long id);

    Product selectProductByName(@Param("name") String name);

    List<Product> selectAllActiveProducts();

    Integer releaseProduct(Product product);

    Integer insertProduct(Product product);

    Integer updateProductById(Product product);
}

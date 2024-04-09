package org.com.product.service;

import org.com.product.dto.ProductRequest;
import org.com.product.model.Product;

public interface ProductService {
    
    Iterable<Product> findAll();
    Product findById(Integer id);
    Product save(ProductRequest productRequest);
    Product update(Integer id,ProductRequest productRequest);
    void deleteById(Integer id);
}

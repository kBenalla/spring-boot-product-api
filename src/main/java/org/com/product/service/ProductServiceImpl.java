package org.com.product.service;

import lombok.AllArgsConstructor;
import org.com.product.dto.ProductRequest;
import org.com.product.exception.ResourceNotFoundException;
import org.com.product.mapper.ProductMapper;
import org.com.product.model.Product;
import org.com.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Product save(ProductRequest productRequest) {
        return productRepository.save(productMapper.mapToEntity(productRequest));
    }

    @Override
    public Product update(Integer id, ProductRequest productRequest) {
        Product existingProduct=findById(id);
        productMapper.mapToEntity(productRequest,existingProduct);
        return productRepository.save(existingProduct);

    }

    @Override
    public void deleteById(Integer id) {
        Product product=findById(id);
        productRepository.delete(product);
    }
}

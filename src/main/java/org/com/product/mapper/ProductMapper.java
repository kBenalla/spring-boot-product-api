package org.com.product.mapper;

import org.com.product.dto.ProductRequest;
import org.com.product.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    private final ModelMapper modelMapper=new ModelMapper();

    public Product mapToEntity(ProductRequest productRequest){
        return modelMapper.map(productRequest,Product.class);
    }

    public void mapToEntity(ProductRequest productRequest,Product product){
        modelMapper.map(productRequest,product);
    }
}

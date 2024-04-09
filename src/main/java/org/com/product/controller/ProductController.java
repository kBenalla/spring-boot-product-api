package org.com.product.controller;

import lombok.AllArgsConstructor;
import org.com.product.dto.ProductRequest;
import org.com.product.model.Product;
import org.com.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ProductController {

    private ProductService productService;


    @GetMapping("/products")
    public Iterable<Product> getAllProducts(){
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable Integer id){
        return productService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("products")
    public Product saveProduct(@Validated @RequestBody ProductRequest productRequest){
        return productService.save(productRequest);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable Integer id,
                                 @Validated @RequestBody ProductRequest productRequest){
        return productService.update(id,productRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("products/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteById(id);
    }
}

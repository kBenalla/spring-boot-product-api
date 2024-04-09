package org.com.product;

import org.com.product.model.Product;
import org.com.product.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApiApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductRepository productRepository){
        return args -> {
            productRepository.save(Product.builder().name("iPhone Pro").description("Apple iPhone Pro").price(8000).build());
            productRepository.save(Product.builder().name("iPhone Pro Max").description("Apple iPhone Pro Max").price(12000).build());
            productRepository.save(Product.builder().name("iPad Pro").description("Apple iPad Pro").price(14000).build());
            productRepository.save(Product.builder().name("MacBook").description("Apple Macbook Pro").price(20000).build());
        };
    }



}

package org.com.product.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductRequest {
    @NotBlank(message = " Filing name is mandatory ")
    private String name;
    @NotBlank(message = "Filing description is mandatory")
    private String description;
    @NotNull(message = "Filing price is mandatory")
    @Min(value = 1,message = "price must be greater than or equal to 1")
    private Integer price;
}
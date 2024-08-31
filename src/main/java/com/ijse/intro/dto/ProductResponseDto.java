package com.ijse.intro.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {

    private String name;
    private double price;
    private String description;
    private long categoryId;
    
}

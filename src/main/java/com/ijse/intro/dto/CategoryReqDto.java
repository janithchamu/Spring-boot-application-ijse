package com.ijse.intro.dto;

import java.util.List;

import com.ijse.intro.entity.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryReqDto {
    private String name;
    private List<Product> products;
}

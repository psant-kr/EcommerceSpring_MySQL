package org.example.ecommercespring.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductWithCategoryDTO {

    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private String model;
    private Long id;
    private String title;
    private CategoryDTO category;
    private String brand;
    private boolean popular;
}

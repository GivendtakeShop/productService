package com.giventake.productcatalog.responseDTOs;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {

    private String id;
    private String name;
    private long price;
    private String type;
    private String description;
    private int quantity;
}

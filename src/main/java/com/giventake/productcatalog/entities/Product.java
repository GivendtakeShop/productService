package com.giventake.productcatalog.entities;

import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product extends BaseEntity{

    private String name;
    private long price;

    @Enumerated(EnumType.STRING)
    private ProductType type;

    private String description="hello";

    private int quantity;

}

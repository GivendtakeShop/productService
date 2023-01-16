package com.giventake.productcatalog.requestDTOs;

import com.giventake.productcatalog.entities.ProductType;
import com.giventake.productcatalog.utilities.Assert;
import com.giventake.productcatalog.utilities.Validatable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Enumerated;

@Getter
@Setter
public class ProductRequestDTO implements Validatable {

    private String name;
    private long price;

    private ProductType type;
    private String description;
    private int quantity;

    @Override
    public void validate() {

        Assert.assertNotEmpty(name);

        Assert.assertMinValue(price, 0);

        Assert.assertNotEmpty(description);

        Assert.assertMinValue(quantity, 0);
    }
}

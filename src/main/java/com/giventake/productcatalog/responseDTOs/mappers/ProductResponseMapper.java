package com.giventake.productcatalog.responseDTOs.mappers;

import com.giventake.productcatalog.entities.Product;
import com.giventake.productcatalog.responseDTOs.ProductResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductResponseMapper {

    public ProductResponseDTO productToProductResponseDTO(Product product);

}

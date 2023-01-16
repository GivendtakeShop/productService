package com.giventake.productcatalog.requestDTOs.mappers;


import com.giventake.productcatalog.entities.Product;
import com.giventake.productcatalog.requestDTOs.ProductRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductRequestMapper {

    Product productRequestDTOToProduct(ProductRequestDTO productRequestDTO);
}

package com.giventake.productcatalog.responseDTOs.mappers;

import com.giventake.productcatalog.entities.File;
import com.giventake.productcatalog.entities.Product;
import com.giventake.productcatalog.responseDTOs.ProductResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ProductResponseMapper {

    @Mapping(source = "cover", target = "coverId", qualifiedByName = "toCoverId")
    public ProductResponseDTO productToProductResponseDTO(Product product);

    @Named("toCoverId")
    public static String toCoverId(File cover){
        if(cover == null) return null;
        return cover.getId();
    }

}

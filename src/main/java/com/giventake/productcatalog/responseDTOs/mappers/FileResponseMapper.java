package com.giventake.productcatalog.responseDTOs.mappers;

import com.giventake.productcatalog.entities.File;
import com.giventake.productcatalog.responseDTOs.FileResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileResponseMapper {

    public FileResponseDTO fileToFileResponseDTO(File file);
}

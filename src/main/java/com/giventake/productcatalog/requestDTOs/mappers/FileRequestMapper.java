package com.giventake.productcatalog.requestDTOs.mappers;

import com.giventake.productcatalog.entities.File;
import com.giventake.productcatalog.requestDTOs.FileRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileRequestMapper {
    File fileRequestDTOToFile(FileRequestDTO fileRequestDTO);
}

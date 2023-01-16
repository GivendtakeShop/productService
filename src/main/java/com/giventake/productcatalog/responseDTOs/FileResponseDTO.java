package com.giventake.productcatalog.responseDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FileResponseDTO {

    private String name;
    private String url;
    private String type;
    private long size;
}

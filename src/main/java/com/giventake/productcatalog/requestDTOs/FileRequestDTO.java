package com.giventake.productcatalog.requestDTOs;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FileRequestDTO {

    private String name;

    private String type;

    private byte[] data;

}

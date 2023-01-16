package com.giventake.productcatalog.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Lob;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class File extends BaseEntity{

    private String name;

    private String type;

    @Lob
    private byte[] data;

}

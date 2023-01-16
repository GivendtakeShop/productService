package com.giventake.productcatalog.repositories;

import com.giventake.productcatalog.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FileRepository extends JpaRepository<File, String> {

}

package com.giventake.productcatalog.services.file;

import com.giventake.productcatalog.entities.File;
import com.giventake.productcatalog.entities.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

public interface FileService {

    public File addFile(MultipartFile file, String productId) throws IOException;

    public File getFile(String id);

    public Stream<File> getAllFiles();

//    boolean deleteFile(String id);
}

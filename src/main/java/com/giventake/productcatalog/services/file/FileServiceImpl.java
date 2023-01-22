package com.giventake.productcatalog.services.file;


import com.giventake.productcatalog.entities.File;
import com.giventake.productcatalog.entities.Product;
import com.giventake.productcatalog.exceptions.BusinessException;
import com.giventake.productcatalog.repositories.FileRepository;
import com.giventake.productcatalog.repositories.ProductRepository;
import com.giventake.productcatalog.requestDTOs.FileRequestDTO;
import com.giventake.productcatalog.requestDTOs.mappers.FileRequestMapper;
import com.giventake.productcatalog.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.stream.Stream;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private FileRequestMapper fileRequestMapper;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public File addFile(MultipartFile newFile, String productId) throws IOException {

        Product product = productService.getProduct(productId);
        String fileName = StringUtils.cleanPath(newFile.getOriginalFilename());
        FileRequestDTO file = new FileRequestDTO(fileName, newFile.getContentType(), newFile.getBytes());

        File cover = fileRequestMapper.fileRequestDTOToFile(file);
        fileRepository.save(cover);

        product.setCover(cover);
        productRepository.save(product);
        return cover;

    }

    @Override
    public File getFile(String id) {
        return fileRepository.findById(id).get();
    }

    @Override
    public Stream<File> getAllFiles() {
        return fileRepository.findAll().stream();
    }

}

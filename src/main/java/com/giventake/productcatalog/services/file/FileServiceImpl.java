package com.giventake.productcatalog.services.file;


import com.giventake.productcatalog.entities.File;
import com.giventake.productcatalog.exceptions.BusinessException;
import com.giventake.productcatalog.repositories.FileRepository;
import com.giventake.productcatalog.requestDTOs.FileRequestDTO;
import com.giventake.productcatalog.requestDTOs.mappers.FileRequestMapper;
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

    @Override
    public File addFile(MultipartFile newFile) throws IOException {

        String fileName = StringUtils.cleanPath(newFile.getOriginalFilename());
        FileRequestDTO file = new FileRequestDTO(fileName, newFile.getContentType(), newFile.getBytes());

        return fileRepository.save(fileRequestMapper.fileRequestDTOToFile(file));

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

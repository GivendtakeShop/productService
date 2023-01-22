package com.giventake.productcatalog.controllers;


import com.giventake.productcatalog.responseDTOs.FileResponseDTO;
import com.giventake.productcatalog.responseDTOs.mappers.FileResponseMapper;
import com.giventake.productcatalog.services.file.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.giventake.productcatalog.constants.PathConstant.*;

@RestController
@RequestMapping(V1+FILE)
@RequiredArgsConstructor
public class FileController {

    @Autowired
    private FileService fileService;
    private final FileResponseMapper fileResponseMapper;

    @PostMapping
    public FileResponseDTO addFile(@RequestBody MultipartFile file, @RequestParam String productId) throws IOException {
        return fileResponseMapper
                .fileToFileResponseDTO(fileService.addFile(file,productId));
    }

    @GetMapping
    public List<FileResponseDTO> getAllFiles() {
        return fileService.getAllFiles()
                 .map(fileResponseMapper::fileToFileResponseDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public FileResponseDTO getFile(@PathVariable String id) {
        return fileResponseMapper
                .fileToFileResponseDTO(fileService.getFile(id));
    }

//    @DeleteMapping("/{id}")
//    public boolean deleteFile(@PathVariable String id){
//        return  fileService.deleteFile(id);
//    }


}

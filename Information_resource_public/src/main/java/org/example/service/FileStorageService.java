package org.example.service;

import org.example.model.FileStorage;
import org.example.repository.FileStorageRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

//import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class FileStorageService {

    @Value("${file.upload.dir}")
    private String uploadDir;

    private final FileStorageRepository fileStorageRepository;

    public FileStorageService(FileStorageRepository fileStorageRepository) {
        this.fileStorageRepository = fileStorageRepository;
    }

    public FileStorage uploadFile(MultipartFile file, Integer uploaderId) throws IOException {
        String fileName = file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir, fileName);
        Files.createDirectories(filePath.getParent());
        Files.write(filePath, file.getBytes());

        FileStorage fileStorage = new FileStorage();
        fileStorage.setFileName(fileName);
        fileStorage.setFilePath(filePath.toString());
        fileStorage.setUploaderId(uploaderId);
        return fileStorageRepository.save(fileStorage);
    }

    public byte[] downloadFile(Integer fileId) throws IOException {
        Optional<FileStorage> optionalFile = fileStorageRepository.findById(fileId);
        if (optionalFile.isPresent()) {
            Path filePath = Paths.get(optionalFile.get().getFilePath());
            return Files.readAllBytes(filePath);
        }
        throw new IOException("File not found");
    }

    public void deleteFile(Integer fileId) throws IOException {
        Optional<FileStorage> optionalFile = fileStorageRepository.findById(fileId);
        if (optionalFile.isPresent()) {
            Path filePath = Paths.get(optionalFile.get().getFilePath());
            Files.deleteIfExists(filePath);
            fileStorageRepository.deleteById(fileId);
        } else {
            throw new IOException("File not found");
        }
    }
}

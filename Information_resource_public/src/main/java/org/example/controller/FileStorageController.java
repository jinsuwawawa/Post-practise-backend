package org.example.controller;

import org.example.model.FileStorage;
import org.example.service.FileStorageService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/file-storage")
public class FileStorageController {

    private final FileStorageService fileStorageService;

    public FileStorageController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<FileStorage> uploadFile(@RequestParam("file") MultipartFile file,
                                                  @RequestParam("uploader_id") Integer uploaderId) {
        try {
            FileStorage fileStorage = fileStorageService.uploadFile(file, uploaderId);
            return new ResponseEntity<>(fileStorage, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Integer id) {
        try {
            byte[] fileData = fileStorageService.downloadFile(id);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"file\"")
                    .body(fileData);
        } catch (IOException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFile(@PathVariable Integer id) {
        try {
            fileStorageService.deleteFile(id);
            return new ResponseEntity<>("File deleted successfully", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // 获取所有文件
    @GetMapping("/list")
    public ResponseEntity<List<FileStorage>> listAllFiles() {
        List<FileStorage> fileList = fileStorageService.getAllFiles();
        if (fileList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(fileList, HttpStatus.OK);
    }
}

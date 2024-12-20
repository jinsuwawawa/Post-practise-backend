package org.example.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "file_storage")
public class FileStorage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer file_id;

    @Column(nullable = false, length = 255)
    private String file_name;

    @Column(nullable = false, length = 255)
    private String file_path;

    @Column
    private Integer uploader_id;

    @Column(nullable = false)
    private LocalDateTime uploaded_at = LocalDateTime.now();

    // Getter and Setter for fileId
    public Integer getFile_id() {
        return file_id;
    }

    public void setFile_id(Integer file_id) {
        this.file_id = file_id;
    }

    // Getter and Setter for fileName
    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    // Getter and Setter for filePath
    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    // Getter and Setter for uploaderId
    public Integer getUploader_id() {
        return uploader_id;
    }

    public void setUploader_id(Integer uploader_id) {
        this.uploader_id = uploader_id;
    }

    // Getter and Setter for uploadedAt
    public LocalDateTime getUploaded_at() {
        return uploaded_at;
    }

    public void setUploaded_at(LocalDateTime uploaded_at) {
        this.uploaded_at = uploaded_at;
    }
}

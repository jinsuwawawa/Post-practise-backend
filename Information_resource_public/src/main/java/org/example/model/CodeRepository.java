package org.example.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "code_repository")
public class CodeRepository {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int repoId;

    @Column(nullable = false, length = 100)
    private String repo_name;

    @Column(nullable = false, length = 255)
    private String repo_url;

    @Column()
    private int created_by;

    @Column()
    private Timestamp created_at;

    public String getRepo_name() {
        return repo_name;
    }

    public void setRepo_name(String repo_name) {
        this.repo_name = repo_name;
    }

    public String getRepo_url() {
        return repo_url;
    }

    public void setRepo_url(String repo_url) {
        this.repo_url = repo_url;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public int getRepoId() {
        return repoId;
    }

    public void setRepoId(int repoId) {
        this.repoId = repoId;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}



//@Entity
//@Table(name = "code_repositories",
//        indexes = {@Index(name = "created_by", columnList = "created_by")})
//public class CodeRepository {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "repo_id")
//    private Integer repoId;  // 仓库ID，自增主键
//
//    @Column(name = "repo_name", nullable = false, length = 100)
//    private String repoName;  // 仓库名称，不为空
//
//    @Column(name = "repo_url", nullable = false, length = 255)
//    private String repoUrl;  // 仓库URL，不为空
//
//    @ManyToOne
//    @JoinColumn(name = "created_by", referencedColumnName = "user_id")
//    private Integer createdBy;  // 创建者用户id, 外键关联至用户表
//
//    @Column(name = "created_at", updatable = false)
//    private LocalDateTime createdAt;  // 记录创建时间
//
//    // Getters and Setters
//
//    public Integer getRepoId() {
//        return repoId;
//    }
//
//    public void setRepoId(Integer repoId) {
//        this.repoId = repoId;
//    }
//
//    public String getRepoName() {
//        return repoName;
//    }
//
//    public void setRepoName(String repoName) {
//        this.repoName = repoName;
//    }
//
//    public String getRepoUrl() {
//        return repoUrl;
//    }
//
//    public void setRepoUrl(String repoUrl) {
//        this.repoUrl = repoUrl;
//    }
//
//    public Integer getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(Integer createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//}

package org.example.service;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.example.model.CodeRepository;
import org.example.repository.CodeRepositoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class GitService {

    @Autowired
    private CodeRepositoryRepository repository;

    public CodeRepository createRepository(String repoName, Integer userId) throws GitAPIException, IOException {
        // 创建本地仓库路径
        File repoDir = new File("repositories/" + repoName);

        // 使用 JGit 创建仓库
        Git git = Git.init().setDirectory(repoDir).call();

        // 保存仓库信息到数据库
        CodeRepository codeRepo = new CodeRepository();
        codeRepo.setRepo_name(repoName);
        codeRepo.setRepo_url(repoDir.getAbsolutePath());
        codeRepo.setCreated_by(userId);  // userId 可以从会话中获取

        return repository.save(codeRepo);
    }

    public Git cloneRepository(String repoUrl, String cloneDir) throws GitAPIException {
        // 克隆仓库
        return Git.cloneRepository()
                .setURI(repoUrl)
                .setDirectory(new File(cloneDir))
                .call();
    }

    public CodeRepository getRepositoryById(int repoId) {
        return repository.findByRepoId(repoId);
    }
}

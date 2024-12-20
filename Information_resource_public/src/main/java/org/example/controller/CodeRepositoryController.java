package org.example.controller;

import org.example.service.GitService;
import org.example.model.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/repos")
public class CodeRepositoryController {

    @Autowired
    private GitService gitService;

    // 用户组长创建仓库
    @PostMapping("/create")
    public CodeRepository createRepository(@RequestParam String repo_name, @RequestParam Integer user_id) {
        try {
            return gitService.createRepository(repo_name, user_id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 用户查看代码仓库
    @GetMapping("/{repoId}")
    public CodeRepository getRepository(@PathVariable int repoId) {
        return gitService.getRepositoryById(repoId);
    }
}

package org.example.repository;

import org.example.model.CodeRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeRepositoryRepository extends JpaRepository<CodeRepository, Integer> {
    CodeRepository findByRepoId(int repoId);
    // 可以添加根据条件查询的自定义方法
}

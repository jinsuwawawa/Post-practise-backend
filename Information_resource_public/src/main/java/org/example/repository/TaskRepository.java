package org.example.repository;

import org.example.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 数据访问层接口，继承 JpaRepository，用于与数据库交互
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // JpaRepository 已经提供常用的数据库操作方法，例如 save(), findAll(), deleteById() 等
}


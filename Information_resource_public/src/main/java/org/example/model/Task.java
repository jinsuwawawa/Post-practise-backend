package org.example.model;

import javax.persistence.*;

// 任务实体类，映射到数据库中的 "tasks" 表
@Entity
@Table(name = "tasks")
public class Task {

    // 主键，自动生成值
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 任务名称，不能为空，最长100字符
    @Column(nullable = false, length = 100)
    private String name;

    // 任务描述，最长500字符，可为空
    @Column(length = 500)
    private String description;

    // 任务状态，枚举类型（todo, IN_PROGRESS, done）
    @Enumerated(EnumType.STRING)
    private Status status;

    // 创建任务的用户 ID，不能为空
    @Column(nullable = false)
    private Long creatorId;

    // Getters 和 Setters，提供对象属性的访问和修改方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }
}

// 枚举类，表示任务的状态
enum Status {
    todo,           // 待办
    in_progress,    // 进行中
    done            // 已完成
}

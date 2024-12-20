package org.example.model;

import javax.persistence.*;

// 任务实体类，映射到数据库中的 "tasks" 表
@Entity
@Table(name = "tasks")
public class Task {

    // 主键，自动生成值
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long task_id;

    // 任务名称，不能为空，最长100字符
    @Column(nullable = false, length = 100)
    private String task_name;

    // 任务描述，最长500字符，可为空
    @Column(length = 500)
    private String description;

    // 任务状态，枚举类型（todo, IN_PROGRESS, done）
    @Enumerated(EnumType.STRING)
    private Status status;

    // 创建任务的用户 ID，不能为空
    @Column(nullable = false)
    private Long creator_id;

    // Getters 和 Setters，提供对象属性的访问和修改方法
    public Long getTask_id() {
        return task_id;
    }

    public void setTask_id(Long task_id) {
        this.task_id = task_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
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

    public Long getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(Long creator_id) {
        this.creator_id = creator_id;
    }
}

// 枚举类，表示任务的状态
enum Status {
    todo,           // 待办
    in_progress,    // 进行中
    done            // 已完成
}

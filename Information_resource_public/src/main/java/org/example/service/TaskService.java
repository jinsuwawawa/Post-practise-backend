package org.example.service;

import org.example.model.Task;
import org.example.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// 服务层，用于实现业务逻辑
@Service
public class TaskService {

    // 依赖任务数据访问层
    private final TaskRepository taskRepository;

    // 构造函数注入 TaskRepository
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // 获取所有任务
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // 创建新任务
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // 更新现有任务
    public Task updateTask(Long id, Task updatedTask) {
        // 根据 ID 查找任务，若不存在抛出异常
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        // 更新任务属性
        task.setName(updatedTask.getName());
        task.setDescription(updatedTask.getDescription());
        task.setStatus(updatedTask.getStatus());
        // 保存更新后的任务
        return taskRepository.save(task);
    }

    // 根据 ID 删除任务
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}

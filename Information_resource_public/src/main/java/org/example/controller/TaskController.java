package org.example.controller;

import org.example.model.Task;
import org.example.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 控制层，负责处理客户端请求并返回响应
@RestController
@RequestMapping("/tasks")
public class TaskController {

    // 依赖任务服务层
    private final TaskService taskService;

    // 构造函数注入 TaskService
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // 获取所有任务
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // 创建新任务
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    // 更新现有任务
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    // 删除任务
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}

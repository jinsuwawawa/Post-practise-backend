package org.example.controller;

import org.example.model.Resource;
import org.example.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/res")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    // 获取所有资源
    @GetMapping
    public List<Resource> getAllResources() {
        return resourceService.getAllResources();
    }

    // 发布资源
    @PostMapping("/post")
    public Resource createResource(@RequestBody Resource resource) {
        return resourceService.saveResource(resource);
    }

    // 删除资源
    @DeleteMapping("/manage/{id}")
    public void deleteResource(@PathVariable("id") Integer resource_id) {
        resourceService.deleteResource(resource_id);
    }
}
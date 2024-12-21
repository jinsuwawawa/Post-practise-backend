package org.example.service;

import org.example.model.Resource;
import org.example.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    public Resource saveResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    public void deleteResource(Integer resourceId) {
        if (!resourceRepository.existsById(resourceId)) {
            throw new EntityNotFoundException("Resource not found with id: " + resourceId);
        }
        resourceRepository.deleteById(resourceId);
    }
}
package com.piatsevich.service.impl;

import com.piatsevich.model.Project;
import com.piatsevich.repository.ProjectRepository;
import com.piatsevich.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project getById(Integer id) {
        return projectRepository.getById(id);
    }

    @Override
    public Project create(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.getAll();
    }

    @Override
    public Project update(Project project) {
        return projectRepository.update(project);
    }

    @Override
    public void delete(Integer id) {
        projectRepository.deleteById(id);
    }
}

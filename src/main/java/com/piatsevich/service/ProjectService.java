package com.piatsevich.service;

import com.piatsevich.model.Project;

import java.util.List;

public interface ProjectService {
    public Project getById(Integer id);

    public Project create(Project project);

    public List<Project> getAll();

    public Project update(Project project);

    public void delete(Integer id);
}

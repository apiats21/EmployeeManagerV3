package com.piatsevich.service;

import com.piatsevich.model.Department;

import java.util.List;

public interface DepartmentService {
    public Department getById(Integer id);

    public Department create(Department department);

    public List<Department> getAll();

    public Department update(Department department);

    public void delete(Integer id);

}

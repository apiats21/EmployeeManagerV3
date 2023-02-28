package com.piatsevich.service.impl;

import com.piatsevich.model.Department;
import com.piatsevich.repository.DepartmentRepository;
import com.piatsevich.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department getById(Integer id) {
        return departmentRepository.getById(id);
    }

    @Override
    public Department create(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.getAll();
    }

    @Override
    public Department update(Department department) {
        return departmentRepository.update(department);
    }

    @Override
    public void delete(Integer id) {
        departmentRepository.deleteById(id);
    }
}
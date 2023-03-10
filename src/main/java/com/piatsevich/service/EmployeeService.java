package com.piatsevich.service;

import com.piatsevich.model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee getById(Integer id);

    public Employee create(Employee employee);

    public List<Employee> getAll();

    public Employee update(Employee employee);

    public void delete(Integer id);
}

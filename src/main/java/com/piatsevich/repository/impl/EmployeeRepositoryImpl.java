package com.piatsevich.repository.impl;

import com.piatsevich.model.Employee;
import com.piatsevich.repository.EmployeeRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Employee getById(Integer integer) {
        return null;
    }

    @Override
    public Employee save(Employee employee) {
        return null;
    }

    @Override
    public List<Employee> getAll() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = currentSession.createQuery("from Employee");

        List<Employee> employees = theQuery.list();

        return employees;
    }

    @Override
    public Employee update(Employee employee) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }
}
package com.piatsevich.repository.impl;

import com.piatsevich.model.Department;
import com.piatsevich.repository.DepartmentRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class DepartmentRepositoryImpl implements DepartmentRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public DepartmentRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Department getById(Integer id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Department department = (Department) currentSession.get(Department.class, id);

        return department;
    }

    @Override
    public Department save(Department department) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(department);

        return department;
    }

    @Override
    public List<Department> getAll() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = currentSession.createQuery("from Department");

        List<Department> departments = theQuery.list();

        return departments;
    }

    @Override
    public Department update(Department department) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query query =
                currentSession.createQuery("delete from Department where id=:departmentId");
        query.setParameter("departmentId", id);

        query.executeUpdate();
    }
}


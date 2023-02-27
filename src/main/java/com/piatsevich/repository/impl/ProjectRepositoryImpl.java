package com.piatsevich.repository.impl;

import com.piatsevich.model.Employee;
import com.piatsevich.model.Project;
import com.piatsevich.repository.EmployeeRepository;
import com.piatsevich.repository.ProjectRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProjectRepositoryImpl implements ProjectRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Project getById(Integer id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Project project = (Project) currentSession.get(Project.class, id);

        return project;
    }

    @Override
    public Project save(Project project) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.save(project);

        return project;
    }

    @Override
    public List<Project> getAll() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = currentSession.createQuery("from Project");

        List<Project> project = theQuery.list();

        return project;
    }

    @Override
    public Project update(Project project) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query query =
                currentSession.createQuery("delete from Project where id=:projectId");
        query.setParameter("projectId", id);

        query.executeUpdate();
    }
}

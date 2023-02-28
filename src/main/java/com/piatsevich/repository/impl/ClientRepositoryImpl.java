package com.piatsevich.repository.impl;

import com.piatsevich.model.Client;
import com.piatsevich.repository.ClientRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ClientRepositoryImpl implements ClientRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Client getById(Integer id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Client client = (Client) currentSession.get(Client.class, id);

        return client;
    }

    @Override
    public Client save(Client client) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.save(client);

        return client;
    }

    @Override
    public List<Client> getAll() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = currentSession.createQuery("from Client");

        List<Client> clients = theQuery.list();

        return clients;
    }

    @Override
    public Client update(Client client) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query query =
                currentSession.createQuery("delete from Client where id=:clientId");
        query.setParameter("clientId", id);

        query.executeUpdate();
    }
}

package com.piatsevich.service;

import com.piatsevich.model.Client;

import java.util.List;

public interface ClientService {
    public Client getById(Integer id);

    public Client create(Client client);

    public List<Client> getAll();

    public Client update(Client client);

    public void delete(Integer id);
}

package com.piatsevich.service.impl;

import com.piatsevich.model.Client;
import com.piatsevich.model.Employee;
import com.piatsevich.repository.ClientRepository;
import com.piatsevich.repository.EmployeeRepository;
import com.piatsevich.service.ClientService;
import com.piatsevich.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client getById(Integer id) {
        return clientRepository.getById(id);
    }

    @Override
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    @Override
    public Client update(Client client) {
        return clientRepository.update(client);
    }

    @Override
    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }
}

package com.usa.doctorapp.service;

import com.usa.doctorapp.model.Client;
import com.usa.doctorapp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getById(Integer id){
        return clientRepository.getById(id);
    }

    public Client save(Client client){
        if(client.getIdClient()==null){
            return clientRepository.save(client);
        } else {
            Optional<Client> optionalClient=clientRepository.getById(client.getIdClient());
            if(optionalClient.isEmpty()){
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }
}

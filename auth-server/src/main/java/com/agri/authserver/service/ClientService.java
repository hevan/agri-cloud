package com.agri.authserver.service;

import com.agri.authserver.domain.Client;
import com.agri.authserver.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public void delete(String clientId){
       Client client =  this.clientRepository.findByClientId(clientId).get();
       if(null != client){
           this.clientRepository.delete(client);
       }
    }

}

package com.agri.authserver.repository;

import com.agri.authserver.domain.Client;
import org.springframework.data.repository.CrudRepository;


public interface ClientRepository extends CrudRepository<Client, String> {
    Client findByClientId(String clientId);
}

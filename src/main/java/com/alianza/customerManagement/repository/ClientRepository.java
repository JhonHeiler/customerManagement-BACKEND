package com.alianza.customerManagement.repository;


import com.alianza.customerManagement.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findBySharedKey(String sharedKey);
}
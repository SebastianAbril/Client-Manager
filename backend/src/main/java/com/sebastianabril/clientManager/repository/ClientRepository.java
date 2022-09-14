package com.sebastianabril.clientManager.repository;

import com.sebastianabril.clientManager.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    public List<Client> findByOrderByIdAsc();
}

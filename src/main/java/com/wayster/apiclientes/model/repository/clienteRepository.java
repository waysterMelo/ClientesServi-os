package com.wayster.apiclientes.model.repository;

import com.wayster.apiclientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface clienteRepository  extends JpaRepository<Cliente, Integer> {
}

package com.wayster.apiclientes.model.repository;

import com.wayster.apiclientes.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}

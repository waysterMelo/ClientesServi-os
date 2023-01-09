package com.wayster.apiclientes.rest;

import com.wayster.apiclientes.model.entity.Cliente;
import com.wayster.apiclientes.model.repository.clienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final clienteRepository clienteRepository;

    /* quando sou obrigado a usar a dependencia injeto via construtor */
    @Autowired
    public ClienteController(clienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }
}

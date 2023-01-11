package com.wayster.apiclientes.rest;

import com.wayster.apiclientes.model.entity.Cliente;
import com.wayster.apiclientes.model.repository.clienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final clienteRepository clienteRepository;

    /* quando sou obrigado a usar a dependencia injeto via construtor */
    @Autowired
    public ClienteController(clienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /* salva cliente */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody @Valid Cliente cliente){
        return clienteRepository.save(cliente);
    }

    /* obtem cliente por id */
    @GetMapping("{id}")
    public Cliente acharPorId(@PathVariable Integer id){
        return clienteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    /* deletar cliente*/
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        clienteRepository.findById(id).map(cliente -> { clienteRepository.delete(cliente); return Void.TYPE; })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @RequestBody @Valid Cliente clienteAtualizado){
        clienteRepository.findById(id)
                .map(cliente -> {
                    clienteAtualizado.setId(cliente.getId());
                    clienteAtualizado.setCpf(cliente.getCpf());
                    return clienteRepository.save(clienteAtualizado);
                }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }


}

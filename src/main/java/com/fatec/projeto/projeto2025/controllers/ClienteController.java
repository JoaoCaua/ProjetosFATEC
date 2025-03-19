package com.fatec.projeto.projeto2025.controllers;
// import main.java.com.fatec.projeto.projeto2025.controllers.Cliente;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
// import java.util.logging.Logger;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController{
    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class.getName());
    private final List<Cliente> clientes = new ArrayList<>();
    private Long idCount = 1L;

    // ClienteController (ExercicioController exercicioController){
        // this.exercicioController = exercicioController;
    // }

    // http://localhost:8080/api/cliente/criarCliente => POST
    @PostMapping("/criarCliente")
    public ResponseEntity<Cliente> CriarCliente(@RequestBody Cliente cliente){
        cliente.setId(idCount++);
        clientes.add(cliente);
        logger.info("Recebido JSON: Nome={}, Idade={}", cliente.getNome(), cliente.getIdade());
        // return "O cliente "+cliente.getNome()+" de idade"+cliente.getIdade()+" foi criado";
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @GetMapping("/listarClientes")
    public List<Cliente> ListarClientes(){
        return clientes;
    }

    @DeleteMapping("/deletarCliente/{id}")
    public String DeletarClientes(@PathVariable Long id){
        for( Cliente cliente: clientes){
            if(cliente.getId().equals(id)){
                clientes.remove(cliente);
                return "Cliente removido com sucesso!";
            }
        }
        return "Não existe cliente com id: " + id;
    }
}
package com.fatec.projeto.projeto2025.controllers;
import com.fatec.projeto.projeto2025.domain.cliente.ClienteService;
import com.fatec.projeto.projeto2025.entities.Cliente;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController{
    @Autowired
    private ClienteService clienteService;

    private final ExercicioController exercicioController;
    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class.getName());
    private final List<Cliente> clientes = new ArrayList<>();
    private Long idCount = 1L;

    ClienteController (ExercicioController exercicioController){
        this.exercicioController = exercicioController;
    }

    // http://localhost:8080/api/cliente/criarCliente => POST
    @PostMapping("/criarCliente")
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente){
        Cliente novoCliente = clienteService.criarCliente(cliente);
        // cliente.setId(idCount++);
        // clientes.add(cliente);
        logger.info("Recebido JSON: Nome={}, Idade={}, Endereco={}", novoCliente.getNome(), novoCliente.getIdade(), novoCliente.getEndereco());
        // return "O cliente "+cliente.getNome()+ " de idade "+cliente.getIdade()+" foi criado";
        // return new ResponseEntity<>(cliente, HttpStatus.OK);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

    // http://localhost:8080/api/cliente/listarClientes => GET
    @GetMapping("/listarClientes")
    public List<Cliente> ListarClientes(){
        // return clientes;
        return clienteService.listarClientes();
    }

    // http://localhost:8080/api/cliente/deletarCliente/{id} => DELETE
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

    // http://localhost:8080/api/cliente/atualizarCliente/{id} => PUT
    @PutMapping("/atualizarCliente/{id}")
    public ResponseEntity<String> atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado){
        for( Cliente cliente: clientes){
            if(cliente.getId().equals(id)){
                cliente.setNome(clienteAtualizado.getNome());
                cliente.setIdade(clienteAtualizado.getIdade());
                cliente.setEndereco(clienteAtualizado.getEndereco());

                logger.info("Cliente atualizado: Id={}, Nome={}, Idade={}, Endereço={}", cliente.getId(), cliente.getNome(), cliente.getIdade(), cliente.getEndereco());
                return ResponseEntity.ok("Cliente atualizado com sucesso!");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente com ID " + id + " não encontrado.");
    }

    // http://localhost:8080/api/cliente/buscarCliente/{id} => GET
    @GetMapping("/buscarCliente/{id}")
    public ResponseEntity<?> buscarClientePorId(@PathVariable Long id){
        Optional<Cliente> cliente = clienteService.buscarClientePorId(id);
        return cliente.<ResponseEntity<?>>map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente com ID: " + id + " não encontrado."));
        /*
        for(Cliente cliente : clientes){
            if(cliente.getId().equals(id)){
                return ResponseEntity.ok(cliente);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente com ID " + id + " não encontrado.");
        */
    }

    /*
    {
        "id": 0,
        "nome": "string",
        "idade": 0,
        "endereco": "string"
    }
    */ 
}
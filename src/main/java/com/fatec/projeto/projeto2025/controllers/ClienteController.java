package com.fatec.projeto.projeto2025.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController{
    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class.getName())
;
    private final List<Cliente> clientes = new ArrayList<>();
    private Long idCount = 1L;

    http://localhost:8080/api/cliente/criarCliente => POST
    @PostMapping("/criarCliente")
    public String CriarCliente(@RequestBody Cliente cliente){
        cliente.setId(idCount++);
        clientes.add(cliente);

        logger.info(format:"Recebido JSON: Nome={}, Idade={}", cliente.getNome(), cliente.getIdade());
        return "O cliente "+cliente.getNome()+" de idade"+cliente.getIdade()+" foi criado";
    }

    @GetMapping("path")
    public List<Cliente> ListarClientes(){
        return clientes;
    }
}
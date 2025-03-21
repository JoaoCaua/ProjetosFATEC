package com.fatec.projeto.projeto2025.domain.cliente;
import com.fatec.projeto.projeto2025.entities.Cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
// import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }
/*/
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente){
        return clienteRepository.saveAll(ResponseEntity);
    }
*/
    /*/ sem @Autowired:
    private final ClienteRepository cRepository; 
    public ClienteService(ClienteRepository cRepository){
        this.cRepository = cRepository;
    }
    */
}

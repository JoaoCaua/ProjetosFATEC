package com.fatec.projeto.projeto2025.domain.cliente;
import com.fatec.projeto.projeto2025.entities.Cliente;

import java.util.List;
import java.util.Optional;

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

    /*/ sem @Autowired:
    private final ClienteRepository cRepository; 
    public ClienteService(ClienteRepository cRepository){
        this.cRepository = cRepository;
    }
    */

    public Cliente criarCliente(Cliente cliente){
        cliente.setId(null);
        // return clienteRepository.save(cliente);
        Cliente clienteCriado = clienteRepository.save(cliente);
        return clienteCriado;
    }

    public boolean atualizarCliente(Long id, Cliente clienteAtualizado){
        Optional<Cliente> clienteOptional = buscarClientePorId(id);
        if(clienteOptional.isPresent()){
            Cliente cliente = clienteOptional.get();
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setIdade(clienteAtualizado.getIdade());
            cliente.setEndereco(clienteAtualizado.getEndereco());
            clienteRepository.save(cliente);
            return true;
        }
        return false;
    }
    
    public boolean deletarCliente(Long id){
        if(clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public Optional<Cliente> buscarClientePorId(Long id){
        return clienteRepository.findById(id);
    }
}

package com.fatec.projeto.projeto2025.domain.cliente;
import com.fatec.projeto.projeto2025.entities.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}

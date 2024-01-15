package com.banco.backend.repository;

import com.banco.backend.models.ContaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<ContaModel, Integer> {
    
}

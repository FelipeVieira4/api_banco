package com.banco.backend.repository;

import com.banco.backend.models.ClienteModel;
import com.banco.backend.models.ContaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaRepository extends JpaRepository<ContaModel, Integer> {
    public Optional<ContaModel> findById(int id);
}

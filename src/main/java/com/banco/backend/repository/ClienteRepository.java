package com.banco.backend.repository;

import com.banco.backend.models.ClienteModel;
import com.banco.backend.models.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {
    public Optional<ClienteModel> findById(int id);
    public Iterable<ClienteModel> findByNome(String nome);
}

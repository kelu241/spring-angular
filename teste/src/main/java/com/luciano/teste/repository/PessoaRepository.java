package com.luciano.teste.repository;

import com.luciano.teste.entidade.Pessoa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findById(Long id);

    void deleteById(Long id);

    

}

package com.luciano.teste.controller;

import org.springframework.web.bind.annotation.RestController;

import com.luciano.teste.entidade.Pessoa;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.luciano.teste.repository.PessoaRepository;

import java.util.List;

@RestController
public class Controller {

    private final PessoaRepository repository;
    public Controller(PessoaRepository repository){
        this.repository = repository;
    }

    @GetMapping("/ola")
    public ResponseEntity<List<Pessoa>> ola() {
        List<Pessoa> pessoas = repository.findAll();

        return ResponseEntity.ok(pessoas);
    }


    @PostMapping("/pessoa")
    public ResponseEntity<Pessoa>criarPessoa(@RequestBody Pessoa pessoa){
        Pessoa novaPessoa= repository.save(pessoa);
        return ResponseEntity.ok(novaPessoa);
    }
    

    @DeleteMapping("/pessoa/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/pessoa/{id}")
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa){
        Pessoa pessoaExistente = repository.findById(id).orElse(null);
        if (pessoaExistente != null){
            pessoaExistente.setNome(pessoa.getNome());
            repository.save(pessoaExistente);
        }
        return ResponseEntity.ok(pessoaExistente);
    }

}

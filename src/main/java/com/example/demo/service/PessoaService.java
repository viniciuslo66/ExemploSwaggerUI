package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pessoa;
import com.example.demo.model.PessoaDTO;
import com.example.demo.repository.PessoaRepository;

import jakarta.transaction.Transactional;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    public List<PessoaDTO> findAll() {
        List<Pessoa> result = repository.findAll();
        return result.stream().map(x -> new PessoaDTO(x)).toList();
    }

    @Transactional
    public Pessoa savePessoa(PessoaDTO dto) {
        Pessoa pessoa = converter(dto, null);
        return repository.save(pessoa);
    }

    // Método usado para converter uma DTO em uma Pessoa
    public Pessoa converter(PessoaDTO dto, Optional<Pessoa> optional) {
        Pessoa pessoa = Objects.nonNull(optional) ? optional.get() : new Pessoa();
        pessoa.setNome(dto.getNome());
        return pessoa;
    }
}

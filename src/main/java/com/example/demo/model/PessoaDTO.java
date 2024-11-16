package com.example.demo.model;

import lombok.Data;

@Data
public class PessoaDTO {

    private Long id;
    private String nome;

    public PessoaDTO(Pessoa pessoa) {
        id = pessoa.getId();
        nome = pessoa.getNome();
    }

}

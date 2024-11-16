package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pessoa;
import com.example.demo.model.PessoaDTO;
import com.example.demo.service.PessoaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    PessoaService service;

    @GetMapping()
    public List<PessoaDTO> findAll() {
        return service.findAll();
    }

    @PostMapping("post/pessoas")
    public ResponseEntity<?> savePessoa(@RequestBody PessoaDTO dto) {
        try {
            Pessoa pessoa = service.savePessoa(dto);
            return new ResponseEntity<>(pessoa, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

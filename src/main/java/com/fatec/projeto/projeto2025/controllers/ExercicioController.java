package com.fatec.projeto.projeto2025.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ExercicioController {

    @GetMapping("{nome}")
    public String HelloWorld(@PathVariable String nome){
        return nome;
    }
}
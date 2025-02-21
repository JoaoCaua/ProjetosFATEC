package com.fatec.projeto.projeto2025.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ExercicioController {

    @GetMapping("")
    public String HelloWorld(){
        return "hello";
    }
}
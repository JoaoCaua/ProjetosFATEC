package com.fatec.projeto.projeto2025.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ExercicioController {

    @GetMapping("{nome}")
    public String HelloWorld(@PathVariable String nome){
        return nome;
    }

    @GetMapping("/get-idade/{idade}")
    public String RetornaIdade(@PathVariable Integer idade){
        try{
            if(idade < 0){
                throw new NumberFormatException();
            }

            else if(idade < 12){
                return "Crianca";
            }

            else if(idade <= 18){
                return "Adolescente";
            }

            else if(idade <= 60){
                return "Adulto";
            }

            else{
                return "Idoso";
            }

        }catch(NumberFormatException e){
            return "idade invalida";
        }
    }

    @GetMapping("/get-numero/{numero}")
    public String RetornaNumero(@PathVariable Integer numero){
        try{
            if(numero < 0){
                throw new NumberFormatException();
            }

            else if(numero % 2 == 0){
                return "O número " + numero + " é par";
            }
            else{
                return "O número " + numero + " é ímpar";
            }
        }

        catch(NumberFormatException e){
            return "Número inválido";
        }
    }

    @GetMapping("/get-imc/{peso}/{altura}")
    public String RetornaImc(@PathVariable Double peso, @PathVariable Double altura){
        try{
            Double imc = peso / (altura*altura);
            if(imc < 0){
                throw new NumberFormatException();
            }

            else if(imc < 18.5){
                return "Abaixo do peso";
            }

            else if(imc >= 18.5 && imc <= 24.9){
                return "Peso normal";
            }

            else if(imc >= 25.0 && imc <= 29.9){
                return "Sobrepeso";
            }

            else if(imc >= 30.0 && imc <= 34.9){
                return "Obesidade grau 1";
            }

            else if(imc >= 35.0 && imc <= 39.9){
                return "Obesidade grau 2";
            }

            else{
                return "Obesidade grau 3";
            }
        }

        catch(NumberFormatException e){
            return "Dados inválidos";
        }
    }
}
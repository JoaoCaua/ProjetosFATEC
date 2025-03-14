package main.java.com.fatec.projeto.projeto2025.controllers;

public class Cliente {
    private Long id;
    private String nome;
    private Integer idade;
    private String endereco;

    public Cliente(Long id, String nome, Integer idade, String endereco){
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(){
        this.nome = nome;
    }

    public Integer getIdade(){
        return nome;
    }

    public void setIdade(){
        this.idade = idade;
    }

    public String getEndereco(){
        return endereco;
    }

    public void setEndereco(){
        this.endereco = endereco;
    }
}

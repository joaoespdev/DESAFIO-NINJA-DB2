package com.example.Naruto_DB.dto;

import java.util.Map;

public class PersonagemDto {
    private Long id;
    private String nome;
    private int idade;
    private String aldeia;
    private int chakra;
    private int vida;
    private Map<String, JutsuDto> jutsus;

    public PersonagemDto(Long id, String nome, int idade, String aldeia, int chakra, int vida, Map<String, JutsuDto> jutsus) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.aldeia = aldeia;
        this.chakra = chakra;
        this.vida = vida;
        this.jutsus = jutsus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getAldeia() {
        return aldeia;
    }

    public void setAldeia(String aldeia) {
        this.aldeia = aldeia;
    }

    public int getChakra() {
        return chakra;
    }

    public void setChakra(int chakra) {
        this.chakra = chakra;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public Map<String, JutsuDto> getJutsus() {
        return jutsus;
    }

    public void setJutsus(Map<String, JutsuDto> jutsus) {
        this.jutsus = jutsus;
    }

    public PersonagemDto() {
    }


}

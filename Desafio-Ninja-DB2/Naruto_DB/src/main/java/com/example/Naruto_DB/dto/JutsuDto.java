package com.example.Naruto_DB.dto;

public class JutsuDto {
    private Long id;
    private String nome;
    private int dano;
    private int consumoDeChakra;

    public JutsuDto(Long id, String nome, int dano, int consumoDeChakra) {
        this.id = id;
        this.nome = nome;
        this.dano = dano;
        this.consumoDeChakra = consumoDeChakra;
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

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getConsumoDeChakra() {
        return consumoDeChakra;
    }

    public void setConsumoDeChakra(int consumoDeChakra) {
        this.consumoDeChakra = consumoDeChakra;
    }
}

package com.example.Naruto_DB.entity;
import jakarta.persistence.*;

@Entity
public class Jutsu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private int dano;
    private int consumoDeChakra;

    @ManyToOne
    @JoinColumn(name = "personagem_id", nullable = false)
    private Personagem personagem;

    public Jutsu() {
    }

    public Jutsu(String nome, int dano, int consumoDeChakra) {
        if (dano < 0) {
            throw new IllegalArgumentException("O dano deve ser igual ou maior que zero.");
        }
        if (consumoDeChakra < 0) {
            throw new IllegalArgumentException("O consumo de chakra deve ser igual ou maior que zero.");
        }

        this.nome = nome;
        this.dano = dano;
        this.consumoDeChakra = consumoDeChakra;
    }

    public int getDano() {
        return dano;
    }

    public int getConsumoDeChakra() {
        return consumoDeChakra;
    }

    public String getNome() {
        return nome;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean usar(Personagem atacante, Personagem defensor) {
        if (atacante.getChakra() >= consumoDeChakra) {
            atacante.setChakra(atacante.getChakra() - consumoDeChakra);
            defensor.receberDano(dano);
            return true;
        } else {
            System.out.println(atacante.getNome() + " não possui chakra suficiente");
            return false;
        }
    }

}

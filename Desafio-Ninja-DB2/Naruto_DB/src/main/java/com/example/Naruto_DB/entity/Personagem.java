package com.example.Naruto_DB.entity;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

@Entity
public class Personagem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private int idade;
    private String aldeia;
    private int chakra;
    private int vida;

    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL, orphanRemoval = true)
    private Map<String, Jutsu> jutsus = new HashMap<>();

    public Personagem() {
        this.chakra = 100;
    }

    public Personagem(String nome, int idade, String aldeia, int vida) {
        this();
        this.nome = nome;
        this.idade = idade;
        this.aldeia = aldeia;
        this.vida = vida;
    }

    public boolean usarJutsu(String nomeJutsu, Personagem inimigo) {
        Jutsu jutsu = jutsus.get(nomeJutsu);

        if (jutsu == null) {
            System.out.println(nome + " não conhece o jutsu " + nomeJutsu + "!");
            return false;
        }

        if (chakra >= jutsu.getConsumoDeChakra()) {
            chakra -= jutsu.getConsumoDeChakra();
            inimigo.receberDano(jutsu.getDano());
            return true;
        } else {
            System.out.println(nome + " não tem chakra suficiente para usar " + nomeJutsu + "!");
            return false;
        }
    }

    public void adicionarNovoJutsu(String nomeJutsu, Jutsu jutsu) {
        jutsu.setPersonagem(this);
        jutsus.put(nomeJutsu, jutsu);
    }

    public void desviar(int dano) {
        if (Math.random() > 0.5) {
            System.out.println(nome + " desviou do ataque!");
        } else {
            receberDano(dano);
        }
    }

    public void receberDano(int dano) {
        vida = Math.max(vida - dano, 0);
        System.out.println(getNome() + " recebeu " + dano + " de dano e agora resta " + vida + " de vida.");
    }

    public boolean estaVivo() {
        return vida > 0;
    }


    public String getNome() {
        return nome;
    }

    public int getChakra() {
        return chakra;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setJutsus(Map<String, Jutsu> jutsus) {
        this.jutsus = jutsus;
    }

    public Map<String, Jutsu> getJutsus() {
        return new HashMap<>(jutsus);
    }


    public void setChakra(int chakra) {
        if (chakra < 0) {
            throw new IllegalArgumentException("Chakra não pode ser negativo.");
        }
        this.chakra = Math.min(chakra, 100);
    }

    public void aumentarChakra(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade a aumentar não pode ser negativa.");
        }
        setChakra(this.chakra + quantidade);
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Aldeia: " + aldeia);
        System.out.println("Vida: " + vida);
        System.out.println("Chakra: " + chakra);
        System.out.println("Jutsus: " + jutsus.keySet());
    }

}

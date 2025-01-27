package com.example.Naruto_DB;

import com.example.Naruto_DB.entity.Personagem;
import com.example.Naruto_DB.entity.Jutsu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonagemTest {
    private Personagem personagem;

    @BeforeEach
    void setUp() {
        personagem = new Personagem("Naruto Uzumaki", 17, "Aldeia da Folha", 100);
    }

    @Test
    void testAdicionarJutsu() {
        Jutsu jutsu = new Jutsu("Rasengan", 80, 50);
        personagem.adicionarNovoJutsu("Rasengan", jutsu);
        assertNotNull(personagem.getJutsus().get("Rasengan"));
        assertEquals(jutsu, personagem.getJutsus().get("Rasengan"));
    }

    @Test
    void testAumentarChakra() {
        personagem.aumentarChakra(50);
        assertEquals(100, personagem.getChakra());

        personagem.setChakra(80);
        personagem.aumentarChakra(30);
        assertEquals(100, personagem.getChakra());
    }

    @Test
    void testExibirInformacoes() {
        personagem.exibirInformacoes();
    }
}

package com.example.Naruto_DB;

import com.example.Naruto_DB.entity.Jutsu;
import com.example.Naruto_DB.ninja.NinjaDeGenjutsu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NinjaDeGenjutsuTest {
    private NinjaDeGenjutsu ninja;

    @BeforeEach
    public void setUp() {
        ninja = new NinjaDeGenjutsu("Itachi Uchiha", 21, "Aldeia da Folha", 300);
    }

    @Test
    public void testAdicionarJutsu() {
        Jutsu jutsu = new Jutsu("Tsukuyomi",50,20);
        ninja.adicionarNovoJutsu("Tsukuyomi", jutsu);
        assertNotNull(ninja.getJutsus().get("Tsukuyomi"));
    }

    @Test
    public void testAumentarChakra() {
        ninja.aumentarChakra(70);
        assertEquals(370, ninja.getChakra());
    }

}

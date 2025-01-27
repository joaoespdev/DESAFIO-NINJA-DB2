package com.example.Naruto_DB;

import com.example.Naruto_DB.entity.Jutsu;
import com.example.Naruto_DB.ninja.NinjaDeTaijutsu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NinjaDeTaijutsuTest {
    private NinjaDeTaijutsu ninja;

    @BeforeEach
    public void setUp() {
        ninja = new NinjaDeTaijutsu("Rock Lee", 17, "Aldeia da Folha", 200);
    }

    @Test
    public void testAdicionarJutsu() {
        Jutsu jutsu = new Jutsu("Dynamic Entry", 50,50);
        ninja.adicionarNovoJutsu("Dynamic Entry", jutsu);
        assertNotNull(ninja.getJutsus().get("Dynamic Entry"));
    }

    @Test
    public void testAumentarChakra() {
        ninja.aumentarChakra(50);
        assertEquals(250, ninja.getChakra());
    }

}

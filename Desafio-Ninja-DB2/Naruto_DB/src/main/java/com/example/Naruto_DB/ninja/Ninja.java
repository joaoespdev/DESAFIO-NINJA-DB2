package com.example.Naruto_DB.ninja;

import com.example.Naruto_DB.entity.Personagem;

public interface Ninja {
    boolean usarJutsu(String nomeJutsu, Personagem inimigo);

    void desviar(int dano);
}

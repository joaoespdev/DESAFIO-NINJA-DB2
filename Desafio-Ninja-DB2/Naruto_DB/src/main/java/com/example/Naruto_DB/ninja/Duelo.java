package com.example.Naruto_DB.ninja;

import com.example.Naruto_DB.entity.Jutsu;
import com.example.Naruto_DB.entity.Personagem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Duelo {
    public void iniciarDuelo(Personagem atacante, Personagem defensor) {
        if (!atacante.estaVivo()) {
            System.out.println(atacante.getNome() + " está derrotado e não pode atacar!");
            return;
        }

        if (!defensor.estaVivo()) {
            System.out.println(defensor.getNome() + " está derrotado e não pode ser atacado!");
            return;
        }

        List<String> jutsusDisponiveis = new ArrayList<>(atacante.getJutsus().keySet());
        if (jutsusDisponiveis.isEmpty()) {
            System.out.println(atacante.getNome() + " não tem jutsus disponíveis para atacar!");
            return;
        }

        String nomeJutsu = jutsusDisponiveis.get((int) (Math.random() * jutsusDisponiveis.size()));
        Optional<Jutsu> jutsuOpt = Optional.ofNullable(atacante.getJutsus().get(nomeJutsu));

        if (jutsuOpt.isPresent()) {
            Jutsu jutsu = jutsuOpt.get();
            System.out.println(atacante.getNome() + " ataca " + defensor.getNome() + " com " + jutsu.getNome() + "!");

            if (Math.random() < 0.5) {
                defensor.desviar(jutsu.getDano());
            } else {
                if (atacante.usarJutsu(nomeJutsu, defensor)) {
                    if (!defensor.estaVivo()) {
                        System.out.println(defensor.getNome() + " foi derrotado!");
                    }
                }
            }

        } else {
            System.out.println("Jutsu não encontrado para " + atacante.getNome());
        }
        System.out.println("-----------------------------");
    }
}

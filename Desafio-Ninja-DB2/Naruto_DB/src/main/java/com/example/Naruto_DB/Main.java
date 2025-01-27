package com.example.Naruto_DB;

import com.example.Naruto_DB.entity.Jutsu;
import com.example.Naruto_DB.ninja.*;

public class Main {
    public static void main(String[] args) {
        NinjaDeTaijutsu naruto = new NinjaDeTaijutsu("Naruto Uzumaki", 17, "Aldeia da Folha", 100);
        NinjaDeNinjutsu jiraiya = new NinjaDeNinjutsu("Jiraiya Sensei", 50, "Aldeia da Folha", 100);
        NinjaDeGenjutsu rockLee = new NinjaDeGenjutsu("Rock Lee", 17, "Aldeia da Folha", 100);

        naruto.adicionarNovoJutsu("Rasengan", new Jutsu("Rasengan", 100, 100));
        jiraiya.adicionarNovoJutsu("Canto do Sapo", new Jutsu("Canto do Sapo", 85, 50));
        rockLee.adicionarNovoJutsu("Oito Portões", new Jutsu("Oito Portões", 90, 00));

        System.out.println("\n*-=- Lutadores -=-*\n");
        naruto.exibirInformacoes();
        System.out.println("\n");
        jiraiya.exibirInformacoes();
        System.out.println("\n");
        rockLee.exibirInformacoes();
        System.out.println("\n");

        System.out.println("\n*-=- Duelo iniciado -=-*\n");

        Duelo duelo = new Duelo();
        duelo.iniciarDuelo(naruto, rockLee);


        if (rockLee.estaVivo()) {
            duelo.iniciarDuelo(rockLee, naruto);
        }
        if (naruto.estaVivo()) {
            duelo.iniciarDuelo(jiraiya, naruto);
        }

        System.out.println("\n-_-_- Combate Encerrado -_-_-\n");
        naruto.exibirInformacoes();
        System.out.println("\n");
        jiraiya.exibirInformacoes();
        System.out.println("\n");
        rockLee.exibirInformacoes();
        System.out.println("\n");
    }
}

package com.example.Naruto_DB.controller;

import com.example.Naruto_DB.dto.JutsuDto;
import com.example.Naruto_DB.dto.PersonagemDto;
import com.example.Naruto_DB.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @GetMapping
    public ResponseEntity<List<PersonagemDto>> listarPersonagens() {
        List<PersonagemDto> personagens = personagemService.listarPersonagens();
        return ResponseEntity.ok(personagens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonagemDto> buscarPersonagemPorId(@PathVariable Long id) {
        PersonagemDto personagem = personagemService.buscarPersonagemPorId(id);
        return personagem != null ? ResponseEntity.ok(personagem) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PersonagemDto> adicionarPersonagem(@RequestBody PersonagemDto personagemDTO) {
        PersonagemDto novoPersonagem = personagemService.criarPersonagem(personagemDTO);
        return ResponseEntity.ok(novoPersonagem);
    }

    @PostMapping("/{personagemId}/jutsus")
    public ResponseEntity<JutsuDto> criarJutsu(@PathVariable Long personagemId, @RequestBody JutsuDto jutsuDTO) {
        JutsuDto novoJutsu = personagemService.criarJutsu(personagemId, jutsuDTO);
        return ResponseEntity.ok(novoJutsu);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonagemDto> alterarPersonagem(@PathVariable Long id, @RequestBody PersonagemDto novosDados) {
        personagemService.alterarPersonagem(id, novosDados);
        return ResponseEntity.ok(novosDados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersonagem(@PathVariable Long id) {
        personagemService.eliminarPersonagem(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{personagemId}/jutsus/{nomeJutsu}")
    public ResponseEntity<Void> deletarJutsu(@PathVariable Long personagemId, @PathVariable String nomeJutsu) {
        personagemService.deletarJutsu(personagemId, nomeJutsu);
        return ResponseEntity.noContent().build();
    }
}

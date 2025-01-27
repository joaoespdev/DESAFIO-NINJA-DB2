package com.example.Naruto_DB;


import com.example.Naruto_DB.controller.PersonagemController;
import com.example.Naruto_DB.dto.JutsuDto;
import com.example.Naruto_DB.dto.PersonagemDto;
import com.example.Naruto_DB.service.PersonagemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PersonagemControllerTests {
    private MockMvc mockMvc;

    @Mock
    private PersonagemService personagemService;

    @InjectMocks
    private PersonagemController personagemController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(personagemController).build();
    }

    @Test
    public void testCriarPersonagem() throws Exception {
        Map<String, JutsuDto> jutsus = new HashMap<>();
        PersonagemDto personagemDTO = new PersonagemDto();
        personagemDTO.setId(1L);
        personagemDTO.setNome("Naruto");
        personagemDTO.setIdade(16);
        personagemDTO.setAldeia("Konoha");
        personagemDTO.setChakra(100);
        personagemDTO.setVida(100);
        personagemDTO.setJutsus(jutsus);

        when(personagemService.criarPersonagem(any(PersonagemDto.class))).thenReturn(personagemDTO);

        mockMvc.perform(post("/api/personagens")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\":\"Naruto\",\"idade\":16,\"aldeia\":\"Konoha\",\"chakra\":100,\"vida\":100,\"jutsus\":{}}"))
                .andExpect(status().isOk());

        verify(personagemService, times(1)).criarPersonagem(any(PersonagemDto.class));
    }

    @Test
    public void testListarPersonagens() throws Exception {
        Map<String, JutsuDto> jutsus1 = new HashMap<>();
        Map<String, JutsuDto> jutsus2 = new HashMap<>();
        PersonagemDto personagem1 = new PersonagemDto(1L, "Naruto", 16, "Konoha", 100, 100, jutsus1);
        PersonagemDto personagem2 = new PersonagemDto(2L, "Sasuke", 16, "Konoha", 100, 100, jutsus2);
        List<PersonagemDto> personagens = Arrays.asList(personagem1, personagem2);

        when(personagemService.listarPersonagens()).thenReturn(personagens);

        mockMvc.perform(get("/api/personagens")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Naruto"))
                .andExpect(jsonPath("$[1].nome").value("Sasuke"));

        verify(personagemService, times(1)).listarPersonagens();
    }

    @Test
    public void testBuscarPersonagemPorId() throws Exception {
        Map<String, JutsuDto> jutsus = new HashMap<>();
        PersonagemDto personagemDTO = new PersonagemDto(1L, "Naruto", 16, "Konoha", 100, 100, jutsus);

        when(personagemService.buscarPersonagemPorId(1L)).thenReturn(personagemDTO);

        mockMvc.perform(get("/api/personagens/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Naruto"));

        verify(personagemService, times(1)).buscarPersonagemPorId(1L);
    }

    @Test
    public void testAlterarPersonagem() throws Exception {
        Map<String, JutsuDto> jutsus = new HashMap<>();
        PersonagemDto personagemDTO = new PersonagemDto(1L, "Naruto", 16, "Konoha", 100, 100, jutsus);

        mockMvc.perform(put("/api/personagens/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\":\"Naruto Uzumaki\",\"idade\":17,\"aldeia\":\"Konoha\",\"chakra\":100,\"vida\":100,\"jutsus\":{}}"))
                .andExpect(status().isOk());

        verify(personagemService, times(1)).alterarPersonagem(eq(1L), any(PersonagemDto.class));
    }

    @Test
    public void testEliminarPersonagem() throws Exception {
        mockMvc.perform(delete("/api/personagens/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(personagemService, times(1)).eliminarPersonagem(1L);
    }
}

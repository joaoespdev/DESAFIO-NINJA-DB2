# 🍥 Desafio de POO - Anime Naruto
Este projeto simula batalhas entre ninjas, com funcionalidades baseadas em **Programação Orientada a Objetos**, inspiradas no anime **Naruto**.

### Versão Anterior  
[Desafio Ninja DB](https://github.com/joaoespdev/Desafio-Ninja-DB)



### 🏮 Funcionalidades

- **Personagens**: Cada personagem possui um nome, chakra, vida e um mapa de jutsus (`Map<String, Jutsu>`), onde o jutsu é representado pela classe **Jutsu**, com dano e consumo de chakra.
- **Usar Jutsu**: A função **usarJutsu()** causa dano ao inimigo e desconta chakra do personagem, exibindo uma mensagem do ataque.
- **Desviar**: A função **desviar()** permite que o ninja evite danos. Se falhar, perde vida igual ao dano do jutsu.
- **Condições de Vitória**: O ninja perde quando fica sem chakra ou vida. O jogo termina quando isso acontece.
- **Classes Especializadas**: Existem classes para ninjas especializados em **Taijutsu** e **Ninjutsu**, que implementam os métodos de ataque e defesa da interface **Ninja**.
- **Classe Jutsu**: Representa os jutsus, com atributos de **dano** e **consumo de chakra**.

### 🍃 Objetivo

Simular batalhas entre ninjas, onde cada um deve gerenciar seu chakra e vida para vencer o oponente.


---

## Data Transfer Object (DTO) 🍡

O projeto utiliza **DTOs (Data Transfer Objects)** para transferir dados entre as camadas de controle e serviço. Os DTOs encapsulam os dados enviados e recebidos pela API, garantindo que apenas as informações necessárias sejam expostas. Isso melhora a segurança 🔒 e a eficiência 🚀 da aplicação.

### Exemplos de DTOs Criados:
- **PersonagemDTO**: Representa os dados de um personagem, incluindo atributos como nome, idade, aldeia, chakra, vida e jutsus.
- **JutsuDTO**: Representa os dados de um jutsu, incluindo atributos como nome, dano e consumo de chakra.

---

### 🧩 Testes da Aplicação

A aplicação possui testes para garantir o funcionamento correto das funcionalidades relacionadas aos personagens e aos ninjas. Eles estão organizados na pasta `src/test/java` e incluem as seguintes classes:

- **PersonagemTests**: Testa a lógica de negócios do serviço de personagens.
- **PersonagemControllerTests**: Valida a API REST do controlador de personagens.
- **BatalhaTests**: Verifica a lógica dos duelos (se houver).
- **PersonagemTest**: Realiza validações gerais dos atributos e métodos da classe `Personagem`.
- **NinjaDeGenjutsuTests**: Testa a lógica para ninjas especializados em Genjutsu.
- **NinjaDeTaijutsuTests**: Testa a lógica para ninjas especializados em Taijutsu.
- **NinjaDeNinjutsuTests**: Testa a lógica para ninjas especializados em Ninjutsu.

---

## Tecnologias Utilizadas 🍜

- **Java 23**: Linguagem de programação utilizada 
- **Spring Boot**: Framework para desenvolvimento de aplicações Java 
- **Spring Data JPA**: Biblioteca para integração com o banco de dados 
- **H2 Database**: Banco de dados em memória para persistência de dados 
- **Spring Boot DevTools**: Ferramenta para recarregamento automático durante o desenvolvimento 
- **JUnit 5**: Framework para testes unitários 
- **Mockito**: Biblioteca para simulação de objetos em testes 
- **Springdoc OpenAPI Starter WebMVC UI**: Para documentação da API e interface Swagger 

---

## Documentação da API com Swagger 🗂️

A aplicação utiliza o **Springdoc OpenAPI** para fornecer uma interface interativa para a documentação da API. Após iniciar o projeto, você pode acessar a documentação em:

```bash
http://localhost:8080/swagger-ui/index.html#/

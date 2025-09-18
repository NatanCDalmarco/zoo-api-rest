# API REST de Zoológico - Cuidadores

Esta é uma API REST para gerenciar os cuidadores de um zoológico.

## Visão Geral

A API permite realizar operações de CRUD (Criar, Ler, Atualizar e Deletar) para os cuidadores.

## Endpoints da API

A seguir estão os endpoints disponíveis para a entidade `Cuidador`.

### Listar Cuidadores

- **GET** `/cuidadores`
- **Descrição:** Retorna uma lista de todos os cuidadores.
- **Parâmetros de Query (Opcionais):**
    - `especialidade` (String): Filtra os cuidadores por sua especialidade.
    - `turno` (String): Filtra os cuidadores por seu turno de trabalho.
- **Resposta de Sucesso:** `200 OK` com uma lista de objetos `Cuidador`.

### Buscar Cuidador por ID

- **GET** `/cuidadores/{id}`
- **Descrição:** Retorna um cuidador específico com base no seu ID.
- **Parâmetros de URL:**
    - `id` (Long): O ID do cuidador.
- **Resposta de Sucesso:** `200 OK` com o objeto `Cuidador`.
- **Resposta de Erro:** `404 Not Found` se o cuidador não for encontrado.

### Criar um Novo Cuidador

- **POST** `/cuidadores`
- **Descrição:** Cria um novo cuidador.
- **Corpo da Requisição:** Um objeto `CuidadorRequestDTO`.
- **Resposta de Sucesso:** `200 OK` com o objeto `Cuidador` criado.

### Atualizar um Cuidador

- **PUT** `/cuidadores/{id}`
- **Descrição:** Atualiza as informações de um cuidador existente.
- **Parâmetros de URL:**
    - `id` (Long): O ID do cuidador a ser atualizado.
- **Corpo da Requisição:** Um objeto `CuidadorRequestDTO` com as novas informações.
- **Resposta de Sucesso:** `200 OK` com o objeto `Cuidador` atualizado.
- **Resposta de Erro:** `404 Not Found` se o cuidador não for encontrado.

### Deletar um Cuidador

- **DELETE** `/cuidadores/{id}`
- **Descrição:** Deleta um cuidador com base no seu ID.
- **Parâmetros de URL:**
    - `id` (Long): O ID do cuidador a ser deletado.
- **Resposta de Sucesso:** `200 OK` com uma mensagem de confirmação.
- **Resposta de Erro:** `404 Not Found` se o cuidador não for encontrado.

## Data Transfer Objects (DTOs)

### CuidadorRequestDTO

Usado para criar ou atualizar um cuidador.

```json
{
  "nome": "string",
  "especialidade": "string",
  "turno": "string"
}
```

### CuidadorResponseDTO

Usado para retornar informações do cuidador.

```json
{
  "id": "long",
  "nome": "string",
  "especialidade": "string",
  "turno": "string"
}
```

## Como Executar o Projeto

1.  Clone o repositório.
2.  Certifique-se de ter o Java e o Maven (ou Gradle) instalados.
3.  Navegue até a raiz do projeto e execute `mvn spring-boot:run` (para Maven) ou `./gradlew bootRun` (para Gradle).
4.  A API estará disponível em `http://localhost:8080`.

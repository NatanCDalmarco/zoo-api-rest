# API REST de Zoológico

Esta é uma API REST para gerenciar as entidades de um zoológico, incluindo Animais, Cuidadores, Habitats, Veterinários e Alimentação.

## Visão Geral

A API permite realizar operações de CRUD (Criar, Ler, Atualizar e Deletar) para as diversas entidades do zoológico.

## Como Executar o Projeto

1.  Clone o repositório.
2.  Certifique-se de ter o Java e o Maven (ou Gradle) instalados.
3.  Navegue até a raiz do projeto e execute `mvn spring-boot:run` (para Maven) ou `./gradlew bootRun` (para Gradle).
4.  A API estará disponível em `http://localhost:8080`.

---

## Endpoints da API

A seguir estão os endpoints disponíveis para cada entidade.

### Animais
-   **Base Path:** `/animals`

| Método | Endpoint | Descrição | Resposta de Sucesso |
| :--- | :--- | :--- | :--- |
| `GET` | `/` | Retorna uma lista de todos os animais. | `200 OK` com uma lista de objetos `Animal`. |
| `GET` | `/{id}` | Retorna um animal específico pelo ID. | `200 OK` com o objeto `Animal`. |
| `GET` | `/species?value={especie}` | Filtra os animais pela espécie. | `200 OK` com uma lista de objetos `Animal`. |
| `GET` | `/name?value={nome}` | Filtra os animais pelo nome. | `200 OK` com uma lista de objetos `Animal`. |
| `GET` | `/age?min={min}&max={max}` | Filtra os animais por uma faixa de idade. | `200 OK` com uma lista de objetos `Animal`. |
| `POST` | `/` | Cria um novo animal. | `200 OK` com o objeto `Animal` criado. |
| `PUT` | `/{id}` | Atualiza as informações de um animal existente. | `200 OK` com o objeto `Animal` atualizado. |
| `DELETE`| `/{id}` | Deleta um animal pelo ID. | `200 OK` com uma mensagem de confirmação. |

### Cuidadores
-   **Base Path:** `/cuidadores`

| Método | Endpoint | Descrição | Resposta de Sucesso |
| :--- | :--- | :--- | :--- |
| `GET` | `/` | Retorna uma lista de cuidadores. Pode ser filtrado por `especialidade` e/ou `turno`. | `200 OK` com uma lista de objetos `Cuidador`. |
| `GET` | `/{id}` | Retorna um cuidador específico pelo ID. | `200 OK` com o objeto `Cuidador`. |
| `POST` | `/` | Cria um novo cuidador. | `200 OK` com o objeto `Cuidador` criado. |
| `PUT` | `/{id}` | Atualiza as informações de um cuidador existente. | `200 OK` com o objeto `Cuidador` atualizado. |
| `DELETE`| `/{id}` | Deleta um cuidador pelo ID. | `200 OK` com uma mensagem de confirmação. |

### Habitats
-   **Base Path:** `/habitats`

| Método | Endpoint | Descrição | Resposta de Sucesso |
| :--- | :--- | :--- | :--- |
| `GET` | `/` | Retorna uma lista de todos os habitats. | `200 OK` com uma lista de objetos `Habitat`. |
| `GET` | `/{id}` | Retorna um habitat específico pelo ID. | `200 OK` com o objeto `Habitat`. |
| `GET` | `/tipo?tipo={tipo}` | Filtra os habitats pelo tipo. | `200 OK` com uma lista de objetos `Habitat`. |
| `POST` | `/` | Cria um novo habitat. | `200 OK` com o objeto `Habitat` criado. |
| `PUT` | `/{id}` | Atualiza as informações de um habitat existente. | `200 OK` com o objeto `Habitat` atualizado. |
| `DELETE`| `/{id}` | Deleta um habitat pelo ID. | `200 OK` com uma mensagem de confirmação. |

### Veterinários
-   **Base Path:** `/veterinarios`

| Método | Endpoint | Descrição | Resposta de Sucesso |
| :--- | :--- | :--- | :--- |
| `GET` | `/` | Retorna uma lista de todos os veterinários. | `200 OK` com uma lista de objetos `Veterinario`. |
| `GET` | `/{id}` | Retorna um veterinário específico pelo ID. | `200 OK` com o objeto `Veterinario`. |
| `GET` | `/especialidade/{especialidade}` | Filtra os veterinários pela especialidade. | `200 OK` com uma lista de objetos `Veterinario`. |
| `POST` | `/` | Cria um novo veterinário. | `200 OK` com o objeto `Veterinario` criado. |
| `PUT` | `/{id}` | Atualiza as informações de um veterinário. | `200 OK` com o objeto `Veterinario` atualizado. |
| `DELETE`| `/{id}` | Deleta um veterinário pelo ID. | `204 No Content`. |

### Alimentação
-   **Base Path:** `/api/alimentacoes`

| Método | Endpoint | Descrição | Resposta de Sucesso |
| :--- | :--- | :--- | :--- |
| `GET` | `/` | Retorna uma lista de todos os registros de alimentação. | `200 OK` com uma lista de objetos `Alimentacao`. |
| `POST` | `/` | Cria um novo registro de alimentação. | `200 OK`. |
| `PUT` | `/{id}` | Atualiza um registro de alimentação. | `200 OK` com o objeto `Alimentacao` atualizado. |
| `DELETE`| `/{id}` | Deleta um registro de alimentação. | `200 OK`. |

---

## Data Transfer Objects (DTOs)

### `AnimalRequestDTO`
Usado para criar ou atualizar um animal.
```json
{
  "nome": "string",
  "especie": "string",
  "idade": "integer",
  "habitatId": "long",
  "cuidadorId": "long"
}
```

### `Cuidador` (Model)
Usado para criar ou atualizar um cuidador.
```json
{
  "nome": "string",
  "especialidade": "string",
  "turno": "string"
}
```

### `HabitatDto`
Usado para criar ou atualizar um habitat.
```json
{
  "nome": "string",
  "capacidadeMaxima": "integer",
  "dueDate": "string (yyyy-MM-dd)",
  "tipo": "string"
}
```

### `VeterinarioDTO`
Usado para criar ou atualizar um veterinário.
```json
{
  "nome": "string",
  "crvm": "string",
  "especialidade": "string"
}
```

### `AlimentacaoRequestDTO`
Usado para criar ou atualizar um registro de alimentação.
```json
{
  "tipoComida": "string",
  "quantidadeDiaria": "number",
  "animalId": "long"
}
```

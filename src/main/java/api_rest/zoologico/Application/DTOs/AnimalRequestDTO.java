package api_rest.zoologico.Application.DTOs;

public record AnimalRequestDTO (
    String nome,
    String especie,
    int idade,
    Long habitatId,
    Long cuidadorId
){}
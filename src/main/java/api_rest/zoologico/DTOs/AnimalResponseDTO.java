package api_rest.zoologico.DTOs;

public record AnimalResponseDTO (
    Long id,
    String nome,
    String especie,
    int idade,
    HabitatDto habitat,
    CuidadorResponseDTO cuidador
){}
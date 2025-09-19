package api_rest.zoologico.DTOs;

public record CuidadorResponseDTO (
    Long id,
    String nome,
    String especialidade,
    String turno
){}

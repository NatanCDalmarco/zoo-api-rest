package api_rest.zoologico.DTOs;


public record CuidadorRequestDTO (
    String nome,
    String especialidade,
    String turno
){}

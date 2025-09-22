package api_rest.zoologico.Application.DTOs;


public record CuidadorRequestDTO (
    String nome,
    String especialidade,
    String turno
){}

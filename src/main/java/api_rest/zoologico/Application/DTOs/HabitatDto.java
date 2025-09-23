package api_rest.zoologico.Application.DTOs;

import api_rest.zoologico.Domain.Models.Tipo;

import java.time.LocalDate;

public record HabitatDto (
        String nome,
        int capacidadeMaxima,
        LocalDate dueDate,
        Tipo tipo
){
}
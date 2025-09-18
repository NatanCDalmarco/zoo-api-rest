package api_rest.zoologico.DTOs;

import api_rest.zoologico.Models.Tipo;

import java.time.LocalDate;

public record HabitatDto (
        String nome,
        int capacidadeMaxima,
        LocalDate dueDate,
        Tipo tipo
){

}
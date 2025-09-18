package api_rest.zoologico.DTOs;

import lombok.Data;

@Data
public class AnimalRequestDTO {
    private String nome;
    private String especie;
    private int idade;
    private Long habitatId;
    private Long cuidadorId;
}
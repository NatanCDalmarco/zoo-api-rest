package api_rest.zoologico.DTOs;

import lombok.Data;

@Data
public class AnimalResponseDTO {
    private Long id;
    private String nome;
    private String especie;
    private int idade;
    private HabitatDto habitat;
    private CuidadorResponseDTO cuidador;
}
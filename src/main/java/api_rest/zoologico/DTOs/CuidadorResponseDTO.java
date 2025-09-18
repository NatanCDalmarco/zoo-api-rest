package api_rest.zoologico.DTOs;

import lombok.Data;

@Data
public class CuidadorResponseDTO {
    private Long id;
    private String nome;
    private String especialidade;
    private String turno;
}

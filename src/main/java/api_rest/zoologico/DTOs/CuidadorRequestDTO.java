package api_rest.zoologico.DTOs;

import lombok.Data;

@Data
public class CuidadorRequestDTO {
    private String nome;
    private String especialidade;
    private String turno;
}

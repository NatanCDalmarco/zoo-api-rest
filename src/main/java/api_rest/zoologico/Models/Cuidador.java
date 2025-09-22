package api_rest.zoologico.Models;

import api_rest.zoologico.DTOs.CuidadorRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cuidador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String especialidade;

    private String turno;

    public Cuidador(CuidadorRequestDTO dto) {
        this.nome = dto.nome();
        this.especialidade = dto.especialidade();
        this.turno = dto.turno();
    }
}

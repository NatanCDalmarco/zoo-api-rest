package api_rest.zoologico.Domain.Models;

import api_rest.zoologico.Application.DTOs.VeterinarioDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Veterinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String CRVM;

    @Enumerated(EnumType.STRING)
    private EspecialidadeVeterinario especialidadeVeterinario;

    public Veterinario(VeterinarioDTO data) {
        this.nome = data.nome();
        this.CRVM = data.crvm();
        this.especialidadeVeterinario = data.especialidade();
    }
}

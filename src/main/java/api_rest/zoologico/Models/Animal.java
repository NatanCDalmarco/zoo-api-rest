package api_rest.zoologico.Models;

import api_rest.zoologico.DTOs.AnimalRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String especie;
    private int idade;

    @ManyToOne
    @JoinColumn(name = "habitat_id", nullable = false)
    private Habitat habitat;

    @ManyToOne
    @JoinColumn(name = "cuidador_id", nullable = false)
    private Cuidador cuidador;

    public Animal(AnimalRequestDTO dto, Habitat habitat, Cuidador cuidador) {
        this.especie = dto.especie();
        this.nome = dto.nome();
        this.idade = dto.idade();
        this.habitat = habitat;
        this.cuidador = cuidador;
    }
}
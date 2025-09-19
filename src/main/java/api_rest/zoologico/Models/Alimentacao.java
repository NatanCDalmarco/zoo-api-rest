package api_rest.zoologico.Models;

import api_rest.zoologico.DTOs.AlimentacaoRequestDTO;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Alimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoComida;
    private BigDecimal quantidadeDiaria;

    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;

    public Alimentacao() {
    }

    public Alimentacao(AlimentacaoRequestDTO dto, Animal animal) {
        this.tipoComida = dto.tipoComida();
        this.quantidadeDiaria = dto.quantidadeDiaria();
        this.animal = animal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    public BigDecimal getQuantidadeDiaria() {
        return quantidadeDiaria;
    }

    public void setQuantidadeDiaria(BigDecimal quantidadeDiaria) {
        this.quantidadeDiaria = quantidadeDiaria;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
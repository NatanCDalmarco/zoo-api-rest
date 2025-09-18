package api_rest.zoologico.dto;

import api_rest.zoologico.entity.Alimentacao;
import java.math.BigDecimal;

public class AlimentacaoResponseDTO {

    private Long id;
    private String tipoComida;
    private BigDecimal quantidadeDiaria;
    private Long animalId;
    private String nomeAnimal; // Campo para fornecer contexto sobre o animal

     public AlimentacaoResponseDTO(Alimentacao alimentacao) {
        this.id = alimentacao.getId();
        this.tipoComida = alimentacao.getTipoComida();
        this.quantidadeDiaria = alimentacao.getQuantidadeDiaria();

    if (alimentacao.getAnimal() != null) {
            this.animalId = alimentacao.getAnimal().getId();
            this.nomeAnimal = alimentacao.getAnimal().getNome();
        }
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

    public Long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }
}
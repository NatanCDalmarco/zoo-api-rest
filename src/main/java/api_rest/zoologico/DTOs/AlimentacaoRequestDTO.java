package api_rest.zoologico.DTOs;

import java.math.BigDecimal;

public class AlimentacaoRequestDTO {

    private String tipoComida;
    private BigDecimal quantidadeDiaria;
    private Long animalId; // Recebe apenas o ID do Animal

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
}
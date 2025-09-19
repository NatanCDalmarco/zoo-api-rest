package api_rest.zoologico.DTOs;

import api_rest.zoologico.Models.Alimentacao;
import java.math.BigDecimal;

public record AlimentacaoResponseDTO (
    Long id,
    String tipoComida,
    BigDecimal quantidadeDiaria,
    Long animalId,
    String nomeAnimal
    ){}

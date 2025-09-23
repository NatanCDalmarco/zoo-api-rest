package api_rest.zoologico.Application.DTOs;

import java.math.BigDecimal;

public record AlimentacaoRequestDTO (
    String tipoComida,
    BigDecimal quantidadeDiaria,
    Long animalId // Recebe apenas o ID do Animal
){}
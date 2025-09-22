package api_rest.zoologico.Application.DTOs;

import api_rest.zoologico.Domain.Models.EspecialidadeVeterinario;

public record VeterinarioDTO(
        String nome,
        String crvm,
        EspecialidadeVeterinario especialidade
) {
}

package api_rest.zoologico.DTOs;

import api_rest.zoologico.Models.EspecialidadeVeterinario;

public record VeterinarioDTO(
        String nome,
        String crvm,
        EspecialidadeVeterinario especialidade
) {
}

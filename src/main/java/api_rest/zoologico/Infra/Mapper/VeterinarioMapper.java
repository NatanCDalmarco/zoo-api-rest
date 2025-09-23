package api_rest.zoologico.Infra.Mapper;

import api_rest.zoologico.Application.DTOs.VeterinarioDTO;
import api_rest.zoologico.Domain.Models.Veterinario;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface VeterinarioMapper {
    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(VeterinarioDTO veterinarioDTO, @MappingTarget Veterinario veterinario);
}

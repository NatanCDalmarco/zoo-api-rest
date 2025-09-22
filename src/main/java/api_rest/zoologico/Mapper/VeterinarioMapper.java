package api_rest.zoologico.Mapper;

import api_rest.zoologico.DTOs.VeterinarioDTO;
import api_rest.zoologico.Models.Veterinario;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface VeterinarioMapper {
    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(VeterinarioDTO veterinarioDTO, @MappingTarget Veterinario veterinario);
}

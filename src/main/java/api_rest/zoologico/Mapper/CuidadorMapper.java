package api_rest.zoologico.Mapper;

import api_rest.zoologico.DTOs.CuidadorRequestDTO;
import api_rest.zoologico.Models.Cuidador;
import org.mapstruct.*;

@Mapper
public interface CuidadorMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(CuidadorRequestDTO cuidadorRequestDTO, @MappingTarget Cuidador cuidador);
}
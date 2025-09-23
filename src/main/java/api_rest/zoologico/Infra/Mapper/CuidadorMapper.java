package api_rest.zoologico.Infra.Mapper;

import api_rest.zoologico.Application.DTOs.CuidadorRequestDTO;
import api_rest.zoologico.Domain.Models.Cuidador;
import org.mapstruct.*;

@Mapper
public interface CuidadorMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(CuidadorRequestDTO cuidadorRequestDTO, @MappingTarget Cuidador cuidador);
}
package api_rest.zoologico.Infra.Mapper;

import api_rest.zoologico.Application.DTOs.AnimalRequestDTO;
import api_rest.zoologico.Domain.Models.Animal;
import org.mapstruct.*;

@Mapper
public interface AnimalMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(AnimalRequestDTO animalRequestDTO, @MappingTarget Animal animal);
}

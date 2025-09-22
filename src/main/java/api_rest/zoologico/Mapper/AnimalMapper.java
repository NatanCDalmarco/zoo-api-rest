package api_rest.zoologico.Mapper;

import api_rest.zoologico.DTOs.AnimalRequestDTO;
import api_rest.zoologico.Models.Animal;
import org.mapstruct.*;

@Mapper
public interface AnimalMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(AnimalRequestDTO animalRequestDTO, @MappingTarget Animal animal);
}

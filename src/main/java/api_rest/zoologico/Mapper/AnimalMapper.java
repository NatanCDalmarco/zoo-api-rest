package api_rest.zoologico.Mapper;

import api_rest.zoologico.DTOs.AnimalRequestDTO;
import api_rest.zoologico.DTOs.AnimalResponseDTO;
import api_rest.zoologico.DTOs.CuidadorResponseDTO;
import api_rest.zoologico.Models.Animal;
import api_rest.zoologico.Models.Cuidador;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {HabitatMapper.class})
public interface AnimalMapper {

    @Mapping(target = "cuidador", expression = "java(cuidadorToCuidadorResponseDTO(animal.getCuidador()))")
    AnimalResponseDTO toResponseDTO(Animal animal);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "habitat", ignore = true)
    @Mapping(target = "cuidador", ignore = true)
    Animal toEntity(AnimalRequestDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "habitat", ignore = true)
    @Mapping(target = "cuidador", ignore = true)
    void updateEntityFromDto(AnimalRequestDTO dto, @MappingTarget Animal animal);

    default CuidadorResponseDTO cuidadorToCuidadorResponseDTO(Cuidador cuidador) {
        if (cuidador == null) {
            return null;
        }
        CuidadorResponseDTO dto = new CuidadorResponseDTO();
        dto.setId(cuidador.getId());
        dto.setNome(cuidador.getNome());
        dto.setEspecialidade(cuidador.getEspecialidade());
        dto.setTurno(cuidador.getTurno());
        return dto;
    }
}
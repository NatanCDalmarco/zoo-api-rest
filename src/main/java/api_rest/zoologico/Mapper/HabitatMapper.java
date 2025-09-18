package api_rest.zoologico.Mapper;

import api_rest.zoologico.Dtos.HabitatDto;
import api_rest.zoologico.Models.Habitat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface HabitatMapper {
    @Mapping(target = "id", ignore = true)
    Habitat toEntity(HabitatDto habitatDto);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(HabitatDto habitatDto, @MappingTarget Habitat habitat);
}

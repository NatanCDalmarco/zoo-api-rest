package api_rest.zoologico.Mapper;

import api_rest.zoologico.DTOs.HabitatDto;
import api_rest.zoologico.Models.Habitat;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface HabitatMapper {
    @Mapping(target = "id", ignore = true)
    Habitat toEntity(HabitatDto habitatDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(HabitatDto habitatDto, @MappingTarget Habitat habitat);
}

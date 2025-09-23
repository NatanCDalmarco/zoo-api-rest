package api_rest.zoologico.Infra.Mapper;

import api_rest.zoologico.Application.DTOs.HabitatDto;
import api_rest.zoologico.Domain.Models.Habitat;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface HabitatMapper {
    @Mapping(target = "id", ignore = true)
    Habitat toEntity(HabitatDto habitatDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(HabitatDto habitatDto, @MappingTarget Habitat habitat);
}

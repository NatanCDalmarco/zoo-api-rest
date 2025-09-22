package api_rest.zoologico.Mapper;

import api_rest.zoologico.DTOs.AlimentacaoRequestDTO;
import api_rest.zoologico.Models.Alimentacao;
import org.mapstruct.*;

@Mapper
public interface AlimentacaoMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(AlimentacaoRequestDTO alimentacaoRequestDTO, @MappingTarget Alimentacao alimentacao);
}

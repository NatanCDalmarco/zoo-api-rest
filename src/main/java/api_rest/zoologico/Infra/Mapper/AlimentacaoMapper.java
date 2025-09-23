package api_rest.zoologico.Infra.Mapper;

import api_rest.zoologico.Application.DTOs.AlimentacaoRequestDTO;
import api_rest.zoologico.Domain.Models.Alimentacao;
import org.mapstruct.*;

@Mapper
public interface AlimentacaoMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(AlimentacaoRequestDTO alimentacaoRequestDTO, @MappingTarget Alimentacao alimentacao);
}

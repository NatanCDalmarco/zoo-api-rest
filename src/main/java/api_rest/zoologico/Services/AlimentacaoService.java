package api_rest.zoologico.Services;

import api_rest.zoologico.DTOs.AlimentacaoRequestDTO;
import api_rest.zoologico.Mapper.AlimentacaoMapper;
import api_rest.zoologico.Models.Alimentacao;
import api_rest.zoologico.Repositories.AlimentacaoRepository;
import api_rest.zoologico.Models.Animal;
import api_rest.zoologico.Repositories.AnimalRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlimentacaoService {
    private final AlimentacaoRepository alimentacaoRepository;
    private final AnimalRepository animalRepository;
    private final AlimentacaoMapper alimentacaoMapper;

    public AlimentacaoService(AlimentacaoRepository alimentacaoRepository, AnimalRepository animalRepository, AlimentacaoMapper alimentacaoMapper) {
        this.alimentacaoRepository = alimentacaoRepository;
        this.animalRepository = animalRepository;
        this.alimentacaoMapper = alimentacaoMapper;
    }

    public Alimentacao create(AlimentacaoRequestDTO dto) {
        Animal animal = animalRepository.getReferenceById(dto.animalId());
        Alimentacao alimentacao = new Alimentacao(dto, animal);
        return alimentacaoRepository.save(alimentacao);
    }

    public List<Alimentacao> getAll() {
        return alimentacaoRepository.findAll();
    }

    public Alimentacao update(AlimentacaoRequestDTO dto, Long id) {
        Alimentacao alimentacao = alimentacaoRepository.getReferenceById(id);
        alimentacaoMapper.updateEntityFromDto(dto, alimentacao);
        return alimentacaoRepository.save(alimentacao);
    }

    public void delete(Long id) {
        Alimentacao alimentacao = alimentacaoRepository.getReferenceById(id);
        alimentacaoRepository.delete(alimentacao);
    }
}
package api_rest.zoologico.service;

import api_rest.zoologico.dto.AlimentacaoRequestDTO;
import api_rest.zoologico.dto.AlimentacaoResponseDTO;
import api_rest.zoologico.entity.Alimentacao;
import api_rest.zoologico.repository.AlimentacaoRepository;
import api_rest.zoologico.entity.Animal;
import api_rest.zoologico.repository.AnimalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlimentacaoService {

    @Autowired
    private AlimentacaoRepository alimentacaoRepository;

    @Autowired
    private AnimalRepository animalRepository;


    private AlimentacaoResponseDTO toResponseDTO(Alimentacao alimentacao) {
        return new AlimentacaoResponseDTO(alimentacao);
    }

    private Alimentacao toEntity(AlimentacaoRequestDTO dto, Long id) {
        Alimentacao entity = id != null ? alimentacaoRepository.findById(id).orElse(new Alimentacao()) : new Alimentacao();

        Animal animal = animalRepository.findById(dto.getAnimalId())
                .orElseThrow(() -> new RuntimeException("Animal não encontrado com ID: " + dto.getAnimalId()));

        entity.setTipoComida(dto.getTipoComida());
        entity.setQuantidadeDiaria(dto.getQuantidadeDiaria());
        entity.setAnimal(animal);

        return entity;
    }


    public AlimentacaoResponseDTO criar(AlimentacaoRequestDTO dto) {
        Alimentacao alimentacao = toEntity(dto, null);
        alimentacao = alimentacaoRepository.save(alimentacao);
        return toResponseDTO(alimentacao);
    }

    public List<AlimentacaoResponseDTO> listarTodos() {
        return alimentacaoRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public AlimentacaoResponseDTO atualizar(Long id, AlimentacaoRequestDTO dto) {

        if (!alimentacaoRepository.existsById(id)) {
            throw new RuntimeException("Alimentação não encontrada.");
        }

        Alimentacao alimentacao = toEntity(dto, id);
        alimentacao.setId(id);
        alimentacao = alimentacaoRepository.save(alimentacao);
        return toResponseDTO(alimentacao);
    }

    public void deletar(Long id) {
        if (!alimentacaoRepository.existsById(id)) {
            throw new RuntimeException("Alimentação não encontrada.");
        }
        alimentacaoRepository.deleteById(id);
    }


    public List<AlimentacaoResponseDTO> buscarPorTipoComida(String tipoComida) {
        return alimentacaoRepository.findByTipoComidaContainingIgnoreCase(tipoComida).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public List<AlimentacaoResponseDTO> buscarPorAnimalId(Long animalId) {
        return alimentacaoRepository.findByAnimalId(animalId).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}
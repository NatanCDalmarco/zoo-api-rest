package api_rest.zoologico.Services;

import api_rest.zoologico.DTOs.AlimentacaoRequestDTO;
import api_rest.zoologico.DTOs.AlimentacaoResponseDTO;
import api_rest.zoologico.Models.Alimentacao;
import api_rest.zoologico.Repositories.AlimentacaoRepository;
import api_rest.zoologico.Models.Animal;
import api_rest.zoologico.Repositories.AnimalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlimentacaoService {

    @Autowired
    private AlimentacaoRepository alimentacaoRepository;

    @Autowired
    private AnimalRepository animalRepository;

    public void salvarALimento(AlimentacaoRequestDTO dto) {
        Animal animal = animalRepository.getReferenceById(dto.animalId());
        Alimentacao alimentacao = new Alimentacao(dto, animal);
        alimentacaoRepository.save(alimentacao);
    }

    public List<Alimentacao> listarAlimentos() {
        return alimentacaoRepository.findAll();
    }

    public Alimentacao updateAlimento(AlimentacaoRequestDTO dto, Long id){
        var found = alimentacaoRepository.getReferenceById(id);
        Animal animal = animalRepository.getReferenceById(dto.animalId());
        found.setAnimal(animal);
        found.setQuantidadeDiaria(dto.quantidadeDiaria());
        found.setTipoComida(dto.tipoComida());

        return found;
    }

    public void deleteAlimento(Long id) {
        alimentacaoRepository.deleteById(id);
    }


//    private AlimentacaoResponseDTO toResponseDTO(Alimentacao alimentacao) {
//        return new AlimentacaoResponseDTO(alimentacao);
//    }
//
//    private Alimentacao toEntity(AlimentacaoRequestDTO dto, Long id) {
//        Alimentacao entity = id != null ? alimentacaoRepository.findById(id).orElse(new Alimentacao()) : new Alimentacao();
//
//        Animal animal = animalRepository.findById(dto.animalId())
//                .orElseThrow(() -> new RuntimeException("Animal não encontrado com ID: " + dto.animalId()));
//
//        entity.setTipoComida(dto.tipoComida());
//        entity.setQuantidadeDiaria(dto.quantidadeDiaria());
//        entity.setAnimal(animal);
//
//        return entity;
//    }
//    public void criar(AlimentacaoRequestDTO dto) {
//        Animal animal = animalRepository.getReferenceById(dto.animalId());
//        Alimentacao alimentacao = new Alimentacao(dto, animal);
//        alimentacaoRepository.save(alimentacao);
//    }
//
//    public List<Alimentacao> listarTodos() {
//        return alimentacaoRepository.findAll();
//    }
//
//    public AlimentacaoResponseDTO atualizar(Long id, AlimentacaoRequestDTO dto) {
//
//        if (!alimentacaoRepository.existsById(id)) {
//            throw new RuntimeException("Alimentação não encontrada.");
//        }
//
//        Alimentacao alimentacao = toEntity(dto, id);
//        alimentacao.setId(id);
//        alimentacao = alimentacaoRepository.save(alimentacao);
//        return toResponseDTO(alimentacao);
//    }
//
//    public void deletar(Long id) {
//        if (!alimentacaoRepository.existsById(id)) {
//            throw new RuntimeException("Alimentação não encontrada.");
//        }
//        alimentacaoRepository.deleteById(id);
//    }
//
//
//    public List<AlimentacaoResponseDTO> buscarPorTipoComida(String tipoComida) {
//        return alimentacaoRepository.findByTipoComidaContainingIgnoreCase(tipoComida).stream()
//                .map(this::toResponseDTO)
//                .collect(Collectors.toList());
//    }
//
//    public List<AlimentacaoResponseDTO> buscarPorAnimalId(Long animalId) {
//        return alimentacaoRepository.findByAnimalId(animalId).stream()
//                .map(this::toResponseDTO)
//                .collect(Collectors.toList());
//    }
}
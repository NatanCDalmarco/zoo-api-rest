package api_rest.zoologico.Services;

import api_rest.zoologico.DTOs.AlimentacaoRequestDTO;
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

    public AlimentacaoService(AlimentacaoRepository alimentacaoRepository, AnimalRepository animalRepository) {
        this.alimentacaoRepository = alimentacaoRepository;
        this.animalRepository = animalRepository;
    }

    public void salvarALimento(AlimentacaoRequestDTO dto) {
        Animal animal = animalRepository.findById(dto.animalId())
                .orElseThrow(() -> new RuntimeException("Animal com ID " + dto.animalId() + " não encontrado."));
        Alimentacao alimentacao = new Alimentacao(dto, animal);
        alimentacaoRepository.save(alimentacao);
    }

    public List<Alimentacao> listarAlimentos() {
        return alimentacaoRepository.findAll();
    }

    public Alimentacao updateAlimento(AlimentacaoRequestDTO dto, Long id) {
        Alimentacao found = alimentacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro de alimentação com ID " + id + " não encontrado."));
        Animal animal = animalRepository.findById(dto.animalId())
                .orElseThrow(() -> new RuntimeException("Animal com ID " + dto.animalId() + " não encontrado."));
        found.setAnimal(animal);
        found.setQuantidadeDiaria(dto.quantidadeDiaria());
        found.setTipoComida(dto.tipoComida());
        return alimentacaoRepository.save(found);
    }

    public void deleteAlimento(Long id) {
        alimentacaoRepository.deleteById(id);
    }
}
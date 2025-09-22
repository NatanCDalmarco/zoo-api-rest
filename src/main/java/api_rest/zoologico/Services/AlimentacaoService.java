package api_rest.zoologico.Services;

import api_rest.zoologico.DTOs.AlimentacaoRequestDTO;
import api_rest.zoologico.Models.Alimentacao;
import api_rest.zoologico.Repositories.AlimentacaoRepository;
import api_rest.zoologico.Models.Animal;
import api_rest.zoologico.Repositories.AnimalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
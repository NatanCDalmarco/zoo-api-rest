package api_rest.zoologico.Services;

import api_rest.zoologico.DTOs.AlimentacaoRequestDTO;
import api_rest.zoologico.DTOs.AnimalRequestDTO;
import api_rest.zoologico.Mapper.AnimalMapper;
import api_rest.zoologico.Models.Alimentacao;
import api_rest.zoologico.Models.Animal;
import api_rest.zoologico.Models.Cuidador;
import api_rest.zoologico.Models.Habitat;
import api_rest.zoologico.Repositories.AnimalRepository;
import api_rest.zoologico.Repositories.CuidadorRepository;
import api_rest.zoologico.Repositories.HabitatRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private HabitatRepository habitatRepository;
    @Autowired
    private CuidadorRepository cuidadorRepository;
    @Autowired
    private AnimalMapper animalMapper;

    public List<Animal> getAll() {
        return animalRepository.findAll();
    }
    public List<Animal> getBySpecies(String especie) {
        return animalRepository.findByEspecieContainingIgnoreCase(especie);
    }
    public List<Animal> getByName(String nome) {
        return animalRepository.findByNomeContainingIgnoreCase(nome);
    }
    public List<Animal> getByAge(Integer idadeMin, Integer idadeMax) {
        return animalRepository.findByIdadeBetween(idadeMin, idadeMax);
    }
    public Animal getById(Long id) {
        return animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal de id " + id + " não encontrado"));
    }

    public Animal update(Long id, AnimalRequestDTO dto) {

        Animal animal = animalRepository.getReferenceById(id);
        Cuidador cuidador = cuidadorRepository.getReferenceById(dto.cuidadorId());
        Habitat habitat = habitatRepository.getReferenceById(dto.cuidadorId();
        animal.setCuidador(cuidador);
        animal.setHabitat(habitat);
        animal.setNome(dto.nome());
        animal.setIdade(dto.idade());
        animal.setEspecie(dto.especie());

        return animal;
    }

    public void delete(Long id) {
        animalRepository.deleteById(id);
    }

    public Animal saveAnimal(AnimalRequestDTO dto) {
        Habitat habitat = habitatRepository.getReferenceById(dto.habitatId());
        Cuidador cuidador = cuidadorRepository.getReferenceById(dto.cuidadorId());
        Animal animal = new Animal(dto, habitat, cuidador);
        animalRepository.save(animal);
        return animal;
    }
}
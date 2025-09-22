package api_rest.zoologico.Services;

import api_rest.zoologico.DTOs.AnimalRequestDTO;
import api_rest.zoologico.Mapper.AnimalMapper;
import api_rest.zoologico.Models.Animal;
import api_rest.zoologico.Models.Cuidador;
import api_rest.zoologico.Models.Habitat;
import api_rest.zoologico.Repositories.AnimalRepository;
import api_rest.zoologico.Repositories.CuidadorRepository;
import api_rest.zoologico.Repositories.HabitatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final HabitatRepository habitatRepository;
    private final CuidadorRepository cuidadorRepository;
    private final AnimalMapper animalMapper;

    public AnimalService(AnimalRepository animalRepository, HabitatRepository habitatRepository, CuidadorRepository cuidadorRepository, AnimalMapper animalMapper) {
        this.animalRepository = animalRepository;
        this.habitatRepository = habitatRepository;
        this.cuidadorRepository = cuidadorRepository;
        this.animalMapper = animalMapper;
    }

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
        return animalRepository.getReferenceById(id);
    }

    public Animal update(Long id, AnimalRequestDTO dto) {
        Animal animal = getById(id);
        animalMapper.updateEntityFromDto(dto, animal);
        return animalRepository.save(animal);
    }

    public void delete(Long id) {
        animalRepository.deleteById(id);
    }

    public Animal create(AnimalRequestDTO dto) {
        Habitat habitat = habitatRepository.findById(dto.habitatId()).orElseThrow(() -> new RuntimeException("Habitat com ID " + dto.habitatId() + " não encontrado."));
        Cuidador cuidador = cuidadorRepository.findById(dto.cuidadorId()).orElseThrow(() -> new RuntimeException("Cuidador com ID " + dto.cuidadorId() + " não encontrado."));
        Animal animal = new Animal(dto, habitat, cuidador);
        return animalRepository.save(animal);
    }
}
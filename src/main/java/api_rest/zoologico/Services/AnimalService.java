package api_rest.zoologico.Services;

import api_rest.zoologico.DTOs.AnimalRequestDTO;
import api_rest.zoologico.Models.Animal;
import api_rest.zoologico.Models.Cuidador;
import api_rest.zoologico.Models.Habitat;
import api_rest.zoologico.Repositories.AnimalRepository;
import api_rest.zoologico.Repositories.CuidadorRepository;
import api_rest.zoologico.Repositories.HabitatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private HabitatRepository habitatRepository;
    @Autowired
    private CuidadorRepository cuidadorRepository;

    public AnimalService(AnimalRepository animalRepository, HabitatRepository habitatRepository, CuidadorRepository cuidadorRepository) {
        this.animalRepository = animalRepository;
        this.habitatRepository = habitatRepository;
        this.cuidadorRepository = cuidadorRepository;
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
        return animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal de id " + id + " não encontrado"));
    }

    public Animal update(Long id, AnimalRequestDTO dto) {

        Animal animal = getById(id);

        if (dto.cuidadorId() != null) {
            Cuidador cuidador = cuidadorRepository.findById(dto.cuidadorId())
                    .orElseThrow(() -> new RuntimeException("Cuidador com ID " + dto.cuidadorId() + " não encontrado."));
            animal.setCuidador(cuidador);
        }
        if(dto.habitatId() != null) {
            Habitat habitat = habitatRepository.findById(dto.habitatId())
                    .orElseThrow(() -> new RuntimeException("Habitat com ID " + dto.habitatId() + " não encontrado."));
            animal.setHabitat(habitat);
        }
        if(dto.nome() != null) animal.setNome(dto.nome());
        animal.setIdade(dto.idade());
        if(dto.especie() != null) animal.setEspecie(dto.especie());

        return animalRepository.save(animal);
    }

    public void delete(Long id) {
        animalRepository.deleteById(id);
    }

    public Animal saveAnimal(AnimalRequestDTO dto) {
        Habitat habitat = habitatRepository.findById(dto.habitatId()).orElseThrow(() -> new RuntimeException("Habitat com ID " + dto.habitatId() + " não encontrado."));
        Cuidador cuidador = cuidadorRepository.findById(dto.cuidadorId()).orElseThrow(() -> new RuntimeException("Cuidador com ID " + dto.cuidadorId() + " não encontrado."));
        Animal animal = new Animal(dto, habitat, cuidador);
        return animalRepository.save(animal);
    }
}
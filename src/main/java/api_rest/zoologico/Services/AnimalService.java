package api_rest.zoologico.Services;

import api_rest.zoologico.DTOs.AnimalRequestDTO;
import api_rest.zoologico.Mapper.AnimalMapper;
import api_rest.zoologico.Models.Animal;
import api_rest.zoologico.Models.Cuidador;
import api_rest.zoologico.Models.Habitat;
import api_rest.zoologico.Repositories.AnimalRepository;
import api_rest.zoologico.Repositories.CuidadorRepository;
import api_rest.zoologico.Repositories.HabitatRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final HabitatRepository habitatRepository;
    private final CuidadorRepository cuidadorRepository;
    private final AnimalMapper animalMapper;

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

    public Animal create(AnimalRequestDTO dto) {
        Habitat habitat = habitatRepository.findById(dto.getHabitatId())
                .orElseThrow(() -> new EntityNotFoundException("Habitat não encontrado: " + dto.getHabitatId()));

        if (animalRepository.countByHabitatId(habitat.getId()) >= habitat.getCapacidadeMaxima()) {
            throw new IllegalStateException("Habitat com capacidade máxima atingida.");
        }

        Cuidador cuidador = cuidadorRepository.findById(dto.getCuidadorId())
                .orElseThrow(() -> new EntityNotFoundException("Cuidador não encontrado: " + dto.getCuidadorId()));

        Animal animal = animalMapper.toEntity(dto);
        animal.setHabitat(habitat);
        animal.setCuidador(cuidador);

        return animalRepository.save(animal);
    }

    public Optional<Animal> update(Long id, AnimalRequestDTO dto) {
        return animalRepository.findById(id).map(animalExistente -> {
            Habitat habitat = habitatRepository.findById(dto.getHabitatId())
                    .orElseThrow(() -> new EntityNotFoundException("Habitat não encontrado: " + dto.getHabitatId()));
            Cuidador cuidador = cuidadorRepository.findById(dto.getCuidadorId())
                    .orElseThrow(() -> new EntityNotFoundException("Cuidador não encontrado: " + dto.getCuidadorId()));

            animalMapper.updateEntityFromDto(dto, animalExistente);
            animalExistente.setHabitat(habitat);
            animalExistente.setCuidador(cuidador);

            return animalRepository.save(animalExistente);
        });
    }

    public void delete(Long id) {
        Animal animal = getById(id);
        animalRepository.delete(animal);
    }
}
package api_rest.zoologico.Repositories;

import api_rest.zoologico.Models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findByEspecieContainingIgnoreCase(String especie);

    List<Animal> findByNomeContainingIgnoreCase(String nome);

    List<Animal> findByIdadeBetween(Integer idadeMin, Integer idadeMax);

    long countByHabitatId(Long habitatId);
}
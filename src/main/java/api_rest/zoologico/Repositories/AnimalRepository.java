package api_rest.zoologico.Repositories;

import api_rest.zoologico.Models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
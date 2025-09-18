package api_rest.zoologico.repository;

import api_rest.zoologico.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository; // Import necessário!

public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
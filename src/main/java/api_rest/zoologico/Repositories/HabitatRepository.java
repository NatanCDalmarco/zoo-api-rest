package api_rest.zoologico.Repositories;

import api_rest.zoologico.Models.Habitat;
import api_rest.zoologico.Models.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitatRepository extends JpaRepository<Habitat, Long> {
    List<Habitat> findByTipo(Tipo tipo);
}

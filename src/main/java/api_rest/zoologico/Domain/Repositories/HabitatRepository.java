package api_rest.zoologico.Domain.Repositories;

import api_rest.zoologico.Domain.Models.Habitat;
import api_rest.zoologico.Domain.Models.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitatRepository extends JpaRepository<Habitat, Long> {
    List<Habitat> findByTipo(Tipo tipo);
}

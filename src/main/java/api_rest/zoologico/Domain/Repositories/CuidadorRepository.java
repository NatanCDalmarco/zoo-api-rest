package api_rest.zoologico.Domain.Repositories;

import api_rest.zoologico.Domain.Models.Cuidador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CuidadorRepository extends JpaRepository<Cuidador, Long> {

    List<Cuidador> findByEspecialidadeOrTurno(String especialidade, String turno);

    List<Cuidador> findByEspecialidade(String especialidade);

    List<Cuidador> findByTurno(String turno);
}

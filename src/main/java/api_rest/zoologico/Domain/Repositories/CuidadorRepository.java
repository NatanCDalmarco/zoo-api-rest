package api_rest.zoologico.Domain.Repositories;

import api_rest.zoologico.Domain.Models.Cuidador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CuidadorRepository extends JpaRepository<Cuidador, Long> {

    // buscar por especialidade ou turno
    List<Cuidador> findByEspecialidadeOrTurno(String especialidade, String turno);

    // buscar por especialidade
    List<Cuidador> findByEspecialidade(String especialidade);

    // buscar por turno
    List<Cuidador> findByTurno(String turno);
}

package api_rest.zoologico.Domain.Repositories;

import api_rest.zoologico.Domain.Models.EspecialidadeVeterinario;
import api_rest.zoologico.Domain.Models.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario,Long>{
    public List<Veterinario> findByEspecialidadeVeterinario(EspecialidadeVeterinario especialidadeVeterinario);
}

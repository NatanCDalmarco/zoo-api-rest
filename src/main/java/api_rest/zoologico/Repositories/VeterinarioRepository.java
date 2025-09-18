package api_rest.zoologico.Repositories;

import api_rest.zoologico.Models.EspecialidadeVeterinario;
import api_rest.zoologico.Models.Veterinario;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario,Long>{
    public List<Veterinario> findByEspecialidadeVeterinario(EspecialidadeVeterinario especialidadeVeterinario);
}

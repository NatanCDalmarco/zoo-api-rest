package api_rest.zoologico.Services;

import api_rest.zoologico.DTOs.VeterinarioDTO;
import api_rest.zoologico.Mapper.VeterinarioMapper;
import api_rest.zoologico.Models.EspecialidadeVeterinario;
import api_rest.zoologico.Models.Veterinario;
import api_rest.zoologico.Repositories.VeterinarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarioService {
    private final VeterinarioRepository veterinarioRepository;
    private final VeterinarioMapper veterinarioMapper;

    public VeterinarioService(VeterinarioRepository veterinarioRepository, VeterinarioMapper veterinarioMapper) {
        this.veterinarioRepository = veterinarioRepository;
        this.veterinarioMapper = veterinarioMapper;
    }

    public List<Veterinario> getAll() {
        return veterinarioRepository.findAll();
    }
        
    public Veterinario findById(Long id) {
        return veterinarioRepository.findById(id).orElseThrow(()-> new RuntimeException("Não há Veterinário com esse ID: " + id));
    }

    public List<Veterinario> getByEspecialidade(EspecialidadeVeterinario especialidadeVeterinario) {
        return veterinarioRepository.findByEspecialidadeVeterinario(especialidadeVeterinario);
    }

    public Veterinario update(Long id, VeterinarioDTO dto) {
        Veterinario veterinario = findById(id);
        veterinarioMapper.updateEntityFromDto(dto, veterinario);
        return veterinarioRepository.save(veterinario);
    }

    public Veterinario create(VeterinarioDTO dto){
        Veterinario veterinario = new Veterinario(dto);
        return veterinarioRepository.save(veterinario);
    }

    public void delete(Long id) {
        veterinarioRepository.deleteById(id);
    }
}

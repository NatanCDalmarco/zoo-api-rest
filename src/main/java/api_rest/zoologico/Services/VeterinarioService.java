package api_rest.zoologico.Services;

import api_rest.zoologico.DTOs.VeterinarioDTO;
import api_rest.zoologico.Models.EspecialidadeVeterinario;
import api_rest.zoologico.Models.Veterinario;
import api_rest.zoologico.Repositories.VeterinarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarioService {
    private final VeterinarioRepository veterinarioRepository;

    public VeterinarioService(VeterinarioRepository veterinarioRepository) {
        this.veterinarioRepository = veterinarioRepository;
    }

    public List<Veterinario> listarVeterinarios() {
        return veterinarioRepository.findAll();
    }
        
    public Veterinario buscarVeterinarioPorID(Long id) {
        return veterinarioRepository.findById(id).orElseThrow(()-> new RuntimeException("Não há Veterinário com esse ID: " + id));
    }

    public List<Veterinario> buscarVeterinarioPorEspecializacao (EspecialidadeVeterinario especialidadeVeterinario) {
        return veterinarioRepository.findByEspecialidadeVeterinario(especialidadeVeterinario);
    }

    public Veterinario atualizarVeterinario(Long id, VeterinarioDTO veterinario) {
        Veterinario veterinarioAtualizado = buscarVeterinarioPorID(id);
        if (veterinario.nome() != null) veterinarioAtualizado.setNome(veterinario.nome());
        if (veterinario.crvm() != null) veterinarioAtualizado.setCRVM(veterinario.crvm());
        if (veterinario.especialidade() != null) veterinarioAtualizado.setEspecialidadeVeterinario(veterinario.especialidade());

        return veterinarioRepository.save(veterinarioAtualizado);
    }

    public Veterinario cadastrarVeterinario(VeterinarioDTO veterinario){
        if (veterinario.crvm() ==  null || veterinario.crvm().isBlank()){
            throw new RuntimeException("O CRVM deve seer obrigatório!");
        }
        Veterinario vet = new Veterinario(veterinario);

        return veterinarioRepository.save(vet);
    }

    public void removerVeterinario(Long id) {
        veterinarioRepository.deleteById(id);
    }
}

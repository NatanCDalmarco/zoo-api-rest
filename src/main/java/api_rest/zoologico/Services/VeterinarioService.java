package api_rest.zoologico.Services;

import api_rest.zoologico.DTOs.VeterinarioDTO;
import api_rest.zoologico.Models.EspecialidadeVeterinario;
import api_rest.zoologico.Models.Veterinario;
import api_rest.zoologico.Repositories.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarioService {
    @Autowired
    private VeterinarioRepository veterinarioRepository;

    public List<Veterinario> listarVeterinarios() {
        return veterinarioRepository.findAll();
    }
        
    public Veterinario buscarVeterinarioPorID(Long id) {
        return veterinarioRepository.findById(id).orElseThrow(()-> new RuntimeException("Não há Veterianario com esse ID"));
    }

    public List<Veterinario> buscarVeterinarioPorEspecializacao (EspecialidadeVeterinario especialidadeVeterinario) {
        return veterinarioRepository.findByEspecialidadeVeterinario(especialidadeVeterinario);
    }

    public Veterinario atualizarVeterinario(Long id, VeterinarioDTO veterinario) {
        Veterinario veterinarioAtulizado = buscarVeterinarioPorID(id);
        veterinarioAtulizado.setNome(veterinario.nome());
        veterinarioAtulizado.setEspecialidadeVeterinario(veterinario.especialidade());
        return  veterinarioRepository.save(veterinarioAtulizado);
    }

    public Veterinario cadastrarVeterinario(VeterinarioDTO veterinario){
        if (veterinario.crvm() ==  null){
            throw new RuntimeException("O CRVM deve seer obrigatório!");
        }
        Veterinario vet = new Veterinario(veterinario);

        return veterinarioRepository.save(vet);
    }

    public void removerVeterinario(Long id) {
        veterinarioRepository.deleteById(id);
    }
}

package api_rest.zoologico.Controllers;

import api_rest.zoologico.DTOs.VeterinarioDTO;
import api_rest.zoologico.Models.EspecialidadeVeterinario;
import api_rest.zoologico.Models.Veterinario;
import api_rest.zoologico.Services.VeterinarioService;
import jakarta.servlet.ServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/veterinarios")
public class VeterinarioController {
    @Autowired
    VeterinarioService veterinarioService;

    public VeterinarioController(VeterinarioService veterinarioService) {
        this.veterinarioService = veterinarioService;
    }

    @GetMapping
    public List<Veterinario> findAll() {
        return veterinarioService.listarVeterinarios();
    }

    @GetMapping("especialidade/{especialidade}")
    public ResponseEntity<?> findByEspecialidade(@PathVariable String especialidade) {
        try {
            EspecialidadeVeterinario enumEspecialidade = EspecialidadeVeterinario.valueOf(especialidade.toUpperCase());
            List<Veterinario> veterinarios = veterinarioService.buscarVeterinarioPorEspecializacao(enumEspecialidade);
            return ResponseEntity.ok(veterinarios);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(
                    "Especialidade inválida: " + especialidade +
                            ". Especialidades válidas são: " + Arrays.toString(EspecialidadeVeterinario.values())
            );
        }
    }


    @GetMapping("{id}")
    public Veterinario buscarPorID(@PathVariable Long id) {
        return veterinarioService.buscarVeterinarioPorID(id);
    }

    @PutMapping("{id}")
    public Veterinario updateVeterinario(@PathVariable Long id, @RequestBody VeterinarioDTO veterinario) {
        return veterinarioService.atualizarVeterinario(id, veterinario);
    }

    @PostMapping
    public Veterinario salvar(@RequestBody VeterinarioDTO veterinario) {
        return veterinarioService.cadastrarVeterinario(veterinario);
    }

    @DeleteMapping("{id}")
    public void deletarVeterinario(@PathVariable Long id) {
        veterinarioService.removerVeterinario(id);
    }
}

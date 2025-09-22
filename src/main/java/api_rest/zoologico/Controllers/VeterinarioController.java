package api_rest.zoologico.Controllers;

import api_rest.zoologico.DTOs.VeterinarioDTO;
import api_rest.zoologico.Models.EspecialidadeVeterinario;
import api_rest.zoologico.Models.Veterinario;
import api_rest.zoologico.Services.VeterinarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veterinarios")
public class VeterinarioController {

    private final VeterinarioService veterinarioService;

    public VeterinarioController(VeterinarioService veterinarioService) {
        this.veterinarioService = veterinarioService;
    }

    @GetMapping
    public ResponseEntity<List<Veterinario>> findAll() {
        return ResponseEntity.ok().body(veterinarioService.getAll());
    }

    @GetMapping("especialidade/{data}")
    public ResponseEntity<?> findByEspecialidade(@PathVariable String data) {
        EspecialidadeVeterinario especialidade = EspecialidadeVeterinario.valueOf(data.toUpperCase());
        return ResponseEntity.ok(veterinarioService.getByEspecialidade(especialidade));
    }

    @GetMapping("{id}")
    public Veterinario findById(@PathVariable Long id) {
        return veterinarioService.findById(id);
    }

    @PutMapping("{id}")
    public Veterinario update(@PathVariable Long id, @RequestBody VeterinarioDTO data) {
        return veterinarioService.update(id, data);
    }

    @PostMapping
    public Veterinario create(@RequestBody VeterinarioDTO data) {
        return veterinarioService.create(data);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        veterinarioService.delete(id);
    }
}

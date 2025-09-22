package api_rest.zoologico.Controllers;

import api_rest.zoologico.DTOs.CuidadorRequestDTO;
import api_rest.zoologico.Models.Cuidador;
import api_rest.zoologico.Services.CuidadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuidadores")
@RequiredArgsConstructor
public class CuidadorController {

    private final CuidadorService cuidadorService;

    @GetMapping
    @RequestMapping("/turno")
    public ResponseEntity<List<Cuidador>> listByTurno(@RequestParam(required = true) String turno) {
        return ResponseEntity.ok().body(cuidadorService.getByTurno(turno));
    }

    @GetMapping
    @RequestMapping("/especilidade")
    public ResponseEntity<List<Cuidador>> listByEspeciaidade(@RequestParam(required = true) String especialidade) {
        return ResponseEntity.ok().body(cuidadorService.getByEspecialidade(especialidade));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuidador> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(cuidadorService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Cuidador> create(@RequestBody Cuidador cuidador) {
        return ResponseEntity.ok().body(cuidadorService.create(cuidador));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cuidador> update(@PathVariable Long id, @RequestBody CuidadorRequestDTO cuidador) {
        cuidadorService.atualizar(id, cuidador);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        cuidadorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

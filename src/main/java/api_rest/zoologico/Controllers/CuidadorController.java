package api_rest.zoologico.Controllers;

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
    public List<Cuidador> listar(
            @RequestParam(required = false) String especialidade,
            @RequestParam(required = false) String turno
    ) {
        return cuidadorService.listar(especialidade, turno);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuidador> buscarPorId(@PathVariable Long id) {
        return cuidadorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cuidador criar(@RequestBody Cuidador cuidador) {
        return cuidadorService.criar(cuidador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cuidador> atualizar(@PathVariable Long id, @RequestBody Cuidador cuidador) {
        return cuidadorService.atualizar(id, cuidador)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        String mensagem = cuidadorService.deletar(id);

        if (mensagem.contains("não encontrado")) {
            return ResponseEntity.status(404).body(mensagem);
        }
        return ResponseEntity.ok(mensagem);
    }
}

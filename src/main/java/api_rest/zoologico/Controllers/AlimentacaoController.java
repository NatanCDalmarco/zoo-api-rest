package api_rest.zoologico.Controllers;

import api_rest.zoologico.DTOs.AlimentacaoRequestDTO;
import api_rest.zoologico.DTOs.AlimentacaoResponseDTO;
import api_rest.zoologico.Services.AlimentacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alimentacoes")
public class AlimentacaoController {

    @Autowired
    private AlimentacaoService alimentacaoService;

    @PostMapping
    public ResponseEntity<AlimentacaoResponseDTO> criar(@RequestBody AlimentacaoRequestDTO dto) {
        try {
            AlimentacaoResponseDTO novaAlimentacao = alimentacaoService.criar(dto);
            return new ResponseEntity<>(novaAlimentacao, HttpStatus.CREATED); // 201 Created
        } catch (RuntimeException e) {
            // Captura exceção do Service (ex: Animal não encontrado)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // 400 Bad Request
        }
    }

    @GetMapping
    public ResponseEntity<List<AlimentacaoResponseDTO>> listar(
            @RequestParam(required = false) String tipoComida,
            @RequestParam(required = false) Long animalId) {

        if (tipoComida != null) {
            return ResponseEntity.ok(alimentacaoService.buscarPorTipoComida(tipoComida));
        }
        if (animalId != null) {
            return ResponseEntity.ok(alimentacaoService.buscarPorAnimalId(animalId));
        }
        return ResponseEntity.ok(alimentacaoService.listarTodos()); // 200 OK
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlimentacaoResponseDTO> atualizar(@PathVariable Long id, @RequestBody AlimentacaoRequestDTO dto) {
        try {
            AlimentacaoResponseDTO atualizada = alimentacaoService.atualizar(id, dto);
            return ResponseEntity.ok(atualizada); // 200 OK
        } catch (RuntimeException e) {
            // Se a Alimentação ou o Animal referenciado não for encontrado
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            alimentacaoService.deletar(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (RuntimeException e) {
            // Se o ID não for encontrado
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
}
package api_rest.zoologico.Controllers;

import api_rest.zoologico.DTOs.AnimalRequestDTO;
import api_rest.zoologico.Models.Animal;
import api_rest.zoologico.Services.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/animals")
@RequiredArgsConstructor
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public ResponseEntity<List<Animal>> getAll() {
        List<Animal> animais = animalService.getAll();
        return ResponseEntity.ok().body(animais);
    }

    @GetMapping("/species")
    public ResponseEntity<List<Animal>> getBySpecies(@RequestParam String value) {
        List<Animal> animais = animalService.getBySpecies(value);
        return ResponseEntity.ok().body(animais);
    }

    @GetMapping("/name")
    public ResponseEntity<List<Animal>> getByName(@RequestParam String value) {
        List<Animal> animais = animalService.getByName(value);
        return ResponseEntity.ok().body(animais);
    }

    @GetMapping("/age")
    public ResponseEntity<List<Animal>> getByAge(
            @RequestParam Integer min,
            @RequestParam Integer max) {
        List<Animal> animais = animalService.getByAge(min, max);
        return ResponseEntity.ok().body(animais);
    }

    @GetMapping("/{id}")
    public Animal getById(@PathVariable Long id) {
        return animalService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Animal> create(@RequestBody AnimalRequestDTO dto) {
        return ResponseEntity.ok().body(animalService.saveAnimal(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> update(@PathVariable Long id, @RequestBody AnimalRequestDTO dto) {
        return ResponseEntity.ok().body(animalService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            animalService.delete(id);
            return ResponseEntity.ok("Animal deletado com sucesso.");
        } catch (Exception e) {
            return buildErrorResponse("Animal não encontrado", e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    private ResponseEntity<Map<String, Object>> buildErrorResponse(String error, String message, HttpStatus status) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("status", status.value());
        body.put("error", error);
        body.put("message", message);
        return ResponseEntity.status(status).body(body);
    }
}
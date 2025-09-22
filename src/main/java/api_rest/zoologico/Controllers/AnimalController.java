package api_rest.zoologico.Controllers;

import api_rest.zoologico.DTOs.AnimalRequestDTO;
import api_rest.zoologico.Models.Animal;
import api_rest.zoologico.Services.AnimalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public ResponseEntity<List<Animal>> getAll() {
        return ResponseEntity.ok().body(animalService.getAll());
    }

    @GetMapping("/species")
    public ResponseEntity<List<Animal>> getBySpecies(@RequestParam String data) {
        return ResponseEntity.ok().body(animalService.getBySpecies(data));
    }

    @GetMapping("/name")
    public ResponseEntity<List<Animal>> getByName(@RequestParam String data) {
        return ResponseEntity.ok().body(animalService.getByName(data));
    }

    @GetMapping("/age")
    public ResponseEntity<List<Animal>> getByAge(
            @RequestParam Integer min,
            @RequestParam Integer max) {
        return ResponseEntity.ok().body(animalService.getByAge(min, max));
    }

    @GetMapping("/{id}")
    public Animal getById(@PathVariable Long id) {
        return animalService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Animal> create(@RequestBody AnimalRequestDTO data) {
        return ResponseEntity.ok().body(animalService.create(data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> update(@PathVariable Long id, @RequestBody AnimalRequestDTO data) {
        return ResponseEntity.ok().body(animalService.update(id, data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
            animalService.delete(id);
            return ResponseEntity.noContent().build();
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
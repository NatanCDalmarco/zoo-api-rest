package api_rest.zoologico.Controllers;


import api_rest.zoologico.DTOs.HabitatDto;
import api_rest.zoologico.Models.Habitat;
import api_rest.zoologico.Models.Tipo;
import api_rest.zoologico.Services.HabitatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/habitats")
public class HabitatController {
    private final HabitatService habitatService;

    public HabitatController(HabitatService habitatService) {
        this.habitatService = habitatService;
    }

    @GetMapping
    public ResponseEntity<List<Habitat>> getAll() {
        return ResponseEntity.ok().body(habitatService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habitat> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(habitatService.getById(id));
    }

    @GetMapping("/tipo")
    public ResponseEntity<List<Habitat>> getByTipo(@RequestParam Tipo tipo) {
        return ResponseEntity.ok().body(habitatService.getByTipo(tipo));
    }

    @PostMapping
    public ResponseEntity<Habitat> create(@RequestBody HabitatDto habitatDto) {
        return ResponseEntity.ok().body(habitatService.create(habitatDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habitat> update(@RequestBody HabitatDto habitatDto, @PathVariable Long id) {
        return ResponseEntity.ok().body(habitatService.update(id, habitatDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }

    private ResponseEntity<Map<String, Object>> buildErrorResponse(String error, String message, HttpStatus status) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("status", status);
        body.put("error", error);
        body.put("message", message);

        return ResponseEntity.status(status).body(body);
    }
}

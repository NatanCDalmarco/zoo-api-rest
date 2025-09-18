package api_rest.zoologico.Controller;


import api_rest.zoologico.Dtos.HabitatDto;
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

    @Autowired
    public HabitatController(HabitatService habitatService) {
        this.habitatService = habitatService;
    }

    @GetMapping
    public List<Habitat> getAll() {
        return habitatService.getAll();
    }

    @GetMapping("/{id}")
    public Habitat getById(@PathVariable Long id) {
        return habitatService.getById(id);
    }

    @PostMapping
    public Habitat create(@RequestBody HabitatDto habitatDto) {
        return habitatService.create(habitatDto);
    }

    @PutMapping("/{id}")
    public Habitat update(@RequestBody HabitatDto habitatDto,  @PathVariable Long id) {
        return habitatService.update(id, habitatDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            habitatService.delete(id);
            return ResponseEntity.ok("Habitat deleted successfully");
        } catch (Exception e) {
            return buildErrorResponse("Can't delete inexistent Habitat", e.getMessage(), HttpStatus.NOT_FOUND);
        }
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

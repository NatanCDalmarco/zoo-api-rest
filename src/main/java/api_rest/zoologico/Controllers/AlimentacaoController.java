package api_rest.zoologico.Controllers;

import api_rest.zoologico.DTOs.AlimentacaoRequestDTO;
import api_rest.zoologico.Models.Alimentacao;
import api_rest.zoologico.Services.AlimentacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alimentacoes")
public class AlimentacaoController {

    @Autowired
    private AlimentacaoService alimentacaoService;

    @PostMapping
    public ResponseEntity postAlimento(@RequestBody AlimentacaoRequestDTO alimentacao){
        alimentacaoService.salvarALimento(alimentacao);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<List<Alimentacao>> getAllAlimento(){
        return ResponseEntity.ok().body(alimentacaoService.listarAlimentos());
    }
    @PutMapping("/{id}")
    public ResponseEntity putAlimento(@RequestBody AlimentacaoRequestDTO dto, @PathVariable Long id){
        return ResponseEntity.ok().body(alimentacaoService.updateAlimento(dto, id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteAlimento(@PathVariable Long id){
        alimentacaoService.deleteAlimento(id);
        return ResponseEntity.ok().build();
    }
}
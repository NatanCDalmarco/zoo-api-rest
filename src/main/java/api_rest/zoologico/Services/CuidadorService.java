package api_rest.zoologico.Services;

import api_rest.zoologico.DTOs.CuidadorRequestDTO;
import api_rest.zoologico.Models.Cuidador;
import api_rest.zoologico.Repositories.CuidadorRepository;import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuidadorService {

    @Autowired
    private  CuidadorRepository cuidadorRepository;

    public void criar(CuidadorRequestDTO dto) {
        Cuidador cuidador = new Cuidador(dto);
        try {
            Cuidador salvo = cuidadorRepository.save(cuidador);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro no dados enviados: " + e);
        }

    }

    // Listar com filtros
    public List<Cuidador> listar(String especialidade, String turno) {
        if (especialidade != null && turno != null) {
            return cuidadorRepository.findByEspecialidadeOrTurno(especialidade, turno);
        }
        if (especialidade != null) {
            return cuidadorRepository.findByEspecialidade(especialidade);
        }
        if (turno != null) {
            return cuidadorRepository.findByTurno(turno);
        }
        return cuidadorRepository.findAll();
    }

    // buscar por Id
    public Optional<Cuidador> buscarPorId(Long id) {
        return cuidadorRepository.findById(id);
    }

    // criar cuidador
    public Cuidador criar(Cuidador cuidador) {
        return cuidadorRepository.save(cuidador);
    }

    // atualizar cuidador
    public Optional<Cuidador> atualizar(Long id, Cuidador cuidador) {
        return cuidadorRepository.findById(id).map(c -> {
            cuidador.setId(id);
            return cuidadorRepository.save(cuidador);
        });
    }

    // deletar cuidador
    public String deletar(Long id) {
        return cuidadorRepository.findById(id).map(c -> {
            cuidadorRepository.deleteById(id);
            return "Cuidador " + c.getNome() + " (ID: " + id + ") foi excluído com sucesso.";
        }).orElse("Cuidador com ID " + id + " não encontrado.");
    }
}

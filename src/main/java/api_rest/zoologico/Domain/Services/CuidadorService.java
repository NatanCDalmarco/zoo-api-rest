package api_rest.zoologico.Domain.Services;

import api_rest.zoologico.Application.DTOs.CuidadorRequestDTO;
import api_rest.zoologico.Infra.Mapper.CuidadorMapper;
import api_rest.zoologico.Domain.Models.Cuidador;
import api_rest.zoologico.Domain.Repositories.CuidadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuidadorService {

    private final CuidadorRepository cuidadorRepository;
    private final CuidadorMapper cuidadorMapper;

    public CuidadorService(CuidadorRepository cuidadorRepository, CuidadorMapper cuidadorMapper) {
        this.cuidadorRepository = cuidadorRepository;
        this.cuidadorMapper = cuidadorMapper;
    }

    public Cuidador create(CuidadorRequestDTO dto) {
        Cuidador cuidador = new Cuidador(dto);
        return cuidadorRepository.save(cuidador);
    }

    public List<Cuidador> getByTurno(String turno) {
        return cuidadorRepository.findByTurno(turno);
    }
    public List<Cuidador> getAll() {
        return cuidadorRepository.findAll();
    }
    public List<Cuidador> getByEspecialidade(String especialidade) {
        return cuidadorRepository.findByEspecialidade(especialidade);
    }
    public Cuidador getById(Long id) {
        return cuidadorRepository.getReferenceById(id);
    }
    public Cuidador create(Cuidador cuidador) {
        return cuidadorRepository.save(cuidador);
    }
    public Cuidador update(Long id, CuidadorRequestDTO dto) {
        Cuidador cuidador = cuidadorRepository.getReferenceById(id);
        cuidadorMapper.updateEntityFromDto(dto, cuidador);
        return cuidadorRepository.save(cuidador);
    }
    public void deletar(Long id) {
        Cuidador cuidador = cuidadorRepository.findById(id).orElseThrow();
        cuidadorRepository.delete(cuidador);
    }
}

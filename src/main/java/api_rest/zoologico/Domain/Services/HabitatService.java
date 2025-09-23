package api_rest.zoologico.Domain.Services;

import api_rest.zoologico.Application.DTOs.HabitatDto;
import api_rest.zoologico.Infra.Mapper.HabitatMapper;
import api_rest.zoologico.Domain.Models.Habitat;
import api_rest.zoologico.Domain.Models.Tipo;
import api_rest.zoologico.Domain.Repositories.HabitatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitatService {
    private final HabitatRepository habitatRepository;
    private final HabitatMapper habitatMapper;

    public HabitatService(HabitatRepository habitatRepository, HabitatMapper habitatMapper) {
        this.habitatRepository = habitatRepository;
        this.habitatMapper = habitatMapper;
    }

    public Habitat getById(Long id) {
        return habitatRepository.findById(id).orElseThrow(() -> new RuntimeException("Habitat de id " + id + " não encontrado"));
    }

    public List<Habitat> getAll() {
        return habitatRepository.findAll();
    }

    public List<Habitat> getByTipo(Tipo tipo) {
        return habitatRepository.findByTipo(tipo);
    }

    public Habitat create(HabitatDto habitatDto) {
        Habitat habitat = habitatMapper.toEntity(habitatDto);
        return habitatRepository.save(habitat);
    }

    public Habitat update(Long id,HabitatDto habitatDto) {
        Habitat habitat = getById(id);
        habitatMapper.updateEntityFromDto(habitatDto, habitat);
        return habitatRepository.save(habitat);
    }

    public void delete(Long id) {
        Habitat habitat = getById(id);
        habitatRepository.delete(habitat);
    }
}

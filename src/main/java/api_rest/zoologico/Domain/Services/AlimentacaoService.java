package api_rest.zoologico.Domain.Services;

import api_rest.zoologico.Application.DTOs.AlimentacaoRequestDTO;
import api_rest.zoologico.Domain.Models.Cuidador;
import api_rest.zoologico.Infra.Mapper.AlimentacaoMapper;
import api_rest.zoologico.Domain.Models.Alimentacao;
import api_rest.zoologico.Domain.Repositories.AlimentacaoRepository;
import api_rest.zoologico.Domain.Models.Animal;
import api_rest.zoologico.Domain.Repositories.AnimalRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlimentacaoService {
    private final AlimentacaoRepository alimentacaoRepository;
    private final AnimalRepository animalRepository;
    private final AlimentacaoMapper alimentacaoMapper;
    private final EmailService emailService;

    public AlimentacaoService(AlimentacaoRepository alimentacaoRepository, AnimalRepository animalRepository, AlimentacaoMapper alimentacaoMapper, EmailService emailService) {
        this.alimentacaoRepository = alimentacaoRepository;
        this.animalRepository = animalRepository;
        this.alimentacaoMapper = alimentacaoMapper;
        this.emailService = emailService;
    }

    public Alimentacao create(AlimentacaoRequestDTO dto) {
        Animal animal = animalRepository.findById(dto.animalId())
                .orElseThrow(() -> new RuntimeException("Animal com ID " + dto.animalId() + " não encontrado."));

        Alimentacao alimentacao = new Alimentacao(dto, animal);
        Alimentacao novaAlimentacao = alimentacaoRepository.save(alimentacao);

        Cuidador cuidador = animal.getCuidador();
        if (cuidador != null && cuidador.getEmail() != null && !cuidador.getEmail().isEmpty()) {
            String nomeAnimal = animal.getNome();
            String nomeCuidador = cuidador.getNome();
            String emailCuidador = cuidador.getEmail();

            String assunto = "Nova Alimentação Cadastrada para " + nomeAnimal;
            String corpo = String.format(
                    "Olá %s,\n\nUma nova rotina de alimentação foi cadastrada para o animal '%s' (espécie: %s), que está sob seus cuidados.\n\nDetalhes:\n- Comida: %s\n- Quantidade Diária: %s\n\nAtt,\nZoológico WBLNF.",
                    nomeCuidador,
                    nomeAnimal,
                    animal.getEspecie(),
                    novaAlimentacao.getTipoComida(),
                    novaAlimentacao.getQuantidadeDiaria().toString()
            );

            emailService.enviarEmail(emailCuidador, assunto, corpo);
        }

        return novaAlimentacao;
    }

    public List<Alimentacao> getAll() {
        return alimentacaoRepository.findAll();
    }

    public Alimentacao update(AlimentacaoRequestDTO dto, Long id) {
        Alimentacao alimentacao = alimentacaoRepository.getReferenceById(id);
        alimentacaoMapper.updateEntityFromDto(dto, alimentacao);
        return alimentacaoRepository.save(alimentacao);
    }

    public void delete(Long id) {
        Alimentacao alimentacao = alimentacaoRepository.getReferenceById(id);
        alimentacaoRepository.delete(alimentacao);
    }
}
package api_rest.zoologico.Domain.Repositories;

import api_rest.zoologico.Domain.Models.Alimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlimentacaoRepository extends JpaRepository<Alimentacao, Long> {

     List<Alimentacao> findByTipoComidaContainingIgnoreCase(String tipoComida);

    List<Alimentacao> findByAnimalId(Long animalId);
}
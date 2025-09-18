package api_rest.zoologico.repository;

import api_rest.zoologico.entity.Alimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlimentacaoRepository extends JpaRepository<Alimentacao, Long> {

     List<Alimentacao> findByTipoComidaContainingIgnoreCase(String tipoComida);

    List<Alimentacao> findByAnimalId(Long animalId);
}
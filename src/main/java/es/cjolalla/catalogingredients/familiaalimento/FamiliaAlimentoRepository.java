package es.cjolalla.catalogingredients.familiaalimento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamiliaAlimentoRepository extends JpaRepository<FamiliaAlimento, Long>{

	
}

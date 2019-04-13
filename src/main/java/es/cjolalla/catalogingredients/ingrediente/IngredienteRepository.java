package es.cjolalla.catalogingredients.ingrediente;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente,Long>{
	
	Ingrediente findByNombre(String nombre);
	
	@Query("SELECT ing FROM Ingrediente ing WHERE ing.precio <= (:precio)")
	List<Ingrediente> findByPrecioMenor(@Param("precio") BigDecimal precio);
}

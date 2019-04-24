package es.cjolalla.catalogingredients.ingrediente;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//RevisionRepository viene de hibernate envers para poder acceder a la informacion de revisiones (incluye metodos) (creo que el tercer generics es el tipo de id de la revision)
@Repository
public interface IngredienteRepository extends RevisionRepository<Ingrediente,Long, Long>, JpaRepository<Ingrediente,Long>{
	
	Ingrediente findByNombre(String nombre);
	
	@Query("SELECT ing FROM Ingrediente ing WHERE ing.precio <= (:precio)")
	List<Ingrediente> findByPrecioMenor(@Param("precio") BigDecimal precio);
}

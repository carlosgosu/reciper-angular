package es.cjolalla.catalogingredients.usuarios;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	//Cargar directamente lo que enlaza el atributo permisos de Usuario (si no se cargarian LAZY lo que daria una lazy initialization si se hace fuera de un transactional)
	@EntityGraph(attributePaths= {"permisos"})
	Usuario findByUsuario(String name);
	
	
	@EntityGraph(value="usuario.perfilesPermisos", type = EntityGraph.EntityGraphType.LOAD)
	Usuario findDistinctByUsuario(String name);
}

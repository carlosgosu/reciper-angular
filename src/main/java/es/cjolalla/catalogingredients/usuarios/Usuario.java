package es.cjolalla.catalogingredients.usuarios;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
//Mejor usarlo en consultas ad-hoc especificas
//@NamedEntityGraph(
//		name="usuarioConPermisos",
//		attributeNodes = @NamedAttributeNode("permisos"))
public class Usuario {

	@Id
	private String usuario;
	
	private String password;
	
	private String email;
	
	private String nombre;
	
	@ManyToMany
	@JoinTable(
			  name = "usuario_permiso", 
			  joinColumns = @JoinColumn(name = "usuario"), 
			  inverseJoinColumns = @JoinColumn(name = "idPermiso"))
	private Set<Permiso> permisos = new HashSet<>();

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(Set<Permiso> permisos) {
		this.permisos = permisos;
	}

}

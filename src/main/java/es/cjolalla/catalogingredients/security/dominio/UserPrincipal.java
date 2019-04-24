package es.cjolalla.catalogingredients.security.dominio;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import es.cjolalla.catalogingredients.usuarios.Usuario;

/**
 * Esta calse sera el wrapper de Usuario para que este pase como UserDetails que necesita Spring security como Principal
 * @author carlosgosu
 *
 */
public class UserPrincipal implements UserDetails{

	private static final long serialVersionUID = 6381132512941377080L;
	
	private Usuario usuario;
	private Set<GrantedAuthority> permisos = new HashSet<>();
	private PerfilGrantedAuthority perfil;
	
	//En la creacion del Principal ya obtenemos todos los permisos que tiene via directa o asociados a su perfil
	public UserPrincipal(Usuario user) {
		this.usuario = user;
		//Hago un stream de la lista de permisos y segun lo voy recorriendo voy llamando al new PermisoGrantedAuthority(permiso) siendo permiso cada uno de los permisos del stream 
		Set<GrantedAuthority> permisosDirectos = user.getPermisos().stream().map(PermisoGrantedAuthority::new).collect(Collectors.toSet());
		this.perfil = new PerfilGrantedAuthority(user.getPerfil());
		//Aqui en vez de usar la referencia al consturctor directamente hacemos la funcion del map. SimpleGrantedAuthority es una implementacion de GrantedAuthority que siemplemente tiene el string del nombre
		//El parallelStream permitiria usar varios cores para ejecutar cada una de las iteraciones del stream
		Set<GrantedAuthority> permisosPorPerfil = user.getPerfil().getPermisos().parallelStream().map(permiso -> new SimpleGrantedAuthority(permiso.getNombrePermiso())).collect(Collectors.toSet());
	
		permisosDirectos.addAll(permisosPorPerfil);
		this.permisos = permisosDirectos;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//Los permisos y los perfiles a ojos de la aplicacion es lo mismo. Se cargaran todos como authorities
		Set<GrantedAuthority> permisos = this.permisos;
		permisos.add(perfil);
		return permisos;
	}

	@Override
	public String getPassword() {
		return this.usuario.getPassword();
	}

	@Override
	public String getUsername() {
		return this.usuario.getUsuario();
	}

	@Override
	public boolean isAccountNonExpired() {
		//Seria adecuado poner un campo que haga calculos aqui
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// Seria adecuado poner un enabled en Usuario
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

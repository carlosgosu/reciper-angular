package es.cjolalla.catalogingredients.security.dominio;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import es.cjolalla.catalogingredients.usuarios.Usuario;

/**
 * Esta calse sera el wrapper de Usuario para que este pase como UserDetails que necesita Spring security como Principal
 * @author carlosgosu
 *
 */
public class UserPrincipal implements UserDetails{

	private Usuario usuario;
	
	public UserPrincipal(Usuario user) {
		this.usuario = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//Hago un stream de la lista de permisos y segun lo voy recorriendo voy llamando al new PermisoGrantedAuthority(permiso) siendo permiso cada uno de los permisos del stream 
		return usuario.getPermisos().stream().map(PermisoGrantedAuthority::new).collect(Collectors.toSet());
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

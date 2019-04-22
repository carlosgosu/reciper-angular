package es.cjolalla.catalogingredients.security.dominio;

import org.springframework.security.core.GrantedAuthority;

import es.cjolalla.catalogingredients.usuarios.Permiso;

public class PermisoGrantedAuthority implements GrantedAuthority{

	private Permiso permiso;
	
	public PermisoGrantedAuthority(Permiso permiso) {
		this.permiso = permiso;
	}
	
	@Override
	public String getAuthority() {
		return permiso.getNombrePermiso();
	}

}

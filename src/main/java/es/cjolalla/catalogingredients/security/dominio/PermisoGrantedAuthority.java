package es.cjolalla.catalogingredients.security.dominio;

import org.springframework.security.core.GrantedAuthority;

import es.cjolalla.catalogingredients.usuarios.Permiso;

public class PermisoGrantedAuthority implements GrantedAuthority{

	private static final long serialVersionUID = -272651981695520946L;
	
	private Permiso permiso;
	
	public PermisoGrantedAuthority(Permiso permiso) {
		this.permiso = permiso;
	}
	
	@Override
	public String getAuthority() {
		return permiso.getNombrePermiso();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((permiso == null) ? 0 : permiso.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PermisoGrantedAuthority other = (PermisoGrantedAuthority) obj;
		if (permiso == null) {
			if (other.permiso != null)
				return false;
		} else if (!permiso.equals(other.permiso))
			return false;
		return true;
	}

	
}

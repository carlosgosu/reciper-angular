package es.cjolalla.catalogingredients.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import es.cjolalla.catalogingredients.security.dominio.UserPrincipal;

//Este servicio lo va a usar spring security para obtener los principal loadUserByUsername
@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepo;
	
//	@Autowired
//	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
//		Assert.notNull(usuarioRepository);
//		this.usuarioRepo = usuarioRepository;
//	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepo.findByUsuario(username);
		UserPrincipal principal = new UserPrincipal(usuario);
		return principal;
	}

}

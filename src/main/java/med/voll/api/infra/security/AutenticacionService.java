package med.voll.api.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import med.voll.api.domain.usuarios.UsuarioRepositorio;

@Service
public class AutenticacionService implements UserDetailsService{
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepositorio.findByLogin(username);
    }
    
}

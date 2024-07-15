package med.voll.api.infra.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import med.voll.api.domain.usuarios.UsuarioRepositorio;;

@Component
public class SecurityFilter extends OncePerRequestFilter{
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException{
        System.out.println("El filtro esta siendo llamado");
        //Obtener token
        var token = request.getHeader("Authorization");
        if(token!=null){        
        token = token.replace("Bearer ", "");
        var subject = tokenService.getSubject(token);
        if (subject !=null) {
            //token valido
            var usuario = usuarioRepositorio.findByLogin(subject);
            var autentication = new UsernamePasswordAuthenticationToken(usuario, null,usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(autentication);
        }
        // filterChain.doFilter(request, response);
    }
    filterChain.doFilter(request, response);
    }
}

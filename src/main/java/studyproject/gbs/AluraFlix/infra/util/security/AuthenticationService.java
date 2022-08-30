package studyproject.gbs.AluraFlix.infra.util.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import studyproject.gbs.AluraFlix.domain.entity.Usuario;
import studyproject.gbs.AluraFlix.domain.port.UsuarioRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> user = repository.findUsuarioByEmail(username);
        if (user.isPresent()){
            return user.get();
        }
        throw new UsernameNotFoundException("Invalid data!");
    }
}

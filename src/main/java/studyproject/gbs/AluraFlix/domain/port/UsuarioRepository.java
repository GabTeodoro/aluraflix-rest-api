package studyproject.gbs.AluraFlix.domain.port;

import studyproject.gbs.AluraFlix.domain.entity.Usuario;

import java.util.Optional;

public interface UsuarioRepository {

    Optional<Usuario> findUsuarioByEmail(String email);

    Optional<Usuario> findUsuarioById(Long id);
}

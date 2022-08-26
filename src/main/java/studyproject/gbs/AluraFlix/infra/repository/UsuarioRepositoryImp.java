package studyproject.gbs.AluraFlix.infra.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import studyproject.gbs.AluraFlix.domain.entity.Usuario;
import studyproject.gbs.AluraFlix.domain.port.UsuarioRepository;
import studyproject.gbs.AluraFlix.infra.repository.jpa.UsuarioJpa;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class UsuarioRepositoryImp implements UsuarioRepository {

    private UsuarioJpa jpa;

    @Override
    public Optional<Usuario> findUsuarioByEmail(String email) {
        return jpa.findByEmail(email);
    }
}

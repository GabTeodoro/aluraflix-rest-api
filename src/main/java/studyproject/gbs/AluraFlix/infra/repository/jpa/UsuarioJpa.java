package studyproject.gbs.AluraFlix.infra.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studyproject.gbs.AluraFlix.domain.entity.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioJpa extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
}

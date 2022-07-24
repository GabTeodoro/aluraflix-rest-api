package studyproject.gbs.AluraFlix.infra.repository.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studyproject.gbs.AluraFlix.domain.entity.Video;

@Repository
public interface VideoJpa extends JpaRepository<Video, Long> {

    Page<Video> findByTitle(String title, Pageable pageable);
}

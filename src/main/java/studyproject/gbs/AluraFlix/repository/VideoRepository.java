package studyproject.gbs.AluraFlix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studyproject.gbs.AluraFlix.entity.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
}

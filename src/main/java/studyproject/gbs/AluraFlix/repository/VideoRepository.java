package studyproject.gbs.AluraFlix.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studyproject.gbs.AluraFlix.entity.Video;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

    Page<Video> findByTitle(String title, Pageable pageable);
}

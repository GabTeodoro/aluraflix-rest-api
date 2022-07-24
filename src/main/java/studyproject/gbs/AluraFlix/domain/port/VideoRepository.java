package studyproject.gbs.AluraFlix.domain.port;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import studyproject.gbs.AluraFlix.domain.entity.Video;

import java.util.Optional;
public interface VideoRepository {

    Page listAllVideos(Pageable pageable);

    Page<Video> findByTitle(String title, Pageable pageable);

    Optional<Video> findVideoById(Long id);

    Video createNewVideo(Video video);

    Video updateVideo(Video video);

    void deleteVideoById(Long id);
}

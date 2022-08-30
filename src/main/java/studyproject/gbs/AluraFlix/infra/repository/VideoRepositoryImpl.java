package studyproject.gbs.AluraFlix.infra.repository;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import studyproject.gbs.AluraFlix.domain.entity.Video;
import studyproject.gbs.AluraFlix.domain.port.VideoRepository;
import studyproject.gbs.AluraFlix.infra.repository.jpa.VideoJpa;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class VideoRepositoryImpl implements VideoRepository {

    VideoJpa jpa;
    @Override
    public Page listAllVideos(Pageable pageable) {

        return jpa.findAll(pageable);
    }

    @Override
    public Optional<Video> findVideoById(Long id) {

        return jpa.findById(id);
    }

    @Override
    public Video createNewVideo(Video video) {

        return jpa.save(video);
    }

    @Override
    public Video updateVideo(Video video) {

        return jpa.save(video);
    }

    @Override
    public void deleteVideoById(Long id) {

        jpa.deleteById(id);
    }

    @Override
    public Page<Video> findFreeVideos(Pageable pageable) {
        return jpa.findFreeVideos(pageable);
    }

    public Page<Video> findByTitle(String title, Pageable pageable) {

        return jpa.findByTitle(title, pageable);
    }
}

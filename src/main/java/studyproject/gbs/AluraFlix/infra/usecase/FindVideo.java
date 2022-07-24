package studyproject.gbs.AluraFlix.infra.usecase;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import studyproject.gbs.AluraFlix.domain.entity.Video;
import studyproject.gbs.AluraFlix.domain.port.VideoRepository;
import studyproject.gbs.AluraFlix.infra.dto.request.VideoDTO;
import studyproject.gbs.AluraFlix.infra.util.exception.VideoNotFoundException;
import studyproject.gbs.AluraFlix.infra.util.verifications.Verifications;

@Service
@AllArgsConstructor
public class FindVideo implements studyproject.gbs.AluraFlix.usecase.video.FindVideo {

    private VideoRepository repository;
    private Verifications verifications;

    @Override
    public ResponseEntity execute(Long id) throws VideoNotFoundException {

        Video video = verifications.verifyVideo(id);
        return ResponseEntity.ok(new VideoDTO(video));
    }

    @Override
    public Page<VideoDTO> execute(Pageable pageable) {

        Page<Video> videos = repository.listAllVideos(pageable);
        return VideoDTO.toVideoDTO(videos);
    }

    @Override
    public Page execute(String title, Pageable pageable) {

        Page<Video> videos = repository.findByTitle(title, pageable);
        return VideoDTO.toVideoDTO(videos);
    }
}

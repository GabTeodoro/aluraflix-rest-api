package studyproject.gbs.AluraFlix.infra.usecase;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import studyproject.gbs.AluraFlix.domain.entity.Video;
import studyproject.gbs.AluraFlix.domain.port.VideoRepository;
import studyproject.gbs.AluraFlix.infra.dto.request.VideoDTO;

@Service
@AllArgsConstructor
public class FindFreeVideos implements studyproject.gbs.AluraFlix.usecase.video.FindFreeVideos {

    private VideoRepository repository;

    @Override
    public Page execute(Pageable pageable) {

        Page<Video> freeVideos = repository.findFreeVideos(pageable);
        return VideoDTO.toVideoDTO(freeVideos);
    }
}

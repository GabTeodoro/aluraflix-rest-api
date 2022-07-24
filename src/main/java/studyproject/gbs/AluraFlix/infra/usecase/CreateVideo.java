package studyproject.gbs.AluraFlix.infra.usecase;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import studyproject.gbs.AluraFlix.domain.entity.Category;
import studyproject.gbs.AluraFlix.domain.entity.Video;
import studyproject.gbs.AluraFlix.domain.port.VideoRepository;
import studyproject.gbs.AluraFlix.infra.dto.request.VideoDTO;
import studyproject.gbs.AluraFlix.infra.util.exception.CategoryNotFoundException;
import studyproject.gbs.AluraFlix.infra.util.verifications.Verifications;

import java.net.URI;

@Service
@AllArgsConstructor
public class CreateVideo implements studyproject.gbs.AluraFlix.usecase.video.CreateVideo {

    private VideoRepository repository;
    private Verifications verifications;

    @Override
    public ResponseEntity<VideoDTO> execute(VideoDTO videoDTO, UriComponentsBuilder uriBuilder) throws CategoryNotFoundException {

        Video video = new Video();
        Category category = verifications.verifyCategory(videoDTO.getCategoryId());
        video.toVideo(videoDTO);
        video.setCategory(category);
        Video savedVideo = repository.createNewVideo(video);

        URI uri = uriBuilder.path("api/v1/videos/{id}").buildAndExpand(savedVideo.getId()).toUri();
        return ResponseEntity.created(uri).body(new VideoDTO(savedVideo));
    }
}

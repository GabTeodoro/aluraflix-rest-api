package studyproject.gbs.AluraFlix.infra.usecase;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import studyproject.gbs.AluraFlix.domain.entity.Category;
import studyproject.gbs.AluraFlix.domain.entity.Video;
import studyproject.gbs.AluraFlix.domain.port.VideoRepository;
import studyproject.gbs.AluraFlix.infra.dto.request.VideoDTO;
import studyproject.gbs.AluraFlix.infra.dto.response.VideoResponse;
import studyproject.gbs.AluraFlix.infra.util.exception.CategoryNotFoundException;
import studyproject.gbs.AluraFlix.infra.util.exception.VideoNotFoundException;
import studyproject.gbs.AluraFlix.infra.util.verifications.Verifications;

@Service
@AllArgsConstructor
public class UpdateVideo implements studyproject.gbs.AluraFlix.usecase.video.UpdateVideo {

    private VideoRepository repository;
    private Verifications verifications;

    @Override
    public ResponseEntity<VideoResponse> execute(Long id, VideoDTO videoDTO)
            throws VideoNotFoundException, CategoryNotFoundException {

        Video video = verifications.verifyVideo(id);
        Category category = verifications.verifyCategory(videoDTO.getCategoryId());
        video.toVideo(videoDTO);
        video.setCategory(category);
        repository.updateVideo(video);

        return setMessageResponse("Video updated with ID ", video.getId());
    }

    private ResponseEntity<VideoResponse> setMessageResponse(String message, Long id) {
        return ResponseEntity.ok(VideoResponse.builder().message(message + id).build());
    }
}

package studyproject.gbs.AluraFlix.infra.usecase;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import studyproject.gbs.AluraFlix.domain.port.VideoRepository;
import studyproject.gbs.AluraFlix.infra.dto.response.VideoResponse;
import studyproject.gbs.AluraFlix.infra.util.exception.VideoNotFoundException;
import studyproject.gbs.AluraFlix.infra.util.verifications.Verifications;

@Service
@AllArgsConstructor
public class DeleteVideo implements studyproject.gbs.AluraFlix.usecase.video.DeleteVideo {

    private VideoRepository repository;
    private Verifications verifications;

    @Override
    public ResponseEntity execute(Long id)
            throws VideoNotFoundException {

        verifications.verifyVideo(id);
        repository.deleteVideoById(id);
        return setMessageResponse("Deleted video with ID ", id);
    }

    private ResponseEntity<VideoResponse> setMessageResponse(String message, Long id) {
        return ResponseEntity.ok(VideoResponse.builder().message(message + id).build());
    }
}

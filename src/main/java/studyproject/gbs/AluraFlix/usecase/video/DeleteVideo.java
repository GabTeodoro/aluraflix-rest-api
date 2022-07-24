package studyproject.gbs.AluraFlix.usecase.video;

import org.springframework.http.ResponseEntity;
import studyproject.gbs.AluraFlix.infra.util.exception.VideoNotFoundException;

public interface DeleteVideo {

    ResponseEntity execute(Long id) throws VideoNotFoundException;
}

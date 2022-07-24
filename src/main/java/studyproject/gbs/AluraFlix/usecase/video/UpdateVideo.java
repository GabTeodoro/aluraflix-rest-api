package studyproject.gbs.AluraFlix.usecase.video;

import org.springframework.http.ResponseEntity;
import studyproject.gbs.AluraFlix.infra.dto.request.VideoDTO;
import studyproject.gbs.AluraFlix.infra.util.exception.CategoryNotFoundException;
import studyproject.gbs.AluraFlix.infra.util.exception.VideoNotFoundException;

public interface UpdateVideo {

    ResponseEntity execute(Long id, VideoDTO videoDTO) throws VideoNotFoundException, CategoryNotFoundException;
}

package studyproject.gbs.AluraFlix.usecase.video;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;
import studyproject.gbs.AluraFlix.infra.dto.request.VideoDTO;
import studyproject.gbs.AluraFlix.infra.util.exception.CategoryNotFoundException;

public interface CreateVideo {

    ResponseEntity execute(VideoDTO videoDTO, UriComponentsBuilder uriBuilder) throws CategoryNotFoundException;
}

package studyproject.gbs.AluraFlix.usecase.video;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import studyproject.gbs.AluraFlix.infra.util.exception.VideoNotFoundException;

public interface FindVideo {

    ResponseEntity execute(Long id) throws VideoNotFoundException;

    Page execute(Pageable pageable);

    Page execute(String title, Pageable pageable);
}

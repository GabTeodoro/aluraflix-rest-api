package studyproject.gbs.AluraFlix.usecase.video;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindFreeVideos {

    Page execute(Pageable pageable);
}

package studyproject.gbs.AluraFlix.infra.util.verifications;

import studyproject.gbs.AluraFlix.domain.entity.Category;
import studyproject.gbs.AluraFlix.domain.entity.Video;
import studyproject.gbs.AluraFlix.infra.util.exception.CategoryNotFoundException;
import studyproject.gbs.AluraFlix.infra.util.exception.VideoNotFoundException;

public interface VerifyIfExists {

    Category verifyCategory(Long id) throws CategoryNotFoundException;

    Video verifyVideo(Long id) throws VideoNotFoundException;
}

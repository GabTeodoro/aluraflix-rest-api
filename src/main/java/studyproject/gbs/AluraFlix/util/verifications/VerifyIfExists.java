package studyproject.gbs.AluraFlix.util.verifications;

import studyproject.gbs.AluraFlix.entity.Category;
import studyproject.gbs.AluraFlix.entity.Video;
import studyproject.gbs.AluraFlix.exception.CategoryNotFoundException;
import studyproject.gbs.AluraFlix.exception.VideoNotFoundException;

public interface VerifyIfExists {

    Category verifyCategory(Long id) throws CategoryNotFoundException;

    Video verifyVideo(Long id) throws VideoNotFoundException;
}

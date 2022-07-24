package studyproject.gbs.AluraFlix.infra.util.verifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import studyproject.gbs.AluraFlix.domain.entity.Category;
import studyproject.gbs.AluraFlix.domain.entity.Video;
import studyproject.gbs.AluraFlix.domain.port.CategoryRepository;
import studyproject.gbs.AluraFlix.domain.port.VideoRepository;
import studyproject.gbs.AluraFlix.infra.util.exception.CategoryNotFoundException;
import studyproject.gbs.AluraFlix.infra.util.exception.VideoNotFoundException;

@Component
public class Verifications implements VerifyIfExists{

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category verifyCategory(Long id) throws CategoryNotFoundException {
        return categoryRepository.findCategoryById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));

    }

    @Override
    public Video verifyVideo(Long id) throws VideoNotFoundException {
        return videoRepository.findVideoById(id)
                .orElseThrow(() -> new VideoNotFoundException(id));
    }
}

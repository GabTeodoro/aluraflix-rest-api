package studyproject.gbs.AluraFlix.util.verifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import studyproject.gbs.AluraFlix.entity.Category;
import studyproject.gbs.AluraFlix.entity.Video;
import studyproject.gbs.AluraFlix.exception.CategoryNotFoundException;
import studyproject.gbs.AluraFlix.exception.VideoNotFoundException;
import studyproject.gbs.AluraFlix.repository.CategoryRepository;
import studyproject.gbs.AluraFlix.repository.VideoRepository;

import java.util.Optional;

@Component
public class Verifications implements VerifyIfExists{

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category verifyCategory(Long id) throws CategoryNotFoundException {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));

    }

    @Override
    public Video verifyVideo(Long id) throws VideoNotFoundException {
        return videoRepository.findById(id)
                .orElseThrow(() -> new VideoNotFoundException(id));
    }
}

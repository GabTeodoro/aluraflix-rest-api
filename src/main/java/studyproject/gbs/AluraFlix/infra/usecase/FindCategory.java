package studyproject.gbs.AluraFlix.infra.usecase;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import studyproject.gbs.AluraFlix.domain.entity.Category;
import studyproject.gbs.AluraFlix.domain.entity.Video;
import studyproject.gbs.AluraFlix.domain.port.CategoryRepository;
import studyproject.gbs.AluraFlix.infra.dto.request.CategoryDTO;
import studyproject.gbs.AluraFlix.infra.dto.request.VideoDTO;
import studyproject.gbs.AluraFlix.infra.util.exception.CategoryNotFoundException;
import studyproject.gbs.AluraFlix.infra.util.verifications.Verifications;

@Service
@AllArgsConstructor
public class FindCategory implements studyproject.gbs.AluraFlix.usecase.category.FindCategory {

    private CategoryRepository repository;
    private Verifications verifications;

    @Override
    public ResponseEntity<CategoryDTO> execute(Long id) throws CategoryNotFoundException {

        Category category = verifications.verifyCategory(id);
        return ResponseEntity.ok(new CategoryDTO(category));
    }

    @Override
    public Page<CategoryDTO> execute(Pageable pageable) {

        Page<Category> categories = repository.listAllCategories(pageable);
        return CategoryDTO.ToCategoryDTO(categories);
    }

    @Override
    public Page execute(Long id, Pageable pageable) throws CategoryNotFoundException {

        verifications.verifyCategory(id);
        Page<Video> videosPerCategory = repository.findVideosPerCategory(id, pageable);
        return VideoDTO.toVideoDTO(videosPerCategory);
    }
}

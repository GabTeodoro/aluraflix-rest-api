package studyproject.gbs.AluraFlix.domain.port;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import studyproject.gbs.AluraFlix.domain.entity.Category;
import studyproject.gbs.AluraFlix.domain.entity.Video;

import java.util.Optional;

public interface CategoryRepository {

    Page<Category> listAllCategories(Pageable pageable);

    Optional<Category> findCategoryById(Long id);

    Category createNewCategory(Category category);

    Category updateCategory(Category category);

    void deleteCategoryById(Long id);

    Page<Video> findVideosPerCategory(Long categoryId, Pageable pageable);
}

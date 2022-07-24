package studyproject.gbs.AluraFlix.infra.repository;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import studyproject.gbs.AluraFlix.domain.entity.Category;
import studyproject.gbs.AluraFlix.domain.entity.Video;
import studyproject.gbs.AluraFlix.domain.port.CategoryRepository;
import studyproject.gbs.AluraFlix.infra.repository.jpa.CategoryJpa;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class CategoryRepositoryImp implements CategoryRepository {

    private CategoryJpa jpa;

    @Override
    public Page<Category> listAllCategories(Pageable pageable) {
        return jpa.findAll(pageable);
    }

    @Override
    public Optional<Category> findCategoryById(Long id) {
        return jpa.findById(id);
    }

    @Override
    public Category createNewCategory(Category category) {
        return jpa.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return jpa.save(category);
    }

    @Override
    public void deleteCategoryById(Long id) {
        jpa.deleteById(id);
    }

    public Page<Video> findVideosPerCategory(Long categoryId, Pageable pageable) {
        return jpa.findVideosPerCategory(categoryId, pageable);
    }
}

package studyproject.gbs.AluraFlix.infra.usecase;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import studyproject.gbs.AluraFlix.domain.entity.Category;
import studyproject.gbs.AluraFlix.domain.port.CategoryRepository;
import studyproject.gbs.AluraFlix.infra.dto.request.CategoryDTO;
import studyproject.gbs.AluraFlix.infra.dto.response.CategoryResponse;

@Service
@AllArgsConstructor
public class CreateCategory implements studyproject.gbs.AluraFlix.usecase.category.CreateCategory {

    private CategoryRepository repository;
    @Override
    public ResponseEntity execute(CategoryDTO categoryDTO) {

        Category category = new Category();
        category.toCategory(categoryDTO);
        repository.createNewCategory(category);
        return setMessageResponse("Category created with ID ", category.getId());
    }

    private ResponseEntity<CategoryResponse> setMessageResponse(String message, Long id) {
        return ResponseEntity.ok(CategoryResponse.builder().message(message + id).build());
    }
}

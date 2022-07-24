package studyproject.gbs.AluraFlix.infra.usecase;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import studyproject.gbs.AluraFlix.domain.entity.Category;
import studyproject.gbs.AluraFlix.domain.port.CategoryRepository;
import studyproject.gbs.AluraFlix.infra.dto.request.CategoryDTO;
import studyproject.gbs.AluraFlix.infra.util.exception.CategoryNotFoundException;
import studyproject.gbs.AluraFlix.infra.util.verifications.Verifications;

@Service
@AllArgsConstructor
public class UpdateCategory implements studyproject.gbs.AluraFlix.usecase.category.UpdateCategory {

    private CategoryRepository repository;
    private Verifications verifications;

    @Override
    public ResponseEntity<CategoryDTO> execute(Long id, CategoryDTO categoryDTO)
            throws CategoryNotFoundException {

        Category category = verifications.verifyCategory(id);
        category.toCategory(categoryDTO);
        repository.updateCategory(category);

        return ResponseEntity.ok(new CategoryDTO(category));
    }
}

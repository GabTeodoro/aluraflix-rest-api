package studyproject.gbs.AluraFlix.infra.usecase;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import studyproject.gbs.AluraFlix.domain.port.CategoryRepository;
import studyproject.gbs.AluraFlix.infra.dto.response.CategoryResponse;
import studyproject.gbs.AluraFlix.infra.util.exception.CategoryNotFoundException;
import studyproject.gbs.AluraFlix.infra.util.verifications.Verifications;

@Service
@AllArgsConstructor
public class DeleteCategory implements studyproject.gbs.AluraFlix.usecase.category.DeleteCategory {

    private CategoryRepository repository;
    private Verifications verifications;

    @Override
    public ResponseEntity<CategoryResponse> execute(Long id) throws CategoryNotFoundException {

        verifications.verifyCategory(id);
        repository.deleteCategoryById(id);
        return setMessageResponse("Deleted category with ID ", id);
    }

    private ResponseEntity<CategoryResponse> setMessageResponse(String message, Long id) {
        return ResponseEntity.ok(CategoryResponse.builder().message(message + id).build());
    }
}

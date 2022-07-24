package studyproject.gbs.AluraFlix.usecase.category;

import org.springframework.http.ResponseEntity;
import studyproject.gbs.AluraFlix.infra.dto.request.CategoryDTO;
import studyproject.gbs.AluraFlix.infra.util.exception.CategoryNotFoundException;

public interface UpdateCategory {

    ResponseEntity execute(Long id, CategoryDTO categoryDTO) throws CategoryNotFoundException;
}

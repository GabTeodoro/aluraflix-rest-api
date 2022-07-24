package studyproject.gbs.AluraFlix.usecase.category;

import org.springframework.http.ResponseEntity;
import studyproject.gbs.AluraFlix.infra.dto.request.CategoryDTO;

public interface CreateCategory {

    ResponseEntity execute(CategoryDTO categoryDTO);
}

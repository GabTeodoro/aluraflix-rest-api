package studyproject.gbs.AluraFlix.usecase.category;

import org.springframework.http.ResponseEntity;
import studyproject.gbs.AluraFlix.infra.util.exception.CategoryNotFoundException;

public interface DeleteCategory {

    ResponseEntity execute(Long id) throws CategoryNotFoundException;
}

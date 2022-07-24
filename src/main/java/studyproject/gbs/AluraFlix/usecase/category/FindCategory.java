package studyproject.gbs.AluraFlix.usecase.category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import studyproject.gbs.AluraFlix.infra.util.exception.CategoryNotFoundException;

public interface FindCategory {

    ResponseEntity execute(Long id) throws CategoryNotFoundException;

    Page execute(Pageable pageable);

    Page execute(Long id, Pageable pageable) throws CategoryNotFoundException;
}

package studyproject.gbs.AluraFlix.application.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studyproject.gbs.AluraFlix.infra.dto.request.CategoryDTO;
import studyproject.gbs.AluraFlix.infra.dto.request.VideoDTO;
import studyproject.gbs.AluraFlix.infra.dto.response.CategoryResponse;
import studyproject.gbs.AluraFlix.infra.util.exception.CategoryNotFoundException;
import studyproject.gbs.AluraFlix.usecase.category.CreateCategory;
import studyproject.gbs.AluraFlix.usecase.category.DeleteCategory;
import studyproject.gbs.AluraFlix.usecase.category.FindCategory;
import studyproject.gbs.AluraFlix.usecase.category.UpdateCategory;

@RestController
@RequestMapping("api/v1/categories")
@AllArgsConstructor
public class CategoryController {

    private CreateCategory create;
    private FindCategory find;
    private DeleteCategory delete;
    private UpdateCategory update;

    @GetMapping
    public Page<CategoryDTO> listAll(@PageableDefault(page = 0, size = 5) Pageable pageable) {
        return find.execute(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) throws  CategoryNotFoundException{
        return find.execute(id);
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryDTO categoryDTO) {
        return create.execute(categoryDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO)
            throws  CategoryNotFoundException {
        return update.execute(id, categoryDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryResponse> deleteCategoryById(@PathVariable Long id) throws  CategoryNotFoundException {
        return delete.execute(id);
    }

    @GetMapping("/{id}/videos")
    public Page<VideoDTO> findVideosPerCategory(@PathVariable Long id, @PageableDefault(page = 0, size = 5) Pageable pageable)
            throws  CategoryNotFoundException{
        return find.execute(id, pageable);
    }
}

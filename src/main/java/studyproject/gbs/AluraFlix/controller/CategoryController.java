package studyproject.gbs.AluraFlix.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import studyproject.gbs.AluraFlix.dto.request.CategoryDTO;
import studyproject.gbs.AluraFlix.dto.request.VideoDTO;
import studyproject.gbs.AluraFlix.dto.response.CategoryResponse;
import studyproject.gbs.AluraFlix.dto.response.VideoResponse;
import studyproject.gbs.AluraFlix.exception.CategoryNotFoundException;
import studyproject.gbs.AluraFlix.service.CategoryService;
import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
@AllArgsConstructor
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public List<CategoryDTO> listAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CategoryDTO findById(@PathVariable Long id) throws CategoryNotFoundException {
        return service.findById(id);
    }

    @PostMapping
    public CategoryResponse createCategory(@RequestBody CategoryDTO categoryDTO) {
        return service.createCategory(categoryDTO);
    }

    @PutMapping("/{id}")
    public CategoryDTO updateCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO)
            throws CategoryNotFoundException {
        return service.updateCategory(id, categoryDTO);
    }

    @DeleteMapping("/{id}")
    public CategoryResponse deleteCategoryById(@PathVariable Long id) throws CategoryNotFoundException {
        return service.deleteCategoryById(id);
    }

    @GetMapping("/{id}/videos")
    public List<VideoDTO> findVideosPerCategory(@PathVariable Long id)
            throws CategoryNotFoundException {
        return service.findVideosPerCategory(id);
    }
}

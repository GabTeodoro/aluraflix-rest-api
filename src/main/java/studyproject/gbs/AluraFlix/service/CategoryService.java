package studyproject.gbs.AluraFlix.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studyproject.gbs.AluraFlix.dto.request.CategoryDTO;
import studyproject.gbs.AluraFlix.dto.response.CategoryResponse;
import studyproject.gbs.AluraFlix.dto.response.VideoResponse;
import studyproject.gbs.AluraFlix.entity.Category;
import studyproject.gbs.AluraFlix.exception.CategoryNotFoundException;
import studyproject.gbs.AluraFlix.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<CategoryDTO> findAll() {
        List<Category> categories = repository.findAll();
        return CategoryDTO.ToCategoryDTO(categories);
    }

    public CategoryDTO findById(Long id) throws CategoryNotFoundException {

        Category category = verifyIfExists(id);
        return new CategoryDTO(category);
    }

    public CategoryResponse createCategory(CategoryDTO categoryDTO) {

        Category category = new Category();
        category.toCategory(categoryDTO);
        repository.save(category);
        return setMessageResponse("Category created with ID ", category.getId());
    }

    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) throws CategoryNotFoundException {

        Category category = verifyIfExists(id);
        category.toCategory(categoryDTO);
        repository.save(category);

        return new CategoryDTO(category);
    }

    public CategoryResponse deleteCategoryById(Long id) throws CategoryNotFoundException {

        verifyIfExists(id);
        repository.deleteById(id);
        return setMessageResponse("Deleted category with ID ", id);
    }

    private CategoryResponse setMessageResponse(String message, Long id) {
        return CategoryResponse.builder().message(message + id).build();
    }

    private Category verifyIfExists(Long id) throws CategoryNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));
    }
}

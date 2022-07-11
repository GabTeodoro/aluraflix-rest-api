package studyproject.gbs.AluraFlix.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import studyproject.gbs.AluraFlix.dto.request.CategoryDTO;
import studyproject.gbs.AluraFlix.dto.request.VideoDTO;
import studyproject.gbs.AluraFlix.dto.response.CategoryResponse;
import studyproject.gbs.AluraFlix.entity.Category;
import studyproject.gbs.AluraFlix.entity.Video;
import studyproject.gbs.AluraFlix.exception.CategoryNotFoundException;
import studyproject.gbs.AluraFlix.repository.CategoryRepository;
import studyproject.gbs.AluraFlix.util.verifications.Verifications;

@Service
@AllArgsConstructor
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    private Verifications verifications;

    public Page<CategoryDTO> findAll(Pageable pageable) {
        Page<Category> categories = repository.findAll(pageable);
        return CategoryDTO.ToCategoryDTO(categories);
    }

    public ResponseEntity<CategoryDTO> findById(Long id) throws  CategoryNotFoundException{

        Category category = verifications.verifyCategory(id);
        return ResponseEntity.ok(new CategoryDTO(category));
    }

    public ResponseEntity<CategoryResponse> createCategory(CategoryDTO categoryDTO) {

        Category category = new Category();
        category.toCategory(categoryDTO);
        repository.save(category);
        return setMessageResponse("Category created with ID ", category.getId());
    }

    public ResponseEntity<CategoryDTO> updateCategory(Long id, CategoryDTO categoryDTO)
            throws  CategoryNotFoundException {

        Category category = verifications.verifyCategory(id);
        category.toCategory(categoryDTO);
        repository.save(category);

        return ResponseEntity.ok(new CategoryDTO(category));
    }

    public ResponseEntity<CategoryResponse> deleteCategoryById(Long id) throws  CategoryNotFoundException{

        verifications.verifyCategory(id);
        repository.deleteById(id);
        return setMessageResponse("Deleted category with ID ", id);
    }

    public Page<VideoDTO> findVideosPerCategory(Long id, Pageable pageable) throws  CategoryNotFoundException{
        verifications.verifyCategory(id);
        Page<Video> videosPerCategory = repository.findVideosPerCategory(id, pageable);
        return VideoDTO.toVideoDTO(videosPerCategory);
    }

    private ResponseEntity<CategoryResponse> setMessageResponse(String message, Long id) {
        return ResponseEntity.ok(CategoryResponse.builder().message(message + id).build());
    }
}

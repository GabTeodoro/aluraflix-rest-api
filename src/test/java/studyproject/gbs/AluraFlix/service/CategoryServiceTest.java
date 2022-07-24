package studyproject.gbs.AluraFlix.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import studyproject.gbs.AluraFlix.infra.dto.request.CategoryDTO;
import studyproject.gbs.AluraFlix.entity.Category;
import studyproject.gbs.AluraFlix.repository.CategoryRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    private CategoryRepository repository;

    @Mock
    private Category category;

    @Mock
    private CategoryDTO categoryDTO;

    @InjectMocks
    private CategoryService service;

//    @Test
//    void testGivenACategoryDTOThenReturnSuccessSavedMessage(){
//
//        CategoryDTO fakeCategoryDTO = createFakeDTO();
//        Category expectedCategory = createFakeEntity();
//
//        when(category.toCategory(fakeCategoryDTO)).thenReturn(expectedCategory);
//        when(repository.save(any(Category.class))).thenReturn(expectedCategory);
//
//        CategoryResponse expectedSuccessMessage = expectCreateMessageResponse(expectedCategory.getId());
//        CategoryResponse successMessage = service.createCategory(fakeCategoryDTO);
//        assertEquals(expectedSuccessMessage, successMessage);
//    }
//
//    private CategoryResponse expectCreateMessageResponse(Long id) {
//        return CategoryResponse.builder().message("Category created with ID " + id).build();
//    }

}

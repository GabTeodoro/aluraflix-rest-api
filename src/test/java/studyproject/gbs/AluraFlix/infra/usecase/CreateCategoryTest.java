package studyproject.gbs.AluraFlix.infra.usecase;

import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.ResponseEntity;
import studyproject.gbs.AluraFlix.domain.entity.Category;
import studyproject.gbs.AluraFlix.domain.entity.CategoryFake;
import studyproject.gbs.AluraFlix.domain.port.CategoryRepository;
import studyproject.gbs.AluraFlix.infra.dto.request.CategoryDTO;

import static org.junit.jupiter.api.Assertions.*;

class CreateCategoryTest {

    private CreateCategory service;

    @Mock
    private CategoryRepository repository;

    @Captor
    private ArgumentCaptor<Category> captor;

    public CreateCategoryTest() {
        MockitoAnnotations.initMocks(this);
        this.service = new CreateCategory(repository);
    }

    @Test
    void shouldCreateNewCategory_When_DtoIsValid(){

        CategoryDTO categoryDTO = CategoryFake.returnCategoryDto();

        service.execute(categoryDTO);
        Mockito.verify(repository).createNewCategory(captor.capture());
        Category category = captor.getValue();

        assertEquals(categoryDTO.getTitle(), category.getTitle());
        assertEquals(categoryDTO.getColor(), category.getColor());
    }

    @Test
    void shouldReturnSuccessCode_When_DtoIsValid(){

        CategoryDTO categoryDTO = CategoryFake.returnCategoryDto();

        ResponseEntity entity = service.execute(categoryDTO);
        Mockito.verify(repository).createNewCategory(captor.capture());
        Category category = captor.getValue();

        assertEquals(entity.getStatusCodeValue(), 200);
    }
}
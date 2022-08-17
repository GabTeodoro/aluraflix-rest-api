package studyproject.gbs.AluraFlix.infra.usecase;

import org.junit.jupiter.api.Test;
import org.mockito.*;
import studyproject.gbs.AluraFlix.domain.entity.Category;
import studyproject.gbs.AluraFlix.domain.entity.CategoryFake;
import studyproject.gbs.AluraFlix.domain.port.CategoryRepository;
import studyproject.gbs.AluraFlix.infra.dto.request.CategoryDTO;
import studyproject.gbs.AluraFlix.infra.util.exception.CategoryNotFoundException;
import studyproject.gbs.AluraFlix.infra.util.verifications.Verifications;

import static org.junit.jupiter.api.Assertions.*;

class UpdateCategoryTest {

    private UpdateCategory service;

    @Mock
    private CategoryRepository repository;

    @Mock
    private Verifications verifications;

    @Captor
    private ArgumentCaptor<Category> captor;

    public UpdateCategoryTest() {
        MockitoAnnotations.initMocks(this);
        this.service = new UpdateCategory(repository, verifications);
    }

    @Test
    void shouldUpdateCategory_When_DtoAndIdIsValid() throws CategoryNotFoundException {

        CategoryDTO categoryDTO = CategoryFake.returnCategoryDto();
        Category category = CategoryFake.returnCategory();
        Mockito.when(verifications.verifyCategory(1L)).thenReturn(category);

        service.execute(1L, categoryDTO);
        category.toCategory(categoryDTO);
        Mockito.verify(repository).updateCategory(category);

        assertEquals(categoryDTO.getTitle(), category.getTitle());
        assertEquals(categoryDTO.getColor(), category.getColor());
    }

    @Test
    void shouldReturnException_When_IdIsInValid() throws CategoryNotFoundException {

        Mockito.when(verifications.verifyCategory(null)).thenThrow(CategoryNotFoundException.class);

        try {
            service.execute(null, null);
        } catch (CategoryNotFoundException e) {

        }

    }
}
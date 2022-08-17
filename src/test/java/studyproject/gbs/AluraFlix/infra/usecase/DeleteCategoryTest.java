package studyproject.gbs.AluraFlix.infra.usecase;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import studyproject.gbs.AluraFlix.domain.port.CategoryRepository;
import studyproject.gbs.AluraFlix.infra.dto.response.CategoryResponse;
import studyproject.gbs.AluraFlix.infra.util.exception.CategoryNotFoundException;
import studyproject.gbs.AluraFlix.infra.util.verifications.Verifications;

import static org.junit.jupiter.api.Assertions.*;

class DeleteCategoryTest {

    private DeleteCategory service;

    @Mock
    private CategoryRepository repository;

    @Mock
    private Verifications verifications;

    public DeleteCategoryTest() {
        MockitoAnnotations.initMocks(this);
        this.service = new DeleteCategory(repository, verifications);
    }

    @Test
    void shouldDeleteCategory_When_IdIsValid() throws CategoryNotFoundException {

        ResponseEntity<CategoryResponse> execute = service.execute(1L);

        Mockito.verify(verifications).verifyCategory(1L);
        Mockito.verify(repository).deleteCategoryById(1L);
        assertEquals(execute.getStatusCodeValue(), 200);

    }

    @Test
    void shouldReturnException_When_IdIsInValid() throws CategoryNotFoundException {

        Mockito.when(verifications.verifyCategory(Mockito.any())).thenThrow(CategoryNotFoundException.class);

        try {
            service.execute(Mockito.any());
            Mockito.verifyNoInteractions(repository);
        }catch (CategoryNotFoundException e){}

    }
}
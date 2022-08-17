package studyproject.gbs.AluraFlix.infra.usecase;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import studyproject.gbs.AluraFlix.domain.entity.Category;
import studyproject.gbs.AluraFlix.domain.entity.CategoryFake;
import studyproject.gbs.AluraFlix.domain.port.CategoryRepository;
import studyproject.gbs.AluraFlix.infra.dto.request.CategoryDTO;
import studyproject.gbs.AluraFlix.infra.util.exception.CategoryNotFoundException;
import studyproject.gbs.AluraFlix.infra.util.verifications.Verifications;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FindCategoryTest {

    private FindCategory service;

    @Mock
    private CategoryRepository repository;

    @Mock
    private Verifications verifications;

    public FindCategoryTest() {
        MockitoAnnotations.initMocks(this);
        this.service = new FindCategory(repository, verifications);
    }

    @Test
    void shouldFindACategory_When_ReceiveAId() throws CategoryNotFoundException {

        Category category = CategoryFake.returnCategory();
        Mockito.when(verifications.verifyCategory(1L)).thenReturn(category);

        service.execute(1L);

        assertEquals(category.getId(), 1L);

    }

    @Test
    void shouldReturnException_When_IdIsInvalid() throws CategoryNotFoundException {

        Mockito.when(verifications.verifyCategory(null)).thenThrow(CategoryNotFoundException.class);

        try {
            service.execute((Long) null);
        } catch (CategoryNotFoundException e) {

        }
    }

    @Test
    void shouldReturnSuccessCode_When_IdIsValid() throws CategoryNotFoundException {

        Category category = CategoryFake.returnCategory();
        Mockito.when(verifications.verifyCategory(1L)).thenReturn(category);

        ResponseEntity<CategoryDTO> entity = service.execute(1L);

        assertEquals(entity.getStatusCodeValue(), 200);
    }
}
package studyproject.gbs.AluraFlix.infra.usecase;

import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.web.util.UriComponentsBuilder;
import studyproject.gbs.AluraFlix.domain.entity.Category;
import studyproject.gbs.AluraFlix.domain.entity.Video;
import studyproject.gbs.AluraFlix.domain.entity.VideoFake;
import studyproject.gbs.AluraFlix.domain.port.VideoRepository;
import studyproject.gbs.AluraFlix.infra.dto.request.VideoDTO;
import studyproject.gbs.AluraFlix.infra.util.exception.CategoryNotFoundException;
import studyproject.gbs.AluraFlix.infra.util.verifications.Verifications;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;

class CreateVideoTest {

    private CreateVideo service;

    @Mock
    private VideoRepository repository;

    @Mock
    private Verifications verifications;

    @Mock
    private UriComponentsBuilder uriBuilder;

    @Captor
    private ArgumentCaptor<Video> captor;

    public CreateVideoTest() {
        MockitoAnnotations.initMocks(this);
        this.service = new CreateVideo(repository, verifications);
    }

    @Test
    void shouldCreateNewVideo_When_DtoIsValid() throws CategoryNotFoundException {

        VideoDTO videoDTO = VideoFake.returnVideoDto();
        Video videoFake = VideoFake.returnVideo();

        // URI uri = uriBuilder.path("api/v1/videos/{id}").buildAndExpand(savedVideo.getId()).toUri();
        service.execute(videoDTO, uriBuilder);
        Mockito.when(repository.createNewVideo(videoFake)).thenReturn(videoFake);

        Mockito.verify(repository).createNewVideo(captor.capture());
        Video video = captor.getValue();

        assertEquals(videoDTO.getTitle(), video.getTitle());
        assertEquals(videoDTO.getDescription(), video.getDescription());
        assertEquals(videoDTO.getCategoryId(), video.getCategory().getId());
    }
}
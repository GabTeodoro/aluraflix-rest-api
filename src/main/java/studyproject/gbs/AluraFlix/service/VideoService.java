package studyproject.gbs.AluraFlix.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import studyproject.gbs.AluraFlix.dto.request.VideoDTO;
import studyproject.gbs.AluraFlix.dto.response.VideoResponse;
import studyproject.gbs.AluraFlix.entity.Category;
import studyproject.gbs.AluraFlix.entity.Video;
import studyproject.gbs.AluraFlix.exception.CategoryNotFoundException;
import studyproject.gbs.AluraFlix.exception.VideoNotFoundException;
import studyproject.gbs.AluraFlix.repository.CategoryRepository;
import studyproject.gbs.AluraFlix.repository.VideoRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor()
public class VideoService {


    @Autowired
    private VideoRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Page<VideoDTO> listAll(Pageable pageable) {

        Page<Video> videos = repository.findAll(pageable);
        return VideoDTO.toVideoDTO(videos);
    }

    public ResponseEntity<VideoDTO> findById(Long id) throws VideoNotFoundException {

        Video video = verifyIfExists(id);
        return ResponseEntity.ok(new VideoDTO(video));
    }

    public ResponseEntity<VideoDTO> createVideo(VideoDTO videoDTO, UriComponentsBuilder uriBuilder) throws CategoryNotFoundException {

        Video video = new Video();
        Category category = verifyIfCategoryExists(videoDTO.getCategoryId());
        video.toVideo(videoDTO);
        video.setCategory(category);
        Video savedVideo = repository.save(video);

        URI uri = uriBuilder.path("api/v1/videos/{id}").buildAndExpand(savedVideo.getId()).toUri();
        return ResponseEntity.created(uri).body(new VideoDTO(savedVideo));
    }

    public ResponseEntity<VideoResponse> updateVideo(Long id, VideoDTO videoDTO)
            throws VideoNotFoundException, CategoryNotFoundException {

        Video video = verifyIfExists(id);
        Category category = verifyIfCategoryExists(videoDTO.getCategoryId());
        video.toVideo(videoDTO);
        video.setCategory(category);
        repository.save(video);

        return setMessageResponse("Video updated with ID ", video.getId());
    }

    public ResponseEntity<VideoResponse> deleteVideoById(Long id) throws VideoNotFoundException {

        verifyIfExists(id);
        repository.deleteById(id);
        return setMessageResponse("Deleted video with ID ", id);
    }

    public Page<VideoDTO> findByTitle(String title, Pageable pageable) {

        Page<Video> videos = repository.findByTitle(title, pageable);
        return VideoDTO.toVideoDTO(videos);
    }

    private ResponseEntity<VideoResponse> setMessageResponse(String message, Long id) {
        return ResponseEntity.ok(VideoResponse.builder().message(message + id).build());
    }

    private Video verifyIfExists(Long id) throws VideoNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new VideoNotFoundException(id));
    }

    private Category verifyIfCategoryExists(Long id) throws CategoryNotFoundException {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));
    }
}

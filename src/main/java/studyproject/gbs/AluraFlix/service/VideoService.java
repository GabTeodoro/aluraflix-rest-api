package studyproject.gbs.AluraFlix.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studyproject.gbs.AluraFlix.dto.request.VideoDTO;
import studyproject.gbs.AluraFlix.dto.response.VideoResponse;
import studyproject.gbs.AluraFlix.entity.Category;
import studyproject.gbs.AluraFlix.entity.Video;
import studyproject.gbs.AluraFlix.exception.CategoryNotFoundException;
import studyproject.gbs.AluraFlix.exception.VideoNotFoundException;
import studyproject.gbs.AluraFlix.repository.CategoryRepository;
import studyproject.gbs.AluraFlix.repository.VideoRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor()
public class VideoService {


    @Autowired
    private VideoRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<VideoDTO> listAll() {

        List<Video> videos = repository.findAll();
        return VideoDTO.toVideoDTO(videos);
    }

    public VideoDTO findById(Long id) throws VideoNotFoundException {

        Video video = verifyIfExists(id);
        return new VideoDTO(video);
    }

    public VideoResponse createVideo(VideoDTO videoDTO) throws CategoryNotFoundException {

        Video video = new Video();
        Category category = verifyIfCategoryExists(videoDTO.getCategoryId());
        video.toVideo(videoDTO);
        video.setCategory(category);
        Video savedVideo = repository.save(video);

        return setMessageResponse("Video created with ID ", savedVideo.getId());
    }

    public VideoResponse updateVideo(Long id, VideoDTO videoDTO)
            throws VideoNotFoundException, CategoryNotFoundException {

        Video video = verifyIfExists(id);
        Category category = verifyIfCategoryExists(videoDTO.getCategoryId());
        video.toVideo(videoDTO);
        video.setCategory(category);
        repository.save(video);

        return setMessageResponse("Video updated with ID ", video.getId());
    }

    public VideoResponse deleteVideoById(Long id) throws VideoNotFoundException {

        verifyIfExists(id);
        repository.deleteById(id);
        return setMessageResponse("Deleted video with ID ", id);
    }

    public List<VideoDTO> findByTitle(String title) {

        List<Video> videos = repository.findByTitle(title);
        return VideoDTO.toVideoDTO(videos);
    }

    private VideoResponse setMessageResponse(String message, Long id) {
        return VideoResponse.builder().message(message + id).build();
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

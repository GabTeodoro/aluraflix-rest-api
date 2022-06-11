package studyproject.gbs.AluraFlix.service;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studyproject.gbs.AluraFlix.dto.request.VideoDTO;
import studyproject.gbs.AluraFlix.dto.response.VideoResponse;
import studyproject.gbs.AluraFlix.entity.Video;
import studyproject.gbs.AluraFlix.exception.VideoNotFoundException;
import studyproject.gbs.AluraFlix.repository.VideoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor()
public class VideoService {


    @Autowired
    private VideoRepository repository;

    public List<VideoDTO> listAll() {

        List<Video> videos = repository.findAll();

        return VideoDTO.toVideoDTO(videos);
    }

    public VideoDTO findById(Long id) throws VideoNotFoundException {

        Video video = verifyIfExists(id);


        return new VideoDTO(video);
    }

    public VideoResponse createVideo(VideoDTO videoDTO) {

        Video video = new Video();
        video.toVideo(videoDTO);
        Video savedVideo = repository.save(video);

        return setMessageResponse("Video created with ID ", savedVideo.getId());
    }

    public VideoResponse updateVideo(Long id, VideoDTO videoDTO) throws VideoNotFoundException {

        Video video = verifyIfExists(id);
        video.toVideo(videoDTO);
        repository.save(video);

        return setMessageResponse("Video updated with ID ", video.getId());
    }

    public void deleteVideoById(Long id) throws VideoNotFoundException {

        Video video = verifyIfExists(id);
        repository.deleteById(id);
    }

    private VideoResponse setMessageResponse(String message, Long id) {
        return VideoResponse.builder().message(message + id).build();
    }

    private Video verifyIfExists(Long id) throws VideoNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new VideoNotFoundException(id));
    }
}

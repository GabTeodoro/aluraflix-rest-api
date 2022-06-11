package studyproject.gbs.AluraFlix.service;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studyproject.gbs.AluraFlix.dto.request.VideoDTO;
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

    private Video verifyIfExists(Long id) throws VideoNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new VideoNotFoundException(id));
    }
}

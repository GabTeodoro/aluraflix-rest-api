package studyproject.gbs.AluraFlix.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studyproject.gbs.AluraFlix.dto.request.VideoDTO;
import studyproject.gbs.AluraFlix.entity.Video;
import studyproject.gbs.AluraFlix.repository.VideoRepository;

import java.util.List;
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
}

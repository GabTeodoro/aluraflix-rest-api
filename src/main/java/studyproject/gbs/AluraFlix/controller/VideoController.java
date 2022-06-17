package studyproject.gbs.AluraFlix.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import studyproject.gbs.AluraFlix.dto.request.VideoDTO;
import studyproject.gbs.AluraFlix.dto.response.VideoResponse;
import studyproject.gbs.AluraFlix.exception.CategoryNotFoundException;
import studyproject.gbs.AluraFlix.exception.VideoNotFoundException;
import studyproject.gbs.AluraFlix.service.VideoService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/videos")
@AllArgsConstructor()
public class VideoController {

    @Autowired
    private VideoService service;

    @GetMapping
    public List<VideoDTO> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public VideoDTO findById(@PathVariable Long id) throws VideoNotFoundException {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VideoResponse createVideo(@RequestBody @Valid VideoDTO videoDTO) throws CategoryNotFoundException {
        return service.createVideo(videoDTO);
    }

    @PutMapping("/{id}")
    public VideoResponse updateVideo(@PathVariable Long id, @RequestBody @Valid VideoDTO videoDTO)
            throws VideoNotFoundException, CategoryNotFoundException {
        return service.updateVideo(id, videoDTO);
    }

    @DeleteMapping("/{id}")
    public VideoResponse deleteVideoById(@PathVariable Long id) throws VideoNotFoundException {
        return service.deleteVideoById(id);
    }
}

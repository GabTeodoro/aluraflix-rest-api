package studyproject.gbs.AluraFlix.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import studyproject.gbs.AluraFlix.dto.request.VideoDTO;
import studyproject.gbs.AluraFlix.dto.response.VideoResponse;
import studyproject.gbs.AluraFlix.exception.CategoryNotFoundException;
import studyproject.gbs.AluraFlix.exception.VideoNotFoundException;
import studyproject.gbs.AluraFlix.service.VideoService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/videos")
@AllArgsConstructor()
public class VideoController {

    @Autowired
    private VideoService service;

    @GetMapping
    public Page<VideoDTO> listAll(@RequestParam(required = false) String search,
                                  @PageableDefault(page = 0, size = 5) Pageable pageable) {

        if (search == null) {
            return service.listAll(pageable);
        }

        return service.findByTitle(search, pageable);

    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoDTO> findById(@PathVariable Long id) throws Throwable {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<VideoDTO> createVideo(@RequestBody @Valid VideoDTO videoDTO,
                                                UriComponentsBuilder uriBuilder) throws CategoryNotFoundException {
        return service.createVideo(videoDTO, uriBuilder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VideoResponse> updateVideo(@PathVariable Long id, @RequestBody @Valid VideoDTO videoDTO)
            throws VideoNotFoundException, CategoryNotFoundException {
        return service.updateVideo(id, videoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VideoResponse> deleteVideoById(@PathVariable Long id) throws VideoNotFoundException {
        return service.deleteVideoById(id);
    }
}

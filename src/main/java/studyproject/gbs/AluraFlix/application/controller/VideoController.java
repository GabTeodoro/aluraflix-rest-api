package studyproject.gbs.AluraFlix.application.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import studyproject.gbs.AluraFlix.infra.dto.request.VideoDTO;
import studyproject.gbs.AluraFlix.infra.dto.response.VideoResponse;
import studyproject.gbs.AluraFlix.infra.util.exception.CategoryNotFoundException;
import studyproject.gbs.AluraFlix.infra.util.exception.VideoNotFoundException;
import studyproject.gbs.AluraFlix.usecase.video.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/videos")
@AllArgsConstructor()
public class VideoController {

    private CreateVideo create;
    private FindVideo find;
    private DeleteVideo delete;
    private UpdateVideo update;
    private FindFreeVideos freeVideos;

    @GetMapping
    public Page<VideoDTO> listAll(@RequestParam(required = false) String search,
                                  @PageableDefault(page = 0, size = 5) Pageable pageable) {

        if (search == null) {

            return find.execute(pageable);
        }

        return find.execute(search, pageable);

    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoDTO> findById(@PathVariable Long id) throws Throwable {
        return find.execute(id);
    }

    @PostMapping
    public ResponseEntity<VideoDTO> createVideo(@RequestBody @Valid VideoDTO videoDTO,
                                                UriComponentsBuilder uriBuilder) throws CategoryNotFoundException {
        return create.execute(videoDTO, uriBuilder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VideoResponse> updateVideo(@PathVariable Long id, @RequestBody @Valid VideoDTO videoDTO)
            throws VideoNotFoundException, CategoryNotFoundException {
        return update.execute(id, videoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VideoResponse> deleteVideoById(@PathVariable Long id) throws VideoNotFoundException {
        return delete.execute(id);
    }

    @GetMapping("/free")
    public Page<VideoDTO> findFreeVideos(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        return freeVideos.execute(pageable);
    }
}

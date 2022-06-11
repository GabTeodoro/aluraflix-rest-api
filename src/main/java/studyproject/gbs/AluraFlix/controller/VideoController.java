package studyproject.gbs.AluraFlix.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studyproject.gbs.AluraFlix.dto.request.VideoDTO;
import studyproject.gbs.AluraFlix.service.VideoService;

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
}

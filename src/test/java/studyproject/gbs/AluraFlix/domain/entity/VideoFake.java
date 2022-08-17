package studyproject.gbs.AluraFlix.domain.entity;

import studyproject.gbs.AluraFlix.infra.dto.request.VideoDTO;

import static studyproject.gbs.AluraFlix.domain.entity.CategoryFake.returnCategory;

public class VideoFake {

    public static VideoDTO returnVideoDto(){
        VideoDTO videoDTO = new VideoDTO();
        videoDTO.setTitle("Title");
        videoDTO.setDescription("Description");
        videoDTO.setUrl("www.url.com.br");
        videoDTO.setCategoryId(1L);

        return videoDTO;
    }

    public static Video returnVideo(){

        return new Video(1L, "Title",
                "Description", "www.url.com.br", returnCategory());
    }
}

package studyproject.gbs.AluraFlix.model;

import studyproject.gbs.AluraFlix.dto.request.CategoryDTO;
import studyproject.gbs.AluraFlix.dto.request.VideoDTO;
import studyproject.gbs.AluraFlix.entity.Category;
import studyproject.gbs.AluraFlix.entity.Video;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryTest {

    private static final Long CATEGORY_ID = 1L;
    private static final String TITLE = "Back-end";
    private static final String COLOR = "RED";

    private static List<VideoDTO> videosDTO = new ArrayList<>();
    private static List<Video> videosEntity = new ArrayList<>();


    public static CategoryDTO createFakeDTO() {
        videosDTO.add(VideoTest.createFakeDTO());
        return CategoryDTO.builder()
                .title(TITLE)
                .color(COLOR)
                .videos(videosDTO)
                .build();
    }

//    public static Category createFakeEntity() {
//        videosEntity.add(VideoTest.createFakeEntity());
//        return Category.builder()
//                .id(CATEGORY_ID)
//                .title(TITLE)
//                .color(COLOR)
//                .videos(videosEntity)
//                .build();
//    }

}

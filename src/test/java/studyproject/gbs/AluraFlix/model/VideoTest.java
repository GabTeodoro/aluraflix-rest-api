package studyproject.gbs.AluraFlix.model;

import studyproject.gbs.AluraFlix.dto.request.VideoDTO;
import studyproject.gbs.AluraFlix.entity.Video;

public class VideoTest {

    private static final Long VIDEO_ID = 10L;
    private static final String TITLE = "Java Backend 1";
    private static final String DESCRIPTION = "First class about Java";
    private static final String URL = "https://www.youtube.com/";
    private static  final Long CATEGORY_ID = 1L;

    public static VideoDTO createFakeDTO() {
        return VideoDTO.builder()
                .title(TITLE)
                .description(DESCRIPTION)
                .url(URL)
                .categoryId(CATEGORY_ID)
                .build();
    }

//    public static Video createFakeEntity(){
//        return Video.builder()
//                .id(VIDEO_ID)
//                .title(TITLE)
//                .description(DESCRIPTION)
//                .url(URL)
//                .category(CategoryTest.createFakeEntity())
//                .build();
//    }


}

package studyproject.gbs.AluraFlix.domain.entity;

import org.springframework.data.domain.Page;
import studyproject.gbs.AluraFlix.infra.dto.request.CategoryDTO;
import studyproject.gbs.AluraFlix.infra.dto.request.VideoDTO;

import java.util.ArrayList;
import java.util.List;

public class CategoryFake {

    public static CategoryDTO returnCategoryDto() {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setTitle("Title");
        categoryDTO.setColor("Black");
        List<VideoDTO> list = new ArrayList<VideoDTO>();

        categoryDTO.setVideos(list);

        return categoryDTO;
    }

    public static Category returnCategory() {

        List<Video> videos = new ArrayList<>();
        return new Category(1L, "Title", "Red", videos);
    }
}

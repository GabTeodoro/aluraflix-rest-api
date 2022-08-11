package studyproject.gbs.AluraFlix.domain.entity;

import org.springframework.data.domain.Page;
import studyproject.gbs.AluraFlix.infra.dto.request.CategoryDTO;
import studyproject.gbs.AluraFlix.infra.dto.request.VideoDTO;

import java.util.ArrayList;
import java.util.List;

public class CategoryFake {

    public static CategoryDTO returnCategoryDto(){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setTitle("Title");
        categoryDTO.setColor("Black");
        List<VideoDTO> list = new ArrayList<VideoDTO>();

        categoryDTO.setVideos(list);

        return categoryDTO;
    }

    public static Category returnCategory(){

        List<Video> videos = new ArrayList<>();
        return new Category(1L, "Title", "Red", videos);
    }

    public static Page<Category> returnList(){

        List<Category> list = new ArrayList<Category>();

        List<Video> list1 = new ArrayList<Video>();
        Category category1 =  new Category(1L, "Title1", "Red",list1);

        List<Video> list2 = new ArrayList<Video>();
        Category category2 =  new Category(2L, "Title2", "Black",list2);

        list.add(category1);
        list.add(category2);

        return (Page<Category>) list;
    }
}

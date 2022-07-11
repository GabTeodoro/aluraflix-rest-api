package studyproject.gbs.AluraFlix.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import studyproject.gbs.AluraFlix.entity.Category;
import studyproject.gbs.AluraFlix.entity.Video;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private Long id;

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private String color;

    private List<VideoDTO> videos;

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.title = category.getTitle();
        this.color = category.getColor();
    }

    public static Page<CategoryDTO> ToCategoryDTO(Page<Category> categories) {
        return categories.map(CategoryDTO::new);
    }
}

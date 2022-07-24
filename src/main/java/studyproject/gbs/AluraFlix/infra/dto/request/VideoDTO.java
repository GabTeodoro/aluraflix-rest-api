package studyproject.gbs.AluraFlix.infra.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import studyproject.gbs.AluraFlix.domain.entity.Video;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VideoDTO {

    private Long id;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 40)
    private String title;

    @NotNull
    @NotEmpty
    private String description;

    @NotNull
    @NotEmpty
    private String url;

    private Long categoryId;

    public VideoDTO(Video video) {
        this.id = video.getId();
        this.title = video.getTitle();
        this.description = video.getDescription();
        this.url = video.getUrl();
        this.categoryId = video.getCategory().getId();
    }

    public static Page<VideoDTO> toVideoDTO(Page<Video> videos) {
        return videos.map(VideoDTO::new);
    }
}

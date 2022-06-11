package studyproject.gbs.AluraFlix.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import studyproject.gbs.AluraFlix.entity.Video;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public VideoDTO(Video video) {
        this.id = video.getId();
        this.title = video.getTitle();
        this.description = video.getDescription();
        ;
        this.url = video.getUrl();
    }

//    public static List<VideoDTO> toVideoDTO(List<Video> videos){
//        List<VideoDTO> videosDTO = new ArrayList<>();
//
//        for (Video video: videos) {
//            videosDTO.add(new VideoDTO(video));
//        }
//
//        return videosDTO;
//    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static List<VideoDTO> toVideoDTO(List<Video> videos) {
        return videos.stream().map(VideoDTO::new).collect(Collectors.toList());
    }
}

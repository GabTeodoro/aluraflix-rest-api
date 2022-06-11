package studyproject.gbs.AluraFlix.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import studyproject.gbs.AluraFlix.entity.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VideoDTO {

    private Long id;
    private String title;
    private String description;
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

    public static List<VideoDTO> toVideoDTO(List<Video> videos) {
        return videos.stream().map(VideoDTO::new).collect(Collectors.toList());
    }
}

package studyproject.gbs.AluraFlix.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import studyproject.gbs.AluraFlix.dto.request.VideoDTO;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String url;

    public void toVideo(VideoDTO videoDTO) {

        this.description = videoDTO.getDescription();
        this.title = videoDTO.getTitle();
        this.url = videoDTO.getUrl();
    }
}

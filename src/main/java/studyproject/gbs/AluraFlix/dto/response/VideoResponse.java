package studyproject.gbs.AluraFlix.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VideoResponse {

    private Long id;
    private String title;
    private String description;
    private String url;
}

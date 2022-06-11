package studyproject.gbs.AluraFlix.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VideoResponse {

   private String message;

   public VideoResponse(String message) {
      this.message = message;
   }
}

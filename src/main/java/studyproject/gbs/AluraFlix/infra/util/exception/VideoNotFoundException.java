package studyproject.gbs.AluraFlix.infra.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class VideoNotFoundException extends Throwable {

    public VideoNotFoundException(Long id) {
        super("Video not found with ID " + id);
    }
}

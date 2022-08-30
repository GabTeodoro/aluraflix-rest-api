package studyproject.gbs.AluraFlix.infra.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
public class TokenResponse {

    private String token;
    private String type;

    private String message;

    public TokenResponse(String token, String type, String message) {
        this.token = token;
        this.type = type;
        this.message = message;
    }

    public TokenResponse(String message) {
        this.message = message;
    }
}

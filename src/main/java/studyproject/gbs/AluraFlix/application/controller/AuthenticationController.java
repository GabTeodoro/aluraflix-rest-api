package studyproject.gbs.AluraFlix.application.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studyproject.gbs.AluraFlix.infra.dto.request.LoginFormDTO;
import studyproject.gbs.AluraFlix.infra.dto.response.TokenResponse;
import studyproject.gbs.AluraFlix.infra.util.security.TokenService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/auth")
@AllArgsConstructor
public class AuthenticationController {

    private AuthenticationManager authManager;

    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenResponse> authenticate(@RequestBody @Valid LoginFormDTO loginForm){

        UsernamePasswordAuthenticationToken loginData = loginForm.convert();
        try {

            Authentication authenticate = authManager.authenticate(loginData);
            String token = tokenService.createToken(authenticate);
            return ResponseEntity.ok(new TokenResponse(token, "Bearer", "Success"));

        }catch (AuthenticationException e){
            return ResponseEntity.badRequest().body(new TokenResponse("Invalid username or password"));
        }
    }
}

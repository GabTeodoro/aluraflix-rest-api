package studyproject.gbs.AluraFlix.application.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studyproject.gbs.AluraFlix.infra.dto.request.LoginFormDTO;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/auth")
@AllArgsConstructor
public class AuthenticationController {

    @PostMapping
    public ResponseEntity authenticate(@RequestBody @Valid LoginFormDTO loginForm){

        System.out.println(loginForm.getEmail());
        System.out.println(loginForm.getPassword());

        return ResponseEntity.ok().build();
    }
}

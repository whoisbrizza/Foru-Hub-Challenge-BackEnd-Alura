package com.example.ForumHubChallengeBackEnd.controller;

import com.example.ForumHubChallengeBackEnd.dto.LoginDTO;
import com.example.ForumHubChallengeBackEnd.dto.TokenDTO;
import com.example.ForumHubChallengeBackEnd.model.UserModel;
import com.example.ForumHubChallengeBackEnd.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AuthenticationController {


    private final AuthenticationManager manager;
    private final TokenService tokenService;

    public AuthenticationController(AuthenticationManager manager, TokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid LoginDTO data) {
        var authToken = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var authentication = manager.authenticate(authToken);


        var tokenJWT = tokenService.generateToken((UserModel) authentication.getPrincipal());
        System.out.println("Token: " + tokenJWT);

        return ResponseEntity.ok(new TokenDTO(tokenJWT));
    }
}


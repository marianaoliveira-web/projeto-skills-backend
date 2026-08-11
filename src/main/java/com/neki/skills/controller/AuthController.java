package com.neki.skills.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neki.skills.dto.LoginRequestDTO;
import com.neki.skills.dto.LoginResponseDTO;
import com.neki.skills.model.Usuario;
import com.neki.skills.repository.UsuarioRepository;
import com.neki.skills.security.TokenService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UsuarioRepository usuarioRepository;

    public AuthController(AuthenticationManager authenticationManager, TokenService tokenService, UsuarioRepository usuarioRepository) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO dadosLogin) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(dadosLogin.getLogin(), dadosLogin.getSenha());
        this.authenticationManager.authenticate(usernamePassword);

        Usuario usuario = usuarioRepository.findByLogin(dadosLogin.getLogin())
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado!"));

        String token = tokenService.gerarToken(usuario);

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
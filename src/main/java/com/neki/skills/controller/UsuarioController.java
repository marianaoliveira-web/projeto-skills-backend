package com.neki.skills.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.neki.skills.dto.UsuarioRequestDTO;
import com.neki.skills.dto.UsuarioResponseDTO;
import com.neki.skills.model.Usuario;
import com.neki.skills.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioResponseDTO> cadastrarUsuario(@RequestBody UsuarioRequestDTO dto) {

        Usuario usuario = new Usuario();
        usuario.setLogin(dto.getLogin());
        usuario.setSenha(dto.getSenha());

        Usuario novoUsuario = usuarioService.cadastrarUsuario(usuario);

        UsuarioResponseDTO response = new UsuarioResponseDTO(novoUsuario.getIdUsuario(), novoUsuario.getLogin());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
package com.neki.skills.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.neki.skills.dto.UsuarioSkillRequestDTO;
import com.neki.skills.dto.UsuarioSkillResponseDTO;
import com.neki.skills.service.UsuarioSkillService;

@RestController
@RequestMapping("/usuario-skills")
public class UsuarioSkillController {

    private final UsuarioSkillService usuarioSkillService;

    public UsuarioSkillController(UsuarioSkillService usuarioSkillService) {
        this.usuarioSkillService = usuarioSkillService;
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<UsuarioSkillResponseDTO>> listarPorUsuario(@PathVariable Integer usuarioId) {
        List<UsuarioSkillResponseDTO> lista = usuarioSkillService.listarSkillsDoUsuario(usuarioId);

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<UsuarioSkillResponseDTO> adicionarSkill(@RequestBody UsuarioSkillRequestDTO dto) {
        UsuarioSkillResponseDTO novaAssociacao = usuarioSkillService.associarSkill(dto);

        return new ResponseEntity<>(novaAssociacao, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<UsuarioSkillResponseDTO> atualizarLevel(@PathVariable Integer id, @RequestBody UsuarioSkillRequestDTO dto) {
        UsuarioSkillResponseDTO skillAtualizada = usuarioSkillService.atualizarLevel(id, dto);

        return new ResponseEntity<>(skillAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarSkill(@PathVariable Integer id) {
        usuarioSkillService.removerAssociacao(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
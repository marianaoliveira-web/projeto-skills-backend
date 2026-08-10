package com.neki.skills.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.neki.skills.model.UsuarioSkill;
import com.neki.skills.service.UsuarioSkillService;

@RestController@RequestMapping("/usuario-skills")
public class UsuarioSkillController {

    private final UsuarioSkillService usuarioSkillService;

    public UsuarioSkillController(UsuarioSkillService usuarioSkillService) {
        this.usuarioSkillService = usuarioSkillService;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<UsuarioSkill> adicionarSkill(@RequestBody UsuarioSkill usuarioSkill) {
        UsuarioSkill novaAssociacao = usuarioSkillService.associarSkill(usuarioSkill);

        return new ResponseEntity<>(novaAssociacao, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<UsuarioSkill> atualizarLevel(@PathVariable Integer id, @RequestBody UsuarioSkill usuarioSkillAtualizada) {
        UsuarioSkill skillAtualizada = usuarioSkillService.atualizarLevel(id, usuarioSkillAtualizada);

        return new ResponseEntity<>(skillAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarSkill(@PathVariable Integer id) {
        usuarioSkillService.removerAssociacao(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
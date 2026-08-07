package com.neki.skills.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.neki.skills.model.Usuario;
import com.neki.skills.model.UsuarioSkill;
import com.neki.skills.repository.UsuarioSkillRepository;

@Service
public class UsuarioSkillService {

    private final UsuarioSkillRepository usuarioSkillRepository;

    public UsuarioSkillService(UsuarioSkillRepository usuarioSkillRepository) {
        this.usuarioSkillRepository = usuarioSkillRepository;
    }

    public List<UsuarioSkill> listarSkillsDoUsuario(Usuario usuario) {
        return usuarioSkillRepository.findByUsuario(usuario);
    }

    public UsuarioSkill associarSkill(UsuarioSkill usuarioSkill) {
        return usuarioSkillRepository.save(usuarioSkill);
    }

    public void removerAssociacao(Integer id) {
        usuarioSkillRepository.deleteById(id);
    }
}
package com.neki.skills.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.neki.skills.model.Usuario;
import com.neki.skills.model.Skill;
import com.neki.skills.model.UsuarioSkill;
import com.neki.skills.repository.SkillRepository;
import com.neki.skills.repository.UsuarioRepository;
import com.neki.skills.repository.UsuarioSkillRepository;
import com.neki.skills.dto.UsuarioSkillRequestDTO;
import com.neki.skills.dto.UsuarioSkillResponseDTO;

@Service
public class UsuarioSkillService {

    private final UsuarioSkillRepository usuarioSkillRepository;
    private final UsuarioRepository usuarioRepository;
    private final SkillRepository skillRepository;

    public UsuarioSkillService(UsuarioSkillRepository usuarioSkillRepository, 
                               UsuarioRepository usuarioRepository, 
                               SkillRepository skillRepository) {
        this.usuarioSkillRepository = usuarioSkillRepository;
        this.usuarioRepository = usuarioRepository;
        this.skillRepository = skillRepository;
    }

    public List<UsuarioSkillResponseDTO> listarSkillsDoUsuario(Integer usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        List<UsuarioSkill> lista = usuarioSkillRepository.findByUsuario(usuario);

        return lista.stream().map(this::converterParaDTO).collect(Collectors.toList());
    }

    public UsuarioSkillResponseDTO associarSkill(UsuarioSkillRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        Skill skill = skillRepository.findById(dto.getSkillId())
                .orElseThrow(() -> new RuntimeException("Skill não encontrada!"));

        UsuarioSkill usuarioSkill = new UsuarioSkill();
        usuarioSkill.setUsuario(usuario);
        usuarioSkill.setSkill(skill);
        usuarioSkill.setLevel(dto.getLevel());

        UsuarioSkill salva = usuarioSkillRepository.save(usuarioSkill);

        return converterParaDTO(salva);
    }

    public UsuarioSkillResponseDTO atualizarLevel(Integer id, UsuarioSkillRequestDTO dto) {
        UsuarioSkill skillExistente = usuarioSkillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Associação de skill não encontrada!"));

        skillExistente.setLevel(dto.getLevel());

        UsuarioSkill atualizada = usuarioSkillRepository.save(skillExistente);

        return converterParaDTO(atualizada);
    }

    public void removerAssociacao(Integer id) {
        usuarioSkillRepository.deleteById(id);
    }

    private UsuarioSkillResponseDTO converterParaDTO(UsuarioSkill usuarioSkill) {
        return new UsuarioSkillResponseDTO(
            usuarioSkill.getIdUsuarioSkill(),
            usuarioSkill.getUsuario().getIdUsuario(),
            usuarioSkill.getSkill().getIdSkill(),
            usuarioSkill.getSkill().getNome(),
            usuarioSkill.getSkill().getImagemUrl(),
            usuarioSkill.getLevel()
        );
    }
}
package com.neki.skills.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.neki.skills.model.Skill;
import com.neki.skills.repository.SkillRepository;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> listarTodas() {
        return skillRepository.findAll();
    }

    public Optional<Skill> buscarPorId(Integer id) {
        return skillRepository.findById(id);
    }
}
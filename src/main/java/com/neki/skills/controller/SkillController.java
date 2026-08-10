package com.neki.skills.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.neki.skills.model.Skill;
import com.neki.skills.service.SkillService;

@RestController
@RequestMapping("/skills")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping
    public ResponseEntity<List<Skill>> listarTodas() {
        List<Skill> skills = skillService.listarTodas();
        
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }
}
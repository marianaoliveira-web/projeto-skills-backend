package com.neki.skills.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neki.skills.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
}
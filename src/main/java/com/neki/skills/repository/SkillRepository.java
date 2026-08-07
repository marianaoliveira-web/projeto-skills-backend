package com.neki.skills.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neki.skills.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
}
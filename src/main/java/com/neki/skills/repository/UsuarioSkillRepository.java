package com.neki.skills.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neki.skills.model.Usuario;
import com.neki.skills.model.UsuarioSkill;

@Repository
public interface UsuarioSkillRepository extends JpaRepository<UsuarioSkill, Integer> {
    List<UsuarioSkill> findByUsuario(Usuario usuario);
}
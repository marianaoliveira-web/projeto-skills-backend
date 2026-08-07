package com.neki.skills.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario_skill")
public class UsuarioSkill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario_skill")
    @SequenceGenerator(name = "seq_usuario_skill", sequenceName = "seq_usuario_skill", allocationSize = 1)
    @Column(name = "id_usuario_skill")
    private Integer idUsuarioSkill;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_skill", nullable = false)
    private Skill skill;

    @Column(nullable = false)
    private Integer level;

    public UsuarioSkill(){
    }

    public UsuarioSkill(Integer idUsuarioSkill, Usuario usuario, Skill skill, Integer level) {
        this.idUsuarioSkill = idUsuarioSkill;
        this.usuario = usuario;
        this.skill = skill;
        this.level = level;
    }

    public Integer getIdUsuarioSkill() {
        return idUsuarioSkill;
    }

    public void setIdUsuarioSkill(Integer idUsuarioSkill) {
        this.idUsuarioSkill = idUsuarioSkill;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}

package com.neki.skills.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_skill")
    @SequenceGenerator(name = "seq_skill", sequenceName = "seq_skill", allocationSize = 1)
    @Column(name = "id_skill")
    private Integer idSkill;

    @Column(nullable = false)
    private String nome;

    private String versao;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "imagem_url")
    private String imagemUrl;

    public Skill() {
    }

    public Skill(Integer idSkill, String nome, String versao, String descricao, String imagemUrl) {
        this.idSkill = idSkill;
        this.nome = nome;
        this.versao = versao;
        this.descricao = descricao;
        this.imagemUrl = imagemUrl;
    }

    public Integer getIdSkill() {
        return idSkill;
    }
    
    public void setIdSkill(Integer idSkill) {
        this.idSkill = idSkill;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }
}

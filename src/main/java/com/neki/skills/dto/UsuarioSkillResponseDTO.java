package com.neki.skills.dto;

public class UsuarioSkillResponseDTO {

    private Integer id;
    private Integer usuarioId;
    private Integer skillId;
    private String skillNome;
    private String skillDescricao;
    private String skillImageUrl;
    private Integer level;

    public UsuarioSkillResponseDTO() {
    }

    public UsuarioSkillResponseDTO(
            Integer id,
            Integer usuarioId,
            Integer skillId,
            String skillNome,
            String skillDescricao,
            String skillImageUrl,
            Integer level) {

        this.id = id;
        this.usuarioId = usuarioId;
        this.skillId = skillId;
        this.skillNome = skillNome;
        this.skillDescricao = skillDescricao;
        this.skillImageUrl = skillImageUrl;
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getSkillNome() {
        return skillNome;
    }

    public void setSkillNome(String skillNome) {
        this.skillNome = skillNome;
    }

    public String getSkillDescricao() {
        return skillDescricao;
    }

    public void setSkillDescricao(String skillDescricao) {
        this.skillDescricao = skillDescricao;
    }

    public String getSkillImageUrl() {
        return skillImageUrl;
    }

    public void setSkillImageUrl(String skillImageUrl) {
        this.skillImageUrl = skillImageUrl;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
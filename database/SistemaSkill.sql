CREATE SEQUENCE seq_usuario START 1;
CREATE SEQUENCE seq_skill START 1;
CREATE SEQUENCE seq_usuario_skill START 1;

CREATE TABLE usuario (
    id_usuario INT PRIMARY KEY DEFAULT nextval('seq_usuario'),
    login VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE skill (
    id_skill INT PRIMARY KEY DEFAULT nextval('seq_skill'),
    nome VARCHAR(100) NOT NULL,
    versao VARCHAR(50),
    descricao TEXT,
    imagem_url VARCHAR(255)
);

CREATE TABLE usuario_skill (
    id_usuario_skill INT PRIMARY KEY DEFAULT nextval('seq_usuario_skill'),
    id_usuario INTEGER NOT NULL,
    id_skill INTEGER NOT NULL,
    level INTEGER NOT NULL,
    CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) ON DELETE CASCADE,
    CONSTRAINT fk_skill FOREIGN KEY (id_skill) REFERENCES skill(id_skill) ON DELETE CASCADE
);
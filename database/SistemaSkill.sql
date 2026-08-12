CREATE SEQUENCE seq_usuario START 1;
CREATE SEQUENCE seq_skill START 1;
CREATE SEQUENCE seq_usuario_skill START 1;

CREATE TABLE usuario (
    id_usuario INTEGER PRIMARY KEY DEFAULT nextval('seq_usuario'),
    login VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE skill (
    id_skill INTEGER PRIMARY KEY DEFAULT nextval('seq_skill'),
    nome VARCHAR(100) NOT NULL,
    versao VARCHAR(50),
    descricao TEXT,
    imagem_url VARCHAR(255)
);

CREATE TABLE usuario_skill (
    id_usuario_skill INTEGER PRIMARY KEY DEFAULT nextval('seq_usuario_skill'),
    id_usuario INTEGER NOT NULL,
    id_skill INTEGER NOT NULL,
    level INTEGER NOT NULL,
    CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) ON DELETE CASCADE,
    CONSTRAINT fk_skill FOREIGN KEY (id_skill) REFERENCES skill(id_skill) ON DELETE CASCADE
);

INSERT INTO skill (nome, versao, descricao, imagem_url) VALUES
('React', '18.2', 'Biblioteca JavaScript para construção de interfaces de usuário.', 'https://cdn.jsdelivr.net/gh/devicons/devicon/icons/react/react-original.svg'),
('Java', '17', 'Linguagem de programação orientada a objetos.', 'https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg'),
('Spring Boot', '3.1', 'Framework backend para desenvolvimento de aplicações em Java.', 'https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg'),
('Python', '3.11', 'Linguagem de programação de alto nível.', 'https://cdn.jsdelivr.net/gh/devicons/devicon/icons/python/python-original.svg'),
('PostgreSQL', '15', 'Sistema gerenciador de banco de dados relacional.', 'https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original.svg');
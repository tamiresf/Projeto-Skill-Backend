-- CriaÃ§Ã£o das Sequences
CREATE SEQUENCE tb_usuario START 1;
CREATE SEQUENCE tb_habilidade START 1;
CREATE SEQUENCE habilidade_usuario START 1;

-- Tabela de UsuÃ¡rios
CREATE TABLE tb_usuario (
    id_usuario INT DEFAULT nextval('tb_usuario') PRIMARY KEY,
    login_usuario VARCHAR(50) UNIQUE NOT NULL,
    nome_usuario VARCHAR(50) NOT NULL
    senha_usuario VARCHAR(50) NOT NULL
);

-- Tabela de Skills
CREATE TABLE tb_habilidade (
    id INT DEFAULT nextval('tb_habilidade') PRIMARY KEY,
    skill VARCHAR(50) UNIQUE NOT NULL
);

-- Tabela Associativa Usuario_Skill
CREATE TABLE habilidade_usuario (
    id INT DEFAULT nextval('habilidade_usuario') PRIMARY KEY,
    usuario_id INT REFERENCES tb_usuario(id) ON DELETE CASCADE,
    habilidade_id INT REFERENCES tb_habilidade(id) ON DELETE CASCADE,
    level INT NOT NULL,
    CONSTRAINT habilidade_usuario UNIQUE (usuario_id, habilidade_id)
);


INSERT INTO habilidade (id, skill) VALUES (1, 'JavaScript'), (2, 'Java'), (3, 'CSS'), (4, 'C++'), (5, 'C#');

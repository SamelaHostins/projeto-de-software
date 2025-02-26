CREATE SCHEMA IF NOT EXISTS projeto;

-- Extensão necessária para gerar UUID automaticamente
CREATE EXTENSION IF NOT EXISTS pgcrypto;

-- Tabela usuario
CREATE TABLE IF NOT EXISTS projeto.usuario (
    id_usuario UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(25) NOT NULL,
    sobrenome VARCHAR(25) NOT NULL,
    data_nascimento DATE NOT NULL CHECK (data_nascimento <= CURRENT_DATE),
    email VARCHAR(30) NOT NULL UNIQUE,
    telefone VARCHAR(12) NOT NULL UNIQUE CHECK (telefone ~ '^[0-9]+$'),
    login_usuario VARCHAR(25) NOT NULL UNIQUE,
    senha VARCHAR(8) NOT NULL CHECK (senha ~ '^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8}$'),
    tipo_usuario INT4
);

-- Tabela perfil
CREATE TABLE IF NOT EXISTS projeto.perfil (
    id_perfil UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    id_usuario UUID UNIQUE NOT NULL,
    historico VARCHAR(500),
    qualificacoes VARCHAR(500),
    experiencia VARCHAR(500) NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES projeto.usuario(id_usuario) ON DELETE CASCADE
);

-- Tabela curso
CREATE TABLE IF NOT EXISTS projeto.curso (
    id_curso UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    dt_publicacao DATE NOT NULL CHECK (dt_publicacao <= CURRENT_DATE),
    descricao VARCHAR(500) NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    url_imagem_capa VARCHAR(500),
    requisitos VARCHAR(255),
    vagas_disponiveis INT NOT NULL
);

-- Relacionamento entre usuario e curso (inscrição)
CREATE TABLE IF NOT EXISTS projeto.usuario_curso (
    id_usuario UUID,
    id_curso UUID,
    PRIMARY KEY (id_usuario, id_curso),
    FOREIGN KEY (id_usuario) REFERENCES projeto.usuario(id_usuario) ON DELETE CASCADE,
    FOREIGN KEY (id_curso) REFERENCES projeto.curso(id_curso) ON DELETE CASCADE
);

-- Tabela empresa
CREATE TABLE IF NOT EXISTS projeto.empresa (
    id_empresa UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(255) NOT NULL,
    setor VARCHAR(255),
    descricao VARCHAR(500)
);

-- Tabela vaga_emprego
CREATE TABLE IF NOT EXISTS projeto.vaga_emprego (
    id_vaga UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    titulo VARCHAR(255) NOT NULL,
    descricao VARCHAR(500),
    requisitos VARCHAR(500),
    id_empresa UUID NOT NULL,
    FOREIGN KEY (id_empresa) REFERENCES projeto.empresa(id_empresa) ON DELETE CASCADE
);

-- Relacionamento entre usuario e vaga_emprego (candidatura)
CREATE TABLE IF NOT EXISTS projeto.usuario_vaga (
    id_usuario UUID,
    id_vaga UUID,
    PRIMARY KEY (id_usuario, id_vaga),
    FOREIGN KEY (id_usuario) REFERENCES projeto.usuario(id_usuario) ON DELETE CASCADE,
    FOREIGN KEY (id_vaga) REFERENCES projeto.vaga_emprego(id_vaga) ON DELETE CASCADE
);

-- Tabela administrador
CREATE TABLE IF NOT EXISTS projeto.administrador (
    id_administrador UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    id_usuario UUID UNIQUE NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES projeto.usuario(id_usuario) ON DELETE CASCADE
);

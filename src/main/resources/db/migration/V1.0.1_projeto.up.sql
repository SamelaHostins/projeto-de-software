CREATE SCHEMA IF NOT EXISTS projeto;

-- Extensão necessária para gerar UUID automaticamente
CREATE EXTENSION IF NOT EXISTS pgcrypto;

-- Tabela usuario
CREATE TABLE
    IF NOT EXISTS projeto.usuario (
        id_usuario UUID DEFAULT gen_random_uuid () PRIMARY KEY,
        nome VARCHAR(25) NOT NULL,
        sobrenome VARCHAR(25) NOT NULL,
        data_nascimento DATE NOT NULL,
        email VARCHAR(30) NOT NULL UNIQUE,
        telefone VARCHAR(12) NOT NULL UNIQUE,
        login_usuario VARCHAR(25) NOT NULL UNIQUE,
        senha VARCHAR(8) NOT NULL,
        historico VARCHAR(500),
        qualificacoes VARCHAR(500),
        experiencia VARCHAR(500) NOT NULL,
        disponibilidade INT4 NOT NULL
    );

-- Tabela empresa
CREATE TABLE
    IF NOT EXISTS projeto.empresa (
        id_empresa UUID DEFAULT gen_random_uuid () PRIMARY KEY,
        nome VARCHAR(255) NOT NULL,
        setor VARCHAR(255),
        descricao VARCHAR(500)
    );

-- Tabela vaga_emprego
CREATE TABLE
    IF NOT EXISTS projeto.vaga_emprego (
        id_vaga UUID DEFAULT gen_random_uuid () PRIMARY KEY,
        titulo VARCHAR(255) NOT NULL,
        descricao VARCHAR(500),
        requisitos VARCHAR(500),
        id_empresa UUID NOT NULL,
        CONSTRAINT fk_vaga_empresa FOREIGN KEY (id_empresa) REFERENCES projeto.empresa (id_empresa) ON DELETE CASCADE
    );

-- Registra quando um usuário se inscreveu em uma vaga.
-- Garante que um mesmo usuário não possa se inscrever mais de uma vez na mesma vaga (UNIQUE (id_usuario, id_vaga)).
-- Se um usuário for excluído, suas inscrições são removidas automaticamente (ON DELETE CASCADE).
-- Se uma vaga for excluída, todas as inscrições dessa vaga também são removidas.
CREATE TABLE IF NOT EXISTS projeto.inscricao_vaga (
    id_inscricao UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    id_usuario UUID NOT NULL,
    id_vaga UUID NOT NULL,
    data_inscricao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_inscricao_usuario FOREIGN KEY (id_usuario) REFERENCES projeto.usuario(id_usuario) ON DELETE CASCADE,
    CONSTRAINT fk_inscricao_vaga FOREIGN KEY (id_vaga) REFERENCES projeto.vaga_emprego(id_vaga) ON DELETE CASCADE,
    CONSTRAINT unique_inscricao UNIQUE (id_usuario, id_vaga)
);

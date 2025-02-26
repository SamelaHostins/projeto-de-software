-- Inserindo usuários
INSERT INTO projeto.usuario (nome, sobrenome, data_nascimento, email, telefone, login_usuario, senha, tipo_usuario) VALUES
('Carlos', 'Silva', '1990-05-10', 'carlos@email.com', '11987654321', 'carlos_s', 'Senha123', 1),
('Mariana', 'Souza', '1995-08-22', 'mariana@email.com', '11976543210', 'mariana_s', 'Senha456', 2);

-- Inserindo perfis
INSERT INTO projeto.perfil (id_usuario, historico, qualificacoes, experiencia)
SELECT id_usuario, 'Histórico acadêmico de Carlos', 'Certificação AWS', '5 anos como dev'
FROM projeto.usuario WHERE login_usuario = 'carlos_s';

INSERT INTO projeto.perfil (id_usuario, historico, qualificacoes, experiencia)
SELECT id_usuario, 'Formada em Design Gráfico', 'Adobe Photoshop, Illustrator', '3 anos como designer'
FROM projeto.usuario WHERE login_usuario = 'mariana_s';

-- Inserindo cursos
INSERT INTO projeto.curso (dt_publicacao, descricao, titulo, url_imagem_capa, requisitos, vagas_disponiveis) VALUES
(CURRENT_DATE, 'Curso de desenvolvimento web', 'Web Dev Completo', 'https://imagem.com/curso1.jpg', 'Conhecimento básico de HTML', 20),
(CURRENT_DATE, 'Curso de UX/UI Design', 'UX/UI para iniciantes', 'https://imagem.com/curso2.jpg', 'Interesse em design', 15);

-- Inscrevendo usuários em cursos
INSERT INTO projeto.usuario_curso (id_usuario, id_curso)
SELECT u.id_usuario, c.id_curso
FROM projeto.usuario u, projeto.curso c
WHERE u.login_usuario = 'carlos_s' AND c.titulo = 'Web Dev Completo';

INSERT INTO projeto.usuario_curso (id_usuario, id_curso)
SELECT u.id_usuario, c.id_curso
FROM projeto.usuario u, projeto.curso c
WHERE u.login_usuario = 'mariana_s' AND c.titulo = 'UX/UI para iniciantes';

-- Inserindo empresas
INSERT INTO projeto.empresa (nome, setor, descricao) VALUES
('Tech Solutions', 'Tecnologia', 'Empresa especializada em software'),
('Creative Studio', 'Design', 'Agência de design gráfico e marketing digital');

-- Inserindo vagas de emprego
INSERT INTO projeto.vaga_emprego (titulo, descricao, requisitos, id_empresa)
SELECT 'Desenvolvedor Frontend', 'Desenvolvimento de interfaces web', 'Experiência com Angular e React', e.id_empresa
FROM projeto.empresa e WHERE e.nome = 'Tech Solutions';

INSERT INTO projeto.vaga_emprego (titulo, descricao, requisitos, id_empresa)
SELECT 'Designer Gráfico', 'Criação de materiais digitais', 'Domínio de Photoshop e Illustrator', e.id_empresa
FROM projeto.empresa e WHERE e.nome = 'Creative Studio';

-- Candidatura de usuários a vagas de emprego
INSERT INTO projeto.usuario_vaga (id_usuario, id_vaga)
SELECT u.id_usuario, v.id_vaga
FROM projeto.usuario u, projeto.vaga_emprego v
WHERE u.login_usuario = 'carlos_s' AND v.titulo = 'Desenvolvedor Frontend';

INSERT INTO projeto.usuario_vaga (id_usuario, id_vaga)
SELECT u.id_usuario, v.id_vaga
FROM projeto.usuario u, projeto.vaga_emprego v
WHERE u.login_usuario = 'mariana_s' AND v.titulo = 'Designer Gráfico';

-- Inserindo administradores
INSERT INTO projeto.administrador (id_usuario)
SELECT id_usuario FROM projeto.usuario WHERE login_usuario = 'carlos_s';

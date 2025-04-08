-- Inserindo empresas
INSERT INTO projeto.empresa (id_empresa, nome, setor, descricao) VALUES
(gen_random_uuid(), 'Tech Solutions', 'Tecnologia', 'Empresa especializada em software'),
(gen_random_uuid(), 'Creative Studio', 'Design', 'Agência de design gráfico e marketing digital');

-- Inserindo usuários
INSERT INTO projeto.usuario (
    id_usuario, nome, sobrenome, data_nascimento, email, telefone, login_usuario,
    senha, historico, qualificacoes, experiencia, disponibilidade
) VALUES
(gen_random_uuid(), 'Carlos', 'Silva', '1990-05-10', 'carlos@email.com', '11987654321',
 'carlos_s', 'Senha123', 'Histórico acadêmico de Carlos', 'Certificação AWS', '5 anos como dev', 0),
(gen_random_uuid(), 'Mariana', 'Souza', '1995-08-22', 'mariana@email.com', '11976543210',
 'mariana_s', 'Senha456', 'Formada em Design Gráfico', 'Adobe Photoshop, Illustrator', '3 anos como designer', 0);

-- Inserindo vagas de emprego
INSERT INTO projeto.vaga_emprego (id_vaga, titulo, descricao, requisitos, id_empresa)
SELECT gen_random_uuid(), 'Engenheiro de Software Backend', 'Desenvolvimento de APIs e microsserviços em Java', 'Experiência com Spring Boot e PostgreSQL', e.id_empresa
FROM projeto.empresa e WHERE e.nome = 'Tech Solutions';

INSERT INTO projeto.vaga_emprego (id_vaga, titulo, descricao, requisitos, id_empresa)
SELECT gen_random_uuid(), 'DevOps Engineer', 'Automatização de pipelines de CI/CD e monitoramento de sistemas', 'Conhecimento em Docker, Kubernetes e GitLab CI', e.id_empresa
FROM projeto.empresa e WHERE e.nome = 'Tech Solutions';

INSERT INTO projeto.vaga_emprego (id_vaga, titulo, descricao, requisitos, id_empresa)
SELECT gen_random_uuid(), 'QA Tester', 'Criação e execução de testes automatizados e manuais', 'Selenium, JUnit, metodologias ágeis', e.id_empresa
FROM projeto.empresa e WHERE e.nome = 'Tech Solutions';

INSERT INTO projeto.vaga_emprego (id_vaga, titulo, descricao, requisitos, id_empresa)
SELECT gen_random_uuid(), 'Diretor de Arte', 'Criação de campanhas visuais e identidade visual de marcas', 'Domínio de Photoshop, Illustrator e InDesign', e.id_empresa
FROM projeto.empresa e WHERE e.nome = 'Creative Studio';

INSERT INTO projeto.vaga_emprego (id_vaga, titulo, descricao, requisitos, id_empresa)
SELECT gen_random_uuid(), 'Motion Designer', 'Criação de animações e vídeos institucionais', 'After Effects, Premiere, noções de storytelling', e.id_empresa
FROM projeto.empresa e WHERE e.nome = 'Creative Studio';

INSERT INTO projeto.vaga_emprego (id_vaga, titulo, descricao, requisitos, id_empresa)
SELECT gen_random_uuid(), 'Social Media Designer', 'Criação de conteúdo visual para redes sociais', 'Figma, Canva, noções de marketing digital', e.id_empresa
FROM projeto.empresa e WHERE e.nome = 'Creative Studio';

-- Inscrevendo usuários nas vagas (tabela inscricao_vaga)
INSERT INTO projeto.inscricao_vaga (id_usuario, id_vaga)
SELECT u.id_usuario, v.id_vaga
FROM projeto.usuario u, projeto.vaga_emprego v
WHERE u.login_usuario = 'carlos_s' AND v.titulo = 'Desenvolvedor Frontend';

INSERT INTO projeto.inscricao_vaga (id_usuario, id_vaga)
SELECT u.id_usuario, v.id_vaga
FROM projeto.usuario u, projeto.vaga_emprego v
WHERE u.login_usuario = 'mariana_s' AND v.titulo = 'Designer Gráfico';

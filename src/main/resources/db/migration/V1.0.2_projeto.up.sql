-- Adicionar UUID automático para cada tabela
ALTER TABLE projeto.usuario 
ALTER COLUMN id_usuario SET DEFAULT gen_random_uuid();

ALTER TABLE projeto.perfil 
ALTER COLUMN id_perfil SET DEFAULT gen_random_uuid();

ALTER TABLE projeto.curso 
ALTER COLUMN id_curso SET DEFAULT gen_random_uuid();

ALTER TABLE projeto.empresa 
ALTER COLUMN id_empresa SET DEFAULT gen_random_uuid();

ALTER TABLE projeto.vaga_emprego 
ALTER COLUMN id_vaga SET DEFAULT gen_random_uuid();

ALTER TABLE projeto.administrador 
ALTER COLUMN id_administrador SET DEFAULT gen_random_uuid();

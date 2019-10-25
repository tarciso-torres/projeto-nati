CREATE TABLE tb_curso (
    id                      UUID NOT NULL,
    nome                	VARCHAR(40) NOT NULL,
    descricao               VARCHAR(255) NOT NULL,
    areaDoConhecimento      VARCHAR(15) NOT NULL
);

ALTER TABLE tb_curso ADD CONSTRAINT pk_curso_id PRIMARY KEY(id);

ALTER TABLE tb_curso ADD CONSTRAINT uk_curso_nome UNIQUE (nome);

CREATE TABLE tb_cadeira(
    id                      UUID NOT NULL,
    nome                	VARCHAR(60),
    creditos                INTEGER,
    ementa                  VARCHAR(255)
);

ALTER TABLE tb_cadeira ADD CONSTRAINT pk_cadeira_id PRIMARY KEY(id);

ALTER TABLE tb_cadeira ADD CONSTRAINT uk_cadeira_nome UNIQUE (nome);

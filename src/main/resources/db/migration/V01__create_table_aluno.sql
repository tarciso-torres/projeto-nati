CREATE TABLE tb_aluno(
    id          UUID NOT NULL,
    nome    	VARCHAR(255),
    matricula   VARCHAR NOT NULL,
	email       VARCHAR NOT NULL,
	PRIMARY KEY (id)
);

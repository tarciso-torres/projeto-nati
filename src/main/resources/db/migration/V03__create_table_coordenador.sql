CREATE TABLE tb_coordenador(
    id                      UUID NOT NULL,
    nome                	VARCHAR(255),
    matricula               VARCHAR(10) NOT NULL,
	email                   VARCHAR(30) NOT NULL,
    cpf                     VARCHAR(11) NOT NULL,
    anoAdmissao             VARCHAR(4) NOT NULL,
    sexo                    CHAR(1) NOT NULL,
    celNumero               VARCHAR(11),
    resNumero               VARCHAR(11),
    comNumero               VARCHAR(11),
    logradouro              VARCHAR(30),
    numero                  VARCHAR(5),
    complemento             VARCHAR(30),
    bairro                  VARCHAR(20),
    CEP                     CHAR(8),
    cidade                  VARCHAR(25),
    estado                  CHAR(2)

);

ALTER TABLE tb_coordenador ADD constraint pk_coordenador_id PRIMARY KEY(id);

ALTER TABLE tb_coordenador ADD constraint ck_coordenador CHECK(sexo IN('M','F'));

ALTER TABLE tb_coordenador ADD CONSTRAINT uk_coordenador_email UNIQUE (email);

ALTER TABLE tb_coordenador ADD CONSTRAINT uk_coordenador_cpf UNIQUE (cpf);

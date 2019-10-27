CREATE TABLE tb_admin(
    id                      UUID NOT NULL,
    nome                	VARCHAR(255),
    matricula               VARCHAR(10) NOT NULL,
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
    estado                  CHAR(2),
    usuario_id               UUID NOT NULL

);

ALTER TABLE tb_admin ADD constraint pk_admin_id PRIMARY KEY(id);

ALTER TABLE tb_admin ADD constraint ck_admin_sexo CHECK(sexo IN('M','F'));

ALTER TABLE tb_admin ADD CONSTRAINT uk_admin_cpf UNIQUE (cpf);

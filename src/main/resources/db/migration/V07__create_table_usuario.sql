CREATE TABLE tb_usuario (
    id                      UUID NOT NULL,
	email                   VARCHAR(30) NOT NULL,
    senha                   VARCHAR(50) NOT NULL
);

ALTER TABLE tb_usuario ADD constraint pk_usuario_id PRIMARY KEY(id);

ALTER TABLE tb_usuario ADD CONSTRAINT uk_usuario_email UNIQUE (email);

ALTER TABLE tb_coordenador ADD CONSTRAINT fk_coordenador_usuario
FOREIGN KEY(usuario_id) REFERENCES tb_usuario(id);

ALTER TABLE tb_admin ADD CONSTRAINT fk_admin_usuario
FOREIGN KEY(usuario_id) REFERENCES tb_usuario(id);

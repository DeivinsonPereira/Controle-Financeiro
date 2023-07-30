INSERT INTO tb_usuario(nome, email, senha) VALUES ('Maria Antonia', 'mariaantonia@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG')
INSERT INTO tb_usuario(nome, email, senha) VALUES ('Joao Carlos da Silva', 'joaocarlos@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG')
INSERT INTO tb_usuario(nome, email, senha) VALUES ('Marcos Pereira', 'marcospereira@outlook.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG')
INSERT INTO tb_usuario(nome, email, senha) VALUES ('Henrique de Moraes', 'henriquemoraes@bol.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG')
INSERT INTO tb_usuario(nome, email, senha) VALUES ('Marcia Brugnolli', 'marciab@yahoo.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG')
INSERT INTO tb_usuario(nome, email, senha) VALUES ('Marta Ferrari', 'martaferrari@hotmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG')
INSERT INTO tb_usuario(nome, email, senha) VALUES ('Victor Machado', 'victorm@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG')
INSERT INTO tb_usuario(nome, email, senha) VALUES ('Jonathan da Silva', 'jdasilva@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG')
INSERT INTO tb_usuario(nome, email, senha) VALUES ('Patrick Moreira', 'patrickm@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG')
INSERT INTO tb_usuario(nome, email, senha) VALUES ('Fernanda de Cassia', 'fernandac@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG')

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (1, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (2, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (2, 2);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (3, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (4, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (5, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (6, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (6, 2);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (7, 2);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (8, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (9, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (10, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (10, 2);
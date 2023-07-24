INSERT INTO tb_usuario(nome, email, senha) VALUES ('Maria Antonia', 'mariaantonia@gmail.com', '$2a$10$HYrjsxIRNOt1vDoVFQVypOsoOCOLSY8XpMvlOC2/IbpBLPgcsP.u.')
INSERT INTO tb_usuario(nome, email, senha) VALUES ('Joao Carlos da Silva', 'joaocarlos@gmail.com', '$2a$10$OQHqpEmEw.CE.qneVHs2..5AS7Vm5Yi.sVkK4SdELuhffJvQoTb2m')
INSERT INTO tb_usuario(nome, email, senha) VALUES ('Marcos Pereira', 'marcospereira@outlook.com', '$2a$10$5KN30h5l8VyZXHasLqpJ.ucf66sU3GnSCAe/H4uAaSP3UwJXYZy06')
INSERT INTO tb_usuario(nome, email, senha) VALUES ('Henrique de Moraes', 'henriquemoraes@bol.com', '$2a$10$MUAgdkRrX2hkTnjHrEgT5Oyo4.0YUy54RfpkEwxg1SZguBQfsYBWq')
INSERT INTO tb_usuario(nome, email, senha) VALUES ('Marcia Brugnolli', 'marciab@yahoo.com', '$2a$10$bZOEdI1CQMF/42tih7SVbeNtuf2bVpEMlEuwXR2seu9jfZX72PMpS')
INSERT INTO tb_usuario(nome, email, senha) VALUES ('Marta Ferrari', 'martaferrari@hotmail.com', '$2a$10$VlUGGn1M28RxNpnL0KLBqufHLvpwW26hgwdEbkGnLQoUJUx7Eixay')
INSERT INTO tb_usuario(nome, email, senha) VALUES ('Victor Machado', 'victorm@gmail.com', '$2a$10$WmyjuiPCng/Z7SZh4GIr9eCkmaiE.t5ZoXSnZlyCQhx0Tgm4nOJbu')
INSERT INTO tb_usuario(nome, email, senha) VALUES ('Jonathan da Silva', 'jdasilva@gmail.com', '$2a$10$ZEjRhVHHTtMKQNi0nnpWCeIXSOKoPqm83LV1wmIF8JnI2e0B3X54O')
INSERT INTO tb_usuario(nome, email, senha) VALUES ('Patrick Moreira', 'patrickm@gmail.com', '$2a$10$epc9gvDhmkCO5sgwI6kCcOcPkxrJR2Xz.a7ZMk.1bfuPZtFsulT.e')
INSERT INTO tb_usuario(nome, email, senha) VALUES ('Fernanda de Cassia', 'fernandac@gmail.com', '$2a$10$vVapTirhg61Xh0RiPWBfv.xh6R20I.0LtvTeSLCeibcggfmA6GxFC')

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
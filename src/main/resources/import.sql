INSERT INTO tb_evento (desc_evento, hr_evento)VALUES ('Palestra Michelli Brito', '2023-11-01 20:00:00');
INSERT INTO tb_evento (desc_evento, hr_evento)VALUES ('Palestra Nelio Alves', '2023-11-02 20:00:00');
INSERT INTO tb_evento (desc_evento, hr_evento)VALUES ('Palestra Giuliana Bezerra', '2023-11-03 20:00:00');
INSERT INTO tb_evento (desc_evento, hr_evento)VALUES ('Palestra Leandro Costa', '2023-11-04 20:00:00');
INSERT INTO tb_evento (desc_evento, hr_evento)VALUES ('Palestra Javanauta', '2023-11-05 20:00:00');
INSERT INTO tb_evento (desc_evento, hr_evento)VALUES ('Palestra Leonardo Leitão', '2023-11-06 20:00:00');
INSERT INTO tb_evento (desc_evento, hr_evento)VALUES ('Palestra Marcus Ballen', '2023-11-07 20:00:00');
INSERT INTO tb_evento (desc_evento, hr_evento)VALUES ('Palestra Douglas Souza', '2023-11-08 20:00:00');
INSERT INTO tb_evento (desc_evento, hr_evento)VALUES ('Palestra Fernanda Kipper', '2023-11-09 20:00:00');
INSERT INTO tb_evento (desc_evento, hr_evento)VALUES ('Palestra Francisco Wagner Aquino', '2023-11-10 20:00:00');

INSERT INTO tb_convidado(nome_convidado,rg_convidado,cpf_convidado,tel_convidado,email_convidado)VALUES ('Bruno Gaspar Romeiro Barbosa', '1234567899', '10823410706', '24988549631', 'bgrbarbosa@hotmail.com');
INSERT INTO tb_convidado(nome_convidado,rg_convidado,cpf_convidado,tel_convidado,email_convidado)VALUES ('Gabriela da Fonseca Barbosa', '1234567890', '14552202723', '24988549631', 'gaby_sampaio17@hotmail.com');
INSERT INTO tb_convidado(nome_convidado,rg_convidado,cpf_convidado,tel_convidado,email_convidado)VALUES ('Teste Barbosa', '1234567899', '10823410706', '24988549631', 'testebarbosa@hotmail.com');

INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Bruno', 'Barbosa', 'bgrbarbosa@gmail.com', '$2a$12$Wt0WVWm1wJz5pdLlrgtdL.Sl/2FVWIlxXdFAZXhgq4GoAyIQ60lx.');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Alex', 'Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Maria', 'Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
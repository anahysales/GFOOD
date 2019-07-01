CREATE DATABASE dbgfood;

SHOW DATABASES;

USE dbgfood;

CREATE TABLE cliente (
	id INTEGER NOT NULL AUTO_INCREMENT, 
    nome VARCHAR(100) NOT NULL, 
    endereco VARCHAR(200),
    PRIMARY KEY (id)
);

SELECT * FROM cliente;

INSERT INTO cliente (nome, endereco)
VALUES ("Helior Gustov", "Rua dos abobrinhas, - 3456");


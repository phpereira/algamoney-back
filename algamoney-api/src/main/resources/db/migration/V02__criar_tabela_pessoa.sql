CREATE TABLE pessoa (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    ativo BIT(1) DEFAULT TRUE,
    logradouro VARCHAR(50),
    numero VARCHAR(10),
    complemento VARCHAR(20),
    bairro VARCHAR(25),
    cep BIGINT(8),
    cidade VARCHAR(25),
    estado VARCHAR(25)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado) VALUES
('Alexandre Cherchia', 'Rua das Árvores', 101, 'Fundos', 'Tijuca', 258789321, 'Rio de Janeiro', 'Rio de Janeiro');

INSERT INTO pessoa (nome) VALUES
('Pedro Terra');

INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado) VALUES
('Maria Clara Tobelem', 'Rua das Flores', 20012, 'Apto 304', 'Ipanema', 258789321, 'Rio de Janeiro', 'Rio de Janeiro');

INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado) VALUES
('Catarina Chiment', 'Avenida dos Mananciais', 765, 'Casa 7', 'Cubeiro', 258789321, 'Vitória', 'Espírito Santo');

INSERT INTO pessoa (nome) VALUES
('Matheus Desidere');

INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado) VALUES
('Ronaldo Pereira', 'Estrada dos Cascalhos', 26, 'Casa 23', 'Tatuí', 258789321, 'Curitiba', 'Paraná');

INSERT INTO pessoa (nome) VALUES
('Luíza Assad');

INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado) VALUES
('Carolina Flores', 'Travessa dos Pássaros', 120, 'Sobreloja 2', 'Oxe', 258789321, 'João Pessoa', 'Paraíba');

INSERT INTO pessoa (nome) VALUES
('Carolina Bessoni');

INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado) VALUES
('Estela Gueron', 'Beco dos Rios', 115, 'Apto 1708', 'Bauru', 258789321, 'São Paulo', 'São Paulo');


CREATE TABLE pessoa (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    logradouro VARCHAR(50),
    numero VARCHAR(10),
    complemento VARCHAR(20),
    bairro VARCHAR(25),
    cep BIGINT(8),
    cidade VARCHAR(25),
    estado VARCHAR(25),
    ativo BIT(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES
('Alexandre Cherchia', 'Rua das Árvores', 101, 'Fundos', 'Tijuca', 258789321, 'Rio de Janeiro', 'Rio de Janeiro', true);

INSERT INTO pessoa (nome, ativo) VALUES
('Pedro Terra', true);

INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES
('Maria Clara Tobelem', 'Rua das Flores', 20012, 'Apto 304', 'Ipanema', 258789321, 'Rio de Janeiro', 'Rio de Janeiro', true);

INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES
('Catarina Chiment', 'Avenida dos Mananciais', 765, 'Casa 7', 'Cubeiro', 258789321, 'Vitória', 'Espírito Santo', true);

INSERT INTO pessoa (nome, ativo) VALUES
('Matheus Desidere', true);

INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES
('Ronaldo Pereira', 'Estrada dos Cascalhos', 26, 'Casa 23', 'Tatuí', 258789321, 'Curitiba', 'Paraná', true);

INSERT INTO pessoa (nome, ativo) VALUES
('Luíza Assad', true);

INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES
('Carolina Flores', 'Travessa dos Pássaros', 120, 'Sobreloja 2', 'Oxe', 258789321, 'João Pessoa', 'Paraíba', true);

INSERT INTO pessoa (nome, ativo) VALUES
('Carolina Bessoni', true);

INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES
('Estela Gueron', 'Beco dos Rios', 115, 'Apto 1708', 'Bauru', 258789321, 'São Paulo', 'São Paulo', true);


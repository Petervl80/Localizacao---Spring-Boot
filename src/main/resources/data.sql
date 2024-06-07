create table tb_cidade (
    id_cidade bigint not null primary key,
    nome varchar(50) not null,
    qtd_habitantes bigint
);

insert into tb_cidade
    (id_cidade, nome, qtd_habitantes)
values
    (1, 'Recife', 123456789),
    (2, 'Camaragibe', 1000000)
    (3, 'São Paulo', 2000000)
    (4, 'Rio de Janeiro', 3000000)
    (5, 'João Pessoa', 4000000)
    (6, 'Natal', 5000000)
    (7, 'Porto Alegre', 6000000)
    (8, 'Palmas', 7000000)
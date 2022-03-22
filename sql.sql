CREATE TABLE Livro(
	ID int not null primary key generated always 
            as identity (start with 1 increment by 1),
	titulo varchar(100) not null,
	paginas int,
	nomeAutor varchar(100) not null,
	genero varchar(100),
	editora varchar(100),
	anoPublicacao int
);

CREATE TABLE Usuario(
	ID int not null primary key generated always as identity (start with 1 increment by 1),
	nome varchar(100) not null,
	email varchar(100) not null,
	senha varchar(20) not null,
	idade int,
	curso varchar(100)
);

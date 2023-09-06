/*
* Sistema para gestão de OS
* @author Hideki Ferreira Santos
*/

create database dbsistema;
use dbsistema;
show tables;

create table usuarios(
	id int primary key auto_increment,
	nome varchar(50) not null,
    login varchar(15) not null unique,
    senha varchar(250) not null,
    perfil varchar(10) not null
);

insert into usuarios (nome,login,senha,perfil) values ('Admistrador','admin', md5('admin'),'admin');

create table cliente (
idcli int primary key auto_increment,
nome varchar (50) not null,
fone varchar(18) not null ,
email varchar (50) not null,
cep varchar(10),
endereco varchar(50) not null,
numero varchar (10) not null,
comp varchar (20),
bairro varchar (30) not null,
cidade varchar (30) not null,
uf char(2) not null,
ref varchar (50)
);

create table servicos (
	os int primary key auto_increment,
    dataOS timestamp default current_timestamp,
    servico varchar(200) not null,
    valor decimal(10,2), 
    idcli int not null,
    foreign key (idcli) references cliente(idcli)
    );

create table produtos(
	idproduto int auto_increment primary key,
    nomeproduto varchar(100),
    descricao text,
    categoria varchar(50),
    lote varchar(20),
    datafabricacao varchar(20),
    datavalidade varchar(20),
    preco decimal(10,2),
    imagemproduto varchar(200)
);
create table fornecedores (
codefornecedor int primary key auto_increment,
razaosocial varchar (50) not null,
fone varchar(18) not null ,
cnpj varchar (20) not null,
email varchar (50) not null,
cep varchar(10),
endereco varchar(50) not null,
numero varchar (20) not null,
comp varchar (20),
bairro varchar (30) not null,
cidade varchar(30) not null,
uf char(2) not null,
ref varchar (50)
);

create table produtos (
codeproduto int primary key auto_increment,
barcode varchar(20) not null,
descricao varchar(50) not null,
foto longblob null,
estoque int not null,
estoquemin int not null,
valor varchar(15) not null,
unidademedida char(2) not null,
localarmazenagem varchar (50) not null,
idfornecedor int null, 
foreign key (idfornecedor) references fornecedores(codefornecedor)
);

create database imobiliaria;
use imobiliaria;

drop table cliente;
drop table conta;
drop table estado;
drop table images;
drop table imovel;
drop table user_type;

create table user_type (
	cd_user_type integer not null primary key auto_increment,
	ds_user_type varchar(50)
);

create table conta (
	cd_conta integer not null primary key auto_increment,
	nm_user varchar(50) not null,
	email_user varchar(50),
	login_user varchar(50) not null,
	password_user varchar(50) not null,
	roles_user integer not null,
	constraint fk_conta_user_type foreign key(roles_user) references user_type(cd_user_type)
);

create table cliente(
	cd_cliente integer not null primary key auto_increment,
	nome_cliente varchar(80) not null,
	cpf_cnpj integer,
	email varchar(60),
	telefone integer not null,
	data_nascimento date,
	tel_celular integer(10),
	tel_outro integer(10)
);

create table estado (
	cd_estado integer not null primary key auto_increment,
	nm_estado varchar(2)
);

create table imovel(
	cd_imovel integer not null primary key auto_increment,
	cd_cliente integer,
	descricao varchar(500),
	tipo_imovel varchar(20),
	tipo_operacao varchar(20),
	area_total integer,
	area_util integer,
	nr_vagas_garagen integer,
	nr_quartos integer,
	nr_banheiros integer,
	tem_suite bool,
	tem_churrasqueira bool,
	tem_ar_condicionado bool,
	tem_academia bool,
	tem_armario_embutido bool,
	tem_sacada_varanda bool,
	tem_piscina bool,
	tem_porteiro bool,
	tem_salao_festas bool,
	tem_aposentos_empregada bool,
	valor_mensal_condominio decimal(12,2),
	valor_anual_iptu decimal(12,2),
	valor decimal(12,2),
	status bool not null,
	data_cadastro datetime not null,
	data_ultima_atualizacao datetime not null,
	cep integer not null,
	cidade varchar(50) not null,
	cd_estado integer not null,
	bairro varchar(50),
	rua varchar(50) not null,
	nr varchar(10) not null,
	complemento varchar(150),
	constraint fk_imovel_estado foreign key(cd_imovel) references estado(cd_estado),
	constraint fk_imovel_cliente foreign key(cd_cliente) references cliente(cd_cliente)
);

create table images (
	cd_images integer not null primary key auto_increment,
	descricao varchar(50),
	width integer,
	height integer,
	url varchar(40),
	cd_imovel integer not null,
	constraint fk_images_imovel foreign key(cd_images) references imovel(cd_imovel) 
);
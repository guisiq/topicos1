create table if not exists produto
(
	id serial not null
		constraint produto_pk
			primary key,
	peso integer not null
		constraint produto_peso_id_fk
			references peso,
	nome varchar not null,
	codigo varchar,
	preco double precision not null,
	quantidade_estoque integer default 0 not null,
	data_fabricacao date,
	data_vencimento date
);

alter table produto owner to postgres;


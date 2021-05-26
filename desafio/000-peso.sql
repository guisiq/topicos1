create table if not exists peso
(
	valor double precision,
	tipo_peso integer,
	id serial not null
		constraint peso_pk
			primary key
);

alter table peso owner to postgres;


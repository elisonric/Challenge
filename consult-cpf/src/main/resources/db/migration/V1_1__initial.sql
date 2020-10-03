CREATE TABLE public.person (
	id bigserial NOT NULL,
	adress varchar(255) NULL,
	cpf varchar(255) NULL,
	"name" varchar(255) NULL,
	CONSTRAINT person_pkey PRIMARY KEY (id)
);

CREATE TABLE public.consultation_history (
	id bigserial NOT NULL,
	consultation_date timestamp NULL,
	personid int8 NULL,
	CONSTRAINT consultation_history_pkey PRIMARY KEY (id)
);

ALTER TABLE public.consultation_history ADD CONSTRAINT fkgg1fox71nwkn4qspt531t3kae FOREIGN KEY (personid) REFERENCES person(id);

CREATE TABLE public.purchase_history (
	id bigserial NOT NULL,
	company varchar(255) NULL,
	purchase_date timestamp NULL,
	value float8 NULL,
	personid int8 NULL,
	CONSTRAINT purchase_history_pkey PRIMARY KEY (id)
);

ALTER TABLE public.purchase_history ADD CONSTRAINT fk1qtgcebpvgowcy84nfkmtdne6 FOREIGN KEY (personid) REFERENCES person(id);

CREATE TABLE public.finalcial_moviment (
	id bigserial NOT NULL,
	value float8 NULL,
	personid int8 NULL,
	CONSTRAINT finalcial_moviment_pkey PRIMARY KEY (id)
);

ALTER TABLE public.finalcial_moviment ADD CONSTRAINT fknolgmuqm3fwr00w7ajl8jxh56 FOREIGN KEY (personid) REFERENCES person(id);

INSERT INTO public.person (adress,cpf,"name") VALUES
('rua padre de melo, 26 - blumenau sc','01234567897','jose amarau');

INSERT INTO public.consultation_history (consultation_date,personid) VALUES
('2020-10-01 15:37:31.000',1)
,('2020-10-10 15:37:31.000',1);

INSERT INTO public.finalcial_moviment (value,personid) VALUES
(500,1)
,(-250,1)
,(100,1);

INSERT INTO public.purchase_history (company,purchase_date,value,personid) VALUES
('46.497.160/0001-99','2020-10-01 15:37:31.000',120.25,1)
,('46.497.160/0001-99','2020-10-02 15:37:31.000',150,1);



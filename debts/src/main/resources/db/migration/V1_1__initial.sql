CREATE TABLE public.person (
	id serial NOT NULL,
	cpf varchar(11) NOT NULL,
	"name" varchar(255) NOT NULL,
	adress varchar(255) NOT NULL,
	CONSTRAINT person_pk PRIMARY KEY (id)
);

CREATE TABLE public.debts (
	id serial NOT NULL,
	value numeric NOT NULL,
	collectingcompanyid int4 NOT NULL,
	personid int4 NOT NULL,
	CONSTRAINT debts_pk PRIMARY KEY (id)
);

ALTER TABLE public.debts ADD CONSTRAINT debts_fk0 FOREIGN KEY (personid) REFERENCES person(id);

INSERT INTO person (cpf, name, adress) VALUES ('01234567897', 'jose amarau', 'rua padre de melo, 26 - blumenau sc');
INSERT INTO debts (value, collectingcompanyid, personid) VALUES (256.25,1,1), (100.25,3,1);

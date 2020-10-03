CREATE TABLE public.person (
	id bigserial NOT NULL,
	adress varchar(255) NULL,
	cpf varchar(11) NULL,
	"name" varchar(255) NULL,
	CONSTRAINT person_pkey PRIMARY KEY (id)
);

CREATE TABLE public.person_property (
	id bigserial NOT NULL,
	adress varchar(255) NULL,
	description varchar(255) NULL,
	"type" varchar(255) NULL,
	value float8 NULL,
	personid int8 NULL,
	CONSTRAINT person_property_pkey PRIMARY KEY (id)
);

ALTER TABLE public.person_property ADD CONSTRAINT fkbtg2xahng54s0g1vv2bctxmg3 FOREIGN KEY (personid) REFERENCES person(id);

INSERT INTO public.person (adress,cpf,"name") VALUES
('rua cba','59752815049','jose luz')
,('rua abc','45806213013','raul nando');

INSERT INTO public.person_property (adress,description,"type",value,personid) VALUES
('rua abc','Casa','Imovel',170000,1)
,(NULL,'Carro - VW','Automovel',35000,1)
,('rua cba','Casa','Imovel',130000,2);
CREATE TABLE public.application_user (
	id bigserial NOT NULL,
	"password" varchar(255) NULL,
	"role" varchar(255) NULL,
	username varchar(255) NULL,
	CONSTRAINT application_user_pkey PRIMARY KEY (id)
);

INSERT INTO public.application_user ("password","role",username) VALUES
('$2a$10$ccifOakXKJ.1klFboA6YUOZ5j.AzhR.653IokX69Fk.fNsfcIkvoC','USER','elison');
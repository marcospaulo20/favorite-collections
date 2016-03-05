-- User
create table tb_user (
	id serial NOT NULL,
	sso_id varchar(30) NOT NULL,
	first_name varchar(30) NOT NULL,
	last_name varchar(30) NOT NULL,
	e_mail varchar(60),
	password varchar(10) NOT NULL,	
	date_register timestamp,
	PRIMARY KEY (id),
	UNIQUE(sso_id)
);

-------------------------------------------------------------------------------------------------------------------------
-- Product
create table tb_product (
	id serial NOT NULL,	
	name varchar(100) NOT NULL,
	date_register timestamp without time zone DEFAULT timestamp 'now()' NOT NULL,	
	PRIMARY KEY(id)	
);

insert into tb_product (name) values ('Saint Seiya');
-- delete from tb_product where id = 2;

select * from tb_product;
-------------------------------------------------------------------------------------------------------------------------
-- Category
create table tb_category (
	id serial NOT NULL,
	product_id integer,
	name varchar(60) NOT NULL,
	url varchar(255) NOT NULL,
	date_register timestamp without time zone DEFAULT timestamp 'now()' NOT NULL,	
	PRIMARY KEY (id),
	CONSTRAINT product_category FOREIGN KEY (product_id) REFERENCES tb_product (id)
);

insert into tb_category (product_id, name, url) values (1, 'Gibis', '#/gibis');
insert into tb_category (product_id, name, url) values (1, 'Animações', '#/animacoes');
-- insert into tb_category (product_id, name, url) values ('Bandas', '#/bandas');
-- insert into tb_category (product_id, name, url) values ('Series', '#/series');

select
	c.name, p.name 
from tb_category c
inner join tb_product p
on c.product_id = p.id;
-------------------------------------------------------------------------------------------------------------------------
-- Genre
create table tb_genre (
	id serial NOT NULL,
	name varchar(80) NOT NULL,
	date_register timestamp without time zone DEFAULT timestamp 'now()' NOT NULL,
	PRIMARY KEY(id)	
);
-- drop table tb_genre;
insert into tb_genre (name) values ('Ação');
insert into tb_genre (name) values ('Adaptação');
insert into tb_genre (name) values ('Alternativo');
insert into tb_genre (name) values ('Aventura');
insert into tb_genre (name) values ('Clássico');
insert into tb_genre (name) values ('Drama');
insert into tb_genre (name) values ('Educacional');
insert into tb_genre (name) values ('Erótico');
insert into tb_genre (name) values ('Espada e Magia');
insert into tb_genre (name) values ('Europeu');
insert into tb_genre (name) values ('Fantasia');
insert into tb_genre (name) values ('Fanzine');
insert into tb_genre (name) values ('Faroeste');
insert into tb_genre (name) values ('Ficção Científica');
insert into tb_genre (name) values ('Guerra');
insert into tb_genre (name) values ('Humor');
insert into tb_genre (name) values ('Infantil');
insert into tb_genre (name) values ('Institucional');
insert into tb_genre (name) values ('Juvenil');
insert into tb_genre (name) values ('Mangá');
insert into tb_genre (name) values ('Policial');
insert into tb_genre (name) values ('Revista de Informação');
insert into tb_genre (name) values ('Romance');
insert into tb_genre (name) values ('Super-heróis');
insert into tb_genre (name) values ('Suspense');
insert into tb_genre (name) values ('Terror');



--update tb_genre set name = 'Clássico' where id = 4
select * from tb_genre g;
-------------------------------------------------------------------------------------------------------------------------
-- Status
create table tb_status (
	id serial NOT NULL,	
	name varchar(80) NOT NULL,
	date_register timestamp without time zone DEFAULT timestamp 'now()' NOT NULL,
	PRIMARY KEY(id)
);

insert into tb_status (name) values ('Edição única');
insert into tb_status (name) values ('Em circulação');
insert into tb_status (name) values ('Série completa');
insert into tb_status (name) values ('Título encerrado');

select * from tb_status;
-------------------------------------------------------------------------------------------------------------------------
-- Image
create table tb_image (
	id serial NOT NULL,	
	name varchar(100) NOT NULL,
	url varchar(255) NOT NULL,
	date_register timestamp without time zone DEFAULT timestamp 'now()' NOT NULL,
	PRIMARY KEY (id)
);
insert into tb_image (name, url) 
values ('Volume 1, edição brasileira Conrad', 'resources/images/gibi/saint_seiya/conrad/volume_01.jpg');

-- jbc
insert into tb_image (name, url) 
values ('Volume 1, edição brasileira Jbc', 'resources/images/gibi/saint_seiya/jbc/volume_01.jpg');

insert into tb_image (name, url) 
values ('Volume 2, edição brasileira Jbc', 'resources/images/gibi/saint_seiya/jbc/volume_02.jpg');

insert into tb_image (name, url) 
values ('Volume 3, edição brasileira Jbc', 'resources/images/gibi/saint_seiya/jbc/volume_03.jpg');

insert into tb_image (name, url) 
values ('Volume 4, edição brasileira Jbc', 'resources/images/gibi/saint_seiya/jbc/volume_04.jpg');

insert into tb_image (name, url) 
values ('Volume 5, edição brasileira Jbc', 'resources/images/gibi/saint_seiya/jbc/volume_05.jpg');

insert into tb_image (name, url) 
values ('Volume 6, edição brasileira Jbc', 'resources/images/gibi/saint_seiya/jbc/volume_06.jpg');

insert into tb_image (name, url) 
values ('Volume 7, edição brasileira Jbc', 'resources/images/gibi/saint_seiya/jbc/volume_07.jpg');
select * from tb_image;
-------------------------------------------------------------------------------------------------------------------------

-- Gibis

-------------------------------------------------------------------------------------------------------------------------
-- Editora
create table tbgib_publishing_company (
	id serial NOT NULL,
	name varchar(100) NOT NULL,	
	name_edition varchar(100) NOT NULL,
	date_register timestamp without time zone DEFAULT timestamp 'now()' NOT NULL,
	PRIMARY KEY(id)
);

insert into tbgib_publishing_company (name, name_edition) values ('Conrad', 'Cavaleiros do Zodíaco');
insert into tbgib_publishing_company (name, name_edition) values ('JBC', 'Cavaleiros do Zodíaco');

-- update tbgib_publishing_company SET name = 'JBC' where id = 2;

-- select * from tbgib_publishing_company
-------------------------------------------------------------------------------------------------------------------------
-- Gibi
create table tbgib_gibi (
	id serial NOT NULL,
	product_id integer NOT NULL,
	status_id integer NOT NULL,	
	image_id integer,
	written varchar(100) NOT NULL,
	published_initial date NOT NULL,
	published_final date,
	magazine varchar(100),
	licensor varchar(100),	
	date_register timestamp without time zone DEFAULT timestamp 'now()' NOT NULL,
	PRIMARY KEY(id),
	CONSTRAINT product_gibi FOREIGN KEY (product_id) REFERENCES tb_product (id)
);

insert into tbgib_gibi 
	(product_id, status_id, image_id, written, published_initial, published_final, magazine, licensor)
values
	(1, 3, 1, 'Masami Kurumada', '1986-01-02', '1990-12-02', 'Weekly Shonen Jump', 'Shueisha(Tankoubon) e (Kazeban)');
--delete from tbgib_gibi where id = 1	
-------------------------------------------------------------------------------------------------------------------------
-- Gibi and Publishing Company
create table gibi_publishing_company (
	gibi_id integer NOT NULL,
	publishing_company_id integer NOT NULL,
	PRIMARY KEY (gibi_id, publishing_company_id),
	CONSTRAINT fk_gibi FOREIGN KEY (gibi_id) REFERENCES tbgib_gibi (id),
	CONSTRAINT fk_publishing_company FOREIGN KEY (publishing_company_id) REFERENCES tbgib_publishing_company (id)
);
insert into gibi_publishing_company (gibi_id, publishing_company_id) values (1, 1);
insert into gibi_publishing_company (gibi_id, publishing_company_id) values (1, 2);

--delete from gibi_publishing_company where gibi_id = 1and publishing_company_id = 2
-- select * from tbgib_publishing_company
-------------------------------------------------------------------------------------------------------------------------
-- Gibi and Genre
create table gibi_genre (
	gibi_id integer NOT NULL,
	genre_id integer NOT NULL,
	PRIMARY KEY (gibi_id, genre_id),
	CONSTRAINT fk_gibi FOREIGN KEY (gibi_id) REFERENCES tbgib_gibi (id),
	CONSTRAINT fk_genre FOREIGN KEY (genre_id) REFERENCES tb_genre (id)
);

insert into gibi_genre (gibi_id, genre_id) values (1, 3);
insert into gibi_genre (gibi_id, genre_id) values (1, 5);
insert into gibi_genre (gibi_id, genre_id) values (1, 10);
insert into gibi_genre (gibi_id, genre_id) values (1, 19);
insert into gibi_genre (gibi_id, genre_id) values (1, 26);

--delete from gibi_genre where gibi_id = 1 and genre_id = 3;

-- select * from tb_genre;
-------------------------------------------------------------------------------------------------------------------------

-- Edição / Edition
create table tbgib_edition (
	id serial NOT NULL,
	image_id integer NOT NULL,
	art varchar(255),
	editor varchar(255),
	number_page integer NOT NULL,	
	comic_book_format varchar(60),
	cover_price float,   
	japan_release date,
	brasil_release date,
	summary text,
	date_register timestamp without time zone DEFAULT timestamp 'now()' NOT NULL,
	PRIMARY KEY(id)	
);

insert into tbgib_edition 
	(image_id, art, editor, number_page, comic_book_format, cover_price, japan_release, brasil_release)
values 
	(1, 'Masami Kurumada', 'Cassius Medauar', 116, '(13 x 20,5 cm) Preto e branco/Lombada quadrada', 3.50, '1986-09-01', '2000-11-01');

-- Jbc
insert into tbgib_edition 
	(image_id, art, editor, number_page, comic_book_format, cover_price, japan_release, brasil_release)
values 
	(2, 'Masami Kurumada', '', 184, '(13 x 20,5 cm) Preto e branco/Lombada quadrada', 10.90, '1986-09-01', '2012-01-03');
	
insert into tbgib_edition 
	(image_id, art, editor, number_page, comic_book_format, cover_price, japan_release, brasil_release)
values 
	(3, 'Masami Kurumada', '', 184, '(13 x 20,5 cm) Preto e branco/Lombada quadrada', 10.90, '1986-09-01', '2012-02-03');	

insert into tbgib_edition 
	(image_id, art, editor, number_page, comic_book_format, cover_price, japan_release, brasil_release)
values 
	(4, 'Masami Kurumada', '', 184, '(13 x 20,5 cm) Preto e branco/Lombada quadrada', 10.90, '1986-09-01', '2012-03-03');
	
insert into tbgib_edition 
	(image_id, art, editor, number_page, comic_book_format, cover_price, japan_release, brasil_release)
values 
	(5, 'Masami Kurumada', '', 184, '(13 x 20,5 cm) Preto e branco/Lombada quadrada', 10.90, '1986-09-01', '2012-04-03');	

insert into tbgib_edition 
	(image_id, art, editor, number_page, comic_book_format, cover_price, japan_release, brasil_release)
values 
	(6, 'Masami Kurumada', '', 184, '(13 x 20,5 cm) Preto e branco/Lombada quadrada', 10.90, '1986-09-01', '2012-05-03');	

insert into tbgib_edition 
	(image_id, art, editor, number_page, comic_book_format, cover_price, japan_release, brasil_release)
values 
	(7, 'Masami Kurumada', '', 184, '(13 x 20,5 cm) Preto e branco/Lombada quadrada', 10.90, '1986-09-01', '2012-06-03');	
	
insert into tbgib_edition 
	(image_id, art, editor, number_page, comic_book_format, cover_price, japan_release, brasil_release)
values 
	(8, 'Masami Kurumada', '', 184, '(13 x 20,5 cm) Preto e branco/Lombada quadrada', 10.90, '1986-09-01', '2012-07-03');
-------------------------------------------------------------------------------------------------------------------------
-- Chapter
create table tbgib_chapter (
	id serial NOT NULL,
	name_saga varchar(255) NOT NULL,
	name_bow varchar(255) NOT NULL,
	PRIMARY KEY(id)
);

insert into tbgib_chapter (name_saga, name_bow)
values ('Os Cavaleiros Sagrados da Deusa Atena', 'Saga do Santúario - Parte 1');
-------------------------------------------------------------------------------------------------------------------------
-- Edition and Chapter
create table edition_chapter (
	edition_id integer NOT NULL,
	chapter_id integer NOT NULL,
	PRIMARY KEY(edition_id, chapter_id),
	CONSTRAINT fk_edition FOREIGN KEY (edition_id) REFERENCES tbgib_edition (id),
	CONSTRAINT fk_chapter FOREIGN KEY (chapter_id) REFERENCES tbgib_chapter (id)
);

insert into edition_chapter values (1, 1);
-------------------------------------------------------------------------------------------------------------------------
-- Publishing Company and Edition
create table publishing_company_edition (
	publishing_company_id integer NOT NULL,
	edition_id integer NOT NULL,	
	PRIMARY KEY(publishing_company_id, edition_id),
	CONSTRAINT fk_chapter FOREIGN KEY (publishing_company_id) REFERENCES tbgib_publishing_company (id),
	CONSTRAINT fk_edition FOREIGN KEY (edition_id) REFERENCES tbgib_edition (id)	
);

insert into publishing_company_edition values (1, 1);
insert into publishing_company_edition values (2, 2);
insert into publishing_company_edition values (2, 3);
insert into publishing_company_edition values (2, 4);
insert into publishing_company_edition values (2, 5);
insert into publishing_company_edition values (2, 6);
insert into publishing_company_edition values (2, 7);
insert into publishing_company_edition values (2, 8);
-------------------------------------------------------------------------------------------------------------------------
-- Animação

-------------------------------------------------------------------------------------------------------------------------
-- Sobre / About
create table tbanim_about (
	id serial NOT NULL,	
	product_id integer,	
	directed varchar(80),
	produced varchar(80),
	written varchar(80),
	music varchar(80),
	stidio varchar(80),
	original_view date,
	date_register timestamp without time zone DEFAULT timestamp 'now()' NOT NULL,
	PRIMARY KEY(id)
);

-- Episodio / Episode
create table tbanim_episode (
	id serial NOT NULL,
	product_id integer,
	name_saga varchar(255),
	name_bow varchar(255),
	number integer,
	title_english varchar(255),
	title_brazil varchar(255),
	original_air_date date,
	summary text,
	date_register timestamp without time zone DEFAULT timestamp 'now()' NOT NULL,
	PRIMARY KEY(id)
);
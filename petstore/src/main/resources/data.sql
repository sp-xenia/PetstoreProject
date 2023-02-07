insert into address (id, street, city, state, zip) values (1, 'Nome strada', 'Nome città', 'Stato', '87036');
insert into category (id,name) values (1,'Pet');
insert into pet (id,name,photo_urls,status,category_id) values (1,'Boo','url','AVAILABLE',1);

commit;
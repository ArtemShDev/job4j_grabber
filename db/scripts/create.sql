create table if not exists post (
	id serial primary key,
 	name text,
 	text text,	
 	link text,
     	created timestamp
 );

ALTER TABLE post ADD UNIQUE (link);
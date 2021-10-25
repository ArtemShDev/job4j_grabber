 CREATE TABLE company
 (
     id integer NOT NULL,
     name character varying,
     CONSTRAINT company_pkey PRIMARY KEY (id)
 );

 CREATE TABLE person
 (
     id integer NOT NULL,
     name character varying,
     company_id integer references company(id),
     CONSTRAINT person_pkey PRIMARY KEY (id)
 );
 insert into company(id, name) values(1, 'comp1');
 insert into company(id, name) values(2, 'comp2');
 insert into company(id, name) values(3, 'comp3');
 insert into company(id, name) values(4, 'comp4');
 insert into company(id, name) values(5, 'comp5');
 insert into person(id, name, company_id) values(1, 'Ivan', 1);
 insert into person(id, name, company_id) values(2, 'Matvey', 2);
 insert into person(id, name, company_id) values(3, 'Donald', 2);
 insert into person(id, name, company_id) values(4, 'Artem', 3);
 insert into person(id, name, company_id) values(5, 'Mark', 4);
 insert into person(id, name, company_id) values(6, 'Maks', 5);
 insert into person(id, name, company_id) values(9, 'Tom', 5);
 insert into person(id, name, company_id) values(8, 'Mike', 5);
 
select p.name person, c.name company, c.id id_comp from person as p join company as c on c.id = p.company_id where c.id != 5;
select c.name company, count(p.name) person from person as p join company as c on c.id = p.company_id group by c.name order by count(p.name) desc limit 1;
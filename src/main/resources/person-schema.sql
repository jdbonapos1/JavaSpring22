drop table if exists person CASCADE;
create table person (id integer generated by default as identity, age integer not null, height integer not null, name varchar(255) not null, primary key (id));

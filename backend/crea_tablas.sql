create table if not exists area
 (id SERIAL primary key,
 nombre varchar(100));

create table if not exists rol
(id SERIAL primary key,
nombre varchar(50));

create table if not exists estado
(id SERIAL primary key,
nombre varchar(50));

create table if not exists usuario
(id SERIAL primary key, 
 nombre varchar(50),
 apellido varchar(50),
 rut varchar(50) unique,
 correo varchar(50),
 clave varchar(50),
 id_rol int,
 id_area int,
 constraint fk_role foreign key(id_rol) references rol(id),
 constraint fk_area foreign key(id_area) references area(id));
 
 create table if not exists ticket
 (id SERIAL primary key,
 nombre varchar(50),
 apellido varchar(50),
 rut varchar(50),
 correo varchar(50),
 asunto varchar(500),
 id_estado int,
 id_area int,
 constraint fk_estado foreign key(id_estado) references estado(id),
 constraint fk_area foreign key(id_area) references area(id));
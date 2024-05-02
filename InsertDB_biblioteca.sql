SET AUTOCOMMIT ON;

--Autores
INSERT INTO AUTOR(nombre_autor) VALUES
('Thomas Harris'),
('Henry Ibsen'),
('George Orwell'),
('Jane Austen'),
('Gabriel García Márquez'),
('Haruki Murakami'),
('J.K. Rowling');

--IDIOMAS
INSERT INTO IDIOMA(nombre_idioma) VALUES
('Inglés'),
('Español'),
('Francés'),
('Alemán'),
('Chino'),
('Portugués'),
('Italiano');

--Tabla Biblioteca material
INSERT INTO biblioteca_material(cantidad,id_autor,id_idioma,descripcion,titulo) VALUES
(3,1,1,'The most Amazing Thriller','The Red Dragon');
INSERT INTO biblioteca_material(cantidad,id_autor,id_idioma,descripcion,titulo) VALUES
(2,1,1,'The most Amazing Thriller','The silence of Lambs');

INSERT INTO biblioteca_material(cantidad, id_autor, id_idioma, descripcion, titulo) 
VALUES (5, 3, 1, 'Una sátira política clásica', '1984');

INSERT INTO biblioteca_material(cantidad, id_autor, id_idioma, descripcion, titulo) 
VALUES (4, 4, 2, 'Una novela de amor y pasión', 'Orgullo y prejuicio');

INSERT INTO biblioteca_material(cantidad, id_autor, id_idioma, descripcion, titulo) 
VALUES (2, 5, 2, 'Una obra maestra del realismo mágico', 'Cien años de soledad');

INSERT INTO biblioteca_material(cantidad, id_autor, id_idioma, descripcion, titulo) 
VALUES (3, 6, 1, 'Una novela surrealista llena de misterio', '1Q84');

INSERT INTO biblioteca_material(cantidad, id_autor, id_idioma, descripcion, titulo) 
VALUES (1, 7, 1, 'Una saga de fantasía épica', 'Harry Potter and the Philosopher''s Stone');


--Tabla Libro
INSERT INTO LIBRO(id_material,es_obra_de_referencia,ISBN,LOGO) VALUES
(1,1,'978-0099532934','ninguno');

--Tabla Mora
INSERT INTO mora(costo_prestamo,mora_prestamo) VALUES
(2.25,2.25);

--Tabla Usuario
INSERT INTO USUARIO(correo,nombre_usuario,PASSWORD,USERNAME) VALUES
('admin@gmail.com','admin','1234','admin');

--Tabla Miembro
INSERT INTO MIEMBRO(CARNET,ID_USUARIO,PENALIZADO) VALUES 
('DD23001',1,0);

--Tabla Presta
INSERT INTO presta(id_material,id_mora,esta_activo,fecha_prestamo,fecha_retorno) VALUES
(1,1,1,TO_DATE('2024-06-12','yyyy-MM-DD'),TO_DATE('2024-06-14','yyyy-MM-DD'));

SELECT bm.titulo,bm.descripcion,l.es_obra_de_referencia,bm.cantidad
FROM LIBRO l INNER JOIN biblioteca_material bm
ON l.id_material=bm.ID_MATERIAL_BIBLIOTECA
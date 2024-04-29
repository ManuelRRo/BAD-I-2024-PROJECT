INSERT INTO AUTOR(nombre_autor) VALUES
('Thomas Harris'),
('Henry Ibsen');

INSERT INTO IDIOMA(nombre_idioma) VALUES
('Inglés'),
('Español');

INSERT INTO biblioteca_material(cantidad,id_autor,id_idioma,descripcion,titulo) VALUES
(3,1,1,'The most Amazing Thriller','The Red Dragon');

INSERT INTO mora(costo_prestamo,mora_prestamo) VALUES
(2.25,2.25);

INSERT INTO USUARIO(correo,nombre_usuario,PASSWORD,USERNAME) VALUES
('admin@gmail.com','admin','1234','admin');

INSERT INTO MIEMBRO(CARNET,ID_USUARIO,PENALIZADO) VALUES 
('DD23001',1,0);

INSERT INTO presta(id_material,id_mora,esta_activo,fecha_prestamo,fecha_retorno) VALUES
(1,1,1,TO_DATE('2024-06-12','yyyy-MM-DD'),TO_DATE('2024-06-14','yyyy-MM-DD'));
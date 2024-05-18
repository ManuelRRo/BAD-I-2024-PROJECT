SET AUTOCOMMIT ON;

--Rol
INSERT INTO ROL(nombre_rol) VALUES ('Admin');
INSERT INTO ROL(nombre_rol) VALUES ('bibliotecario');
INSERT INTO ROL(nombre_rol) VALUES ('miembro');
INSERT INTO ROL(nombre_rol) VALUES ('estudiante');
--Autores
INSERT INTO AUTOR(nombre_autor) VALUES
('Thomas Harris'),
('Henry Ibsen'),
('George Orwell'),
('Jane Austen'),
('Gabriel Garc�a M�rquez'),
('Haruki Murakami'),
('J.K. Rowling');

--IDIOMAS
INSERT INTO IDIOMA(nombre_idioma) VALUES
('Ingl�s'),
('Espa�ol'),
('Franc�s'),
('Alem�n'),
('Chino'),
('Portugu�s'),
('Italiano');

--Tabla Biblioteca material
INSERT INTO biblioteca_material(cantidad,id_autor,id_idioma,descripcion,titulo) VALUES
(3,1,1,'The most Amazing Thriller','The Red Dragon');
INSERT INTO biblioteca_material(cantidad,id_autor,id_idioma,descripcion,titulo) VALUES
(2,1,1,'The most Amazing Thriller','The silence of Lambs');

INSERT INTO biblioteca_material(cantidad, id_autor, id_idioma, descripcion, titulo) 
VALUES (5, 3, 1, 'Una s�tira pol�tica cl�sica', '1984');

INSERT INTO biblioteca_material(cantidad, id_autor, id_idioma, descripcion, titulo) 
VALUES (4, 4, 2, 'Una novela de amor y pasi�n', 'Orgullo y prejuicio');

INSERT INTO biblioteca_material(cantidad, id_autor, id_idioma, descripcion, titulo) 
VALUES (2, 5, 2, 'Una obra maestra del realismo m�gico', 'Cien a�os de soledad');

INSERT INTO biblioteca_material(cantidad, id_autor, id_idioma, descripcion, titulo) 
VALUES (3, 6, 1, 'Una novela surrealista llena de misterio', '1Q84');

INSERT INTO biblioteca_material(cantidad, id_autor, id_idioma, descripcion, titulo) 
VALUES (1, 7, 1, 'Una saga de fantas�a �pica', 'Harry Potter and the Philosopher''s Stone');


--Tabla Libro
INSERT INTO LIBRO(id_material,es_obra_de_referencia,ISBN,LOGO) VALUES
(1,1,'978-0099532934','ninguno');

--Tabla Usuario
INSERT INTO USUARIO(CORREO, NOMBRE_USUARIO, PASSWORD, USERNAME) 
VALUES 
('admin@gmail.com','admin','1234','admin'),
('maria@gmail.com', 'Maria Rodriguez', '5678', 'marita'),
('pedro@gmail.com','Pedro Gonzalez','1234','pedrito'),
('juan@gmail.com', 'Juan Perez', 'abcd', 'juanito'),
('laura@gmail.com', 'Laura Martinez', 'efgh', 'laurita'),
('carlos@gmail.com', 'Carlos Sanchez', 'ijkl', 'carlitos'),
('ana@gmail.com', 'Ana Lopez', 'mnop', 'anita');

--Tabla Miembro
INSERT INTO MIEMBRO(CARNET,ID_USUARIO,PENALIZADO) VALUES 
('DD23001',1,0),
('DD23002', 2, 0),
('DD23003', 3, 0),
('DD23004', 4, 0),
('DD23005', 5, 0),
('DD23006', 6, 0),
('DD23007', 7, 0);

--Tabla Mora
INSERT INTO mora(costo_prestamo,mora_prestamo,carnet_miembro) VALUES
(2.25,2.25,'DD23001');

--Tabla Presta
INSERT INTO presta(id_material,id_mora,esta_activo,fecha_prestamo,fecha_retorno) VALUES
(1,1,1,TO_DATE('2024-06-12','yyyy-MM-DD'),TO_DATE('2024-06-14','yyyy-MM-DD'));

SELECT bm.titulo,bm.descripcion,l.es_obra_de_referencia,bm.cantidad
FROM LIBRO l INNER JOIN biblioteca_material bm
ON l.id_material=bm.ID_MATERIAL_BIBLIOTECA
--#########################################################################################3
-- ALTER PARA CONDICIONES ESPECIALES
-- Al crear una nueva mora el campo mora costo_prestamo = 2.50  
-- es 0.00 y mora_presta es 0.0
ALTER TABLE MORA
MODIFY COSTO_PRESTAMO FLOAT DEFAULT 2.50;

ALTER TABLE MORA
MODIFY MORA_PRESTAMO FLOAT DEFAULT 0.00;

ALTER TABLE PRESTA
MODIFY ESTA_ACTIVO NUMBER(1,0) DEFAULT 1;
--TRIGGERS--------------------------------------------------------------------------------
CREATE OR REPLACE TRIGGER ValidarFecha
  BEFORE INSERT OR UPDATE ON BIBLIOTECARIO.PRESTA
  FOR EACH ROW
  WHEN (NEW.FECHA_RETORNO < NEW.FECHA_PRESTAMO)
DECLARE
    salida VARCHAR2(100) := 'Fecha de prestamo mayor que fecha de retorno';
BEGIN
    RAISE_APPLICATION_ERROR(-20001, salida);
END;
/
------------------------------------------------------------------------------------------
--########################################################################################
--PROCEDIMIENTOS
--#########################################################################################
--OBTENER ID DE LA MORA
--#########################################################################################
CREATE OR REPLACE PROCEDURE getIdMora
(carnet in mora.carnet_miembro%TYPE, id_mora_out out mora.id_mora%TYPE)
AS
BEGIN
    SELECT id_mora INTO id_mora_out FROM MORA WHERE MORA.CARNET_MIEMBRO = carnet;
END;
EXECUTE getIdMora('DD23001',v_id_mora);
--#############################################################################################
--INSERTAR MORA y obtener id de inserccion
--#############################################################################################
create or replace PROCEDURE insertarMora (
    carnet IN mora.carnet_miembro%TYPE,
    id_mora_out OUT mora.id_mora%TYPE
)
AS
BEGIN
    -- Insertar el registro en la tabla MORA y obtener su ID de inserción
    INSERT INTO MORA (CARNET_MIEMBRO) 
    VALUES (carnet)
    RETURNING id_mora INTO id_mora_out;

    COMMIT; -- Realizar la confirmación de la transacción
END;
--##################################################################################################
--REGISTRAR PRESTAMO
--##################################################################################################
create or replace PROCEDURE registrarPrestamos (
    carnet IN mora.carnet_miembro%TYPE,
    id_material_nuevo IN presta.id_material%TYPE
) 
AS
    id_mora_out mora.id_mora%TYPE; -- Variable para almacenar el resultado de getIdMora
BEGIN
    -- Insertar en MATERIALES_MIEMBROS
    INSERT INTO MATERIALES_MIEMBROS (CARNET_MIEMBRO, MATERIAL_MIEMBRO) VALUES (carnet, id_material_nuevo);

    -- Insertar en MORA
    --INSERT INTO MORA (CARNET_MIEMBRO) VALUES (carnet);
    insertarMora(carnet,id_mora_out);

    -- Obtener id_mora usando getIdMora
    --getIdMora(carnet, id_mora_out);

    -- Insertar en presta
    INSERT INTO presta (id_material, id_mora, fecha_prestamo, fecha_retorno) 
    VALUES (id_material_nuevo, id_mora_out, TO_DATE('2024-06-12','yyyy-MM-DD'), TO_DATE('2024-06-14','yyyy-MM-DD'));
END;
--##################################################################################
--MostrarLibrosPorAutor
--##################################################################################
CREATE OR REPLACE PROCEDURE LISTADELIBROSPORAUTOR (
    nombreAutor IN autor.nombre_autor%TYPE,
    CURSOR_ OUT SYS_REFCURSOR,
    o_sqlcode OUT NUMBER,
    o_sqlmsg  OUT VARCHAR2
)
AS
BEGIN
    IF nombreAutor IS NULL OR nombreAutor = '' THEN
        o_sqlcode := -1;
        o_sqlmsg := 'El nombre del autor está vacío.';
    ELSE
        o_sqlcode := 0;
        o_sqlmsg := 'Libros encontrados.';
        OPEN CURSOR_ FOR
            SELECT bm.titulo, bm.descripcion, a.nombre_autor
            FROM biblioteca_material bm
            INNER JOIN autor a ON bm.id_autor = a.id_autor
            WHERE LOWER(a.nombre_autor) LIKE '%' || LOWER(nombreAutor) || '%';
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        o_sqlcode := SQLCODE;
        o_sqlmsg := 'No se encontraron libros de ese autor.';
END;

SET SERVEROUTPUT ON;
COMMIT;
VARIABLE miCursor REFCURSOR;
VARIABLE opcode NUMBER;
VARIABLE msg varchar2;
EXECUTE listaDeLibrosPorAutor('', :miCursor,:opcode,:msg);
PRINT msg;
--######################################################################################################
-- UNA FORMA DE EJECUTAR getIdMora
--######################################################################################################
DECLARE
    v_carnet mora.carnet_miembro%TYPE := 'DD23001'; -- Ingresa aquí el valor del carnet que deseas buscar
    v_id_mora mora.id_mora%TYPE;
BEGIN
    getIdMora(v_carnet, v_id_mora); -- Llamada al procedimiento
    DBMS_OUTPUT.PUT_LINE('El ID de mora para el carnet ' || v_carnet || ' es: ' || v_id_mora);
END;
/
--########################################################################################################
--GUARDAR UN PRESTAMO
--#######################################################################################################
BEGIN
    registrarPrestamos('DD23001',2); -- Llama al procedimiento con el carnet 'DD23001' y el id_material_nuevo 1
    COMMIT; -- Realiza la confirmación de la transacción
END;
/

CALL registrarPrestamos('DD23001',5);
--#####################################################################################################3



alter session set "_oracle_script"=true;
CREATE USER bibliotecario IDENTIFIED BY "bibliotecario";

GRANT CREATE SESSION TO bibliotecario;
GRANT CREATE TABLE TO bibliotecario;
GRANT DELETE ANY TABLE, UPDATE ANY TABLE, INSERT ANY TABLE TO bibliotecario;
GRANT CREATE PROCEDURE TO bibliotecario;
GRANT CREATE SEQUENCE TO bibliotecario;
ALTER USER bibliotecario QUOTA UNLIMITED ON users;
GRANT CONNECT TO bibliotecario;

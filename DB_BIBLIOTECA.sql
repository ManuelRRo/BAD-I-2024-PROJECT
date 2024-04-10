/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     4/8/2024 11:28:51 PM                         */
/*==============================================================*/


alter table BIBLIOTECAMATERIAL
   drop constraint FK_BIBLIOTE_REFERENCE_AUTOR;

alter table BIBLIOTECAMATERIAL
   drop constraint FK_BIBLIOTE_RELATIONS_IDIOMA;

alter table CD
   drop constraint FK_CD_RELATIONS_BIBLIOTE;

alter table DETALLEPRESTAMO
   drop constraint FK_DETALLEP_DETALLEPR_MORA;

alter table DETALLEPRESTAMO
   drop constraint FK_DETALLEP_DETALLEPR_BIBLIOTE;

alter table DETALLETRANSACCIONMEMBRESIA
   drop constraint FK_DETALLET_RELATIONS_MIEMBRO;

alter table DVD
   drop constraint FK_DVD_RELATIONS_BIBLIOTE;

alter table LIBRO
   drop constraint FK_LIBRO_RELATIONS_BIBLIOTE;

alter table MAPA
   drop constraint FK_MAPA_RELATIONS_BIBLIOTE;

alter table MAPA
   drop constraint FK_MAPA_RELATIONS_FORMATO;

alter table MAPA
   drop constraint FK_MAPA_RELATIONS_TAMANO;

alter table MAPA
   drop constraint FK_MAPA_RELATIONS_CDU;

alter table MAPA
   drop constraint FK_MAPA_RELATIONS_MATERIAL;

alter table MIEMBRO
   drop constraint FK_MIEMBRO_RELATIONS_USUARIO;

alter table MORA
   drop constraint FK_MORA_RELATIONS_MIEMBRO;

alter table POSEE
   drop constraint FK_POSEE_POSEE_ROL;

alter table POSEE
   drop constraint FK_POSEE_POSEE2_PERMISO;

alter table PRESTAMOSMIEMBROS
   drop constraint FK_PRESTAMO_PRESTAMOS_MIEMBRO;

alter table PRESTAMOSMIEMBROS
   drop constraint FK_PRESTAMO_PRESTAMOS_BIBLIOTE;

alter table REVISTA
   drop constraint FK_REVISTA_RELATIONS_BIBLIOTE;

alter table USA
   drop constraint FK_USA_USA_USUARIO;

alter table USA
   drop constraint FK_USA_USA2_ROL;

alter table USUARIO
   drop constraint FK_USUARIO_RELATIONS_TIPOUSUA;

alter table USUARIO
   drop constraint FK_USUARIO_RELATIONS_MIEMBRO;

drop table AUTOR cascade constraints;

drop index RELATIONSHIP_12_FK;

drop table BIBLIOTECAMATERIAL cascade constraints;

drop table CD cascade constraints;

drop table CDU cascade constraints;

drop index PRESTA3_FK;

drop table DETALLEPRESTAMO cascade constraints;

drop index RELATIONSHIP_10_FK;

drop table DETALLETRANSACCIONMEMBRESIA cascade constraints;

drop table DVD cascade constraints;

drop table FORMATO cascade constraints;

drop table IDIOMA cascade constraints;

drop table LIBRO cascade constraints;

drop index RELATIONSHIP_17_FK;

drop index RELATIONSHIP_16_FK;

drop index RELATIONSHIP_15_FK;

drop table MAPA cascade constraints;

drop table MATERIAL cascade constraints;

drop index RELATIONSHIP_9_FK;

drop table MIEMBRO cascade constraints;

drop index RELATIONSHIP_13_FK;

drop table MORA cascade constraints;

drop table PERMISO cascade constraints;

drop index POSEE2_FK;

drop index POSEE_FK;

drop table POSEE cascade constraints;

drop index PRESTA2_FK;

drop table PRESTAMOSMIEMBROS cascade constraints;

drop table REVISTA cascade constraints;

drop table ROL cascade constraints;

drop table TAMANO cascade constraints;

drop table TIPOUSUARIO cascade constraints;

drop index USA2_FK;

drop index USA_FK;

drop table USA cascade constraints;

drop index RELATIONSHIP_11_FK;

drop index RELATIONSHIP_8_FK;

drop table USUARIO cascade constraints;

/*==============================================================*/
/* Table: AUTOR                                                 */
/*==============================================================*/
create table AUTOR 
(
   ID_AUTOR             INTEGER              not null,
   NOMBRE_AUTOR         CHAR(255)            not null,
   constraint PK_AUTOR primary key (ID_AUTOR)
);

/*==============================================================*/
/* Table: BIBLIOTECAMATERIAL                                    */
/*==============================================================*/
create table BIBLIOTECAMATERIAL 
(
   ID_IDIOMA            INTEGER,
   ID_MATERIAL_BIBLIOTECA INTEGER              not null,
   ID_AUTOR             INTEGER,
   CANTIDAD             INTEGER,
   DESCRIPCION          CHAR(255),
   COSTO_PRESTAMO       NUMBER(2,2),
   TITULO               CHAR(255),
   constraint PK_BIBLIOTECAMATERIAL primary key (ID_MATERIAL_BIBLIOTECA)
);

/*==============================================================*/
/* Index: RELATIONSHIP_12_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_12_FK on BIBLIOTECAMATERIAL (
   ID_IDIOMA ASC
);

/*==============================================================*/
/* Table: CD                                                    */
/*==============================================================*/
create table CD 
(
   ID_MATERIAL_BIBLIOTECA INTEGER              not null,
   IFPI                 CHAR(255),
   constraint PK_CD primary key (ID_MATERIAL_BIBLIOTECA)
);

/*==============================================================*/
/* Table: CDU                                                   */
/*==============================================================*/
create table CDU 
(
   ID_CDU               INTEGER              not null,
   CODIGO               INTEGER              not null,
   constraint PK_CDU primary key (ID_CDU)
);

/*==============================================================*/
/* Table: DETALLEPRESTAMO                                       */
/*==============================================================*/
create table DETALLEPRESTAMO 
(
   ID_MORA              INTEGER              not null,
   ID_MATERIAL_BIBLIOTECA INTEGER              not null,
   FECHA_PRESTAMO       CHAR(255)            not null,
   FECHA_RETORNO        CHAR(255)            not null,
   ESTA_ACTIVO          SMALLINT             not null,
   constraint PK_DETALLEPRESTAMO primary key (ID_MORA, ID_MATERIAL_BIBLIOTECA)
);

/*==============================================================*/
/* Index: PRESTA3_FK                                            */
/*==============================================================*/
create index PRESTA3_FK on DETALLEPRESTAMO (
   ID_MATERIAL_BIBLIOTECA ASC
);

/*==============================================================*/
/* Table: DETALLETRANSACCIONMEMBRESIA                           */
/*==============================================================*/
create table DETALLETRANSACCIONMEMBRESIA 
(
   ID_DETALLE           INTEGER              not null,
   CARNET               INTEGER,
   MONTO                NUMBER(1,2),
   FECHA                CHAR(255),
   constraint PK_DETALLETRANSACCIONMEMBRESIA primary key (ID_DETALLE)
);

/*==============================================================*/
/* Index: RELATIONSHIP_10_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_10_FK on DETALLETRANSACCIONMEMBRESIA (
   CARNET ASC
);

/*==============================================================*/
/* Table: DVD                                                   */
/*==============================================================*/
create table DVD 
(
   ID_MATERIAL_BIBLIOTECA INTEGER              not null,
   TIPO                 CHAR(255),
   constraint PK_DVD primary key (ID_MATERIAL_BIBLIOTECA)
);

/*==============================================================*/
/* Table: FORMATO                                               */
/*==============================================================*/
create table FORMATO 
(
   ID_FORMATO           INTEGER              not null,
   NOMBRE_FORMATO       CHAR(255)            not null,
   constraint PK_FORMATO primary key (ID_FORMATO)
);

/*==============================================================*/
/* Table: IDIOMA                                                */
/*==============================================================*/
create table IDIOMA 
(
   ID_IDIOMA            INTEGER              not null,
   NOMBRE_IDIOMA        CHAR(255),
   constraint PK_IDIOMA primary key (ID_IDIOMA)
);

/*==============================================================*/
/* Table: LIBRO                                                 */
/*==============================================================*/
create table LIBRO 
(
   ID_MATERIAL_BIBLIOTECA INTEGER              not null,
   ES_OBRA_DE_REFERENCIA SMALLINT             not null,
   ISBN                 CHAR(255)            not null,
   LOGO                 CHAR(255),
   constraint PK_LIBRO primary key (ID_MATERIAL_BIBLIOTECA)
);

/*==============================================================*/
/* Table: MAPA                                                  */
/*==============================================================*/
create table MAPA 
(
   ID_MATERIAL_BIBLIOTECA INTEGER              not null,
   ID_MAT_MAP           INTEGER,
   ID_TAMANO            INTEGER,
   ID_FORMATO           INTEGER,
   ID_CDU               INTEGER,
   constraint PK_MAPA primary key (ID_MATERIAL_BIBLIOTECA)
);

/*==============================================================*/
/* Index: RELATIONSHIP_15_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_15_FK on MAPA (
   ID_FORMATO ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_16_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_16_FK on MAPA (
   ID_TAMANO ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_17_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_17_FK on MAPA (
   ID_CDU ASC
);

/*==============================================================*/
/* Table: MATERIAL                                              */
/*==============================================================*/
create table MATERIAL 
(
   ID_MAT_MAP           INTEGER              not null,
   MATERIAL_MAPA_NOMBRE CHAR(255)            not null,
   constraint PK_MATERIAL primary key (ID_MAT_MAP)
);

/*==============================================================*/
/* Table: MIEMBRO                                               */
/*==============================================================*/
create table MIEMBRO 
(
   CARNET               INTEGER              not null,
   ID_USUARIO           INTEGER,
   PENALIZADO           SMALLINT,
   constraint PK_MIEMBRO primary key (CARNET)
);

/*==============================================================*/
/* Index: RELATIONSHIP_9_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_9_FK on MIEMBRO (
   ID_USUARIO ASC
);

/*==============================================================*/
/* Table: MORA                                                  */
/*==============================================================*/
create table MORA 
(
   ID_MORA              INTEGER              not null,
   CARNET               INTEGER,
   MORA_PRESTAMO        NUMBER(2,2),
   COSTO_PRESTAMO       NUMBER(2,2),
   constraint PK_MORA primary key (ID_MORA)
);

/*==============================================================*/
/* Index: RELATIONSHIP_13_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_13_FK on MORA (
   CARNET ASC
);

/*==============================================================*/
/* Table: PERMISO                                               */
/*==============================================================*/
create table PERMISO 
(
   ID_PERMISO           INTEGER              not null,
   NOMBRE_PERMISO       CHAR(255)            not null,
   constraint PK_PERMISO primary key (ID_PERMISO)
);

/*==============================================================*/
/* Table: POSEE                                                 */
/*==============================================================*/
create table POSEE 
(
   ID_ROL               INTEGER              not null,
   ID_PERMISO           INTEGER              not null,
   constraint PK_POSEE primary key (ID_ROL, ID_PERMISO)
);

/*==============================================================*/
/* Index: POSEE_FK                                              */
/*==============================================================*/
create index POSEE_FK on POSEE (
   ID_ROL ASC
);

/*==============================================================*/
/* Index: POSEE2_FK                                             */
/*==============================================================*/
create index POSEE2_FK on POSEE (
   ID_PERMISO ASC
);

/*==============================================================*/
/* Table: PRESTAMOSMIEMBROS                                     */
/*==============================================================*/
create table PRESTAMOSMIEMBROS 
(
   CARNET               INTEGER              not null,
   ID_MATERIAL_BIBLIOTECA INTEGER              not null,
   constraint PK_PRESTAMOSMIEMBROS primary key (CARNET, ID_MATERIAL_BIBLIOTECA)
);

/*==============================================================*/
/* Index: PRESTA2_FK                                            */
/*==============================================================*/
create index PRESTA2_FK on PRESTAMOSMIEMBROS (
   ID_MATERIAL_BIBLIOTECA ASC
);

/*==============================================================*/
/* Table: REVISTA                                               */
/*==============================================================*/
create table REVISTA 
(
   ID_MATERIAL_BIBLIOTECA INTEGER              not null,
   ISSN                 CHAR(255),
   constraint PK_REVISTA primary key (ID_MATERIAL_BIBLIOTECA)
);

/*==============================================================*/
/* Table: ROL                                                   */
/*==============================================================*/
create table ROL 
(
   ID_ROL               INTEGER              not null,
   NOMBRE_ROL           CHAR(255)            not null,
   constraint PK_ROL primary key (ID_ROL)
);

/*==============================================================*/
/* Table: TAMANO                                                */
/*==============================================================*/
create table TAMANO 
(
   ID_TAMANO            INTEGER              not null,
   ANCHO                NUMBER(5,2),
   ALTO                 CHAR(10),
   constraint PK_TAMANO primary key (ID_TAMANO)
);

/*==============================================================*/
/* Table: TIPOUSUARIO                                           */
/*==============================================================*/
create table TIPOUSUARIO 
(
   ID_TIPO_USUARIO      INTEGER              not null,
   NOMBRE_TIPO_USUARIO  CHAR(255)            not null,
   constraint PK_TIPOUSUARIO primary key (ID_TIPO_USUARIO)
);

/*==============================================================*/
/* Table: USA                                                   */
/*==============================================================*/
create table USA 
(
   ID_USUARIO           INTEGER              not null,
   ID_ROL               INTEGER              not null,
   constraint PK_USA primary key (ID_USUARIO, ID_ROL)
);

/*==============================================================*/
/* Index: USA_FK                                                */
/*==============================================================*/
create index USA_FK on USA (
   ID_USUARIO ASC
);

/*==============================================================*/
/* Index: USA2_FK                                               */
/*==============================================================*/
create index USA2_FK on USA (
   ID_ROL ASC
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO 
(
   ID_USUARIO           INTEGER              not null,
   ID_TIPO_USUARIO      INTEGER,
   CARNET               INTEGER,
   NOMBRE_USUARIO       CHAR(255)            not null,
   USERNAME             CHAR(255)            not null,
   CORREO               CHAR(255)            not null,
   PASSWORD             CHAR(255)            not null,
   constraint PK_USUARIO primary key (ID_USUARIO)
);

/*==============================================================*/
/* Index: RELATIONSHIP_8_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_8_FK on USUARIO (
   CARNET ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_11_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_11_FK on USUARIO (
   ID_TIPO_USUARIO ASC
);

alter table BIBLIOTECAMATERIAL
   add constraint FK_BIBLIOTE_REFERENCE_AUTOR foreign key (ID_AUTOR)
      references AUTOR (ID_AUTOR);

alter table BIBLIOTECAMATERIAL
   add constraint FK_BIBLIOTE_RELATIONS_IDIOMA foreign key (ID_IDIOMA)
      references IDIOMA (ID_IDIOMA);

alter table CD
   add constraint FK_CD_RELATIONS_BIBLIOTE foreign key (ID_MATERIAL_BIBLIOTECA)
      references BIBLIOTECAMATERIAL (ID_MATERIAL_BIBLIOTECA);

alter table DETALLEPRESTAMO
   add constraint FK_DETALLEP_DETALLEPR_MORA foreign key (ID_MORA)
      references MORA (ID_MORA);

alter table DETALLEPRESTAMO
   add constraint FK_DETALLEP_DETALLEPR_BIBLIOTE foreign key (ID_MATERIAL_BIBLIOTECA)
      references BIBLIOTECAMATERIAL (ID_MATERIAL_BIBLIOTECA);

alter table DETALLETRANSACCIONMEMBRESIA
   add constraint FK_DETALLET_RELATIONS_MIEMBRO foreign key (CARNET)
      references MIEMBRO (CARNET);

alter table DVD
   add constraint FK_DVD_RELATIONS_BIBLIOTE foreign key (ID_MATERIAL_BIBLIOTECA)
      references BIBLIOTECAMATERIAL (ID_MATERIAL_BIBLIOTECA);

alter table LIBRO
   add constraint FK_LIBRO_RELATIONS_BIBLIOTE foreign key (ID_MATERIAL_BIBLIOTECA)
      references BIBLIOTECAMATERIAL (ID_MATERIAL_BIBLIOTECA);

alter table MAPA
   add constraint FK_MAPA_RELATIONS_BIBLIOTE foreign key (ID_MATERIAL_BIBLIOTECA)
      references BIBLIOTECAMATERIAL (ID_MATERIAL_BIBLIOTECA);

alter table MAPA
   add constraint FK_MAPA_RELATIONS_FORMATO foreign key (ID_FORMATO)
      references FORMATO (ID_FORMATO);

alter table MAPA
   add constraint FK_MAPA_RELATIONS_TAMANO foreign key (ID_TAMANO)
      references TAMANO (ID_TAMANO);

alter table MAPA
   add constraint FK_MAPA_RELATIONS_CDU foreign key (ID_CDU)
      references CDU (ID_CDU);

alter table MAPA
   add constraint FK_MAPA_RELATIONS_MATERIAL foreign key (ID_MATERIAL_BIBLIOTECA)
      references MATERIAL (ID_MAT_MAP);

alter table MIEMBRO
   add constraint FK_MIEMBRO_RELATIONS_USUARIO foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO);

alter table MORA
   add constraint FK_MORA_RELATIONS_MIEMBRO foreign key (CARNET)
      references MIEMBRO (CARNET);

alter table POSEE
   add constraint FK_POSEE_POSEE_ROL foreign key (ID_ROL)
      references ROL (ID_ROL);

alter table POSEE
   add constraint FK_POSEE_POSEE2_PERMISO foreign key (ID_PERMISO)
      references PERMISO (ID_PERMISO);

alter table PRESTAMOSMIEMBROS
   add constraint FK_PRESTAMO_PRESTAMOS_MIEMBRO foreign key (CARNET)
      references MIEMBRO (CARNET);

alter table PRESTAMOSMIEMBROS
   add constraint FK_PRESTAMO_PRESTAMOS_BIBLIOTE foreign key (ID_MATERIAL_BIBLIOTECA)
      references BIBLIOTECAMATERIAL (ID_MATERIAL_BIBLIOTECA);

alter table REVISTA
   add constraint FK_REVISTA_RELATIONS_BIBLIOTE foreign key (ID_MATERIAL_BIBLIOTECA)
      references BIBLIOTECAMATERIAL (ID_MATERIAL_BIBLIOTECA);

alter table USA
   add constraint FK_USA_USA_USUARIO foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO);

alter table USA
   add constraint FK_USA_USA2_ROL foreign key (ID_ROL)
      references ROL (ID_ROL);

alter table USUARIO
   add constraint FK_USUARIO_RELATIONS_TIPOUSUA foreign key (ID_TIPO_USUARIO)
      references TIPOUSUARIO (ID_TIPO_USUARIO);

alter table USUARIO
   add constraint FK_USUARIO_RELATIONS_MIEMBRO foreign key (CARNET)
      references MIEMBRO (CARNET);


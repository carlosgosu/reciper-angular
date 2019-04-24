CREATE TABLE Ingrediente (
    id   		BIGINT			NOT NULL AUTO_INCREMENT,
    nombre 		VARCHAR(128)	NOT NULL,
    kcal		INTEGER,
    precio		DECIMAL(8,2),
    PRIMARY KEY (id)
);

CREATE TABLE Usuario (
    usuario   	VARCHAR(30)		NOT NULL,
    password 	VARCHAR(256)	NOT NULL,
    email		VARCHAR(255),
    nombre		VARCHAR(255),
    idPerfil	BIGINT,
    PRIMARY KEY (usuario)
);

CREATE TABLE Permiso (
    idPermiso   	BIGINT			NOT NULL,
    nombrePermiso 	VARCHAR(100)	NOT NULL,
    PRIMARY KEY (idPermiso)
);

CREATE TABLE Usuario_Permiso (
	usuario			VARCHAR(30)		NOT NULL,
    idPermiso   	BIGINT			NOT NULL,
    PRIMARY KEY (usuario,idPermiso)
);

CREATE TABLE Perfil (
    idPerfil   	BIGINT			NOT NULL,
    perfil 		VARCHAR(100)	NOT NULL,
    PRIMARY KEY (idPerfil)
);


CREATE TABLE Perfil_Permiso (
	idPerfil		BIGINT			NOT NULL,
    idPermiso   	BIGINT			NOT NULL,
    PRIMARY KEY (idPerfil,idPermiso)
);

CREATE TABLE Revision_INFO (
    id   				BIGINT			NOT NULL AUTO_INCREMENT,
    revision_time		TIMESTAMP,
    ip	 				VARCHAR(30),
    session_id			VARCHAR(255),
    revision_user_name	VARCHAR(30),
    PRIMARY KEY (id)
);

CREATE TABLE familiaAlimento (
    id   				BIGINT			NOT NULL AUTO_INCREMENT,
    nombreFamilia		VARCHAR(70),
    PRIMARY KEY (id)
);

CREATE TABLE Ingrediente (
    id   		BIGINT			NOT NULL AUTO_INCREMENT,
    version		BIGINT default 0,
    nombre 		VARCHAR(128)	NOT NULL,
    kcal		INTEGER,
    precio		DECIMAL(8,2),
    idFamilia	BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (idFamilia) REFERENCES familiaAlimento(id)
);

CREATE TABLE Ingrediente_AUD (
    id   		BIGINT			NOT NULL,
    rev			BIGINT			NOT NULL,
    revtype		TINYINT,
    nombre 		VARCHAR(128)	NOT NULL,
    kcal		INTEGER,
    precio		DECIMAL(8,2),
    PRIMARY KEY (id,rev)
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

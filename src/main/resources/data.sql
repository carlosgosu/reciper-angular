--Este fichero se carga automaticamente cuando arranca spring boot
INSERT INTO Ingrediente(id,nombre,kcal,precio) VALUES
(100,'Puerro',30,2.25),
(101,'Cordero',250,15),
(102,'Pollo',150,7.99);

INSERT INTO Usuario(usuario,password,email,nombre) VALUES
('admin','$2a$10$eJ2Mn48Sp8l3ce2WWn/CYuLWDRRLSOnQPErpnd74nEK00fBlSXOB2','ad@gmail.com','Administrador'),
('carlosgosu','$2a$10$eCuz7nVmIbrbng4Fu0LAa.GmtXsfEqHaNfZoLyad.QLgMWzENqdBK','carlosgosu@gmail.com','Carlos Javier');

--Ojo si se crean las tablas con hbm2dll estas columnas las crea como id_permiso y nombre_permiso
INSERT INTO Permiso(idPermiso,nombrePermiso) VALUES
(1,'ADMIN'),
(2,'READ_INGREDIENTES'),
(3,'WRITE_INGREDIENTES');

INSERT INTO usuario_permiso(usuario,idPermiso) VALUES
('admin',1),
('admin',2),
('admin',3),
('carlosgosu',2),
('carlosgosu',3);
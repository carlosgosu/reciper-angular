--Este fichero se carga automaticamente cuando arranca spring boot
INSERT INTO Ingrediente(id,nombre,kcal,precio) VALUES
(100,'Puerro',30,2.25),
(101,'Cordero',250,15),
(102,'Pollo',150,7.99);

INSERT INTO Perfil(idPerfil,perfil) VALUES
(1,'ADMIN'),
(2,'INGREDIENTES_MANAGER');

INSERT INTO Usuario(usuario,password,email,nombre, idPerfil) VALUES
('admin','$2a$10$eJ2Mn48Sp8l3ce2WWn/CYuLWDRRLSOnQPErpnd74nEK00fBlSXOB2','ad@gmail.com','Administrador',1),
('carlosgosu','$2a$10$eCuz7nVmIbrbng4Fu0LAa.GmtXsfEqHaNfZoLyad.QLgMWzENqdBK','carlosgosu@gmail.com','Carlos Javier',2),
('guest','$2a$10$.s/JFacGu.P6G1Lo6t1Qyek/.jCiZGbSLxce/edxv/uavPwi77bJO','guest@gmail.com','Usuario invitado',NULL);

--Ojo si se crean las tablas con hbm2dll estas columnas las crea como id_permiso y nombre_permiso
INSERT INTO Permiso(idPermiso,nombrePermiso) VALUES
(1,'READ_CONFIGURATION'),
(2,'WRITE_CONFIGURATION'),
(3,'READ_INGREDIENTES'),
(4,'WRITE_INGREDIENTES');

INSERT INTO usuario_permiso(usuario,idPermiso) VALUES
('admin',3);

INSERT INTO perfil_permiso(idPerfil,idPermiso) VALUES
(1,1),
(1,2),
(2,3),
(2,4);



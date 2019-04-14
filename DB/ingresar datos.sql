INSERT INTO mydb.tipousuario (idtipousuario, tipo)
values (1,'administrador');
INSERT INTO mydb.usuario (idusuario, usuario, contraseña, tipousuario_idtipousuario)
values (1,'admin','admin',1);
INSERT INTO mydb.cargo (idcargo, cargo) values(1,'Administrador'),
(2,'Recolector'),(3,'Conductor'),(4,'Conserje');
INSERT INTO mydb.producto (idproducto, tipo, descripcion, existencia)
values (1,'Bote Plástico','Para residuos sólidos',50), (2,'Bote Plástico','Para residuos orgánicos',50),
(3,'Costal','Para residuos sólidos',50);
INSERT INTO mydb.empleado (idempleado, nombres, apellidos, direccion, telefono, cui, nit, fechanac, edad, genero, cargo_idcargo)
values (1,'Andrea','Rodríguez','4ta calle 8-19 zona 2 S.C.C.','56784536','1980-56789-1225','272501-2',STR_TO_DATE('22/06/1995','%d/%m/%Y'),21,'Femenino',1),
(2,'José','Cifuentes','6ta calle 3-12 zona 6 S.C.C.','56784536','2743-23857-1225','272501-2',STR_TO_DATE('12/03/1990','%d/%m/%Y'),26,'Masculino',2),
(3,'Luis','Gómez','2da calle 8-7 zona 3 S.C.C.','56784536','2843-12375-1225','272501-2',STR_TO_DATE('15/10/1992','%d/%m/%Y'),24,'Masculino',2),
(4,'Rodrigo','Aguilar','1ra calle 3-13 zona 4 S.C.C.','56784536','2563-89543-1225','272501-2',STR_TO_DATE('03/01/1991','%d/%m/%Y'),25,'Masculino',2),
(5,'Juan','Fuentes','8va calle 6-14 zona 2 S.C.C.','56784536','1753-34675-1225','272501-2',STR_TO_DATE('28/11/1992','%d/%m/%Y'),24,'Masculino',3),
(6,'Hector','López','4ta calle 2-4 zona 7 S.C.C.','56784536','1345-67954-1225','272501-2',STR_TO_DATE('09/04/1993','%d/%m/%Y'),23,'Masculino',3),
(7,'Daniel','Miranda','3ra calle 3-5 zona 1 S.C.C.','45678765','2563-34567-1225','272501-2',STR_TO_DATE('21/07/1990','%d/%m/%Y'),26,'Masculino',4);
insert into mydb.tipopago (idTipoPago, Tipo, Monto)
values (1,'Inscripción',25.00), (2,'Mensualidad',20.00);
INSERT INTO mydb.aldea (idAldea, Aldea) 
VALUES (1,'Barranca Grande'),(2,'Las Majadas'),(3,'Rancho El Padre'),(4,'San Rafael Guativil');
INSERT INTO mydb.vehiculo (idVehiculo, Marca, Modelo, Color, Cilindros, Motor, Num_Placa, Capacidad, Conductor_ID)
VALUES (idVehiculo, 'Freightliner', 2004, 'Blanco',8,'2HBD47JSUD2A14D9D', 'P308DMD',10.7,6);
INSERT INTO mydb.cliente (idCliente, Nombres, Apellidos, Municipio, Direccion, Telefono, CUI, Boleto_ornato, Caserio_ID, Aldea_idAldea)
VALUES (1,'Roberto','Fuentes','San Cristóbal Cucho','3ra calle 9-23 zona 3','56739201','2130-76482-1225','A210408',null,null),
(2,'Juan','López','San Cristóbal Cucho','8va calle 3-21 zona 1','34672893','1903-41231-1225','A112301',null,1),
(3,'Alva','Cifuentes','San Cristóbal Cucho','2da calle 3-13 zona 5','42871943','1302-25792-1225','A185727',null,2),
(4,'Felipe','Macario','San Cristóbal Cucho','1ra calle 4-6 zona 4','53817293','2391-67342-1225','A196852',null,3),
(5,'Ricardo','Ambrocio','San Cristóbal Cucho','5ta calle 2-11 zona 1','42857234','2467-36583-1225','A206742',null,4);
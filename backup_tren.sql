-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aldea`
--

DROP TABLE IF EXISTS `aldea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `aldea` (
  `idAldea` int(11) NOT NULL,
  `Aldea` varchar(40) NOT NULL,
  PRIMARY KEY (`idAldea`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aldea`
--

LOCK TABLES `aldea` WRITE;
/*!40000 ALTER TABLE `aldea` DISABLE KEYS */;
INSERT INTO `aldea` VALUES (1,'Barranca Grande'),(2,'Las Majadas'),(3,'Rancho El Padre'),(4,'San Rafael Guativil');
/*!40000 ALTER TABLE `aldea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bote_cliente`
--

DROP TABLE IF EXISTS `bote_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bote_cliente` (
  `Producto_idProducto` int(11) NOT NULL,
  `Cliente_idCliente` int(11) NOT NULL,
  `Fecha_Entrega` date NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Nota` mediumtext,
  PRIMARY KEY (`Producto_idProducto`,`Cliente_idCliente`),
  KEY `fk_Producto_has_Clientes_Clientes1_idx` (`Cliente_idCliente`),
  KEY `fk_Producto_has_Clientes_Producto1_idx` (`Producto_idProducto`),
  CONSTRAINT `fk_Producto_has_Clientes_Clientes1` FOREIGN KEY (`Cliente_idCliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `fk_Producto_has_Clientes_Producto1` FOREIGN KEY (`Producto_idProducto`) REFERENCES `producto` (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bote_cliente`
--

LOCK TABLES `bote_cliente` WRITE;
/*!40000 ALTER TABLE `bote_cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `bote_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cargo` (
  `idCargo` int(11) NOT NULL,
  `Cargo` varchar(45) NOT NULL,
  PRIMARY KEY (`idCargo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (1,'Administrador'),(2,'Recolector'),(3,'Conductor'),(4,'Conserje');
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caserio`
--

DROP TABLE IF EXISTS `caserio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `caserio` (
  `idCaserio` int(11) NOT NULL,
  `Caserio` varchar(40) NOT NULL,
  `Aldea_idAldea` int(11) NOT NULL,
  PRIMARY KEY (`idCaserio`),
  KEY `fk_Caserio_Aldea1_idx` (`Aldea_idAldea`),
  CONSTRAINT `fk_Caserio_Aldea1` FOREIGN KEY (`Aldea_idAldea`) REFERENCES `aldea` (`idAldea`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caserio`
--

LOCK TABLES `caserio` WRITE;
/*!40000 ALTER TABLE `caserio` DISABLE KEYS */;
/*!40000 ALTER TABLE `caserio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `Nombres` varchar(50) NOT NULL,
  `Apellidos` varchar(50) NOT NULL,
  `Municipio` varchar(30) NOT NULL,
  `Direccion` varchar(200) NOT NULL,
  `Telefono` varchar(8) DEFAULT NULL,
  `CUI` varchar(17) NOT NULL,
  `Boleto_ornato` varchar(45) DEFAULT NULL,
  `Caserio_ID` int(11) DEFAULT NULL,
  `Aldea_idAldea` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCliente`),
  KEY `fk_Cliente_Caserio1_idx` (`Caserio_ID`),
  KEY `fk_Cliente_Aldea1_idx` (`Aldea_idAldea`),
  CONSTRAINT `fk_Cliente_Aldea1` FOREIGN KEY (`Aldea_idAldea`) REFERENCES `aldea` (`idAldea`),
  CONSTRAINT `fk_Cliente_Caserio1` FOREIGN KEY (`Caserio_ID`) REFERENCES `caserio` (`idCaserio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Roberto','Fuentes','San Cristóbal Cucho','3ra calle 9-23 zona 3','56739201','2130-76482-1225','A210408',NULL,NULL),(2,'Juan','López','San Cristóbal Cucho','8va calle 3-21 zona 1','34672893','1903-41231-1225','A112301',NULL,1),(3,'Alva','Cifuentes','San Cristóbal Cucho','2da calle 3-13 zona 5','42871943','1302-25792-1225','A185727',NULL,2),(4,'Felipe','Macario','San Cristóbal Cucho','1ra calle 4-6 zona 4','53817293','2391-67342-1225','A196852',NULL,3),(5,'Ricardo','Ambrocio','San Cristóbal Cucho','5ta calle 2-11 zona 1','42857234','2467-36583-1225','A206742',NULL,4),(6,'PruebaDB','Prueba','San Marcos','3ra calle 2-33 zona 1','12341234','123412341234','A1',NULL,1),(7,'asdf','ASDFA','San MArcos','sjdfhlasldf sadfkjsd','12341234','12341234124','A12',NULL,1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `empleado` (
  `idEmpleado` int(11) NOT NULL,
  `Nombres` varchar(50) NOT NULL,
  `Apellidos` varchar(50) NOT NULL,
  `Direccion` varchar(200) NOT NULL,
  `Telefono` varchar(8) NOT NULL,
  `CUI` varchar(17) NOT NULL,
  `NIT` varchar(9) NOT NULL,
  `FechaNac` date NOT NULL,
  `Edad` int(11) NOT NULL,
  `Genero` varchar(20) NOT NULL,
  `Cargo_idCargo` int(11) NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  KEY `fk_Empleado_Cargo1_idx` (`Cargo_idCargo`),
  CONSTRAINT `fk_Empleado_Cargo1` FOREIGN KEY (`Cargo_idCargo`) REFERENCES `cargo` (`idCargo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'Andrea','Rodríguez','4ta calle 8-19 zona 2 S.C.C.','56784536','1980-56789-1225','272501-2','1995-06-22',21,'Femenino',1),(2,'José','Cifuentes','6ta calle 3-12 zona 6 S.C.C.','56784536','2743-23857-1225','272501-2','1990-03-12',26,'Masculino',2),(3,'Luis','Gómez','2da calle 8-7 zona 3 S.C.C.','56784536','2843-12375-1225','272501-2','1992-10-15',24,'Masculino',2),(4,'Rodrigo','Aguilar','1ra calle 3-13 zona 4 S.C.C.','56784536','2563-89543-1225','272501-2','1991-01-03',25,'Masculino',2),(5,'Juan','Fuentes','8va calle 6-14 zona 2 S.C.C.','56784536','1753-34675-1225','272501-2','1992-11-28',24,'Masculino',3),(6,'Hector','López','4ta calle 2-4 zona 7 S.C.C.','56784536','1345-67954-1225','272501-2','1993-04-09',23,'Masculino',3),(7,'Daniel','Miranda','3ra calle 3-5 zona 1 S.C.C.','45678765','2563-34567-1225','272501-2','1990-07-21',26,'Masculino',4);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pago` (
  `idPago` int(11) NOT NULL,
  `Serie` varchar(45) NOT NULL,
  `Num_Comprobante` varchar(45) NOT NULL,
  `Descripcion` longtext,
  `Mes_Pago` varchar(45) NOT NULL,
  `Fecha` date NOT NULL,
  `Hora` time NOT NULL,
  `TipoPago_idTipoPago` int(11) NOT NULL,
  `Empleado_idEmpleado` int(11) NOT NULL,
  `Cliente_idCliente` int(11) NOT NULL,
  PRIMARY KEY (`idPago`),
  KEY `fk_DetallePago_TipoPago1_idx` (`TipoPago_idTipoPago`),
  KEY `fk_Pago_Empleado1_idx` (`Empleado_idEmpleado`),
  KEY `fk_Pago_Cliente1_idx` (`Cliente_idCliente`),
  CONSTRAINT `fk_DetallePago_TipoPago1` FOREIGN KEY (`TipoPago_idTipoPago`) REFERENCES `tipopago` (`idTipoPago`),
  CONSTRAINT `fk_Pago_Cliente1` FOREIGN KEY (`Cliente_idCliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `fk_Pago_Empleado1` FOREIGN KEY (`Empleado_idEmpleado`) REFERENCES `empleado` (`idEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--

LOCK TABLES `pago` WRITE;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
INSERT INTO `pago` VALUES (1,'A','1','Inscripción','MAYO','2019-05-04','09:39:00',2,1,1),(2,'A','2','Inscripción','MAYO','2019-05-04','09:44:00',2,1,2),(3,'A','3','Inscripción','MAYO','2019-05-04','09:45:00',2,1,1),(4,'A','4','Inscripción','MAYO','2019-05-04','09:47:00',2,1,1),(5,'A','5','Inscripción','MAYO','2019-05-04','09:48:00',2,1,1),(6,'A','6','Inscripción','MAYO','2019-05-04','10:00:00',2,1,4),(7,'A','7','Inscripción','MAYO','2019-05-04','10:16:00',2,1,3);
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `Tipo` varchar(45) NOT NULL,
  `Descripcion` text NOT NULL,
  `Existencia` int(11) NOT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'Bote Plástico','Para residuos sólidos',50),(2,'Bote Plástico','Para residuos orgánicos',50),(3,'Costal','Para residuos sólidos',50);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipopago`
--

DROP TABLE IF EXISTS `tipopago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipopago` (
  `idTipoPago` int(11) NOT NULL,
  `Tipo` varchar(45) NOT NULL,
  `Monto` float NOT NULL,
  PRIMARY KEY (`idTipoPago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipopago`
--

LOCK TABLES `tipopago` WRITE;
/*!40000 ALTER TABLE `tipopago` DISABLE KEYS */;
INSERT INTO `tipopago` VALUES (1,'Inscripción',25),(2,'Mensualidad',20);
/*!40000 ALTER TABLE `tipopago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipousuario`
--

DROP TABLE IF EXISTS `tipousuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipousuario` (
  `idTipoUsuario` int(11) NOT NULL,
  `Tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipoUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipousuario`
--

LOCK TABLES `tipousuario` WRITE;
/*!40000 ALTER TABLE `tipousuario` DISABLE KEYS */;
INSERT INTO `tipousuario` VALUES (1,'administrador');
/*!40000 ALTER TABLE `tipousuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `total_pago`
--

DROP TABLE IF EXISTS `total_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `total_pago` (
  `idtotal_pago` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` float NOT NULL,
  `descripcion` varchar(120) NOT NULL,
  PRIMARY KEY (`idtotal_pago`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `total_pago`
--

LOCK TABLES `total_pago` WRITE;
/*!40000 ALTER TABLE `total_pago` DISABLE KEYS */;
INSERT INTO `total_pago` VALUES (1,25,'Hola este es una prueba'),(2,25,'Hola este es una prueba'),(3,25,'Hola este es una prueba'),(4,25,'Hola este es una prueba'),(5,25,'Hola este es una prueba'),(6,25,'Hola este es una prueba'),(7,50,'Hola este es una prueba');
/*!40000 ALTER TABLE `total_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `traslado`
--

DROP TABLE IF EXISTS `traslado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `traslado` (
  `idTraslado` int(11) NOT NULL AUTO_INCREMENT,
  `Tipo_Traslado` varchar(45) NOT NULL,
  `Direccion_Origen` varchar(200) NOT NULL,
  `Direccion_Destino` varchar(200) NOT NULL,
  `Fecha` date NOT NULL,
  `Hora` time DEFAULT NULL,
  `Peso` float NOT NULL,
  `Vehiculo_idVehiculo` int(11) NOT NULL,
  PRIMARY KEY (`idTraslado`),
  KEY `fk_Traslado_Vehiculo1_idx` (`Vehiculo_idVehiculo`),
  CONSTRAINT `fk_Traslado_Vehiculo1` FOREIGN KEY (`Vehiculo_idVehiculo`) REFERENCES `vehiculo` (`idVehiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `traslado`
--

LOCK TABLES `traslado` WRITE;
/*!40000 ALTER TABLE `traslado` DISABLE KEYS */;
/*!40000 ALTER TABLE `traslado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `Usuario` varchar(45) NOT NULL,
  `Contraseña` varchar(45) NOT NULL,
  `TipoUsuario_idTipoUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `fk_Usuario_TipoUsuario1_idx` (`TipoUsuario_idTipoUsuario`),
  CONSTRAINT `fk_Usuario_TipoUsuario1` FOREIGN KEY (`TipoUsuario_idTipoUsuario`) REFERENCES `tipousuario` (`idTipoUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin','5c23mB35/4BR/NACKhKu8g==',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vehiculo` (
  `idVehiculo` int(11) NOT NULL,
  `Marca` varchar(45) NOT NULL,
  `Modelo` int(11) NOT NULL,
  `Color` varchar(45) NOT NULL,
  `Cilindros` int(11) NOT NULL,
  `Motor` varchar(45) NOT NULL,
  `Num_Placa` varchar(10) NOT NULL,
  `Capacidad` float DEFAULT NULL,
  `Conductor_ID` int(11) NOT NULL,
  PRIMARY KEY (`idVehiculo`),
  KEY `fk_Vehiculos_Empleados1_idx` (`Conductor_ID`),
  CONSTRAINT `fk_Vehiculos_Empleados1` FOREIGN KEY (`Conductor_ID`) REFERENCES `empleado` (`idEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo`
--

LOCK TABLES `vehiculo` WRITE;
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
INSERT INTO `vehiculo` VALUES (0,'Freightliner',2004,'Blanco',8,'2HBD47JSUD2A14D9D','P308DMD',10.7,6);
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-04 17:26:55

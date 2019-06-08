-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Aldea`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Aldea` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Aldea` (
  `idAldea` INT NOT NULL,
  `Aldea` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`idAldea`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Caserio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Caserio` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Caserio` (
  `idCaserio` INT NOT NULL,
  `Caserio` VARCHAR(40) NOT NULL,
  `Aldea_idAldea` INT NOT NULL,
  PRIMARY KEY (`idCaserio`),
  INDEX `fk_Caserio_Aldea1_idx` (`Aldea_idAldea` ASC) VISIBLE,
  CONSTRAINT `fk_Caserio_Aldea1`
    FOREIGN KEY (`Aldea_idAldea`)
    REFERENCES `mydb`.`Aldea` (`idAldea`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Cliente` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Cliente` (
  `idCliente` INT NOT NULL,
  `Nombres` VARCHAR(50) NOT NULL,
  `Apellidos` VARCHAR(50) NOT NULL,
  `Municipio` VARCHAR(30) NOT NULL,
  `Direccion` VARCHAR(200) NOT NULL,
  `Telefono` VARCHAR(8) NULL,
  `CUI` VARCHAR(17) NOT NULL,
  `Boleto_ornato` VARCHAR(45) NULL,
  `Caserio_ID` INT NULL,
  `Aldea_idAldea` INT NULL,
  PRIMARY KEY (`idCliente`),
  INDEX `fk_Cliente_Caserio1_idx` (`Caserio_ID` ASC) VISIBLE,
  INDEX `fk_Cliente_Aldea1_idx` (`Aldea_idAldea` ASC) VISIBLE,
  CONSTRAINT `fk_Cliente_Caserio1`
    FOREIGN KEY (`Caserio_ID`)
    REFERENCES `mydb`.`Caserio` (`idCaserio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cliente_Aldea1`
    FOREIGN KEY (`Aldea_idAldea`)
    REFERENCES `mydb`.`Aldea` (`idAldea`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cargo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Cargo` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Cargo` (
  `idCargo` INT NOT NULL,
  `Cargo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCargo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Empleado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Empleado` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Empleado` (
  `idEmpleado` INT NOT NULL,
  `Nombres` VARCHAR(50) NOT NULL,
  `Apellidos` VARCHAR(50) NOT NULL,
  `Direccion` VARCHAR(200) NOT NULL,
  `Telefono` VARCHAR(8) NOT NULL,
  `CUI` VARCHAR(17) NOT NULL,
  `NIT` VARCHAR(9) NOT NULL,
  `FechaNac` DATE NOT NULL,
  `Edad` INT NOT NULL,
  `Genero` VARCHAR(20) NOT NULL,
  `Cargo_idCargo` INT NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  INDEX `fk_Empleado_Cargo1_idx` (`Cargo_idCargo` ASC) VISIBLE,
  CONSTRAINT `fk_Empleado_Cargo1`
    FOREIGN KEY (`Cargo_idCargo`)
    REFERENCES `mydb`.`Cargo` (`idCargo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Vehiculo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Vehiculo` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Vehiculo` (
  `idVehiculo` INT NOT NULL,
  `Marca` VARCHAR(45) NOT NULL,
  `Modelo` INT NOT NULL,
  `Color` VARCHAR(45) NOT NULL,
  `Cilindros` INT NOT NULL,
  `Motor` VARCHAR(45) NOT NULL,
  `Num_Placa` VARCHAR(10) NOT NULL,
  `Capacidad` FLOAT NULL,
  `Conductor_ID` INT NOT NULL,
  PRIMARY KEY (`idVehiculo`),
  INDEX `fk_Vehiculos_Empleados1_idx` (`Conductor_ID` ASC) VISIBLE,
  CONSTRAINT `fk_Vehiculos_Empleados1`
    FOREIGN KEY (`Conductor_ID`)
    REFERENCES `mydb`.`Empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TipoUsuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TipoUsuario` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TipoUsuario` (
  `idTipoUsuario` INT NOT NULL,
  `Tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Usuario` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `Usuario` VARCHAR(45) NOT NULL,
  `Contraseña` VARCHAR(45) NOT NULL,
  `TipoUsuario_idTipoUsuario` INT NOT NULL,
  PRIMARY KEY (`idUsuario`),
  INDEX `fk_Usuario_TipoUsuario1_idx` (`TipoUsuario_idTipoUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_TipoUsuario1`
    FOREIGN KEY (`TipoUsuario_idTipoUsuario`)
    REFERENCES `mydb`.`TipoUsuario` (`idTipoUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Producto` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Producto` (
  `idProducto` INT NOT NULL AUTO_INCREMENT,
  `Tipo` VARCHAR(45) NOT NULL,
  `Descripcion` TEXT NOT NULL,
  `Existencia` INT NOT NULL,
  PRIMARY KEY (`idProducto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Traslado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Traslado` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Traslado` (
  `idTraslado` INT NOT NULL AUTO_INCREMENT,
  `Tipo_Traslado` VARCHAR(45) NOT NULL,
  `Direccion_Origen` VARCHAR(200) NOT NULL,
  `Direccion_Destino` VARCHAR(200) NOT NULL,
  `Fecha` DATE NOT NULL,
  `Hora` TIME NULL,
  `Peso` FLOAT NOT NULL,
  `Vehiculo_idVehiculo` INT NOT NULL,
  PRIMARY KEY (`idTraslado`),
  INDEX `fk_Traslado_Vehiculo1_idx` (`Vehiculo_idVehiculo` ASC) VISIBLE,
  CONSTRAINT `fk_Traslado_Vehiculo1`
    FOREIGN KEY (`Vehiculo_idVehiculo`)
    REFERENCES `mydb`.`Vehiculo` (`idVehiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Bote_Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Bote_Cliente` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Bote_Cliente` (
  `Producto_idProducto` INT NOT NULL,
  `Cliente_idCliente` INT NOT NULL,
  `Fecha_Entrega` DATE NOT NULL,
  `Cantidad` INT NOT NULL,
  `Nota` MEDIUMTEXT NULL,
  PRIMARY KEY (`Producto_idProducto`, `Cliente_idCliente`),
  INDEX `fk_Producto_has_Clientes_Clientes1_idx` (`Cliente_idCliente` ASC) VISIBLE,
  INDEX `fk_Producto_has_Clientes_Producto1_idx` (`Producto_idProducto` ASC) VISIBLE,
  CONSTRAINT `fk_Producto_has_Clientes_Producto1`
    FOREIGN KEY (`Producto_idProducto`)
    REFERENCES `mydb`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_has_Clientes_Clientes1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `mydb`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TipoPago`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TipoPago` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TipoPago` (
  `idTipoPago` INT NOT NULL,
  `Tipo` VARCHAR(45) NOT NULL,
  `Monto` FLOAT NOT NULL,
  PRIMARY KEY (`idTipoPago`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pago`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Pago` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Pago` (
  `idPago` INT NOT NULL,
  `Serie` VARCHAR(45) NOT NULL,
  `Num_Comprobante` VARCHAR(45) NOT NULL,
  `Descripcion` LONGTEXT NULL,
  `Mes_Pago` VARCHAR(45) NOT NULL,
  `Fecha` DATE NOT NULL,
  `Hora` TIME NOT NULL,
  `TipoPago_idTipoPago` INT NOT NULL,
  `Empleado_idEmpleado` INT NOT NULL,
  `Cliente_idCliente` INT NOT NULL,
  INDEX `fk_DetallePago_TipoPago1_idx` (`TipoPago_idTipoPago` ASC) VISIBLE,
  PRIMARY KEY (`idPago`),
  INDEX `fk_Pago_Empleado1_idx` (`Empleado_idEmpleado` ASC) VISIBLE,
  INDEX `fk_Pago_Cliente1_idx` (`Cliente_idCliente` ASC) VISIBLE,
  CONSTRAINT `fk_DetallePago_TipoPago1`
    FOREIGN KEY (`TipoPago_idTipoPago`)
    REFERENCES `mydb`.`TipoPago` (`idTipoPago`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pago_Empleado1`
    FOREIGN KEY (`Empleado_idEmpleado`)
    REFERENCES `mydb`.`Empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pago_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `mydb`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`total_pago`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`total_pago` ;

CREATE TABLE IF NOT EXISTS `mydb`.`total_pago` (
  `idtotal_pago` INT NOT NULL AUTO_INCREMENT,
  `cantidad` FLOAT NOT NULL,
  `descripcion` VARCHAR(120) NOT NULL,
  PRIMARY KEY (`idtotal_pago`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

SELECT idEmpleado, Nombres, Apellidos, Direccion, Telefono, CUI, NIT, FechaNac, Edad, Genero, Cargo 
FROM Empleado
INNER JOIN Cargo ON
	Empleado.Cargo_idCargo = Cargo.idCargo;
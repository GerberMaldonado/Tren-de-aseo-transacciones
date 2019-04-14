SELECT idCliente,Nombres, Apellidos, CUI, Direccion, Municipio, al.Aldea, cas.Caserio FROM mydb.cliente c
LEFT JOIN mydb.caserio cas
ON c.Caserio_ID = cas.idCaserio
LEFT JOIN mydb.aldea al
ON c.Aldea_idAldea = al.idAldea
ORDER BY Nombres ASC;
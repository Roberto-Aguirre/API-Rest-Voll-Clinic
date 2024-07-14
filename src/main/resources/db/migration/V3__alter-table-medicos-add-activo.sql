
ALTER TABLE medicos add activo TINYINT;
UPDATE medicos set activo = 1;
-- Crear un cliente Administrativo
INSERT INTO Usuarios (nombre, tipo, area, experiencia_previa)
VALUES ('Goku', 'ADMINISTRATIVO', 'Administración', '5 años de experiencia');

-- Crear un cliente Cliente
INSERT INTO Usuarios (nombre, tipo, rut, telefono, afp, sistema_salud, direccion, comuna, edad)
VALUES ('Vegeta', 'CLIENTE', '12345678-9', '98765432', 'AFP Pro', 'Fonasa', 'Calle Z', 'Pueblo Z', 35);

-- Crear un cliente Profesional
INSERT INTO Usuarios (nombre, tipo, titulo, fecha_ingreso)
VALUES ('Gohan', 'PROFESIONAL', 'Médico', '2020-01-01');

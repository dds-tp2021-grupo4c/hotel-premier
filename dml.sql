--Inserts Tabla pais
INSERT INTO pais (nombre)
VALUES
	('Argentina'),
	('Bolivia'),
	('Brasil'),
	('Chile'),
	('Ecuador'),
	('Perú'),
	('Uruguay'),
	('Paraguay');

--Inserts Tabla provincia
INSERT INTO provincia (nombre, id_pais)
VALUES
	('Buenos Aires',1),
	('Catamarca',1),
	('Chaco',1),
	('Chubut',1),
	('Córdoba',1),
	('Corrientes',1),
	('Entre Ríos',1),
	('Formosa',1),
	('Jujuy',1),
	('La Pampa',1),
	('La Rioja',1),
	('Mendoza',1),
	('Misiones',1),
	('Neuquén',1),
	('Río Negro',1),
	('Salta',1),
	('San Juan',1),
	('San Luis',1),
	('Santa Cruz',1),
	('Santa Fe',1),
	('Santiago del Estero',1),
	('Tierra del Fuego',1),
	('Tucumán',1),
	('Arica',4),
	('Santiago',4);

--Inserts tabla localidad
INSERT INTO localidad (nombre, codigo_postal, id_provincia)
VALUES
	('Santiago','8320000',25),
	('San Marcos de Arica','1000000',24),
	('22 de Mayo', '2124', 20),
	('4 de Febrero', '2732', 20),
	('Acebal', '2109', 20),
	('Adolfo Alsina', '2109', 20),
	('Aguara Grande', '3071', 20),
	('Aldao', '2214', 20),
	('Alvarez', '2107', 20),
	('Ambrosetti', '2352', 20),
	('Arequito', '2183', 20),
	('Arroyo Seco', '2128', 20),
	('Esperanza', '3080', 20),
	('Santo Tomé', '3016', 20),
	('San Carlos Centro', '3016', 20),
	('San Carlos Norte', '3009', 20),
	('San Carlos Sud', '3013', 20),
	('San Carlos', '6106', 20),
	('Galvez', '2252', 20),
	('Gobernador Crespo', '3044', 20),
	('Rosario', '2000', 20),
	('Santa Fe', '3000', 20),
	('1 de Mayo', '3263', 7),
	('Achiras', '3246', 7),
	('Aldea San Juan', '2826', 7),
	('Aldea San Rafael', '3116', 7),
	('Aldea Santafecina', '3103', 7),
	('Aldea Santa María', '3150', 7),
	('Aldea Protestante', '3101', 7),
	('Aldea María Luisa', '3114', 7),
	('Aranguren', '3162', 7),
	('Camps', '3150', 7),
	('Carrizal', '3101', 7),
	('Cerrito', '3122', 7),
	('Chajarí', '3228', 7),
	('Libertador San Martín', '3103', 7),
	('Villaguay', '3240', 7),
	('Crespo', '3116', 7),
	('General Ramírez', '3164', 7),
	('Paraná', '3100', 7),
	('Tupungato', '5561', 12),
	('Lujan de Cuyo', '5507', 12),
	('Godoy Cruz', '5501', 12),
	('Mendoza', '5500', 12),
	('San Carlos', '5212', 5),
	('Villa Carlos Paz', '5112', 5),
	('Santa Rosa de Calamuchita', '5196', 5),
	('Córdoba', '5000', 5),
	('Malvinas Argentinas', '1846', 1),
	('Banfield', '1828', 1),
	('Alamos', '6437', 1),
	('Hurlingham', '1686', 1),
	('Vicente Lopez', '1638', 1),
	('La Plata', '1900', 1),
	('Achalco', '4235', 2),
	('Aconquija', '4740', 2),
	('Adolfo E Carranza', '5263', 2),
	('Balungasta', '5340', 2),
	('Chiflón', '4718', 2),
	('Choya', '4741', 2),
	('San Fernando del Valle de Catamarca', '4700', 2); 

-- Inserts Tabla tipo_documento
INSERT INTO tipo_documento (nombre)
VALUES
	('Libreta Civica'),
	('Lib. de Enrolamiento'),
	('Pasaporte'),
	('Cedula de identidad'),
	('DNI');

--Inserts en Tabla posicion_frente_iva
INSERT INTO posicion_frente_iva (nombre)
VALUES
	('Monotributista'),
	('Responsable Inscripto'),
	('Excento'),
	('Consumidor Final');

-- Insert en Tabla profesion
INSERT INTO profesion (nombre)
VALUES
	('Abogado'),
	('Escribano'),
	('Doctor'),
	('Veterinario'),
	('Ingeniero'),
	('Profesor'),
	('Bioquímico'),
	('Dentista'),
	('Programador'),
	('Carpintero'),
	('Cerrajero'),
	('Mecánico'),
	('Plomero'),
	('Escritor'),
	('Periodista'),
	('Locutor');

-- Insert en Tabla estado_habitacion
INSERT INTO estado_habitacion (nombre)
VALUES
	('LIBRE'),
	('RESERVADA'),
	('OCUPADA'),
	('FUERA DE SERVICIO');

-- Insert en Tabla tipo_habitacion
INSERT INTO tipo_habitacion (nombre)
VALUES
	('INDIVIDUAL ESTANDAR'),
	('DOBLE ESTANDAR'),
	('DOBLE SUPERIOR'),
	('SUPERIOR FAMILY PLAN'),
	('SUITE DOBLE');

-- Insert en Tabla tipo_consumo
INSERT INTO tipo_consumo (nombre)
VALUES
	('BAR'),
	('SAUNA'),
	('LAVADO PLANCHADO');

-- Insert en Tabla habitacion
INSERT INTO habitacion (id_estado, id_tipo)
VALUES
	(1,1),
	(1,1),
	(1,1),
	(1,1),
	(1,1),
	(1,1),
	(1,1),
	(1,1),
	(1,1),
	(1,1),
	(1,2),
	(1,2),
	(1,2),
	(1,2),
	(1,2),
	(1,2),
	(1,2),
	(1,2),
	(1,2),
	(1,2),
	(1,2),
	(1,2),
	(1,2),
	(1,2),
	(1,2),
	(1,2),
	(1,2),
	(1,2),
	(1,3),
	(1,3),
	(1,3),
	(1,3),
	(1,3),
	(1,3),
	(1,3),
	(1,3),
	(1,4),
	(1,4),
	(1,4),
	(1,4),
	(1,4),
	(1,4),
	(1,4),
	(1,4),
	(1,4),
	(1,4),
	(1,5),
	(1,5);

-- Insert en Tabla moneda
INSERT INTO moneda (nombre)
VALUES
	('DOLAR'),
	('EURO'),
	('REAL'),
	('PESO URUGUAYO'),
	('PESO ARGENTINO');

-- Insert en Tabla costo
INSERT INTO costo (valor,fecha_inicio,id_moneda)
VALUES
	(4200,CURRENT_DATE,5),
	(6240,CURRENT_DATE,5),
	(7308,CURRENT_DATE,5),
	(10500,CURRENT_DATE,5),
	(12600,CURRENT_DATE,5);

-- Insert en Tabla posee
INSERT INTO posee (id_habitacion, id_costo)
VALUES
	(1,1),
	(2,1),
	(3,1),
	(4,1),
	(5,1),
	(6,1),
	(7,1),
	(8,1),
	(9,1),
	(10,1),
	(11,2),
	(12,2),
	(13,2),
	(14,2),
	(15,2),
	(16,2),
	(17,2),
	(18,2),
	(19,2),
	(20,2),
	(21,2),
	(22,2),
	(23,2),
	(24,2),
	(25,2),
	(26,2),
	(27,2),
	(28,2),
	(29,3),
	(30,3),
	(31,3),
	(32,3),
	(33,3),
	(34,3),
	(35,3),
	(36,3),
	(37,4),
	(38,4),
	(39,4),
	(40,4),
	(41,4),
	(42,4),
	(43,4),
	(44,4),
	(45,4),
	(46,4),
	(47,5),
	(48,5);


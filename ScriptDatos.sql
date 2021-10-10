--Inserts Tabla public.pais

INSERT INTO public.pais
VALUES
	(1, 'Argentina'),
	(2, 'Bolivia'),
	(3, 'Brasil'),
	(4, 'Chile'),
	(5, 'Ecuador'),
	(6, 'Perú'),
	(7, 'Uruguay'),
	(8, 'Paraguay');

--Inserts Tabla public.provincia

INSERT INTO public.provincia
VALUES
	(1, 'Buenos Aires'),
	(2, 'Capital Federal'),
	(3, 'Catamarca'),
	(4, 'Chaco'),
	(5, 'Chubut'),
	(6, 'Córdoba'),
	(7, 'Corrientes'),
	(8, 'Entre Ríos'),
	(9, 'Formosa'),
	(10, 'Jujuy'),
	(11, 'La Pampa'),
	(12, 'La Rioja'),
	(13, 'Mendoza'),
	(14, 'Misiones'),
	(15, 'Neuquén'),
	(16, 'Río Negro'),
	(17, 'Salta'),
	(18, 'San Juan'),
	(19, 'San Luis'),
	(20, 'Santa Cruz'),
	(21, 'Santa Fe'),
	(22, 'Santiago del Estero'),
	(23, 'Tierra del Fuego'),
	(24, 'Tucumán');

--Inserts tabla public.localidad

INSERT INTO public.localidad
VALUES
	(1, '22 de Mayo', 2124, 21),
	(2, '4 de Febrero', 2732, 21),
	(3, 'Acebal', 2109, 21),
	(4, 'Adolfo Alsina', 2109, 21),
	(5, 'Aguara Grande', 3071, 21),
	(6, 'Aldao', 2214, 21),
	(7, 'Alvarez', 2107, 21),
	(8, 'Ambrosetti', 2352, 21),
	(9, 'Arequito', 2183, 21),
	(10, 'Arroyo Seco', 2128, 21),
	(11, 'Esperanza', 3080, 21),
	(12, 'Santo Tomé', 3016, 21),
	(13, 'San Carlos Centro', 3016, 21),
	(14, 'San Carlos Norte', 3009, 21),
	(15, 'San Carlos Sud', 3013, 21),
	(16, 'San Carlos', 6106, 21),
	(17, 'Galvez', 2252, 21),
	(18, 'Gobernador Crespo', 3044, 21),
	(19, 'Rosario', 2000, 21),
	(20, 'Santa Fe', 3000, 21),
	(21, '1 de Mayo', 3263, 8),
	(22, 'Achiras', 3246, 8),
	(23, 'Aldea San Juan', 2826, 8),
	(24, 'Aldea San Rafael', 3116, 8),
	(25, 'Aldea Santafecina', 3103, 8),
	(26, 'Aldea Santa María', 3150, 8),
	(27, 'Aldea Protestante', 3101, 8),
	(28, 'Aldea María Luisa', 3114, 8),
	(29, 'Aranguren' 3162, 8),
	(30, 'Camps', 3150, 8),
	(31, 'Carrizal', 3101, 8),
	(32, 'Cerrito', 3122, 8),
	(33, 'Chajarí, 3228, 8),
	(34, 'Libertador San Martín', 3103, 8),
	(35, 'Villaguay', 3240, 8),
	(36, 'Crespo', 3116, 8),
	(37, 'General Ramírez', 3164, 8),
	(38, 'Paraná', 3100, 8),
	(39, 'Tupungato', 5561, 13),
	(40, 'Lujan de Cuyo', 5507, 13),
	(41, 'Godoy Cruz', 5501, 13),
	(42, 'Mendoza', 5500, 13),
	(43, 'San Carlos', 5212, 6),
	(44, 'Villa Carlos Paz', 5112, 6),
	(45, 'Santa Rosa de Calamuchita', 5196, 6),
	(46, 'Córdoba', 5000, 6),
	(47, 'Malvinas Argentinas', 1846, 1),
	(48, 'Banfield', 1828, 1),
	(49, 'Alamos', 6437, 1),
	(50, 'Hurlingham', 1686, 1),
	(51, 'Vicente Lopez', 1638, 1),
	(52, 'La Plata', 1900, 1),
	(53, 'Achalco', 4235, 3),
	(54, 'Aconquija', 4740, 3),
	(55, 'Adolfo E Carranza', 5263, 3),
	(56, 'Balungasta', 5340, 3),
	(57, 'Chiflón', 4718, 3),
	(58, 'Choya', 4741, 3),
	(59, 'San Fernando del Valle de Catamarca', 4700, 3); 

-- Inserts Tabla public.tipo_documento

INSERT INTO public.tipo_documento 
VALUES
	(1, 'Libreta Cívica'),
	(2, 'Lib. de Enrolamiento'),
	(3, 'DNI Libreta Verde'),
	(4, 'DNI Libreta Celeste'),
	(5, 'DNI Tarjeta');

--Inserts en Tabla public.posicion_frente_iva

INSERT INTO public.posicion_frente_iva
VALUES
	(1, 'Monotributista'),
	(2, 'Responsable Inscripto'),
	(3, 'Excento'),
	(4, 'Consumidor Final');

-- Insert en Tabla public.profesion

INSERT INTO public.profesion
VALUES
	(1, 'Abogado'),
	(2, 'Escribano'),
	(3, 'Doctor'),
	(4, 'Veterinario'),
	(5, 'Ingeniero'),
	(6, 'Profesor'),
	(7, 'Bioquímico'),
	(8, 'Dentista'),
	(9, 'Programador'),
	(10, 'Carpintero'),
	(11, 'Cerrajero'),
	(12, 'Mecánico'),
	(13, 'Plomero'),
	(14, 'Escritor'),
	(15, 'Periodista'),
	(16, 'Locutor');



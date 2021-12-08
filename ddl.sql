create table banco(
id serial primary key,
nombre varchar(50) unique not null);

create table usuario(
id serial primary key,
nombre varchar(20) unique not null,
contrasenia varchar(20) not null);

create table tipo_documento(
id serial primary key,
nombre varchar(20) unique not null);

create table profesion(
id serial primary key,
nombre varchar(30) unique not null);

create table posicion_frente_iva(
id serial primary key,
nombre varchar(50) unique not null);

create table pais(
id serial primary key,
nombre varchar(40) unique not null);

create table provincia(
id serial primary key,
nombre varchar(40) not null,
id_pais integer references pais(id) not null);

create table localidad(
id serial primary key,
nombre varchar(40) not null,
codigo_postal varchar(10) not null,
id_provincia integer references provincia(id) not null);

create table pasajero(
id serial primary key,
nombre varchar(50) not null,
apellido varchar(50) not null,
nro_documento varchar(10) not null,
telefono varchar(30) not null,
cuit varchar(13),
fecha_nacimiento date not null,
email varchar(70),
nacionalidad varchar(30) not null,
calle varchar(50) not null,
nro_calle varchar(10) not null,
departamento varchar(10),
piso varchar(10),
id_profesion integer references profesion(id) not null,
id_localidad integer references localidad(id) not null ,
id_tipo_documento integer references tipo_documento(id) not null,
id_posicion_frente_iva integer references posicion_frente_iva(id) not null);

create table moneda(
id serial primary key,
nombre varchar(50) unique not null);

create table eventual_pasajero(
id serial primary key,
nombre varchar(50) not null,
apellido varchar(50) not null,
telefono varchar(30) not null);

create table persona_juridica(
id serial primary key,
calle varchar(50) not null,
nro_calle varchar(10) not null,
telefono varchar(30) not null,
cuit varchar(13) not null,
razon_social varchar(50) not null,
departamento varchar(10),
piso varchar(10),
id_localidad integer references localidad(id) not null);

create table costo(
id serial primary key,
valor float not null,
fecha_inicio date not null,
fecha_fin date,
id_moneda integer references moneda(id));

create table responsable_pago(
id serial primary key,
id_pasajero integer references pasajero(id) on delete set null,
id_persona_juridica integer references persona_juridica(id) on delete set null);

create table estado_habitacion(
id serial primary key,
nombre varchar(20) unique not null);

create table tipo_habitacion(
id serial primary key,
nombre varchar(20) unique not null);

create table tipo_consumo(
id serial primary key,
nombre varchar(20) unique not null);

create table habitacion(
id serial primary key,
numero serial not null,
id_estado integer references estado_habitacion(id) not null,
id_tipo integer references tipo_habitacion(id) not null);

create table ocupacion(
id serial primary key,
fecha_inicio date not null,
fecha_fin date not null,
id_responsable integer references pasajero(id) not null,
id_habitacion integer references habitacion(id) not null);

create table tiene_acompaniantes(
id_pasajero integer references pasajero(id),
id_ocupacion integer references ocupacion(id) not null,
primary key (id_pasajero, id_ocupacion));

create table posee(
id_habitacion integer references habitacion(id) not null,
id_costo integer references costo(id) not null,
primary key (id_habitacion, id_costo));

create table consumo(
id serial primary key,
nombre_producto varchar(50) not null,
precio_unitario float not null,
cantidad integer not null,
id_tipo_consumo integer references tipo_consumo(id) not null,
id_habitacion integer references habitacion(id) not null);

create table reserva(
id serial primary key,
fecha_ingreso date not null,
fecha_egreso date not null,
id_habitacion integer references habitacion(id) not null,
id_eventual_pasajero integer references eventual_pasajero(id) not null);

create table nota_credito(
id serial primary key,
numero integer not null,
iva float not null,
importe_neto float not null,
importe_total float not null,
id_responsable_pago integer references responsable_pago(id) not null);

create table factura(
id serial primary key,
numero integer not null,
tipo character(1) check(tipo in ('A', 'B')) not null,
iva float not null,
importe_neto float not null,
importe_total float not null,
id_responsable_pago integer references responsable_pago(id) not null,
id_nota_credito integer references nota_credito(id),
id_ocupacion integer references ocupacion(id) not null);

create table pago(
id serial primary key,
importe float not null,
vuelto float not null,
id_factura integer references factura(id) not null);

create table medio_pago(
id serial primary key,
importe float not null,
cotizacion float not null,
id_moneda integer references moneda(id) not null,
id_pago integer references pago(id) not null);

create table efectivo(
id_efectivo serial primary key,
id_medio_pago integer references medio_pago(id) not null);

create table tarjeta_debito(
id_tarjeta_debito serial primary key,
nombre varchar(50) unique not null,
id_medio_pago integer references medio_pago(id) not null);

create table tarjeta_credito(
id_tarjeta_credito serial primary key,
nombre varchar(50) unique not null,
id_medio_pago integer references medio_pago(id) not null);

create table cheque(
id_cheque serial primary key,
nro varchar(50) not null,
fecha_cobro date not null,
id_medio_pago integer references medio_pago(id) not null,
id_banco integer references banco(id) not null,
id_localidad integer references localidad(id) not null);

create table se_detalla_en(
id serial primary key,
cantidad integer not null,
id_consumo integer references consumo(id),
id_factura integer references factura(id) not null);

create table mantenimiento(
id serial primary key,
fecha_desde date not null,
fecha_hasta date not null,
id_habitacion integer references habitacion(id) not null);
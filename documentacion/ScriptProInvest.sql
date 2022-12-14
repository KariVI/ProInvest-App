----------------
CREATE DATABASE ProInvest;
USE ProInvest;

CREATE USER 'usuarioProInvest'@'localhost' IDENTIFIED BY 'UserProInvest123';
GRANT ALL PRIVILEGES ON * . * TO 'usuarioProInvest'@'localhost';


-- ----------------------------
-- Tabla para `GradoAcademico`
-- ----------------------------
DROP TABLE IF EXISTS gradoAcademico;
CREATE TABLE gradoAcademico(
	idGradoAcademico int(11) NOT NULL AUTO_INCREMENT,
    grado varchar(255) NOT NULL,
    primary key(idGradoAcademico)
);

-- ----------------------------
-- Tabla para `Profesion`
-- ----------------------------
DROP TABLE IF EXISTS profesion;
CREATE TABLE profesion(
	idProfesion int(11) not null auto_increment,
    nombreProfesion varchar(255) not null,
    primary key(idProfesion)
);

-- ----------------------------
-- Tabla para `usuario`
-- ----------------------------
DROP TABLE IF EXISTS usuario;
CREATE TABLE usuario(
	idUsuario int(11) NOT NULL auto_increment,
    correo varchar(255) not null,
    contrasena varchar(255) not null,
    horaAcceso DATETIME,
    primary key (idUsuario)
);

-- ----------------------------
-- Tabla para `inversionista`
-- ----------------------------
DROP TABLE IF EXISTS inversionista;
CREATE TABLE inversionista (
	idInversionista int(11) NOT NULL AUTO_INCREMENT,
	apellidoMaterno varchar(255) NOT NULL,
	apellidoPaterno varchar(255) NOT NULL,	
	celular varchar(255) NOT NULL,
	direccionIp varchar(255),
	fechaNacimiento DATE NOT NULL,
	nombre VARCHAR(255) NOT NULL,
	rfc VARCHAR(15) NOT NULL,
    idGradoAcademico int(11) NOT NULL,
    idUsuario int(11) not null,
    idProfesion int(11) not null,
	PRIMARY KEY (idInversionista),
    FOREIGN KEY (idGradoAcademico) REFERENCES gradoAcademico(idGradoAcademico),
    foreign key (idUsuario) references usuario(idUsuario),
    foreign key (idProfesion) references profesion(idProfesion)
);

-- ----------------------------
-- Tabla para `banco`
-- ---------------------------
DROP TABLE IF EXISTS banco;
CREATE TABLE banco(
	idBanco int(11) NOT NULL AUTO_INCREMENT,
    nombre varchar(255) NOT NULL,
    primary key(idBanco)
);

-- ----------------------------
-- Tabla para `origenFondos`
-- ---------------------------
DROP TABLE IF EXISTS origenFondo;
CREATE TABLE origenFondo(
	idOrigenFondo int(11) NOT NULL AUTO_INCREMENT,
    origen varchar(255) NOT NULL,
    primary key(idOrigenFondo)
);

-- ----------------------------
-- Tabla para `informacionFinanciera`
-- ----------------------------
DROP TABLE IF EXISTS informacionFinanciera;
CREATE TABLE informacionFinanciera (
	idInformacion int(11) NOT NULL AUTO_INCREMENT,
	idBanco int(11) NOT NULL,
	clabe VARCHAR(50) NOT NULL,
	cuenta VARCHAR(50) NOT NULL,
	idOrigenFondo INT(11) NOT NULL,
	PRIMARY KEY (idInformacion),
    foreign key (idBanco) REFERENCES banco(idBanco),
    foreign key (idOrigenFondo) REFERENCES origenFondo(idOrigenFondo)
);

-- ----------------------------
-- Tabla para `TipoInversion`
-- ----------------------------
DROP TABLE IF EXISTS TipoInversion;
CREATE TABLE TipoInversion(
	idTipoInversion int(11) not null auto_increment,
    tipo varchar(255) not null,
    plazo int not null,
    tasaRetorno DOUBLE not null,
    primary key (idTipoInversion)
);
-- ----------------------------
-- Tabla para `inversion`
-- ----------------------------
DROP TABLE IF EXISTS inversion;
CREATE TABLE inversion (
	idInversion int(11) NOT NULL AUTO_INCREMENT,
	importe DOUBLE NOT NULL,
    idTipoInversion int not null,
	idInversionista INT NOT NULL,
	idInformacion INT NOT NULL,
	PRIMARY KEY (idInversion),
    foreign key (idTipoInversion) REFERENCES tipoInversion(idTipoInversion),
	FOREIGN KEY (idInversionista) REFERENCES inversionista(idInversionista),
	FOREIGN KEY (idInformacion) REFERENCES informacionFinanciera(idInformacion)
);

-- ----------------------------
-- Tabla para `datosSepomex`
-- ----------------------------
DROP TABLE IF EXISTS datosSepomex;
CREATE TABLE datosSepomex(
	idDatosSepomex int NOT NULL AUTO_INCREMENT , 
	idEstado SMALLINT UNSIGNED NOT NULL , 
	estado VARCHAR(255) NOT NULL ,
	idMunicipio SMALLINT UNSIGNED NOT NULL , 
	municipio VARCHAR(255) NOT NULL , 
	ciudad VARCHAR(255), 
	zona VARCHAR(255) NOT NULL,
	cp MEDIUMINT NOT NULL , 
	asentamiento VARCHAR(255) NOT NULL , 
	tipo VARCHAR(255) NOT NULL ,
	PRIMARY KEY (idDatosSepomex)
);

-- ----------------------------
-- Tabla para `direccion`
-- ----------------------------
DROP TABLE IF EXISTS direccion;
CREATE TABLE direccion (
	idDireccion int(11) NOT NULL AUTO_INCREMENT,
	calle VARCHAR(255) NOT NULL,
    numeroExterior INT, 
	numeroInterior INT, 
    idDatosSepomex int not null,
	idInversionista INT NOT NULL,
	PRIMARY KEY (idDireccion),
	FOREIGN KEY (idInversionista) REFERENCES inversionista(idInversionista),
    FOREIGN KEY(idDatosSepomex) REFERENCES datosSepomex(idDatosSepomex)
);

-- ----------------------------
-- Tabla para `expediente`
-- ----------------------------
DROP TABLE IF EXISTS expediente;
CREATE TABLE expediente (
	idExpediente int(11) NOT NULL AUTO_INCREMENT,
	pdf LONGBLOB,
	idInversionista INT NOT NULL,
	PRIMARY KEY (idExpediente),
	FOREIGN KEY (idInversionista) REFERENCES inversionista(idInversionista)
);

DROP database proinvest;
----------------
CREATE DATABASE ProInvest;
USE ProInvest;


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
-- Tabla para `inversionista`
-- ----------------------------
DROP TABLE IF EXISTS inversionista;
CREATE TABLE inversionista (
	idInversionista int(11) NOT NULL AUTO_INCREMENT,
	apellidoMaterno varchar(255) NOT NULL,
	apellidoPaterno varchar(255) NOT NULL,	
	celular varchar(255) NOT NULL,
	correo varchar(255) NOT NULL,
	direccionIp varchar(255) NOT NULL,
	empresa varchar(255) NOT NULL,
	fechaNacimiento DATE NOT NULL,
	idGradoAcademico int(11) NOT NULL,
	nombre VARCHAR(255) NOT NULL,
	profesion VARCHAR(255) NOT NULL,
	rfc VARCHAR(15) NOT NULL,
	PRIMARY KEY (idInversionista),
    FOREIGN KEY (idGradoAcademico) REFERENCES gradoAcademico(idGradoAcademico)
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
-- Tabla para `inversion`
-- ----------------------------
DROP TABLE IF EXISTS inversion;
CREATE TABLE inversion (
	idInversion int(11) NOT NULL AUTO_INCREMENT,
	importe DOUBLE NOT NULL,
	plazo INT NOT NULL,
	tasaRetorno DOUBLE NOT NULL,
	tipo VARCHAR(255) NOT NULL,
	idInversionista INT NOT NULL,
	idInformacion INT NOT NULL,
	PRIMARY KEY (idInversion),
	FOREIGN KEY (idInversionista) REFERENCES inversionista(idInversionista),
	FOREIGN KEY (idInformacion) REFERENCES informacionFinanciera(idInformacion)
);



-- ----------------------------
-- Tabla para `codigoPostal`
-- ---------------------------
DROP TABLE IF EXISTS codigoPostal;
CREATE TABLE codigoPostal(
	idCodigoPostal int(11) NOT NULL AUTO_INCREMENT,
    codigo varchar(255) NOT NULL,
     primary key(idCodigoPostal)
);

-- ----------------------------
-- Tabla para `colonia`
-- ---------------------------
DROP TABLE IF EXISTS colonia;
CREATE TABLE colonia(
	idColonia int(11) NOT NULL AUTO_INCREMENT,
    nombreColonia varchar(255) NOT NULL,
    idCodigoPostal int(11) not null,
    primary key(idColonia),
    foreign key (idCodigoPostal) references codigoPostal(idCodigoPostal)
);

-- ----------------------------
-- Tabla para `estado`
-- ---------------------------
DROP TABLE IF EXISTS estado;
CREATE TABLE estado(
	idEstado int(11) NOT NULL AUTO_INCREMENT,
    nombreEstado varchar(255) NOT NULL,
    primary key(idEstado)
);

-- ----------------------------
-- Tabla para `municipio`
-- ---------------------------
DROP TABLE IF EXISTS municipio;
CREATE TABLE municipio(
	idMunicipio int(11) NOT NULL AUTO_INCREMENT,
    nombreMunicipio varchar(255) NOT NULL,
    idEstado int(11) not null,
    primary key(idMunicipio),
    foreign key(idEstado) references estado (idEstado)
);


-- ----------------------------
-- Tabla para `direccion`
-- ----------------------------
DROP TABLE IF EXISTS direccion;
CREATE TABLE direccion (
	idDireccion int(11) NOT NULL AUTO_INCREMENT,
	calle VARCHAR(255) NOT NULL,
	idCodigoPostal int(11) NOT NULL,
	idColonia int(11) NOT NULL,
	idEstado int(11) NOT NULL,
	idMunicipio int(11) NOT NULL,
	numero INT NOT NULL, 
	idInversionista INT NOT NULL,
	PRIMARY KEY (idDireccion),
	FOREIGN KEY (idInversionista) REFERENCES inversionista(idInversionista),
    FOREIGN KEY (idCodigoPostal) REFERENCES codigoPostal(idCodigoPostal),
    FOREIGN KEY (idColonia) REFERENCES colonia(idColonia),
    FOREIGN KEY (idEstado) REFERENCES estado(idEstado),
    FOREIGN KEY (idMunicipio) REFERENCES municipio(idMunicipio)
);

-- ----------------------------
-- Tabla para `expediente`
-- ----------------------------
DROP TABLE IF EXISTS expediente;
CREATE TABLE expediente (
	idExpediente int(11) NOT NULL AUTO_INCREMENT,
	pdf BLOB,
	idInversionista INT NOT NULL,
	PRIMARY KEY (idExpediente),
	FOREIGN KEY (idInversionista) REFERENCES inversionista(idInversionista)
);





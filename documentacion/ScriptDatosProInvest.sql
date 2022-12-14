USE ProInvest;
-- ----------------------------
-- Insersión datos para `gradoAcademico`
-- ----------------------------
INSERT INTO gradoAcademico(grado) VALUES
('Primaria'),
('Secundaria'),
('Bachillerato'),
('Carrera técnica'),
('Universidad'),
('Maestría'),
('Doctorado');

-- ----------------------------
-- Insersión datos para `Profesion`
-- ----------------------------
INSERT INTO profesion(nombreProfesion) VALUES
('Docente'),
('Ingeniero'),
('Tecnologías de la información y comunicación'),
('Desarrollador'),
('Administrador'),
('Contador'),
('Médico'),
('Arquitecto'),
('Diseñador'),
('Veterinario'),
('Enfermero'),
('Comunicación'),
('Psicólogo'),
('Biólogo');

-- ----------------------------
-- Insersión datos para `Usuario`
-- ----------------------------
INSERT INTO usuario (correo, contrasena) VALUES
('jose_ramon@gmail.com', hex(AES_ENCRYPT("JoseRamon123",'Key'))),
('Laura@gmail.com', hex(AES_ENCRYPT("Laura1234",'Key'))),
('armando.anota.98@gmail.com', hex(AES_ENCRYPT("ArmandoAnota98",'Key'))),
('merari_jimenez@gmail.com', hex(AES_ENCRYPT("MerariJimenez123",'Key'))),
('pedro_velasquez@gmail.com', hex(AES_ENCRYPT("PedritoVelasquez12",'Key')));

-- ----------------------------
-- Insersión datos para `Inversionista`
-- ----------------------------
INSERT INTO inversionista (apellidoMaterno, apellidoPaterno, celular, direccionIp, fechaNacimiento, nombre, rfc, idGradoAcademico, idUsuario, idProfesion) VALUES
('Vargas', 'Ramón', '2287659873', '192.158.1.38', '1988-01-28', 'José', 'RAVO280188HOCRJ', 5, 1, 1),
('Mateos', 'Dominguez', '2287657853', '192.158.1.38', '1990-04-13', 'Laura', 'DOML130490MOCRJ', 5, 2, 2),
('Ramirez', 'Anota', '9873789393', '192.158.1.38',  '1990-05-03', 'Armando', 'ANRA280188HOCRJ', 5, 3, 3),
('Vargas', 'Jimenez', '8763782839', '192.158.1.38',  '1988-10-09', 'Merari', 'JIVM280188HOCRJ', 6, 4, 4),
('Vasquez', 'Velasquez', '3458920392', '192.158.1.38',  '1991-12-08', 'Pedro', 'VEVP280188HOCRJ', 5, 5, 5);

-- ----------------------------
-- Insersión datos para `banco`
-- ----------------------------
INSERT INTO banco (nombre) VALUES 
('Banamex'),
('Santander'),
('BBVA Bancomer'),
('Banorte'),
('HSBC'),
('Scotiabank');

-- ----------------------------
-- Insersión datos para `origenFondos`
-- ----------------------------
INSERT INTO origenFondo (origen) VALUES
('Ahorro');

-- ----------------------------
-- Insersión datos para `informacionFinanciera`
-- ----------------------------
INSERT INTO informacionFinanciera (idBanco, clabe, cuenta, idOrigenFondo) VALUES
(1, '616575574998164351', '10385599668', 1),
(2, '426575574998164358', '11384599668', 1),
(4, '567575574998164352', '13384599668', 1),
(4, '546575574998164353', '10385599458', 1),
(3, '876575574998164355', '10485499678', 1);

-- ----------------------------
-- Insersión datos para `tipoInversion`
-- ----------------------------
INSERT INTO tipoInversion(tipo, plazo, tasaRetorno) VALUES
('CETES', 1, 7.23);

-- ----------------------------
-- Insersión datos para `direccion`
-- ----------------------------
INSERT INTO direccion(calle, numeroExterior, numeroInterior, idDatosSepomex, idInversionista) VALUES
('Robles', 130, 0, 5, 1),
('20 de noviembre', 311, 8, 1029, 2),
('Benito Juarez', 9, 0, 13, 3),
('México', 0, 0, 2394, 4),
('Toluca', 1323, 0, 1331, 5);




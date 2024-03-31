DROP DATABASE IF EXISTS sonicwavecr;

CREATE DATABASE sonicwavecr;

CREATE USER 'usuario_proyecto'@'%' IDENTIFIED BY 'Usuar1o_Clave.';

GRANT All PRIVILEGES ON sonicwavecr.* TO 'usuario_proyecto'@'%';
FLUSH PRIVILEGES;

CREATE TABLE sonicwavecr.tipo_producto (
id_tipo_producto INT NOT NULL AUTO_INCREMENT,
descripcion varchar(30) NOT NULL,
ruta_imagen VARCHAR(1024),
activo bool,
PRIMARY KEY (id_tipo_producto)) 
ENGINE = InnoDB 
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE sonicwavecr.marca (
id_marca INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(50) NOT NULL,
activo bool,
PRIMARY KEY (id_marca))
ENGINE = InnoDB 
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE sonicwavecr.producto (
id_producto INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(50) NOT NULL,
id_tipo_producto INT NOT NULL,
id_marca INT NOT NULL,
descripcion VARCHAR(100) NOT NULL,
precio double,
stock INT,
ruta_imagen VARCHAR(1024),
activo bool,
PRIMARY KEY (id_producto),
FOREIGN KEY (id_tipo_producto) REFERENCES tipo_producto (id_tipo_producto),
FOREIGN KEY (id_marca) REFERENCES marca (id_marca))
ENGINE = InnoDB 
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE sonicwavecr.usuario (
id_usuario INT NOT NULL AUTO_INCREMENT,
username VARCHAR(20) NOT NULL,
password VARCHAR(512) NOT NULL,
nombre VARCHAR(50) NOT NULL, 
apellidos VARCHAR(50) NOT NULL,
correo VARCHAR(50) NULL,
telefono VARCHAR(15) NULL, 
ruta_imagen VARCHAR(1024),
PRIMARY KEY (id_usuario))
ENGINE = InnoDB 
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO sonicwavecr.usuario (id_usuario, username, password, nombre, apellidos, correo, telefono, ruta_imagen) VALUES
(1, 'juan', '$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.', 'Juan', 'Castro Mora', 'jcastro@gmail.com', '4556-8978', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Juan_Diego_Madrigal.jpg/250px-Juan_Diego_Madrigal.jpg'),
(2, 'rebeca', '$2a$10$GkEj.ZzmQa/aEfDmtLIh3udIH5fMphx/35d0EYeqZL5uzgCJ0lQRi', 'Rebeca', 'Contreras Mora', 'acontreras@gmail.com', '5456-8789', 'https://upload.wikimedia.org/wikipedia/commons/0/06/Photo_of_Rebeca_Arthur.jpg'),
(3, 'pedro', '$2a$10$koGR7eS22Pv5KdaVJKDcge04ZB53iMiw76.UjHPY.XyVYlYqXnPbO', 'Pedro', 'Mena Loria', 'lmena@gmail.com', '7898-8936', 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Eduardo_de_Pedro_2019.jpg/480px-Eduardo_de_Pedro_2019.jpg?20200109230854');

INSERT INTO sonicwavecr.tipo_producto (descripcion, ruta_imagen, activo) VALUES
('DAC', 'https://example.com/truthear-dac1000.jpg', 1),
('AMP', 'https://example.com/truthear-dac1000.jpg', 1),
('In-Ear-Monitor', 'https://example.com/truthear-dac1000.jpg', 1),
('Headphones', 'https://example.com/truthear-dac1000.jpg', 1),
('TWS', 'https://example.com/truthear-dac1000.jpg', 1);

INSERT INTO sonicwavecr.marca (nombre) VALUES
('TrutHear'),
('Thangzu'),
('Moondrop'),
('KZ'),
('Dunu'),
('FiiO'),
('Blon'),
('Seenheiser');

INSERT INTO sonicwavecr.producto (nombre,id_tipo_producto,id_marca,descripcion,precio,stock,ruta_imagen,activo) VALUES
('TrutHear DAC-1000',1,1,'High-Resolution Digital-to-Analog Converter',249.99,10,'https://ae01.alicdn.com/kf/S8f983c31ec9c43539f3caccd193878b2B.jpg_640x640Q90.jpg_.webp',true),
('Thangzu T2020 AMP',2, 2,'Stereo Headphone Amplifier',99.99, 15,'https://hifigo.com/cdn/shop/products/xduoo-ta20-plus-balanced-double-tube-class-a-headphone-amplifier-hifigo-xduoo-ta20-plus-585994_800x800.jpg?v=1693821951',true),
('Moondrop Aria In-Ear-Monitor',3,3,'High-Definition Earphones with Balanced Armature Drivers',129.99,20,'https://m.media-amazon.com/images/I/518eldsRiiL.jpg',true),
('KZ ZSTX Pro In-Ear-Monitor',4,4,'Dual Driver Hybrid HiFi Earphones',59.99,30,'https://m.media-amazon.com/images/I/61RzZ4HfTcL.jpg',true),
('Dunu Titan 6 Headphones',4,5,'Over-Ear Open-Back Planar Magnetic Headphones',399.99,8,'https://shenzhenaudio.com/cdn/shop/products/dunu-titan-6-dynamic-126mm-beryllium-diaphragm-sports-wired-earphones-586593.jpg?v=1605619090&width=1000',true),
('FiiO FH5S In-Ear-Monitor',3,6,'Quad Driver HiFi Earphones with Detachable Cable',299.99,25,'https://m.media-amazon.com/images/I/510dGhgyY3S._AC_UF894,1000_QL80_.jpg',true),
('Blon BL-30 AMP',2,7,'Portable Hi-Res Audio Amplifier',79.99,12,'https://cdn.shopify.com/s/files/1/0040/7201/3924/products/BLONHeadphone_2_f0c8f68b-605b-49c4-8e9f-efac0dc9dd46_1024x1024.jpg',true),
('Seenheiser HD 660 S Headphones',1,8,'Reference-Class Open-Back Dynamic Headphones',499.99,5,'https://eu.sennheiser-hearing.com/cdn/shop/products/660S2.1_530x@2x.png?v=1674735602',true);

CREATE TABLE sonicwavecr.rol (
  id_rol INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(20),
  id_usuario INT,
  PRIMARY KEY (id_rol),
  FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO sonicwavecr.rol (nombre, id_usuario) VALUES
('ROLE_ADMIN', 1), ('ROLE_USER', 1), ('ROLE_ADMIN', 2), ('ROLE_USER', 2), ('ROLE_USER', 3);


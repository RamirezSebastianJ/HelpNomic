-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3308
-- Tiempo de generación: 25-07-2020 a las 08:26:55
-- Versión del servidor: 8.0.18
-- Versión de PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `help_nomic`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

DROP TABLE IF EXISTS `administrador`;
CREATE TABLE IF NOT EXISTS `administrador` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(70) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `cedula` int(20) NOT NULL,
  `sueldo` float(10,3) NOT NULL,
  `direccion` varchar(70) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `telefono` float(10,0) NOT NULL,
  `monto_cartera` float(10,3) NOT NULL,
  `id_super_asministrador` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_super_asministrador` (`id_super_asministrador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cartera_administrador`
--

DROP TABLE IF EXISTS `cartera_administrador`;
CREATE TABLE IF NOT EXISTS `cartera_administrador` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `monto_total_ca` float(10,3) NOT NULL,
  `monto_prestado_ca` float(10,3) NOT NULL,
  `puntos_negativos` int(3) NOT NULL,
  `id_administrador` int(4) NOT NULL,
  `id_super_cartera` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_super_cartera` (`id_super_cartera`),
  KEY `id_administrador` (`id_administrador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `credito`
--

DROP TABLE IF EXISTS `credito`;
CREATE TABLE IF NOT EXISTS `credito` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `monto` float(10,3) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `tipo_de_pago` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `metodo_de_pago` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `porcentaje` float(2,2) NOT NULL,
  `cantidad_cuotas` int(2) NOT NULL,
  `cuotas_cumplidas` int(2) NOT NULL,
  `puntos_negativos` int(3) NOT NULL,
  `id_usuario` int(4) NOT NULL,
  `id_cartera_administrador` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_cartera_administrador` (`id_cartera_administrador`),
  KEY `id_usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `super_administrador`
--

DROP TABLE IF EXISTS `super_administrador`;
CREATE TABLE IF NOT EXISTS `super_administrador` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(70) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `cedula` int(20) NOT NULL,
  `pass` int(6) NOT NULL,
  `telefono` float(10,0) NOT NULL,
  `direccion` varchar(70) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `super_administrador`
--

INSERT INTO `super_administrador` (`id`, `nombre`, `cedula`, `pass`, `telefono`, `direccion`) VALUES
(1, 'juan sebastian', 1112794590, 205085, 3145911808, 'calle 4 9 27');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `super_cartera`
--

DROP TABLE IF EXISTS `super_cartera`;
CREATE TABLE IF NOT EXISTS `super_cartera` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `monto_total` float(10,3) NOT NULL,
  `monto_prestado` float(10,3) NOT NULL,
  `id_super_administrador` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_super_administrador` (`id_super_administrador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(70) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `cedula` int(20) NOT NULL,
  `direccion` varchar(70) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `cantidad_prestamos` int(1) NOT NULL,
  `puntos_negativos` int(3) NOT NULL,
  `telefono` float(10,0) NOT NULL,
  `deuda_total` float(10,3) NOT NULL,
  `id_administrador` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_administrador` (`id_administrador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD CONSTRAINT `administrador_ibfk_1` FOREIGN KEY (`id_super_asministrador`) REFERENCES `super_administrador` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE;

--
-- Filtros para la tabla `cartera_administrador`
--
ALTER TABLE `cartera_administrador`
  ADD CONSTRAINT `cartera_administrador_ibfk_1` FOREIGN KEY (`id_super_cartera`) REFERENCES `super_cartera` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  ADD CONSTRAINT `cartera_administrador_ibfk_2` FOREIGN KEY (`id_administrador`) REFERENCES `administrador` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE;

--
-- Filtros para la tabla `credito`
--
ALTER TABLE `credito`
  ADD CONSTRAINT `credito_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  ADD CONSTRAINT `credito_ibfk_2` FOREIGN KEY (`id_cartera_administrador`) REFERENCES `cartera_administrador` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE;

--
-- Filtros para la tabla `super_cartera`
--
ALTER TABLE `super_cartera`
  ADD CONSTRAINT `super_cartera_ibfk_1` FOREIGN KEY (`id_super_administrador`) REFERENCES `super_administrador` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_administrador`) REFERENCES `administrador` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

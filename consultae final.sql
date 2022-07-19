-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 15, 2020 at 06:00 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `consultae`
--

-- --------------------------------------------------------

--
-- Table structure for table `acceso`
--

CREATE TABLE `acceso` (
  `usuario` varchar(45) NOT NULL,
  `clave` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `acceso`
--

INSERT INTO `acceso` (`usuario`, `clave`) VALUES
('test', '123');

-- --------------------------------------------------------

--
-- Table structure for table `consulta`
--

CREATE TABLE `consulta` (
  `id_consulta` int(45) NOT NULL,
  `fecha_consulta` date NOT NULL,
  `paciente_rut` varchar(45) NOT NULL,
  `doctor_rut` varchar(45) NOT NULL,
  `doctor_precio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `rut_doctor` varchar(45) NOT NULL,
  `nombre_doctor` varchar(45) NOT NULL,
  `apellido_doctor` varchar(45) NOT NULL,
  `fecha_ nacimiento` date NOT NULL,
  `correo` varchar(45) NOT NULL,
  `especialidad` varchar(45) NOT NULL,
  `precio` int(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `paciente`
--

CREATE TABLE `paciente` (
  `rut` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `fecha_ nacimiento` date NOT NULL,
  `correo` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `acceso`
--
ALTER TABLE `acceso`
  ADD PRIMARY KEY (`usuario`);

--
-- Indexes for table `consulta`
--
ALTER TABLE `consulta`
  ADD PRIMARY KEY (`id_consulta`),
  ADD KEY `paciente_rut` (`paciente_rut`),
  ADD KEY `doctor_rut` (`doctor_rut`,`doctor_precio`),
  ADD KEY `doctor_rut_2` (`doctor_rut`),
  ADD KEY `consulta_ibfk_3` (`doctor_precio`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`rut_doctor`),
  ADD KEY `precio` (`precio`),
  ADD KEY `rut_doctor` (`rut_doctor`),
  ADD KEY `nombre_doctor` (`nombre_doctor`);

--
-- Indexes for table `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`rut`),
  ADD UNIQUE KEY `rut` (`rut`),
  ADD KEY `rut_2` (`rut`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `consulta`
--
ALTER TABLE `consulta`
  MODIFY `id_consulta` int(45) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `consulta`
--
ALTER TABLE `consulta`
  ADD CONSTRAINT `consulta_ibfk_3` FOREIGN KEY (`doctor_precio`) REFERENCES `doctor` (`precio`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `consulta_ibfk_4` FOREIGN KEY (`doctor_rut`) REFERENCES `doctor` (`rut_doctor`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `consulta_ibfk_5` FOREIGN KEY (`paciente_rut`) REFERENCES `paciente` (`rut`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

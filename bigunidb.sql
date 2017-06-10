-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 10-Jun-2017 às 20:36
-- Versão do servidor: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bigunidb`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `carona`
--

CREATE TABLE IF NOT EXISTS `carona` (
  `status` tinyint(1) NOT NULL,
  `trajeto` varchar(420) NOT NULL,
  `vagas` int(11) NOT NULL,
  `vagas_disponiveis` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `matricula` bigint(20) NOT NULL,
  `senha` varchar(60) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `endereco` varchar(150) NOT NULL,
  `perfilsocial` varchar(60) NOT NULL,
  `avatar` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario_carona`
--

CREATE TABLE IF NOT EXISTS `usuario_carona` (
  `matricula_usuario` bigint(20) NOT NULL,
  `vagasdisponiveis_carona` int(11) NOT NULL,
  `descricao` text NOT NULL,
  `trajeto` text NOT NULL,
  `diasDaSemana` int(11) NOT NULL,
  `horario` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `carona`
--
ALTER TABLE `carona`
 ADD PRIMARY KEY (`vagas_disponiveis`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
 ADD PRIMARY KEY (`matricula`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

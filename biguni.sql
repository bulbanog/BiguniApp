-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 03-Abr-2017 às 01:15
-- Versão do servidor: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `biguni`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `carona`
--

CREATE TABLE `carona` (
  `status` int(11) NOT NULL COMMENT '0-disponivel  1-indisponível',
  `caroneiro_fk` int(11) NOT NULL,
  `caronas_fk` int(11) NOT NULL,
  `vagas_disponiveis` int(11) NOT NULL,
  `horario_saida` varchar(15) NOT NULL,
  `dias_semana` int(11) NOT NULL COMMENT '1-5 respectivos dias da semana'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `carro`
--

CREATE TABLE `carro` (
  `dono_matricula_fk` int(11) NOT NULL,
  `modelo` varchar(20) NOT NULL,
  `cor` varchar(12) NOT NULL,
  `total de vagas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `curso`
--

CREATE TABLE `curso` (
  `id_curso` int(11) NOT NULL,
  `nome_curso` varchar(20) NOT NULL,
  `turma_curso` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `trajetos`
--

CREATE TABLE `trajetos` (
  `caroneiro_FK` int(11) NOT NULL,
  `saida` varchar(15) NOT NULL,
  `retorno` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `matricula_usuario` int(11) NOT NULL,
  `cpf_usuario` bigint(20) NOT NULL,
  `nome_usuario` varchar(50) NOT NULL,
  `posicao_usuario` int(11) NOT NULL COMMENT '0 - caroneiro 1 - carona',
  `habilitacao_usuario` int(11) NOT NULL,
  `telefone` bigint(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `id_curso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `carona`
--
ALTER TABLE `carona`
  ADD KEY `caroneiro_fk` (`caroneiro_fk`),
  ADD KEY `caronas_fk` (`caronas_fk`);

--
-- Indexes for table `carro`
--
ALTER TABLE `carro`
  ADD KEY `dono_matricula_fk` (`dono_matricula_fk`);

--
-- Indexes for table `trajetos`
--
ALTER TABLE `trajetos`
  ADD KEY `caroneiro_FK` (`caroneiro_FK`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`matricula_usuario`);

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `carona`
--
ALTER TABLE `carona`
  ADD CONSTRAINT `carona_ibfk_1` FOREIGN KEY (`caroneiro_fk`) REFERENCES `usuario` (`matricula_usuario`),
  ADD CONSTRAINT `carona_ibfk_2` FOREIGN KEY (`caronas_fk`) REFERENCES `usuario` (`matricula_usuario`);

--
-- Limitadores para a tabela `carro`
--
ALTER TABLE `carro`
  ADD CONSTRAINT `carro_ibfk_1` FOREIGN KEY (`dono_matricula_fk`) REFERENCES `usuario` (`matricula_usuario`);

--
-- Limitadores para a tabela `trajetos`
--
ALTER TABLE `trajetos`
  ADD CONSTRAINT `trajetos_ibfk_1` FOREIGN KEY (`caroneiro_FK`) REFERENCES `usuario` (`matricula_usuario`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

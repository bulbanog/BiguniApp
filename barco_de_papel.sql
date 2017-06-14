-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 14-Jun-2017 às 21:10
-- Versão do servidor: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `barco_de_papel`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `codigo` int(11) NOT NULL,
  `cpf` varchar(20) NOT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `nome` varchar(200) NOT NULL,
  `email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `cep` varchar(20) NOT NULL,
  `rua` varchar(100) DEFAULT NULL,
  `numero` varchar(20) DEFAULT NULL,
  `telefone` varchar(50) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `uf` char(2) DEFAULT NULL,
  `complemento` varchar(150) DEFAULT NULL,
  `fornecedor_cnpj` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`cep`, `rua`, `numero`, `telefone`, `bairro`, `cidade`, `uf`, `complemento`, `fornecedor_cnpj`) VALUES
('23124', 'Rua Professor', '1919', '341234324', 'Barro', 'Recife', 'PE', 'Frente a igreja', '1237637');

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE `fornecedor` (
  `cnpj` varchar(100) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `nome_fantasia` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `fornecedor`
--

INSERT INTO `fornecedor` (`cnpj`, `nome`, `nome_fantasia`) VALUES
('1237637', 'Lule Art', 'Caixas');

-- --------------------------------------------------------

--
-- Estrutura da tabela `material`
--

CREATE TABLE `material` (
  `idmaterial` int(11) NOT NULL,
  `tipo` varchar(100) DEFAULT NULL,
  `modelo` varchar(45) DEFAULT NULL,
  `cor` varchar(45) DEFAULT NULL,
  `gramatura` double DEFAULT NULL,
  `preco_compra` double DEFAULT NULL,
  `quantidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `material`
--

INSERT INTO `material` (`idmaterial`, `tipo`, `modelo`, `cor`, `gramatura`, `preco_compra`, `quantidade`) VALUES
(1, 'Papel', '15x15', 'Rio de Janeiro', 80, 2, 25),
(2, 'Garrafa Solitario', 'Vidro', 'Transparente', 0, 1.8, 15);

-- --------------------------------------------------------

--
-- Estrutura da tabela `material_fornecedor`
--

CREATE TABLE `material_fornecedor` (
  `material_idmaterial` int(11) NOT NULL,
  `fornecedor_cnpj` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `material_fornecedor`
--

INSERT INTO `material_fornecedor` (`material_idmaterial`, `fornecedor_cnpj`) VALUES
(1, '1237637'),
(2, '1237637');

-- --------------------------------------------------------

--
-- Estrutura da tabela `material_produto`
--

CREATE TABLE `material_produto` (
  `material_idmaterial` int(11) NOT NULL,
  `produto_codigo` varchar(10) NOT NULL,
  `quantidade` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `codigo` varchar(10) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `descricao` varchar(300) NOT NULL,
  `preco` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`codigo`, `quantidade`, `descricao`, `preco`) VALUES
('1', 2, 'Quadro Rosa', 20),
('2', 10, 'Solitario', 15);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto_venda`
--

CREATE TABLE `produto_venda` (
  `produto_codigo` varchar(10) NOT NULL,
  `venda_idvenda` int(11) NOT NULL,
  `preco` double NOT NULL,
  `quantidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE `venda` (
  `idvenda` int(11) NOT NULL,
  `data` date DEFAULT NULL,
  `loja` varchar(45) DEFAULT NULL,
  `status` varchar(15) DEFAULT NULL,
  `cliente_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`codigo`);

--
-- Indexes for table `endereco`
--
ALTER TABLE `endereco`
  ADD KEY `fk_endereco_fornecedor1_idx` (`fornecedor_cnpj`);

--
-- Indexes for table `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`cnpj`);

--
-- Indexes for table `material`
--
ALTER TABLE `material`
  ADD PRIMARY KEY (`idmaterial`);

--
-- Indexes for table `material_fornecedor`
--
ALTER TABLE `material_fornecedor`
  ADD PRIMARY KEY (`material_idmaterial`,`fornecedor_cnpj`),
  ADD KEY `fk_material_has_fornecedor_fornecedor1_idx` (`fornecedor_cnpj`),
  ADD KEY `fk_material_has_fornecedor_material1_idx` (`material_idmaterial`);

--
-- Indexes for table `material_produto`
--
ALTER TABLE `material_produto`
  ADD PRIMARY KEY (`material_idmaterial`,`produto_codigo`),
  ADD KEY `fk_material_has_produto_produto1_idx` (`produto_codigo`),
  ADD KEY `fk_material_has_produto_material1_idx` (`material_idmaterial`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`codigo`);

--
-- Indexes for table `produto_venda`
--
ALTER TABLE `produto_venda`
  ADD PRIMARY KEY (`produto_codigo`,`venda_idvenda`),
  ADD KEY `fk_produto_has_venda_venda1_idx` (`venda_idvenda`),
  ADD KEY `fk_produto_has_venda_produto_idx` (`produto_codigo`);

--
-- Indexes for table `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`idvenda`),
  ADD KEY `fk_venda_cliente1_idx` (`cliente_codigo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `material`
--
ALTER TABLE `material`
  MODIFY `idmaterial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `venda`
--
ALTER TABLE `venda`
  MODIFY `idvenda` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `endereco`
--
ALTER TABLE `endereco`
  ADD CONSTRAINT `fk_endereco_fornecedor1` FOREIGN KEY (`fornecedor_cnpj`) REFERENCES `fornecedor` (`cnpj`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `material_fornecedor`
--
ALTER TABLE `material_fornecedor`
  ADD CONSTRAINT `fk_material_has_fornecedor_fornecedor1` FOREIGN KEY (`fornecedor_cnpj`) REFERENCES `fornecedor` (`cnpj`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_material_has_fornecedor_material1` FOREIGN KEY (`material_idmaterial`) REFERENCES `material` (`idmaterial`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `material_produto`
--
ALTER TABLE `material_produto`
  ADD CONSTRAINT `fk_material_has_produto_material1` FOREIGN KEY (`material_idmaterial`) REFERENCES `material` (`idmaterial`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_material_has_produto_produto1` FOREIGN KEY (`produto_codigo`) REFERENCES `produto` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `produto_venda`
--
ALTER TABLE `produto_venda`
  ADD CONSTRAINT `fk_produto_has_venda_produto` FOREIGN KEY (`produto_codigo`) REFERENCES `produto` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_produto_has_venda_venda1` FOREIGN KEY (`venda_idvenda`) REFERENCES `venda` (`idvenda`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `venda`
--
ALTER TABLE `venda`
  ADD CONSTRAINT `fk_venda_cliente1` FOREIGN KEY (`cliente_codigo`) REFERENCES `cliente` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

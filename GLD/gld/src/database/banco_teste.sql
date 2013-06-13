-- phpMyAdmin SQL Dump
-- version 4.0.3
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: 11/06/2013 às 00:28
-- Versão do servidor: 5.5.31-0ubuntu0.13.04.1
-- Versão do PHP: 5.4.9-4ubuntu2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de dados: `banco_teste`
--
CREATE DATABASE IF NOT EXISTS `banco_teste` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `banco_teste`;

-- --------------------------------------------------------

--
-- Estrutura para tabela `tabela_teste`
--

CREATE TABLE IF NOT EXISTS `tabela_teste` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

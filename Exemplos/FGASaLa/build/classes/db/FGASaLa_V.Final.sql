-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 19, 2011 at 01:05 AM
-- Server version: 5.1.44
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `FGASaLa`
--
CREATE DATABASE `FGASaLa` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `FGASaLa`;

-- --------------------------------------------------------

--
-- Table structure for table `equip`
--

CREATE TABLE IF NOT EXISTS `equip` (
  `idequip` int(3) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `nome` varchar(15) NOT NULL,
  `descricao` varchar(80) NOT NULL,
  `status` varchar(15) NOT NULL,
  PRIMARY KEY (`idequip`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `equip`
--

INSERT INTO `equip` (`idequip`, `nome`, `descricao`, `status`) VALUES
(001, 'Projetor', 'Projetor Novo!', 'EMUSO'),
(002, 'Projetor', 'Projetor Novo!', 'EMUSO'),
(003, 'Projetor', 'Projetor Novo!', 'DISPONIVEL'),
(004, 'Computador', 'Computador Novo!', 'DISPONIVEL'),
(005, 'Computador', 'Computador Novo!', 'DISPONIVEL'),
(006, 'Computador', 'Computador Novo!', 'DISPONIVEL');

-- --------------------------------------------------------

--
-- Table structure for table `lab`
--

CREATE TABLE IF NOT EXISTS `lab` (
  `idlab` int(3) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `nbancada` int(11) NOT NULL,
  `nporbancada` int(11) NOT NULL,
  `locallab` varchar(20) NOT NULL,
  `tipolab` varchar(20) NOT NULL,
  PRIMARY KEY (`idlab`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `lab`
--

INSERT INTO `lab` (`idlab`, `nbancada`, `nporbancada`, `locallab`, `tipolab`) VALUES
(003, 7, 9, 'Fórum', 'Informática'),
(004, 7, 7, 'Fórum', 'Eletrônica'),
(006, 6, 6, 'SESC', 'Eletrônica'),
(007, 5, 5, 'Galpão', 'Informática');

-- --------------------------------------------------------

--
-- Table structure for table `lab_equip`
--

CREATE TABLE IF NOT EXISTS `lab_equip` (
  `idlab` int(3) unsigned zerofill NOT NULL,
  `idequip` int(3) unsigned zerofill NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lab_equip`
--


-- --------------------------------------------------------

--
-- Table structure for table `local`
--

CREATE TABLE IF NOT EXISTS `local` (
  `idlocal` int(2) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `nomelocal` varchar(20) NOT NULL,
  PRIMARY KEY (`idlocal`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `local`
--

INSERT INTO `local` (`idlocal`, `nomelocal`) VALUES
(01, 'Novo Campus'),
(02, 'Fórum'),
(03, 'SESC'),
(04, 'Galpão');

-- --------------------------------------------------------

--
-- Table structure for table `sala`
--

CREATE TABLE IF NOT EXISTS `sala` (
  `idsala` int(3) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `qtdlugares` int(10) unsigned NOT NULL,
  `localsala` varchar(20) NOT NULL,
  `tiposala` varchar(20) NOT NULL,
  PRIMARY KEY (`idsala`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Dumping data for table `sala`
--

INSERT INTO `sala` (`idsala`, `qtdlugares`, `localsala`, `tiposala`) VALUES
(001, 60, 'Novo Campus', 'Aula'),
(002, 60, 'Fórum', 'Aula'),
(003, 12, 'SESC', 'Aula'),
(004, 60, 'Galpão', 'Aula'),
(005, 70, 'Novo Campus', 'Reunião'),
(006, 70, 'Fórum', 'Reunião'),
(007, 70, 'SESC', 'Reunião'),
(008, 70, 'Galpão', 'Reunião'),
(009, 120, 'Novo Campus', 'Auditório'),
(010, 120, 'Fórum', 'Auditório'),
(011, 120, 'SESC', 'Auditório'),
(012, 120, 'Galpão', 'Auditório'),
(013, 120, 'Novo Campus', 'Aula'),
(014, 100, 'Novo Campus', 'Aula'),
(016, 60, 'Fórum', 'Reunião');

-- --------------------------------------------------------

--
-- Table structure for table `sala_equip`
--

CREATE TABLE IF NOT EXISTS `sala_equip` (
  `idsala` int(3) unsigned zerofill NOT NULL,
  `idequip` int(3) unsigned zerofill NOT NULL,
  KEY `idsala` (`idsala`),
  KEY `idequip` (`idequip`),
  KEY `idsala_2` (`idsala`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sala_equip`
--

INSERT INTO `sala_equip` (`idsala`, `idequip`) VALUES
(001, 001),
(001, 002);

-- --------------------------------------------------------

--
-- Table structure for table `solicitacao`
--

CREATE TABLE IF NOT EXISTS `solicitacao` (
  `idsolic` int(6) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `idusuario` varchar(15) NOT NULL,
  `idsala` int(3) unsigned zerofill NOT NULL,
  `idlab` int(3) unsigned zerofill NOT NULL,
  `data` date NOT NULL,
  `diasemana` int(2) NOT NULL,
  `hora` int(2) NOT NULL,
  `nbancada` int(11) NOT NULL,
  `status` varchar(15) NOT NULL,
  PRIMARY KEY (`idsolic`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `solicitacao`
--

INSERT INTO `solicitacao` (`idsolic`, `idusuario`, `idsala`, `idlab`, `data`, `diasemana`, `hora`, `nbancada`, `status`) VALUES
(000001, 'user', 001, 000, '2011-07-17', 1, 1, 0, 'RESERVADA'),
(000005, 'user', 001, 000, '2011-07-20', 4, 3, 0, 'RESERVADA');

-- --------------------------------------------------------

--
-- Table structure for table `tipo_lab`
--

CREATE TABLE IF NOT EXISTS `tipo_lab` (
  `idtipo` int(3) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `nometipo` varchar(20) NOT NULL,
  PRIMARY KEY (`idtipo`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tipo_lab`
--

INSERT INTO `tipo_lab` (`idtipo`, `nometipo`) VALUES
(001, 'Informática'),
(002, 'Eletrônica');

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `user` varchar(20) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `tipo` varchar(10) NOT NULL,
  PRIMARY KEY (`user`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`user`, `senha`, `nome`, `email`, `telefone`, `tipo`) VALUES
('admin', 'admin', 'Itallo Rossi', 'itallorossi.lucas@gmail.com', '(61) 8416-9944', 'admin'),
('admin2', 'admin2', 'Matheus da Silva Freire', 'matheus@gmail.com', '(61) 3030-3030', 'admin'),
('090038070', '123456', 'Itallo Rossi', 'itallorossi.lucas@gmail.com', '(61) 9131-6325', 'usuario'),
('090038843', '123456', 'Matheus da Silva Freire', 'matheus@gmail.com', '(61) 9111-3908', 'usuario'),
('090039548', '123456', 'Wagner Jeronimo', 'wagner@gmail.com', '(61) 8188-5187', 'usuario'),
('090039505', '123456', 'Vinicius Maia de Brito', 'vinicius@gmail.com', '(61) 9311-2424', 'usuario');

-- phpMyAdmin SQL Dump
-- version 5.2.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 02, 2026 at 01:27 AM
-- Server version: 8.0.30
-- PHP Version: 8.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_kampus_resky`
--

-- --------------------------------------------------------

--
-- Table structure for table `bobot`
--

CREATE TABLE `bobot` (
  `nilaiMutu` char(2) NOT NULL,
  `bobot` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `bobot`
--

INSERT INTO `bobot` (`nilaiMutu`, `bobot`) VALUES
('A', 4),
('B', 3),
('C', 3);

-- --------------------------------------------------------

--
-- Table structure for table `dosen`
--

CREATE TABLE `dosen` (
  `nid` varchar(10) NOT NULL,
  `nama_dosen` varchar(50) DEFAULT NULL,
  `gender` enum('L','P') DEFAULT NULL,
  `alamat_dosen` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `dosen`
--

INSERT INTO `dosen` (`nid`, `nama_dosen`, `gender`, `alamat_dosen`) VALUES
('D01', 'BU ENTIN', 'P', 'Jakarta timur'),
('D02', 'Pak jo', 'L', 'Bandung');

-- --------------------------------------------------------

--
-- Table structure for table `dosen_mengajar`
--

CREATE TABLE `dosen_mengajar` (
  `id_mengajar` int NOT NULL,
  `nid` varchar(10) DEFAULT NULL,
  `kdMatkul` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `dosen_mengajar`
--

INSERT INTO `dosen_mengajar` (`id_mengajar`, `nid`, `kdMatkul`) VALUES
(1, 'D01', 'MK01'),
(3, 'D01', 'MK02'),
(4, 'D02', 'MK02');

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `nim` varchar(15) NOT NULL,
  `nama_mhs` varchar(50) DEFAULT NULL,
  `gender` enum('L','P') DEFAULT NULL,
  `tempat_lahir` varchar(30) NOT NULL,
  `tglLahir` date DEFAULT NULL,
  `noHP` varchar(17) DEFAULT NULL,
  `alamat` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`nim`, `nama_mhs`, `gender`, `tempat_lahir`, `tglLahir`, `noHP`, `alamat`) VALUES
('M01', 'Reza F', 'L', 'Jakarta', '2008-12-11', '088843621', 'Jalan Jani Nasir'),
('M02', 'raka', 'L', 'jakarta', '2026-02-11', '0823623523', 'Cawang'),
('M03', 'leo', 'P', 'jakarta', '2026-02-11', '0823623523', 'Cawang'),
('M04', 'resky', 'L', 'jakartaaaaaaaaa', '2026-02-04', '2545463', 'jakarta');

-- --------------------------------------------------------

--
-- Table structure for table `matakuliah`
--

CREATE TABLE `matakuliah` (
  `kdMatkul` varchar(10) NOT NULL,
  `namaMatkul` varchar(50) DEFAULT NULL,
  `sks` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `matakuliah`
--

INSERT INTO `matakuliah` (`kdMatkul`, `namaMatkul`, `sks`) VALUES
('MK01', 'Basis Data', 3),
('MK02', 'Java Desktop', 2),
('MK03', 'Desain Web', 1);

-- --------------------------------------------------------

--
-- Table structure for table `nilai`
--

CREATE TABLE `nilai` (
  `idNilai` int NOT NULL,
  `nim` varchar(15) DEFAULT NULL,
  `id_mengajar` int DEFAULT NULL,
  `tgs` int DEFAULT NULL,
  `uts` int DEFAULT NULL,
  `uas` int DEFAULT NULL,
  `nilaiMutu` char(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `nilai`
--

INSERT INTO `nilai` (`idNilai`, `nim`, `id_mengajar`, `tgs`, `uts`, `uas`, `nilaiMutu`) VALUES
(2, 'M04', 1, 90, 90, 90, 'A'),
(3, 'M03', 1, 75, 75, 75, 'B'),
(5, 'M01', 1, 90, 87, 95, 'A');

--
-- Triggers `nilai`
--
DELIMITER $$
CREATE TRIGGER `insert_nilaiMutu` BEFORE INSERT ON `nilai` FOR EACH ROW BEGIN
    DECLARE rata DOUBLE;
    SET rata = (NEW.tgs + NEW.uts + NEW.uas) / 3;
    
    IF rata >= 85 THEN SET NEW.nilaiMutu = 'A';
    ELSEIF rata >= 75 THEN SET NEW.nilaiMutu = 'B';
    ELSEIF rata >= 60 THEN SET NEW.nilaiMutu = 'C';
    ELSEIF rata >= 45 THEN SET NEW.nilaiMutu = 'D';
    ELSE SET NEW.nilaiMutu = 'E';
    END IF;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `update_nilaiMutu` BEFORE UPDATE ON `nilai` FOR EACH ROW BEGIN
    DECLARE rata DOUBLE;
    -- Mengambil nilai baru (NEW) yang sedang di-update
    SET rata = (NEW.tgs + NEW.uts + NEW.uas) / 3;
    
    IF rata >= 85 THEN SET NEW.nilaiMutu = 'A';
    ELSEIF rata >= 75 THEN SET NEW.nilaiMutu = 'B';
    ELSEIF rata >= 60 THEN SET NEW.nilaiMutu = 'C';
    ELSEIF rata >= 45 THEN SET NEW.nilaiMutu = 'D';
    ELSE SET NEW.nilaiMutu = 'E';
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `level` enum('admin','dosen','mahasiswa') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `level`) VALUES
('admin', 'admin1234', 'admin'),
('Dosen1', '123', 'dosen'),
('Mahasiswa1', 'password', 'mahasiswa');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bobot`
--
ALTER TABLE `bobot`
  ADD PRIMARY KEY (`nilaiMutu`);

--
-- Indexes for table `dosen`
--
ALTER TABLE `dosen`
  ADD PRIMARY KEY (`nid`);

--
-- Indexes for table `dosen_mengajar`
--
ALTER TABLE `dosen_mengajar`
  ADD PRIMARY KEY (`id_mengajar`),
  ADD KEY `nid` (`nid`,`kdMatkul`),
  ADD KEY `kdMatkul` (`kdMatkul`);

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`nim`);

--
-- Indexes for table `matakuliah`
--
ALTER TABLE `matakuliah`
  ADD PRIMARY KEY (`kdMatkul`);

--
-- Indexes for table `nilai`
--
ALTER TABLE `nilai`
  ADD PRIMARY KEY (`idNilai`),
  ADD KEY `id_mengajar` (`id_mengajar`,`nilaiMutu`),
  ADD KEY `nim` (`nim`),
  ADD KEY `nilaiMutu` (`nilaiMutu`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`,`password`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dosen_mengajar`
--
ALTER TABLE `dosen_mengajar`
  MODIFY `id_mengajar` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `nilai`
--
ALTER TABLE `nilai`
  MODIFY `idNilai` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dosen_mengajar`
--
ALTER TABLE `dosen_mengajar`
  ADD CONSTRAINT `dosen_mengajar_ibfk_1` FOREIGN KEY (`kdMatkul`) REFERENCES `matakuliah` (`kdMatkul`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `dosen_mengajar_ibfk_2` FOREIGN KEY (`nid`) REFERENCES `dosen` (`nid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `nilai`
--
ALTER TABLE `nilai`
  ADD CONSTRAINT `nilai_ibfk_1` FOREIGN KEY (`id_mengajar`) REFERENCES `dosen_mengajar` (`id_mengajar`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `nilai_ibfk_2` FOREIGN KEY (`nim`) REFERENCES `mahasiswa` (`nim`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `nilai_ibfk_3` FOREIGN KEY (`nilaiMutu`) REFERENCES `bobot` (`nilaiMutu`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

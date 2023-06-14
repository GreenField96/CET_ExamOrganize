-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 13, 2023 at 09:36 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `organize_exam_test`
--

-- --------------------------------------------------------

--
-- Table structure for table `answer_paper_movement`
--

CREATE TABLE `answer_paper_movement` (
  `id` int(11) NOT NULL,
  `committe_id` int(11) NOT NULL,
  `he_had_id` int(11) NOT NULL,
  `he_have_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `number_papers_received` int(11) NOT NULL,
  `specification` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `group` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `answer_paper_movement`
--

-- --------------------------------------------------------

--
-- Table structure for table `committe`
--

CREATE TABLE `committe` (
  `id` int(11) NOT NULL,
  `class` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `course` int(30) NOT NULL,
  `number_answer_paper` varchar(30) NOT NULL,
  `periodExam` varchar(20) NOT NULL DEFAULT '09:00-11:00',
  `year` varchar(10) NOT NULL DEFAULT '2023',
  `semester_period` varchar(20) NOT NULL DEFAULT 'ربيعي'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `committe`
--

-- --------------------------------------------------------

--
-- Table structure for table `course_name`
--

CREATE TABLE `course_name` (
  `id` int(11) NOT NULL,
  `courseName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `courseNumber` varchar(30) NOT NULL,
  `course_a` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `course_name`
--

INSERT INTO `course_name` (`id`, `courseName`, `courseNumber`) VALUES
(2, 'قواعد بيانات (تحليل و تصميم)', 'CS322'),
(3, 'الجبر الخطي', 'GS202'),
(6, 'تراكيب البيانات', 'CS315'),
(7, 'بروتوكولات التوجيه', 'CN302'),
(8, 'انجليزي 1', 'GS121'),
(9, 'رياضة 1', 'GS101'),
(10, 'دوائر كهربائية 1', 'EE101'),
(11, 'الكترونية 1', 'EE111'),
(12, 'دوائر رقمية 1', 'EE121'),
(13, 'فيزياء', 'GS111'),
(14, 'انجليزي 2', 'GS122'),
(15, 'رياضة 2', 'GS102'),
(16, 'دوائر كهربائية 2', 'EE102'),
(17, 'دوائر رقمية 2', 'EE122'),
(18, 'اساسيات البرمجة', 'CS111'),
(19, 'دوائر كهربائية معمل', 'EE102L'),
(20, 'دوائر رقمية معمل', 'EE122L'),
(21, 'انجليزي 3', 'GS223' ),
(22, 'معادلات تفاضلية', 'GS203'),
(23, 'الاحصاء والاحتمالات', 'GS204'),
(24, 'معمارية الحاسب', 'CE325'),
(25, 'اساسيات الشبكات', 'CN201'),
(26, 'مهارات دراسية', 'GS251'),
(27, 'البرمجة بلغة السي ++', 'CS212'),
(28, 'كتابة تقارير فنية', 'GS252'),
(29, 'انظمة حاسب دقيقة', 'CE224'),
(30, 'اساسيات البرمجة الهدفية', 'CS213'),
(31, 'تحليل وتصميم النظم', 'CS221'),
(32, 'هندسة البرمجيات', 'CS325'),
(33, 'تطبيقات البرمجة الهدفية', 'CS314'),
(34, 'امن الحاسب والمعلومات', 'CS326' ),
(35, 'اساسيات البرمجة مرئية', 'CS316'),
(36, 'برمجة مرئية متقدمة', 'CS417'),
(37, 'تطبيقات قواعد بيانات', 'CS323'),
(38, 'الشبكات المحلية والاسلكية', 'CN303'),
(39, 'تصميم صفحات الويب', 'CS331'),
(42, 'أختبار البرمجيات', 'CS427'),
(43, 'الشبكات الواسعة النطاق', 'CN404'),
(44, 'برمجة صفحات الويب', 'CS432'),
(45, 'ادراة قواعد بيانات', 'CS424'),
(46, 'صيانة انظمة حاسبات', 'CE223'),
(49, 'الجبر الخطي', 'GS202');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `work_as` enum('doctor','employee','موظف','دكتور') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(25) NOT NULL DEFAULT '99',
  `permisson` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`id`, `name`, `phone_number`, `work_as`, `email`, `password`, `permisson`) VALUES
(1, 'مندر الجبالي', '0928515299', 'موظف', 'munderjb', '25102510', 1);

-- --------------------------------------------------------

--
-- Table structure for table `monitor_committe`
--

CREATE TABLE `monitor_committe` (
  `id` int(11) NOT NULL,
  `personal_info_id` int(11) NOT NULL,
  `committe_id` int(11) NOT NULL,
  `absence` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `monitor_committe`
--

-- --------------------------------------------------------

--
-- Table structure for table `student_absence`
--

CREATE TABLE `student_absence` (
  `id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `phone_number` varchar(30) DEFAULT NULL,
  `specification` varchar(30) NOT NULL,
  `group_number` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `committe_id` int(11) NOT NULL,
  `note` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_absence`
--


--
-- Indexes for dumped tables
--

--
-- Indexes for table `answer_paper_movement`
--
ALTER TABLE `answer_paper_movement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `committe_id` (`committe_id`),
  ADD KEY `recent_id` (`he_had_id`),
  ADD KEY `he_have_id` (`he_have_id`);

--
-- Indexes for table `committe`
--
ALTER TABLE `committe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `course` (`course`);

--
-- Indexes for table `course_name`
--
ALTER TABLE `course_name`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `monitor_committe`
--
ALTER TABLE `monitor_committe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `committe_id` (`committe_id`),
  ADD KEY `personal_info_id` (`personal_info_id`);

--
-- Indexes for table `student_absence`
--
ALTER TABLE `student_absence`
  ADD PRIMARY KEY (`id`),
  ADD KEY `committe_id` (`committe_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `answer_paper_movement`
--
ALTER TABLE `answer_paper_movement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=130;

--
-- AUTO_INCREMENT for table `committe`
--
ALTER TABLE `committe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1046;

--
-- AUTO_INCREMENT for table `course_name`
--
ALTER TABLE `course_name`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=94;

--
-- AUTO_INCREMENT for table `monitor_committe`
--
ALTER TABLE `monitor_committe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=124;

--
-- AUTO_INCREMENT for table `student_absence`
--
ALTER TABLE `student_absence`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=186;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `answer_paper_movement`
--
ALTER TABLE `answer_paper_movement`
  ADD CONSTRAINT `answer_paper_movement_ibfk_1` FOREIGN KEY (`committe_id`) REFERENCES `committe` (`id`),
  ADD CONSTRAINT `answer_paper_movement_ibfk_2` FOREIGN KEY (`he_had_id`) REFERENCES `employees` (`id`),
  ADD CONSTRAINT `answer_paper_movement_ibfk_3` FOREIGN KEY (`he_have_id`) REFERENCES `employees` (`id`);

--
-- Constraints for table `committe`
--
ALTER TABLE `committe`
  ADD CONSTRAINT `committe_ibfk_1` FOREIGN KEY (`course`) REFERENCES `course_name` (`id`);

--
-- Constraints for table `monitor_committe`
--
ALTER TABLE `monitor_committe`
  ADD CONSTRAINT `monitor_committe_ibfk_1` FOREIGN KEY (`committe_id`) REFERENCES `committe` (`id`),
  ADD CONSTRAINT `monitor_committe_ibfk_2` FOREIGN KEY (`personal_info_id`) REFERENCES `employees` (`id`);

--
-- Constraints for table `student_absence`
--
ALTER TABLE `student_absence`
  ADD CONSTRAINT `student_absence_ibfk_1` FOREIGN KEY (`committe_id`) REFERENCES `committe` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

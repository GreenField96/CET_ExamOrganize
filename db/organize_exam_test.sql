-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 10, 2023 at 01:21 PM
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

INSERT INTO `answer_paper_movement` (`id`, `committe_id`, `he_had_id`, `he_have_id`, `date`, `number_papers_received`, `specification`, `group`) VALUES
(70, 1034, 16, 2, '2023-06-08', 23, 'حاسب ألي', 'الاولى'),
(71, 1034, 16, 2, '2023-06-08', 22, 'تحكم ألي', 'الاولى'),
(72, 1034, 2, 10, '2023-06-08', 23, 'حاسب ألي', 'الاولى'),
(74, 1035, 15, 2, '2023-06-09', 12, 'عام', 'الاولى'),
(75, 1034, 2, 21, '2023-06-09', 22, 'تحكم ألي', 'الاولى'),
(78, 1034, 10, 2, '2023-06-09', 23, 'حاسب ألي', 'الاولى'),
(79, 1034, 21, 2, '2023-06-09', 22, 'تحكم ألي', 'الاولى'),
(80, 1035, 2, 3, '2023-06-09', 12, 'عام', 'الاولى'),
(81, 1035, 3, 2, '2023-06-09', 12, 'عام', 'الاولى'),
(82, 1036, 20, 2, '2023-06-09', 25, 'عام', 'الاولى'),
(83, 1036, 20, 2, '2023-06-09', 24, 'تمهيدي', 'الاولى'),
(84, 1036, 2, 22, '2023-06-09', 25, 'عام', 'الاولى'),
(85, 1036, 2, 34, '2023-06-09', 24, 'تمهيدي', 'الاولى'),
(86, 1036, 22, 2, '2023-06-09', 25, 'عام', 'الاولى'),
(87, 1036, 34, 2, '2023-06-09', 24, 'تمهيدي', 'الاولى'),
(88, 1036, 2, 34, '2023-06-09', 24, 'تمهيدي', 'الاولى'),
(89, 1035, 2, 12, '2023-06-09', 12, 'عام', 'الاولى'),
(90, 1035, 12, 2, '2023-06-09', 12, 'عام', 'الاولى'),
(91, 1037, 14, 2, '2023-06-10', 30, 'تمهيدي', 'الحادية عشرة'),
(92, 1038, 26, 2, '2023-06-10', 20, 'تمهيدي', 'الحادية عشرة'),
(93, 1038, 2, 20, '2023-06-10', 20, 'تمهيدي', 'الحادية عشرة'),
(94, 1037, 2, 20, '2023-06-10', 30, 'تمهيدي', 'الحادية عشرة'),
(95, 1037, 20, 2, '2023-06-10', 30, 'تمهيدي', 'الحادية عشرة'),
(96, 1038, 20, 2, '2023-06-10', 20, 'تمهيدي', 'الحادية عشرة'),
(97, 1038, 2, 3, '2023-06-10', 20, 'تمهيدي', 'الحادية عشرة');

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

INSERT INTO `committe` (`id`, `class`, `date`, `course`, `number_answer_paper`, `periodExam`, `year`, `semester_period`) VALUES
(1034, '220', '2023-06-08', 25, '45', '09:00-11:00', '2023', 'ربيعي'),
(1035, 'E1', '2023-06-09', 13, '12', '09:00-11:00', '2023', 'ربيعي'),
(1036, '323', '2023-06-09', 11, '49', '09:00-11:00', '2023', 'ربيعي'),
(1037, '224', '2023-06-10', 9, '30', '09:00-11:00', '2023', 'ربيعي'),
(1038, '220', '2023-06-10', 9, '20', '09:00-11:00', '2023', 'ربيعي');

-- --------------------------------------------------------

--
-- Table structure for table `course_name`
--

CREATE TABLE `course_name` (
  `id` int(11) NOT NULL,
  `courseName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `courseNumber` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `course_name`
--

INSERT INTO `course_name` (`id`, `courseName`, `courseNumber`) VALUES
(0, 'قواعد بيانات (تحليل و تصميم)', 'CS322'),
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
(21, 'انجليزي 3', 'GS223'),
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
(34, 'امن الحاسب والمعلومات', 'CS326'),
(35, 'اساسيات البرمجة مرئية', 'CS316'),
(36, 'برمجة مرئية متقدمة', 'CS417'),
(37, 'تطبيقات قواعد بيانات', 'CS323'),
(38, 'الشبكات المحلية والاسلكية', 'CN303'),
(39, 'تصميم صفحات الويب', 'CS331'),
(42, 'أختبار البرمجيات', 'CS427'),
(43, 'الشبكات الواسعة النطاق', 'CN404'),
(44, 'برمجة صفحات الويب', 'CS432'),
(45, 'ادراة قواعد بيانات', 'CS424'),
(46, 'صيانة انظمة حاسبات', 'CE223');

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
(2, 'مندر الجبالي', '0928515299', 'دكتور', 'munderjb', '25102510', 1),
(3, 'محمد فرارة', '0921112222', 'دكتور', 'mohamed99', 'mohamedFurara99&$#', 0),
(10, 'محمد بوكر', '0921122334', 'دكتور', 'pokr@gmail.com', '99', 0),
(12, 'علي حسين', '0912224442', 'دكتور', 'ali@gmail.com', '99', 0),
(14, 'مصطفى قاباج', '0924403212', 'دكتور', 'gabaj@gmail.com', '99', 0),
(15, 'ناصر التليسي', '0928922123', 'دكتور', 'nasir@gmail.com', '99', 0),
(16, 'حاتم المهني', '0921234562', 'موظف', '', '99', 0),
(17, 'مندر المبروك مفتاح الجبالي', '0918637521', 'موظف', ' munderjbaly77@gmail.com', '99', 0),
(18, 'عبد العزيز التابت', '0926776122', 'دكتور', 'abdElaziz@gmail.com', '99', 0),
(19, 'فتحي مختار', '0927212012', 'دكتور', 'fathi@gmail.com', '99', 0),
(20, 'ناجي عبدالله', '0916336722', 'دكتور', '', '99', 0),
(21, 'محمد الجعفري', '0913663092', 'دكتور', 'mohamed@gmail.com', '99', 0),
(22, 'فوزي زريقان', '0921155117', 'دكتور', 'fozi@yahoo.com', '99', 0),
(23, 'امال النوري', '', 'دكتور', 'amal@gmail.com', '99', 0),
(24, 'حسني علي', '0924554122', 'موظف', '', '99', 0),
(25, 'خالد عتيق', '0917558131', 'موظف', '', '99', 0),
(26, 'سميح العماري', '0921221343', 'دكتور', 'samih@yahoo.com', '99', 0),
(27, 'مروان مرغم', '0928558747', 'دكتور', 'marwan@gmail.com', '99', 0),
(28, 'احمد حلمي', '0924554002', 'موظف', 'ahmed@yahoo.com', '99', 0),
(29, 'عبد الباسط عاشور', '0921441210', 'دكتور', '', '99', 0),
(30, 'رولا اسماعيل', '0912332120', 'دكتور', '', '99', 0),
(31, 'أشرف خشخوشة', '0921122232', 'دكتور', 'Ashraf@gmail.com', '99', 0),
(34, 'احمد هشيك', '0913231111', 'موظف', '', '99', 0);

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

INSERT INTO `monitor_committe` (`id`, `personal_info_id`, `committe_id`, `absence`) VALUES
(99, 15, 1034, 1),
(100, 16, 1034, 1),
(101, 19, 1034, 1),
(102, 20, 1034, 1),
(103, 14, 1035, 1),
(104, 15, 1035, 1),
(105, 16, 1035, 1),
(106, 15, 1036, 1),
(107, 17, 1036, 0),
(108, 19, 1036, 1),
(109, 20, 1036, 1),
(110, 15, 1037, 1),
(111, 14, 1037, 1),
(112, 25, 1038, 1),
(113, 26, 1038, 1);

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

INSERT INTO `student_absence` (`id`, `student_id`, `name`, `phone_number`, `specification`, `group_number`, `committe_id`, `note`) VALUES
(175, 171455, 'مهند المبروك', '', 'حاسب ألي', 'الاولى', 1034, ''),
(176, 191411, 'علي محمد', '', 'تحكم ألي', 'الاولى', 1034, ''),
(177, 151441, 'محمد محمد', '', 'عام', 'الاولى', 1035, ''),
(178, 190322, 'محمد سالم', '', 'عام', 'الاولى', 1036, ''),
(179, 200123, 'محمد علي', '', 'تمهيدي', 'الاولى', 1036, ''),
(180, 190111, 'حسام محمد', '', 'عام', 'الاولى', 1036, ''),
(181, 220123, 'ناصر محمد', '', 'تمهيدي', 'الحادية عشرة', 1037, ''),
(182, 202121, 'مصطفى الطاهر', '', 'تمهيدي', 'الحادية عشرة', 1038, '');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=98;

--
-- AUTO_INCREMENT for table `committe`
--
ALTER TABLE `committe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1039;

--
-- AUTO_INCREMENT for table `course_name`
--
ALTER TABLE `course_name`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT for table `monitor_committe`
--
ALTER TABLE `monitor_committe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=114;

--
-- AUTO_INCREMENT for table `student_absence`
--
ALTER TABLE `student_absence`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=183;

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

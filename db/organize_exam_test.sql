-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 26, 2023 at 11:33 AM
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
  `recent_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `number_papers_received` int(11) NOT NULL,
  `group` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `answer_paper_movement`
--

INSERT INTO `answer_paper_movement` (`id`, `committe_id`, `recent_id`, `date`, `number_papers_received`, `group`) VALUES
(1, 50, 21, '2023-04-24', 20, 'الاولى'),
(2, 7, 12, '2023-04-25', 10, 'الرابعة'),
(3, 7, 19, '2023-04-25', 10, 'الخامسة'),
(4, 50, 10, '2023-04-24', 25, 'التامنة'),
(9, 5, 2, '2023-04-30', 20, 'الاولى'),
(10, 2, 15, '2023-04-30', 20, 'الاولى'),
(11, 2, 15, '2023-04-30', 20, 'الاولى'),
(12, 1009, 31, '2023-05-01', 16, 'الاولى'),
(13, 1009, 31, '2023-05-01', 14, 'التانية'),
(14, 30, 22, '2023-05-01', 20, 'الرابعة'),
(15, 30, 22, '2023-05-01', 25, 'الخامسة'),
(16, 7, 21, '2023-05-01', 23, 'الاولى'),
(17, 7, 21, '2023-05-01', 21, 'التانية'),
(25, 1005, 29, '2023-05-01', 17, 'الاولى'),
(26, 1005, 20, '2023-05-01', 16, 'التانية'),
(28, 1010, 3, '2023-05-03', 20, 'الاولى'),
(29, 1, 3, '2023-05-14', 20, 'الاولى'),
(30, 1, 3, '2023-05-14', 20, 'التانية'),
(31, 9, 2, '2023-05-14', 25, 'الاولى'),
(32, 9, 2, '2023-05-14', 20, 'التانية'),
(33, 1012, 15, '2023-05-14', 34, 'الاولى'),
(34, 1, 30, '2023-05-25', 40, 'الاولى');

-- --------------------------------------------------------

--
-- Table structure for table `committe`
--

CREATE TABLE `committe` (
  `id` int(11) NOT NULL,
  `class` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `course` int(30) NOT NULL,
  `semester` varchar(30) NOT NULL,
  `specification` varchar(30) NOT NULL,
  `number_answer_paper` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `committe`
--

INSERT INTO `committe` (`id`, `class`, `date`, `course`, `semester`, `specification`, `number_answer_paper`) VALUES
(1, '215', '2023-04-21', 3, 'الخامس', 'حاسب ألي', '40'),
(2, '315', '2023-04-04', 0, 'تمهيدي', 'عام', '34'),
(3, 'المسرح', '2023-04-20', 0, 'الأول', 'عام', '22'),
(4, '110', '2023-04-06', 6, 'تمهيدي', 'عام', '18'),
(5, '110', '2023-04-20', 0, 'التاني', 'عام', '20'),
(6, '222', '2023-04-05', 0, 'التاني', 'عام', '27'),
(7, '120', '2023-04-12', 0, 'الرابع', 'حاسب ألي', '20'),
(8, '215', '2023-04-06', 0, 'الرابع', 'حاسب ألي', '50'),
(9, '217', '2023-04-14', 0, 'التالت', 'حاسب ألي', '45'),
(13, '330', '2023-04-22', 0, 'الأول', 'عام', '42'),
(14, '212', '2023-04-29', 0, 'الخامس', 'حاسب ألي', '22'),
(15, '315', '2023-04-20', 0, 'السادس', 'حاسب ألي', '33'),
(16, '216', '2023-04-12', 0, 'التالت', 'اتصالات', '24'),
(17, '233', '2023-04-12', 0, 'التالت', 'تحكم ألي', '24'),
(30, '215', '2023-04-06', 0, 'الأول', 'عام', '45'),
(31, '112', '2023-04-06', 0, 'الخامس', 'حاسب ألي', '45'),
(50, '120', '2023-04-06', 0, 'الأول', 'عام', '45'),
(51, '212', '2023-04-06', 0, 'الرابع', 'تحكم ألي', '36'),
(52, 'المسرح', '2023-04-24', 0, 'السابع', 'حاسب ألي', '44'),
(1001, '318', '2023-04-25', 0, 'الخامس', 'اتصالات', '45'),
(1002, '312', '2023-04-20', 0, 'التاني', 'عام', '45'),
(1003, '215', '2023-04-27', 0, 'الأول', 'عام', '40'),
(1004, '112', '2023-04-28', 0, 'الخامس', 'حاسب ألي', '12'),
(1005, '220', '2023-04-28', 0, 'الرابع', 'اتصالات', '33'),
(1006, '312', '2023-04-29', 0, 'التالت', 'اتصالات', '46'),
(1007, '215', '2023-04-29', 0, 'الرابع', 'تحكم ألي', '47'),
(1008, '215', '2023-04-29', 0, 'الرابع', 'حاسب ألي', '16'),
(1009, 'معمل شبكات 1', '2023-05-01', 0, 'التالت', 'حاسب ألي', '40'),
(1010, '212', '2023-05-03', 0, 'الرابع', 'حاسب ألي', '20'),
(1011, 'مسرح', '2023-05-07', 0, 'الخامس', 'حاسب ألي', '90'),
(1012, '315', '2023-05-14', 0, 'السادس', 'حاسب ألي', '34'),
(1013, '', '2023-05-18', 0, 'الرابع', 'حاسب ألي', ''),
(1014, '314', '2023-05-25', 0, 'الخامس', 'حاسب ألي', '23'),
(1015, 'مسرح', '2023-05-25', 9, 'تمهيدي', 'عام', '45'),
(1016, '220', '2023-05-25', 12, 'الأول', 'عام', '18');

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
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`id`, `name`, `phone_number`, `work_as`, `email`) VALUES
(2, 'مندر الجبالي', '0928515299', 'دكتور', 'munderjb@gmail.com'),
(3, 'محمد فرارة', '0921112222', 'موظف', 'mohamed@gmail.com'),
(10, 'محمد بوكر', '0921122334', 'دكتور', 'pokr@gmail.com'),
(12, 'علي حسين', '0912224442', 'دكتور', 'ali@gmail.com'),
(14, 'مصطفى قاباج', '0924403212', 'دكتور', 'gabaj@gmail.com'),
(15, 'ناصر التليسي', '0928922123', 'دكتور', 'nasir@gmail.com'),
(16, 'حاتم المهني', '0921234562', 'موظف', ''),
(17, 'مندر المبروك مفتاح الجبالي', '0918637521', 'موظف', ' munderjbaly77@gmail.com'),
(18, 'عبد العزيز التابت', '0926776122', 'دكتور', 'abdElaziz@gmail.com'),
(19, 'فتحي مختار', '0927212012', 'دكتور', 'fathi@gmail.com'),
(20, 'ناجي عبدالله', '0916336722', 'دكتور', ''),
(21, 'محمد الجعفري', '0913663092', 'دكتور', 'mohamed@gmail.com'),
(22, 'فوزي زريقان', '0921155117', 'دكتور', 'fozi@yahoo.com'),
(23, 'امال النوري', '', 'دكتور', 'amal@gmail.com'),
(24, 'حسني علي', '0924554122', 'موظف', ''),
(25, 'خالد عتيق', '0917558131', 'موظف', ''),
(26, 'سميح العماري', '0921221343', 'دكتور', 'samih@yahoo.com'),
(27, 'مروان مرغم', '0928558747', 'دكتور', 'marwan@gmail.com'),
(28, 'احمد حلمي', '0924554002', 'موظف', 'ahmed@yahoo.com'),
(29, 'عبد الباسط عاشور', '0921441210', 'دكتور', ''),
(30, 'رولا اسماعيل', '0912332120', 'دكتور', ''),
(31, 'أشرف خشخوشة', '0921122232', 'دكتور', 'Ashraf@gmail.com'),
(32, 'محمد نوري غنائم', '0945829268', 'دكتور', ''),
(34, 'احمد هشيك', '0913231111', 'موظف', '');

-- --------------------------------------------------------

--
-- Table structure for table `monitor_committe`
--

CREATE TABLE `monitor_committe` (
  `id` int(11) NOT NULL,
  `personal_info_id` int(11) NOT NULL,
  `committe_id` int(11) NOT NULL,
  `absence` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `monitor_committe`
--

INSERT INTO `monitor_committe` (`id`, `personal_info_id`, `committe_id`, `absence`) VALUES
(1, 10, 1, 0),
(2, 19, 14, 0),
(3, 10, 14, 0),
(4, 18, 14, 0),
(5, 10, 15, 0),
(6, 21, 15, 0),
(7, 3, 16, 0),
(8, 10, 16, 0),
(9, 12, 16, 0),
(10, 16, 17, 0),
(11, 17, 17, 0),
(16, 3, 30, 0),
(17, 2, 30, 0),
(18, 10, 30, 0),
(19, 15, 31, 0),
(20, 21, 31, 0),
(23, 10, 50, 0),
(24, 12, 50, 0),
(25, 14, 50, 0),
(26, 20, 51, 0),
(27, 20, 51, 0),
(28, 15, 51, 0),
(29, 2, 52, 0),
(30, 3, 52, 0),
(31, 14, 52, 0),
(32, 15, 52, 0),
(33, 19, 52, 0),
(34, 18, 52, 0),
(35, 21, 52, 0),
(36, 14, 1001, 0),
(37, 21, 1001, 0),
(38, 21, 1001, 0),
(39, 10, 1001, 0),
(40, 23, 1002, 0),
(41, 12, 1002, 0),
(42, 14, 1003, 0),
(43, 12, 1003, 0),
(44, 15, 1003, 0),
(45, 12, 1004, 0),
(46, 10, 1004, 0),
(47, 14, 1004, 0),
(48, 3, 1005, 0),
(49, 2, 1005, 0),
(50, 20, 1005, 0),
(51, 21, 1005, 0),
(52, 18, 1006, 0),
(53, 29, 1006, 0),
(54, 19, 1007, 0),
(55, 18, 1007, 0),
(56, 20, 1007, 0),
(57, 30, 1008, 0),
(58, 14, 1008, 0);

-- --------------------------------------------------------

--
-- Table structure for table `student_absence`
--

CREATE TABLE `student_absence` (
  `id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `phone_number` varchar(30) DEFAULT NULL,
  `group_number` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `committe_id` int(11) NOT NULL,
  `note` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_absence`
--

INSERT INTO `student_absence` (`id`, `student_id`, `name`, `phone_number`, `group_number`, `committe_id`, `note`) VALUES
(1, 192123, 'مندر المبروك مفتاح الجبالي', '0928515299', 'الرابعة', 1, 'لايوجد '),
(2, 200100, 'مهند الاسطى', '', '', 3, ''),
(3, 200123, 'عبدالله', '0926264321', '', 3, ''),
(4, 200124, 'خالد العكشي', '', '', 4, 'قام بالامتحان مسبقا'),
(5, 200432, 'غراب سبيعة', '0917771111', '', 4, ''),
(6, 200322, 'جمعة المقرحي', '', '', 4, 'لديه مسابقة كمال أجسام'),
(8, 190123, 'عبد الرزاق', '', '', 5, ''),
(10, 122003, 'محمد المسلاتي', '0928445658', '', 6, ''),
(11, 192120, 'معاد ناصر', '0928168712', '', 7, ''),
(12, 192220, 'سالم عموش', '0921234211', '', 7, ''),
(13, 192190, 'هبة الخويلدي', '0927861234', '', 8, ''),
(14, 192290, 'معتز محمد', '', '', 8, ''),
(15, 192123, 'مندر على', '0929793434', '', 9, ''),
(19, 192118, 'هبة القانقا', '', '', 13, ''),
(20, 220121, 'سالم الروامي', '0927862123', '', 14, ''),
(21, 190123, 'فوزي المزداوي', '', '', 15, ''),
(22, 191001, 'خديجة التارقي', '', '', 15, ''),
(23, 192213, 'حفيظ التومي', '', '', 16, ''),
(24, 192001, 'عبير التميمي', '', '', 16, ''),
(36, 144100, 'عبادة الترهوني', '', '', 30, ''),
(45, 155100, 'حسني', '', '', 31, ''),
(95, 192123, 'مندر الجبالي', '', '', 50, ''),
(96, 192120, 'معاد ناصر', '0926556788', '', 50, ''),
(97, 141001, 'علي شارف', '', '', 51, ''),
(98, 200100, 'شارف علي', '', '', 51, ''),
(99, 181100, 'جمال القرقني', '', '', 52, ''),
(100, 181232, 'غانم الساعدي', '', '', 52, ''),
(101, 181009, 'محمود عاصم', '', '', 52, ''),
(102, 181020, 'سوزان محمود', '', '', 52, ''),
(103, 181022, 'عبد السلام البصير', '0928778990', 'التانية', 1001, ''),
(104, 181132, 'محمود سالم', '0917728121', 'التالتة', 1001, ''),
(105, 191112, 'علي المسلاتي', '0945565110', 'التالتة', 1002, ''),
(106, 192123, 'مندر الجبالي', '', 'الرابعة', 1003, ''),
(107, 181122, 'علي ', '', 'الرابعة', 1003, ''),
(108, 181002, 'عبدالله عمر', '', 'الاولى', 1004, ''),
(109, 181102, 'خديجة محمد', '', 'التانية', 1004, ''),
(110, 192455, 'حاتم علي', '', 'الاولى', 1005, ''),
(111, 191255, 'علي سامي', '', 'الاولى', 1005, ''),
(112, 181002, 'فرح عمر', '', 'الاولى', 1006, ''),
(113, 191021, 'عمر ناجي', '', 'التانية', 1006, ''),
(114, 181554, 'سامي فوزي', '0928112112', 'الاولى', 1007, '.'),
(115, 190211, 'حامد كريم', '0911221333', 'الاولى', 1007, ''),
(116, 191224, 'عبد الباسط', '', 'الاولى', 1008, ''),
(117, 192012, 'سراج فوزي', '', 'التانية', 1008, ''),
(118, 191254, 'أحمد محمد', '', 'الاولى', 1009, ''),
(119, 190123, 'علي محمد', '', 'التانية', 1009, ''),
(120, 192123, '', '', 'الاولى', 1010, ''),
(121, 192123, '', '', 'الاولى', 1011, ''),
(122, 181001, 'العبسي', '', 'الاولى', 1011, ''),
(123, 192141, 'عادل حمد', '', 'الاولى', 1012, ''),
(124, 171211, 'سالم محمد', '', 'الاولى', 1012, ''),
(125, 192172, 'معاد مشيرم', '', 'السادسة', 1013, ''),
(126, 192123, 'مندر الجبالي', '', 'التانية', 1014, ''),
(127, 181200, 'قاسم سالم', '', 'التانية', 1014, ''),
(128, 220123, '', '', 'الاولى', 1015, ''),
(129, 221090, '', '', 'التانية', 1015, ''),
(130, 220121, '', '', 'الاولى', 1016, '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `answer_paper_movement`
--
ALTER TABLE `answer_paper_movement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `committe_id` (`committe_id`),
  ADD KEY `recent_id` (`recent_id`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `committe`
--
ALTER TABLE `committe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1017;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- AUTO_INCREMENT for table `student_absence`
--
ALTER TABLE `student_absence`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=131;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `answer_paper_movement`
--
ALTER TABLE `answer_paper_movement`
  ADD CONSTRAINT `answer_paper_movement_ibfk_1` FOREIGN KEY (`committe_id`) REFERENCES `committe` (`id`),
  ADD CONSTRAINT `answer_paper_movement_ibfk_2` FOREIGN KEY (`recent_id`) REFERENCES `employees` (`id`);

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

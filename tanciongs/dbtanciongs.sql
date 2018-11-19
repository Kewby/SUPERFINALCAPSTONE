-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 12, 2018 at 12:44 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbtanciongs`
--

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE `branch` (
  `branch_id` int(11) NOT NULL,
  `branch_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`branch_id`, `branch_name`) VALUES
(1, 'Cebu Branch'),
(2, 'Leyte Branch');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(50) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`category_id`, `category_name`, `description`) VALUES
(1, 'Beverages', 'Beverages'),
(2, 'Dry Goods', 'Dry Goods'),
(3, 'Condiments', 'Condiments'),
(4, 'Toiletries', 'Toiletries'),
(5, 'Canned Goods', 'Canned Goods'),
(6, 'Snacks', 'Snacks');

-- --------------------------------------------------------

--
-- Table structure for table `delivery`
--

CREATE TABLE `delivery` (
  `delivery_id` int(11) NOT NULL,
  `delivery_datetime` datetime DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `delivery_unitprice` float(255,2) DEFAULT NULL,
  `delivery_numberofunits` int(11) DEFAULT NULL,
  `delivery_unitofmeasure` varchar(255) DEFAULT NULL,
  `delivery_totalcostamount` float(255,2) AS (delivery_unitprice * delivery_numberofunits) VIRTUAL,
  `supplier_id` int(11) DEFAULT NULL,
  `branch_id` int(11) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `deleteStatus` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `delivery`
--

INSERT INTO `delivery` (`delivery_id`, `delivery_datetime`, `product_id`, `delivery_unitprice`, `delivery_numberofunits`, `delivery_unitofmeasure`, `supplier_id`, `branch_id`, `employee_id`, `deleteStatus`) VALUES
(1, '2018-11-12 16:50:38', 134, 15.00, 10, 'pcs', 1, 1, 33, 0);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL,
  `employee_firstname` varchar(255) DEFAULT NULL,
  `employee_lastname` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `employee_email` varchar(255) DEFAULT NULL,
  `employee_contactnumber` varchar(15) DEFAULT NULL,
  `employee_address` varchar(255) DEFAULT NULL,
  `branch_id` int(11) DEFAULT NULL,
  `isAdmin` tinyint(4) DEFAULT NULL,
  `deleteStatus` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employee_id`, `employee_firstname`, `employee_lastname`, `username`, `password`, `employee_email`, `employee_contactnumber`, `employee_address`, `branch_id`, `isAdmin`, `deleteStatus`) VALUES
(30, 'Admin', 'Cebu', 'admin_cebu', 'cebu', 'admincebu@gmail.com', '09123456789', 'Mabolo, Cebu City', 1, 1, 0),
(31, 'Admin', 'Leyte', 'admin_leyte', 'leyte', 'adminleyte@gmail.com', '09123456789', 'Tacloban, Leyte', 2, 1, 0),
(32, 'John Mari', 'Flores', 'john', '12345', 'john@gmail.com', '09123456789', 'Mabolo, Cebu City', 1, 0, 0),
(33, 'Genale', 'Tagalog', 'genale', '1234', 'genale@gmail.com', '09123456789', 'Canduman', 1, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL,
  `product_code` bigint(20) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_type` tinyint(1) DEFAULT NULL,
  `standard_cost` float(255,2) DEFAULT NULL,
  `markup_cost` varchar(5) NOT NULL,
  `list_price` float(255,2) AS (standard_cost + markup_cost) VIRTUAL,
  `branch_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `deleteStatus` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `product_code`, `product_name`, `product_type`, `standard_cost`, `markup_cost`, `branch_id`, `category_id`, `deleteStatus`) VALUES
(132, 4800049720121, '1000mL NATURES SPRING DRINKING WATER', 1, 15.00, '5.0', 1, 1, 0),
(133, 4807770270055, '60g PANCIT CANTON ORIGINAL', 0, 5.00, '2.0', 1, 6, 0),
(134, 4807770270024, '50g LUCKY ME CHICKEN', 0, 7.00, '2.0', 1, 6, 0),
(135, 4800110026497, '55g HO-MI INSTANT MAMI NOODLES', 0, 7.00, '2.0', 1, 6, 0),
(136, 4902430278119, '380G TIDE ULTRA ORIG SCENT', 0, 10.00, '5.0', 1, 4, 0),
(137, 4806502350096, '10G SANICARE COTTON ROLLS', 0, 8.00, '1.0', 1, 4, 0),
(138, 4902430698085, '12ML PANTENE SHAMPOO', 0, 35.00, '5.0', 1, 4, 0),
(139, 4902430698078, '16ML REJOICE FRAGRANT RICH SHAMPOO', 0, 35.00, '2.0', 1, 4, 0),
(140, 4902430522809, '12ML HEAD AND SHOULDERS MEN COOL BLAST SHAMPOO', 0, 4.00, '2.0', 1, 4, 0),
(141, 4902430951357, '60G SAFEGUARD FLORAL PINK WITH ALOE VERA', 0, 13.00, '3.0', 1, 4, 0),
(142, 4902430935999, '135G SAFEGUARD CLASSIC BEIGE', 0, 7.00, '1.0', 1, 4, 0),
(143, 4806507832481, '65G SILKA PAPAYA WHITENING SOAP', 0, 7.00, '1.0', 1, 4, 0),
(144, 4902430934800, '135G SAFEGUARD PURE WHITE', 0, 7.00, '1.0', 1, 4, 0),
(145, 4902430401845, '27ML DOWNY SUNRISE FRESH', 0, 30.00, '2.0', 1, 4, 0),
(146, 4902430583169, '70G ARIEL SUNRISE FRESH', 0, 7.00, '1.0', 1, 4, 0),
(147, 8850006342039, '24G COLGATE SENSITIVE FRESH MINT', 0, 45.00, '1.0', 1, 4, 0),
(148, 4902430453295, '25ML DOWNY GARDEN BLOOM', 0, 7.00, '1.0', 1, 4, 0),
(149, 4800888189806, '57G SURF WITH FABCON CHERRY BLOSSOM', 0, 8.00, '1.0', 1, 4, 0),
(150, 4902430389563, '45ML JOY LEMON DISHWASHING', 0, 5.00, '1.0', 1, 4, 0),
(151, 4800011133607, '95G EVERCLEAN WHITE LAUNDRY BAR', 0, 7.00, '1.0', 1, 4, 0),
(152, 4902430335065, '16PADS WHISPER COTTONY SOFT', 0, 5.00, '2.0', 1, 4, 0),
(153, 4800049720114, '500ML NATURES SPRING DRINIKING WATER', 0, 15.00, '2.0', 1, 1, 0),
(154, 4801981110001, '330ML COCA COLA CAN', 0, 13.00, '5.0', 1, 1, 0),
(155, 4806511012916, '70 GRAMS WL CORNBITS', 0, 5.00, '2.0', 1, 6, 1),
(156, 4806508621039, '155G SEÑORITA SARDINES RED', 0, 30.00, '2.0', 1, 5, 0),
(158, 4809011681378, '100G BOY BAWANG CORNICK GARLIC FLAVOR', 0, 5.00, '3.0', 2, 6, 0),
(159, 4807770121692, '10 PIECES VOICE CAFÉ MOCHA', 0, 20.00, '2.0', 2, 6, 0),
(160, 4806511012916, '70 GRAMS WL CORNBITS', 0, 5.00, '1.0', 2, 6, 0),
(161, 4800024020642, '227G DEL MONTE PINEAPPLE CHUNKS', 0, 45.00, '1.0', 2, 5, 0),
(162, 4800088146012, '150G AUSTRALIAN CARNE NORTE', 0, 55.00, '1.0', 2, 5, 0),
(163, 4800088135269, '150G WINNER BEEF LOAF', 0, 30.00, '1.0', 2, 5, 0),
(164, 748485100401, '155G CENTURY TUNA FLAKES AND OIL', 0, 16.00, '1.0', 2, 5, 0),
(165, 4800024562258, '7G DEL MONTE PINEAPPLE TIDBITS', 0, 55.00, '1.0', 2, 5, 0),
(166, 4800088270373, '150G VIRGINIA CORNED BEEF', 0, 13.00, '1.0', 2, 5, 0),
(167, 4800088135023, '150G WINNER MEAT LOAF', 0, 14.00, '2.0', 2, 5, 0),
(168, 4806508621039, '155G SEÑORITA SARDINES RED', 0, 34.00, '1.0', 2, 5, 0),
(169, 4800088115162, '165G VIRGINIA PORK AND BEANS', 0, 13.00, '2.0', 2, 5, 0),
(170, 4800024555489, '115G DEL MONTE TOMATO SAUCE', 0, 30.00, '1.0', 2, 3, 0),
(171, 4800024556929, '250G DEL MONTE TOMATO SAUCE ORIGINAL', 0, 45.00, '1.0', 2, 3, 0),
(172, 4800024575395, '90G DEL MONTE TOMATO SAUCE FILIPINO STYLE', 0, 30.00, '2.0', 2, 3, 0),
(173, 4800024555496, '200G DEL MONTE TOMATO SAUCE ORIGINAL', 0, 13.00, '2.0', 2, 3, 0),
(174, 4800344004940, '200ML SILVER SWAN SUKANG PUTI', 0, 13.00, '2.0', 2, 3, 0),
(175, 4801668602034, '200ML DATUPUTI SOY SAUCE', 0, 14.00, '2.0', 2, 3, 0),
(176, 4800194177085, '90G OISHI PRAWN CRACKERS', 0, 4.00, '2.0', 2, 6, 0),
(177, 4809011681378, '100G BOY BAWANG CORNICK GARLIC FLAVOR', 0, 4.00, '1.0', 2, 6, 0),
(178, 4800194179881, '90G OISHI CRACKLINGS PLAIN SALTED', 0, 7.00, '5.0', 2, 6, 0),
(179, 4806014000366, '565G JOLLY LYCHEES', 0, 35.00, '2.0', 2, 5, 0),
(180, 4800024020642, '227G DEL MONTE PINEAPPLE CHUNKS', 0, 50.00, '5.0', 2, 5, 0),
(181, 8850006325230, '22G TWINPACK COLGATE COOLING CRYSTALS', 0, 56.00, '1.0', 2, 4, 0),
(182, 74923408731, 'PIKNIK KETCHUP FRIES 130G', 0, 35.00, '5.0', 1, 6, 0);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` tinyint(4) NOT NULL,
  `role_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role_name`) VALUES
(0, 'Cashier'),
(1, 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `sales_id` int(11) NOT NULL,
  `sales_datetime` datetime DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `changefund` float(255,2) DEFAULT NULL,
  `total_sales` float(255,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`sales_id`, `sales_datetime`, `employee_id`, `changefund`, `total_sales`) VALUES
(2, '2018-11-12 19:06:57', 30, 1000.00, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `stock_id` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  `stock_onhand` int(11) DEFAULT NULL,
  `branch_id` int(11) DEFAULT NULL,
  `deleteStatus` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`stock_id`, `product_id`, `stock_onhand`, `branch_id`, `deleteStatus`) VALUES
(1, 134, 10, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `supplier_id` int(11) NOT NULL,
  `supplier_name` varchar(255) DEFAULT NULL,
  `supplier_address` varchar(255) DEFAULT NULL,
  `supplier_email` varchar(255) DEFAULT NULL,
  `supplier_contactnumber` varchar(255) DEFAULT NULL,
  `supplier_contactperson` varchar(255) DEFAULT NULL,
  `deleteStatus` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`supplier_id`, `supplier_name`, `supplier_address`, `supplier_email`, `supplier_contactnumber`, `supplier_contactperson`, `deleteStatus`) VALUES
(1, 'Malaya Goods', 'Nasipit, Talamban, Cebu City', 'malaya_goods@gmail.com', '09123456789', 'Mr. Jake Peralta', 0);

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `transaction_id` int(11) NOT NULL,
  `transaction_datetime` datetime DEFAULT NULL,
  `transaction_tender` float(255,2) DEFAULT NULL,
  `transaction_change` float(255,2) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `transaction_grandtotal` float(255,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transactionitem`
--

CREATE TABLE `transactionitem` (
  `transactionItem_id` int(11) NOT NULL,
  `transaction_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `transactionItem_qty` int(11) DEFAULT NULL,
  `transactionItem_unitprice` float(255,2) DEFAULT NULL,
  `transactionItem_subtotal` float(255,2) AS (transactionItem_qty * transactionItem_unitprice) VIRTUAL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`branch_id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `delivery`
--
ALTER TABLE `delivery`
  ADD PRIMARY KEY (`delivery_id`),
  ADD KEY `delivery_fk1` (`product_id`),
  ADD KEY `delivery_fk2` (`supplier_id`),
  ADD KEY `delivery_fk3` (`branch_id`),
  ADD KEY `delivery_fk4` (`employee_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employee_id`),
  ADD KEY `employee_fk1` (`branch_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `product_fk1` (`branch_id`),
  ADD KEY `product_fk2` (`category_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`sales_id`),
  ADD KEY `sales_fk1` (`employee_id`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`stock_id`),
  ADD KEY `stock_fk1` (`product_id`),
  ADD KEY `stock_fk2` (`branch_id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`supplier_id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`transaction_id`),
  ADD KEY `transaction_fk1` (`employee_id`);

--
-- Indexes for table `transactionitem`
--
ALTER TABLE `transactionitem`
  ADD PRIMARY KEY (`transactionItem_id`),
  ADD KEY `transactionItem_fk1` (`transaction_id`),
  ADD KEY `transactionItem_fk2` (`product_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `branch`
--
ALTER TABLE `branch`
  MODIFY `branch_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `delivery`
--
ALTER TABLE `delivery`
  MODIFY `delivery_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `employee_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=183;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `role_id` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `sales_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `stock`
--
ALTER TABLE `stock`
  MODIFY `stock_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `supplier_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `transaction_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `transactionitem`
--
ALTER TABLE `transactionitem`
  MODIFY `transactionItem_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `delivery`
--
ALTER TABLE `delivery`
  ADD CONSTRAINT `delivery_fk1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  ADD CONSTRAINT `delivery_fk2` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`),
  ADD CONSTRAINT `delivery_fk3` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`branch_id`),
  ADD CONSTRAINT `delivery_fk4` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_fk1` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`branch_id`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_fk1` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`branch_id`),
  ADD CONSTRAINT `product_fk2` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`);

--
-- Constraints for table `sales`
--
ALTER TABLE `sales`
  ADD CONSTRAINT `sales_fk1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`);

--
-- Constraints for table `stock`
--
ALTER TABLE `stock`
  ADD CONSTRAINT `stock_fk1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  ADD CONSTRAINT `stock_fk2` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`branch_id`);

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `transaction_fk1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`);

--
-- Constraints for table `transactionitem`
--
ALTER TABLE `transactionitem`
  ADD CONSTRAINT `transactionItem_fk1` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`),
  ADD CONSTRAINT `transactionItem_fk2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

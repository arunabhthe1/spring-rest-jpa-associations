SELECT * FROM my_project.address;CREATE TABLE `address` (
  `addressId` int NOT NULL AUTO_INCREMENT,
  `empid` int DEFAULT NULL,
  `lane` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `addresstype` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`addressId`)
) ENGINE=InnoDB AUTO_INCREMENT=10007 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `costcenter` (
  `COST_CENTER_ID` int NOT NULL AUTO_INCREMENT,
  `COST_CENTER_NAME` varchar(45) DEFAULT NULL,
  `COST` int DEFAULT NULL,
  PRIMARY KEY (`COST_CENTER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1008 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `customer` (
  `cust_id` int NOT NULL AUTO_INCREMENT,
  `cust_name` varchar(45) DEFAULT NULL,
  `cust_type` varchar(45) DEFAULT NULL,
  `address_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1012 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `customer_address` (
  `address_id` int NOT NULL AUTO_INCREMENT,
  `address_details` varchar(45) DEFAULT NULL,
  `pin` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `customer_trading_account_map` (
  `cust_id` int NOT NULL,
  `trading_id` int NOT NULL,
  PRIMARY KEY (`cust_id`,`trading_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `department` (
  `DEPARTMENT_ID` int NOT NULL AUTO_INCREMENT,
  `DEPARTMENT_NAME` varchar(45) DEFAULT NULL,
  `COST_CENTER_ID` int DEFAULT NULL,
  PRIMARY KEY (`DEPARTMENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `employee` (
  `empid` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `doj` datetime DEFAULT NULL,
  `salary` int DEFAULT NULL,
  PRIMARY KEY (`empid`)
) ENGINE=InnoDB AUTO_INCREMENT=1009 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `employee_department_map` (
  `EMPLOYEE_ID` int NOT NULL,
  `DEPARTMENT_ID` int NOT NULL,
  PRIMARY KEY (`EMPLOYEE_ID`,`DEPARTMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `project` (
  `id` bigint NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `dt_created` date DEFAULT NULL,
  `dt_updated` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `project_identifier` varchar(6) DEFAULT NULL,
  `project_name` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_PROJECT_IDENTIFER` (`project_identifier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `retail_bank_accout` (
  `cust_id` int NOT NULL AUTO_INCREMENT,
  `acc_no` varchar(45) DEFAULT NULL,
  `ifsc_code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `student` (
  `student_id` int NOT NULL AUTO_INCREMENT,
  `fullname` varchar(100) DEFAULT NULL,
  `age` int DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `trading_account` (
  `trading_id` int NOT NULL AUTO_INCREMENT,
  `trading_acc_type` varchar(45) DEFAULT NULL,
  `trading_account_no` int DEFAULT NULL,
  PRIMARY KEY (`trading_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10007 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

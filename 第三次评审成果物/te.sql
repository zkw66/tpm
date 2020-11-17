/*
SQLyog Professional v12.08 (64 bit)
MySQL - 5.5.27 : Database - te
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`te` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `te`;

/*Table structure for table `course_book` */

DROP TABLE IF EXISTS `course_book`;

CREATE TABLE `course_book` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `courseid` varchar(10) DEFAULT NULL COMMENT '课程编号',
  `types` varchar(10) DEFAULT NULL COMMENT '类型（指定教材/参考书目）',
  `author` varchar(50) DEFAULT NULL COMMENT '作者',
  `bookname` varchar(30) DEFAULT NULL COMMENT '书名',
  `press` varchar(20) DEFAULT NULL COMMENT '出版社',
  `presstime` varchar(10) DEFAULT NULL COMMENT '出版年份',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `course_book` */

insert  into `course_book`(`id`,`courseid`,`types`,`author`,`bookname`,`press`,`presstime`) values (1,'SEG031','指定教材','Wesley J. Chun 著，宋广吉 译','Python核心编程（第二版）','人民邮电出版社','2008'),(2,'SEG031','指定教材','Magnus L. Hetland著，司维 等译','Python基础教程(第2版)','人民邮电出版社','2014'),(3,'SEG031','参考书目','Laura Cassell，Alan Gauld 著， 高弘扬、卫莹 译','Python项目开发实战','清华大学出版社','2015'),(4,'SEG031','参考书目','张若愚 著','Python科学计算','清华大学出版社','2012');

/*Table structure for table `course_info1` */

DROP TABLE IF EXISTS `course_info1`;

CREATE TABLE `course_info1` (
  `courseid` varchar(10) NOT NULL COMMENT '课程编号',
  `username` varchar(10) DEFAULT NULL COMMENT '课程负责人用户名',
  `attribute` varchar(10) DEFAULT NULL COMMENT '课程性质',
  `cname` varchar(20) DEFAULT NULL COMMENT '课程名称',
  `points` varchar(5) DEFAULT NULL COMMENT '课程学分',
  `period` int(5) DEFAULT NULL COMMENT '课程总学时',
  `theory` int(5) DEFAULT NULL COMMENT '理论学时',
  `practice` int(5) DEFAULT NULL COMMENT '实验学时',
  `major` varchar(50) DEFAULT NULL COMMENT '适用专业',
  `state` int(5) DEFAULT NULL COMMENT '课程是否发布',
  PRIMARY KEY (`courseid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `course_info1` */

insert  into `course_info1`(`courseid`,`username`,`attribute`,`cname`,`points`,`period`,`theory`,`practice`,`major`,`state`) values ('CST030','C2222','学科共同课','高级语言程序设计实验','1.0',32,0,32,'计算机科学技术、软件工程等专业',0),('CST031','C2222','学科共同课','高级语言程序设计','4.0',64,64,0,'计算机科学技术、软件工程等专业',0),('MHC001','C4444','普通共同课','大学生心理健康教育','1.0',24,24,0,'所有专业',0),('MPE001','C4444','普通共同课','军事理论','2.0',32,32,0,'所有专业',0),('SEG007','C2222','专业选修课','面向对象程序设计(Java)','3.0',48,48,0,'计算机科学技术、软件工程等专业',0),('SEG008','C2222','专业选修课','面向对象程序设计(Java)实验','1.0',32,0,32,'计算机科学技术、软件工程等专业',0),('SEG011','C2222','专业选修课','Web应用开发技术基础','3.0',48,48,0,'计算机科学技术、软件工程等专业',0),('SEG012','C2222','专业选修课','Web应用开发技术基础实验','1.0',32,0,32,'计算机科学技术、软件工程等专业',0),('SEG013','C2222','专业选修课','设计模式','2.0',32,24,8,'计算机科学技术、软件工程等专业',0),('SEG031','C2222','专业必修课','Python程序设计与实践','2.0',32,24,8,'计算机科学技术、软件工程等专业',0);

/*Table structure for table `course_info2` */

DROP TABLE IF EXISTS `course_info2`;

CREATE TABLE `course_info2` (
  `courseid` varchar(10) NOT NULL COMMENT '课程编号',
  `username` varchar(10) DEFAULT NULL COMMENT '课程负责人用户名',
  `weeklytime` int(5) DEFAULT NULL COMMENT '每周学时',
  `totalgoal` text COMMENT '全部课程目标',
  `coursedes` text COMMENT '课程描述',
  `ways` text COMMENT '教学方法与手段',
  `tests` text COMMENT '考核方式及成绩评定',
  PRIMARY KEY (`courseid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `course_info2` */

insert  into `course_info2`(`courseid`,`username`,`weeklytime`,`totalgoal`,`coursedes`,`ways`,`tests`) values ('SEG031','C2222',2,'1、掌握Python基础语法知识\r\n2、掌握Python科学计算工具进行数据统计与可视化分析\r\n3、利用Python网络爬虫算法获取web数据，存储在数据库中\r\n4、具备应用Python进行各类项目快速开发的能力','本课程为计算机科学与技术、软件工程等相关专业的专业选修课。课程目的是向学生介绍“语法简洁清晰、具有丰富类库”的Python语言，感受新一代编程语言的魅力。课程内容主要包括Python基础语法知识、Python数据科学分析工具包、数据库编程、网络编程、正则表达式、Web开发、GUI设计以及Python应用开发项目实训，重在培养学生利用Python进行数据分析与管理以及IT领域项目快速开发的能力，为以后的《数据库应用技术》、《大数据与知识工程》等课程打下坚实基础，以适应大数据时代各行各业软件快速开发的需求。','以课堂理论教学为主，实验实践为辅。课堂理论教学以多媒体课件为主，黑板板书为辅。在教学过程中注重能力的培养，以实际应用系统为例，提高理论教学实用性，提高学生分析和解决实际问题的能力。','考核方式：期末闭卷考试+平时表现（平时作业、出勤、课堂表现、实验报告）。\r\n成绩评定标准：总成绩（百分制）＝平时成绩×40％＋期末考试成绩×60％。');

/*Table structure for table `course_infodetails` */

DROP TABLE IF EXISTS `course_infodetails`;

CREATE TABLE `course_infodetails` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(10) DEFAULT NULL COMMENT '课程负责人用户名',
  `courseid` varchar(10) DEFAULT NULL COMMENT '课程编号',
  `ord` int(5) DEFAULT NULL COMMENT '课程内容顺序',
  `coursedata` text COMMENT '课程章节内容',
  `coursetime` int(5) DEFAULT NULL COMMENT '课时数',
  `goal` varchar(50) DEFAULT NULL COMMENT '课程目标',
  `secondindicid` varchar(5) DEFAULT NULL COMMENT '对应毕业生能力二级指标编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `course_infodetails` */

insert  into `course_infodetails`(`id`,`username`,`courseid`,`ord`,`coursedata`,`coursetime`,`goal`,`secondindicid`) values (1,'C2222','SEG031',1,'第1章   Python语言入门概览	                \r\n    重点内容： Python开发环境IDE，代码示例与语言风格\r\n    难点内容： Python语言风格\r\n教学内容： 介绍Python的发展历史，安装、运行方式与开发环境IDE，最简单Python代码示例，讲解Python语言特色。\r\n1.1 Python语言起源\r\n1.2 Python能做什么？\r\n1.3 Python的安装、运行与IDE\r\n1.4最简单python代码示例\r\n1.5 Python语言风格',1,'掌握Python基础语法知识','5.1'),(2,'C2222','SEG031',2,'第2章  数据结构	                              \r\n    重点内容： 列表、元组、字符串、字典\r\n    难点内容： 列表、字典\r\n教学内容： 介绍Python的数据类型与运算符，以及列表、元组、字符串、字典和集合等数据结构。\r\n2.1 数据类型与运算符\r\n2.2 列表\r\n2.3 元组\r\n2.4 字符串\r\n2.5字典\r\n2.6 集合',2,'掌握Python基础语法知识','5.1'),(3,'C2222','SEG031',3,'第3章  控制流与函数编程	                      \r\n    重点内容： 条件语句、循环语句、函数的调用与创建\r\n    难点内容： 迭代器和列表解析，函数的调用与创建\r\n教学内容： 讲解Python的条件语句、循环语句等控制结构，迭代器和列表解析，函数的调用与自定义创建，可变长度参数的函数，lambda函数及一些内建函数。\r\n3.1 条件语句：if和else\r\n3.2 循环语句：while和for\r\n3.3 break、continue和pass语句\r\n3.4 测试与异常处理：try-except语句\r\n3.5 迭代器和列表解析\r\n3.6 函数调用\r\n3.7 创建函数：def语句\r\n3.8 可变长度参数\r\n3.9 lambda函数\r\n3.10内建函数',2,'掌握Python基础语法知识','5.1'),(4,'C2222','SEG031',4,'第4章  文件操作与数据存取	                        \r\n    重点内容： 文件读写方法、文件系统处理\r\n    难点内容： 数据永久存储\r\n教学内容： 介绍Python的文件对象和打开方式，读取文件数据的各种方法，文件系统处理方法，并讲解数据解压缩和数据永久存储方法。\r\n4.1 文件对象与打开\r\n4.2 文件读写方法\r\n4.3 文件系统处理\r\n4.4 数据解压缩\r\n4.5 数据永久存储',1,'掌握Python基础语法知识','5.1'),(5,'C2222','SEG031',5,'第5章  模块与面向对象编程	                        \r\n    重点内容： 模块，类\r\n    难点内容： 面向对象编程\r\n教学内容： 讲解Python模块的导入和定义，包，以及面向对象编程中的类与实例。\r\n5.1模块与文件\r\n5.2导入模块\r\n5.3常用模块\r\n5.4 Package(包)\r\n5.5面向对象编程\r\n5.6类\r\n5.7类属性\r\n5.8实例与实例属性',2,'掌握Python基础语法知识','5.1'),(6,'C2222','SEG031',6,'第6章  Python数据科学工具	                        \r\n    重点内容： 科学计算Numpy和Scipy，数据分析Pandas，画图Matplotlib\r\n    难点内容： Numpy中的矩阵运算，数据挖掘工具\r\n教学内容： 介绍各种常用的Python数据科学工具包。\r\n6.1 科学计算Numpy和Scipy\r\n6.2 符号计算Sympy\r\n6.3 数据分析Pandas\r\n6.4 画图工具Matplotlib\r\n6.5 统计分析StatsModels与Rpy2\r\n6.6 数据挖掘工具scikit-learn\r\n6.7 图形图像处理工具',4,'掌握Python科学计算工具进行数据统计与可视化分析','5.3'),(7,'C2222','SEG031',7,'第7章  Python扩展与性能优化                      \r\n    重点内容： 执行其他python与非python程序，Cython\r\n    难点内容： Rpy2，Cython\r\n教学内容： 讲解Python扩展，如何在当前Python代码中执行其他python与非python程序，介绍Jython和IronPython，利用Rpy2模块在Python代码中编写R语言统计函数，利用Cython植入C语言优化计算性能。\r\n7.1 Python扩展概述\r\n7.2 执行其他python与非python程序\r\n7.3 Jython和IronPython\r\n7.4 写R语言代码：利用Rpy2\r\n7.5 植入C语言： 利用Cython优化计算性能',1,'掌握Python科学计算工具进行数据统计与可视化分析','5.3'),(8,'C2222','SEG031',8,'第8章  正则表达式                              \r\n    重点内容： 正则表达式\r\n    难点内容： 正则表达式\r\n教学内容： 介绍特殊符号与字符的表达方式，讲解正则表达式模块re。\r\n8.1 引言\r\n8.2 特殊符号与字符\r\n8.3 正则表达式模块re\r\n8.4 正则表达式示例',2,'掌握Python科学计算工具进行数据统计与可视化分析','5.3'),(9,'C2222','SEG031',9,'第9章  Python访问数据库                           \r\n    重点内容：Python数据库接口\r\n    难点内容： MongoDB与Python\r\n教学内容： 介绍Python数据库接口，SQLite和PySQLite，Python访问Mysql和MongoDB数据库的方式。\r\n9.1 数据管理和SQL语言\r\n9.2 Python数据库接口(DB-API)\r\n9.3 SQLite和PySQLite　\r\n9.4 Mysql的Python访问\r\n9.5 MongoDB的Python访问',2,'利用Python网络爬虫算法获取web数据，存储在数据库中','4.1'),(10,'C2222','SEG031',10,'第10章 多线程编程                                \r\n重点内容：Python的多线程编程\r\n难点内容：thread和threading模块\r\n教学内容：介绍线程和进程等概念，讲解Python的多线程编程。\r\n10.1 线程和进程概述\r\n10.2 Python中的线程\r\n10.3 thread和threading模块\r\n10.4 单线程与多线程执行比较',2,'利用Python网络爬虫算法获取web数据，存储在数据库中','4.1'),(11,'C2222','SEG031',11,'第11章  网络与Web编程                           \r\n    重点内容：Socket编程，网络爬虫，web开发框架\r\n    难点内容： 网络爬虫，web开发框架\r\n教学内容： 讲解利用Python进行Socket编程，ftp文件传输，电子邮件处理，以及利用基于Python的网络爬虫获取web数据，最后介绍web开发框架Django。\r\n11.1 Socket编程\r\n11.2 Python与ftp文件传输\r\n11.3 电子邮件\r\n11.4网络爬虫\r\n11.5 Web服务器\r\n11.6 Web开发框架',3,'利用Python网络爬虫算法获取web数据，存储在数据库中','4.1'),(12,'C2222','SEG031',12,'第12章  图形用户界面设计                           \r\n    重点内容：Tkinter模块\r\n    难点内容： Tkinter组件\r\n教学内容： 主要讲解利用Python的Tkinter进行GUI设计，简单介绍其他GUI设计工具，如PyQt和WxPython。\r\n12.1 Tkinter模块\r\n12.2 Tkinter组件\r\n12.3 其它GUI设计工具',2,'具备应用Python进行各类项目快速开发的能力','3.1'),(13,'C2222','SEG031',13,'第13章  Python项目开发实战                           \r\n    重点内容：PyGame，Django，Scrapy\r\n    难点内容： PyGame，Django，Scrapy\r\n教学内容：介绍与掌握PyGame，Django，Scrapy等Python工具包，进行项目开发实训。\r\n13.1 玩转PyGame：游戏开发实例\r\n13.2 利用Django 进行Web开发\r\n13.3 应用Web爬虫框架Scrapy抓取数据\r\n13.4 其它',2,'具备应用Python进行各类项目快速开发的能力','3.1'),(14,'C2222','SEG031',14,'课内实验内容:Python核心语法学习实践\r\n实验要求:\r\n通过编程，熟练掌握Python的数据结构，控制流，函数编程，文件操作和面向对象编程',2,NULL,NULL),(15,'C2222','SEG031',15,'课内实验内容:Python科学计算实验\r\n实验要求:\r\n通过编程，熟练掌握numpy的矩阵计算，matplotlib画图，pandas数据分析，了解Python统计分析、数据挖掘与图形图像处理等工具',2,NULL,NULL),(16,'C2222','SEG031',16,'课内实验内容:Python数据收集与数据库管理\r\n实验要求:\r\n掌握Python的Web爬虫工具，获取大量数据，存储在数据库中，并进行一定的统计分析',2,NULL,NULL),(17,'C2222','SEG031',17,'课内实验内容:基于Python的项目开发实训\r\n实验要求:\r\n选择一个项目，利用Python进行游戏开发、Web开发、Android开发等实践',2,NULL,NULL);

/*Table structure for table `course_relation` */

DROP TABLE IF EXISTS `course_relation`;

CREATE TABLE `course_relation` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `courseid` varchar(10) DEFAULT NULL COMMENT '课程编号',
  `coursetype` varchar(10) DEFAULT NULL COMMENT '类型（先修/后修）',
  `relacourseid` varchar(10) DEFAULT NULL COMMENT '有关课程id',
  `relacname` varchar(20) DEFAULT NULL COMMENT '有关课程名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `course_relation` */

insert  into `course_relation`(`id`,`courseid`,`coursetype`,`relacourseid`,`relacname`) values (1,'SEG031','先修','CST030','高级语言程序设计实验'),(2,'SEG031','先修','CST031','高级语言程序设计'),(3,'SEG031','后修','SEG011','Web应用开发技术基础');

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `pid` varchar(10) NOT NULL,
  `memorandum` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

/*Data for the table `userinfo` */

insert  into `userinfo`(`id`,`username`,`password`,`pid`,`memorandum`) values (1,'A1111','11111','管理员','唯一的管理员'),(2,'C2222','66666','课程负责人',NULL),(3,'C3333','55555','课程负责人',NULL),(4,'C4444','44444','课程负责人',NULL),(5,'P5555','12345','专业负责人',NULL),(6,'P6666','55555','专业负责人',NULL),(30,'P4433','12333','专业负责人','');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

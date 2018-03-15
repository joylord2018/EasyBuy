/*
SQLyog Ultimate v12.3.1 (32 bit)
MySQL - 5.0.24-community-nt : Database - easybuy
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`easybuy` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `easybuy`;

/*Table structure for table `easybuy_comment` */

DROP TABLE IF EXISTS `easybuy_comment`;

CREATE TABLE `easybuy_comment` (
  `ec_id` int(20) NOT NULL auto_increment COMMENT '编号',
  `ec_content` varchar(200) NOT NULL COMMENT '留言内容',
  `ec_create_time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '创建时间',
  `ec_reply` varchar(200) default NULL COMMENT '留言回复',
  `ec_reply_time` timestamp NOT NULL default '0000-00-00 00:00:00' COMMENT '回复时间',
  `ec_nick_name` varchar(10) NOT NULL COMMENT '留言用户昵称(用户id)',
  PRIMARY KEY  (`ec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `easybuy_comment` */

insert  into `easybuy_comment`(`ec_id`,`ec_content`,`ec_create_time`,`ec_reply`,`ec_reply_time`,`ec_nick_name`) values 
(1,'牛批！','2017-11-08 09:21:42','牛批+1！','2009-12-27 09:21:37','美滋滋'),
(2,'吃翔','2017-11-08 09:21:46','不吃，滚！','2022-08-24 09:21:42','不知味'),
(3,'纽顿艾因丝毯','2017-11-08 09:21:50','大家好，我是秦始皇，你们懂的','2017-09-19 09:21:46','不知死活'),
(4,'此留言必火!','2017-11-08 09:21:55','神贴前排留名！','2017-06-05 09:21:51','呵呵哒'),
(7,'给力啊兄dei！','2017-11-08 10:24:59',NULL,'0000-00-00 00:00:00','当前用户名'),
(8,'真的这么好？','2017-11-08 10:30:14',NULL,'0000-00-00 00:00:00','qwq'),
(9,'卧槽真的假的？血亏大甩卖？','2017-11-13 11:15:45','呵呵哒哒哒','2017-11-13 11:15:45','qwq');

/*Table structure for table `easybuy_news` */

DROP TABLE IF EXISTS `easybuy_news`;

CREATE TABLE `easybuy_news` (
  `en_id` int(20) NOT NULL auto_increment COMMENT '编号',
  `en_title` varchar(40) NOT NULL COMMENT '标题',
  `en_content` varchar(10000) NOT NULL COMMENT '内容',
  `en_create_time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '录入时间 默认系统时间',
  PRIMARY KEY  (`en_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `easybuy_news` */

insert  into `easybuy_news`(`en_id`,`en_title`,`en_content`,`en_create_time`) values 
(1,'中铁侵美战争','战争海贼王','2017-11-07 09:18:09'),
(2,'母猪如何半年减肥到20斤','肥萨奇','2017-11-07 09:18:33'),
(3,'论天才如何变成智障','驱蚊器','2017-11-07 09:19:02'),
(4,'论狗蛋如何升天','蔷薇','2017-11-07 13:53:23'),
(5,'马云要演电影了！','瑞特','2017-11-07 09:19:54'),
(6,'雷神8电动牙刷上市','雷神','2017-11-07 09:20:47'),
(7,'悟空何时归来？','唐僧','2013-05-13 13:53:41');

/*Table structure for table `easybuy_order` */

DROP TABLE IF EXISTS `easybuy_order`;

CREATE TABLE `easybuy_order` (
  `eo_id` varchar(50) NOT NULL default '' COMMENT '订单编号',
  `eo_user_id` varchar(20) NOT NULL COMMENT '用户id',
  `eo_user_name` varchar(20) NOT NULL COMMENT '用户真实姓名',
  `eo_user_address` varchar(200) NOT NULL COMMENT '用户地址',
  `eo_create_time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '订单创建时间',
  `eo_cost` double NOT NULL COMMENT '订单总金额',
  `eo_status` int(10) NOT NULL COMMENT '状态:1待审核，2审核通过，3配货，卖家已发货，5已收货',
  PRIMARY KEY  (`eo_id`),
  KEY `eo_user_id` (`eo_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `easybuy_order` */

insert  into `easybuy_order`(`eo_id`,`eo_user_id`,`eo_user_name`,`eo_user_address`,`eo_create_time`,`eo_cost`,`eo_status`) values 
('4d4c3241be7a43099865def54879850f','asd','王琦瑶','天狼星32号石板桥','2017-11-10 12:00:07',800,1),
('4f52a34b4c2442e5a2c84d80fcfde8c4','asd','王琦瑶','斯坦星82号洞','2017-11-10 11:59:38',1600,1),
('62251cf7f8c44f5c9090f94a63a44a43','asd','王琦瑶','宝莲灯路谭水区12-1','2017-11-13 10:22:45',1012,1),
('7537c9a7481442f08dcc50fba70305e6','asd','王琦瑶','天狼星32号石板桥','2017-11-10 11:48:40',1100,1),
('90e69b0301f94f0ebc75ab081cb8b371','zxc','李少顺','水值河骷髅穴','2017-11-13 10:12:04',620,1),
('c7b19db775d741f4b7e8157a562017a6','asd','王琦瑶','恒苗山72号洞','2017-11-13 09:40:46',800,1),
('d5787b558c904f45b24328ec530198c9','qwq','许嵩','大水寨水帘洞','2017-11-10 10:57:17',1712,1);

/*Table structure for table `easybuy_order_detail` */

DROP TABLE IF EXISTS `easybuy_order_detail`;

CREATE TABLE `easybuy_order_detail` (
  `eod_id` int(20) NOT NULL auto_increment COMMENT '订单详情编号',
  `eo_id` varchar(50) NOT NULL COMMENT '订单ID',
  `ep_id` int(20) NOT NULL COMMENT '商品编号',
  `eod_quantity` int(20) NOT NULL COMMENT '购买数量',
  `eod_cost` double NOT NULL COMMENT '订单金额',
  PRIMARY KEY  (`eod_id`),
  KEY `eo_id` (`eo_id`),
  KEY `ep_id` (`ep_id`),
  CONSTRAINT `easybuy_order_detail_ibfk_3` FOREIGN KEY (`eo_id`) REFERENCES `easybuy_order` (`eo_id`),
  CONSTRAINT `easybuy_order_detail_ibfk_2` FOREIGN KEY (`ep_id`) REFERENCES `easybuy_product` (`ep_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `easybuy_order_detail` */

insert  into `easybuy_order_detail`(`eod_id`,`eo_id`,`ep_id`,`eod_quantity`,`eod_cost`) values 
(4,'4f52a34b4c2442e5a2c84d80fcfde8c4',3,3,900),
(5,'4f52a34b4c2442e5a2c84d80fcfde8c4',4,1,200),
(6,'4f52a34b4c2442e5a2c84d80fcfde8c4',1,1,500),
(7,'4d4c3241be7a43099865def54879850f',2,1,500),
(8,'4d4c3241be7a43099865def54879850f',3,1,300),
(9,'c7b19db775d741f4b7e8157a562017a6',2,1,500),
(10,'c7b19db775d741f4b7e8157a562017a6',3,1,300),
(11,'90e69b0301f94f0ebc75ab081cb8b371',3,2,600);

/*Table structure for table `easybuy_product` */

DROP TABLE IF EXISTS `easybuy_product`;

CREATE TABLE `easybuy_product` (
  `ep_id` int(20) NOT NULL auto_increment COMMENT '商品编号',
  `ep_name` varchar(20) NOT NULL COMMENT '商品名称',
  `ep_description` varchar(100) default NULL COMMENT '商品描述',
  `ep_price` float NOT NULL COMMENT '商品价格',
  `ep_stock` int(20) NOT NULL COMMENT '商品库存',
  `epc_id` int(20) NOT NULL COMMENT '所属分类ID',
  `epc_child_id` int(20) default NULL COMMENT '所属二级分类编号',
  `ep_file_name` varchar(200) NOT NULL COMMENT '上传的文件名',
  `ep_delete` int(11) NOT NULL COMMENT '1为正常商品 2为删除商品不显示',
  PRIMARY KEY  (`ep_id`),
  KEY `epc_id` (`epc_id`),
  CONSTRAINT `easybuy_product_ibfk_1` FOREIGN KEY (`epc_id`) REFERENCES `easybuy_product_category` (`epc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `easybuy_product` */

insert  into `easybuy_product`(`ep_id`,`ep_name`,`ep_description`,`ep_price`,`ep_stock`,`epc_id`,`epc_child_id`,`ep_file_name`,`ep_delete`) values 
(1,'龟苓膏','延年益寿',400,996,5,NULL,'1.jpg',1),
(2,'深海鱼油','辅助降血脂三高',500,997,5,NULL,'2.jpg',1),
(3,'幸福伤风素','消除喷嚏，流鼻水，蔽塞，发烧，肌肉酸痛',300,984,6,NULL,'3.jpg',1),
(4,'和兴白花油','清凉效果和止痛功能',200,996,6,NULL,'4.jpg',1),
(5,'百威啤酒','喝了都说好',15,9998,7,NULL,'5.jsp',1),
(6,'德麦啤酒','就很好喝，没理由，不吹',20,9999,7,NULL,'cffc964454cc4fe2b99c6db2586940c9.png',1),
(7,'烤猪腰子','好吃再来',8,49,8,NULL,'5201536823c44678970cf389e1efcc60.jpg',1),
(8,'烤牛鞭','神奇补肾，夜御百女枪不倒',12,19,8,NULL,'6.jpg',1),
(9,'大齐波板糖','不甜不腻苦兮兮',10,100,9,NULL,'7.jpg',1),
(10,'蚱蜢棒棒糖','贝爷最爱零食',28,15,9,NULL,'8.jpg',1),
(11,'PSIII','不买剁手',3000,1000,10,NULL,'9.jpg',1),
(12,'PSIV8',' 这都不卖有人性？',6500,499,10,NULL,'10.jpg',1),
(13,'花王尿不湿','防侧漏透风',389,499,11,NULL,'10.jpg',1),
(14,'安尔乐','还真德挺好用',289,499,11,NULL,'11.jpg',1),
(15,'Nutrilon','能喝，不大头',600,1000,12,NULL,'11.jpg',1),
(16,'美素佳儿','提高智力，仙风道骨',700,500,12,NULL,'12.jpg',1),
(17,'天使','天使纸尿裤，一夜干爽',320,500,11,NULL,'ccba465d657c4caeacf23cbf4d116101.png',1);

/*Table structure for table `easybuy_product_category` */

DROP TABLE IF EXISTS `easybuy_product_category`;

CREATE TABLE `easybuy_product_category` (
  `epc_id` int(20) NOT NULL auto_increment COMMENT '一级分类编号',
  `epc_name` varchar(20) NOT NULL COMMENT '名称',
  `epc_parent_id` int(20) default NULL COMMENT '父分类没卵用',
  PRIMARY KEY  (`epc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `easybuy_product_category` */

insert  into `easybuy_product_category`(`epc_id`,`epc_name`,`epc_parent_id`) values 
(1,'老人',-1),
(2,'青年',-1),
(3,'小孩',-1),
(4,'幼儿',-1),
(5,'保健品',1),
(6,'药品',1),
(7,'啤酒',2),
(8,'烤串',2),
(9,'棒棒糖',3),
(10,'PSIV',3),
(11,'尿不湿',4),
(12,'幼儿奶粉',4);

/*Table structure for table `easybuy_user` */

DROP TABLE IF EXISTS `easybuy_user`;

CREATE TABLE `easybuy_user` (
  `eu_user_id` varchar(10) NOT NULL COMMENT '用户名',
  `eu_user_name` varchar(20) NOT NULL COMMENT '用户真实姓名',
  `eu_password` varchar(50) NOT NULL default '' COMMENT '密码',
  `eu_sex` varchar(1) NOT NULL COMMENT '性别 T为男，F为女',
  `eu_birthday` date default NULL COMMENT '出生日期',
  `eu_identity_code` varchar(18) default NULL COMMENT '身份证号',
  `eu_email` varchar(80) default NULL COMMENT '邮箱',
  `eu_mobile` varchar(11) NOT NULL default '' COMMENT '手机号',
  `eu_address` varchar(200) NOT NULL COMMENT '收货地址',
  `eu_login` int(1) NOT NULL COMMENT '是否登陆1登陆 2未登陆',
  `eu_status` int(5) default NULL COMMENT '1为普通用户，2为管理员',
  `eu_delete` int(2) NOT NULL COMMENT '1为正常用户 2为已删除用户',
  PRIMARY KEY  (`eu_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `easybuy_user` */

insert  into `easybuy_user`(`eu_user_id`,`eu_user_name`,`eu_password`,`eu_sex`,`eu_birthday`,`eu_identity_code`,`eu_email`,`eu_mobile`,`eu_address`,`eu_login`,`eu_status`,`eu_delete`) values 
('asd','王琦瑶','4297f44b13955235245b2497399d7a93','F','1933-03-03','963418944894942213','456@456.com','16954959574','斯坦星82号洞,恒苗山72号洞,宝莲灯路谭水区12-1,天狼星32号石板桥',2,1,1),
('osd','王玲','4297f44b13955235245b2497399d7a93','F',NULL,'123456789012345678','adsd@sad.com','13165987569','战歌氏族',2,1,1),
('qwe','王伟说','4297f44b13955235245b2497399d7a93','T','1933-03-15','121256489632148569','456@456.com','13859648954','火云教第二房',2,1,1),
('qwq','许嵩','4297f44b13955235245b2497399d7a93','T','2017-11-23','123456789012345678','asda@dqw.com','13565659898','大水寨水帘洞,萨比城二呆街',2,2,1),
('zxc','李少顺','4297f44b13955235245b2497399d7a93','T','1888-08-08','945845416541521484','123@123.com','13566699549','水值河骷髅穴',2,1,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

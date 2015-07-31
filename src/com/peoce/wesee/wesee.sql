# Host: localhost  (Version: 5.6.21-log)
# Date: 2015-07-31 17:06:10
# Generator: MySQL-Front 5.3  (Build 4.13)

/*!40101 SET NAMES utf8 */;

#
# Source for table "pic"
#

CREATE TABLE `pic` (
  `PhotoId` varchar(100) DEFAULT NULL,
  `PhotoUrl` varchar(200) DEFAULT NULL,
  `UpCount` bigint(20) DEFAULT NULL,
  `CreateBy` int(10) DEFAULT NULL,
  `PicCreateTime` datetime DEFAULT NULL,
  `Tag` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "pic"
#

INSERT INTO `pic` VALUES ('hash001','http://f10.topitme.com/l/201102/25/12986156767026.jpg',0,NULL,'2015-07-29 02:22:22',NULL),('hash002','http://f10.topitme.com/l/201008/15/12818581767206.jpg',8,10001,'2015-07-29 02:12:22',NULL),('hash003','http://f10.topitme.com/l/201008/15/12818581612550.jpg',0,NULL,'2015-03-29 02:22:22','视觉'),('hash004','http://f10.topitme.com/l/201008/15/12818581466229.jpg',5,NULL,'2015-07-29 02:22:12','设计,动物'),('hash005','http://f10.topitme.com/l/201008/15/12818579878408.jpg',0,10001,'2015-01-19 02:22:22','美女,风景'),('hash006','http://f10.topitme.com/l/201008/15/12818579238869.jpg',0,10001,'2015-07-29 02:22:22',NULL),('hash007','http://f10.topitme.com/l/201008/15/12818579342714.jpg',0,NULL,'2015-07-29 02:22:22',NULL),('hash008','http://f10.topitme.com/l/201008/15/12818579776119.jpg',0,NULL,'2014-07-29 02:22:22','风景,'),('hash009','http://f10.topitme.com/l/201008/15/12818579674975.jpg',9,NULL,'2015-07-22 02:22:22',NULL),('hash010','http://f10.topitme.com/l/201008/15/12818579643989.jpg',0,10006,'2015-07-29 02:22:22','动物,肖像'),('hash011','http://f10.topitme.com/l/201008/15/12818579463609.jpg',7,NULL,'2015-07-29 02:22:22',NULL),('hash012','http://f10.topitme.com/l/201008/15/12818579457303.jpg',6,10002,'2015-07-29 02:22:22',NULL),('hash013','http://f10.topitme.com/l/201103/06/12994159046560.jpg',0,NULL,'2015-07-29 02:22:22',NULL),('hash014','http://f10.topitme.com/l/201103/06/12994158819934.jpg',5,10006,'2015-07-29 02:22:22',NULL),('hash015','http://f10.topitme.com/l/201103/06/12994158737788.jpg',0,NULL,'2015-07-29 02:22:22',NULL),('hash016','http://f10.topitme.com/l/201011/08/12891474357367.jpg',0,NULL,'2015-07-29 02:22:22',NULL),('hash017','http://f10.topitme.com/l/201103/06/12994157615902.jpg',4,NULL,'2015-07-29 02:22:22','科技,人文,风景');

#
# Source for table "user_relation"
#

CREATE TABLE `user_relation` (
  `Id` int(11) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `FriendId` int(11) DEFAULT NULL COMMENT '好友的ID',
  `IsBlock` bit(1) DEFAULT NULL COMMENT '不看他的信息',
  `NotVisible` bit(1) DEFAULT NULL COMMENT '不让谁看'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户关系表';

#
# Data for table "user_relation"
#

INSERT INTO `user_relation` VALUES (10001,10002,b'0',b'0'),(10002,10006,b'0',b'0'),(10003,10002,b'0',b'0'),(10004,10002,b'0',b'0'),(10005,10006,b'0',b'0'),(10006,10002,b'0',b'0'),(10001,10006,b'1',b'0'),(10006,10001,b'0',b'0'),(10005,10003,b'0',b'0'),(10001,10003,b'0',b'0');

#
# Source for table "users"
#

CREATE TABLE `users` (
  `id` int(10) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `PhoneNumber` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `PassWord` varchar(50) DEFAULT NULL COMMENT 'Hash后的密码',
  `Gender` varchar(10) DEFAULT NULL COMMENT '性别',
  `NickName` varchar(20) DEFAULT NULL COMMENT '昵称',
  `City` varchar(255) DEFAULT NULL COMMENT '所在城市',
  `Email` varchar(255) DEFAULT NULL COMMENT '电子邮件',
  `PhotoURL` varchar(300) DEFAULT NULL COMMENT '头像路径',
  `SignTime` datetime DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

#
# Data for table "users"
#

INSERT INTO `users` VALUES (10001,'13856284152','14DE0D30C8225AF539A0E47E6E793387','male','tom','南京','34234@qq.com','http://1.1.1.1/avatar/10001_avatar.jpg','2014-12-09 12:12:33'),(10002,'18852441434','1C97AC216164D984AB4581D98E8F4500','female','alice','深圳','yingyunm@163.com','http://1.1.1.1/avatar/10002_avatar.jpg','2014-12-09 12:12:33'),(10003,'13545274125','66E7F034AAF81559C56DFBB041E27AFF','female','cydine','上海','zhangsan@gmail.com','http://1.1.1.1/avatar/10003_avatar.jpg','2014-12-09 12:12:33'),(10004,'18541454242','556870393E2AD583A247E0800C490850','female','susan','深圳','lisi@hotmail.com','http://1.1.1.1/avatar/10004_avatar.jpg','2014-12-09 12:12:33'),(10005,'13352451457','2F8F2CCBA039AA590CE6701675C85A0C','male','zacy','深圳','85956211@qq.com','http://1.1.1.1/avatar/10005_avatar.jpg','2014-12-09 12:12:33'),(10006,'15975414324','31450C2649C6A60688585EBB1893F3A5','female','tomas','深圳','56132@qq.com','http://1.1.1.1/avatar/10006_avatar.jpg','2014-12-09 12:12:33');

#
# Source for table "user_pic"
#

CREATE TABLE `user_pic` (
  `id` int(11) DEFAULT NULL COMMENT '用户ID',
  `Descript` text,
  `PhotoId` varchar(100) DEFAULT NULL COMMENT '图片编号',
  `UpCount` bigint(20) DEFAULT NULL COMMENT '点赞数',
  `IsRetwitter` bit(1) DEFAULT NULL COMMENT '是否为转发的图片',
  `PublishTime` datetime DEFAULT NULL COMMENT '发布日期',
  KEY `FK_user_content_id` (`id`),
  CONSTRAINT `FK_user_content_id` FOREIGN KEY (`id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "user_pic"
#

INSERT INTO `user_pic` VALUES (10006,'bea','hash014',2,b'0','2015-07-30 10:01:01'),(10006,'bea','hash014',2,b'0','2015-07-30 10:01:01'),(10002,'我的自拍','hash0012',0,b'0','2015-07-20 20:01:01'),(10001,'哈哈哈','hash005',1,b'0','2015-07-15 20:01:01'),(10001,'角度很有么','hash006',0,b'0','2015-07-30 18:01:01'),(10001,'喵喵喵','hash002',0,b'0','2015-02-12 20:01:01');

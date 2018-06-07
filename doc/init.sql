/*
SQLyog Ultimate v9.30 
MySQL - 5.6.40 : Database - zhiyi
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`zhiyi` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `zhiyi`;

/*Table structure for table `sys_config` */

DROP TABLE IF EXISTS `sys_config`;

CREATE TABLE `sys_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key` varchar(50) DEFAULT NULL COMMENT 'key',
  `value` varchar(2000) DEFAULT NULL COMMENT 'value',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态   0：隐藏   1：显示',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key` (`key`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统配置信息表';

/*Data for the table `sys_config` */

LOCK TABLES `sys_config` WRITE;

insert  into `sys_config`(`id`,`key`,`value`,`status`,`remark`) values (1,'CLOUD_STORAGE_CONFIG_KEY','{\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"aliyunDomain\":\"\",\"aliyunEndPoint\":\"\",\"aliyunPrefix\":\"\",\"qcloudBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qiniuAccessKey\":\"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ\",\"qiniuBucketName\":\"ios-app\",\"qiniuDomain\":\"http://7xqbwh.dl1.z0.glb.clouddn.com\",\"qiniuPrefix\":\"upload\",\"qiniuSecretKey\":\"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV\",\"type\":1}',0,'云存储配置信息');

UNLOCK TABLES;

/*Table structure for table `sys_log` */

DROP TABLE IF EXISTS `sys_log`;

CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=275 DEFAULT CHARSET=utf8 COMMENT='系统日志';

/*Data for the table `sys_log` */

LOCK TABLES `sys_log` WRITE;

insert  into `sys_log`(`id`,`username`,`operation`,`method`,`params`,`time`,`ip`,`create_date`) values (198,'admin','修改定时任务','com.idou.modules.job.controller.ScheduleJobController.update()','{\"jobId\":1,\"beanName\":\"testTask\",\"methodName\":\"test\",\"params\":\"idou\",\"cronExpression\":\"0 0/30 * * * ?\",\"status\":0,\"remark\":\"有参数测试\",\"createTime\":\"Dec 1, 2016 11:16:46 PM\"}',448,'0:0:0:0:0:0:0:1','2018-01-11 11:34:39'),(199,'admin','立即执行任务','com.idou.modules.job.controller.ScheduleJobController.run()','[1]',286,'0:0:0:0:0:0:0:1','2018-01-11 14:23:36'),(200,'admin','立即执行任务','com.idou.modules.job.controller.ScheduleJobController.run()','[1]',55,'0:0:0:0:0:0:0:1','2018-01-11 14:27:01'),(201,'admin','立即执行任务','com.idou.modules.job.controller.ScheduleJobController.run()','[1]',4557,'0:0:0:0:0:0:0:1','2018-01-11 14:38:30'),(202,'admin','立即执行任务','com.idou.modules.job.controller.ScheduleJobController.run()','[1]',97,'0:0:0:0:0:0:0:1','2018-01-11 14:39:14'),(203,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"网站管理\",\"type\":0,\"icon\":\"fa fa-product-hunt\",\"orderNum\":0}',57,'0:0:0:0:0:0:0:1','2018-05-29 15:23:07'),(204,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1056,\"parentName\":\"网站管理\",\"name\":\"基本信息\",\"url\":\"modules/sysEx/baseInfo.html\",\"perms\":\"sysWs:baseinfo:info\",\"type\":1,\"icon\":\"fa fa-list\",\"orderNum\":0}',64,'0:0:0:0:0:0:0:1','2018-05-29 15:31:20'),(205,'admin','保存角色','com.idou.modules.sysBs.controller.SysRoleController.save()','{\"roleId\":2,\"roleName\":\"网站管理员\",\"createUserId\":1,\"menuIdList\":[1056,1057],\"createTime\":\"May 29, 2018 3:50:10 PM\"}',134,'0:0:0:0:0:0:0:1','2018-05-29 15:50:10'),(206,'admin','删除角色','com.idou.modules.sysBs.controller.SysRoleController.delete()','[1]',68,'0:0:0:0:0:0:0:1','2018-05-29 15:50:17'),(207,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1056,\"parentName\":\"网站管理\",\"name\":\"网站菜单\",\"url\":\"modules/sysEx/menu.html\",\"perms\":\"sysWs:menu:info\",\"type\":1,\"icon\":\"fa fa-th-list\",\"orderNum\":1}',55,'0:0:0:0:0:0:0:1','2018-05-29 15:55:00'),(208,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1058,\"parentName\":\"网站菜单\",\"name\":\"修改\",\"perms\":\"sysWs:menu:update\",\"type\":2,\"orderNum\":0}',63,'0:0:0:0:0:0:0:1','2018-05-30 11:00:13'),(209,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1056,\"parentName\":\"网站管理\",\"name\":\"首页Banner\",\"url\":\"modules/sysEx/wsbanner.html\",\"perms\":\"sysWs:banner:list\",\"type\":1,\"icon\":\"fa fa-th-list\",\"orderNum\":2}',58,'0:0:0:0:0:0:0:1','2018-05-30 11:16:25'),(210,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1060,\"parentName\":\"首页Banner\",\"name\":\"新增\",\"perms\":\"sysWs:banner:add\",\"type\":2,\"orderNum\":0}',47,'0:0:0:0:0:0:0:1','2018-05-30 11:17:46'),(211,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1060,\"parentName\":\"首页Banner\",\"name\":\"修改\",\"perms\":\"sysWs:banner:update\",\"type\":2,\"orderNum\":0}',48,'0:0:0:0:0:0:0:1','2018-05-30 11:18:02'),(212,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1060,\"parentName\":\"首页Banner\",\"name\":\"删除\",\"perms\":\"sysWs:banner:del\",\"type\":2,\"orderNum\":0}',62,'0:0:0:0:0:0:0:1','2018-05-30 11:18:17'),(213,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"案例管理\",\"type\":0,\"icon\":\"fa fa-telegram\",\"orderNum\":1}',67,'0:0:0:0:0:0:0:1','2018-05-30 15:23:54'),(214,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1064,\"parentName\":\"案例管理\",\"name\":\"案例类型\",\"url\":\"modules/sysEx/wscasetype.html\",\"perms\":\"sysWs:wscasetype:list,sysWs:wscasetype:info\",\"type\":1,\"icon\":\"fa fa-th-list\",\"orderNum\":0}',63,'0:0:0:0:0:0:0:1','2018-05-30 15:27:01'),(215,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1064,\"parentName\":\"案例管理\",\"name\":\"案例列表\",\"url\":\"modules/sysEx/wscase.html\",\"perms\":\"sysWs:wscase:list,sysWs:wscase:info\",\"type\":1,\"icon\":\"fa fa-th-list\",\"orderNum\":1}',71,'0:0:0:0:0:0:0:1','2018-05-30 15:28:09'),(216,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1065,\"parentName\":\"案例类型\",\"name\":\"新增\",\"perms\":\"sysWs:wscasetype:add\",\"type\":2,\"orderNum\":0}',109,'0:0:0:0:0:0:0:1','2018-05-30 15:47:53'),(217,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1065,\"parentName\":\"案例类型\",\"name\":\"修改\",\"perms\":\"sysWs:wscasetype:update\",\"type\":2,\"orderNum\":0}',56,'0:0:0:0:0:0:0:1','2018-05-30 15:48:10'),(218,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1065,\"parentName\":\"案例类型\",\"name\":\"删除\",\"perms\":\"sysWs:wscasetype:delete\",\"type\":2,\"orderNum\":0}',54,'0:0:0:0:0:0:0:1','2018-05-30 15:48:26'),(219,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1066,\"parentName\":\"案例列表\",\"name\":\"新增\",\"perms\":\"sysWs:wscase:add\",\"type\":2,\"orderNum\":0}',212,'0:0:0:0:0:0:0:1','2018-05-30 17:25:02'),(220,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1066,\"parentName\":\"案例列表\",\"name\":\"修改\",\"perms\":\"sysWs:wscase:update\",\"type\":2,\"orderNum\":0}',65,'0:0:0:0:0:0:0:1','2018-05-30 17:25:18'),(221,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1066,\"parentName\":\"案例列表\",\"name\":\"删除\",\"perms\":\"sysWs:wscase:delete\",\"type\":2,\"orderNum\":0}',65,'0:0:0:0:0:0:0:1','2018-05-30 17:25:32'),(222,'admin','删除产品信息','com.idou.modules.wechat.controller.WxItemController.delete()','[2]',11,'0:0:0:0:0:0:0:1','2018-05-31 20:26:54'),(223,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1056,\"parentName\":\"网站管理\",\"name\":\"友链管理\",\"url\":\"modules/sysEx/wslinks.html\",\"perms\":\"sysWs:wslinks:list,sysWs:wslinks:info\",\"type\":1,\"icon\":\"fas fa-anchor\",\"orderNum\":3}',40,'0:0:0:0:0:0:0:1','2018-06-02 09:35:45'),(224,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1073,\"parentName\":\"友链管理\",\"name\":\"新增\",\"perms\":\"sysWs:wslinks:add\",\"type\":2,\"orderNum\":0}',42,'0:0:0:0:0:0:0:1','2018-06-02 09:36:51'),(225,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1073,\"parentName\":\"友链管理\",\"name\":\"修改\",\"perms\":\"sysWs:wslinks:update\",\"type\":2,\"orderNum\":0}',44,'0:0:0:0:0:0:0:1','2018-06-02 09:37:07'),(226,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1073,\"parentName\":\"友链管理\",\"name\":\"删除\",\"perms\":\"sysWs:wslinks:delete\",\"type\":2,\"orderNum\":0}',46,'0:0:0:0:0:0:0:1','2018-06-02 09:37:22'),(227,'admin','删除菜单','com.idou.modules.sysBs.controller.SysMenuController.delete()','1026',2,'0:0:0:0:0:0:0:1','2018-06-02 12:54:27'),(228,'admin','删除菜单','com.idou.modules.sysBs.controller.SysMenuController.delete()','1026',3,'0:0:0:0:0:0:0:1','2018-06-02 12:54:30'),(229,'admin','删除菜单','com.idou.modules.sysBs.controller.SysMenuController.delete()','1029',3,'0:0:0:0:0:0:0:1','2018-06-02 12:54:38'),(230,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1056,\"parentName\":\"网站管理\",\"name\":\"服务管理\",\"url\":\"modules/sysEx/wsserver.html\",\"perms\":\"sysWs:wsserver:list,sysWs:wsserver:info\",\"type\":1,\"icon\":\"fa fa-th-list\",\"orderNum\":4}',46,'0:0:0:0:0:0:0:1','2018-06-02 13:26:35'),(231,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1077,\"parentName\":\"服务管理\",\"name\":\"新增\",\"perms\":\"sysWs:wsserver:add\",\"type\":2,\"orderNum\":0}',64,'0:0:0:0:0:0:0:1','2018-06-02 13:27:13'),(232,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1077,\"parentName\":\"服务管理\",\"name\":\"修改\",\"perms\":\"sysWs:wsserver:update\",\"type\":2,\"orderNum\":0}',47,'0:0:0:0:0:0:0:1','2018-06-02 13:27:26'),(233,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1077,\"parentName\":\"服务管理\",\"name\":\"删除\",\"perms\":\"sysWs:wsserver:delete\",\"type\":2,\"orderNum\":0}',48,'0:0:0:0:0:0:0:1','2018-06-02 13:27:54'),(234,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"关于管理\",\"type\":0,\"icon\":\"fas fa-universal-access\",\"orderNum\":3}',70,'0:0:0:0:0:0:0:1','2018-06-04 15:18:38'),(235,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1081,\"parentName\":\"关于管理\",\"name\":\"封面管理\",\"url\":\"modules/sysEx/wsabout.html\",\"perms\":\"sysWs:wsabout:info,sysWs:wsabout:list\",\"type\":1,\"icon\":\"fa fa-file-image-o\",\"orderNum\":0}',75,'0:0:0:0:0:0:0:1','2018-06-04 15:38:10'),(236,'admin','删除菜单','com.idou.modules.sysBs.controller.SysMenuController.delete()','1082',126,'0:0:0:0:0:0:0:1','2018-06-04 15:39:23'),(237,'admin','删除菜单','com.idou.modules.sysBs.controller.SysMenuController.delete()','1081',69,'0:0:0:0:0:0:0:1','2018-06-04 15:39:28'),(238,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1056,\"parentName\":\"网站管理\",\"name\":\"关于管理\",\"url\":\"modules/sysEx/wsabout.html\",\"perms\":\"sysWs:wsabout:info,sysWs:wsabout:list\",\"type\":1,\"icon\":\"fa fa-bandcamp\",\"orderNum\":5}',68,'0:0:0:0:0:0:0:1','2018-06-04 15:40:47'),(239,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1083,\"parentName\":\"关于管理\",\"name\":\"新增\",\"perms\":\"sysWs:wsabout:add\",\"type\":2,\"orderNum\":0}',90,'0:0:0:0:0:0:0:1','2018-06-04 16:18:25'),(240,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1083,\"parentName\":\"关于管理\",\"name\":\"修改\",\"perms\":\"sysWs:wsabout:update\",\"type\":2,\"orderNum\":0}',57,'0:0:0:0:0:0:0:1','2018-06-04 16:19:08'),(241,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1083,\"parentName\":\"关于管理\",\"name\":\"删除\",\"perms\":\"sysWs:wsabout:delete\",\"type\":2,\"orderNum\":0}',85,'0:0:0:0:0:0:0:1','2018-06-04 16:19:23'),(242,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"动态管理\",\"type\":0,\"icon\":\"fa fa-life-ring\",\"orderNum\":2}',62,'0:0:0:0:0:0:0:1','2018-06-04 17:37:06'),(243,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1087,\"parentName\":\"动态管理\",\"name\":\"动态类型\",\"url\":\"modules/sysEx/wsnewstype.html\",\"perms\":\"sysWs:wsnewstype:list,sysWs:wsnewstype:info\",\"type\":1,\"icon\":\"fa fa-th-list\",\"orderNum\":0}',115,'0:0:0:0:0:0:0:1','2018-06-04 17:39:19'),(244,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1087,\"parentName\":\"动态管理\",\"name\":\"动态列表\",\"url\":\"modules/sysEx/wsnews.html\",\"perms\":\"sysWs:wsnews:info,sysWs:wsnews:list\",\"type\":1,\"icon\":\"fa fa-th-list\",\"orderNum\":1}',77,'0:0:0:0:0:0:0:1','2018-06-04 17:40:20'),(245,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1088,\"parentName\":\"动态类型\",\"name\":\"新增\",\"perms\":\"sysWs:wsnewstype:add\",\"type\":2,\"orderNum\":0}',66,'0:0:0:0:0:0:0:1','2018-06-04 17:41:47'),(246,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1088,\"parentName\":\"动态类型\",\"name\":\"修改\",\"perms\":\"sysWs:wsnewstype:update\",\"type\":2,\"orderNum\":0}',68,'0:0:0:0:0:0:0:1','2018-06-04 17:42:01'),(247,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1088,\"parentName\":\"动态类型\",\"name\":\"删除\",\"perms\":\"sysWs:wsnewstype:delete\",\"type\":2,\"orderNum\":0}',71,'0:0:0:0:0:0:0:1','2018-06-04 17:42:15'),(248,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1089,\"parentName\":\"动态列表\",\"name\":\"新增\",\"perms\":\"sysWs:wsnew:add\",\"type\":2,\"orderNum\":0}',61,'0:0:0:0:0:0:0:1','2018-06-04 17:43:06'),(249,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1089,\"parentName\":\"动态列表\",\"name\":\"修改\",\"perms\":\"sysWs:wsnew:update\",\"type\":2,\"orderNum\":0}',43,'0:0:0:0:0:0:0:1','2018-06-04 17:43:21'),(250,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1089,\"parentName\":\"动态列表\",\"name\":\"删除\",\"perms\":\"sysWs:wsnew:delete\",\"type\":2,\"orderNum\":0}',48,'0:0:0:0:0:0:0:1','2018-06-04 17:43:32'),(251,'admin','修改菜单','com.idou.modules.sysBs.controller.SysMenuController.update()','{\"menuId\":1093,\"parentId\":1089,\"parentName\":\"动态列表\",\"name\":\"新增\",\"perms\":\"sysWs:wsnews:add\",\"type\":2,\"orderNum\":0}',258,'0:0:0:0:0:0:0:1','2018-06-05 09:55:40'),(252,'admin','修改菜单','com.idou.modules.sysBs.controller.SysMenuController.update()','{\"menuId\":1094,\"parentId\":1089,\"parentName\":\"动态列表\",\"name\":\"修改\",\"perms\":\"sysWs:wsnews:update\",\"type\":2,\"orderNum\":0}',77,'0:0:0:0:0:0:0:1','2018-06-05 09:55:49'),(253,'admin','修改菜单','com.idou.modules.sysBs.controller.SysMenuController.update()','{\"menuId\":1095,\"parentId\":1089,\"parentName\":\"动态列表\",\"name\":\"删除\",\"perms\":\"sysWs:wsnews:delete\",\"type\":2,\"orderNum\":0}',62,'0:0:0:0:0:0:0:1','2018-06-05 09:55:58'),(254,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1056,\"parentName\":\"网站管理\",\"name\":\"加入管理\",\"url\":\"modules/sysEx/wsjoin.html\",\"perms\":\"sysWs:wsjoin:info,sysWs:wsjoin:list\",\"type\":1,\"icon\":\"fa fa-th-list\",\"orderNum\":6}',86,'0:0:0:0:0:0:0:1','2018-06-05 15:31:09'),(255,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1096,\"parentName\":\"加入管理\",\"name\":\"新增\",\"perms\":\"sysWs:wsjoin:add\",\"type\":2,\"orderNum\":0}',72,'0:0:0:0:0:0:0:1','2018-06-05 15:31:40'),(256,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1096,\"parentName\":\"加入管理\",\"name\":\"删除\",\"perms\":\"sysWs:wsjoin:delete\",\"type\":2,\"orderNum\":0}',143,'0:0:0:0:0:0:0:1','2018-06-05 15:32:09'),(257,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1056,\"parentName\":\"网站管理\",\"name\":\"联系管理\",\"url\":\"modules/sysEx/wscontact.html\",\"perms\":\"sysWs:wscontact:info,sysWs:wscontact:list\",\"type\":1,\"icon\":\"fa fa-th-list\",\"orderNum\":7}',72,'0:0:0:0:0:0:0:1','2018-06-05 15:33:18'),(258,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1099,\"parentName\":\"联系管理\",\"name\":\"新增\",\"perms\":\"sysWs:wscontact:add\",\"type\":2,\"orderNum\":0}',55,'0:0:0:0:0:0:0:1','2018-06-05 15:35:25'),(259,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1099,\"parentName\":\"联系管理\",\"name\":\"删除\",\"perms\":\"sysWs:wscontact:delete\",\"type\":2,\"orderNum\":0}',45,'0:0:0:0:0:0:0:1','2018-06-05 15:35:37'),(260,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"活动管理\",\"type\":0,\"icon\":\"fa fa-compass\",\"orderNum\":3}',56,'0:0:0:0:0:0:0:1','2018-06-05 16:29:42'),(261,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1102,\"parentName\":\"活动管理\",\"name\":\"活动类型\",\"url\":\"modules/sysEx/wsactivitytype.html\",\"perms\":\"sysWs:wsactivitytype:info,sysWs:wsactivitytype:list\",\"type\":1,\"icon\":\"fa fa-th-list\",\"orderNum\":0}',85,'0:0:0:0:0:0:0:1','2018-06-05 16:30:51'),(262,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1102,\"parentName\":\"活动管理\",\"name\":\"活动列表\",\"url\":\"modules/sysEx/wsactivity.html\",\"perms\":\"sysWs:wsactivity:info,sysWs:wsactivity:list\",\"type\":1,\"icon\":\"fa fa-th-list\",\"orderNum\":1}',91,'0:0:0:0:0:0:0:1','2018-06-05 16:31:35'),(263,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1103,\"parentName\":\"活动类型\",\"name\":\"新增\",\"perms\":\"sysWs:wsactivitytype:add\",\"type\":2,\"orderNum\":0}',46,'0:0:0:0:0:0:0:1','2018-06-05 16:32:07'),(264,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1103,\"parentName\":\"活动类型\",\"name\":\"修改\",\"perms\":\"sysWs:wsactivitytype:update\",\"type\":2,\"orderNum\":0}',64,'0:0:0:0:0:0:0:1','2018-06-05 16:32:21'),(265,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1103,\"parentName\":\"活动类型\",\"name\":\"删除\",\"perms\":\"sysWs:wsactivitytype:delete\",\"type\":2,\"orderNum\":0}',68,'0:0:0:0:0:0:0:1','2018-06-05 16:32:34'),(266,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1104,\"parentName\":\"活动列表\",\"name\":\"新增\",\"perms\":\"sysWs:wsactivity:add\",\"type\":2,\"orderNum\":0}',113,'0:0:0:0:0:0:0:1','2018-06-05 16:32:50'),(267,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1104,\"parentName\":\"活动列表\",\"name\":\"修改\",\"perms\":\"sysWs:wsactivity:update\",\"type\":2,\"orderNum\":0}',67,'0:0:0:0:0:0:0:1','2018-06-05 16:33:04'),(268,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1104,\"parentName\":\"活动列表\",\"name\":\"删除\",\"perms\":\"sysWs:wsactivity:delete\",\"type\":2,\"orderNum\":0}',62,'0:0:0:0:0:0:0:1','2018-06-05 16:33:19'),(269,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1057,\"parentName\":\"基本信息\",\"name\":\"新增\",\"perms\":\"sysWs:baseinfo:add\",\"type\":2,\"orderNum\":0}',127,'0:0:0:0:0:0:0:1','2018-06-06 00:32:16'),(270,'admin','修改菜单','com.idou.modules.sysBs.controller.SysMenuController.update()','{\"menuId\":1057,\"parentId\":1056,\"parentName\":\"网站管理\",\"name\":\"基本信息\",\"url\":\"modules/sysEx/wsbaseinfo.html\",\"perms\":\"sysWs:baseinfo:info\",\"type\":1,\"icon\":\"fa fa-list\",\"orderNum\":0}',127,'0:0:0:0:0:0:0:1','2018-06-06 00:32:35'),(271,'admin','修改菜单','com.idou.modules.sysBs.controller.SysMenuController.update()','{\"menuId\":1057,\"parentId\":1056,\"parentName\":\"网站管理\",\"name\":\"基本信息\",\"url\":\"modules/sysEx/wsbaseinfo.html\",\"perms\":\"sysWs:wsbaseInfo:info\",\"type\":1,\"icon\":\"fa fa-list\",\"orderNum\":0}',123,'0:0:0:0:0:0:0:1','2018-06-06 00:37:55'),(272,'admin','修改菜单','com.idou.modules.sysBs.controller.SysMenuController.update()','{\"menuId\":1111,\"parentId\":1057,\"parentName\":\"基本信息\",\"name\":\"新增\",\"perms\":\"sysWs:wsbaseInfo:add\",\"type\":2,\"orderNum\":0}',119,'0:0:0:0:0:0:0:1','2018-06-06 00:38:10'),(273,'admin','修改角色','com.idou.modules.sysBs.controller.SysRoleController.update()','{\"roleId\":2,\"roleName\":\"网站管理员\",\"createUserId\":1,\"menuIdList\":[1056,1057,1111,1058,1059,1060,1061,1062,1063,1073,1074,1075,1076,1077,1078,1079,1080,1083,1084,1085,1086,1096,1097,1098,1099,1100,1101,1064,1065,1067,1068,1069,1066,1070,1071,1072,1087,1088,1090,1091,1092,1089,1093,1094,1095,1102,1103,1105,1106,1107,1104,1108,1109,1110],\"createTime\":\"May 29, 2018 3:50:10 PM\"}',131,'110.53.179.185','2018-06-06 11:40:36'),(274,'idou','保存用户','com.idou.modules.sysBs.controller.SysUserController.save()','{\"userId\":2,\"username\":\"admin\",\"password\":\"324e2fc76cdd8d66756f3b9922288eba\",\"salt\":\"8d459a5f19a07a3d38166b65d2df0258\",\"email\":\"917661718@qq.com\",\"mobile\":\"18573163183\",\"status\":1,\"roleIdList\":[2],\"createUserId\":1,\"createTime\":\"Jun 6, 2018 11:42:10 AM\"}',56,'110.53.179.185','2018-06-06 11:42:10');

UNLOCK TABLES;

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1112 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

/*Data for the table `sys_menu` */

LOCK TABLES `sys_menu` WRITE;

insert  into `sys_menu`(`menu_id`,`parent_id`,`name`,`url`,`perms`,`type`,`icon`,`order_num`) values (1,0,'系统管理',NULL,NULL,0,'fa fa-cog',999),(2,1,'管理员列表','modules/sysBs/user.html',NULL,1,'fa fa-user',1),(3,1,'角色管理','modules/sysBs/role.html',NULL,1,'fa fa-user-secret',2),(4,1,'菜单管理','modules/sysBs/menu.html',NULL,1,'fa fa-th-list',3),(5,1,'SQL监控','druid/sql.html',NULL,1,'fa fa-bug',4),(15,2,'查看',NULL,'sys:user:list,sys:user:info',2,NULL,0),(16,2,'新增',NULL,'sys:user:save,sys:role:select',2,NULL,0),(17,2,'修改',NULL,'sys:user:update,sys:role:select',2,NULL,0),(18,2,'删除',NULL,'sys:user:delete',2,NULL,0),(19,3,'查看',NULL,'sys:role:list,sys:role:info',2,NULL,0),(20,3,'新增',NULL,'sys:role:save,sys:menu:perms',2,NULL,0),(21,3,'修改',NULL,'sys:role:update,sys:menu:perms',2,NULL,0),(22,3,'删除',NULL,'sys:role:delete',2,NULL,0),(23,4,'查看',NULL,'sys:menu:list,sys:menu:info',2,NULL,0),(24,4,'新增',NULL,'sys:menu:save,sys:menu:select',2,NULL,0),(25,4,'修改',NULL,'sys:menu:update,sys:menu:select',2,NULL,0),(26,4,'删除',NULL,'sys:menu:delete',2,NULL,0),(27,1,'参数管理','modules/sysBs/config.html','sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete',1,'fa fa-sun-o',6),(29,1,'系统日志','modules/sysBs/log.html','sys:log:list',1,'fa fa-file-text-o',7),(1056,0,'网站管理',NULL,NULL,0,'fa fa-product-hunt',0),(1057,1056,'基本信息','modules/sysEx/wsbaseinfo.html','sysWs:wsbaseInfo:info',1,'fa fa-list',0),(1058,1056,'网站菜单','modules/sysEx/wsmenu.html','sysWs:menu:list',1,'fa fa-th-list',1),(1059,1058,'修改',NULL,'sysWs:menu:update',2,NULL,0),(1060,1056,'首页Banner','modules/sysEx/wsbanner.html','sysWs:banner:list,sysWs:banner:info',1,'fa fa-th-list',2),(1061,1060,'新增',NULL,'sysWs:banner:add',2,NULL,0),(1062,1060,'修改',NULL,'sysWs:banner:update',2,NULL,0),(1063,1060,'删除',NULL,'sysWs:banner:del',2,NULL,0),(1064,0,'案例管理',NULL,NULL,0,'fa fa-telegram',1),(1065,1064,'案例类型','modules/sysEx/wscasetype.html','sysWs:wscasetype:list,sysWs:wscasetype:info',1,'fa fa-th-list',0),(1066,1064,'案例列表','modules/sysEx/wscase.html','sysWs:wscase:list,sysWs:wscase:info',1,'fa fa-th-list',1),(1067,1065,'新增',NULL,'sysWs:wscasetype:add',2,NULL,0),(1068,1065,'修改',NULL,'sysWs:wscasetype:update',2,NULL,0),(1069,1065,'删除',NULL,'sysWs:wscasetype:delete',2,NULL,0),(1070,1066,'新增',NULL,'sysWs:wscase:add',2,NULL,0),(1071,1066,'修改',NULL,'sysWs:wscase:update',2,NULL,0),(1072,1066,'删除',NULL,'sysWs:wscase:delete',2,NULL,0),(1073,1056,'友链管理','modules/sysEx/wslinks.html','sysWs:wslinks:list,sysWs:wslinks:info',1,'fa fa-th-list',3),(1074,1073,'新增',NULL,'sysWs:wslinks:add',2,NULL,0),(1075,1073,'修改',NULL,'sysWs:wslinks:update',2,NULL,0),(1076,1073,'删除',NULL,'sysWs:wslinks:delete',2,NULL,0),(1077,1056,'服务管理','modules/sysEx/wsserver.html','sysWs:wsserver:list,sysWs:wsserver:info',1,'fa fa-th-list',4),(1078,1077,'新增',NULL,'sysWs:wsserver:add',2,NULL,0),(1079,1077,'修改',NULL,'sysWs:wsserver:update',2,NULL,0),(1080,1077,'删除',NULL,'sysWs:wsserver:delete',2,NULL,0),(1083,1056,'关于管理','modules/sysEx/wsabout.html','sysWs:wsabout:info,sysWs:wsabout:list',1,'fa fa-bandcamp',5),(1084,1083,'新增',NULL,'sysWs:wsabout:add',2,NULL,0),(1085,1083,'修改',NULL,'sysWs:wsabout:update',2,NULL,0),(1086,1083,'删除',NULL,'sysWs:wsabout:delete',2,NULL,0),(1087,0,'动态管理',NULL,NULL,0,'fa fa-life-ring',2),(1088,1087,'动态类型','modules/sysEx/wsnewstype.html','sysWs:wsnewstype:list,sysWs:wsnewstype:info',1,'fa fa-th-list',0),(1089,1087,'动态列表','modules/sysEx/wsnews.html','sysWs:wsnews:info,sysWs:wsnews:list',1,'fa fa-th-list',1),(1090,1088,'新增',NULL,'sysWs:wsnewstype:add',2,NULL,0),(1091,1088,'修改',NULL,'sysWs:wsnewstype:update',2,NULL,0),(1092,1088,'删除',NULL,'sysWs:wsnewstype:delete',2,NULL,0),(1093,1089,'新增',NULL,'sysWs:wsnews:add',2,NULL,0),(1094,1089,'修改',NULL,'sysWs:wsnews:update',2,NULL,0),(1095,1089,'删除',NULL,'sysWs:wsnews:delete',2,NULL,0),(1096,1056,'加入管理','modules/sysEx/wsjoin.html','sysWs:wsjoin:info,sysWs:wsjoin:list',1,'fa fa-th-list',6),(1097,1096,'新增',NULL,'sysWs:wsjoin:add',2,NULL,0),(1098,1096,'删除',NULL,'sysWs:wsjoin:delete',2,NULL,0),(1099,1056,'联系管理','modules/sysEx/wscontact.html','sysWs:wscontact:info,sysWs:wscontact:list',1,'fa fa-th-list',7),(1100,1099,'新增',NULL,'sysWs:wscontact:add',2,NULL,0),(1101,1099,'删除',NULL,'sysWs:wscontact:delete',2,NULL,0),(1102,0,'活动管理',NULL,NULL,0,'fa fa-compass',3),(1103,1102,'活动类型','modules/sysEx/wsactivitytype.html','sysWs:wsactivitytype:info,sysWs:wsactivitytype:list',1,'fa fa-th-list',0),(1104,1102,'活动列表','modules/sysEx/wsactivity.html','sysWs:wsactivity:info,sysWs:wsactivity:list',1,'fa fa-th-list',1),(1105,1103,'新增',NULL,'sysWs:wsactivitytype:add',2,NULL,0),(1106,1103,'修改',NULL,'sysWs:wsactivitytype:update',2,NULL,0),(1107,1103,'删除',NULL,'sysWs:wsactivitytype:delete',2,NULL,0),(1108,1104,'新增',NULL,'sysWs:wsactivity:add',2,NULL,0),(1109,1104,'修改',NULL,'sysWs:wsactivity:update',2,NULL,0),(1110,1104,'删除',NULL,'sysWs:wsactivity:delete',2,NULL,0),(1111,1057,'新增',NULL,'sysWs:wsbaseInfo:add',2,NULL,0);

UNLOCK TABLES;

/*Table structure for table `sys_oss` */

DROP TABLE IF EXISTS `sys_oss`;

CREATE TABLE `sys_oss` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) DEFAULT NULL COMMENT 'URL地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件上传';

/*Data for the table `sys_oss` */

LOCK TABLES `sys_oss` WRITE;

UNLOCK TABLES;

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色';

/*Data for the table `sys_role` */

LOCK TABLES `sys_role` WRITE;

insert  into `sys_role`(`role_id`,`role_name`,`remark`,`create_user_id`,`create_time`) values (2,'网站管理员',NULL,1,'2018-05-29 15:50:10');

UNLOCK TABLES;

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

/*Data for the table `sys_role_menu` */

LOCK TABLES `sys_role_menu` WRITE;

insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`) values (70,2,1056),(71,2,1057),(72,2,1111),(73,2,1058),(74,2,1059),(75,2,1060),(76,2,1061),(77,2,1062),(78,2,1063),(79,2,1073),(80,2,1074),(81,2,1075),(82,2,1076),(83,2,1077),(84,2,1078),(85,2,1079),(86,2,1080),(87,2,1083),(88,2,1084),(89,2,1085),(90,2,1086),(91,2,1096),(92,2,1097),(93,2,1098),(94,2,1099),(95,2,1100),(96,2,1101),(97,2,1064),(98,2,1065),(99,2,1067),(100,2,1068),(101,2,1069),(102,2,1066),(103,2,1070),(104,2,1071),(105,2,1072),(106,2,1087),(107,2,1088),(108,2,1090),(109,2,1091),(110,2,1092),(111,2,1089),(112,2,1093),(113,2,1094),(114,2,1095),(115,2,1102),(116,2,1103),(117,2,1105),(118,2,1106),(119,2,1107),(120,2,1104),(121,2,1108),(122,2,1109),(123,2,1110);

UNLOCK TABLES;

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名,登录名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(36) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统用户';

/*Data for the table `sys_user` */

LOCK TABLES `sys_user` WRITE;

insert  into `sys_user`(`user_id`,`username`,`password`,`salt`,`email`,`mobile`,`status`,`create_user_id`,`create_time`) values (1,'idou','324e2fc76cdd8d66756f3b9922288eba','eb97d8855d83308471e93df8ee214292','917661718@qq.com','18578785656',1,1,'2016-11-11 11:11:11'),(2,'admin','324e2fc76cdd8d66756f3b9922288eba','eb97d8855d83308471e93df8ee214292','917661718@qq.com','18573163183',1,1,'2018-06-06 11:42:10');

UNLOCK TABLES;

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

/*Data for the table `sys_user_role` */

LOCK TABLES `sys_user_role` WRITE;

insert  into `sys_user_role`(`id`,`user_id`,`role_id`) values (1,2,2);

UNLOCK TABLES;

/*Table structure for table `sys_user_token` */

DROP TABLE IF EXISTS `sys_user_token`;

CREATE TABLE `sys_user_token` (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户Token';

/*Data for the table `sys_user_token` */

LOCK TABLES `sys_user_token` WRITE;

insert  into `sys_user_token`(`user_id`,`token`,`expire_time`,`update_time`) values (1,'dff9fe334cb4e3aae0d926ee61b9dabd','2018-01-13 01:45:15','2018-01-12 13:45:15');

UNLOCK TABLES;

/*Table structure for table `t_ws_about` */

DROP TABLE IF EXISTS `t_ws_about`;

CREATE TABLE `t_ws_about` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cover` varchar(120) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_ws_about` */

LOCK TABLES `t_ws_about` WRITE;

insert  into `t_ws_about`(`id`,`cover`,`createTime`) values (8,'http://39.107.87.101:8088/about/20180606/1528265955248549.jpg','2018-06-06 14:22:53');

UNLOCK TABLES;

/*Table structure for table `t_ws_about_list` */

DROP TABLE IF EXISTS `t_ws_about_list`;

CREATE TABLE `t_ws_about_list` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(36) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_ws_about_list` */

LOCK TABLES `t_ws_about_list` WRITE;

insert  into `t_ws_about_list`(`id`,`title`,`content`) values (5,'村','<p>2131</p><p><img src=\"http://localhost:8088\\about\\20180604\\1528104070603627.jpg\" alt=\"1528104070603627.jpg\"><br></p>'),(4,'2131231','3123123132');

UNLOCK TABLES;

/*Table structure for table `t_ws_activity` */

DROP TABLE IF EXISTS `t_ws_activity`;

CREATE TABLE `t_ws_activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `link` varchar(120) DEFAULT NULL,
  `poll` int(11) DEFAULT '0' COMMENT '票数',
  `typeId` bigint(20) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_ws_activity` */

LOCK TABLES `t_ws_activity` WRITE;

UNLOCK TABLES;

/*Table structure for table `t_ws_activity_type` */

DROP TABLE IF EXISTS `t_ws_activity_type`;

CREATE TABLE `t_ws_activity_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_ws_activity_type` */

LOCK TABLES `t_ws_activity_type` WRITE;

insert  into `t_ws_activity_type`(`id`,`name`,`sortNum`) values (1,'C8动漫CosPlay展 / 2018-05',0),(2,'橘子洲大自然活动 / 2018-03',0);

UNLOCK TABLES;

/*Table structure for table `t_ws_banner` */

DROP TABLE IF EXISTS `t_ws_banner`;

CREATE TABLE `t_ws_banner` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(120) DEFAULT NULL COMMENT 'banner图片路径',
  `mobileUrl` varchar(120) DEFAULT NULL COMMENT 'banner图片路径(mobile)',
  `link` varchar(50) DEFAULT NULL COMMENT 'banner图片链接',
  `sortNum` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10012 DEFAULT CHARSET=utf8;

/*Data for the table `t_ws_banner` */

LOCK TABLES `t_ws_banner` WRITE;

insert  into `t_ws_banner`(`id`,`url`,`mobileUrl`,`link`,`sortNum`) values (10009,'http://39.107.87.101:8088/banner/20180606/1528265955244677.jpg',NULL,NULL,0),(10010,'http://39.107.87.101:8088/banner/20180606/1528265955245048.jpg',NULL,'3',1),(10011,'http://39.107.87.101:8088/banner/20180606/1528265955246354.jpg',NULL,'3',2);

UNLOCK TABLES;

/*Table structure for table `t_ws_baseinfo` */

DROP TABLE IF EXISTS `t_ws_baseinfo`;

CREATE TABLE `t_ws_baseinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `companyName` varchar(120) DEFAULT NULL COMMENT '公司名',
  `logo` varchar(120) DEFAULT NULL COMMENT 'logo',
  `slogan` varchar(50) DEFAULT NULL COMMENT '口号',
  `tel` varchar(16) DEFAULT NULL COMMENT '服务热线',
  `qq` varchar(32) DEFAULT NULL COMMENT 'QQ',
  `serverTime` varchar(32) DEFAULT NULL COMMENT '服务时间',
  `qrCode` varchar(120) DEFAULT NULL COMMENT '二维码',
  `addr` varchar(250) DEFAULT NULL COMMENT '地址',
  `aboutUs` varchar(250) DEFAULT NULL COMMENT '关于我们',
  `copyright` varchar(120) DEFAULT NULL COMMENT '版权信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10026 DEFAULT CHARSET=utf8;

/*Data for the table `t_ws_baseinfo` */

LOCK TABLES `t_ws_baseinfo` WRITE;

insert  into `t_ws_baseinfo`(`id`,`companyName`,`logo`,`slogan`,`tel`,`qq`,`serverTime`,`qrCode`,`addr`,`aboutUs`,`copyright`) values (10025,'致亿文化','http://39.107.87.101:8088/index/20180606/1528256343379200.png','中国最具影响力的品牌策划公司之一中国品牌设计50强','0731-89939868','2387361147','周一~周五 08:30~18:00',NULL,'湖南省长沙市开福区北辰凤凰天阶B1E1区3栋15017室','专注于品牌战略与价值管理，善于从市场和竞争的角度出发，通过行业市场分析与消费者调研，同时结合企业的实际情况，找到精准而差异化的定位，并创造出独特的品牌视觉符号，结合相应的产品、定价、渠道、传播策略。','All Rights Reserved. © 2018-2020 湖南致亿文化传媒有限责任公司. 湘ICP备XXXXXXXX号');

UNLOCK TABLES;

/*Table structure for table `t_ws_case` */

DROP TABLE IF EXISTS `t_ws_case`;

CREATE TABLE `t_ws_case` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `cover` varchar(120) DEFAULT NULL COMMENT '封面',
  `pv` int(11) DEFAULT '0' COMMENT '访问量',
  `content` text COMMENT '内容',
  `typeId` bigint(20) NOT NULL COMMENT '案例类型',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_ws_case` */

LOCK TABLES `t_ws_case` WRITE;

insert  into `t_ws_case`(`id`,`title`,`cover`,`pv`,`content`,`typeId`,`createTime`) values (2,'111','http://39.107.87.101:8088/case/20180606/1528267010838048.jpg',0,'<p>胜多负少的发送到胜多负少的</p>',1,'2018-05-31 19:24:14'),(3,'文章的模拟示范标题','http://39.107.87.101:8088/case/20180606/1528267010837888.jpg',0,'<p><span>&nbsp; &nbsp; &nbsp; 大谷吉继的出身，主要传说是近江和丰后，于此暂采近江一说。众所周知，他同好友三成一起担任秀吉的近侍而崭露头角，关原之前的事迹，在此略过不提。关原一战时，他是五万石的敦贺城主。六月二十一日（日期另有异说）家康征伐会津，他领着一千兵马进军美浓垂井，佐和山的三成遣长子石田重家亲任使者，把他邀入西军。三成久已牵挂着他，听说吉继到达，立刻遣樫原彦右卫门过来求一会面。于是吉继受邀前往佐和山，在那里了解了三成举兵的详情。 　吉继心中以为此时难有胜算，表示了强烈的反对，一度说服三成。但是三成依然决意举兵。到了这个地步，两人之间几乎至于决裂。回到垂井之后他十分烦恼，但到最后，决定为了友情举家相殉。重新集结部队之后，吉继率兵回到了敦贺。</span><br><br></p><p><span>　吉继决定加入三成一方的时候，将名字改成了“吉隆”，这据说是因为“吉继”这个名字与三好义继谐音，而后者有着被信长攻破河内若江城后自刎城头的凶死（《烈祖成绩》）。其实原本从此时开始就应该称他为“大谷吉隆”，但为行文方便，文中将一直使用“吉继”这个通名。 　《改正三河后风土记》里，改名之前称其为“吉继”，改名之后则称为“吉隆”，区分得清清楚楚。大谷在关原町山中之墓的说明板上也是写成“吉隆”的。 　在敦贺整军以待的吉继，以最快速度准备防卫前田利长的南下，以下情节在前文《大圣寺城之战》及《浅井畷之战》中有所介绍。确认前田军已返金泽后，吉继应三成的邀请从敦贺出兵，九月二日抵关原西面的山中村宫上地方，扎下营盘。然而，名义上可称为北陆方面总大将的京极高次非但行军晚了一天，且根本不曾到达美浓，而是突然变向折回居城大津城，死守不出。</span></p><p style=\"text-align: center;\"><span><img src=\"http://39.107.87.101:8088/case/20180606/1528267010836810.jpg\" alt=\"1528267010836810.jpg\"><br></span></p><p style=\"text-align: center;\"></p><p style=\"text-align: center;\"><span style=\"text-align: left;\">&nbsp; &nbsp; &nbsp; &nbsp;大谷吉继的出身，主要传说是近江和丰后，于此暂采近江一说。众所周知，他同好友三成一起担任秀吉的近侍而崭露头角，关原之前的事迹，在此略过不提。关原一战时，他是五万石的敦贺城主。六月二十一日（日期另有异说）家康征伐会津，他领着一千兵马进军美浓垂井，佐和山的三成遣长子石田重家亲任使者，把他邀入西军。三成久已牵挂着他，听说吉继到达，立刻遣樫原彦右卫门过来求一会面。于是吉继受邀前往佐和山，在那里了解了三成举兵的详情。 　吉继心中以为此时难有胜算，表示了强烈的反对，一度说服三成。但是三成依然决意举兵。到了这个地步，两人之间几乎至于决裂。回到垂井之后他十分烦恼，但到最后，决定为了友情举家相殉。重新集结部队之后，吉继率兵回到了敦贺。</span><br></p><p style=\"text-align: left;\">　吉继决定加入三成一方的时候，将名字改成了“吉隆”，这据说是因为“吉继”这个名字与三好义继谐音，而后者有着被信长攻破河内若江城后自刎城头的凶死（《烈祖成绩》）。其实原本从此时开始就应该称他为“大谷吉隆”，但为行文方便，文中将一直使用“吉继”这个通名。 　《改正三河后风土记》里，改名之前称其为“吉继”，改名之后则称为“吉隆”，区分得清清楚楚。大谷在关原町山中之墓的说明板上也是写成“吉隆”的。 　在敦贺整军以待的吉继，以最快速度准备防卫前田利长的南下，以下情节在前文《大圣寺城之战》及《浅井畷之战》中有所介绍。确认前田军已返金泽后，吉继应三成的邀请从敦贺出兵，九月二日抵关原西面的山中村宫上地方，扎下营盘。然而，名义上可称为北陆方面总大将的京极高次非但行军晚了一天，且根本不曾到达美浓，而是突然变向折回居城大津城，死守不出。</p><p></p><p></p><p></p>',1,'2018-06-02 13:47:02');

UNLOCK TABLES;

/*Table structure for table `t_ws_case_type` */

DROP TABLE IF EXISTS `t_ws_case_type`;

CREATE TABLE `t_ws_case_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '案例类型名称',
  `sortNum` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_ws_case_type` */

LOCK TABLES `t_ws_case_type` WRITE;

insert  into `t_ws_case_type`(`id`,`name`,`sortNum`) values (1,'案例类型一',1),(4,'案例类型二',1);

UNLOCK TABLES;

/*Table structure for table `t_ws_contact` */

DROP TABLE IF EXISTS `t_ws_contact`;

CREATE TABLE `t_ws_contact` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tel1` varchar(16) DEFAULT NULL COMMENT '总机电话',
  `tel2` varchar(16) DEFAULT NULL COMMENT '电话',
  `fax` varchar(16) DEFAULT NULL COMMENT '传真',
  `email` varchar(36) DEFAULT NULL COMMENT '邮箱',
  `addr` varchar(120) DEFAULT NULL COMMENT '地址',
  `addrPic` varchar(120) DEFAULT NULL COMMENT '地址图片',
  `workTime` varchar(36) DEFAULT NULL COMMENT '工作时间',
  `banner` varchar(120) DEFAULT NULL COMMENT 'banner',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_ws_contact` */

LOCK TABLES `t_ws_contact` WRITE;

insert  into `t_ws_contact`(`id`,`tel1`,`tel2`,`fax`,`email`,`addr`,`addrPic`,`workTime`,`banner`) values (2,'400-888-8888','0731-8888888','0731-888888','zhiyi@163.com','湖南长沙开福区普瑞金大道518号 XX大楼14栋2704室（1号线往开福区政府方向-北辰三角洲站下车，第1出口步行200米即达） ','http://localhost:8088\\contact\\20180605\\1528187225429010.jpg','周一至周五：08:30~18:00','http://localhost:8088\\contact\\20180605\\1528187225428837.jpg');

UNLOCK TABLES;

/*Table structure for table `t_ws_join` */

DROP TABLE IF EXISTS `t_ws_join`;

CREATE TABLE `t_ws_join` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cover` varchar(120) DEFAULT NULL,
  `content` text,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `t_ws_join` */

LOCK TABLES `t_ws_join` WRITE;

insert  into `t_ws_join`(`id`,`cover`,`content`,`createTime`) values (9,NULL,'                        <p><img src=\"http://39.107.87.101:8088/join/20180606/1528267010834971.jpg\" alt=\"1528267010834971.jpg\"></p><p><img src=\"http://39.107.87.101:8088/join/20180606/1528267010835316.jpg\" alt=\"1528267010835316.jpg\"><br></p>','2018-06-06 14:36:58');

UNLOCK TABLES;

/*Table structure for table `t_ws_links` */

DROP TABLE IF EXISTS `t_ws_links`;

CREATE TABLE `t_ws_links` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '网址名',
  `url` varchar(50) NOT NULL COMMENT '网址链接',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_ws_links` */

LOCK TABLES `t_ws_links` WRITE;

insert  into `t_ws_links`(`id`,`name`,`url`,`createTime`) values (2,'百度','http://www.baidu.com','2018-06-02 12:51:49'),(3,'谷歌','http://www.google.com','2018-06-06 14:20:38');

UNLOCK TABLES;

/*Table structure for table `t_ws_menu` */

DROP TABLE IF EXISTS `t_ws_menu`;

CREATE TABLE `t_ws_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL COMMENT '菜单名',
  `alias` varchar(20) DEFAULT NULL COMMENT '别名',
  `sortNum` int(11) NOT NULL COMMENT '排序号',
  `usable` tinyint(4) DEFAULT '0' COMMENT '0:可用，1不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10008 DEFAULT CHARSET=utf8;

/*Data for the table `t_ws_menu` */

LOCK TABLES `t_ws_menu` WRITE;

insert  into `t_ws_menu`(`id`,`name`,`alias`,`sortNum`,`usable`) values (10000,'首页','home',1,0),(10001,'案例','case',2,0),(10002,'服务','service',3,0),(10003,'关于','about',4,0),(10004,'活动','active',5,0),(10005,'动态','news',6,0),(10006,'加入','join',7,0),(10007,'联系','contact',8,0);

UNLOCK TABLES;

/*Table structure for table `t_ws_news` */

DROP TABLE IF EXISTS `t_ws_news`;

CREATE TABLE `t_ws_news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(120) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `pv` int(11) DEFAULT '0',
  `typeId` bigint(20) NOT NULL COMMENT '类型ID',
  `cover` varchar(120) DEFAULT NULL COMMENT '封面',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_ws_news` */

LOCK TABLES `t_ws_news` WRITE;

insert  into `t_ws_news`(`id`,`title`,`content`,`pv`,`typeId`,`cover`,`createTime`) values (1,'致亿合作伙伴XXX在第23届长沙美博会（CCE）盛大展出2','<p><span>2018年第23届上海美博会（CBE）于5月22至24日在上海新国际博览中心举行，致亿合作伙伴龙美科技在C1馆D16展位盛大展出，植然方适将真实的石斛生长环境和石斛森林搬到了美博会现场，让更多人完美感受了植然方适带给大家的珍稀植物之旅，并异地还原一个更高级的自然药房，让自然之方历历在现2</span></p>',0,1,'http://localhost:8088\\news\\20180605\\1528165333346760.jpg',NULL);

UNLOCK TABLES;

/*Table structure for table `t_ws_news_type` */

DROP TABLE IF EXISTS `t_ws_news_type`;

CREATE TABLE `t_ws_news_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(36) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_ws_news_type` */

LOCK TABLES `t_ws_news_type` WRITE;

insert  into `t_ws_news_type`(`id`,`name`,`sortNum`) values (1,'精彩资讯 / wonderful info',0),(2,'行业新闻 / industry news',1);

UNLOCK TABLES;

/*Table structure for table `t_ws_server` */

DROP TABLE IF EXISTS `t_ws_server`;

CREATE TABLE `t_ws_server` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_ws_server` */

LOCK TABLES `t_ws_server` WRITE;

insert  into `t_ws_server`(`id`,`title`,`content`,`createTime`) values (2,'我们能做啥','                                                <p style=\"text-align: center;\">专注为企业解决品牌盈利问题</p><p style=\"text-align: center;\">坚持专项调研，精准诊断，量身定制</p><p style=\"text-align: center;\"><img src=\"http://39.107.87.101:8088/server/20180606/1528265955247700.jpg\" alt=\"1528265955247700.jpg\"><br></p>\n                    \n                    ','2018-06-06 14:21:30');

UNLOCK TABLES;

/* Procedure structure for procedure `execute_todayRob` */

/*!50003 DROP PROCEDURE IF EXISTS  `execute_todayRob` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `execute_todayRob`(
  IN v_orderNo VARCHAR (36),
  IN v_itemId BIGINT,
  IN v_orderNum INT,
  IN v_orderMoney DECIMAL (5, 2),
  IN v_addressId BIGINT,
  IN v_userId BIGINT,
  IN v_receiver VARCHAR (20),
  IN v_tel VARCHAR (11),
  IN v_payType INT,
  in v_createTime date,
  IN v_expireTime DATE,
  OUT r_result INT
)
BEGIN
  DECLARE insert_count INT DEFAULT 0 ;
  declare now_time date default now();
  START TRANSACTION ;
  INSERT IGNORE INTO `t_order` (
    `orderNo`,
    `itemId`,
    `orderNum`,
    `orderMoney`,
    `addressId`,
    `userId`,
    `receiver`,
    `tel`,
    `payType`,
    `createTime`,
    `expireTime`
  ) 
  VALUES
    (
      v_orderNo,
      v_itemId,
      v_orderNum,
      v_orderMoney,
      v_addressId,
      v_userId,
      v_receiver,
      v_tel,
      v_payType,
      v_createTime,
      v_expireTime
    ) ;
  SELECT 
    ROW_COUNT() INTO insert_count ;
  IF(insert_count = 0) 
  THEN ROLLBACK ;
  SET r_result = - 1 ;
  ELSEIF (insert_count < 0) 
  THEN ROLLBACK ;
  SET r_result = - 2 ;
  ELSE 
  UPDATE 
    `t_item_sku` 
  SET
    `stock` = stock - v_orderNum,
    `saleNum` = saleNum + v_orderNum 
  WHERE `stock` > 0 
    AND `itemId` = v_itemId ;
  SELECT 
    ROW_COUNT() INTO insert_count ;
  IF(insert_count = 0) 
  THEN ROLLBACK ;
  SET r_result = 0 ;
  ELSEIF (insert_count < 0) 
  THEN ROLLBACK ;
  SET r_result = - 2 ;
  ELSE 
  UPDATE 
    `t_item` 
  SET
    `SPUSaleNum` = `SPUSaleNum` + v_orderNum 
  WHERE `id` = v_itemId ;
  SELECT 
    ROW_COUNT() INTO insert_count ;
  IF(insert_count = 0) 
  THEN ROLLBACK ;
  SET r_result = 0 ;
  ELSEIF (insert_count < 0) 
  THEN ROLLBACK ;
  SET r_result = - 2 ;
  ELSE COMMIT ;
  SET r_result = 1 ;
  END IF ;
  END IF ;
  END IF ;
END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

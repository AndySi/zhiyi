/*
SQLyog Ultimate v9.30 
MySQL - 5.6.34-log : Database - zhiyi
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
) ENGINE=InnoDB AUTO_INCREMENT=242 DEFAULT CHARSET=utf8 COMMENT='系统日志';

/*Data for the table `sys_log` */

LOCK TABLES `sys_log` WRITE;

insert  into `sys_log`(`id`,`username`,`operation`,`method`,`params`,`time`,`ip`,`create_date`) values (198,'admin','修改定时任务','com.idou.modules.job.controller.ScheduleJobController.update()','{\"jobId\":1,\"beanName\":\"testTask\",\"methodName\":\"test\",\"params\":\"idou\",\"cronExpression\":\"0 0/30 * * * ?\",\"status\":0,\"remark\":\"有参数测试\",\"createTime\":\"Dec 1, 2016 11:16:46 PM\"}',448,'0:0:0:0:0:0:0:1','2018-01-11 11:34:39'),(199,'admin','立即执行任务','com.idou.modules.job.controller.ScheduleJobController.run()','[1]',286,'0:0:0:0:0:0:0:1','2018-01-11 14:23:36'),(200,'admin','立即执行任务','com.idou.modules.job.controller.ScheduleJobController.run()','[1]',55,'0:0:0:0:0:0:0:1','2018-01-11 14:27:01'),(201,'admin','立即执行任务','com.idou.modules.job.controller.ScheduleJobController.run()','[1]',4557,'0:0:0:0:0:0:0:1','2018-01-11 14:38:30'),(202,'admin','立即执行任务','com.idou.modules.job.controller.ScheduleJobController.run()','[1]',97,'0:0:0:0:0:0:0:1','2018-01-11 14:39:14'),(203,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"网站管理\",\"type\":0,\"icon\":\"fa fa-product-hunt\",\"orderNum\":0}',57,'0:0:0:0:0:0:0:1','2018-05-29 15:23:07'),(204,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1056,\"parentName\":\"网站管理\",\"name\":\"基本信息\",\"url\":\"modules/sysEx/baseInfo.html\",\"perms\":\"sysWs:baseinfo:info\",\"type\":1,\"icon\":\"fa fa-list\",\"orderNum\":0}',64,'0:0:0:0:0:0:0:1','2018-05-29 15:31:20'),(205,'admin','保存角色','com.idou.modules.sysBs.controller.SysRoleController.save()','{\"roleId\":2,\"roleName\":\"网站管理员\",\"createUserId\":1,\"menuIdList\":[1056,1057],\"createTime\":\"May 29, 2018 3:50:10 PM\"}',134,'0:0:0:0:0:0:0:1','2018-05-29 15:50:10'),(206,'admin','删除角色','com.idou.modules.sysBs.controller.SysRoleController.delete()','[1]',68,'0:0:0:0:0:0:0:1','2018-05-29 15:50:17'),(207,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1056,\"parentName\":\"网站管理\",\"name\":\"网站菜单\",\"url\":\"modules/sysEx/menu.html\",\"perms\":\"sysWs:menu:info\",\"type\":1,\"icon\":\"fa fa-th-list\",\"orderNum\":1}',55,'0:0:0:0:0:0:0:1','2018-05-29 15:55:00'),(208,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1058,\"parentName\":\"网站菜单\",\"name\":\"修改\",\"perms\":\"sysWs:menu:update\",\"type\":2,\"orderNum\":0}',63,'0:0:0:0:0:0:0:1','2018-05-30 11:00:13'),(209,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1056,\"parentName\":\"网站管理\",\"name\":\"首页Banner\",\"url\":\"modules/sysEx/wsbanner.html\",\"perms\":\"sysWs:banner:list\",\"type\":1,\"icon\":\"fa fa-th-list\",\"orderNum\":2}',58,'0:0:0:0:0:0:0:1','2018-05-30 11:16:25'),(210,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1060,\"parentName\":\"首页Banner\",\"name\":\"新增\",\"perms\":\"sysWs:banner:add\",\"type\":2,\"orderNum\":0}',47,'0:0:0:0:0:0:0:1','2018-05-30 11:17:46'),(211,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1060,\"parentName\":\"首页Banner\",\"name\":\"修改\",\"perms\":\"sysWs:banner:update\",\"type\":2,\"orderNum\":0}',48,'0:0:0:0:0:0:0:1','2018-05-30 11:18:02'),(212,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1060,\"parentName\":\"首页Banner\",\"name\":\"删除\",\"perms\":\"sysWs:banner:del\",\"type\":2,\"orderNum\":0}',62,'0:0:0:0:0:0:0:1','2018-05-30 11:18:17'),(213,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"案例管理\",\"type\":0,\"icon\":\"fa fa-telegram\",\"orderNum\":1}',67,'0:0:0:0:0:0:0:1','2018-05-30 15:23:54'),(214,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1064,\"parentName\":\"案例管理\",\"name\":\"案例类型\",\"url\":\"modules/sysEx/wscasetype.html\",\"perms\":\"sysWs:wscasetype:list,sysWs:wscasetype:info\",\"type\":1,\"icon\":\"fa fa-th-list\",\"orderNum\":0}',63,'0:0:0:0:0:0:0:1','2018-05-30 15:27:01'),(215,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1064,\"parentName\":\"案例管理\",\"name\":\"案例列表\",\"url\":\"modules/sysEx/wscase.html\",\"perms\":\"sysWs:wscase:list,sysWs:wscase:info\",\"type\":1,\"icon\":\"fa fa-th-list\",\"orderNum\":1}',71,'0:0:0:0:0:0:0:1','2018-05-30 15:28:09'),(216,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1065,\"parentName\":\"案例类型\",\"name\":\"新增\",\"perms\":\"sysWs:wscasetype:add\",\"type\":2,\"orderNum\":0}',109,'0:0:0:0:0:0:0:1','2018-05-30 15:47:53'),(217,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1065,\"parentName\":\"案例类型\",\"name\":\"修改\",\"perms\":\"sysWs:wscasetype:update\",\"type\":2,\"orderNum\":0}',56,'0:0:0:0:0:0:0:1','2018-05-30 15:48:10'),(218,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1065,\"parentName\":\"案例类型\",\"name\":\"删除\",\"perms\":\"sysWs:wscasetype:delete\",\"type\":2,\"orderNum\":0}',54,'0:0:0:0:0:0:0:1','2018-05-30 15:48:26'),(219,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1066,\"parentName\":\"案例列表\",\"name\":\"新增\",\"perms\":\"sysWs:wscase:add\",\"type\":2,\"orderNum\":0}',212,'0:0:0:0:0:0:0:1','2018-05-30 17:25:02'),(220,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1066,\"parentName\":\"案例列表\",\"name\":\"修改\",\"perms\":\"sysWs:wscase:update\",\"type\":2,\"orderNum\":0}',65,'0:0:0:0:0:0:0:1','2018-05-30 17:25:18'),(221,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1066,\"parentName\":\"案例列表\",\"name\":\"删除\",\"perms\":\"sysWs:wscase:delete\",\"type\":2,\"orderNum\":0}',65,'0:0:0:0:0:0:0:1','2018-05-30 17:25:32'),(222,'admin','删除产品信息','com.idou.modules.wechat.controller.WxItemController.delete()','[2]',11,'0:0:0:0:0:0:0:1','2018-05-31 20:26:54'),(223,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1056,\"parentName\":\"网站管理\",\"name\":\"友链管理\",\"url\":\"modules/sysEx/wslinks.html\",\"perms\":\"sysWs:wslinks:list,sysWs:wslinks:info\",\"type\":1,\"icon\":\"fas fa-anchor\",\"orderNum\":3}',40,'0:0:0:0:0:0:0:1','2018-06-02 09:35:45'),(224,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1073,\"parentName\":\"友链管理\",\"name\":\"新增\",\"perms\":\"sysWs:wslinks:add\",\"type\":2,\"orderNum\":0}',42,'0:0:0:0:0:0:0:1','2018-06-02 09:36:51'),(225,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1073,\"parentName\":\"友链管理\",\"name\":\"修改\",\"perms\":\"sysWs:wslinks:update\",\"type\":2,\"orderNum\":0}',44,'0:0:0:0:0:0:0:1','2018-06-02 09:37:07'),(226,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1073,\"parentName\":\"友链管理\",\"name\":\"删除\",\"perms\":\"sysWs:wslinks:delete\",\"type\":2,\"orderNum\":0}',46,'0:0:0:0:0:0:0:1','2018-06-02 09:37:22'),(227,'admin','删除菜单','com.idou.modules.sysBs.controller.SysMenuController.delete()','1026',2,'0:0:0:0:0:0:0:1','2018-06-02 12:54:27'),(228,'admin','删除菜单','com.idou.modules.sysBs.controller.SysMenuController.delete()','1026',3,'0:0:0:0:0:0:0:1','2018-06-02 12:54:30'),(229,'admin','删除菜单','com.idou.modules.sysBs.controller.SysMenuController.delete()','1029',3,'0:0:0:0:0:0:0:1','2018-06-02 12:54:38'),(230,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1056,\"parentName\":\"网站管理\",\"name\":\"服务管理\",\"url\":\"modules/sysEx/wsserver.html\",\"perms\":\"sysWs:wsserver:list,sysWs:wsserver:info\",\"type\":1,\"icon\":\"fa fa-th-list\",\"orderNum\":4}',46,'0:0:0:0:0:0:0:1','2018-06-02 13:26:35'),(231,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1077,\"parentName\":\"服务管理\",\"name\":\"新增\",\"perms\":\"sysWs:wsserver:add\",\"type\":2,\"orderNum\":0}',64,'0:0:0:0:0:0:0:1','2018-06-02 13:27:13'),(232,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1077,\"parentName\":\"服务管理\",\"name\":\"修改\",\"perms\":\"sysWs:wsserver:update\",\"type\":2,\"orderNum\":0}',47,'0:0:0:0:0:0:0:1','2018-06-02 13:27:26'),(233,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1077,\"parentName\":\"服务管理\",\"name\":\"删除\",\"perms\":\"sysWs:wsserver:delete\",\"type\":2,\"orderNum\":0}',48,'0:0:0:0:0:0:0:1','2018-06-02 13:27:54'),(234,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"关于管理\",\"type\":0,\"icon\":\"fas fa-universal-access\",\"orderNum\":3}',70,'0:0:0:0:0:0:0:1','2018-06-04 15:18:38'),(235,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1081,\"parentName\":\"关于管理\",\"name\":\"封面管理\",\"url\":\"modules/sysEx/wsabout.html\",\"perms\":\"sysWs:wsabout:info,sysWs:wsabout:list\",\"type\":1,\"icon\":\"fa fa-file-image-o\",\"orderNum\":0}',75,'0:0:0:0:0:0:0:1','2018-06-04 15:38:10'),(236,'admin','删除菜单','com.idou.modules.sysBs.controller.SysMenuController.delete()','1082',126,'0:0:0:0:0:0:0:1','2018-06-04 15:39:23'),(237,'admin','删除菜单','com.idou.modules.sysBs.controller.SysMenuController.delete()','1081',69,'0:0:0:0:0:0:0:1','2018-06-04 15:39:28'),(238,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1056,\"parentName\":\"网站管理\",\"name\":\"关于管理\",\"url\":\"modules/sysEx/wsabout.html\",\"perms\":\"sysWs:wsabout:info,sysWs:wsabout:list\",\"type\":1,\"icon\":\"fa fa-bandcamp\",\"orderNum\":5}',68,'0:0:0:0:0:0:0:1','2018-06-04 15:40:47'),(239,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1083,\"parentName\":\"关于管理\",\"name\":\"新增\",\"perms\":\"sysWs:wsabout:add\",\"type\":2,\"orderNum\":0}',90,'0:0:0:0:0:0:0:1','2018-06-04 16:18:25'),(240,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1083,\"parentName\":\"关于管理\",\"name\":\"修改\",\"perms\":\"sysWs:wsabout:update\",\"type\":2,\"orderNum\":0}',57,'0:0:0:0:0:0:0:1','2018-06-04 16:19:08'),(241,'admin','保存菜单','com.idou.modules.sysBs.controller.SysMenuController.save()','{\"parentId\":1083,\"parentName\":\"关于管理\",\"name\":\"删除\",\"perms\":\"sysWs:wsabout:delete\",\"type\":2,\"orderNum\":0}',85,'0:0:0:0:0:0:0:1','2018-06-04 16:19:23');

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
) ENGINE=InnoDB AUTO_INCREMENT=1087 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

/*Data for the table `sys_menu` */

LOCK TABLES `sys_menu` WRITE;

insert  into `sys_menu`(`menu_id`,`parent_id`,`name`,`url`,`perms`,`type`,`icon`,`order_num`) values (1,0,'系统管理',NULL,NULL,0,'fa fa-cog',999),(2,1,'管理员列表','modules/sysBs/user.html',NULL,1,'fa fa-user',1),(3,1,'角色管理','modules/sysBs/role.html',NULL,1,'fa fa-user-secret',2),(4,1,'菜单管理','modules/sysBs/menu.html',NULL,1,'fa fa-th-list',3),(5,1,'SQL监控','druid/sql.html',NULL,1,'fa fa-bug',4),(15,2,'查看',NULL,'sys:user:list,sys:user:info',2,NULL,0),(16,2,'新增',NULL,'sys:user:save,sys:role:select',2,NULL,0),(17,2,'修改',NULL,'sys:user:update,sys:role:select',2,NULL,0),(18,2,'删除',NULL,'sys:user:delete',2,NULL,0),(19,3,'查看',NULL,'sys:role:list,sys:role:info',2,NULL,0),(20,3,'新增',NULL,'sys:role:save,sys:menu:perms',2,NULL,0),(21,3,'修改',NULL,'sys:role:update,sys:menu:perms',2,NULL,0),(22,3,'删除',NULL,'sys:role:delete',2,NULL,0),(23,4,'查看',NULL,'sys:menu:list,sys:menu:info',2,NULL,0),(24,4,'新增',NULL,'sys:menu:save,sys:menu:select',2,NULL,0),(25,4,'修改',NULL,'sys:menu:update,sys:menu:select',2,NULL,0),(26,4,'删除',NULL,'sys:menu:delete',2,NULL,0),(27,1,'参数管理','modules/sysBs/config.html','sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete',1,'fa fa-sun-o',6),(29,1,'系统日志','modules/sysBs/log.html','sys:log:list',1,'fa fa-file-text-o',7),(1056,0,'网站管理',NULL,NULL,0,'fa fa-product-hunt',0),(1057,1056,'基本信息','modules/sysEx/wsbaseinfo.html','sysWs:baseinfo:info,sysWs:baseinfo:save',1,'fa fa-list',0),(1058,1056,'网站菜单','modules/sysEx/wsmenu.html','sysWs:menu:list',1,'fa fa-th-list',1),(1059,1058,'修改',NULL,'sysWs:menu:update',2,NULL,0),(1060,1056,'首页Banner','modules/sysEx/wsbanner.html','sysWs:banner:list,sysWs:banner:info',1,'fa fa-th-list',2),(1061,1060,'新增',NULL,'sysWs:banner:add',2,NULL,0),(1062,1060,'修改',NULL,'sysWs:banner:update',2,NULL,0),(1063,1060,'删除',NULL,'sysWs:banner:del',2,NULL,0),(1064,0,'案例管理',NULL,NULL,0,'fa fa-telegram',1),(1065,1064,'案例类型','modules/sysEx/wscasetype.html','sysWs:wscasetype:list,sysWs:wscasetype:info',1,'fa fa-th-list',0),(1066,1064,'案例列表','modules/sysEx/wscase.html','sysWs:wscase:list,sysWs:wscase:info',1,'fa fa-th-list',1),(1067,1065,'新增',NULL,'sysWs:wscasetype:add',2,NULL,0),(1068,1065,'修改',NULL,'sysWs:wscasetype:update',2,NULL,0),(1069,1065,'删除',NULL,'sysWs:wscasetype:delete',2,NULL,0),(1070,1066,'新增',NULL,'sysWs:wscase:add',2,NULL,0),(1071,1066,'修改',NULL,'sysWs:wscase:update',2,NULL,0),(1072,1066,'删除',NULL,'sysWs:wscase:delete',2,NULL,0),(1073,1056,'友链管理','modules/sysEx/wslinks.html','sysWs:wslinks:list,sysWs:wslinks:info',1,'fa fa-th-list',3),(1074,1073,'新增',NULL,'sysWs:wslinks:add',2,NULL,0),(1075,1073,'修改',NULL,'sysWs:wslinks:update',2,NULL,0),(1076,1073,'删除',NULL,'sysWs:wslinks:delete',2,NULL,0),(1077,1056,'服务管理','modules/sysEx/wsserver.html','sysWs:wsserver:list,sysWs:wsserver:info',1,'fa fa-th-list',4),(1078,1077,'新增',NULL,'sysWs:wsserver:add',2,NULL,0),(1079,1077,'修改',NULL,'sysWs:wsserver:update',2,NULL,0),(1080,1077,'删除',NULL,'sysWs:wsserver:delete',2,NULL,0),(1083,1056,'关于管理','modules/sysEx/wsabout.html','sysWs:wsabout:info,sysWs:wsabout:list',1,'fa fa-bandcamp',5),(1084,1083,'新增',NULL,'sysWs:wsabout:add',2,NULL,0),(1085,1083,'修改',NULL,'sysWs:wsabout:update',2,NULL,0),(1086,1083,'删除',NULL,'sysWs:wsabout:delete',2,NULL,0);

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
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

/*Data for the table `sys_role_menu` */

LOCK TABLES `sys_role_menu` WRITE;

insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`) values (68,2,1056),(69,2,1057);

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统用户';

/*Data for the table `sys_user` */

LOCK TABLES `sys_user` WRITE;

insert  into `sys_user`(`user_id`,`username`,`password`,`salt`,`email`,`mobile`,`status`,`create_user_id`,`create_time`) values (1,'admin','324e2fc76cdd8d66756f3b9922288eba','eb97d8855d83308471e93df8ee214292','917661718@qq.com','18578785656',1,1,'2016-11-11 11:11:11');

UNLOCK TABLES;

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

/*Data for the table `sys_user_role` */

LOCK TABLES `sys_user_role` WRITE;

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

/*Table structure for table `t_activity` */

DROP TABLE IF EXISTS `t_activity`;

CREATE TABLE `t_activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL COMMENT '活动名称',
  `startTime` datetime DEFAULT NULL COMMENT '活动开始时间',
  `endTime` datetime DEFAULT NULL COMMENT '活动结束时间',
  `sendTime` datetime DEFAULT NULL COMMENT '预计发货时间',
  `createTime` datetime DEFAULT NULL COMMENT '活动创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_time` (`startTime`,`endTime`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_activity` */

LOCK TABLES `t_activity` WRITE;

insert  into `t_activity`(`id`,`name`,`startTime`,`endTime`,`sendTime`,`createTime`) values (1,'今日必抢','2018-01-12 00:00:00','2018-01-22 00:00:00','2017-12-08 20:39:51','2017-12-05 20:39:54');

UNLOCK TABLES;

/*Table structure for table `t_activity_item` */

DROP TABLE IF EXISTS `t_activity_item`;

CREATE TABLE `t_activity_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activityId` bigint(20) NOT NULL,
  `itemId` bigint(20) NOT NULL,
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `t_activity_item` */

LOCK TABLES `t_activity_item` WRITE;

insert  into `t_activity_item`(`id`,`activityId`,`itemId`,`createTime`) values (2,1,2,'2017-11-26 10:50:37'),(3,1,5,'2017-12-30 12:01:03'),(4,1,7,'2017-12-30 12:20:25'),(5,1,8,'2017-12-30 12:20:25'),(6,1,9,'2017-12-30 12:20:25'),(7,1,10,'2017-12-30 12:20:25');

UNLOCK TABLES;

/*Table structure for table `t_address` */

DROP TABLE IF EXISTS `t_address`;

CREATE TABLE `t_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tel` varchar(11) DEFAULT NULL COMMENT '收货人电话号码',
  `uName` varchar(20) DEFAULT NULL COMMENT '收货人姓名',
  `userId` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `address` varchar(250) DEFAULT NULL COMMENT '收货人地址',
  `isDefault` tinyint(1) DEFAULT '1' COMMENT '是否默认（0：默认，1：不默认）',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `t_address` */

LOCK TABLES `t_address` WRITE;

insert  into `t_address`(`id`,`tel`,`uName`,`userId`,`address`,`isDefault`,`createTime`) values (4,'18576124512','张三',1,'湖南湘潭',1,'2017-12-07 16:41:52'),(10,'18133333333','鬼武者',1,'山西省 长治市 长治县1111',1,'2018-01-12 12:25:52'),(11,'18133212312','丰臣秀吉',1,'河北省 秦皇岛市 山海关区404栋',1,'2018-01-12 12:26:26'),(12,'18193221233','芳兰',1,'内蒙古自治区 通辽市 开鲁县404栋',1,'2018-01-12 12:27:59'),(13,'18167322112','蓝胶儿',1,'内蒙古自治区 通辽市 科尔沁左翼后旗404号',1,'2018-01-12 12:33:05');

UNLOCK TABLES;

/*Table structure for table `t_attr_name` */

DROP TABLE IF EXISTS `t_attr_name`;

CREATE TABLE `t_attr_name` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '属性名编号',
  `name` varchar(20) DEFAULT NULL COMMENT '商品分类编号',
  `itemTypeId` bigint(20) DEFAULT NULL COMMENT '属性名',
  `pid` bigint(20) DEFAULT '0' COMMENT '父属性编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_attr_name` */

LOCK TABLES `t_attr_name` WRITE;

insert  into `t_attr_name`(`id`,`name`,`itemTypeId`,`pid`) values (1,'规格',1,0),(3,'规格',2,0);

UNLOCK TABLES;

/*Table structure for table `t_attr_value` */

DROP TABLE IF EXISTS `t_attr_value`;

CREATE TABLE `t_attr_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '属性值编号',
  `value` varchar(50) DEFAULT NULL COMMENT '属性值',
  `nameId` bigint(20) DEFAULT NULL COMMENT '属性名编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_attr_value` */

LOCK TABLES `t_attr_value` WRITE;

insert  into `t_attr_value`(`id`,`value`,`nameId`) values (1,'普通商品',1),(2,'普通商品',3);

UNLOCK TABLES;

/*Table structure for table `t_banner` */

DROP TABLE IF EXISTS `t_banner`;

CREATE TABLE `t_banner` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `imgUrl` varchar(60) DEFAULT NULL,
  `statu` tinyint(11) DEFAULT '0' COMMENT '是否上架（0:否，1：是）',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_banner` */

LOCK TABLES `t_banner` WRITE;

insert  into `t_banner`(`id`,`imgUrl`,`statu`,`sort`) values (1,'http://tuan.hnmall.com/Public/Pintuan/img/item02.jpg',1,1),(2,'http://tuan.hnmall.com/Public/Pintuan/img/todaybuy.png',1,2);

UNLOCK TABLES;

/*Table structure for table `t_item` */

DROP TABLE IF EXISTS `t_item`;

CREATE TABLE `t_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(120) NOT NULL COMMENT '名称',
  `typeId` bigint(20) DEFAULT NULL COMMENT '商品分类编号',
  `describe` varchar(120) NOT NULL COMMENT '描述',
  `coverUrl` varchar(120) NOT NULL COMMENT '封面图片',
  `SPUSaleNum` int(11) NOT NULL DEFAULT '0' COMMENT 'SPU售量',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `t_item` */

LOCK TABLES `t_item` WRITE;

insert  into `t_item`(`id`,`name`,`typeId`,`describe`,`coverUrl`,`SPUSaleNum`,`createTime`) values (5,'【500克 7包每包6个】夏威夷果 单果重400-600g',2,'国家地理标志产品 酥脆可口','http://7xvsmx.com1.z0.glb.clouddn.com/imgData/20171216/feb1dc0a67d242288e8dd5f0d91e820b',2,'2017-12-16 17:43:48'),(7,'泰国金枕头榴莲',1,'新鲜带壳榴莲进口热带水果包邮香糯甜榴莲精选果','http://7xvsmx.com1.z0.glb.clouddn.com/imgData/20171218/28c0272c0a5643d098259c1f565a5e24',0,'2017-12-18 14:48:47'),(8,'泰国椰青热带大椰子9颗装原装进口送开椰器椰汁新鲜水果多仓包邮',1,'泰国原装进口 宝宝饮料 送开椰器','http://7xvsmx.com1.z0.glb.clouddn.com/imgData/20171230/bdcb7d1acdbd49eeaca0e4d3279a6e80',0,'2017-12-30 12:08:21'),(9,'云南特产河口菠萝大果8斤 甜脆香水菠萝凤梨新鲜热带水果现摘现发',1,'基地直采 新鲜发货 坏果包赔 送菠萝刀','http://7xvsmx.com1.z0.glb.clouddn.com/imgData/20171230/a1bf1d8402ca4045bcfc887e1149efa8',0,'2017-12-30 12:11:42'),(10,'上海红霞草莓1盒(约400g/盒) 新鲜水果',1,'颜色鲜艳，香气浓郁，甜糯多汁','http://7xvsmx.com1.z0.glb.clouddn.com/imgData/20171230/0e38c0c9c3034d199a9773a48cd96701',0,'2017-12-30 12:15:36');

UNLOCK TABLES;

/*Table structure for table `t_item_detail` */

DROP TABLE IF EXISTS `t_item_detail`;

CREATE TABLE `t_item_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `itemId` bigint(20) NOT NULL COMMENT '商品编号',
  `imgUrl` varchar(120) NOT NULL COMMENT '图片地址',
  `sort` bigint(20) DEFAULT '1' COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

/*Data for the table `t_item_detail` */

LOCK TABLES `t_item_detail` WRITE;

insert  into `t_item_detail`(`id`,`itemId`,`imgUrl`,`sort`) values (18,5,'http://7xvsmx.com1.z0.glb.clouddn.com/imgData/20171216/5e4e5992ecbf4ac7b858cb4f075b432a',1),(19,5,'http://7xvsmx.com1.z0.glb.clouddn.com/imgData/20171216/c24a95bf866348dfa29a0f9b284fe01b',1),(23,7,'http://7xvsmx.com1.z0.glb.clouddn.com/imgData/20171218/9cb8ba54085c437db37580d10528688a',1),(24,7,'http://7xvsmx.com1.z0.glb.clouddn.com/imgData/20171218/f305f2c8d76a4b38b11e04e5add0d724',1),(25,8,'http://7xvsmx.com1.z0.glb.clouddn.com/imgData/20171230/559b74ba103643f88332afaa8477c868',1),(26,8,'http://7xvsmx.com1.z0.glb.clouddn.com/imgData/20171230/86cc5f3397dd499da0833324b4b8d128',1),(27,9,'http://7xvsmx.com1.z0.glb.clouddn.com/imgData/20171230/deaed30c5c614b1c92138b5bd2412d23',1),(28,9,'http://7xvsmx.com1.z0.glb.clouddn.com/imgData/20171230/b6a721669b8f448fa62f818512505b64',1),(29,9,'http://7xvsmx.com1.z0.glb.clouddn.com/imgData/20171230/abeb7819e65346108555e9b451f54119',1),(30,10,'http://7xvsmx.com1.z0.glb.clouddn.com/imgData/20171230/de88b1f91fac4891ac5b11b2d3e11aa1',1),(31,10,'http://7xvsmx.com1.z0.glb.clouddn.com/imgData/20171230/1a182d93049a4ef0b0df1fa78d927999',1),(32,10,'http://7xvsmx.com1.z0.glb.clouddn.com/imgData/20171230/6156cf288bb24af09a6a1664e3927f91',1),(33,10,'http://7xvsmx.com1.z0.glb.clouddn.com/imgData/20171230/e7696390ef7e4b2f877e475b804af2a9',1);

UNLOCK TABLES;

/*Table structure for table `t_item_sku` */

DROP TABLE IF EXISTS `t_item_sku`;

CREATE TABLE `t_item_sku` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `itemId` bigint(20) DEFAULT NULL COMMENT '商品编号',
  `attr` varchar(20) DEFAULT NULL COMMENT 'SKU属性',
  `originalPrice` decimal(5,2) DEFAULT NULL COMMENT '原价',
  `price` decimal(5,2) DEFAULT NULL COMMENT '销售价',
  `stock` int(11) DEFAULT '1' COMMENT '库存',
  `saleNum` int(11) DEFAULT '0' COMMENT 'SKU销量',
  PRIMARY KEY (`id`),
  UNIQUE KEY `itemId` (`itemId`,`attr`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `t_item_sku` */

LOCK TABLES `t_item_sku` WRITE;

insert  into `t_item_sku`(`id`,`itemId`,`attr`,`originalPrice`,`price`,`stock`,`saleNum`) values (7,5,'1','100.00','88.00',8,2),(9,7,'2','20.00','10.00',10,0),(10,8,'3','30.00','25.00',10,0),(11,9,'4','80.00','60.00',10,0),(12,10,'5','50.00','42.00',10,0);

UNLOCK TABLES;

/*Table structure for table `t_item_type` */

DROP TABLE IF EXISTS `t_item_type`;

CREATE TABLE `t_item_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(36) DEFAULT NULL COMMENT '名称',
  `pid` bigint(20) DEFAULT '0',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_item_type` */

LOCK TABLES `t_item_type` WRITE;

insert  into `t_item_type`(`id`,`name`,`pid`,`createTime`) values (1,'水果类',0,NULL),(2,'坚果类',0,NULL);

UNLOCK TABLES;

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `orderNo` varchar(36) NOT NULL COMMENT '订单号',
  `itemId` bigint(20) DEFAULT NULL COMMENT '商品编号',
  `orderNum` int(11) DEFAULT NULL COMMENT '订单数量',
  `orderMoney` decimal(5,2) DEFAULT NULL COMMENT '订单金额',
  `addressId` bigint(20) DEFAULT NULL COMMENT '订单地址',
  `userId` bigint(20) DEFAULT NULL COMMENT '下单人',
  `receiver` varchar(20) DEFAULT NULL COMMENT '收货人',
  `tel` varchar(11) DEFAULT NULL COMMENT '收货人手机号码',
  `orderState` int(11) DEFAULT '0' COMMENT '订单状态（0：未支付，1：已支付未发货，2：已支付已发货，3：已签收，4：拒签）',
  `payType` int(11) DEFAULT '0' COMMENT '支付方式（0：微信）',
  `createTime` datetime DEFAULT NULL COMMENT '订单创建时间',
  `expireTime` datetime DEFAULT NULL COMMENT '订单过期时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `orderNo` (`orderNo`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `t_order` */

LOCK TABLES `t_order` WRITE;

insert  into `t_order`(`id`,`orderNo`,`itemId`,`orderNum`,`orderMoney`,`addressId`,`userId`,`receiver`,`tel`,`orderState`,`payType`,`createTime`,`expireTime`) values (2,'2017120811512719347474',5,1,'16.00',1,1,'王五','18878782323',0,0,'2017-12-08 15:49:07',NULL),(4,'2018010311514957897236',5,1,'10.00',3,1,'李太白','18578784545',0,0,'2018-01-03 00:00:00','2018-01-03 00:15:00'),(14,'2018010411515057319362',5,1,'12.00',1,1,'工人','18545451212',0,0,'2018-01-04 00:00:00','2018-01-04 00:15:00'),(15,'2018010411515058135137',5,1,'12.00',1,1,'木','18578451245',0,0,'2018-01-04 00:00:00','2018-01-04 00:15:00');

UNLOCK TABLES;

/*Table structure for table `t_relationship_item_attr` */

DROP TABLE IF EXISTS `t_relationship_item_attr`;

CREATE TABLE `t_relationship_item_attr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增编号',
  `itemId` bigint(20) NOT NULL COMMENT '商品编号',
  `attrNameId` bigint(20) NOT NULL COMMENT '属性名编号',
  `attrValueId` bigint(20) NOT NULL COMMENT '属性值编号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `itemId` (`itemId`,`attrNameId`,`attrValueId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_relationship_item_attr` */

LOCK TABLES `t_relationship_item_attr` WRITE;

insert  into `t_relationship_item_attr`(`id`,`itemId`,`attrNameId`,`attrValueId`) values (1,5,3,2),(2,7,1,1),(3,8,1,1),(4,9,1,1),(5,10,1,1);

UNLOCK TABLES;

/*Table structure for table `t_sms` */

DROP TABLE IF EXISTS `t_sms`;

CREATE TABLE `t_sms` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tel` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `code` int(6) DEFAULT NULL COMMENT '短信验证码',
  `expireTime` datetime DEFAULT NULL COMMENT '过期时间',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sms` */

LOCK TABLES `t_sms` WRITE;

UNLOCK TABLES;

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `openId` varchar(60) DEFAULT NULL COMMENT '微信openId',
  `nickName` varchar(26) DEFAULT NULL COMMENT '昵称',
  `utel` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `gender` tinyint(1) DEFAULT NULL COMMENT '性别',
  `province` varchar(30) DEFAULT NULL COMMENT '省份',
  `country` varchar(30) DEFAULT NULL COMMENT '城市',
  `headimgurl` varchar(120) DEFAULT NULL COMMENT '头像',
  `isSubscribe` tinyint(1) DEFAULT NULL COMMENT '是否关注',
  `subscribeTime` datetime DEFAULT NULL COMMENT '订阅时间',
  `lastLoginTime` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `source` varchar(26) DEFAULT NULL COMMENT '用户来源',
  `uStatu` int(11) DEFAULT '0' COMMENT '用户状态（0：正常，1：锁定）',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_openId` (`openId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

LOCK TABLES `t_user` WRITE;

insert  into `t_user`(`id`,`openId`,`nickName`,`utel`,`gender`,`province`,`country`,`headimgurl`,`isSubscribe`,`subscribeTime`,`lastLoginTime`,`source`,`uStatu`,`createTime`) values (1,'wx007','剑圣','18573163183',1,'湖南省','长沙市',NULL,1,'2017-12-02 10:12:25','2017-12-02 10:12:27','0',0,'2017-12-01 10:12:37');

UNLOCK TABLES;

/*Table structure for table `t_ws_about` */

DROP TABLE IF EXISTS `t_ws_about`;

CREATE TABLE `t_ws_about` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cover` varchar(120) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `t_ws_about` */

LOCK TABLES `t_ws_about` WRITE;

insert  into `t_ws_about`(`id`,`cover`,`createTime`) values (7,'http://localhost:8088\\about\\20180604\\1528104070604820.jpg','2018-06-04 17:25:22');

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

/*Table structure for table `t_ws_banner` */

DROP TABLE IF EXISTS `t_ws_banner`;

CREATE TABLE `t_ws_banner` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(120) DEFAULT NULL COMMENT 'banner图片路径',
  `mobileUrl` varchar(120) DEFAULT NULL COMMENT 'banner图片路径(mobile)',
  `link` varchar(50) DEFAULT NULL COMMENT 'banner图片链接',
  `sortNum` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10009 DEFAULT CHARSET=utf8;

/*Data for the table `t_ws_banner` */

LOCK TABLES `t_ws_banner` WRITE;

insert  into `t_ws_banner`(`id`,`url`,`mobileUrl`,`link`,`sortNum`) values (10006,'http://localhost:8088\\banner\\20180602\\1527909395581242.jpg',NULL,'2',0),(10007,'http://localhost:8088\\banner\\20180602\\1527909395582617.jpg',NULL,NULL,0),(10008,'http://localhost:8088\\banner\\20180602\\1527909395583732.jpg',NULL,NULL,0);

UNLOCK TABLES;

/*Table structure for table `t_ws_baseinfo` */

DROP TABLE IF EXISTS `t_ws_baseinfo`;

CREATE TABLE `t_ws_baseinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB AUTO_INCREMENT=10003 DEFAULT CHARSET=utf8;

/*Data for the table `t_ws_baseinfo` */

LOCK TABLES `t_ws_baseinfo` WRITE;

insert  into `t_ws_baseinfo`(`id`,`logo`,`slogan`,`tel`,`qq`,`serverTime`,`qrCode`,`addr`,`aboutUs`,`copyright`) values (10002,'http://localhost:8088\\index\\20180601\\1527845148127866.png','中国最具影响力的品牌策划公司之一中国品牌设计50强','400-8888-866','917661718','周一~周五 08:30~18:00',NULL,'湖南长沙开福区普瑞金大道518号 三角大楼88栋888号','专注于品牌战略与价值管理，善于从市场和竞争的角度出发，通过行业市场分析与消费者调研，同时结合企业的实际情况，找到精准而差异化的定位，并创造出独特的品牌视觉符号，结合相应的产品、定价、渠道、传播策略。','All Rights Reserved. © 2018-2020 湖南致亿文化传媒有限责任公司. 湘ICP备XXXXXXXX号');

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

insert  into `t_ws_case`(`id`,`title`,`cover`,`pv`,`content`,`typeId`,`createTime`) values (2,'111','http://localhost:8088\\case\\20180531\\1527765685296617.jpg',0,'<p>胜多负少的发送到胜多负少的</p><p><img src=\"http://localhost:8088\\case\\20180531\\1527765685297767.jpg\" alt=\"undefined\"><br></p>',1,'2018-05-31 19:24:14'),(3,'文章的模拟示范标题','http://localhost:8088\\case\\20180602\\1527918378431284.jpg',0,'<p><span>&nbsp; &nbsp; &nbsp; 大谷吉继的出身，主要传说是近江和丰后，于此暂采近江一说。众所周知，他同好友三成一起担任秀吉的近侍而崭露头角，关原之前的事迹，在此略过不提。关原一战时，他是五万石的敦贺城主。六月二十一日（日期另有异说）家康征伐会津，他领着一千兵马进军美浓垂井，佐和山的三成遣长子石田重家亲任使者，把他邀入西军。三成久已牵挂着他，听说吉继到达，立刻遣樫原彦右卫门过来求一会面。于是吉继受邀前往佐和山，在那里了解了三成举兵的详情。 　吉继心中以为此时难有胜算，表示了强烈的反对，一度说服三成。但是三成依然决意举兵。到了这个地步，两人之间几乎至于决裂。回到垂井之后他十分烦恼，但到最后，决定为了友情举家相殉。重新集结部队之后，吉继率兵回到了敦贺。</span><br><br><p><span>　吉继决定加入三成一方的时候，将名字改成了“吉隆”，这据说是因为“吉继”这个名字与三好义继谐音，而后者有着被信长攻破河内若江城后自刎城头的凶死（《烈祖成绩》）。其实原本从此时开始就应该称他为“大谷吉隆”，但为行文方便，文中将一直使用“吉继”这个通名。 　《改正三河后风土记》里，改名之前称其为“吉继”，改名之后则称为“吉隆”，区分得清清楚楚。大谷在关原町山中之墓的说明板上也是写成“吉隆”的。 　在敦贺整军以待的吉继，以最快速度准备防卫前田利长的南下，以下情节在前文《大圣寺城之战》及《浅井畷之战》中有所介绍。确认前田军已返金泽后，吉继应三成的邀请从敦贺出兵，九月二日抵关原西面的山中村宫上地方，扎下营盘。然而，名义上可称为北陆方面总大将的京极高次非但行军晚了一天，且根本不曾到达美浓，而是突然变向折回居城大津城，死守不出。</span></p><p style=\"text-align: center;\"><span><img src=\"http://localhost:8088\\case\\20180602\\1527918378432908.jpg\" alt=\"1527918378432908.jpg\"><br></span></p><p style=\"text-align: center;\"><p style=\"text-align: center;\"><span style=\"text-align: left;\">&nbsp; &nbsp; &nbsp; &nbsp;大谷吉继的出身，主要传说是近江和丰后，于此暂采近江一说。众所周知，他同好友三成一起担任秀吉的近侍而崭露头角，关原之前的事迹，在此略过不提。关原一战时，他是五万石的敦贺城主。六月二十一日（日期另有异说）家康征伐会津，他领着一千兵马进军美浓垂井，佐和山的三成遣长子石田重家亲任使者，把他邀入西军。三成久已牵挂着他，听说吉继到达，立刻遣樫原彦右卫门过来求一会面。于是吉继受邀前往佐和山，在那里了解了三成举兵的详情。 　吉继心中以为此时难有胜算，表示了强烈的反对，一度说服三成。但是三成依然决意举兵。到了这个地步，两人之间几乎至于决裂。回到垂井之后他十分烦恼，但到最后，决定为了友情举家相殉。重新集结部队之后，吉继率兵回到了敦贺。</span><br><p style=\"text-align: left;\">　吉继决定加入三成一方的时候，将名字改成了“吉隆”，这据说是因为“吉继”这个名字与三好义继谐音，而后者有着被信长攻破河内若江城后自刎城头的凶死（《烈祖成绩》）。其实原本从此时开始就应该称他为“大谷吉隆”，但为行文方便，文中将一直使用“吉继”这个通名。 　《改正三河后风土记》里，改名之前称其为“吉继”，改名之后则称为“吉隆”，区分得清清楚楚。大谷在关原町山中之墓的说明板上也是写成“吉隆”的。 　在敦贺整军以待的吉继，以最快速度准备防卫前田利长的南下，以下情节在前文《大圣寺城之战》及《浅井畷之战》中有所介绍。确认前田军已返金泽后，吉继应三成的邀请从敦贺出兵，九月二日抵关原西面的山中村宫上地方，扎下营盘。然而，名义上可称为北陆方面总大将的京极高次非但行军晚了一天，且根本不曾到达美浓，而是突然变向折回居城大津城，死守不出。</p></p></p></p>',1,'2018-06-02 13:47:02');

UNLOCK TABLES;

/*Table structure for table `t_ws_case_type` */

DROP TABLE IF EXISTS `t_ws_case_type`;

CREATE TABLE `t_ws_case_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '案例类型名称',
  `sortNum` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_ws_case_type` */

LOCK TABLES `t_ws_case_type` WRITE;

insert  into `t_ws_case_type`(`id`,`name`,`sortNum`) values (1,'案例类型一',1);

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
  `addrPic` varchar(50) DEFAULT NULL COMMENT '地址图片',
  `workTime` varchar(36) DEFAULT NULL COMMENT '工作时间',
  `banner` varchar(50) DEFAULT NULL COMMENT 'banner',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_ws_contact` */

LOCK TABLES `t_ws_contact` WRITE;

UNLOCK TABLES;

/*Table structure for table `t_ws_join` */

DROP TABLE IF EXISTS `t_ws_join`;

CREATE TABLE `t_ws_join` (
  `id` bigint(20) DEFAULT NULL,
  `content` text,
  `createTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_ws_join` */

LOCK TABLES `t_ws_join` WRITE;

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

insert  into `t_ws_links`(`id`,`name`,`url`,`createTime`) values (1,'谷歌','http://www.google.com',NULL),(2,'百度','http://www.baidu.com','2018-06-02 12:51:49');

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
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `typeId` bigint(20) NOT NULL COMMENT '类型ID',
  `cover` varchar(50) DEFAULT NULL COMMENT '封面',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_ws_news` */

LOCK TABLES `t_ws_news` WRITE;

UNLOCK TABLES;

/*Table structure for table `t_ws_news_type` */

DROP TABLE IF EXISTS `t_ws_news_type`;

CREATE TABLE `t_ws_news_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(36) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_ws_news_type` */

LOCK TABLES `t_ws_news_type` WRITE;

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

insert  into `t_ws_server`(`id`,`title`,`content`,`createTime`) values (2,'我们能做啥2','                        <p style=\"text-align: center;\">专注为企业解决品牌盈利问题2</p><p style=\"text-align: center;\">坚持专项调研，精准诊断，量身定制2</p><p style=\"text-align: center;\"><img src=\"http://localhost:8088\\server\\20180602\\1527918231936121.jpg\" alt=\"1527918231936121.jpg\"><br></p>\n                    ','2018-06-02 14:42:40');

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

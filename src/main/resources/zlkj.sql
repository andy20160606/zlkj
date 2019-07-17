/*
Navicat MySQL Data Transfer

Source Server         : YG
Source Server Version : 50533
Source Host           : localhost:3306
Source Database       : zlkj

Target Server Type    : MYSQL
Target Server Version : 50533
File Encoding         : 65001

Date: 2019-07-17 08:58:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_file`
-- ----------------------------
DROP TABLE IF EXISTS `t_file`;
CREATE TABLE `t_file` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_file
-- ----------------------------

-- ----------------------------
-- Table structure for `t_hd`
-- ----------------------------
DROP TABLE IF EXISTS `t_hd`;
CREATE TABLE `t_hd` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cpjs` varchar(255) DEFAULT NULL,
  `cpsl` varchar(255) DEFAULT NULL,
  `cptp` varchar(255) DEFAULT NULL,
  `dj` double DEFAULT NULL,
  `dwdz` varchar(255) DEFAULT NULL,
  `dwmc` varchar(255) DEFAULT NULL,
  `dykjje` double DEFAULT NULL,
  `hdgz` varchar(255) DEFAULT NULL,
  `hdjs` varchar(255) DEFAULT NULL,
  `hdmc` varchar(255) DEFAULT NULL,
  `hdts` int(11) DEFAULT NULL,
  `hjcs` int(11) DEFAULT NULL,
  `khwybs` varchar(255) DEFAULT NULL,
  `lxfs` varchar(255) DEFAULT NULL,
  `starttime` datetime DEFAULT NULL,
  `stoptime` datetime DEFAULT NULL,
  `yj` double DEFAULT NULL,
  `cykjrs` int(11) DEFAULT NULL,
  `hjrs` int(11) DEFAULT NULL,
  `llrs` int(11) DEFAULT NULL,
  `cpmc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_hd
-- ----------------------------
INSERT INTO `t_hd` VALUES ('1', 'string', 'string', 'string', '100', 'string', 'string', '50', 'string', 'string', 'string', '0', '2', 'string', 'string', '2019-06-04 13:17:28', '2019-06-04 13:17:28', '200', '0', '0', '1', null);
INSERT INTO `t_hd` VALUES ('2', 'string', 'string', 'string', '0', 'string', 'string', '0', 'string', 'string', 'string', '0', '0', 'string', 'string', '2019-06-04 14:45:31', '2019-06-04 14:45:31', '0', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('3', 'string', 'string', 'string', '0', 'string', 'string', '0', 'string', 'string', 'string', '0', '0', 'string', 'string', '2019-06-04 14:57:32', '2019-06-04 14:57:32', '0', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('4', '1', '2', '3', '100', '2', '3', '10', '2', '1', '2', '1', '1', '0', '1', '2019-06-04 15:14:37', '2019-06-04 15:14:37', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('5', '1', '2', '3', '100', '2', '3', '10', '2', '1', '2', '1', '1', '0', '1', '2019-06-04 15:14:37', '2019-06-04 15:14:37', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('6', '1', '2', '3', '100', '2', '3', '10', '2', '1', '2', '1', '1', '0', '1', '2019-06-04 15:14:37', '2019-06-04 15:14:37', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('7', '1', '2', '1', '100', '2', '3', '10', '2', '1', '2', '1', '1', '0', '1', '2019-06-04 15:14:37', '2019-06-04 15:14:37', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('8', '1', '2', '1', '100', '2', '3', '10', '2', '1', '2', '1', '1', '0', '1', '2019-06-04 15:14:37', '2019-06-04 15:14:37', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('9', '1', '2', '1', '100', '2', '3', '10', '2', '1', '2', '1', '1', '0', '1', '2019-06-04 15:14:37', '2019-06-04 15:14:37', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('10', '1', '2', '1', '100', '2', '3', '10', '2', '1', '2', '1', '1', '0', '1', '2019-06-04 15:14:37', '2019-06-04 15:14:37', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('11', '1', '2', '1', '100', '2', '3', '10', '2', '1', '2', '1', '1', '0', '1', '2019-06-04 15:14:37', '2019-06-04 15:14:37', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('12', '1', '2', '1', '100', '2', '3', '10', '2', '1', '2', '1', '1', '0', '1', '2019-06-04 15:14:37', '2019-06-04 15:14:37', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('13', '1', '2', '1', '100', '2', '3', '10', '2', '1', '2', '1', '1', '0', '1', '2019-06-04 15:14:37', '2019-06-04 15:14:37', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('14', '1', '2', '1', '100', '2', '3', '10', '2', '1', '2', '1', '1', '0', '1', '2019-06-04 15:14:37', '2019-06-04 15:14:37', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('15', '1', '2', '1', '100', '2', '3', '10', '2', '1', '2', '1', '1', '0', '1', '2019-06-04 15:14:37', '2019-06-04 15:14:37', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('16', '1', '2', '1', '100', '2', '3', '10', '2', '1', '2', '1', '1', '0', '1', '2019-06-04 15:14:37', '2019-06-04 15:14:37', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('17', '1', '2', '1', '100', '2', '3', '10', '2', '1', '2', '1', '1', '0', '1', '2019-06-04 15:14:37', '2019-06-04 15:14:37', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('18', '1', '2', '1', '100', '2', '3', '10', '2', '1', '2', '1', '1', '0', '1', '2019-06-04 15:14:37', '2019-06-04 15:14:37', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('19', '1', '2', '1', '100', '2', '3', '10', '2', '1', '2', '1', '1', '0', '1', '2019-06-04 15:14:37', '2019-06-04 15:14:37', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('20', '1', '2', '1', '100', '2', '3', '10', '2', '1', '2', '1', '1', '0', '1', '2019-06-04 15:14:37', '2019-06-04 15:14:37', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('21', '1', '2', '1', '100', '2', '3', '10', '2', '1', '2', '1', '1', '0', '1', '2019-06-04 15:14:37', '2019-06-04 15:14:37', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('22', '1', '2', '1', '100', '2', '3', '10', '2', '1', '2', '1', '1', '0', '1', '2019-06-04 15:14:37', '2019-06-04 15:14:37', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('23', '1', '2', '1', '100', '2', '3', '10', '2', '1', '2', '1', '1', '0', '1', '2019-06-04 15:14:37', '2019-06-04 15:14:37', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('24', '1', '2', '1', '100', '2', '3', '10', '2', '1', '2', '1', '1', '0', '1', '2019-06-04 15:14:37', '2019-06-04 15:14:37', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('25', '1', '2', '1', '100', '2', '3', '10', '2', '1', '2', '1', '1', '0', '1', '2019-06-04 15:14:37', '2019-06-04 15:14:37', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('26', '1', '2', '1', '100', '2', '3', '10', '2', '1', '2', '1', '1', '0', '1', '2019-06-04 15:14:37', '2019-06-04 15:14:37', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('27', '1', '2', '1', '100', '2', '3', '10', '2', '1', '2', '1', '1', '0', '1', '2019-06-04 15:14:37', '2019-06-04 15:14:37', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('28', '1', '2', '1', '100', '2', '3', '10', '2', '1', '2', '1', '1', '0', '1', '2019-06-04 15:14:37', '2019-06-04 15:14:37', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('29', '1', '2', '1', '100', '2', '3', '10', '2', '1', '2', '1', '1', '0', '1', '2019-06-04 15:14:37', '2019-06-04 15:14:37', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('30', '1', '2', '1', '100', '2', '3', '10', '2', '1', '2', '1', '1', '0', '1', '2019-06-04 15:14:37', '2019-06-04 15:14:37', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('31', '1', '2', '1', '100', '2', '3', '10', '2', '1', '2', '1', '1', '0', '1', '2019-06-04 15:14:37', '2019-06-04 15:14:37', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('32', 'string', 'string', 'string', '0', 'string', 'string', '0', 'string', 'string', 'string', '0', '0', 'string', 'string', '2019-06-04 16:12:52', '2019-06-04 16:12:52', '0', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('33', '参与者可自行创建队伍或加入他人创建的队伍，每人\n最多加入3个队伍，每个队伍满员后等待开奖，开奖\n后可立即抽奖。\n兑奖时间：2月29日至3月10日 兑奖地点：深圳南山学\n区 兑奖须知：凭核销码线下领取奖品', '10', '1b76233e-6c55-45ea-b3c3-82a324b57eea.jpg', '120', '江苏省常州市', '奶香铺子', '10', '参与者可自行创建队伍或加入他人创建的队伍，每人\n最多加入3个队伍，每个队伍满员后等待开奖，开奖\n后可立即抽奖。\n兑奖时间：2月29日至3月10日 兑奖地点：深圳南山学\n区 兑奖须知：凭核销码线下领取奖品', '参与者可自行创建队伍或加入他人创建的队伍，每人\n最多加入3个队伍，每个队伍满员后等待开奖，开奖\n后可立即抽奖。\n兑奖时间：2月29日至3月10日 兑奖地点：深圳南山学\n区 兑奖须知：凭核销码线下领取奖品', '芋泥酸奶盒子', '10', '1', '1', '15961114501', '2019-06-01 00:00:00', '2019-06-16 00:00:00', '200', '5', '0', '1', null);
INSERT INTO `t_hd` VALUES ('34', '参与者可自行创建队伍或加入他人创建的队伍，每人\n最多加入3个队伍，每个队伍满员后等待开奖，开奖\n后可立即抽奖。\n兑奖时间：2月29日至3月10日 兑奖地点：深圳南山学\n区 兑奖须知：凭核销码线下领取奖品', '10', '805ef77a-c743-4abf-b48b-e92943a84237.jpg', '120', '江苏省常州市', '奶香铺子', '10', '参与者可自行创建队伍或加入他人创建的队伍，每人\n最多加入3个队伍，每个队伍满员后等待开奖，开奖\n后可立即抽奖。\n兑奖时间：2月29日至3月10日 兑奖地点：深圳南山学\n区 兑奖须知：凭核销码线下领取奖品', '参与者可自行创建队伍或加入他人创建的队伍，每人\n最多加入3个队伍，每个队伍满员后等待开奖，开奖\n后可立即抽奖。\n兑奖时间：2月29日至3月10日 兑奖地点：深圳南山学\n区 兑奖须知：凭核销码线下领取奖品', '芋泥酸奶盒子', '1', '1', '1', '15961114501', '2019-06-01 00:00:00', '2019-06-29 00:00:00', '200', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('35', '5689', '1', 'f0b12e96-5b18-4661-8ead-56a0d43d88e2.jpg', '380', '测试', '测', '30', '123', '123', '测试的', '4', '1', '1', '15961114501', '2019-06-01 00:00:00', '2019-06-29 00:00:00', '500', '0', '0', '0', null);
INSERT INTO `t_hd` VALUES ('36', 'hehe', '2', 'bc5bb11f-312b-4e4f-9756-90522caaa74c.jpg', '120', '2', 'xin', '20', 'hahahahaha', 'hahahahha', 'newsPage', '18', '1', '1', '3', '2019-06-07 00:00:00', '2019-06-22 00:00:00', '200', '4', '1', '0', 'default');
INSERT INTO `t_hd` VALUES ('37', '31323123123', '1', '625fc0c8-72ec-476f-a1a7-0808064b98d8.png', '120', 'jhahah', 'haha', '20', '33', '333', '这是一个新的活动', '1', '1', '1', '22222', '2019-05-04 00:00:00', '2019-05-03 00:00:00', '200', '0', '0', '0', 'default');
INSERT INTO `t_hd` VALUES ('38', '4', '1', 'e869190d-395e-4ea1-8896-3eec9da7c967.jpg', '7', '2', '2', '2', '2', '3', 'ddwwq', '1', '1', '1', '2', '2019-06-01 00:00:00', '2019-06-29 00:00:00', '15', '0', '0', '0', 'default');
INSERT INTO `t_hd` VALUES ('39', 'ddddddd', '20', 'b62fb53c-548d-483c-8f19-79c2875b9bfb.png', '120', '暂无', '暂无', '20', '123456', '1222', '如意混沌', '30', '3', '1', '15961114501', '2019-06-01 00:00:00', '2019-06-30 00:00:00', '200', '0', '0', '0', 'default');

-- ----------------------------
-- Table structure for `t_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_info`;
CREATE TABLE `t_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `k` varchar(255) DEFAULT NULL,
  `val` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_info
-- ----------------------------

-- ----------------------------
-- Table structure for `t_kjdw`
-- ----------------------------
DROP TABLE IF EXISTS `t_kjdw`;
CREATE TABLE `t_kjdw` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dqkjdj` double DEFAULT NULL,
  `dwcjsj` datetime DEFAULT NULL,
  `sykjje` double DEFAULT NULL,
  `ykjje` double DEFAULT NULL,
  `dz_id` bigint(20) DEFAULT NULL,
  `hd_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnmr20tvq8v8lyuyjjvxpyxsps` (`dz_id`),
  KEY `FKh042p6feu70t8fdxo56ncolr` (`hd_id`),
  CONSTRAINT `FKh042p6feu70t8fdxo56ncolr` FOREIGN KEY (`hd_id`) REFERENCES `t_hd` (`id`),
  CONSTRAINT `FKnmr20tvq8v8lyuyjjvxpyxsps` FOREIGN KEY (`dz_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_kjdw
-- ----------------------------
INSERT INTO `t_kjdw` VALUES ('1', '200', '2019-06-05 11:27:56', '100', '0', '1', '1');
INSERT INTO `t_kjdw` VALUES ('2', '150', '2019-06-05 16:47:29', '30', '50', '15', '33');
INSERT INTO `t_kjdw` VALUES ('3', '120', '2019-06-06 13:45:15', '0', '80', '15', '36');
INSERT INTO `t_kjdw` VALUES ('4', '200', '2019-06-09 10:32:18', '80', '0', '14', '39');
INSERT INTO `t_kjdw` VALUES ('5', '200', '2019-06-09 10:32:24', '80', '0', '15', '39');
INSERT INTO `t_kjdw` VALUES ('6', '500', '2019-06-09 13:00:40', '120', '0', '15', '35');
INSERT INTO `t_kjdw` VALUES ('7', '15', '2019-06-09 14:22:59', '8', '0', '15', '38');
INSERT INTO `t_kjdw` VALUES ('8', '200', '2019-06-09 14:27:19', '80', '0', '15', '39');
INSERT INTO `t_kjdw` VALUES ('9', '200', '2019-06-09 14:27:23', '80', '0', '15', '39');
INSERT INTO `t_kjdw` VALUES ('10', '200', '2019-06-09 14:28:32', '80', '0', '15', '34');

-- ----------------------------
-- Table structure for `t_kjrz`
-- ----------------------------
DROP TABLE IF EXISTS `t_kjrz`;
CREATE TABLE `t_kjrz` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `kjhj` double DEFAULT NULL,
  `kjje` double DEFAULT NULL,
  `kjqj` double DEFAULT NULL,
  `kjsj` datetime DEFAULT NULL,
  `hd_id` bigint(20) DEFAULT NULL,
  `kjdw_id` bigint(20) DEFAULT NULL,
  `kjr_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcdmuhoa487wi2xqta9i5v5dte` (`hd_id`),
  KEY `FKiyxg5sejbj079eoig3rx5bbln` (`kjdw_id`),
  KEY `FK6t9wxbm90mq9t6kk1olg6oxh6` (`kjr_id`),
  CONSTRAINT `FK6t9wxbm90mq9t6kk1olg6oxh6` FOREIGN KEY (`kjr_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FKcdmuhoa487wi2xqta9i5v5dte` FOREIGN KEY (`hd_id`) REFERENCES `t_hd` (`id`),
  CONSTRAINT `FKiyxg5sejbj079eoig3rx5bbln` FOREIGN KEY (`kjdw_id`) REFERENCES `t_kjdw` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_kjrz
-- ----------------------------
INSERT INTO `t_kjrz` VALUES ('1', '190', '10', '200', '2019-06-06 09:57:36', '33', '2', '15');
INSERT INTO `t_kjrz` VALUES ('2', '180', '10', '190', '2019-06-06 10:04:05', '33', '2', '16');
INSERT INTO `t_kjrz` VALUES ('3', '170', '10', '180', '2019-06-06 10:08:05', '33', '2', '13');
INSERT INTO `t_kjrz` VALUES ('4', '160', '10', '170', '2019-06-06 10:08:13', '33', '2', '14');
INSERT INTO `t_kjrz` VALUES ('5', '150', '10', '160', '2019-06-06 10:08:18', '33', '2', '14');
INSERT INTO `t_kjrz` VALUES ('7', '180', '20', '200', '2019-06-06 13:47:46', '36', '3', '13');
INSERT INTO `t_kjrz` VALUES ('8', '160', '20', '180', '2019-06-06 13:47:50', '36', '3', '14');
INSERT INTO `t_kjrz` VALUES ('9', '140', '20', '160', '2019-06-06 13:47:54', '36', '3', '15');
INSERT INTO `t_kjrz` VALUES ('10', '120', '20', '140', '2019-06-06 13:47:58', '36', '3', '16');

-- ----------------------------
-- Table structure for `t_org`
-- ----------------------------
DROP TABLE IF EXISTS `t_org`;
CREATE TABLE `t_org` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `seq` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7kp4bd28iid77gvobyfdustpl` (`pid`),
  CONSTRAINT `FK7kp4bd28iid77gvobyfdustpl` FOREIGN KEY (`pid`) REFERENCES `t_org` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_org
-- ----------------------------
INSERT INTO `t_org` VALUES ('1', '行政楼', '111000', '2019-04-10 09:16:10', 'desc', null, '办公室', null, null, null);
INSERT INTO `t_org` VALUES ('2', '行政楼111', '111000', '2019-04-10 09:16:10', 'desc', null, '办公室1', null, null, '1');
INSERT INTO `t_org` VALUES ('3', '行政楼222', '111000', '2019-04-10 09:16:11', 'desc', null, '办公室1', null, null, '2');
INSERT INTO `t_org` VALUES ('4', null, null, '2019-04-17 14:52:50', '微信渠道', null, '微信渠道', null, null, null);

-- ----------------------------
-- Table structure for `t_res`
-- ----------------------------
DROP TABLE IF EXISTS `t_res`;
CREATE TABLE `t_res` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdate` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `resourcetype` int(11) DEFAULT NULL,
  `seq` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK44mad20e1ud26wjqhy6fn2ls7` (`pid`),
  CONSTRAINT `FK44mad20e1ud26wjqhy6fn2ls7` FOREIGN KEY (`pid`) REFERENCES `t_res` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_res
-- ----------------------------
INSERT INTO `t_res` VALUES ('1', '2019-04-10 09:15:59', '系统管理', null, 'res-name-1', '0', null, null, 'system', null);
INSERT INTO `t_res` VALUES ('2', '2019-04-10 09:15:59', '系统管理/用户管理', null, '用户管理', '0', null, null, 'system/user', '1');
INSERT INTO `t_res` VALUES ('3', '2019-04-10 09:15:59', '系统管理/用户管理/添加', null, '添加', '1', null, null, 'system/user/add', '2');
INSERT INTO `t_res` VALUES ('4', '2019-04-10 09:15:59', '系统管理/用户管理/修改', null, '修改', '1', null, null, 'system/user/edit', '2');
INSERT INTO `t_res` VALUES ('5', '2019-04-10 09:15:59', '系统管理/用户管理/删除', null, '删除', '1', null, null, 'system/user/del', '2');
INSERT INTO `t_res` VALUES ('6', '2019-04-22 11:33:48', 'wx', null, 'wx', '0', null, null, 'yhq/add', null);

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `seq` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'desc', '超级用户', '1', '1');
INSERT INTO `t_role` VALUES ('2', 'wx', 'wx', '1', '1');

-- ----------------------------
-- Table structure for `t_role_ress`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_ress`;
CREATE TABLE `t_role_ress` (
  `roles_id` bigint(20) NOT NULL,
  `ress_id` bigint(20) NOT NULL,
  KEY `FKcgo3urndu6s035ij8nrnwrwrd` (`ress_id`),
  KEY `FK9tnpujhwjo5vdlgf5vajg6hqn` (`roles_id`),
  CONSTRAINT `FK9tnpujhwjo5vdlgf5vajg6hqn` FOREIGN KEY (`roles_id`) REFERENCES `t_role` (`id`),
  CONSTRAINT `FKcgo3urndu6s035ij8nrnwrwrd` FOREIGN KEY (`ress_id`) REFERENCES `t_res` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_ress
-- ----------------------------
INSERT INTO `t_role_ress` VALUES ('1', '1');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  `loginname` varchar(255) DEFAULT NULL,
  `loginpass` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `usertype` int(11) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `procince` varchar(255) DEFAULT NULL,
  `wxopenid` varchar(255) DEFAULT NULL,
  `headimgurl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK50styg35vbtj9mrdd6nk8gwdh` (`wxopenid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '20', '2019-04-10 09:16:43', 'root', 'root', '139000000000', '1', '0', 'root', '1', null, null, null, null, '', null);
INSERT INTO `t_user` VALUES ('13', null, '2019-06-04 10:43:27', null, null, null, null, '0', null, null, 'Kagoshima-shi', 'JP', '异界的天乐君', 'Kagoshima-ken', 'odN1v1ibu_Mocf9eYUhFEQlxHB2A', 'http://thirdwx.qlogo.cn/mmopen/vi_32/WHUb0ia2b6Ct0fs0XLJFNdlBPPfZIf2P8ibicz1d2VfO4ib8yj7gLuSo9qd6USGI35DEa3EPhBr6buG1ZUnBLxZN8Q/132');
INSERT INTO `t_user` VALUES ('14', null, '2019-06-05 15:29:40', null, null, null, null, '0', null, null, '', '', 'andy', '', 'odN1v1rJ91EF89wuyt6n2iPbRAL0', 'http://thirdwx.qlogo.cn/mmopen/vi_32/Rgr60EMyax7HhJjY1lWGy06FHg1TsC6Fh4NOFsVPLiaKoDsAu1IC8kfKQowBknDMRh7cry1w0XNz2at5od9OdEA/132');
INSERT INTO `t_user` VALUES ('15', null, '2019-06-05 16:18:19', null, null, null, null, '0', null, null, '', '', 'lazy', '', 'odN1v1knmZ6JZStczWX3P50qNTtU', 'http://thirdwx.qlogo.cn/mmopen/vi_32/q5a4kPUQfiaKjbqkpc9RRHgzAU4qicIlDy9IuSy6ibJb3mjrGZ5bnG87eQjPLUXqPQbcVGGD2iaOu2bKcLUo6nJQjw/132');
INSERT INTO `t_user` VALUES ('16', null, '2019-06-06 10:03:11', null, null, null, null, '0', null, null, '徐州', '中国', '与君玉颜', '江苏', 'odN1v1uG0tHCCxVPiAwgJTxDuDt4', 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ9QQVVbUA1tpOde2n0dQ1plyXLHkLgNTDicMJygq4OCJIVorEvFhhYPaEIK2UkrTb5tRX6WMmnVlA/132');

-- ----------------------------
-- Table structure for `t_user_orgs`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_orgs`;
CREATE TABLE `t_user_orgs` (
  `users_id` bigint(20) NOT NULL,
  `orgs_id` bigint(20) NOT NULL,
  KEY `FKcma3uatexedv5qf33ac2877ah` (`orgs_id`),
  KEY `FK5vs64vn7jsoi7segphuch6ucd` (`users_id`),
  CONSTRAINT `FK5vs64vn7jsoi7segphuch6ucd` FOREIGN KEY (`users_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FKcma3uatexedv5qf33ac2877ah` FOREIGN KEY (`orgs_id`) REFERENCES `t_org` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_orgs
-- ----------------------------
INSERT INTO `t_user_orgs` VALUES ('1', '1');
INSERT INTO `t_user_orgs` VALUES ('13', '4');
INSERT INTO `t_user_orgs` VALUES ('14', '4');
INSERT INTO `t_user_orgs` VALUES ('15', '4');
INSERT INTO `t_user_orgs` VALUES ('16', '4');

-- ----------------------------
-- Table structure for `t_user_roles`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_roles`;
CREATE TABLE `t_user_roles` (
  `users_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL,
  KEY `FKj47yp3hhtsoajht9793tbdrp4` (`roles_id`),
  KEY `FKp67oqi40xgs7j7ad5xqaxx857` (`users_id`),
  CONSTRAINT `FKj47yp3hhtsoajht9793tbdrp4` FOREIGN KEY (`roles_id`) REFERENCES `t_role` (`id`),
  CONSTRAINT `FKp67oqi40xgs7j7ad5xqaxx857` FOREIGN KEY (`users_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_roles
-- ----------------------------
INSERT INTO `t_user_roles` VALUES ('1', '1');

-- ----------------------------
-- Table structure for `t_yhq`
-- ----------------------------
DROP TABLE IF EXISTS `t_yhq`;
CREATE TABLE `t_yhq` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `je` double DEFAULT NULL,
  `jsrq` datetime DEFAULT NULL,
  `ksrq` datetime DEFAULT NULL,
  `yhm` varchar(255) DEFAULT NULL,
  `yxzt` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `hqsj` datetime DEFAULT NULL,
  `hd_id` bigint(20) DEFAULT NULL,
  `sysj` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk77k0tdagqomrjkbnefb0l72y` (`user_id`),
  KEY `FK4ob978vk9wtv2utamianfk803` (`hd_id`),
  CONSTRAINT `FK4ob978vk9wtv2utamianfk803` FOREIGN KEY (`hd_id`) REFERENCES `t_hd` (`id`),
  CONSTRAINT `FKk77k0tdagqomrjkbnefb0l72y` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_yhq
-- ----------------------------
INSERT INTO `t_yhq` VALUES ('1', '80', null, null, '1559800078953', '1', '15', '2019-06-06 13:47:58', '36', null);

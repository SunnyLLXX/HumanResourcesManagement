/*
Navicat MySQL Data Transfer

Source Server         : test01
Source Server Version : 50041
Source Host           : localhost:3306
Source Database       : manage

Target Server Type    : MYSQL
Target Server Version : 50041
File Encoding         : 65001

Date: 2021-02-04 16:39:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `applyinfo`
-- ----------------------------
DROP TABLE IF EXISTS `applyinfo`;
CREATE TABLE `applyinfo` (
  `applyId` int(11) NOT NULL auto_increment,
  `applyName` varchar(20) NOT NULL,
  `applySex` varchar(4) NOT NULL,
  `applyBirth` varchar(40) NOT NULL,
  `applyPhone` varchar(11) NOT NULL,
  `applyEmail` varchar(20) NOT NULL,
  `applyDate` varchar(40) NOT NULL,
  `applyPosition` varchar(40) NOT NULL,
  `penScore` int(3) default NULL,
  `faceScore` int(3) default NULL,
  `evaluate` varchar(120) default NULL,
  `applyState` varchar(20) default NULL,
  `applyGroup` varchar(20) default NULL,
  `applyCollege` varchar(20) default NULL,
  PRIMARY KEY  (`applyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of applyinfo
-- ----------------------------
INSERT INTO `applyinfo` VALUES ('1', 'lx', '女', '2000-09-23', '17882286393', '1632846502@qq.com', '2021-02-01', '前端', '89', '99', '厉害', '比试', null, '本科');
INSERT INTO `applyinfo` VALUES ('2', 'xiao', '男', '1999-02-09', '13278907655', '1632846502@qq.com', '2021-02-03', '后端', '90', '87', '厉害', '面试', null, '本科');
INSERT INTO `applyinfo` VALUES ('3', 'ming', '女', '1998-04-05', '17643245678', '1632846502@qq.com', '2020-09-21', 'UI', '79', '65', '厉害', null, null, '本科');
INSERT INTO `applyinfo` VALUES ('4', 'hong', '女', '1999-07-21', '15690876543', '1632846502@qq.com', '2021-01-23', '测试', '94', '79', '厉害', null, null, '本科');
INSERT INTO `applyinfo` VALUES ('5', 'bai', '男', '2000-05-14', '17654389021', '1632846502@qq.com', '2020-04-28', '运维啊', '89', '90', '棒极了\n                ', '未处理', '软件开发', '本科');
INSERT INTO `applyinfo` VALUES ('7', 'baibai', '男', '1998-09-12', '17843267543', '1632846502@qq.com', '2021-01-23', '运营', '12', '0', '棒棒哒', null, null, '本科');
INSERT INTO `applyinfo` VALUES ('8', 'nihaoya', '女', '1999-09-21', '17854329074', '1632846502@qq.com', '2020-10-03', '测试', null, null, null, null, '测试', '本科');

/*
Navicat MySQL Data Transfer

Source Server         : test01
Source Server Version : 50041
Source Host           : localhost:3306
Source Database       : manage

Target Server Type    : MYSQL
Target Server Version : 50041
File Encoding         : 65001

Date: 2021-02-04 16:39:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `employinfo`
-- ----------------------------
DROP TABLE IF EXISTS `employinfo`;
CREATE TABLE `employinfo` (
  `employId` int(11) NOT NULL auto_increment,
  `employName` varchar(20) NOT NULL,
  `college` varchar(20) NOT NULL,
  `group` varchar(20) NOT NULL,
  `employPosition` varchar(20) NOT NULL,
  `employState` varchar(20) NOT NULL,
  `employDate` varchar(20) NOT NULL,
  PRIMARY KEY  (`employId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employinfo
-- ----------------------------
INSERT INTO `employinfo` VALUES ('1', '廖新', '西南石油大学', '软件开发', '前端', '在职', '2021-09-12');
INSERT INTO `employinfo` VALUES ('3', 'bgf', 'SWPU', '测试', '测试', '在职', '2020-02-15');
INSERT INTO `employinfo` VALUES ('4', 'bai', '本科', '软件开发', '运维啊', '在职', '2021-02-03 ');

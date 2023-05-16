/*
Navicat MySQL Data Transfer

Source Server         : mysql@localhost
Source Server Version : 50171
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50171
File Encoding         : 65001

Date: 2018-11-13 16:18:03
*/

use `test`;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO `author` VALUES ('1', '黑马');
INSERT INTO `author` VALUES ('2', '李四');
INSERT INTO `author` VALUES ('3', '王五');
INSERT INTO `author` VALUES ('4', '谭浩强');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `author_id` int(255) DEFAULT NULL,
  `publish_date` date DEFAULT NULL,
  `press` varchar(255) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `author_id` (`author_id`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', 'JavaWeb', '1234', '1', '2018-11-13', '清华大学出版社', '20');


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `real_name` varchar(255) DEFAULT NULL COMMENT '实名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'lisi', 'lisi', '李四');
INSERT INTO `user` VALUES ('2', 'zhang', 'zhang', null);
INSERT INTO `user` VALUES ('3', 'wang', 'wang', null);
INSERT INTO `user` VALUES ('4', '老王', 'wang', null);
INSERT INTO `user` VALUES ('5', 'some', 'some', null);

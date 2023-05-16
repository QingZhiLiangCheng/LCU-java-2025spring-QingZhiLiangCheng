/*
Navicat MySQL Data Transfer

Source Server         : q
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : goodedu

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2016-10-10 09:49:29
*/

DROP database IF EXISTS `goodedu`;
create database `goodedu`;
use `goodedu`;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(255) NOT NULL,
  `course_no` varchar(255) NOT NULL,
  `credit` int(11) DEFAULT '0' COMMENT '学分',
  `teacher_id` bigint(20) DEFAULT NULL COMMENT '授课教师ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `course_no` (`course_no`),
  KEY `fk_course_teacher_id` (`teacher_id`),
  CONSTRAINT `fk_course_teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', 'Web应用开发', '001', '2', '1');
INSERT INTO `course` VALUES ('2', '脚本编程技术', '002', '2', '1');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `student_id` bigint(20) DEFAULT NULL,
  `course_id` bigint(20) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL COMMENT '课程类型',
  `score` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_score_student_id` (`student_id`),
  KEY `fk_score_course_id` (`course_id`),
  CONSTRAINT `fk_score_course_id` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
  CONSTRAINT `fk_score_student_id` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('1', '1', '1', null, '0');
INSERT INTO `score` VALUES ('2', '2', '1', null, '100');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `student_no` varchar(20) NOT NULL,
  `student_name` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `favorites` varchar(255) DEFAULT NULL COMMENT '兴趣爱好，逗号分隔的列表',
  PRIMARY KEY (`id`),
  UNIQUE KEY `student_no` (`student_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '2014204366', '张三', '123', null, null, null);
INSERT INTO `student` VALUES ('2', '2014204367', '李四', '123', null, null, null);
INSERT INTO `student` VALUES ('3', '2014204300', '王五', '123', null, null, null);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `teacher_no` varchar(20) NOT NULL COMMENT '职工号',
  `password` varchar(255) DEFAULT NULL,
  `teacher_name` varchar(255) NOT NULL,
  `gender` varchar(1) DEFAULT '女' COMMENT '性别',
  `title` varchar(255) DEFAULT NULL COMMENT '职称',
  `birthdate` date DEFAULT NULL COMMENT '出生日期',
  `vote` int(11) DEFAULT NULL COMMENT '该老师的获得的投票数量',
  PRIMARY KEY (`id`),
  UNIQUE KEY `teacher_no` (`teacher_no`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '130019', '123', '凌海云', '男', null, null, '0');
INSERT INTO `teacher` VALUES ('2', '130020', '123', '许老师', '女', null, null, '0');
INSERT INTO `teacher` VALUES ('3', '130021', '123', '孔子', '男', null, null, '0');
INSERT INTO `teacher` VALUES ('4', '130022', '123', '孙子', '男', null, null, '1');
INSERT INTO `teacher` VALUES ('5', '130023', '123', '孟子', '男', null, null, '1');
INSERT INTO `teacher` VALUES ('7', '130024', '123', '爱因斯坦', '男', null, null, '0');
INSERT INTO `teacher` VALUES ('8', '130025', '123', '居里夫人', '女', null, null, '0');

-- ----------------------------
-- Table structure for vote
-- ----------------------------
DROP TABLE IF EXISTS `vote`;
CREATE TABLE `vote` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `teacher_id` bigint(20) NOT NULL,
  `vote` int(11) NOT NULL COMMENT '当前教师的投票数量',
  PRIMARY KEY (`id`),
  KEY `fk_vote_teacher_id` (`teacher_id`),
  CONSTRAINT `fk_vote_teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vote
-- ----------------------------

-- ----------------------------
-- Procedure structure for get_average_score_of_course
-- ----------------------------
DROP PROCEDURE IF EXISTS `get_average_score_of_course`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_average_score_of_course`(IN `course_id` bigint, OUT `average_score` FLOAT)
BEGIN
		select AVG( score.score ) into average_score from score WHERE score.course_id = course_id;
END
;;
DELIMITER ;

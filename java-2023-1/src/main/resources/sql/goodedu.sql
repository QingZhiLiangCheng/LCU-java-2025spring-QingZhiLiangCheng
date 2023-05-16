/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50711
 Source Host           : localhost:3306
 Source Schema         : goodedu

 Target Server Type    : MySQL
 Target Server Version : 50711
 File Encoding         : 65001

 Date: 24/05/2022 17:13:58
*/

DROP database IF EXISTS `goodedu`;
create database `goodedu`;
use `goodedu`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `credit` int(11) NULL DEFAULT 0 COMMENT '学分',
  `teacher_id` bigint(20) NULL DEFAULT NULL COMMENT '授课教师ID',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `course_no`(`course_no`) USING BTREE,
  INDEX `fk_course_teacher_id`(`teacher_id`) USING BTREE,
  CONSTRAINT `fk_course_teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, 'Web应用开发', '001', 2, 1);
INSERT INTO `course` VALUES (2, '脚本编程技术', '002', 2, 1);

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `student_id` bigint(20) NULL DEFAULT NULL,
  `course_id` bigint(20) NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程类型',
  `score` float NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_score_student_id`(`student_id`) USING BTREE,
  INDEX `fk_score_course_id`(`course_id`) USING BTREE,
  CONSTRAINT `fk_score_course_id` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_score_student_id` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES (1, 1, 1, NULL, 0);
INSERT INTO `score` VALUES (2, 2, 1, NULL, 100);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `student_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `student_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthdate` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `student_no`(`student_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1020 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '2014204366', '张三', '22222', '男', NULL);
INSERT INTO `student` VALUES (2, '2014204367', '李四', '123', NULL, NULL);
INSERT INTO `student` VALUES (3, '2014204300', '王五', '123', NULL, NULL);
INSERT INTO `student` VALUES (999, '2018123456', 'lisi', NULL, NULL, NULL);
INSERT INTO `student` VALUES (1002, '2018123455', 'lisi', NULL, NULL, NULL);
INSERT INTO `student` VALUES (1003, '1111', 'lisi', '123', NULL, NULL);
INSERT INTO `student` VALUES (1011, '2019654321', 'li', '22222', NULL, NULL);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `teacher_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职工号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teacher_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '女' COMMENT '性别',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职称',
  `birthdate` date NULL DEFAULT NULL COMMENT '出生日期',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `teacher_no`(`teacher_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '130019', '123', '凌海云', '男', NULL, NULL);
INSERT INTO `teacher` VALUES (2, '130020', '123', '王老师', '女', NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `gender` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthdate` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'lisi', '123456', '李四', '男', '2016-01-24');
INSERT INTO `user` VALUES (2, 'zhang', '123', '张三', '女', '2021-09-21');

SET FOREIGN_KEY_CHECKS = 1;

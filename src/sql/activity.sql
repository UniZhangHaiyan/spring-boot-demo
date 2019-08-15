/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost
 Source Database       : activity

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : utf-8

 Date: 08/15/2019 16:46:13 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `score`
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
  `student_code` varchar(30) NOT NULL COMMENT '学生编号',
  `course_code` varchar(30) NOT NULL COMMENT '课程编号',
  `score` double(30,0) NOT NULL COMMENT '成绩',
  PRIMARY KEY (`id`),
  UNIQUE KEY `all_unique` (`student_code`,`course_code`,`score`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat Premium Data Transfer

 Source Server         : MySQL-1
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : javaweb_bbs

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 22/06/2019 22:46:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for forum
-- ----------------------------
DROP TABLE IF EXISTS `forum`;
CREATE TABLE `forum`  (
  `forum_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `forum_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `forum_desc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `by_area_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`forum_id`) USING BTREE,
  UNIQUE INDEX `forum_name`(`forum_name`) USING BTREE,
  INDEX `forum_ibfk_1`(`by_area_id`) USING BTREE,
  CONSTRAINT `forum_ibfk_1` FOREIGN KEY (`by_area_id`) REFERENCES `area` (`area_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

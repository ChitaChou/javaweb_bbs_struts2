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

 Date: 22/06/2019 22:46:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for thread
-- ----------------------------
DROP TABLE IF EXISTS `thread`;
CREATE TABLE `thread`  (
  `thread_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `writer_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `by_forum_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `latest_post_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `thread_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `thread_text` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`thread_id`) USING BTREE,
  INDEX `thread_ibfk_1`(`writer_id`) USING BTREE,
  INDEX `thread_ibfk_2`(`by_forum_id`) USING BTREE,
  CONSTRAINT `thread_ibfk_1` FOREIGN KEY (`writer_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `thread_ibfk_2` FOREIGN KEY (`by_forum_id`) REFERENCES `forum` (`forum_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

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

 Date: 22/06/2019 22:46:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply`  (
  `reply_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `reply_writer_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `by_thread_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reply_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reply_text` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `2nd_reply_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`reply_id`) USING BTREE,
  INDEX `reply_ibfk_1`(`reply_writer_id`) USING BTREE,
  INDEX `reply_ibfk_2`(`by_thread_id`) USING BTREE,
  INDEX `reply_ibfk_3`(`2nd_reply_id`) USING BTREE,
  CONSTRAINT `reply_ibfk_1` FOREIGN KEY (`reply_writer_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `reply_ibfk_2` FOREIGN KEY (`by_thread_id`) REFERENCES `thread` (`thread_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `reply_ibfk_3` FOREIGN KEY (`2nd_reply_id`) REFERENCES `reply` (`reply_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

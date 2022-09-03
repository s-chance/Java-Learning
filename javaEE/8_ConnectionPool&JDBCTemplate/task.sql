/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : task

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 29/08/2022 23:30:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for coder
-- ----------------------------
DROP TABLE IF EXISTS `coder`;
CREATE TABLE `coder`  (
  `id` int(11) DEFAULT NULL,
  `name` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `grade` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `project` int(11) DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coder
-- ----------------------------
INSERT INTO `coder` VALUES (1, 'Mike', 100, 'A', 1);
INSERT INTO `coder` VALUES (2, 'Jhon', 96, 'A', 2);
INSERT INTO `coder` VALUES (3, 'Dram', 60, 'D', NULL);
INSERT INTO `coder` VALUES (4, 'Lambda', 100, 'A', NULL);
INSERT INTO `coder` VALUES (5, 'LuBen', 89, 'B', 3);
INSERT INTO `coder` VALUES (6, 'K', 75, 'C', NULL);
INSERT INTO `coder` VALUES (7, 'Z', 88, 'C', NULL);
INSERT INTO `coder` VALUES (8, 'L', 75, 'B', NULL);

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp`  (
  `id` int(11) DEFAULT NULL,
  `name` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` char(20) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  `salary` double DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES (1, 'a', 19, '男', 3500);
INSERT INTO `emp` VALUES (2, 'b', 22, '男', 5600);
INSERT INTO `emp` VALUES (3, 'c', 34, '女', 7700);
INSERT INTO `emp` VALUES (4, 'd', 16, '男', 4300);
INSERT INTO `emp` VALUES (5, 'e', 51, '女', 4300);
INSERT INTO `emp` VALUES (6, 'f', 23, '女', 4300);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `password` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'tom', 123);
INSERT INTO `user` VALUES (2, 'fay', 424);

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : 10_demo

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 01/09/2022 19:16:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `gender` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `address` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `qq` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '黎明', '男', 20, '广东', '1234567890', 'liming@123.com', 'admin', '123');
INSERT INTO `user` VALUES (3, 'apo', '女', 23, '广西', '1213131212', '1213131212@123.com', NULL, NULL);
INSERT INTO `user` VALUES (6, 'ajax', '男', 21, '广东', '1341652612', '1341652612@123.com', NULL, NULL);
INSERT INTO `user` VALUES (7, '测试1', '女', 12, '广东', '', '', NULL, NULL);
INSERT INTO `user` VALUES (8, '测试2', '男', NULL, '广东', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (9, '测试3', '男', NULL, '广西', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (12, '测试6', '男', NULL, '湖南', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (13, '测试7', '男', NULL, '广西', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (14, '测试8', '男', NULL, '湖南', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (15, '测试9', '男', NULL, '广西', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (16, '测试10', '男', NULL, '湖南', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (20, 'qwq', '女', 19, '湖南', '', '', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;

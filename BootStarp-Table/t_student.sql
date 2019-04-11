/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50528
 Source Host           : localhost:3306
 Source Schema         : cdb

 Target Server Type    : MySQL
 Target Server Version : 50528
 File Encoding         : 65001

 Date: 04/04/2019 09:42:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `age` int(57) NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES (1, '张三', 23, '18328564682', '成都市青羊区');
INSERT INTO `t_student` VALUES (2, '李四', 35, '132132121', '成都市青羊区');
INSERT INTO `t_student` VALUES (3, '万物', 46, '21231312', '成都市青羊区');
INSERT INTO `t_student` VALUES (4, '阿萨德', 23, '121321321', '成都市青羊区');
INSERT INTO `t_student` VALUES (5, '发给', 57, '325235235', '成都市青羊区');
INSERT INTO `t_student` VALUES (6, '请问', 24, '3412423432', '成都市青羊区');

SET FOREIGN_KEY_CHECKS = 1;

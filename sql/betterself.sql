/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 50721
Source Host           : 47.106.134.165:3306
Source Database       : betterself

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-11-24 23:22:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '主键ID',
  `user_no` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '用户编码',
  `account` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '账号',
  `name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `password` varchar(128) COLLATE utf8_bin NOT NULL COMMENT '密码',
  `gender` tinyint(1) DEFAULT '1' COMMENT '性别',
  `tell` varchar(18) COLLATE utf8_bin DEFAULT NULL COMMENT '电话',
  `email` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '电子邮件',
  `remark` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `create_user` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '最后修改人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_account` (`account`) USING BTREE,
  KEY `idx_name` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户信息表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '1', 'admin', '超管', '1', '1', null, null, '勿删', null, null, null, null);

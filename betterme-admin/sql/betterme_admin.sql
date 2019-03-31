-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_no` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '用户编码',
  `account` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '账号',
  `name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `password` varchar(128) COLLATE utf8_bin NOT NULL COMMENT '密码',
  `gender` tinyint(1) DEFAULT '1' COMMENT '性别',
  `tell` varchar(18) COLLATE utf8_bin DEFAULT NULL COMMENT '电话',
  `email` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '电子邮件',
  `status` tinyint(3) NOT NULL DEFAULT '1' COMMENT '状态',
  `create_user` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '最后修改人',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `remark` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_account` (`account`) USING BTREE,
  KEY `idx_name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户信息表';

-- ----------------------------
-- Table structure for `operation_log`
-- ----------------------------
DROP TABLE IF EXISTS `operation_log`;
CREATE TABLE `operation_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `opt_no` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '操作编码',
  `opt_type` tinyint(3) NOT NULL DEFAULT '1' COMMENT '操作类型，1-新增，2-修改，3-删除',
  `opt_content` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '操作的数据的id或者编码',
  `module_no` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '模块编码',
  `status` tinyint(3) NOT NULL DEFAULT '1' COMMENT '状态',
  `create_user` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '最后修改人',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `remark` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_opt_no` (`opt_no`) USING BTREE,
  KEY `idx_opt_content` (`opt_content`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='操作日志表';
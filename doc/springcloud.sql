/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : springcloud

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-01-15 11:00:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_base_element
-- ----------------------------
DROP TABLE IF EXISTS `t_base_element`;
CREATE TABLE `t_base_element` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `menu_id` varchar(32) DEFAULT NULL COMMENT '菜单ID',
  `code` varchar(150) DEFAULT NULL COMMENT '资源编码',
  `name` varchar(50) DEFAULT NULL COMMENT '元素名称',
  `uri` varchar(150) DEFAULT NULL COMMENT '执行该操作需要的权限地址',
  `method` varchar(50) DEFAULT NULL COMMENT '请求类型',
  `date_created` datetime DEFAULT NULL COMMENT '数据输入日期',
  `create_id` varchar(50) DEFAULT NULL COMMENT '建立者ID',
  `create_ip` varchar(50) DEFAULT NULL COMMENT '建立者IP',
  `date_updated` datetime DEFAULT NULL COMMENT '资料更新日期',
  `update_id` varchar(50) DEFAULT NULL COMMENT '修改者ID',
  `update_ip` varchar(50) DEFAULT NULL COMMENT '修改者IP',
  `version` int(11) DEFAULT '0' COMMENT 'VERSION',
  `del_flag` char(1) DEFAULT '0' COMMENT '0否1是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='页面元素';

-- ----------------------------
-- Records of t_base_element
-- ----------------------------
INSERT INTO `t_base_element` VALUES ('34e94bb388e146e8b27712713503589c', '16f5373e51dc4245b7e1d8e185f8cb15', 'userManager:view', '查询', '/sysAdmin/user', 'GET', null, null, null, null, null, null, '0', '0');
INSERT INTO `t_base_element` VALUES ('352a02ed554d4d269407935c36198271', '16f5373e51dc4245b7e1d8e185f8cb15', 'userManager:btn_add', '新增', '/sysAdmin/user', 'POST', null, null, null, null, null, null, '0', '0');
INSERT INTO `t_base_element` VALUES ('35c6fce7f6a446f89696fcf5c2593cdb', '16f5373e51dc4245b7e1d8e185f8cb15', 'userManager:btn_upd', '编辑', '/sysAdmin/user', 'UPDATE', null, null, null, null, null, null, '0', '0');
INSERT INTO `t_base_element` VALUES ('363c9469368c4f249d4c67a6bb4bf8e9', '16f5373e51dc4245b7e1d8e185f8cb15', 'userManager:btn_del', '删除', '/sysAdmin/user', 'DELETE', null, null, null, null, null, null, '0', '0');
INSERT INTO `t_base_element` VALUES ('3668d4d9e4164ef1b2541fcb5bba97e1', '186d664a81e44ca48f58aaaf16c6d221', 'groupManager:view', '查询', '/sysAdmin/group', 'GET', null, null, null, null, null, null, '0', '0');
INSERT INTO `t_base_element` VALUES ('368664d6a0d3485ea05cc73efbe49837', '186d664a81e44ca48f58aaaf16c6d221', 'groupManager:btn_add', '新增', '/sysAdmin/group', 'POST', null, null, null, null, null, null, '0', '0');
INSERT INTO `t_base_element` VALUES ('36b74e5685d34c1e9c0c931253cb1b4e', '186d664a81e44ca48f58aaaf16c6d221', 'groupManager:btn_upd', '编辑', '/sysAdmin/group', 'UPDATE', null, null, null, null, null, null, '0', '0');
INSERT INTO `t_base_element` VALUES ('3721a60a06524fed8711de3bc358e1d6', '186d664a81e44ca48f58aaaf16c6d221', 'groupManager:btn_del', '删除', '/sysAdmin/group', 'DELETE', null, null, null, null, null, null, '0', '0');
INSERT INTO `t_base_element` VALUES ('3721f2e336054058acfea69517be9f0d', '-1', null, '登陆', '/sysAuth/auth/login', 'POST', null, null, null, null, null, null, '0', '0');

-- ----------------------------
-- Table structure for t_base_group
-- ----------------------------
DROP TABLE IF EXISTS `t_base_group`;
CREATE TABLE `t_base_group` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `code` varchar(50) DEFAULT NULL COMMENT '组编码',
  `name` varchar(50) DEFAULT NULL COMMENT '组名',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父级组',
  `path` varchar(150) DEFAULT NULL COMMENT '组路径关系',
  `type` varchar(32) DEFAULT NULL COMMENT '组类型',
  `date_created` datetime DEFAULT NULL COMMENT '数据输入日期',
  `create_id` varchar(50) DEFAULT NULL COMMENT '建立者ID',
  `create_ip` varchar(50) DEFAULT NULL COMMENT '建立者IP',
  `date_updated` datetime DEFAULT NULL COMMENT '资料更新日期',
  `update_id` varchar(50) DEFAULT NULL COMMENT '修改者ID',
  `update_ip` varchar(50) DEFAULT NULL COMMENT '修改者IP',
  `version` int(11) DEFAULT '0' COMMENT 'VERSION',
  `del_flag` char(1) DEFAULT '0' COMMENT '0否1是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组信息';

-- ----------------------------
-- Records of t_base_group
-- ----------------------------
INSERT INTO `t_base_group` VALUES ('0a564344dbc241cb9fd2a7e78d9db486', 'admin', '管理员组', '-1', '/admin', '1', null, null, null, null, null, null, '0', '0');

-- ----------------------------
-- Table structure for t_base_group_leader
-- ----------------------------
DROP TABLE IF EXISTS `t_base_group_leader`;
CREATE TABLE `t_base_group_leader` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `group_id` varchar(32) DEFAULT NULL COMMENT '组ID',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组领导者';

-- ----------------------------
-- Records of t_base_group_leader
-- ----------------------------
INSERT INTO `t_base_group_leader` VALUES ('0741b62c0f034d25b3f0dc1adb5c65c8', '0a564344dbc241cb9fd2a7e78d9db486', '03a7fbdc3d444c85a00047d3ca604034');

-- ----------------------------
-- Table structure for t_base_group_member
-- ----------------------------
DROP TABLE IF EXISTS `t_base_group_member`;
CREATE TABLE `t_base_group_member` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `group_id` varchar(32) DEFAULT NULL COMMENT '组ID',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组成员';

-- ----------------------------
-- Records of t_base_group_member
-- ----------------------------

-- ----------------------------
-- Table structure for t_base_group_type
-- ----------------------------
DROP TABLE IF EXISTS `t_base_group_type`;
CREATE TABLE `t_base_group_type` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '类型名',
  `date_created` datetime DEFAULT NULL COMMENT '数据输入日期',
  `create_id` varchar(50) DEFAULT NULL COMMENT '建立者ID',
  `create_ip` varchar(50) DEFAULT NULL COMMENT '建立者IP',
  `date_updated` datetime DEFAULT NULL COMMENT '资料更新日期',
  `update_id` varchar(50) DEFAULT NULL COMMENT '修改者ID',
  `update_ip` varchar(50) DEFAULT NULL COMMENT '修改者IP',
  `version` int(11) DEFAULT '0' COMMENT 'VERSION',
  `del_flag` char(1) DEFAULT '0' COMMENT '0否1是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组类型';

-- ----------------------------
-- Records of t_base_group_type
-- ----------------------------

-- ----------------------------
-- Table structure for t_base_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_base_menu`;
CREATE TABLE `t_base_menu` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `code` varchar(50) DEFAULT NULL COMMENT '路径编码',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父级菜单',
  `path` varchar(150) DEFAULT NULL COMMENT '菜单路径关系',
  `href` varchar(150) DEFAULT NULL COMMENT '菜单地址',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `sort` int(10) DEFAULT NULL COMMENT '排序',
  `date_created` datetime DEFAULT NULL COMMENT '数据输入日期',
  `create_id` varchar(50) DEFAULT NULL COMMENT '建立者ID',
  `create_ip` varchar(50) DEFAULT NULL COMMENT '建立者IP',
  `date_updated` datetime DEFAULT NULL COMMENT '资料更新日期',
  `update_id` varchar(50) DEFAULT NULL COMMENT '修改者ID',
  `update_ip` varchar(50) DEFAULT NULL COMMENT '修改者IP',
  `version` int(11) DEFAULT '0' COMMENT 'VERSION',
  `del_flag` char(1) DEFAULT '0' COMMENT '0否1是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单';

-- ----------------------------
-- Records of t_base_menu
-- ----------------------------
INSERT INTO `t_base_menu` VALUES ('15809d9eec174692aadb6c1af64b1ddf', 'sysAdmin', '系统管理', '-1', '/sysAdmin', '', null, '1', null, null, null, null, null, null, '0', '0');
INSERT INTO `t_base_menu` VALUES ('16f5373e51dc4245b7e1d8e185f8cb15', 'sysUser', '用户管理', '15809d9eec174692aadb6c1af64b1ddf', '/sysAdmin/sysUser', null, null, '1', null, null, null, null, null, null, '0', '0');
INSERT INTO `t_base_menu` VALUES ('186d664a81e44ca48f58aaaf16c6d221', 'sysGroup', '组管理', '15809d9eec174692aadb6c1af64b1ddf', '/sysAdmin/sysGroup', null, null, '2', null, null, null, null, null, null, '0', '0');
INSERT INTO `t_base_menu` VALUES ('38a054e013d1485ca5266f2213414523', 'home', '主页', '-1', '/home/init', null, null, '1', null, null, null, null, null, null, '0', '0');

-- ----------------------------
-- Table structure for t_base_resource_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_base_resource_authority`;
CREATE TABLE `t_base_resource_authority` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `group_id` varchar(32) DEFAULT NULL COMMENT '组id',
  `resource_id` varchar(32) DEFAULT NULL COMMENT '资源（菜单，元素）id',
  `type` varchar(50) DEFAULT NULL COMMENT '菜单（menu），元素（element）',
  `date_created` datetime DEFAULT NULL COMMENT '数据输入日期',
  `create_id` varchar(50) DEFAULT NULL COMMENT '建立者ID',
  `create_ip` varchar(50) DEFAULT NULL COMMENT '建立者IP',
  `date_updated` datetime DEFAULT NULL COMMENT '资料更新日期',
  `update_id` varchar(50) DEFAULT NULL COMMENT '修改者ID',
  `update_ip` varchar(50) DEFAULT NULL COMMENT '修改者IP',
  `version` int(11) DEFAULT '0' COMMENT 'VERSION',
  `del_flag` char(1) DEFAULT '0' COMMENT '0否1是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源权限';

-- ----------------------------
-- Records of t_base_resource_authority
-- ----------------------------
INSERT INTO `t_base_resource_authority` VALUES ('1', '0a564344dbc241cb9fd2a7e78d9db486', '16f5373e51dc4245b7e1d8e185f8cb15', 'menu', null, null, null, null, null, null, '0', '0');
INSERT INTO `t_base_resource_authority` VALUES ('2', '0a564344dbc241cb9fd2a7e78d9db486', '34e94bb388e146e8b27712713503589c', 'resource', null, null, null, null, null, null, '0', '0');
INSERT INTO `t_base_resource_authority` VALUES ('3', '0a564344dbc241cb9fd2a7e78d9db486', '352a02ed554d4d269407935c36198271', 'resource', null, null, null, null, null, null, '0', '0');
INSERT INTO `t_base_resource_authority` VALUES ('4', '0a564344dbc241cb9fd2a7e78d9db486', '35c6fce7f6a446f89696fcf5c2593cdb', 'resource', null, null, null, null, null, null, '0', '0');
INSERT INTO `t_base_resource_authority` VALUES ('5', '0a564344dbc241cb9fd2a7e78d9db486', '363c9469368c4f249d4c67a6bb4bf8e9', 'resource', null, null, null, null, null, null, '0', '0');
INSERT INTO `t_base_resource_authority` VALUES ('7', '0a564344dbc241cb9fd2a7e78d9db486', '15809d9eec174692aadb6c1af64b1ddf', 'menu', null, null, null, null, null, null, '0', '0');
INSERT INTO `t_base_resource_authority` VALUES ('8', '0a564344dbc241cb9fd2a7e78d9db486', '38a054e013d1485ca5266f2213414523', 'menu', null, null, null, null, null, null, '0', '0');

-- ----------------------------
-- Table structure for t_base_user
-- ----------------------------
DROP TABLE IF EXISTS `t_base_user`;
CREATE TABLE `t_base_user` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(150) DEFAULT NULL COMMENT '密码',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `gender` varchar(1) DEFAULT NULL COMMENT '1:男2女3保密',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `email` varchar(30) DEFAULT NULL COMMENT '电子邮件',
  `head_img` varchar(155) DEFAULT NULL COMMENT '头像',
  `address` varchar(200) DEFAULT NULL COMMENT '住址',
  `reg_date` datetime DEFAULT NULL COMMENT '注册日期',
  `enabled` char(5) DEFAULT '1' COMMENT '1可用的 0不可用',
  `last_login` datetime DEFAULT NULL COMMENT '最后登入时间',
  `credential_code` varchar(50) DEFAULT NULL COMMENT '证件号码',
  `credential` varchar(50) DEFAULT NULL COMMENT '证件类型',
  `date_created` datetime DEFAULT NULL COMMENT '数据输入日期',
  `create_id` varchar(50) DEFAULT NULL COMMENT '建立者ID',
  `create_ip` varchar(50) DEFAULT NULL COMMENT '建立者IP',
  `date_updated` datetime DEFAULT NULL COMMENT '资料更新日期',
  `update_id` varchar(50) DEFAULT NULL COMMENT '修改者ID',
  `update_ip` varchar(50) DEFAULT NULL COMMENT '修改者IP',
  `version` int(11) DEFAULT '0' COMMENT 'VERSION',
  `del_flag` char(1) DEFAULT '0' COMMENT '0否1是',
  PRIMARY KEY (`id`),
  KEY `sys_c006744` (`username`),
  KEY `real_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户基本信息';

-- ----------------------------
-- Records of t_base_user
-- ----------------------------
INSERT INTO `t_base_user` VALUES ('03a7fbdc3d444c85a00047d3ca604034', 'admin', '111111', '邹朝亮', null, null, null, null, 'http://yysh.962020.com/yyshWeb/img/index_02.png', null, null, '1', null, null, null, '2017-11-28 12:28:16', null, null, '2017-11-30 12:28:13', null, null, '0', '0');
INSERT INTO `t_base_user` VALUES ('12345', 'zoucl111', '111111', '邹朝亮123', null, null, null, null, null, null, null, '1', null, null, null, '2017-12-06 18:18:43', '1', '127.0.0.1', '2017-12-06 18:18:43', '1', '127.0.0.1', '0', '0');
INSERT INTO `t_base_user` VALUES ('2', 'chenghong', '111111', '橙红', null, null, null, null, null, null, null, '1', null, null, null, '2017-12-04 10:43:01', null, null, '2017-12-04 10:43:05', null, null, '0', '0');

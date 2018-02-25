/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : springcloud

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-02-25 14:21:25
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
INSERT INTO `t_base_element` VALUES ('00885895f7854fa89364b06c1f56c237', '01e886d372de4a89bb70bfd1ac0204fd', 'sysAdminElement:view', '元素查询', '/sysAdmin/element', 'GET', null, null, null, '2018-02-01 14:35:26', '03a7fbdc3d444c85a00047d3ca604034', '127.0.0.1', '0', '0');
INSERT INTO `t_base_element` VALUES ('008da25baf374e48ba0bc0e390bf1f32', '0', null, '个人信息', '/sysAdmin/user/loginUserInfo', 'GET', null, null, null, null, null, null, '0', '0');
INSERT INTO `t_base_element` VALUES ('00f697e6a15949f7b0f45ec368f8db39', '01e886d372de4a89bb70bfd1ac0204fd', 'sysAdminElement:btn_add', '元素新增', '/sysAdmin/element', 'POST', null, null, null, '2018-02-01 14:35:51', '03a7fbdc3d444c85a00047d3ca604034', '127.0.0.1', '0', '0');
INSERT INTO `t_base_element` VALUES ('01fb513845714f988c7658f70aa4c76d', '01e886d372de4a89bb70bfd1ac0204fd', 'sysAdminMenu:view', '菜单查询', '/sysAdmin/menu', 'GET', null, null, null, '2018-02-01 14:35:57', '03a7fbdc3d444c85a00047d3ca604034', '127.0.0.1', '0', '0');
INSERT INTO `t_base_element` VALUES ('02282fa13a69466686240cb58175ed72', '01e886d372de4a89bb70bfd1ac0204fd', 'sysAdminElement:btn_upd', '元素编辑', '/sysAdmin/element', 'PUT', null, null, null, '2018-02-01 14:36:07', '03a7fbdc3d444c85a00047d3ca604034', '127.0.0.1', '0', '0');
INSERT INTO `t_base_element` VALUES ('02707c75fe374c1ebd6c1b975d552df2', '01e886d372de4a89bb70bfd1ac0204fd', 'sysAdminMenu:btn_add', '菜单新增', '/sysAdmin/menu', 'POST', null, null, null, '2018-02-01 15:19:51', '03a7fbdc3d444c85a00047d3ca604034', '127.0.0.1', '0', '0');
INSERT INTO `t_base_element` VALUES ('028cdb9bde85420a8b4eb96c188a9495', '01e886d372de4a89bb70bfd1ac0204fd', 'sysAdminMenu:btn_upd', '菜单编辑', '/sysAdmin/menu', 'PUT', null, null, null, '2018-02-01 14:36:18', '03a7fbdc3d444c85a00047d3ca604034', '127.0.0.1', '0', '0');
INSERT INTO `t_base_element` VALUES ('0299fd47170b4f949796710201850f58', '01e886d372de4a89bb70bfd1ac0204fd', 'sysAdminMenu:btn_del', '菜单删除', '/sysAdmin/menu', 'DELETE', null, null, null, '2018-02-01 14:36:23', '03a7fbdc3d444c85a00047d3ca604034', '127.0.0.1', '0', '0');
INSERT INTO `t_base_element` VALUES ('12', '0', null, '七牛上传', '/sysAdmin/qiniu', 'GET', null, null, null, null, null, null, '0', '0');
INSERT INTO `t_base_element` VALUES ('153054137682453a967ed67d21af21a8', '01e886d372de4a89bb70bfd1ac0204fd', 'sysAdminMenu:btn_del', '元素删除', '/sysAdmin/element', 'DELETE', '2018-02-01 15:18:08', '03a7fbdc3d444c85a00047d3ca604034', '127.0.0.1', '2018-02-01 15:18:08', '03a7fbdc3d444c85a00047d3ca604034', '127.0.0.1', '0', '0');
INSERT INTO `t_base_element` VALUES ('302b4794979a4e7ea5d3ffa6f46a378e', '186d664a81e44ca48f58aaaf16c6d221', 'sysAdminGroup:user:view', '用户查询', '/sysAdmin/user', 'GET', '2018-02-01 23:13:05', '03a7fbdc3d444c85a00047d3ca604034', '127.0.0.1', '2018-02-02 12:15:44', '03a7fbdc3d444c85a00047d3ca604034', '127.0.0.1', '0', '0');
INSERT INTO `t_base_element` VALUES ('34e94bb388e146e8b27712713503589c', '16f5373e51dc4245b7e1d8e185f8cb15', 'sysAdminUser:view', '查询', '/sysAdmin/user', 'GET', null, null, null, null, null, null, '0', '0');
INSERT INTO `t_base_element` VALUES ('352a02ed554d4d269407935c36198271', '16f5373e51dc4245b7e1d8e185f8cb15', 'sysAdminUser:btn_add', '新增', '/sysAdmin/user', 'POST', null, null, null, null, null, null, '0', '0');
INSERT INTO `t_base_element` VALUES ('35c6fce7f6a446f89696fcf5c2593cdb', '16f5373e51dc4245b7e1d8e185f8cb15', 'sysAdminUser:btn_upd', '编辑', '/sysAdmin/user', 'PUT', null, null, null, null, null, null, '0', '0');
INSERT INTO `t_base_element` VALUES ('363c9469368c4f249d4c67a6bb4bf8e9', '16f5373e51dc4245b7e1d8e185f8cb15', 'sysAdminUser:btn_del', '删除', '/sysAdmin/user', 'DELETE', null, null, null, null, null, null, '0', '0');
INSERT INTO `t_base_element` VALUES ('3668d4d9e4164ef1b2541fcb5bba97e1', '186d664a81e44ca48f58aaaf16c6d221', 'sysAdminGroup:view', '查询', '/sysAdmin/group', 'GET', null, null, null, null, null, null, '0', '0');
INSERT INTO `t_base_element` VALUES ('368664d6a0d3485ea05cc73efbe49837', '186d664a81e44ca48f58aaaf16c6d221', 'sysAdminGroup:btn_add', '新增', '/sysAdmin/group', 'POST', null, null, null, null, null, null, '0', '0');
INSERT INTO `t_base_element` VALUES ('36b74e5685d34c1e9c0c931253cb1b4e', '186d664a81e44ca48f58aaaf16c6d221', 'sysAdminGroup:btn_upd', '编辑', '/sysAdmin/group', 'PUT', null, null, null, null, null, null, '0', '0');
INSERT INTO `t_base_element` VALUES ('3721a60a06524fed8711de3bc358e1d6', '186d664a81e44ca48f58aaaf16c6d221', 'sysAdminGroup:btn_del', '删除', '/sysAdmin/group', 'DELETE', null, null, null, null, null, null, '0', '0');
INSERT INTO `t_base_element` VALUES ('3721f2e336054058acfea69517be9f0d', '-1', null, '登陆', '/sysAuth/auth/login', 'POST', null, null, null, null, null, null, '0', '0');
INSERT INTO `t_base_element` VALUES ('83acbf9faebe4d03a64f51052a9d594c', '186d664a81e44ca48f58aaaf16c6d221', 'sysAdminGroup:menu:view', '菜单查询', '/sysAdmin/menu', 'GET', '2018-02-01 23:14:03', '03a7fbdc3d444c85a00047d3ca604034', '127.0.0.1', '2018-02-02 12:15:58', '03a7fbdc3d444c85a00047d3ca604034', '127.0.0.1', '0', '0');

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
INSERT INTO `t_base_group` VALUES ('0a564344dbc241cb9fd2a7e78d9db486', 'admin', '管理员组', '-1', '/admin', '1', null, null, null, '2018-01-30 14:25:37', '03a7fbdc3d444c85a00047d3ca604034', '127.0.0.1', '0', '0');
INSERT INTO `t_base_group` VALUES ('489c84de2c2b49bd8288f037363c1825', 'test', '测试组', '0a564344dbc241cb9fd2a7e78d9db486', '/admin/test', '1', '2018-01-30 19:09:12', '03a7fbdc3d444c85a00047d3ca604034', '127.0.0.1', '2018-02-02 12:17:17', '03a7fbdc3d444c85a00047d3ca604034', '127.0.0.1', '0', '0');

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
INSERT INTO `t_base_group_leader` VALUES ('fbacb1d321a7446396cfe14ffcdb4a31', '489c84de2c2b49bd8288f037363c1825', '4516cfdbbee94193b81d157b82ff7b52');

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
  `path` varchar(150) DEFAULT NULL COMMENT '菜单地址',
  `href` varchar(150) DEFAULT NULL COMMENT '菜单地址（备用字段）',
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
INSERT INTO `t_base_menu` VALUES ('01e886d372de4a89bb70bfd1ac0204fd', 'sysAdminMenu', '菜单管理', '15809d9eec174692aadb6c1af64b1ddf', '/sysAdmin/menu/init', null, null, '3', null, null, null, '2018-02-01 12:09:35', '03a7fbdc3d444c85a00047d3ca604034', '127.0.0.1', '0', '0');
INSERT INTO `t_base_menu` VALUES ('15809d9eec174692aadb6c1af64b1ddf', 'sysAdmin', '系统管理', '-1', '/sysAdmin', '', null, '2', null, null, null, '2018-02-02 12:53:36', '03a7fbdc3d444c85a00047d3ca604034', '127.0.0.1', '0', '0');
INSERT INTO `t_base_menu` VALUES ('16f5373e51dc4245b7e1d8e185f8cb15', 'sysAdminUser', '用户管理', '15809d9eec174692aadb6c1af64b1ddf', '/sysAdmin/user/init', null, null, '1', null, null, null, '2018-01-31 23:52:41', '03a7fbdc3d444c85a00047d3ca604034', '127.0.0.1', '0', '0');
INSERT INTO `t_base_menu` VALUES ('186d664a81e44ca48f58aaaf16c6d221', 'sysAdminGroup', '组管理', '15809d9eec174692aadb6c1af64b1ddf', '/sysAdmin/group/init', null, null, '2', null, null, null, '2018-02-01 12:06:13', '03a7fbdc3d444c85a00047d3ca604034', '127.0.0.1', '0', '0');
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
  `is_show` varchar(1) DEFAULT NULL COMMENT '是否是后台添加的菜单（1是，0否）',
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
INSERT INTO `t_base_resource_authority` VALUES ('010d8d74d3984224bbcf7c8c0d65b2a0', '0a564344dbc241cb9fd2a7e78d9db486', '186d664a81e44ca48f58aaaf16c6d221', 'menu', '0', null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('03b808dcd50c4c8e82d47920ea030a09', '0a564344dbc241cb9fd2a7e78d9db486', '0299fd47170b4f949796710201850f58', 'resource', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('12d2302efcd64649be8d868f2ad09011', '0a564344dbc241cb9fd2a7e78d9db486', '3668d4d9e4164ef1b2541fcb5bba97e1', 'resource', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('140764d47db04c7c96261558994557ce', '0a564344dbc241cb9fd2a7e78d9db486', '01fb513845714f988c7658f70aa4c76d', 'resource', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('15821ed43ea040dd85084e2fa92357ef', '0a564344dbc241cb9fd2a7e78d9db486', '34e94bb388e146e8b27712713503589c', 'resource', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('22e94315928c4d1d9b6cfb90451e2b82', '0a564344dbc241cb9fd2a7e78d9db486', '3721a60a06524fed8711de3bc358e1d6', 'resource', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('25bf6e9a13a147af838a5c74763fb39a', '489c84de2c2b49bd8288f037363c1825', '028cdb9bde85420a8b4eb96c188a9495', 'resource', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('29e0dd03fe3f47ec9f13a8c67b4f5ec0', '489c84de2c2b49bd8288f037363c1825', '15809d9eec174692aadb6c1af64b1ddf', 'menu', '0', null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('2ab56d16db09444ab8d71df07a5569bf', '0a564344dbc241cb9fd2a7e78d9db486', '38a054e013d1485ca5266f2213414523', 'menu', '1', null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('35a8668d3c434dec9e21c7a04f42a2b6', '0a564344dbc241cb9fd2a7e78d9db486', '35c6fce7f6a446f89696fcf5c2593cdb', 'resource', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('5d1ec70702c44c1c8a4258ae0a9b275f', '489c84de2c2b49bd8288f037363c1825', '00885895f7854fa89364b06c1f56c237', 'resource', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('5fabe403458a4ae594aee823a22c4548', '0a564344dbc241cb9fd2a7e78d9db486', '028cdb9bde85420a8b4eb96c188a9495', 'resource', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('71d95dc6570b48daadc0766eac943299', '0a564344dbc241cb9fd2a7e78d9db486', '00f697e6a15949f7b0f45ec368f8db39', 'resource', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('72c98c91c7944b3c93a5fc3d5799a387', '489c84de2c2b49bd8288f037363c1825', '16f5373e51dc4245b7e1d8e185f8cb15', 'menu', '0', null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('8191535c87a140338ccb392187a9a9b6', '0a564344dbc241cb9fd2a7e78d9db486', '368664d6a0d3485ea05cc73efbe49837', 'resource', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('8387eda74bb84c79acd860b06b6bd12e', '489c84de2c2b49bd8288f037363c1825', '02282fa13a69466686240cb58175ed72', 'resource', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('853e218f8c74485d82cc944bb1d50592', '489c84de2c2b49bd8288f037363c1825', '0299fd47170b4f949796710201850f58', 'resource', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('91dd04ddcf5e4b41b922cf44a396b51e', '0a564344dbc241cb9fd2a7e78d9db486', '302b4794979a4e7ea5d3ffa6f46a378e', 'resource', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('941a57a7f4194a0a8e1268bba6320b48', '0a564344dbc241cb9fd2a7e78d9db486', '01e886d372de4a89bb70bfd1ac0204fd', 'menu', '0', null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('96a7722e8d07474b9ec773d68fec5959', '489c84de2c2b49bd8288f037363c1825', '01fb513845714f988c7658f70aa4c76d', 'resource', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('9aae0e44317842d7ae5dbf2157a13f5c', '0a564344dbc241cb9fd2a7e78d9db486', '153054137682453a967ed67d21af21a8', 'resource', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('9abf31c48b1b4872baff1112bba66f96', '0a564344dbc241cb9fd2a7e78d9db486', '352a02ed554d4d269407935c36198271', 'resource', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('adee00275c2c4c3a9caead5d8044f624', '0a564344dbc241cb9fd2a7e78d9db486', '02282fa13a69466686240cb58175ed72', 'resource', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('af9de6fe63254c6c9510c27b498ac1f9', '489c84de2c2b49bd8288f037363c1825', '01e886d372de4a89bb70bfd1ac0204fd', 'menu', '0', null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('afaa871e4cd7456e8a7088132c3c06b5', '0a564344dbc241cb9fd2a7e78d9db486', '00885895f7854fa89364b06c1f56c237', 'resource', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('b30ebf170a75439785495cc0d7717532', '489c84de2c2b49bd8288f037363c1825', '02707c75fe374c1ebd6c1b975d552df2', 'resource', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('b886fde01a1c463097c308d7495718e4', '0a564344dbc241cb9fd2a7e78d9db486', '36b74e5685d34c1e9c0c931253cb1b4e', 'resource', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('c3f63f11043b443f91216fa2a80f94a0', '0a564344dbc241cb9fd2a7e78d9db486', '16f5373e51dc4245b7e1d8e185f8cb15', 'menu', '0', null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('c79f1cee3f8842f29bdef1ddf8acce86', '0a564344dbc241cb9fd2a7e78d9db486', '83acbf9faebe4d03a64f51052a9d594c', 'resource', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('d2f3e40e37644b7a8f21d96b4f1b440b', '0a564344dbc241cb9fd2a7e78d9db486', '02707c75fe374c1ebd6c1b975d552df2', 'resource', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('e0ea537e88e7481dbec3112d4cce1ff5', '0a564344dbc241cb9fd2a7e78d9db486', '363c9469368c4f249d4c67a6bb4bf8e9', 'resource', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('e6bf633e10fa466c90b01c78c2e32f2d', '489c84de2c2b49bd8288f037363c1825', '34e94bb388e146e8b27712713503589c', 'resource', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('f01f8f4cb7914faa950da204c5fb6ae2', '0a564344dbc241cb9fd2a7e78d9db486', '15809d9eec174692aadb6c1af64b1ddf', 'menu', '0', null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('f6f9e2bf96fe469faf90aeeb3d456b9c', '489c84de2c2b49bd8288f037363c1825', '153054137682453a967ed67d21af21a8', 'resource', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_resource_authority` VALUES ('fb24a03578d449f38cb84f4b686f7c8d', '489c84de2c2b49bd8288f037363c1825', '00f697e6a15949f7b0f45ec368f8db39', 'resource', null, null, null, null, null, null, null, null, null);

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
INSERT INTO `t_base_user` VALUES ('03a7fbdc3d444c85a00047d3ca604034', 'admin', '111111', '邹朝亮', '0', '2018-01-24 00:00:00', '12345', null, null, null, null, null, null, null, null, null, null, null, '2018-02-02 14:02:40', '03a7fbdc3d444c85a00047d3ca604034', '127.0.0.1', '0', '0');
INSERT INTO `t_base_user` VALUES ('4516cfdbbee94193b81d157b82ff7b52', 'test123', '111111', '测试用户', '0', null, '124', '124', null, null, null, '1', null, null, null, '2018-02-01 21:50:07', '03a7fbdc3d444c85a00047d3ca604034', '127.0.0.1', '2018-02-01 21:50:36', '03a7fbdc3d444c85a00047d3ca604034', '127.0.0.1', '0', '0');

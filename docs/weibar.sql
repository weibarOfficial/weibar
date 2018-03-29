/*
Navicat MySQL Data Transfer

Source Server         : weibar
Source Server Version : 50718
Source Host           : rm-wz9l3k9adb590oksvo.mysql.rds.aliyuncs.com:3306
Source Database       : weibar

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-01-09 15:10:48
*/

Use weibar;
SET FOREIGN_KEY_CHECKS=0;


-- ----------------------------
-- Table structure for `merchants_user_base_info`
-- ----------------------------
DROP TABLE IF EXISTS `merchants_user_base_info`;
CREATE TABLE `merchants_user_base_info` (
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `openid` varchar(500) DEFAULT NULL COMMENT '商户对应的微信openid',
  `bind_time` datetime NOT NULL COMMENT '帐号绑定时间',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  KEY `AK_Key_openid` (`openid`(255)) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of merchants_user_base_info
-- ----------------------------





-- ----------------------------
-- Table structure for `user_account_balance`
-- ----------------------------
DROP TABLE IF EXISTS `user_account_balance`;
CREATE TABLE `user_account_balance` (
  `user_id` bigint(20) NOT NULL COMMENT '帐号',
  `openid` varchar(500) DEFAULT NULL COMMENT '商户对应的微信openid',
  `balance` decimal(10,2) NOT NULL COMMENT '用户钱包余额',
  `subject` varchar(50) NOT NULL COMMENT '科目',
  `user_type` int(11) DEFAULT NULL  COMMENT '用户类型，1为普通用户，2为商户用户',
  `merchantid` bigint(20) DEFAULT NULL  COMMENT '商户ID',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  KEY `AK_Key_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户钱包表';

-- ----------------------------
-- Records of user_account_balance
-- ----------------------------


-- ----------------------------
-- Table structure for `user_base_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_base_info`;
CREATE TABLE `user_base_info` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `point` decimal(10,2) NOT NULL COMMENT '用户钱包余额',
  `user_picture` varchar(1024) DEFAULT NULL,
  `nickname` varchar(500) DEFAULT NULL COMMENT '用户昵称',
  `sex` varchar(500) DEFAULT NULL COMMENT '用户的性别',
  `user_level` varchar(50) NOT NULL DEFAULT '0' COMMENT '用户等级',
  `city` varchar(500) DEFAULT NULL COMMENT '用户城市',
  `country` varchar(500) DEFAULT NULL COMMENT '用户国家',
  `province` varchar(500) DEFAULT NULL COMMENT '用户省份',
  `user_mobile` varchar(500) DEFAULT NULL COMMENT '用户手机',
  `remark` varchar(500) DEFAULT NULL COMMENT '用户备注',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  `openid` varchar(1024) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1514806336570 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_base_info
-- ----------------------------



-- ----------------------------
-- Table structure for `user_consume_order`
-- ----------------------------
DROP TABLE IF EXISTS `user_consume_order`;
CREATE TABLE `user_consume_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '请求ID',
  `merchantid` bigint(20) NOT NULL DEFAULT '0' COMMENT '商户ID',
  `openid` varchar(1024) DEFAULT NULL COMMENT '商户对应的微信openid',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `beneficial_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '受益用户ID，为他人霸屏，打赏目标',
  `beneficial_openid` varchar(1024) NOT NULL COMMENT '受益者的微信openid',
  `balance_type` int(11) NOT NULL COMMENT '货币类型 默认为 1',
  `amount` decimal(16,2) NOT NULL COMMENT '数额，连送为合计商品总金额',
  `pay_type` int(11) NOT NULL COMMENT '购买商品类型 1 自己霸屏 2 为他人霸屏 3. 打赏个人 4.打赏艺人  ',
  `goods_id` bigint(20) NOT NULL COMMENT '购买霸屏/打赏商品ID',
  `goods_name` varchar(50) NOT NULL COMMENT '购买霸屏/打赏商品名',
  `goods_num` int(11) NOT NULL COMMENT '连送次数',
  `pay_time` datetime NOT NULL COMMENT '产品支付时间',
  `user_ip` varchar(256) NOT NULL COMMENT '用户IP',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `ext1` varchar(64) DEFAULT NULL COMMENT '扩展字段1',
  `ext2` varchar(255) DEFAULT NULL COMMENT '扩展字段2',
  `ext3` decimal(16,2) DEFAULT NULL COMMENT '扩展字段3',
  `ext4` datetime DEFAULT NULL COMMENT '扩展字段4',
  `ext5` int(11) DEFAULT NULL COMMENT '扩展字段5',
  PRIMARY KEY (`id`),
  KEY `AK_create_time_idx` (`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=151 DEFAULT CHARSET=utf8 COMMENT='用户消费交易信息表';

-- ----------------------------
-- Records of user_consume_order
-- ----------------------------

-- ----------------------------
-- Table structure for `user_recharge_order`
-- ----------------------------
DROP TABLE IF EXISTS `user_recharge_order`;
CREATE TABLE `user_recharge_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '请求ID',
  `order_id` varchar(32) NOT NULL COMMENT '消费订单ID',
  `openid` varchar(256) DEFAULT NULL COMMENT '商户对应的微信openid',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `chorderid` varchar(100) DEFAULT NULL COMMENT '渠道订单id',
  `ch_tpye` int(11) NOT NULL COMMENT '渠道类型1.微信 2.支付宝 3.银联',
  `ch_bank_tpye` varchar(64) DEFAULT NULL COMMENT '渠道银行id',
  `total_fee` int(11) NOT NULL COMMENT '支付金额，分为单位',
  `chaccount` varchar(100) DEFAULT NULL COMMENT '渠道账号',
  `chapp_id` varchar(100) DEFAULT NULL COMMENT '渠道appid',
  `chmethod` varchar(64) NOT NULL COMMENT '支付方式H5，公众号等',
  `user_ip` varchar(64) NOT NULL COMMENT '用户IP',
  `status` int(11) DEFAULT NULL COMMENT '返回码 订单 1.等待支付  2.成功 3.失败',
  `ch_status` varchar(64) DEFAULT NULL COMMENT '渠道返回描述',
  `ch_statusMsg` varchar(1024) DEFAULT NULL COMMENT '渠道返回描述',
  `description` varchar(2048) DEFAULT NULL COMMENT '渠道返回完整信息',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `pay_comp_time` datetime DEFAULT NULL COMMENT '支付完成时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `ext1` varchar(64) DEFAULT NULL COMMENT '扩展字段1',
  `ext2` varchar(255) DEFAULT NULL COMMENT '扩展字段2',
  `ext3` decimal(16,2) DEFAULT NULL COMMENT '扩展字段3',
  `ext4` datetime DEFAULT NULL COMMENT '扩展字段4',
  `ext5` int(11) DEFAULT NULL COMMENT '扩展字段5',
  PRIMARY KEY (`id`),
  UNIQUE KEY `AK_order_id_unq` (`order_id`) USING BTREE,
  KEY `AK_create_time_idx` (`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8 COMMENT='用户充值信息表';

-- ----------------------------
-- Records of user_recharge_order
-- ----------------------------

-- ----------------------------
-- Table structure for `user_transaction`
-- ----------------------------
DROP TABLE IF EXISTS `user_transaction`;
CREATE TABLE `user_transaction` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_id` varchar(20) NOT NULL COMMENT '通行证',
  `openid` varchar(500) DEFAULT NULL COMMENT '商户对应的微信openid',
  `transaction_type` int(11) NOT NULL COMMENT '0表示支出，1表示收入',
  `amount` decimal(10,2) NOT NULL COMMENT '交易发生额',
  `balance` decimal(10,2) NOT NULL COMMENT '当前钱包余额',
  `remark` varchar(1024) DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  `status` int(11) NOT NULL COMMENT '对应的交易单状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=360 DEFAULT CHARSET=utf8 COMMENT='用户账户交易明细表';

-- ----------------------------
-- Records of user_transaction
-- ----------------------------

-- ----------------------------
-- Table structure for `user_withdraw_log`
-- ----------------------------
DROP TABLE IF EXISTS `user_withdraw_log`;
CREATE TABLE `user_withdraw_log` (
  `id` bigint(20) NOT NULL COMMENT '自增id',
  `user_id` bigint(20) NOT NULL COMMENT '商户ID',
  `alipay_account` varchar(256) DEFAULT NULL COMMENT '支付宝账号',
  `point` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '提现金额',
  `open_id` varchar(128) DEFAULT NULL COMMENT '微信openId',
  `merchantid` varchar(128) DEFAULT NULL COMMENT '商户ID',
  `subject` varchar(50) NOT NULL COMMENT '科目',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  `status` int(11) NOT NULL COMMENT '对应的交易单状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户提现表';

-- ----------------------------
-- Records of user_withdraw_log
-- ----------------------------

-- ----------------------------
-- Table structure for `weibar_goods_setting_info`
-- ----------------------------
DROP TABLE IF EXISTS `weibar_goods_setting_info`;
CREATE TABLE `weibar_goods_setting_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `goodsid` bigint(20) DEFAULT NULL,
  `goodsname` varchar(1024) DEFAULT NULL COMMENT '礼物名称',
  `goodsurl` varchar(1024) DEFAULT NULL COMMENT '礼物图片',
  `amount` decimal(16,2) NOT NULL COMMENT '礼物数额',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  `goods_big_url` varchar(1024) DEFAULT NULL,
  `goods_msg` varchar(1024) DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibar_goods_setting_info
-- ----------------------------
INSERT INTO `weibar_goods_setting_info` VALUES ('1', '1515223581449', '香蕉', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/dcf8202d81a2422f5b1eb514dfc1c2c4', '8.80', '2018-01-06 15:26:21', '2018-01-06 15:26:21', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/cde9b3a7dff6261295ed0ff3bd3a6349', '好香蕉，够大、够黄、够直', '8', '550', '508');
INSERT INTO `weibar_goods_setting_info` VALUES ('2', '1515223582071', '套套', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/17ec97a812a9dd4e935152573d5f9dc4', '6.60', '2018-01-06 15:26:22', '2018-01-06 15:26:22', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/f5b54f2d027565d143b401460009fa1a', '今夜，与你一起\"杜\"过', '8', '550', '400');
INSERT INTO `weibar_goods_setting_info` VALUES ('3', '1515223582096', '丁字裤', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/7bd5ff41e5937cd508a41a6d11552293', '6.60', '2018-01-06 15:26:22', '2018-01-06 15:26:22', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/2fabd89699b3764ac77f2c1d38e81666', '丝丝入扣，动人心弦', '12', '550', '813');
INSERT INTO `weibar_goods_setting_info` VALUES ('4', '1515223582118', '私人飞机', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/09295963049d2c7e585296bc3b3ed9ea', '12.00', '2018-01-06 15:26:22', '2018-01-06 15:26:22', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/c23a9fdab9bafbdbccf1889e54b58b6d', '跟老铁一起环游世界吧', '16', '800', '450');
INSERT INTO `weibar_goods_setting_info` VALUES ('5', '1515223582142', '去污皂', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/d45bc13297b4732b84158356ce28ae9d', '2.00', '2018-01-06 15:26:22', '2018-01-06 15:26:22', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/66b7b90657ad6c0a5267e3710d47b753', '为你去污，越皂越污', '8', '1280', '720');
INSERT INTO `weibar_goods_setting_info` VALUES ('6', '1515223582164', '金话筒', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/fcd34f719e17d3de5f07dc62b9aa0ad3', '1.00', '2018-01-06 15:26:22', '2018-01-06 15:26:22', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/ae4a5f81240add7941d800d84facbe7d', '天籁歌喉，为你喝彩', '8', '550', '610');
INSERT INTO `weibar_goods_setting_info` VALUES ('7', '1515223582185', '游艇', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/d910b2ff8918ae62c703f9a9232dd70b', '24.00', '2018-01-06 15:26:22', '2018-01-06 15:26:22', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/ffdb61d859f7421e2efa1a6432106503', '来一场碧波荡漾的海上盛宴', '16', '800', '450');
INSERT INTO `weibar_goods_setting_info` VALUES ('8', '1515223582208', '玫瑰花海', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/ed2682744a869dee7e0bfb227bfe90ae', '12.00', '2018-01-06 15:26:22', '2018-01-06 15:26:22', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/1b954c87be2ae91493f5bae51301eb7f', '为你，奉献此生真爱', '12', '800', '480');
INSERT INTO `weibar_goods_setting_info` VALUES ('9', '1515223582232', '战斗机', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/ad2f36398a8e877aa7cef588d3158a37', '12.00', '2018-01-06 15:26:22', '2018-01-06 15:26:22', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/8cc81aefc7247bdf941b46fdd82a0cda', '红星照你去战斗', '16', '550', '330');
INSERT INTO `weibar_goods_setting_info` VALUES ('10', '1515223582253', '火箭', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/c47b3b5897a4c5d4d2f6d8869ce9ad63', '11.00', '2018-01-06 15:26:22', '2018-01-06 15:26:22', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/81f60978be5630f5f87b841be6cd1336', '爱似火箭，猛烈无惧', '16', '550', '502');
INSERT INTO `weibar_goods_setting_info` VALUES ('11', '1515223582275', '扭臀', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/0561eac9e8c9d30a553baf6c56d7cdd1', '1.00', '2018-01-06 15:26:22', '2018-01-06 15:26:22', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/048fd93c9ce9253329ada0695d2dc4f9', '颤抖吧，PP', '12', '800', '450');
INSERT INTO `weibar_goods_setting_info` VALUES ('12', '1515223582297', '香水', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/8f17444a044fb289308723117d96656f', '1.00', '2018-01-06 15:26:22', '2018-01-06 15:26:22', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/41d69859333c133cc8c2a17d1bc56993', '送你一款有故事的香水', '8', '800', '450');
INSERT INTO `weibar_goods_setting_info` VALUES ('13', '1515223582318', '跑车', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/9d5f97f2d79b85442cf8f8d7fe34f889', '3.00', '2018-01-06 15:26:22', '2018-01-06 15:26:22', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/493611abbb8d59f59a771570fc0d65fa', '老铁兜风去', '12', '800', '450');
INSERT INTO `weibar_goods_setting_info` VALUES ('14', '1515223582342', '红唇', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/ed214f2631f5ab98755bbb47d98b9e3e', '5.00', '2018-01-06 15:26:22', '2018-01-06 15:26:22', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/efddd2b5bc63c632ba6932dcebb5eeba', '么么哒', '12', '1280', '720');
INSERT INTO `weibar_goods_setting_info` VALUES ('15', '1515223582364', '木吉他', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/e1205a5f04387903b5412c10c0cd4d84', '3.00', '2018-01-06 15:26:22', '2018-01-06 15:26:22', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/87adf082fa12235ea39d48dc24984f5e', '木吉他', '8', '1000', '563');
INSERT INTO `weibar_goods_setting_info` VALUES ('16', '1515223582385', '手风琴', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/0c99a129163094384f3fc25a123a8869', '3.00', '2018-01-06 15:26:22', '2018-01-06 15:26:22', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/4c6820702d9fa02f3c42801ceda57ee2', '手风琴', '8', '1000', '600');
INSERT INTO `weibar_goods_setting_info` VALUES ('17', '1515223582413', '皮皮虾', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/1c478316f9c3abc2f57106dbf9e2070a', '33.00', '2018-01-06 15:26:22', '2018-01-06 15:26:22', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/c578c843c844fef529380a8a7483e48b', '皮皮虾我们走', '12', '800', '450');
INSERT INTO `weibar_goods_setting_info` VALUES ('18', '1515223582434', '鹊桥', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/0fcd68d583b05e2e29560b62108bc05d', '1.00', '2018-01-06 15:26:22', '2018-01-06 15:26:22', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/2d634dc629454782d03d21c90373a3bf', '鹊桥', '16', '800', '450');
INSERT INTO `weibar_goods_setting_info` VALUES ('19', '1515223582468', 'XO', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/2852a17182ecef23f946e4d7f690a638', '32.00', '2018-01-06 15:26:22', '2018-01-06 15:26:22', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/3786bd2668e6c28b0ce1cadaa8a4fe17', 'XO', '16', '800', '450');
INSERT INTO `weibar_goods_setting_info` VALUES ('20', '1515223582489', '轩尼诗', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/8a1681ebd4b44aa0098c2732e7bb6db5', '12.00', '2018-01-06 15:26:22', '2018-01-06 15:26:22', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/3a117b1f64a1108d9d22454806aeddd4', '轩尼诗', '12', '800', '450');
INSERT INTO `weibar_goods_setting_info` VALUES ('21', '1515223582511', '五仁月饼', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/6a5d206577058e558955de40197284bf', '11.00', '2018-01-06 15:26:23', '2018-01-06 15:26:23', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/dbf758e3fd0d2878b249a5f7ce084a1a', '五仁月饼', '16', '1920', '1080');
INSERT INTO `weibar_goods_setting_info` VALUES ('22', '1515223582534', '南瓜', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/7392566e250adbeb33e129b52cab0c73', '2.00', '2018-01-06 15:26:23', '2018-01-06 15:26:23', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/deff0ea2e92451ac79c850cf4661f3cd', '南瓜', '8', '1280', '720');

-- ----------------------------
-- Table structure for `weibar_merchants_artist`
-- ----------------------------
DROP TABLE IF EXISTS `weibar_merchants_artist`;
CREATE TABLE `weibar_merchants_artist` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `merchantid` bigint(20) NOT NULL DEFAULT '0' COMMENT '商户ID',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `openid` varchar(128) DEFAULT NULL COMMENT '商户对应的微信openid',
  `nickname` varchar(256) DEFAULT NULL COMMENT '用户昵称',
  `user_picture` varchar(1024) DEFAULT NULL COMMENT '用户图像url',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `AK_Key_openid` (`merchantid`,`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibar_merchants_artist
-- ----------------------------

-- ----------------------------
-- Table structure for `weibar_merchants_barrage_info`
-- ----------------------------
DROP TABLE IF EXISTS `weibar_merchants_barrage_info`;
CREATE TABLE `weibar_merchants_barrage_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `merchantid` bigint(20) NOT NULL DEFAULT '0' COMMENT '商户ID',
  `order_id` varchar(100) DEFAULT NULL COMMENT '交易订单ID',
  `openid` varchar(500) DEFAULT NULL COMMENT '商户对应的微信openid',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `context` varchar(100) DEFAULT NULL COMMENT '弹幕内容 ，图片,视频路径',
  `type` int(11) DEFAULT NULL COMMENT '0 文字消息，1 图文消息（含图片）该状态可用霸频 2 打赏消息 3 红包消息 4 点歌 5 投票消息 999其他',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '0 已霸屏，1 未霸屏',
  `redpackageid` bigint(20) DEFAULT NULL COMMENT '红包组ID，红包消息此值不能为空',
  `screen_num` int(11) DEFAULT NULL COMMENT '霸屏次数',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  `img_url` varchar(1024) DEFAULT NULL,
  `user_level` varchar(50) NOT NULL DEFAULT '0' COMMENT '用户等级',
  `nickname` varchar(500) DEFAULT NULL COMMENT '用户昵称',
  `sex` varchar(500) DEFAULT NULL COMMENT '用户的性别',
  `user_picture` varchar(1024) DEFAULT NULL,
  `redpackage_title` varchar(1024) DEFAULT NULL COMMENT '用户昵称',
  `bar_content` varchar(1024) DEFAULT NULL COMMENT '霸屏信息',
  `timesid` int(11) DEFAULT NULL COMMENT '霸屏时长',
  `redpackage_give_openid` varchar(1024) DEFAULT NULL COMMENT '发送红包者openid,红包领取消息使用',
`barpin_title` int(11) DEFAULT NULL COMMENT '霸屏主题',
  `barpin_openid` varchar(500) DEFAULT NULL COMMENT '霸屏用户openId',
  `barpin_user_id` bigint(20) DEFAULT NULL COMMENT '霸屏用户userId',
  `barpin_user_name` varchar(1024) DEFAULT NULL COMMENT '霸屏用户名字',
  `give_user_id` bigint(20) DEFAULT NULL COMMENT '被打赏用户ID微信userId',
  `give_user_img_url` varchar(1024) DEFAULT NULL COMMENT '被打赏用户ID微信图片',
  `give_content` varchar(1024) DEFAULT NULL COMMENT '打赏信息',
  `give_goodsname` varchar(1024) DEFAULT NULL COMMENT '礼物名称',
  `give_goodsurl` varchar(1024) DEFAULT NULL COMMENT '礼物图片',
  `give_user_name` varchar(1024) DEFAULT NULL COMMENT '被打赏用户名字',
  `redpackage_give_user_id` bigint(20) DEFAULT NULL COMMENT '发送红包者userId,红包领取消息使用',
  `redpackage_amount` decimal(10,2) DEFAULT NULL COMMENT '发送红包总金额',
  `barpin_theme` int(11) DEFAULT NULL,
  `give_goods_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=376 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibar_merchants_barrage_info
-- ----------------------------



-- ----------------------------
-- Table structure for `weibar_merchants_base_info`
-- ----------------------------
DROP TABLE IF EXISTS `weibar_merchants_base_info`;
CREATE TABLE `weibar_merchants_base_info` (
  `merchantid` bigint(20) NOT NULL DEFAULT '0' COMMENT '商户ID',
  `user_id` bigint(20) NOT NULL  COMMENT '用户ID',
  `login_name` varchar(500) DEFAULT NULL COMMENT '登录用户名',
  `producerlogo_url` varchar(500) DEFAULT NULL COMMENT '商户log链接地址',
  `qrcode_url` varchar(500) DEFAULT NULL COMMENT '商户公众号二维码地址',
  `mp_name` varchar(500) DEFAULT NULL COMMENT '商户公众号名称',
  `merchants_name` varchar(500) DEFAULT NULL COMMENT '商家名称',
  `merchants_mail` varchar(500) DEFAULT NULL COMMENT '商家邮箱帐号',
  `merchants_mobile` varchar(500) DEFAULT NULL COMMENT '商家手机帐号',
  `customercare_mobile` varchar(500) DEFAULT NULL COMMENT '商家客服电话',
  `merchants_address` varchar(1000) DEFAULT NULL COMMENT '商家地址',
  `merchants_lable` varchar(1000) DEFAULT NULL COMMENT '商家标签',
  `merchants_des` varchar(1000) DEFAULT NULL COMMENT '商家介绍',
  `wifi_passport` varchar(100) DEFAULT NULL COMMENT 'wifi密码',
  `per_capita` varchar(100) DEFAULT NULL COMMENT '人均消费',
  `bar_picture` varchar(100) DEFAULT NULL COMMENT '吧图url',
  `bar_des` varchar(100) DEFAULT NULL COMMENT '吧图描述',
  `hash_pwd` varchar(400) DEFAULT NULL COMMENT '加盐密码',
  `hash_salt` varchar(400) DEFAULT NULL COMMENT '密码的盐',
  `parent_merchantid` bigint(20) NOT NULL DEFAULT '0' COMMENT '父商户ID',
  `role` int(11) DEFAULT NULL COMMENT '角色, 1杭州公司，2为代理商，3为酒吧',
  `sharing_ratio_barpin` int(11) DEFAULT NULL COMMENT '霸屏分成比例，表示千分之几',
  `sharing_ratio_redp` int(11) DEFAULT NULL COMMENT '红包分成比例，表示千分之几',
  `sharing_ratio_give` int(11) DEFAULT NULL COMMENT '打赏分成比例，表示千分之几',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  `state` int(11) DEFAULT NULL,
  `wechat_login_url` varchar(1024) DEFAULT NULL COMMENT '微信授权登录url',
  PRIMARY KEY (`merchantid`),
  KEY `AK_Key_user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
-- Records of weibar_merchants_base_info
-- ----------------------------
INSERT INTO `weibar_merchants_base_info` VALUES ('1', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/419608ca6edcd52006a56195f1751e83', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/419608ca6edcd52006a56195f1751e83', '', '官方频道', null, null, null, null, null, null, null, null, null, null, '2017-11-12 12:20:45', '2017-11-12 12:20:45', '1', 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxa105b2133d0dd8b0&redirect_uri=http%3A%2F%2Fwww.yylive.com%2Fwechat%2Flogin&response_type=code&scope=snsapi_userinfo&state=http%3A%2F%2Fwww.yylive.com%2Fstatic%2Findex.html%3FmerchantId%3D1#wechat_redirect');





CREATE TABLE `weibar_merchants_game_setting_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `merchantid` bigint(20) NOT NULL DEFAULT '0' COMMENT '商户ID',
  `gameid` varchar(10) DEFAULT NULL COMMENT '游戏ID',
  `gamename` varchar(500) DEFAULT NULL COMMENT '游戏名称',
  `game_img_url` varchar(1000) DEFAULT NULL COMMENT '游戏图标URL',
  `game_url` varchar(1000) DEFAULT NULL COMMENT '游戏URL',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8




CREATE TABLE `weibar_merchants_account_balance` (
  `merchantid` bigint(20) NOT NULL COMMENT '帐号',
  `balance` decimal(10,2) NOT NULL COMMENT '用户钱包余额',
  `bank_name` varchar(50) NOT NULL COMMENT '银行卡开户行（如中国工商银行）',
  `bank_card_no` varchar(50) NOT NULL COMMENT '银行卡号',
  `bank_card_name` varchar(50) NOT NULL COMMENT '银行卡姓名（姓名或公司名称）',
  `bank_branch` varchar(30) NOT NULL COMMENT '银行所在网点名称',
  `subject` varchar(50) NOT NULL COMMENT '科目',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`merchantid`),
  KEY `AK_Key_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商户钱包表';






-- ----------------------------
-- Table structure for `weibar_merchants_goods_setting_info`
-- ----------------------------
DROP TABLE IF EXISTS `weibar_merchants_goods_setting_info`;
CREATE TABLE `weibar_merchants_goods_setting_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `merchantid` bigint(20) NOT NULL DEFAULT '0' COMMENT '商户ID',
  `goodsid` bigint(20) DEFAULT NULL,
  `goodsname` varchar(1024) DEFAULT NULL COMMENT '礼物名称',
  `goodsurl` varchar(1024) DEFAULT NULL COMMENT '礼物图片',
  `amount` decimal(16,2) NOT NULL COMMENT '礼物数额',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  `goods_big_url` varchar(1024) DEFAULT NULL,
  `goods_msg` varchar(1024) DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibar_merchants_goods_setting_info
-- ----------------------------
INSERT INTO `weibar_merchants_goods_setting_info` VALUES ('6', '1', '1515223581449', '香蕉', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/dcf8202d81a2422f5b1eb514dfc1c2c4', '8.80', '2018-01-06 15:37:03', '2018-01-06 15:37:03', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/cde9b3a7dff6261295ed0ff3bd3a6349', '好香蕉，够大、够黄、够直', '8', '550', '508');
INSERT INTO `weibar_merchants_goods_setting_info` VALUES ('7', '1', '1515223582071', '套套', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/17ec97a812a9dd4e935152573d5f9dc4', '6.60', '2018-01-06 15:37:03', '2018-01-06 15:37:03', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/f5b54f2d027565d143b401460009fa1a', '今夜，与你一起\"杜\"过', '8', '550', '400');
INSERT INTO `weibar_merchants_goods_setting_info` VALUES ('8', '1', '1515223582096', '丁字裤', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/7bd5ff41e5937cd508a41a6d11552293', '6.60', '2018-01-06 15:37:03', '2018-01-06 15:37:03', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/2fabd89699b3764ac77f2c1d38e81666', '丝丝入扣，动人心弦', '12', '550', '813');
INSERT INTO `weibar_merchants_goods_setting_info` VALUES ('9', '1', '1515223582118', '私人飞机', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/09295963049d2c7e585296bc3b3ed9ea', '12.00', '2018-01-06 15:37:03', '2018-01-06 15:37:03', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/c23a9fdab9bafbdbccf1889e54b58b6d', '跟老铁一起环游世界吧', '16', '800', '450');
INSERT INTO `weibar_merchants_goods_setting_info` VALUES ('10', '1', '1515223582142', '去污皂', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/d45bc13297b4732b84158356ce28ae9d', '2.00', '2018-01-06 15:37:03', '2018-01-06 15:37:03', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/66b7b90657ad6c0a5267e3710d47b753', '为你去污，越皂越污', '8', '1280', '720');
INSERT INTO `weibar_merchants_goods_setting_info` VALUES ('11', '1', '1515223582164', '金话筒', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/fcd34f719e17d3de5f07dc62b9aa0ad3', '1.00', '2018-01-06 15:37:03', '2018-01-06 15:37:03', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/ae4a5f81240add7941d800d84facbe7d', '天籁歌喉，为你喝彩', '8', '550', '610');
INSERT INTO `weibar_merchants_goods_setting_info` VALUES ('12', '1', '1515223582185', '游艇', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/d910b2ff8918ae62c703f9a9232dd70b', '24.00', '2018-01-06 15:37:03', '2018-01-06 15:37:03', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/ffdb61d859f7421e2efa1a6432106503', '来一场碧波荡漾的海上盛宴', '16', '800', '450');
INSERT INTO `weibar_merchants_goods_setting_info` VALUES ('13', '1', '1515223582208', '玫瑰花海', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/ed2682744a869dee7e0bfb227bfe90ae', '12.00', '2018-01-06 15:37:03', '2018-01-06 15:37:03', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/1b954c87be2ae91493f5bae51301eb7f', '为你，奉献此生真爱', '12', '800', '480');
INSERT INTO `weibar_merchants_goods_setting_info` VALUES ('14', '1', '1515223582232', '战斗机', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/ad2f36398a8e877aa7cef588d3158a37', '12.00', '2018-01-06 15:37:03', '2018-01-06 15:37:03', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/8cc81aefc7247bdf941b46fdd82a0cda', '红星照你去战斗', '16', '550', '330');
INSERT INTO `weibar_merchants_goods_setting_info` VALUES ('15', '1', '1515223582253', '火箭', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/c47b3b5897a4c5d4d2f6d8869ce9ad63', '11.00', '2018-01-06 15:37:04', '2018-01-06 15:37:04', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/81f60978be5630f5f87b841be6cd1336', '爱似火箭，猛烈无惧', '16', '550', '502');
INSERT INTO `weibar_merchants_goods_setting_info` VALUES ('16', '1', '1515223582275', '扭臀', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/0561eac9e8c9d30a553baf6c56d7cdd1', '1.00', '2018-01-06 15:37:04', '2018-01-06 15:37:04', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/048fd93c9ce9253329ada0695d2dc4f9', '颤抖吧，PP', '12', '800', '450');
INSERT INTO `weibar_merchants_goods_setting_info` VALUES ('17', '1', '1515223582297', '香水', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/8f17444a044fb289308723117d96656f', '1.00', '2018-01-06 15:37:04', '2018-01-06 15:37:04', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/41d69859333c133cc8c2a17d1bc56993', '送你一款有故事的香水', '8', '800', '450');
INSERT INTO `weibar_merchants_goods_setting_info` VALUES ('18', '1', '1515223582318', '跑车', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/9d5f97f2d79b85442cf8f8d7fe34f889', '3.00', '2018-01-06 15:37:04', '2018-01-06 15:37:04', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/493611abbb8d59f59a771570fc0d65fa', '老铁兜风去', '12', '800', '450');
INSERT INTO `weibar_merchants_goods_setting_info` VALUES ('19', '1', '1515223582342', '红唇', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/ed214f2631f5ab98755bbb47d98b9e3e', '5.00', '2018-01-06 15:37:04', '2018-01-06 15:37:04', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/efddd2b5bc63c632ba6932dcebb5eeba', '么么哒', '12', '1280', '720');
INSERT INTO `weibar_merchants_goods_setting_info` VALUES ('20', '1', '1515223582364', '木吉他', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/e1205a5f04387903b5412c10c0cd4d84', '3.00', '2018-01-06 15:37:04', '2018-01-06 15:37:04', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/87adf082fa12235ea39d48dc24984f5e', '木吉他', '8', '1000', '563');
INSERT INTO `weibar_merchants_goods_setting_info` VALUES ('21', '1', '1515223582385', '手风琴', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/0c99a129163094384f3fc25a123a8869', '3.00', '2018-01-06 15:37:04', '2018-01-06 15:37:04', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/4c6820702d9fa02f3c42801ceda57ee2', '手风琴', '8', '1000', '600');
INSERT INTO `weibar_merchants_goods_setting_info` VALUES ('22', '1', '1515223582413', '皮皮虾', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/1c478316f9c3abc2f57106dbf9e2070a', '33.00', '2018-01-06 15:37:04', '2018-01-06 15:37:04', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/c578c843c844fef529380a8a7483e48b', '皮皮虾我们走', '12', '800', '450');
INSERT INTO `weibar_merchants_goods_setting_info` VALUES ('23', '1', '1515223582434', '鹊桥', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/0fcd68d583b05e2e29560b62108bc05d', '1.00', '2018-01-06 15:37:04', '2018-01-06 15:37:04', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/2d634dc629454782d03d21c90373a3bf', '鹊桥', '16', '800', '450');
INSERT INTO `weibar_merchants_goods_setting_info` VALUES ('24', '1', '1515223582468', 'XO', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/2852a17182ecef23f946e4d7f690a638', '32.00', '2018-01-06 15:37:04', '2018-01-06 15:37:04', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/3786bd2668e6c28b0ce1cadaa8a4fe17', 'XO', '16', '800', '450');
INSERT INTO `weibar_merchants_goods_setting_info` VALUES ('25', '1', '1515223582489', '轩尼诗', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/8a1681ebd4b44aa0098c2732e7bb6db5', '12.00', '2018-01-06 15:37:04', '2018-01-06 15:37:04', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/3a117b1f64a1108d9d22454806aeddd4', '轩尼诗', '12', '800', '450');
INSERT INTO `weibar_merchants_goods_setting_info` VALUES ('26', '1', '1515223582511', '五仁月饼', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/6a5d206577058e558955de40197284bf', '11.00', '2018-01-06 15:37:04', '2018-01-06 15:37:04', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/dbf758e3fd0d2878b249a5f7ce084a1a', '五仁月饼', '16', '1920', '1080');
INSERT INTO `weibar_merchants_goods_setting_info` VALUES ('27', '1', '1515223582534', '南瓜', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/7392566e250adbeb33e129b52cab0c73', '2.00', '2018-01-06 15:37:04', '2018-01-06 15:37:04', 'http://weibar.oss-cn-shenzhen.aliyuncs.com/deff0ea2e92451ac79c850cf4661f3cd', '南瓜', '8', '1280', '720');

-- ----------------------------
-- Table structure for `weibar_merchants_login_log`
-- ----------------------------
DROP TABLE IF EXISTS `weibar_merchants_login_log`;
CREATE TABLE `weibar_merchants_login_log` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `merchantid` bigint(20) NOT NULL DEFAULT '0' COMMENT '商户ID',
  `openid` varchar(256) DEFAULT NULL COMMENT '商户对应的微信openid',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `producerlogo_url` varchar(1024) DEFAULT NULL COMMENT '商户logo链接地址',
  `merchants_name` varchar(128) DEFAULT NULL COMMENT '商家名称',
  `login_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `AK_user_id_unq` (`user_id`,`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=545 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibar_merchants_login_log
-- ----------------------------



-- ----------------------------
-- Table structure for `weibar_merchants_price_time_setting_info`
-- ----------------------------
DROP TABLE IF EXISTS `weibar_merchants_price_time_setting_info`;
CREATE TABLE `weibar_merchants_price_time_setting_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `merchantid` bigint(20) NOT NULL DEFAULT '0' COMMENT '商户ID',
  `timesid` int(11) DEFAULT NULL COMMENT '时长',
  `timesdesc` varchar(256) DEFAULT NULL COMMENT '时长描述',
  `amount` decimal(16,2) NOT NULL COMMENT '数额',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibar_merchants_price_time_setting_info
-- ----------------------------
INSERT INTO `weibar_merchants_price_time_setting_info` VALUES ('1', '1', '8', '8秒', '0.01', '2017-11-21 16:09:03', '2017-11-21 16:09:03');
INSERT INTO `weibar_merchants_price_time_setting_info` VALUES ('2', '1', '20', '20秒', '0.16', '2017-11-21 16:09:17', '2017-11-21 16:09:17');
INSERT INTO `weibar_merchants_price_time_setting_info` VALUES ('3', '1', '60', '60秒', '0.30', '2017-11-21 16:09:38', '2017-11-21 16:09:38');
INSERT INTO `weibar_merchants_price_time_setting_info` VALUES ('4', '1', '520', '520秒', '1.00', '2017-11-21 16:09:58', '2017-11-21 16:09:58');
INSERT INTO `weibar_merchants_price_time_setting_info` VALUES ('5', '1', '1314', '1314秒', '5.00', '2017-11-21 16:10:29', '2017-11-21 16:10:29');




-- ----------------------------
-- Table structure for `weibar_pay_attach`
-- ----------------------------
DROP TABLE IF EXISTS `weibar_pay_attach`;
CREATE TABLE `weibar_pay_attach` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `attach` varchar(2048) DEFAULT NULL COMMENT '支付附带信息',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibar_pay_attach
-- ----------------------------



-- ----------------------------
-- Table structure for `weibar_price_time_setting_info`
-- ----------------------------
DROP TABLE IF EXISTS `weibar_price_time_setting_info`;
CREATE TABLE `weibar_price_time_setting_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `timesid` int(11) DEFAULT NULL COMMENT '时长',
  `timesdesc` varchar(256) DEFAULT NULL COMMENT '时长描述',
  `amount` decimal(16,2) NOT NULL COMMENT '数额',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibar_price_time_setting_info
-- ----------------------------

INSERT INTO `weibar_price_time_setting_info` VALUES ('1',  '8', '8秒', '0.01', '2017-11-21 16:09:03', '2017-11-21 16:09:03');
INSERT INTO `weibar_price_time_setting_info` VALUES ('2',  '20', '20秒', '0.16', '2017-11-21 16:09:17', '2017-11-21 16:09:17');
INSERT INTO `weibar_price_time_setting_info` VALUES ('3',  '60', '60秒', '0.30', '2017-11-21 16:09:38', '2017-11-21 16:09:38');
INSERT INTO `weibar_price_time_setting_info` VALUES ('4',  '520', '520秒', '1.00', '2017-11-21 16:09:58', '2017-11-21 16:09:58');
INSERT INTO `weibar_price_time_setting_info` VALUES ('5',  '1314', '1314秒', '5.00', '2017-11-21 16:10:29', '2017-11-21 16:10:29');


-- ----------------------------
-- Table structure for `weibar_private_chat`
-- ----------------------------
DROP TABLE IF EXISTS `weibar_private_chat`;
CREATE TABLE `weibar_private_chat` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `chat_id` bigint(20) NOT NULL,
  `message` varchar(1024) DEFAULT NULL COMMENT '消息内容',
  `img_url` varchar(1024) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '1 文字  2 图片，3 打赏',
  `status` int(11) DEFAULT NULL COMMENT '0 为已读  1 未读',
  `from_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '发送用户ID',
  `from_user_openid` varchar(500) DEFAULT NULL COMMENT '商户对应的微信openid',
  `from_user_picture` varchar(256) DEFAULT NULL COMMENT '用户图像url',
  `from_nickname` varchar(256) DEFAULT NULL COMMENT '用户昵称',
  `from_sex` varchar(10) DEFAULT NULL COMMENT '用户的性别',
  `to_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '接收用户ID',
  `to_user_openid` varchar(500) DEFAULT NULL COMMENT '商户对应的微信openid',
  `to_user_picture` varchar(256) DEFAULT NULL COMMENT '用户图像url',
  `to_nickname` varchar(256) DEFAULT NULL COMMENT '用户昵称',
  `to_sex` varchar(10) DEFAULT NULL COMMENT '用户的性别',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  `give_user_id` bigint(20) DEFAULT NULL COMMENT '被打赏用户ID微信userId',
  `give_user_img_url` varchar(1024) DEFAULT NULL COMMENT '被打赏用户ID微信图片',
  `give_content` varchar(1024) DEFAULT NULL COMMENT '打赏信息',
  `give_goodsname` varchar(1024) DEFAULT NULL COMMENT '礼物名称',
  `give_goodsurl` varchar(1024) DEFAULT NULL COMMENT '礼物图片',
  `give_user_name` varchar(128) DEFAULT NULL COMMENT '被打赏用户昵称',
  PRIMARY KEY (`id`),
  KEY `chat_id_uniq` (`chat_id`),
  KEY `AK_from_to_unq` (`from_user_id`,`to_user_id`) USING BTREE,
  KEY `create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibar_private_chat
-- ----------------------------

-- ----------------------------
-- Table structure for `weibar_private_chat_id_map`
-- ----------------------------
DROP TABLE IF EXISTS `weibar_private_chat_id_map`;
CREATE TABLE `weibar_private_chat_id_map` (
  `chat_id` bigint(20) NOT NULL,
  `from_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '发送用户ID',
  `to_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '接收用户ID',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`chat_id`),
  KEY `AK_from_to_unq` (`from_user_id`,`to_user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibar_private_chat_id_map
-- ----------------------------


-- ----------------------------
-- Table structure for `weibar_redpackage_deposit`
-- ----------------------------
DROP TABLE IF EXISTS `weibar_redpackage_deposit`;
CREATE TABLE `weibar_redpackage_deposit` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `redpackageid` bigint(20) DEFAULT NULL COMMENT '红包组ID',
  `openid` varchar(500) DEFAULT NULL COMMENT '充值的商户对应的微信openid',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `amount` decimal(10,2) NOT NULL COMMENT '红包金额',
  `sendnumber` int(11) DEFAULT NULL COMMENT '发送红包数量',
  `getnumber` int(11) DEFAULT NULL COMMENT '收取红包数量',
  `redPacketTitle` varchar(200) DEFAULT NULL,
  `merchantid` bigint(20) NOT NULL COMMENT '商户ID',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '0 已领取完毕，1 未领取完毕',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Records of weibar_redpackage_deposit
-- ----------------------------

-- ----------------------------
-- Table structure for `weibar_redpackage_deposit_detail`
-- ----------------------------
DROP TABLE IF EXISTS `weibar_redpackage_deposit_detail`;
CREATE TABLE `weibar_redpackage_deposit_detail` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `redpackageid` bigint(20) DEFAULT NULL COMMENT '红包组ID',
  `openid` varchar(500) DEFAULT NULL COMMENT '充值的商户对应的微信openid',
  `user_id` bigint(20) DEFAULT NULL COMMENT '帐号',
  `nickname` varchar(500) DEFAULT NULL COMMENT '充值的商户对应的微信昵称',
  `user_picture` varchar(1024) DEFAULT NULL COMMENT '充值的商户对应的微信图像url',
  `amount` decimal(10,2) NOT NULL COMMENT '红包金额',
  `redPacketTitle` varchar(200) DEFAULT NULL,
  `get_time` datetime DEFAULT NULL COMMENT '红包领取时间',
  `is_best` int(11) DEFAULT NULL COMMENT '是否最佳',
  `status` int(11) NOT NULL COMMENT '红包订单状态',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=181 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibar_redpackage_deposit_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `weibar_redpackage_deposit_temp`
-- ----------------------------
DROP TABLE IF EXISTS `weibar_redpackage_deposit_temp`;
CREATE TABLE `weibar_redpackage_deposit_temp` (
  `redpackageid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '红包组ID',
  `user_id` bigint(20) NOT NULL COMMENT '帐号',
  `openid` varchar(500) DEFAULT NULL COMMENT '充值的商户对应的微信openid',
  `amount` decimal(10,2) NOT NULL COMMENT '红包金额',
  `sendnumber` int(11) DEFAULT NULL COMMENT '发送红包数量',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  `redPacketTitle` varchar(200) DEFAULT NULL,
  `merchantid` bigint(20) NOT NULL COMMENT '商户ID',
  PRIMARY KEY (`redpackageid`)
) ENGINE=InnoDB AUTO_INCREMENT=1515407957798 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibar_redpackage_deposit_temp
-- ----------------------------

-- ----------------------------
-- Table structure for `weibar_red_packet_order`
-- ----------------------------
DROP TABLE IF EXISTS `weibar_red_packet_order`;
CREATE TABLE `weibar_red_packet_order` (
  `orderid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '红包订单id',
  `user_id` bigint(20) NOT NULL COMMENT '帐号',
  `chorderid` varchar(100) NOT NULL COMMENT '渠道微信红包订单id',
  `amount` decimal(12,4) DEFAULT NULL COMMENT '红包金额',
  `openid` varchar(200) NOT NULL COMMENT '红包收款方id',
  `userIp` varchar(100) DEFAULT NULL COMMENT '用户ip',
  `scene_id` varchar(100) DEFAULT NULL COMMENT '发放红包使用场景，红包金额大于200时必传',
  `redPacketTitle` varchar(200) DEFAULT NULL COMMENT '红包标题',
  `description` varchar(500) DEFAULT NULL COMMENT '红包描述',
  `statusCode` varchar(100) DEFAULT NULL COMMENT '微信返回码',
  `statusMsg` varchar(1000) DEFAULT NULL COMMENT '微信返回描述',
  `status` int(11) DEFAULT NULL COMMENT '红包订单状态',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  `ext` text COMMENT '扩展字段',
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

alter table `weibar_red_packet_order` add column `app_id` varchar(256);

-- ----------------------------
-- Records of weibar_red_packet_order
-- ----------------------------

-- ----------------------------
-- Table structure for `weibar_wechat_login_log`
-- ----------------------------
DROP TABLE IF EXISTS `weibar_wechat_login_log`;
CREATE TABLE `weibar_wechat_login_log` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `openid` varchar(1024) DEFAULT NULL COMMENT '商户对应的微信openid',
  `code` varchar(128) DEFAULT NULL COMMENT '微信用于换取token的code',
  `expires_in` bigint(20) DEFAULT NULL COMMENT '微信accessToken过期时间',
  `access_token` varchar(1024) DEFAULT NULL,
  `refresh_token` varchar(1024) DEFAULT NULL,
  `scope` varchar(128) DEFAULT NULL COMMENT '访问作用域',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_unq` (`code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=341 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibar_wechat_login_log
-- ----------------------------





-- ----------------------------
-- Table structure for `weibar_ws_cache`
-- ----------------------------
DROP TABLE IF EXISTS `weibar_ws_cache`;
CREATE TABLE `weibar_ws_cache` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `sub_url` varchar(256) DEFAULT NULL COMMENT '订阅url',
  `res` varchar(8192) DEFAULT NULL COMMENT '返回结果',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=337 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibar_ws_cache
-- ----------------------------

/*
Navicat MySQL Data Transfer

Source Server         : weibar
Source Server Version : 50718
Source Host           : rm-wz9l3k9adb590oksvo.mysql.rds.aliyuncs.com:3306
Source Database       : weibar

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-12-26 10:32:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `merchants_login_info`
-- ----------------------------
DROP TABLE IF EXISTS `merchants_login_info`;
CREATE TABLE `merchants_login_info` (
  `merchantid` bigint(20) NOT NULL DEFAULT '0' COMMENT '商户ID',
  `merchant_passport` varchar(500) DEFAULT NULL COMMENT '商户通行证',
  `merchant_password` varchar(500) DEFAULT NULL COMMENT '商户登陆密码',
  `lastloginip` varchar(40) DEFAULT NULL COMMENT '商户最后登陆时间',
  `lastlogintime` datetime DEFAULT NULL COMMENT '商户最后登陆时间',
  `user_type` tinyint(4) DEFAULT '0' COMMENT '用户类型,0个人,1企业',
  `status` tinyint(4) DEFAULT NULL,
  `version` int(10) unsigned NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`merchantid`),
  KEY `Index_useraccount_1` (`merchant_passport`(255)) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of merchants_login_info
-- ----------------------------

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
-- Table structure for `merchant_account_balance`
-- ----------------------------
DROP TABLE IF EXISTS `merchant_account_balance`;
CREATE TABLE `merchant_account_balance` (
  `merchantid` varchar(20) NOT NULL COMMENT '帐号',
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
-- Records of merchant_account_balance
-- ----------------------------

-- ----------------------------
-- Table structure for `merchant_commission_issue`
-- ----------------------------
DROP TABLE IF EXISTS `merchant_commission_issue`;
CREATE TABLE `merchant_commission_issue` (
  `bill_id` char(20) NOT NULL DEFAULT '' COMMENT '发放订单id',
  `merchantid` char(20) NOT NULL DEFAULT '' COMMENT '发放订单id',
  `pay_order_id` varchar(25) NOT NULL COMMENT '消费订单ID',
  `user_id` varchar(20) NOT NULL COMMENT '帐号',
  `point` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '佣金金额',
  `issue_time` datetime NOT NULL COMMENT '发放时间',
  `effective_time` datetime NOT NULL COMMENT '生效时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后更新时间',
  `remark` varchar(100) NOT NULL DEFAULT '' COMMENT '备注',
  `status` tinyint(4) NOT NULL COMMENT '对应的交易单状态',
  `ext1` varchar(100) NOT NULL DEFAULT '' COMMENT '扩展字段1',
  `ext2` varchar(100) NOT NULL DEFAULT '' COMMENT '扩展字段2',
  `ext3` varchar(100) NOT NULL DEFAULT '' COMMENT '扩展字段3',
  PRIMARY KEY (`bill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商户佣金发放申请表';

-- ----------------------------
-- Records of merchant_commission_issue
-- ----------------------------

-- ----------------------------
-- Table structure for `merchant_withdraw_log`
-- ----------------------------
DROP TABLE IF EXISTS `merchant_withdraw_log`;
CREATE TABLE `merchant_withdraw_log` (
  `id` bigint(20) NOT NULL COMMENT '自增id',
  `merchantid` bigint(20) NOT NULL COMMENT '商户ID',
  `bank_name` varchar(50) NOT NULL COMMENT '银行卡开户行（如中国工商银行）',
  `bank_card_no` varchar(50) NOT NULL COMMENT '银行卡号',
  `bank_card_name` varchar(50) NOT NULL COMMENT '银行卡姓名（姓名或公司名称）',
  `bank_branch` varchar(30) NOT NULL COMMENT '银行所在网点名称',
  `subject` varchar(50) NOT NULL COMMENT '科目',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  `status` tinyint(4) NOT NULL COMMENT '对应的交易单状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商户提现表';

-- ----------------------------
-- Records of merchant_withdraw_log
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
) ENGINE=InnoDB AUTO_INCREMENT=1514113677406 DEFAULT CHARSET=utf8;

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
  `goods_id` int(11) NOT NULL COMMENT '购买霸屏/打赏商品ID',
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
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8 COMMENT='用户消费交易信息表';

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
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COMMENT='用户充值信息表';

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
) ENGINE=InnoDB AUTO_INCREMENT=165 DEFAULT CHARSET=utf8 COMMENT='用户账户交易明细表';

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
  `goodsid` int(11) DEFAULT NULL COMMENT '礼物ID',
  `goodsname` varchar(1024) DEFAULT NULL COMMENT '礼物名称',
  `goodsurl` varchar(1024) DEFAULT NULL COMMENT '礼物图片',
  `amount` decimal(16,2) NOT NULL COMMENT '礼物数额',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibar_goods_setting_info
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=164 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibar_merchants_barrage_info
-- ----------------------------

-- ----------------------------
-- Table structure for `weibar_merchants_barrage_setting_info`
-- ----------------------------
DROP TABLE IF EXISTS `weibar_merchants_barrage_setting_info`;
CREATE TABLE `weibar_merchants_barrage_setting_info` (
  `merchantid` bigint(20) NOT NULL DEFAULT '0' COMMENT '商户ID',
  `barrage_turn_on` varchar(10) DEFAULT NULL COMMENT '弹幕版普通消息开关，0为关，1为开',
  `loop_turn_on` varchar(10) DEFAULT NULL COMMENT '弹幕显示循环开关，0为关，1为开',
  `sytle_turn_on` varchar(10) DEFAULT NULL COMMENT '霸屏效果 1，简洁 2，酷炫 ',
  `sheer_turn_on` varchar(10) DEFAULT NULL COMMENT '背景透明效果效果 1，简洁 2，酷炫',
  `richman_turn_on` varchar(10) DEFAULT NULL COMMENT '土豪霸屏倒计时（霸屏时长超过60秒，将有震撼的倒计时效果），0为关，1为开',
  `qrcode_turn_on` varchar(10) DEFAULT NULL COMMENT '弹幕版二维码开关 ,0为关，1为开',
  `qrcode_light_sytle` varchar(10) DEFAULT NULL COMMENT '弹幕版二维码亮度 ,0为亮，1为暗',
  `barrage_font_sytle` varchar(10) DEFAULT NULL COMMENT '弹幕字体 ,0为大，1为中，2为小',
  `holdscreen_font_sytle` varchar(10) DEFAULT NULL COMMENT '霸屏字体 ,0为大，1为中，2为小',
  `barrage_move_sytle` varchar(10) DEFAULT NULL COMMENT '弹幕移动速度 ,0为慢，1为中，2为快',
  `bg_light_sytle` varchar(10) DEFAULT NULL COMMENT '微上墙亮度 ,0为亮，1为微亮，2为暗',
  `music_turn_on` varchar(10) DEFAULT NULL COMMENT '弹幕显示循环开关，0为关，1为开',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`merchantid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibar_merchants_barrage_setting_info
-- ----------------------------

-- ----------------------------
-- Table structure for `weibar_merchants_base_info`
-- ----------------------------
DROP TABLE IF EXISTS `weibar_merchants_base_info`;
CREATE TABLE `weibar_merchants_base_info` (
  `merchantid` bigint(20) NOT NULL DEFAULT '0' COMMENT '商户ID',
  `producerlogo_url` varchar(500) DEFAULT NULL COMMENT '商户log链接地址',
  `qrcode_url` varchar(500) DEFAULT NULL COMMENT '商户公众号二维码地址',
  `wechat_login_url` varchar(1024) DEFAULT NULL COMMENT '微信授权登录url',
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
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`merchantid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibar_merchants_base_info
-- ----------------------------
INSERT INTO `weibar_merchants_base_info` VALUES ('1', 'http://wemew.oss-cn-qingdao.aliyuncs.com/2017-09-17-18/150564477090406349.jpg?x-oss-process=style/100', null, '测试酒吧1公众号名称', '测试酒吧1名称', null, null, null, null, null, null, null, null, null, null, '2017-11-12 12:20:45', '2017-11-12 12:20:45', '1');
INSERT INTO `weibar_merchants_base_info` VALUES ('2', 'http://wemew.oss-cn-qingdao.aliyuncs.com/2017-09-17-18/150564477090406349.jpg?x-oss-process=style/100', null, null, '番禺万达酒吧', null, null, null, null, null, null, null, null, null, null, '2017-12-18 18:00:15', '2017-12-18 18:00:15', null);
INSERT INTO `weibar_merchants_base_info` VALUES ('3', 'http://wemew.oss-cn-qingdao.aliyuncs.com/2017-09-17-18/150564477090406349.jpg?x-oss-process=style/100', null, null, '白云万达酒吧', null, null, null, null, null, null, null, null, null, null, '2017-12-18 18:00:38', '2017-12-18 18:00:38', null);





-- ----------------------------
-- Table structure for `weibar_merchants_goods_setting_info`
-- ----------------------------
DROP TABLE IF EXISTS `weibar_merchants_goods_setting_info`;
CREATE TABLE `weibar_merchants_goods_setting_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `merchantid` bigint(20) NOT NULL DEFAULT '0' COMMENT '商户ID',
  `goodsid` int(11) DEFAULT NULL COMMENT '礼物ID',
  `goodsname` varchar(1024) DEFAULT NULL COMMENT '礼物名称',
  `goodsurl` varchar(1024) DEFAULT NULL COMMENT '礼物图片',
  `amount` decimal(16,2) NOT NULL COMMENT '礼物数额',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibar_merchants_goods_setting_info
-- ----------------------------
INSERT INTO `weibar_merchants_goods_setting_info` VALUES ('1', '1', '1', '火鸡', 'http://www.wemew.com/wemew/images/noHeadImg_100_100.gif', '0.01', '2017-11-27 11:05:01', '2017-11-27 11:05:01');
INSERT INTO `weibar_merchants_goods_setting_info` VALUES ('2', '1', '2', 'XO', 'http://www.wemew.com/wemew/images/noHeadImg_100_100.gif', '0.59', '2017-11-27 11:05:06', '2017-11-27 11:05:06');
INSERT INTO `weibar_merchants_goods_setting_info` VALUES ('3', '1', '3', '路易十三', 'http://www.wemew.com/wemew/images/noHeadImg_100_100.gif', '1.08', '2017-11-27 11:05:11', '2017-11-27 11:05:11');
INSERT INTO `weibar_merchants_goods_setting_info` VALUES ('4', '1', '4', '花环', 'http://www.wemew.com/wemew/images/noHeadImg_100_100.gif', '0.49', '2017-11-27 11:05:17', '2017-11-27 11:05:17');
INSERT INTO `weibar_merchants_goods_setting_info` VALUES ('5', '1', '5', '皇冠', 'http://www.wemew.com/wemew/images/noHeadImg_100_100.gif', '0.98', '2017-11-27 11:05:22', '2017-11-27 11:05:22');

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
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibar_merchants_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for `weibar_merchants_mtv_setting_info`
-- ----------------------------
DROP TABLE IF EXISTS `weibar_merchants_mtv_setting_info`;
CREATE TABLE `weibar_merchants_mtv_setting_info` (
  `merchantid` bigint(20) NOT NULL DEFAULT '0' COMMENT '商户ID',
  `mtv_name` varchar(10) DEFAULT NULL COMMENT '屏幕MTV的名称',
  `mtv_sytle` varchar(10) DEFAULT NULL COMMENT '屏幕MTV的风格',
  `mtv_url` varchar(10) DEFAULT NULL COMMENT '屏幕MTV的背景视频url',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`merchantid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibar_merchants_mtv_setting_info
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
INSERT INTO `weibar_merchants_price_time_setting_info` VALUES ('5', '1', '1314', '重金霸屏1314秒', '5.00', '2017-11-21 16:10:29', '2017-11-21 16:10:29');

-- ----------------------------
-- Table structure for `weibar_merchants_seat_setting_info`
-- ----------------------------
DROP TABLE IF EXISTS `weibar_merchants_seat_setting_info`;
CREATE TABLE `weibar_merchants_seat_setting_info` (
  `merchantid` bigint(20) NOT NULL DEFAULT '0' COMMENT '商户ID',
  `seat_name` varchar(10) DEFAULT NULL COMMENT '弹幕内容',
  `seat_no` varchar(10) DEFAULT NULL COMMENT '座位号码',
  `min_num` bigint(20) NOT NULL DEFAULT '0' COMMENT '最小人数',
  `max_num` bigint(20) NOT NULL DEFAULT '0' COMMENT '最大人数',
  `price` decimal(16,2) NOT NULL COMMENT '预定价格',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`merchantid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibar_merchants_seat_setting_info
-- ----------------------------

-- ----------------------------
-- Table structure for `weibar_merchants_setting_info`
-- ----------------------------
DROP TABLE IF EXISTS `weibar_merchants_setting_info`;
CREATE TABLE `weibar_merchants_setting_info` (
  `merchantid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商户ID',
  `turn_on` varchar(10) DEFAULT NULL COMMENT '霸屏开关，0为关，1为开',
  `setting_name` varchar(10) DEFAULT NULL COMMENT '配置名称：微上墙',
  `shortcut` varchar(500) DEFAULT NULL COMMENT '快捷方式路径',
  `bar_map` varchar(500) DEFAULT NULL COMMENT '酒吧地图',
  `automatic_detection_screen` varchar(10) DEFAULT NULL COMMENT '自动检测大屏幕开启状态,未开启大屏幕时，用户无法霸屏和打赏',
  `components` varchar(500) DEFAULT NULL COMMENT '设置大屏幕组件',
  `screen_picture` varchar(500) DEFAULT NULL COMMENT '屏幕背景图片',
  `message_audit` varchar(50) DEFAULT NULL COMMENT '消息审核类型,不审核 0 审核全部消息 1 审核霸屏、打赏消息 2 审核视频消息',
  `mtv_turn_on` varchar(10) DEFAULT NULL COMMENT '霸屏视频开关，0为关，1为开',
  `redpackage_turn_on` varchar(10) DEFAULT NULL COMMENT '霸屏红包开关，0为关，1为开',
  `group_turn_on` varchar(10) DEFAULT NULL COMMENT '异性配对 1，女女配对 2，男男配对 3',
  `message_turn_on` varchar(10) DEFAULT NULL COMMENT '是否允许私聊，0为关，1为开',
  `message_clearn` varchar(10) DEFAULT NULL COMMENT '是否自动清除全部消息(开启功能，默认将在每天8:00自动清除全部消息)，0为关，1为开',
  `message_admin` varchar(200) DEFAULT NULL COMMENT '消息管理员',
  `message_manager` varchar(500) DEFAULT NULL COMMENT '消息审核接收者',
  `pc_url` varchar(1024) DEFAULT NULL,
  `mob_url` varchar(1024) DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  `openid` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`merchantid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibar_merchants_setting_info
-- ----------------------------
INSERT INTO `weibar_merchants_setting_info` VALUES ('1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'http://wx.qlogo.cn/mmopen/62wpEIlHFFS6If9NPoEc99QyYq6VZNYTtrOy553ic5cQRibEjf0VarD3z2pYdlT4WEJ7jzV1wpQIrdibbO9NfCTgpzqrckwu2tS/0', 'http://wx.qlogo.cn/mmopen/62wpEIlHFFS6If9NPoEc99QyYq6VZNYTtrOy553ic5cQRibEjf0VarD3z2pYdlT4WEJ7jzV1wpQIrdibbO9NfCTgpzqrckwu2tS/0', '2017-11-12 11:24:26', '2017-11-12 11:24:26', 'op2oX1DtL6cZTddF3eu7A2q_HA8o');

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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

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

-- ----------------------------
-- Table structure for `weibar_private_chat`
-- ----------------------------
DROP TABLE IF EXISTS `weibar_private_chat`;
CREATE TABLE `weibar_private_chat` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `chat_id` bigint(20) NOT NULL ,
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
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibar_private_chat
-- ----------------------------

DROP TABLE IF EXISTS `weibar_private_chat_id_map`;
CREATE TABLE `weibar_private_chat_id_map` (
  `chat_id` bigint(20) NOT NULL ,
  `from_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '发送用户ID',
  `to_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '接收用户ID',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`chat_id`),
  KEY `AK_from_to_unq` (`from_user_id`,`to_user_id`) USING BTREE
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;


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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibar_redpackage_deposit
-- ----------------------------


DROP TABLE IF EXISTS `weibar_ws_cache`;
CREATE TABLE `weibar_ws_cache` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `sub_url` varchar(256) DEFAULT NULL COMMENT '订阅url',
  `res` varchar(8192) DEFAULT NULL COMMENT '返回结果',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=14  DEFAULT CHARSET=utf8;





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
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=1514213815778 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibar_wechat_login_log
-- ----------------------------

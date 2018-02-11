CREATE TABLE `daka_day_summary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `daka_date` DATE NOT NULL  COMMENT '日期',
  `count` int(11) NOT NULL COMMENT '打卡总参与人次',
  `scount` int(11) NOT NULL COMMENT '打卡成功人次',
  `fcount` int(11) NOT NULL COMMENT '打卡失败人次',
  `pay_amount` decimal(10,2) DEFAULT NULL COMMENT '用户支付总金额',
  `send_amount` decimal(10,2) DEFAULT NULL COMMENT '用户分到金额',
  `early_open_id` varchar(200) DEFAULT NULL COMMENT '当天早起之星的openid',
  `early_time` datetime DEFAULT NULL COMMENT '当天早起之星的时间',
  `early_user_id` bigint(20) DEFAULT NULL COMMENT '当天早起之星帐号',
  `early_user_picture` varchar(1024) DEFAULT NULL,
  `lucky_open_id` varchar(200) DEFAULT NULL COMMENT '手气之星的openid',
  `lucky_amount` decimal(10,2) DEFAULT NULL COMMENT '手气之星金额',
  `lucky_user_id` bigint(20) DEFAULT NULL COMMENT '手气之星帐号',
  `lucky_user_picture` varchar(1024) DEFAULT NULL,
  `guts_open_id` varchar(200) DEFAULT NULL COMMENT '毅力之星的openid',
  `guts_count` int(11) DEFAULT NULL COMMENT '毅力之星总打卡次数',
  `guts_user_id` bigint(20) DEFAULT NULL COMMENT '毅力之星帐号',
  `guts_user_picture` varchar(1024) DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



CREATE TABLE `daka_order` (
  `orderid` bigint(20) COMMENT '打卡订单id',
  `user_id` bigint(20) NOT NULL COMMENT '帐号',
  `openid` varchar(200) NOT NULL COMMENT '用户openid',
  `pay_amount` decimal(10,2) DEFAULT NULL COMMENT '用户支付金额',
  `get_amount` decimal(10,2) DEFAULT NULL COMMENT '用户打开成功分到金额',
  `status` int(11) DEFAULT NULL COMMENT '订单状态（未付款，已付款，已分配金额）',
  `order_date` DATE NOT NULL  COMMENT '这个订单所属结算日期（可以支付下单明天的日期）',  
  `pay_time` datetime DEFAULT NULL  COMMENT '支付时间时间',
  `daka_time` datetime DEFAULT NULL  COMMENT '打卡时间',
  `create_time` datetime NOT NULL   COMMENT '创建时间',
  `update_time` datetime NOT NULL   COMMENT '更新时间',
  `client_ip` varchar(200) DEFAULT NULL  COMMENT '用户IP',
  PRIMARY KEY (`orderid`),
  KEY `AK_Key_user_id` (`user_id`) USING BTREE,
  KEY `AK_Key_order_date` (`order_date`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4;



CREATE TABLE `daka_user` (
  `user_id` bigint(20) NOT NULL COMMENT '帐号',
  `user_picture` varchar(1024) DEFAULT NULL,
  `openid` varchar(1024) NOT NULL,
  `nickname` varchar(500) DEFAULT NULL COMMENT '用户昵称',
  `sex` varchar(500) DEFAULT NULL COMMENT '用户的性别',
  `city` varchar(500) DEFAULT NULL COMMENT '用户城市',
  `country` varchar(500) DEFAULT NULL COMMENT '用户国家',
  `province` varchar(500) DEFAULT NULL COMMENT '用户省份',
  `count` int(11) NOT NULL COMMENT '打卡总次',
  `scount` int(11) NOT NULL COMMENT '打卡成功次',
  `fcount` int(11) NOT NULL COMMENT '打卡失败次',
  `pay_sum_amount` decimal(10,2) DEFAULT NULL COMMENT '用户支付总金额',
  `get_sum_amount` decimal(10,2) DEFAULT NULL COMMENT '用户打开成功分到金额',
  `create_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `s_order` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_no` varchar(128)  DEFAULT NULL COMMENT 'orderNo',
  `order_desc` varchar(128) DEFAULT NULL COMMENT 'orderDesc',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

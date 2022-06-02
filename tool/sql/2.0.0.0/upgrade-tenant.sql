INSERT INTO `dw_rdbms_fields` (`TABLE_NAME`, `SEQ`, `FIELD_NAME`, `IS_KEY`, `FIELD_TYPE`, `STATUS_CODE`, `FIELD_DISPLAY_NAME`, `SCALE`, `DEFAULT_VALUE`, `NULLABLE`, `IS_VERSION`, `SIZE`, `IS_AUTO_INCREMENT`) VALUES
	('dw_schedule_time', 6, 'assign_time', 'N', 'varchar', 'Y', 'assign_time', '0', '', 'Y', 'N', '255', 'N'),
	('dw_schedule_time', 26, 'byday', 'N', 'varchar', 'Y', 'byday', '0', '', 'Y', 'N', '5', 'N'),
	('dw_schedule_time', 28, 'bymonthday', 'N', 'INT', 'Y', 'bymonthday', '0', '', 'Y', 'N', '5', 'N'),
	('dw_schedule_time', 29, 'byweeklyday', 'N', 'varchar', 'Y', 'byweeklyday', '0', '', 'Y', 'N', '10', 'N'),
	('dw_schedule_time', 24, 'daily', 'N', 'INT', 'Y', 'daily', '0', '', 'Y', 'N', '10', 'N'),
	('dw_schedule_time', 5, 'day_of_month', 'N', 'varchar', 'Y', 'day_of_month', '0', '', 'Y', 'N', '255', 'N'),
	('dw_schedule_time', 13, 'day_radio', 'N', 'varchar', 'Y', 'day_radio', '0', '', 'Y', 'N', '1', 'N'),
	('dw_schedule', 6, 'description', 'N', 'varchar', 'Y', 'description', '0', '', 'Y', 'N', '100', 'N'),
	('dw_schedule', 7, 'effective_time', 'N', 'datetime', 'Y', 'effective_time', '0', '', 'Y', 'N', '20', 'N'),
	('dw_schedule', 5, 'enable_status', 'N', 'varchar', 'Y', 'enable_status', '0', '', 'Y', 'N', '1', 'N'),
	('dw_schedule_record', 8, 'end_time', 'N', 'datetime', 'Y', 'end_time', '0', '', 'Y', 'N', '20', 'N'),
	('dw_schedule_time', 21, 'end_time', 'N', 'datetime', 'Y', 'end_time', '0', '', 'Y', 'N', '20', 'N'),
	('dw_schedule_record', 1, 'execute_id', 'Y', 'varchar', 'Y', 'execute_id', '0', '', 'N', 'N', '50', 'N'),
	('dw_schedule_record', 4, 'execute_status', 'N', 'varchar', 'Y', 'execute_status', '0', '', 'Y', 'N', '10', 'N'),
	('dw_schedule', 8, 'expire_time', 'N', 'datetime', 'Y', 'expire_time', '0', '', 'Y', 'N', '20', 'N'),
	('dw_schedule_time', 17, 'frequency', 'N', 'varchar', 'Y', 'frequency', '0', '', 'Y', 'N', '10', 'N'),
	('dw_schedule_time', 8, 'holiday', 'N', 'varchar', 'Y', 'holiday', '0', '', 'Y', 'N', '255', 'N'),
	('dw_schedule_time', 23, 'hourly', 'N', 'INT', 'Y', 'hourly', '0', '', 'Y', 'N', '10', 'N'),
	('dw_schedule_contact', 1, 'id', 'Y', 'number', 'Y', 'id', '0', '', 'N', 'N', '10', 'N'),
	('dw_schedule_time', 12, 'is_allow_concurrent', 'N', 'varchar', 'Y', 'is_allow_concurrent', '0', '', 'Y', 'N', '1', 'N'),
	('dw_schedule', 3, 'job_name', 'N', 'varchar', 'Y', 'job_name', '0', '', 'Y', 'N', '50', 'N'),
	('dw_schedule_record', 3, 'job_name', 'N', 'varchar', 'Y', 'job_name', '0', '', 'N', 'N', '50', 'N'),
	('dw_schedule', 13, 'last_period_time', 'N', 'number', 'Y', 'last_period_time', '0', '', 'Y', 'N', '10', 'N'),
	('dw_schedule', 12, 'last_success_time', 'N', 'datetime', 'Y', 'last_success_time', '0', '', 'Y', 'N', NULL, 'N'),
	('dw_schedule_contact', 5, 'mail_content', 'N', 'number', 'Y', 'mail_content', '0', '', 'Y', 'N', '255', 'N'),
	('dw_schedule_contact', 4, 'mail_subject', 'N', 'number', 'Y', 'mail_subject', '0', '', 'Y', 'N', '255', 'N'),
	('dw_schedule_contact', 3, 'mail_type', 'N', 'number', 'Y', 'mail_type', '0', '', 'Y', 'N', '10', 'N'),
	('dw_schedule', 9, 'max_runtime', 'N', 'number', 'Y', 'max_runtime', '0', '', 'Y', 'N', '10', 'N'),
	('dw_schedule_record', 5, 'message', 'N', 'varchar', 'Y', 'message', '0', '', 'Y', 'N', '255', 'N'),
	('dw_schedule_record', 6, 'message_detail', 'N', 'varchar', 'Y', 'message_detail', '0', '', 'Y', 'N', '255', 'N'),
	('dw_schedule_time', 22, 'minutely', 'N', 'INT', 'Y', 'minutely', '0', '', 'Y', 'N', '10', 'N'),
	('dw_schedule_time', 2, 'month', 'N', 'varchar', 'Y', 'month', '0', '', 'Y', 'N', '255', 'N'),
	('dw_schedule_time', 14, 'month_radio', 'N', 'varchar', 'Y', 'month_radio', '0', '', 'Y', 'N', '1', 'N'),
	('dw_schedule_time', 27, 'monthly', 'N', 'INT', 'Y', 'monthly', '0', '', 'Y', 'N', '10', 'N'),
	('dw_schedule', 14, 'next_execute_time', 'N', 'datetime', 'Y', 'next_execute_time', '0', '', 'Y', 'N', NULL, 'N'),
	('dw_schedule_contact', 6, 'receiver_email', 'N', 'number', 'Y', 'receiver_email', '0', '', 'Y', 'N', '255', 'N'),
	('dw_schedule', 11, 'recent_status', 'N', 'varchar', 'Y', 'recent_status', '0', '', 'Y', 'N', '255', 'N'),
	('dw_schedule_time', 18, 'repeat_count', 'N', 'number', 'Y', 'repeat_count', '0', '', 'Y', 'N', '65', 'N'),
	('dw_schedule_time', 19, 'repeat_type', 'N', 'varchar', 'Y', 'repeat_type', '0', '', 'Y', 'N', '1', 'N'),
	('dw_schedule', 1, 'schedule_id', 'Y', 'varchar', 'Y', 'schedule_id', '0', '', 'N', 'N', '50', 'N'),
	('dw_schedule_contact', 2, 'schedule_id', 'N', 'number', 'Y', 'schedule_id', '0', '', 'N', 'N', '50', 'N'),
	('dw_schedule_record', 2, 'schedule_id', 'N', 'varchar', 'Y', 'schedule_id', '0', '', 'N', 'N', '50', 'N'),
	('dw_schedule_time', 1, 'schedule_id', 'Y', 'varchar', 'Y', 'schedule_id', '0', '', 'N', 'N', '50', 'N'),
	('dw_schedule', 2, 'schedule_name', 'N', 'varchar', 'Y', 'schedule_name', '0', '', 'Y', 'N', '50', 'N'),
	('dw_schedule', 10, 'schedule_param', 'N', 'varchar', 'Y', 'schedule_param', '0', '', 'Y', 'N', '255', 'N'),
	('dw_schedule_record', 9, 'schedule_param', 'N', 'varchar', 'Y', 'schedule_param', '0', '', 'Y', 'N', '255', 'N'),
	('dw_schedule', 4, 'schedule_type', 'N', 'varchar', 'Y', 'schedule_type', '0', '', 'Y', 'N', '1', 'N'),
	('dw_schedule_record', 10, 'schedule_type', 'N', 'varchar', 'Y', 'schedule_type', '0', '', 'Y', 'N', '1', 'N'),
	('dw_schedule_contact', 7, 'send_condition', 'N', 'number', 'Y', 'send_condition', '0', '', 'Y', 'N', '50', 'N'),
	('dw_schedule_record', 7, 'start_time', 'N', 'datetime', 'Y', 'start_time', '0', '', 'Y', 'N', '20', 'N'),
	('dw_schedule_time', 20, 'start_time', 'N', 'datetime', 'Y', 'start_time', '0', '', 'Y', 'N', '20', 'N'),
	('dw_schedule_time', 7, 'time', 'N', 'varchar', 'Y', 'time', '0', '', 'Y', 'N', '255', 'N'),
	('dw_schedule_time', 9, 'time1', 'N', 'varchar', 'Y', 'time1', '0', '', 'Y', 'N', '255', 'N'),
	('dw_schedule_time', 10, 'time2', 'N', 'varchar', 'Y', 'time2', '0', '', 'Y', 'N', '255', 'N'),
	('dw_schedule_time', 11, 'time3', 'N', 'varchar', 'Y', 'time3', '0', '', 'Y', 'N', '255', 'N'),
	('dw_schedule_time', 15, 'time_radio', 'N', 'varchar', 'Y', 'time_radio', '0', '', 'Y', 'N', '1', 'N'),
	('dw_schedule_time', 4, 'week', 'N', 'varchar', 'Y', 'week', '0', '', 'Y', 'N', '255', 'N'),
	('dw_schedule_time', 3, 'week_of_month', 'N', 'varchar', 'Y', 'week_of_month', '0', '', 'Y', 'N', '255', 'N'),
	('dw_schedule_time', 16, 'week_radio', 'N', 'varchar', 'Y', 'week_radio', '0', '', 'N', 'N', '1', 'N'),
	('dw_schedule_time', 25, 'weekly', 'N', 'INT', 'Y', 'weekly', '0', '', 'Y', 'N', '10', 'N'),
	('dw_schedule', 15, 'tenantid', 'Y', 'varchar', 'N', 'tenantid', '0', '', 'N', 'N', '40', 'N'),
	('dw_schedule_contact', 8, 'tenantid', 'Y', 'varchar', 'N', 'tenantid', '0', '', 'N', 'N', '40', 'N'),
	('dw_schedule_record', 11, 'tenantid', 'Y', 'varchar', 'N', 'tenantid', '0', '', 'N', 'N', '40', 'N'),
	('dw_schedule_time', 30, 'tenantid', 'Y', 'varchar', 'N', 'tenantid', '0', '', 'N', 'N', '40', 'N');

INSERT INTO `dw_rdbms_tables` (`table_name`, `table_display_name`, `table_description`) VALUES
	('dw_schedule', '排程表', '排程表'),
	('dw_schedule_contact', '排程寄信通知表', '排程寄信通知表'),
	('dw_schedule_record', '排程執行記錄', '排程執行記錄'),
	('dw_schedule_time', '排程執行時間設定檔', '排程執行時間設定檔');

CREATE TABLE `dw_schedule` (
  `schedule_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '排程編號',
  `schedule_name` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '排程名稱',
  `job_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '工作名稱',
  `schedule_type` varchar(1) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '排程類型 1.指定時間背景執行 2.周期執行',
  `enable_status` varchar(1) COLLATE utf8_bin NOT NULL DEFAULT 'Y' COMMENT '啟用狀態 Y/N',
  `description` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `effective_time` timestamp NULL DEFAULT NULL COMMENT '排程生效時間',
  `expire_time` timestamp NULL DEFAULT NULL COMMENT '排程失效時間',
  `max_runtime` int(10) DEFAULT NULL COMMENT '最長執行時間(分鐘)',
  `schedule_param` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '參數',
  `recent_status` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '近期狀態',
  `last_success_time` timestamp NULL DEFAULT NULL COMMENT '上次成功時間',
  `last_period_time` int(10) DEFAULT NULL COMMENT '上次執行時間',
  `next_execute_time` timestamp NULL DEFAULT NULL COMMENT '下次執行時間',
  `tenantid` varchar(40) NOT NULL COMMENT '租戶ID',
  PRIMARY KEY (`schedule_id`, `tenantid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='排程表';

CREATE TABLE `dw_schedule_contact` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '編號',
  `schedule_id` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '排程編號',
  `mail_type` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '寄件形式',
  `mail_subject` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '寄件主題',
  `mail_content` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '寄件內容',
  `receiver_email` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '收件人email地址',
  `send_condition` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '寄信條件',
  `tenantid` varchar(40) NOT NULL COMMENT '租戶ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='排程寄信通知表';

CREATE TABLE `dw_schedule_record` (
  `execute_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '執行編號',
  `schedule_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '排程編號',
  `job_name` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '工作名稱',
  `execute_status` varchar(10) COLLATE utf8_bin DEFAULT '' COMMENT '執行狀態 ',
  `message` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '訊息id',
  `message_detail` text COLLATE utf8_bin DEFAULT NULL COMMENT '詳細訊息',
  `start_time` timestamp NOT NULL COMMENT '執行開始時間',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '執行結束時間',
  `schedule_param` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '執行參數',
  `schedule_type` varchar(1) COLLATE utf8_bin DEFAULT '' COMMENT '排程類型 1.指定時間背景執行 2.周期執行',
  `tenantid` varchar(40) NOT NULL COMMENT '租戶ID',
  PRIMARY KEY (`execute_id`, `tenantid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='排程執行記錄';

CREATE TABLE `dw_schedule_time` (
  `schedule_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '執行編號',
  `month` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '月份',
  `week_of_month` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '每個月第幾個星期',
  `week` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '星期幾',
  `day_of_month` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '每個月第幾天',
  `assign_time` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '指定時間',
  `time` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '週期性指定時間',
  `holiday` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '假日處理模式',
  `time1` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '時間區間一',
  `time2` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '時間區間二',
  `time3` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '時間區間三',
  `is_allow_concurrent` varchar(1) COLLATE utf8_bin DEFAULT '' COMMENT '是否允許併發 Y/N',
  `day_radio` varchar(1) COLLATE utf8_bin DEFAULT NULL COMMENT '日頻次',
  `month_radio` varchar(1) COLLATE utf8_bin DEFAULT NULL COMMENT '月頻次',
  `time_radio` varchar(1) COLLATE utf8_bin DEFAULT NULL COMMENT '時間頻次',
  `week_radio` varchar(1) COLLATE utf8_bin DEFAULT NULL COMMENT '周頻次',
  `frequency` varchar(10) COLLATE utf8_bin DEFAULT '' COMMENT '週期頻率',
  `repeat_type` varchar(1) COLLATE utf8_bin DEFAULT NULL COMMENT '區間類型  1.每幾分 2.每幾小時 3.每幾天',
  `start_time` timestamp NULL DEFAULT NULL COMMENT '開始日期',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '結束日期',
  `repeat_count` decimal(65,0) DEFAULT NULL COMMENT '重覆次數',
  `minutely` int(10) DEFAULT NULL COMMENT '每n分',
  `hourly` int(10) DEFAULT NULL COMMENT '每n時',
  `daily` int(10) DEFAULT NULL COMMENT '每n天',
  `weekly` int(10) DEFAULT NULL COMMENT '每n週',
  `byday` varchar(5) COLLATE utf8_bin DEFAULT NULL COMMENT '星期n',
  `monthly` int(10) DEFAULT NULL COMMENT '每n月',
  `bymonthday` int(5) DEFAULT NULL COMMENT '當月中的第n天',
  `byweeklyday` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '當月中的第n個星期m',
  `tenantid` varchar(40) NOT NULL COMMENT '租戶ID',
  PRIMARY KEY (`schedule_id`, `tenantid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='排程執行時間設定檔';

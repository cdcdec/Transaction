--
-- Table structure for table `t_comment`
--
--sql语句中的数据库,数据表的名字,可以不加单引号,也可以全部用小写
DROP DATABASE IF EXISTS `TRANSACTION`;
CREATE DATABASE `TRANSACTION`;
USE `TRANSACTION`;

DROP TABLE IF EXISTS `t_comment`;

--
--外键信息
--USER_ID外键,与t_user表的主键关联
--TRANSACTION_ID外键,与t_transaction表的主键关联
--

CREATE TABLE `t_comment` (
  `ID` int(10) primary key not null auto_increment,
  `CM_TITLE` varchar(255) NOT NULL,
  `CM_CONTENT` text,
  `CM_DATE` varchar(255) default NULL,
  `USER_ID` int(10) NOT NULL,
  `TRANSACTION_ID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



--
-- Table structure for table `t_log`
--

--
--外键信息
--无外键
--

DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log` (
  `ID` int(10) primary key not null auto_increment,
  `LOG_DATE` varchar(255) NOT NULL,
  `HANDLER_ID` int(10) NOT NULL,
  `COMMENT_ID` int(10) NOT NULL,
  `TS_ID` int(10) NOT NULL,
  `TS_DESC` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `t_role`
--

--
--外键信息
--无外键
--

DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `ROLE_NAME` varchar(255) NOT NULL,
  `ID` int(10) primary key not null auto_increment
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Table structure for table `t_transaction`
--


--
--外键信息
--INITIATOR_ID外键,与t_user表的主键关联
--HANDLER_ID外键,与t_user表的主键关联
--PRE_HANDLER_ID外键,与t_user表的主键关联
--

DROP TABLE IF EXISTS `t_transaction`;
CREATE TABLE `t_transaction` (
  `ID` int(10) primary key not null auto_increment,
  `TS_TITLE` varchar(255) NOT NULL,
  `TS_CONTENT` text,
  `TS_TARGETDATE` varchar(255) default NULL,
  `TS_FACTDATE` varchar(255) default NULL,
  `TS_CREATEDATE` varchar(255) default NULL,
  `INITIATOR_ID` int(10) default NULL,
  `HANDLER_ID` int(10) default NULL,
  `PRE_HANDLER_ID` int(10) default NULL,
  `TS_STATE` varchar(255) NOT NULL,
  `IS_HURRY` varchar(255) default '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



--
-- Table structure for table `t_user`
--

--
--外键信息
--ROLE_ID外键,与t_role表的主键关联
--

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `ID` int(10) primary key not null auto_increment,
  `USER_NAME` varchar(255) NOT NULL,
  `ROLE_ID` int(10) NOT NULL,
  `REAL_NAME` varchar(255) default NULL,
  `IS_DELETE` varchar(255) NOT NULL default '0',
  `PASS_WD` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



--
-- Table structure for table `user_transfer`
--

--
--外键信息
--TARGET_USER_ID外键,与t_user表的主键关联
--TS_ID外键,与t_transaction表的主键关联
--USER_ID外键,与t_user表的主键关联
--

DROP TABLE IF EXISTS `user_transfer`;
CREATE TABLE `user_transfer` (
  `ID` int(10) primary key not null auto_increment,
  `TS_ID` int(10) NOT NULL COMMENT 'Transaction foreign key',
  `USER_ID` int(10) NOT NULL COMMENT 'User foreign key',
  `TARGET_USER_ID` int(10) NOT NULL COMMENT 'target user foreign key',
  `OPERATE_DATE` varchar(255) NOT NULL COMMENT 'operate date'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;






----------------------
-- Define foreign keys
----------------------

--t_comment外键
ALTER TABLE t_comment ADD CONSTRAINT FK_t_comment_t_user FOREIGN KEY (user_id) REFERENCES t_user (id);
ALTER TABLE t_comment ADD CONSTRAINT FK_t_comment_t_transaction FOREIGN KEY (TRANSACTION_ID) REFERENCES t_transaction (id);

--t_transaction外键
ALTER TABLE t_transaction ADD CONSTRAINT FK_t_transaction_t_user FOREIGN KEY (INITIATOR_ID) REFERENCES t_user (id);
ALTER TABLE t_transaction ADD CONSTRAINT FK_t_transaction2_t_user FOREIGN KEY (HANDLER_ID) REFERENCES t_user (id);
ALTER TABLE t_transaction ADD CONSTRAINT FK_t_transaction3_t_user FOREIGN KEY (PRE_HANDLER_ID) REFERENCES t_user (id);



--t_user外键
ALTER TABLE t_user ADD CONSTRAINT FK_t_user_t_role FOREIGN KEY (ROLE_ID) REFERENCES t_role (id);


--user_transfer外键
alter table user_transfer add constraint fk_user_transfer_t_user foreign key(TARGET_USER_ID) references t_user(id);
alter table user_transfer add constraint fk_user_transfer2_t_transaction foreign key(TS_ID) references t_transaction(id);
alter table user_transfer add constraint fk_user_transfer3_t_user foreign key(USER_ID) references t_user(id);


--插入数据
INSERT INTO `t_role` VALUES ('admin',1),('manager',2),('employee',3);
INSERT INTO `t_user` VALUES (1,'root',1,'root','0','12345');

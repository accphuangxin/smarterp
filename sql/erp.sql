# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.17)
# Database: erp
# Generation Time: 2022-07-16 11:07:53 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;


# Dump of table t_sys_authbutton
# ------------------------------------------------------------


DROP TABLE IF EXISTS `t_sys_authbutton`;

CREATE TABLE `t_sys_authbutton`
(
    `ID`          int(10)  NOT NULL AUTO_INCREMENT,
    `BUTTON_ID`   varchar(36)  DEFAULT NULL,
    `BUTTON_CODE` varchar(20)  DEFAULT NULL,
    `ROLE_ID`     varchar(36)  DEFAULT NULL,
    `ROLE_CODE`   varchar(20)  DEFAULT NULL,
    `REMARK`      varchar(200) DEFAULT NULL,
    `BUTTON_NAME` varchar(100) DEFAULT NULL,
    `CREATE_BY`   varchar(50)  DEFAULT NULL,
    `CREATE_TIME` datetime NOT NULL,
    `UPDATE_BY`   varchar(50)  DEFAULT NULL,
    `UPDATE_TIME` datetime     DEFAULT NULL,
    PRIMARY KEY (`ID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;



# Dump of table t_sys_authresouce
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_authresouce`;

CREATE TABLE `t_sys_authresouce`
(
    `ID`            int(10)  NOT NULL AUTO_INCREMENT,
    `RESOURCE_ID`   varchar(100) DEFAULT NULL,
    `RESOURCE_CODE` varchar(20)  DEFAULT NULL,
    `ROLE_ID`       varchar(36)  DEFAULT NULL,
    `ROLE_CODE`     varchar(50)  DEFAULT NULL,
    `SAAS_CODE`     varchar(50)  DEFAULT NULL,
    `REMARK`        varchar(200) DEFAULT NULL,
    `MODIFY_TIME`   datetime     DEFAULT NULL,
    `MODIFY_USER`   varchar(20)  DEFAULT NULL,
    `CREATE_BY`     varchar(50)  DEFAULT NULL,
    `CREATE_TIME`   datetime NOT NULL,
    `UPDATE_BY`     varchar(50)  DEFAULT NULL,
    `UPDATE_TIME`   datetime     DEFAULT NULL,
    PRIMARY KEY (`ID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;



# Dump of table t_sys_authservice
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_authservice`;

CREATE TABLE `t_sys_authservice`
(
    `ID`           int(10) NOT NULL AUTO_INCREMENT,
    `SERVICE_ID`   varchar(36)  DEFAULT NULL,
    `METHOD_CODE`  varchar(20)  DEFAULT NULL,
    `SERVICE_CODE` varchar(20)  DEFAULT NULL,
    `ROLE_ID`      varchar(36)  DEFAULT NULL,
    `ROLE_CODE`    varchar(20)  DEFAULT NULL,
    `SAAS_CODE`    varchar(50)  DEFAULT NULL,
    `REMARK`       varchar(200) DEFAULT NULL,
    `CREATE_TIME`  datetime     DEFAULT NULL,
    `CREATE_USER`  varchar(20)  DEFAULT NULL,
    `MODIFY_TIME`  date         DEFAULT NULL,
    `MODIFY_USER`  varchar(20)  DEFAULT NULL,
    PRIMARY KEY (`ID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;



# Dump of table t_sys_authuser
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_authuser`;

CREATE TABLE `t_sys_authuser`
(
    `ID`          int(10)     NOT NULL AUTO_INCREMENT,
    `USER_ID`     varchar(36) NOT NULL,
    `ROLE_ID`     varchar(36) NOT NULL,
    `USER_CODE`   varchar(20) NOT NULL,
    `ROLE_CODE`   varchar(40) NOT NULL,
    `SAAS_CODE`   varchar(50) DEFAULT NULL,
    `CREATE_BY`   varchar(50) DEFAULT NULL,
    `CREATE_TIME` datetime    NOT NULL,
    `UPDATE_BY`   varchar(50) DEFAULT NULL,
    `UPDATE_TIME` datetime    DEFAULT NULL,
    PRIMARY KEY (`ID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;



# Dump of table t_sys_code
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_code`;

CREATE TABLE `t_sys_code`
(
    `ID`          int(10)       NOT NULL AUTO_INCREMENT,
    `VALUE`       varchar(4000) NOT NULL,
    `TEXT`        varchar(50)   NOT NULL,
    `CODE`        varchar(30)   NOT NULL,
    `PARENT`      varchar(30)  DEFAULT NULL,
    `REMARK`      varchar(200) DEFAULT NULL,
    `SAAS_CODE`   varchar(50)  DEFAULT NULL,
    `CREATE_BY`   varchar(50)  DEFAULT NULL,
    `CREATE_TIME` datetime      NOT NULL,
    `UPDATE_BY`   varchar(50)  DEFAULT NULL,
    `UPDATE_TIME` datetime     DEFAULT NULL,
    `org`         varchar(100) DEFAULT NULL,
    PRIMARY KEY (`ID`),
    UNIQUE KEY `sys_code_index` (`CODE`, `TEXT`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;



# Dump of table t_sys_menu
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_menu`;

CREATE TABLE `t_sys_menu`
(
    `ID`          int(10)     NOT NULL AUTO_INCREMENT,
    `CODE`        varchar(20) NOT NULL,
    `PARENT_CODE` varchar(20)  DEFAULT NULL,
    `PAGE_CODE`   varchar(200) DEFAULT NULL,
    `REMARK`      varchar(100) DEFAULT NULL,
    `STATUS`      varchar(10)  DEFAULT NULL,
    `SORT_INDEX`  int(10)      DEFAULT NULL,
    `NAME`        varchar(50) NOT NULL,
    `STATE`       varchar(10) NOT NULL,
    `SAAS_CODE`   varchar(50)  DEFAULT NULL,
    `CREATE_BY`   varchar(50)  DEFAULT NULL,
    `CREATE_TIME` datetime    NOT NULL,
    `UPDATE_BY`   varchar(50)  DEFAULT NULL,
    `UPDATE_TIME` datetime     DEFAULT NULL,
    PRIMARY KEY (`ID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# Dump of table t_sys_org
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_org`;

CREATE TABLE `t_sys_org`
(
    `ID`          int(10)      NOT NULL AUTO_INCREMENT,
    `ORG_CODE`    varchar(20)  NOT NULL,
    `ORG_NAME`    varchar(200) NOT NULL,
    `PARENT_CODE` varchar(20) DEFAULT NULL,
    `LEVELS`      int(10)      NOT NULL,
    `ALIVE_FLAG`  int(10)      NOT NULL,
    `SAAS_CODE`   varchar(50) DEFAULT NULL,
    `CREATE_BY`   varchar(50) DEFAULT NULL,
    `CREATE_TIME` datetime     NOT NULL,
    `UPDATE_BY`   varchar(50) DEFAULT NULL,
    `UPDATE_TIME` datetime    DEFAULT NULL,
    `STATE`       varchar(10) DEFAULT NULL,
    PRIMARY KEY (`ID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;



# Dump of table t_sys_page
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_page`;

CREATE TABLE `t_sys_page`
(
    `ID`          int(10)      NOT NULL AUTO_INCREMENT,
    `CODE`        varchar(20)  NOT NULL,
    `URL`         varchar(200) NOT NULL,
    `NAME`        varchar(50)  NOT NULL,
    `SAAS_CODE`   varchar(50) DEFAULT NULL,
    `CREATE_BY`   varchar(50) DEFAULT NULL,
    `CREATE_TIME` datetime     NOT NULL,
    `UPDATE_BY`   varchar(50) DEFAULT NULL,
    `UPDATE_TIME` datetime    DEFAULT NULL,
    `IS_CACHE`    varchar(10) DEFAULT NULL,
    PRIMARY KEY (`ID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;



# Dump of table t_sys_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_role`;

CREATE TABLE `t_sys_role`
(
    `ID`             int(10)     NOT NULL AUTO_INCREMENT,
    `ROLE_CODE`      varchar(40) NOT NULL,
    `ROLE_NAME`      varchar(100) DEFAULT NULL,
    `ROLE_TYPE_CODE` varchar(20) NOT NULL,
    `ORG_CODE`       varchar(20) NOT NULL,
    `SAAS_CODE`      varchar(50)  DEFAULT NULL,
    `CREATE_BY`      varchar(50)  DEFAULT NULL,
    `CREATE_TIME`    datetime    NOT NULL,
    `UPDATE_BY`      varchar(50)  DEFAULT NULL,
    `UPDATE_TIME`    datetime     DEFAULT NULL,
    PRIMARY KEY (`ID`),
    UNIQUE KEY `code_index` (`ROLE_CODE`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;



# Dump of table t_sys_roletype
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_roletype`;

CREATE TABLE `t_sys_roletype`
(
    `ID`              int(10)      NOT NULL AUTO_INCREMENT,
    `ROLE_TYPE_CODE`  varchar(20)  NOT NULL,
    `ROLE_TYPE_NAME`  varchar(100) NOT NULL,
    `STATUS`          int(10)      DEFAULT NULL,
    `REMARK`          varchar(200) DEFAULT NULL,
    `SORT_INDEX`      int(10)      DEFAULT NULL,
    `SAAS_CODE`       varchar(50)  DEFAULT NULL,
    `CREATE_BY`       varchar(50)  DEFAULT NULL,
    `CREATE_TIME`     datetime     NOT NULL,
    `UPDATE_BY`       varchar(50)  DEFAULT NULL,
    `UPDATE_TIME`     datetime     DEFAULT NULL,
    `ROLE_TYPE_GROUP` varchar(20)  DEFAULT NULL,
    PRIMARY KEY (`ID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;



# Dump of table t_sys_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_user`;

CREATE TABLE `t_sys_user`
(
    `ID`           int(10)     NOT NULL AUTO_INCREMENT,
    `LOGIN_ID`     varchar(20) NOT NULL,
    `NAME`         varchar(20) NOT NULL,
    `PASSWORD`     varchar(32) DEFAULT NULL,
    `ALIVE_FLAG`   varchar(10) DEFAULT NULL,
    `MOBILE_PHONE` varchar(15) DEFAULT NULL,
    `ORG_CODE`     varchar(20) DEFAULT NULL,
    `IN_JOIN_TIME` varchar(20) DEFAULT NULL,
    `login_count`  int(10)     DEFAULT NULL,
    `E_MAIL`       varchar(50) DEFAULT NULL,
    `SAAS_CODE`    varchar(50) DEFAULT NULL,
    `CREATE_BY`    varchar(50) DEFAULT NULL,
    `CREATE_TIME`  datetime    NOT NULL,
    `UPDATE_BY`    varchar(50) DEFAULT NULL,
    `UPDATE_TIME`  datetime    DEFAULT NULL,
    PRIMARY KEY (`ID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;



/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;

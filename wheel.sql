/*
Navicat MySQL Data Transfer

Source Server         : atatakai.xin
Source Server Version : 50716
Source Host           : localhost:3360
Source Database       : wheel

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-05-08 20:18:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wheel_comments
-- ----------------------------
DROP TABLE IF EXISTS `wheel_comments`;
CREATE TABLE `wheel_comments` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `comment_post_ID` int(11) NOT NULL,
  `comment_author_ID` int(11) NOT NULL,
  `comment_content` varchar(255) DEFAULT NULL,
  `comment_date` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `comment_status` int(11) DEFAULT NULL,
  `comment_ip` char(20) DEFAULT NULL,
  `comment_agent` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wheel_posts
-- ----------------------------
DROP TABLE IF EXISTS `wheel_posts`;
CREATE TABLE `wheel_posts` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `post_author` int(11) NOT NULL,
  `post_title` varchar(20) DEFAULT NULL,
  `post_content` varchar(255) DEFAULT NULL,
  `post_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `post_status` int(11) DEFAULT NULL,
  `post_comNum` int(11) DEFAULT NULL,
  `post_lookNum` int(11) DEFAULT NULL,
  `post_lastdate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `post_lastuser` char(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wheel_users
-- ----------------------------
DROP TABLE IF EXISTS `wheel_users`;
CREATE TABLE `wheel_users` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` char(20) NOT NULL,
  `user_password` char(30) NOT NULL,
  `user_nickname` char(20) DEFAULT NULL,
  `user_email` varchar(30) DEFAULT NULL,
  `user_image` varchar(255) DEFAULT NULL,
  `user_registertime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `user_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

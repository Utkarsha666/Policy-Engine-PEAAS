/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50015
Source Host           : localhost:3306
Source Database       : policy_data_base

Target Server Type    : MYSQL
Target Server Version : 50015
File Encoding         : 65001

Date: 2017-06-03 14:14:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ceo_reg`
-- ----------------------------
DROP TABLE IF EXISTS `ceo_reg`;
CREATE TABLE `ceo_reg` (
  `name` varchar(255) default NULL,
  `address` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `city` varchar(255) default NULL,
  `username` varchar(255) default NULL,
  `pwd` varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of ceo_reg
-- ----------------------------
INSERT INTO `ceo_reg` VALUES ('BHARGAVA', '12345', 'bhag@gmail.com', 'qwerty', 'bhag@gmail.com', '12345');

-- ----------------------------
-- Table structure for `file_upload`
-- ----------------------------
DROP TABLE IF EXISTS `file_upload`;
CREATE TABLE `file_upload` (
  `name` varchar(255) default NULL,
  `hash_value` varchar(255) default NULL,
  `f_key` varchar(255) default NULL,
  `file` varchar(255) default NULL,
  `pubKey` varchar(255) default NULL,
  `security` varchar(255) default NULL,
  `file_cost` varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of file_upload
-- ----------------------------
INSERT INTO `file_upload` VALUES ('!@#', '12201400186446931258226313185911', 'Sj4ntZRP1qV0iJFsfQhISkdZ48f=12', 'cash.txt', null, 'Medium Security', null);
INSERT INTO `file_upload` VALUES ('text file', 'd04e83ac6844ad481a76783651d0411597eb0d093f715d75c90b26d767c', '', 'were.txt', null, 'High Security', null);
INSERT INTO `file_upload` VALUES ('456', 'd04e83ac6844ad481a76783651d0411597eb0d093f715d75c90b26d767c', '', 'were.txt', null, 'High Security', null);
INSERT INTO `file_upload` VALUES ('123', 'd04e83ac6844ad481a76783651d0411597eb0d093f715d75c90b26d767c', '', 'were.txt', null, 'High Security', null);
INSERT INTO `file_upload` VALUES ('12356', '13713745117227271708181419100230', 'QUZEQoJDpyQv+cY388UIPGuDIGJ=17', 'test file.txt', null, 'Medium Security', null);
INSERT INTO `file_upload` VALUES ('!@$%^&', '13447487160805331448131811014220', 'XQRUOfc/XnBw4jZ61rgi1FHPbaG=16', 'tesrfile.txt', null, 'Medium Security', null);
INSERT INTO `file_upload` VALUES ('test', 'Not Required.', 'Not Required.', 'anspro file.txt', null, 'Low Security', null);
INSERT INTO `file_upload` VALUES ('tset', 'Not Required.', 'Not Required.', 'anspro file.txt', null, 'Low Security', null);
INSERT INTO `file_upload` VALUES ('test', 'Not Required.', 'Not Required.', 'anspro file.txt', null, 'Low Security', null);
INSERT INTO `file_upload` VALUES ('test', 'Not Required.', 'Not Required.', 'anspro file.txt', null, 'Low Security', null);
INSERT INTO `file_upload` VALUES ('test', 'Not Required.', 'Not Required.', 'anspro file.txt', null, 'Low Security', null);
INSERT INTO `file_upload` VALUES ('FILE', 'Not Required.', 'Not Required.', 'testFile.txt', null, 'Low Security', null);
INSERT INTO `file_upload` VALUES ('FILE', 'Not Required.', 'Not Required.', 'testFile.txt', null, 'Low Security', null);
INSERT INTO `file_upload` VALUES ('ARMY', 'Not Required.', 'Not Required.', 'soldier.txt', null, 'Low Security', null);
INSERT INTO `file_upload` VALUES ('demo', '5f9270752811b35c043ae90cdf0ada6e14dd2ce931a95c7328a4d189771d4a', '', 'RSA.txt', null, 'High Security', null);
INSERT INTO `file_upload` VALUES ('demo', '56a8ce356a6359fc86863aa33ddaf44eeee213015dd53022d0c78a1790bb', '', 'RSA.txt', null, 'High Security', null);
INSERT INTO `file_upload` VALUES ('demo', '56a8ce356a6359fc86863aa33ddaf44eeee213015dd53022d0c78a1790bb', '', 'RSA.txt', null, 'High Security', null);
INSERT INTO `file_upload` VALUES ('23456', '56a8ce356a6359fc86863aa33ddaf44eeee213015dd53022d0c78a1790bb', '', 'RSA.txt', null, 'High Security', null);
INSERT INTO `file_upload` VALUES (null, null, null, null, null, null, null);
INSERT INTO `file_upload` VALUES ('12sxsd', 'RSA.txt', '12433958105735191078768211319420', 'Qaqcd5lFyYg2oVjjJJlu9yRhHi0=10', null, 'Medium Security', null);
INSERT INTO `file_upload` VALUES ('12sxsd', 'RSA.txt', '19784777166648841074643311495490', '2EB5699BFC53903CB4F161BCAD6BDFAC', null, 'Medium Security', null);
INSERT INTO `file_upload` VALUES ('//////', 'South.txt', '46f7089982e61365d22f696d68b6b3a55eb825edc83d1b162bf5afea1dff8', '2EB5699BFC53903CB4F161BCAD6BDFAC2EB5699BFC53903CB4F161BCAD6BDFAC', null, 'High Security', null);
INSERT INTO `file_upload` VALUES ('//////', 'South.txt', '46f7089982e61365d22f696d68b6b3a55eb825edc83d1b162bf5afea1dff8', '2EB5699BFC53903CB4F161BCAD6BDFAC2EB5699BFC53903CB4F161BCAD6BDFAC', null, 'High Security', null);
INSERT INTO `file_upload` VALUES ('//////', 'South.txt', '46f7089982e61365d22f696d68b6b3a55eb825edc83d1b162bf5afea1dff8', '2EB5699BFC53903CB4F161BCAD6BDFAC2EB5699BFC53903CB4F161BCAD6BDFAC', null, 'High Security', null);
INSERT INTO `file_upload` VALUES ('//////', 'South.txt', 'null', '2EB5699BFC53903CB4F161BCAD6BDFAC2EB5699BFC53903CB4F161BCAD6BDFAC', null, 'High Security', null);
INSERT INTO `file_upload` VALUES ('//////', 'South.txt', 'null', '2EB5699BFC53903CB4F161BCAD6BDFAC2EB5699BFC53903CB4F161BCAD6BDFAC', null, 'High Security', null);
INSERT INTO `file_upload` VALUES ('//////', 'South.txt', 'null', '2EB5699BFC53903CB4F161BCAD6BDFAC2EB5699BFC53903CB4F161BCAD6BDFAC', null, 'High Security', null);
INSERT INTO `file_upload` VALUES ('//////', 'South.txt', 'null', '2EB5699BFC53903CB4F161BCAD6BDFAC2EB5699BFC53903CB4F161BCAD6BDFAC', null, 'High Security', null);
INSERT INTO `file_upload` VALUES ('test file', 'anspro file.txt', 'null', '2EB5699BFC53903CB4F161BCAD6BDFAC2EB5699BFC53903CB4F161BCAD6BDFAC', null, 'High Security', null);
INSERT INTO `file_upload` VALUES ('test file', 'anspro file.txt', 'null', '2EB5699BFC53903CB4F161BCAD6BDFAC2EB5699BFC53903CB4F161BCAD6BDFAC', null, 'High Security', null);
INSERT INTO `file_upload` VALUES ('test file', 'anspro file.txt', 'null', '2EB5699BFC53903CB4F161BCAD6BDFAC2EB5699BFC53903CB4F161BCAD6BDFAC', null, 'High Security', null);
INSERT INTO `file_upload` VALUES ('details', 'Bank.txt', 'null', '6A95FA1FD389E27C4CBC11D28396DC986A95FA1FD389E27C4CBC11D28396DC98', null, 'High Security', null);
INSERT INTO `file_upload` VALUES ('123', 'Bank.txt', 'null', '612935EF5F4DF4118ED59B05B9EDB612612935EF5F4DF4118ED59B05B9EDB612', null, 'High Security', null);
INSERT INTO `file_upload` VALUES ('787897', 'anro file.txt', '13021812126101891774399017042577', '5165402E01BEA1B4436EF166F7341BA5', null, 'Medium Security', null);
INSERT INTO `file_upload` VALUES ('test file', 'Not Required', '16970865166522421554580318955567', 'ansprofile.txt', 'Not Required', 'Medium Security', null);
INSERT INTO `file_upload` VALUES ('test file', 'Not Required', '19508483167878701796891712501717', 'Halasuru.txt', 'Not Required', 'Medium Security', '9.240234375');
INSERT INTO `file_upload` VALUES ('test file', 'Not Required', '19073584116618371661308916143186', 'South.txt', 'Not Required', 'Medium Security', '16.1669921875');

-- ----------------------------
-- Table structure for `login_details`
-- ----------------------------
DROP TABLE IF EXISTS `login_details`;
CREATE TABLE `login_details` (
  `email` varchar(255) default NULL,
  `pwd` varchar(255) default NULL,
  `utype` varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of login_details
-- ----------------------------
INSERT INTO `login_details` VALUES ('ravi', '123', 'CEO');
INSERT INTO `login_details` VALUES ('Manager', 'Manager', 'Manager');
INSERT INTO `login_details` VALUES ('COMPANY', 'COMPANY', 'Owner');
INSERT INTO `login_details` VALUES ('USER', 'USER', 'user');

-- ----------------------------
-- Table structure for `manager_reg`
-- ----------------------------
DROP TABLE IF EXISTS `manager_reg`;
CREATE TABLE `manager_reg` (
  `name` varchar(255) default NULL,
  `companyName` varchar(255) default NULL,
  `departmentName` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `city` varchar(255) default NULL,
  `user_name` varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of manager_reg
-- ----------------------------
INSERT INTO `manager_reg` VALUES ('ravi', 'ravi@gmail.com', '124567890', '123', null, null);
INSERT INTO `manager_reg` VALUES ('rajveer', 'raj@gmail.com', '1234567890', '123', null, null);
INSERT INTO `manager_reg` VALUES ('rajveer', 'dvbxcvb', 'xcvxcvbvb@gmail.com', 'asdfsaf', 'asdf', '123');
INSERT INTO `manager_reg` VALUES ('agsdg', 'null', 'dfgsfdg@hjgh', 'dfsg', 'sdf', '123');
INSERT INTO `manager_reg` VALUES ('qwert', 'qazws', 'qsewad', 'hgfd@asdv', 'ccasdsad', 'sdad');
INSERT INTO `manager_reg` VALUES ('qwerty', 'qewrty', 'weqrty', 'werwerty@werty', 'fwdfw', 'gjddwd');
INSERT INTO `manager_reg` VALUES ('qwert', 'qwerty', 'bhytg', 'zxcv@gmail.com', 'dddh', 'asdf');

-- ----------------------------
-- Table structure for `payment_mode`
-- ----------------------------
DROP TABLE IF EXISTS `payment_mode`;
CREATE TABLE `payment_mode` (
  `holderName` varchar(255) default NULL,
  `cardNo` varchar(255) default NULL,
  `month` varchar(255) default NULL,
  `year` varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of payment_mode
-- ----------------------------
INSERT INTO `payment_mode` VALUES ('RAVI SINGH', '1234567890', 'null', 'mercedes');

-- ----------------------------
-- Table structure for `reg`
-- ----------------------------
DROP TABLE IF EXISTS `reg`;
CREATE TABLE `reg` (
  `name` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `cno` varchar(255) default NULL,
  `pwd` varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of reg
-- ----------------------------
INSERT INTO `reg` VALUES ('asd', '122e', 'zx', 'ada');

-- ----------------------------
-- Table structure for `registration`
-- ----------------------------
DROP TABLE IF EXISTS `registration`;
CREATE TABLE `registration` (
  `name` varchar(255) default NULL,
  `address` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `city` varchar(255) default NULL,
  `username` varchar(255) default NULL,
  `pwd` varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of registration
-- ----------------------------
INSERT INTO `registration` VALUES ('ravi', 'ravi@gmail.com', '124567890', '123', null, null);
INSERT INTO `registration` VALUES ('rajveer', 'raj@gmail.com', '1234567890', '123', null, null);
INSERT INTO `registration` VALUES ('bhargava', '1234gfgg', 'bhagu@gmail.com', 'dsfdsfss', 'bhargava', '123456');
INSERT INTO `registration` VALUES ('bhag', 'dqwe', 'qwdf@gmail.com', '1234', 'qwerty', '123654');

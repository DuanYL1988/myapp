/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : duanyl

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2019-12-06 00:59:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `favorite_image`
-- ----------------------------
DROP TABLE IF EXISTS `favorite_image`;
CREATE TABLE `favorite_image` (
  `ID` int(8) NOT NULL AUTO_INCREMENT,
  `image_path` varchar(100) NOT NULL,
  `user` int(8) DEFAULT NULL,
  `rank` int(1) DEFAULT NULL,
  `display_flg` int(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=470 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of favorite_image
-- ----------------------------
INSERT INTO `favorite_image` VALUES ('347', 'resources/images/feh/acter/Lin_F_Normal/break.png', null, '0', null, '2019-06-06 23:04:09');
INSERT INTO `favorite_image` VALUES ('348', 'resources/images/feh/acter/Lin_F_ELECTION01/break.png', null, '0', null, '2019-06-06 23:04:56');
INSERT INTO `favorite_image` VALUES ('349', 'resources/images/feh/acter/Lin_F_ELECTION01/normal.png', null, '0', null, '2019-06-06 23:04:59');
INSERT INTO `favorite_image` VALUES ('350', 'resources/images/feh/acter/Lin_F_ELECTION01/attact.png', null, '0', null, '2019-06-06 23:06:01');
INSERT INTO `favorite_image` VALUES ('351', 'resources/images/feh/acter/Lin_F_Lengend/break.png', null, '0', null, '2019-06-06 23:06:19');
INSERT INTO `favorite_image` VALUES ('352', 'resources/images/feh/acter/Lin_F_Lengend/attact.png', null, '0', null, '2019-06-06 23:06:36');
INSERT INTO `favorite_image` VALUES ('353', 'resources/images/feh/acter/Lin_F_Wedding17/normal.png', null, '0', null, '2019-06-06 23:07:00');
INSERT INTO `favorite_image` VALUES ('354', 'resources/images/feh/acter/Lin_F_Wedding17/attact.png', null, '0', null, '2019-06-06 23:07:00');
INSERT INTO `favorite_image` VALUES ('355', 'resources/images/feh/acter/Lin_F_Wedding17/extra.png', null, '0', null, '2019-06-06 23:07:00');
INSERT INTO `favorite_image` VALUES ('356', 'resources/images/feh/acter/Lin_F_Wedding17/break.png', null, '0', null, '2019-06-06 23:07:00');
INSERT INTO `favorite_image` VALUES ('357', 'resources/images/feh/acter/Lin_F_ELECTION01/face.png', null, '0', null, '2019-06-06 23:07:00');
INSERT INTO `favorite_image` VALUES ('358', 'resources/images/feh/acter/Lin_F_Normal/face.png', null, '0', null, '2019-06-06 23:07:00');
INSERT INTO `favorite_image` VALUES ('359', 'resources/images/feh/acter/Lin_F_Lengend/face.png', null, '0', null, '2019-06-06 23:07:00');
INSERT INTO `favorite_image` VALUES ('360', 'resources/images/feh/acter/Lin_F_Valentine18/face.png', null, '0', null, '2019-06-06 23:07:00');
INSERT INTO `favorite_image` VALUES ('361', 'resources/images/feh/acter/Lin_F_Valentine18/normal.png', null, '0', null, '2019-06-06 23:07:31');
INSERT INTO `favorite_image` VALUES ('362', 'resources/images/feh/acter/Lin_F_Valentine18/break.png', null, '0', null, '2019-06-06 23:07:35');
INSERT INTO `favorite_image` VALUES ('363', 'resources/images/feh/acter/Camilla_F_Dream/normal.png', null, '0', null, '2019-06-06 23:08:22');
INSERT INTO `favorite_image` VALUES ('364', 'resources/images/feh/acter/Camilla_F_Dream/attact.png', null, '0', null, '2019-06-06 23:08:22');
INSERT INTO `favorite_image` VALUES ('365', 'resources/images/feh/acter/Camilla_F_Dream/extra.png', null, '0', null, '2019-06-06 23:08:22');
INSERT INTO `favorite_image` VALUES ('366', 'resources/images/feh/acter/Camilla_F_Dream/break.png', null, '0', null, '2019-06-06 23:08:22');
INSERT INTO `favorite_image` VALUES ('367', 'resources/images/feh/acter/Camilla_F_Normal/face.png', null, '0', null, '2019-06-06 23:08:22');
INSERT INTO `favorite_image` VALUES ('368', 'resources/images/feh/acter/Camilla_F_NewYear18/face.png', null, '0', null, '2019-06-06 23:08:22');
INSERT INTO `favorite_image` VALUES ('369', 'resources/images/feh/acter/Camilla_F_Misuki/face.png', null, '0', null, '2019-06-06 23:08:22');
INSERT INTO `favorite_image` VALUES ('370', 'resources/images/feh/acter/Camilla_F_SpringFes17/face.png', null, '0', null, '2019-06-06 23:08:22');
INSERT INTO `favorite_image` VALUES ('371', 'resources//images/feh/acter/Camilla_F_Furo/face.png', null, '0', null, '2019-06-06 23:08:22');
INSERT INTO `favorite_image` VALUES ('372', 'resources/images/feh/acter/Camilla_F_NewYear18/break.png', null, '0', null, '2019-06-06 23:08:34');
INSERT INTO `favorite_image` VALUES ('373', 'resources/images/feh/acter/Camilla_F_Misuki/normal.png', null, '0', null, '2019-06-06 23:08:49');
INSERT INTO `favorite_image` VALUES ('374', 'resources/images/feh/acter/Camilla_F_Misuki/attact.png', null, '0', null, '2019-06-06 23:08:49');
INSERT INTO `favorite_image` VALUES ('375', 'resources/images/feh/acter/Camilla_F_Misuki/extra.png', null, '0', null, '2019-06-06 23:08:49');
INSERT INTO `favorite_image` VALUES ('376', 'resources/images/feh/acter/Camilla_F_Misuki/break.png', null, '0', null, '2019-06-06 23:08:49');
INSERT INTO `favorite_image` VALUES ('377', 'resources/images/feh/acter/Camilla_F_Dream/face.png', null, '0', null, '2019-06-06 23:08:49');
INSERT INTO `favorite_image` VALUES ('378', 'resources/images/feh/acter/Camilla_F_SpringFes17/attact.png', null, '0', null, '2019-06-06 23:09:13');
INSERT INTO `favorite_image` VALUES ('379', 'resources/images/feh/acter/Ayra_F_Normal/normal.png', null, '0', null, '2019-06-06 23:10:25');
INSERT INTO `favorite_image` VALUES ('380', 'resources/images/feh/acter/Ayra_F_Normal/attact.png', null, '0', null, '2019-06-06 23:10:25');
INSERT INTO `favorite_image` VALUES ('381', 'resources/images/feh/acter/Ayra_F_Normal/extra.png', null, '0', null, '2019-06-06 23:10:25');
INSERT INTO `favorite_image` VALUES ('382', 'resources/images/feh/acter/Ayra_F_Normal/break.png', null, '0', null, '2019-06-06 23:10:25');
INSERT INTO `favorite_image` VALUES ('383', 'resources/images/feh/acter/Lean_F_Normal/break.png', null, '0', null, '2019-06-06 23:10:47');
INSERT INTO `favorite_image` VALUES ('384', 'resources/images/feh/acter/Lean_F_Normal/normal.png', null, '0', null, '2019-06-06 23:10:52');
INSERT INTO `favorite_image` VALUES ('385', 'resources/images/feh/acter/Olivie_F_Normal/normal.png', null, '0', null, '2019-06-06 23:12:08');
INSERT INTO `favorite_image` VALUES ('386', 'resources//images/feh/acter/Eirik_F_Memories/attact.png', null, '0', null, '2019-06-06 23:13:06');
INSERT INTO `favorite_image` VALUES ('387', 'resources//images/feh/acter/Eirik_F_Legend/normal.png', null, '0', null, '2019-06-06 23:13:57');
INSERT INTO `favorite_image` VALUES ('388', 'resources//images/feh/acter/Eirik_F_Legend/attact.png', null, '0', null, '2019-06-06 23:14:01');
INSERT INTO `favorite_image` VALUES ('389', 'resources//images/feh/acter/Eirik_F_Xmas/normal.png', null, '0', null, '2019-06-06 23:14:27');
INSERT INTO `favorite_image` VALUES ('390', 'resources//images/feh/acter/Sigrun_Steadfast%20Bride/normal.png', null, '0', null, '2019-06-06 23:14:56');
INSERT INTO `favorite_image` VALUES ('391', 'resources//images/feh/acter/Sallya_F_Obsessive/normal.png', null, '0', null, '2019-06-06 23:15:37');
INSERT INTO `favorite_image` VALUES ('392', 'resources//images/feh/acter/Sallya_F_Obsessive/attact.png', null, '0', null, '2019-06-06 23:15:37');
INSERT INTO `favorite_image` VALUES ('393', 'resources//images/feh/acter/Sallya_F_Obsessive/extra.png', null, '0', null, '2019-06-06 23:15:37');
INSERT INTO `favorite_image` VALUES ('394', 'resources//images/feh/acter/Sallya_F_Obsessive/break.png', null, '0', null, '2019-06-06 23:15:37');
INSERT INTO `favorite_image` VALUES ('395', 'resources//images/feh/acter/Sallya_F_Normal/face.png', null, '0', null, '2019-06-06 23:15:37');
INSERT INTO `favorite_image` VALUES ('396', 'resources//images/feh/acter/Sallya_F_WinterFes17/face.png', null, '0', null, '2019-06-06 23:15:37');
INSERT INTO `favorite_image` VALUES ('397', 'resources//images/feh/acter/Sallya_F_WinterFes17/normal.png', null, '0', null, '2019-06-06 23:15:52');
INSERT INTO `favorite_image` VALUES ('398', 'resources//images/feh/acter/Sallya_F_WinterFes17/attact.png', null, '0', null, '2019-06-06 23:16:08');
INSERT INTO `favorite_image` VALUES ('399', 'resources//images/feh/acter/Turner_F_NobleandNimble/normal.png', null, '0', null, '2019-06-06 23:16:51');
INSERT INTO `favorite_image` VALUES ('400', 'resources//images/feh/acter/Turner_F_NobleandNimble/break.png', null, '0', null, '2019-06-06 23:16:56');
INSERT INTO `favorite_image` VALUES ('401', 'resources//images/feh/acter/Aversa_F_Normal/normal.png', null, '0', null, '2019-06-06 23:17:02');
INSERT INTO `favorite_image` VALUES ('402', 'resources/images/feh/acter/Tiki_F_Beachside/normal.png', null, '0', null, '2019-06-06 23:17:37');
INSERT INTO `favorite_image` VALUES ('403', 'resources/images/feh/acter/Tiki_F_Legendary/attact.png', null, '0', null, '2019-06-06 23:17:48');
INSERT INTO `favorite_image` VALUES ('404', 'resources//images/feh/acter/Idunn_F_DarkPriestess/attact.png', null, '0', null, '2019-06-06 23:18:11');
INSERT INTO `favorite_image` VALUES ('405', 'resources//images/feh/acter/Idunn_F_DarkPriestess/break.png', null, '0', null, '2019-06-06 23:18:15');
INSERT INTO `favorite_image` VALUES ('406', 'resources//images/feh/acter/Mel_F_Halloween/attact.png', null, '0', null, '2019-06-06 23:18:34');
INSERT INTO `favorite_image` VALUES ('407', 'resources/images/feh/acter/Aqua_F_Normal/break.png', null, '0', null, '2019-06-06 23:18:53');
INSERT INTO `favorite_image` VALUES ('408', 'resources/images/feh/acter/Aqua_F_BlackNormal/break.png', null, '0', null, '2019-06-06 23:19:04');
INSERT INTO `favorite_image` VALUES ('409', 'resources/images/feh/acter/Aqua_F_NewYear18/normal.png', null, '0', null, '2019-06-06 23:19:19');
INSERT INTO `favorite_image` VALUES ('410', 'resources/images/feh/acter/Aqua_F_NewYear18/attact.png', null, '0', null, '2019-06-06 23:19:23');
INSERT INTO `favorite_image` VALUES ('411', 'resources/images/feh/acter/Aqua_F_Legend/normal.png', null, '0', null, '2019-06-06 23:19:34');
INSERT INTO `favorite_image` VALUES ('412', 'resources/images/feh/acter/Aqua_F_Legend/attact.png', null, '0', null, '2019-06-06 23:19:39');
INSERT INTO `favorite_image` VALUES ('413', 'resources//images/feh/acter/Lucina_F_ELECTION01/attact.png', null, '0', null, '2019-06-06 23:20:01');
INSERT INTO `favorite_image` VALUES ('414', 'resources//images/feh/acter/Lucina_F_GloriousArcher/normal.png', null, '0', null, '2019-06-06 23:20:11');
INSERT INTO `favorite_image` VALUES ('415', 'resources//images/feh/acter/Lucina_F_GloriousArcher/attact.png', null, '0', null, '2019-06-06 23:20:11');
INSERT INTO `favorite_image` VALUES ('416', 'resources//images/feh/acter/Lucina_F_GloriousArcher/extra.png', null, '0', null, '2019-06-06 23:20:11');
INSERT INTO `favorite_image` VALUES ('417', 'resources//images/feh/acter/Lucina_F_GloriousArcher/break.png', null, '0', null, '2019-06-06 23:20:11');
INSERT INTO `favorite_image` VALUES ('418', 'resources//images/feh/acter/Lucina_F_ELECTION01/face.png', null, '0', null, '2019-06-06 23:20:11');
INSERT INTO `favorite_image` VALUES ('419', 'resources//images/feh/acter/Hinoka_F_Normal/normal.png', null, '0', null, '2019-06-06 23:21:44');
INSERT INTO `favorite_image` VALUES ('420', 'resources//images/feh/acter/Hinoka_F_Normal/attact.png', null, '0', null, '2019-06-06 23:21:46');
INSERT INTO `favorite_image` VALUES ('421', 'resources//images/feh/acter/Katua_F_Normal/normal.png', null, '0', null, '2019-06-06 23:22:24');
INSERT INTO `favorite_image` VALUES ('422', 'resources//images/feh/acter/Ishtar_F_ThunderGoddess/normal.png', null, '0', null, '2019-06-06 23:23:36');
INSERT INTO `favorite_image` VALUES ('423', 'resources//images/feh/acter/Ishtar_F_ThunderGoddess/attact.png', null, '0', null, '2019-06-06 23:23:36');
INSERT INTO `favorite_image` VALUES ('424', 'resources//images/feh/acter/Ishtar_F_ThunderGoddess/extra.png', null, '0', null, '2019-06-06 23:23:36');
INSERT INTO `favorite_image` VALUES ('425', 'resources//images/feh/acter/Ishtar_F_ThunderGoddess/break.png', null, '0', null, '2019-06-06 23:23:36');
INSERT INTO `favorite_image` VALUES ('426', 'resources//images/feh/acter/Morgan_F_LassfromAfar/normal.png', null, '0', null, '2019-06-06 23:24:16');
INSERT INTO `favorite_image` VALUES ('427', 'resources//images/feh/acter/Kamui_F_Swim17/normal.png', null, '0', null, '2019-06-06 23:24:26');
INSERT INTO `favorite_image` VALUES ('428', 'resources//images/feh/acter/Kamui_F_Swim17/attact.png', null, '0', null, '2019-06-06 23:24:26');
INSERT INTO `favorite_image` VALUES ('429', 'resources//images/feh/acter/Kamui_F_Swim17/extra.png', null, '0', null, '2019-06-06 23:24:26');
INSERT INTO `favorite_image` VALUES ('430', 'resources//images/feh/acter/Kamui_F_Swim17/break.png', null, '0', null, '2019-06-06 23:24:26');
INSERT INTO `favorite_image` VALUES ('431', 'resources//images/feh/acter/Kamui_F_Wailing%20Soul/face.png', null, '0', null, '2019-06-06 23:24:26');
INSERT INTO `favorite_image` VALUES ('432', 'resources//images/feh/acter/Kamui_F_Dream/face.png', null, '0', null, '2019-06-06 23:24:26');
INSERT INTO `favorite_image` VALUES ('433', 'resources//images/feh/acter/Kamui_F_Wailing%20Soul/normal.png', null, '0', null, '2019-06-06 23:24:48');
INSERT INTO `favorite_image` VALUES ('434', 'resources//images/feh/acter/Kamui_F_Wailing%20Soul/attact.png', null, '0', null, '2019-06-06 23:24:48');
INSERT INTO `favorite_image` VALUES ('435', 'resources//images/feh/acter/Kamui_F_Wailing%20Soul/extra.png', null, '0', null, '2019-06-06 23:24:48');
INSERT INTO `favorite_image` VALUES ('436', 'resources//images/feh/acter/Kamui_F_Wailing%20Soul/break.png', null, '0', null, '2019-06-06 23:24:48');
INSERT INTO `favorite_image` VALUES ('437', 'resources//images/feh/acter/Kamui_F_Swim17/face.png', null, '0', null, '2019-06-06 23:24:48');
INSERT INTO `favorite_image` VALUES ('438', 'resources//images/feh/acter/Kamui_F_Dream/normal.png', null, '0', null, '2019-06-06 23:24:55');
INSERT INTO `favorite_image` VALUES ('439', 'resources//images/feh/acter/Kamui_F_Dream/attact.png', null, '0', null, '2019-06-06 23:24:55');
INSERT INTO `favorite_image` VALUES ('440', 'resources//images/feh/acter/Kamui_F_Dream/extra.png', null, '0', null, '2019-06-06 23:24:55');
INSERT INTO `favorite_image` VALUES ('441', 'resources//images/feh/acter/Kamui_F_Dream/break.png', null, '0', null, '2019-06-06 23:24:55');
INSERT INTO `favorite_image` VALUES ('442', 'resources//images/feh/acter/Naga_Dragon%20Divinity/normal.png', null, '0', null, '2019-06-06 23:25:10');
INSERT INTO `favorite_image` VALUES ('443', 'resources//images/feh/acter/Naga_Dragon%20Divinity/break.png', null, '0', null, '2019-06-06 23:25:14');
INSERT INTO `favorite_image` VALUES ('444', 'resources//images/feh/acter/Kagerou_F_SpringFes18/break.png', null, '0', null, '2019-06-06 23:26:28');
INSERT INTO `favorite_image` VALUES ('445', 'resources//images/feh/acter/Erincia_F_EstivalPrincess/attact.png', null, '0', null, '2019-06-06 23:26:53');
INSERT INTO `favorite_image` VALUES ('446', 'resources//images/feh/acter/Nino_F_PaleFlower/normal.png', null, '0', null, '2019-06-06 23:27:21');
INSERT INTO `favorite_image` VALUES ('447', 'resources//images/feh/acter/Lilina_F_Valentine18/attact.png', null, '0', null, '2019-06-06 23:27:43');
INSERT INTO `favorite_image` VALUES ('448', 'resources//images/feh/acter/Secilia_F_Xmas/break.png', null, '0', null, '2019-06-06 23:28:12');
INSERT INTO `favorite_image` VALUES ('449', 'resources//images/feh/acter/Yune_F_haosGoddess/normal.png', null, '0', null, '2019-06-06 23:28:50');
INSERT INTO `favorite_image` VALUES ('450', 'resources//images/feh/acter/Loki_F_pringTrickster/normal.png', null, '0', null, '2019-06-06 23:29:35');
INSERT INTO `favorite_image` VALUES ('451', 'resources//images/feh/acter/Louise_Eternal%20Devotion/normal.png', null, '0', null, '2019-06-06 23:29:46');
INSERT INTO `favorite_image` VALUES ('452', 'resources//images/feh/acter/Louise_Eternal%20Devotion/attact.png', null, '0', null, '2019-06-06 23:29:46');
INSERT INTO `favorite_image` VALUES ('453', 'resources//images/feh/acter/Louise_Eternal%20Devotion/extra.png', null, '0', null, '2019-06-06 23:29:46');
INSERT INTO `favorite_image` VALUES ('454', 'resources//images/feh/acter/Louise_Eternal%20Devotion/break.png', null, '0', null, '2019-06-06 23:29:46');
INSERT INTO `favorite_image` VALUES ('455', 'resources/images/feh/acter/Linde_F_SummerRays/normal.png', null, '0', null, '2019-06-06 23:29:58');
INSERT INTO `favorite_image` VALUES ('456', 'resources/images/feh/acter/Linde_F_SummerRays/attact.png', null, '0', null, '2019-06-06 23:29:58');
INSERT INTO `favorite_image` VALUES ('457', 'resources/images/feh/acter/Linde_F_SummerRays/extra.png', null, '0', null, '2019-06-06 23:29:58');
INSERT INTO `favorite_image` VALUES ('458', 'resources/images/feh/acter/Linde_F_SummerRays/break.png', null, '0', null, '2019-06-06 23:29:58');
INSERT INTO `favorite_image` VALUES ('459', 'resources/images/feh/acter/Air_F_Normal/normal.png', null, '0', null, '2019-06-06 23:30:35');
INSERT INTO `favorite_image` VALUES ('460', 'resources/images/feh/acter/Air_F_Normal/attact.png', null, '0', null, '2019-06-06 23:30:35');
INSERT INTO `favorite_image` VALUES ('461', 'resources/images/feh/acter/Air_F_Normal/extra.png', null, '0', null, '2019-06-06 23:30:35');
INSERT INTO `favorite_image` VALUES ('462', 'resources/images/feh/acter/Air_F_Normal/break.png', null, '0', null, '2019-06-06 23:30:35');
INSERT INTO `favorite_image` VALUES ('463', 'resources//images/feh/acter/Mitsukoto_F_Normal/normal.png', null, '0', null, '2019-06-06 23:31:13');
INSERT INTO `favorite_image` VALUES ('464', 'resources//images/feh/acter/Mitsukoto_F_Normal/attact.png', null, '0', null, '2019-06-06 23:31:13');
INSERT INTO `favorite_image` VALUES ('465', 'resources//images/feh/acter/Mitsukoto_F_Normal/extra.png', null, '0', null, '2019-06-06 23:31:13');
INSERT INTO `favorite_image` VALUES ('466', 'resources//images/feh/acter/Mitsukoto_F_Normal/break.png', null, '0', null, '2019-06-06 23:31:13');
INSERT INTO `favorite_image` VALUES ('467', 'resources//images/feh/acter/Asilin_F_Normal/normal.png', null, '0', null, '2019-06-06 23:31:30');
INSERT INTO `favorite_image` VALUES ('468', 'resources//images/feh/acter/Leanne_F_ForestSong/normal.png', null, '0', null, '2019-06-06 23:31:40');
INSERT INTO `favorite_image` VALUES ('469', 'resources//images/feh/acter/Lin_F_LadyOfTheBeach/normal.png', null, '0', null, '2019-07-14 10:26:16');

-- ----------------------------
-- Table structure for `feh_character`
-- ----------------------------
DROP TABLE IF EXISTS `feh_character`;
CREATE TABLE `feh_character` (
  `CHARACTER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CHARACTER_TITLENAME` varchar(10) NOT NULL,
  `CHARACTER_ORIGIN` varchar(20) DEFAULT NULL,
  `CHARACTER_BASENAME` varchar(10) DEFAULT NULL,
  `CHARACTER_NAME` varchar(10) NOT NULL,
  `CHARACTER_MASTER_ID` int(11) DEFAULT NULL,
  `CHARACTER_POOL` varchar(10) DEFAULT NULL,
  `CHARACTER_FACE_IMG` varchar(150) DEFAULT NULL,
  `CHARACTER_Q_IMG` varchar(150) DEFAULT NULL,
  `CHARACTER_STAND_IMG` varchar(150) DEFAULT NULL,
  `CHARACTER_ATT_IMG` varchar(150) DEFAULT NULL,
  `CHARACTER_EXTRA_IMG` varchar(150) DEFAULT NULL,
  `CHARACTER_DEF_IMG` varchar(150) DEFAULT NULL,
  `CHARACTER_HP` int(11) DEFAULT NULL,
  `CHARACTER_ATT` int(11) DEFAULT NULL,
  `CHARACTER_SPD` int(11) DEFAULT NULL,
  `CHARACTER_DEF` int(11) DEFAULT NULL,
  `CHARACTER_MDF` int(11) DEFAULT NULL,
  `CHARACTER_BASE_HP` int(11) DEFAULT NULL,
  `CHARACTER_BASE_ATT` int(11) DEFAULT NULL,
  `CHARACTER_BASE_SPD` int(11) DEFAULT NULL,
  `CHARACTER_BASE_DEF` int(11) DEFAULT NULL,
  `CHARACTER_BASE_MDF` int(11) DEFAULT NULL,
  `CHARACTER_WEAPON` varchar(10) DEFAULT NULL,
  `CHARACTER_SKILL_A` varchar(10) DEFAULT NULL,
  `CHARACTER_SKILL_B` varchar(10) DEFAULT NULL,
  `CHARACTER_SKILL_C` varchar(10) DEFAULT NULL,
  `CHARACTER_SKILL_D` varchar(10) DEFAULT NULL,
  `CHARACTER_SKILL_S` varchar(10) DEFAULT NULL,
  `CHARACTER_SKILL_E` varchar(10) DEFAULT NULL,
  `CHARACTER_MOVE_TYPE` varchar(2) DEFAULT NULL,
  `CHARACTER_WEAPON_TYPE` varchar(2) DEFAULT NULL,
  `CHARACTER_RACE` varchar(2) DEFAULT NULL,
  `CHARACTER_BLESSING` varchar(2) DEFAULT NULL,
  `CHARACTER_LEVEL_PLUS` int(11) DEFAULT NULL,
  `CHARACTER_COLOR` int(11) DEFAULT NULL,
  PRIMARY KEY (`CHARACTER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feh_character
-- ----------------------------
INSERT INTO `feh_character` VALUES ('2', '伟大的女爵', '烈火之剑', '琳迪斯', '总选举琳', null, null, '../../../resources/images/feh/acter/Lin_F_ELECTION01/face.png', '../../../resources/images/feh/acter/Lin_F_ELECTION01/q.png', '../../../resources/images/feh/acter/Lin_F_ELECTION01/normal.png', '../../../resources/images/feh/acter/Lin_F_ELECTION01/attact.png', '../../../resources/images/feh/acter/Lin_F_ELECTION01/extra.png', '../../../resources/images/feh/acter/Lin_F_ELECTION01/break.png', '42', '54', '42', '20', '31', '35', '47', '38', '28', '18', '妙尔葛雷', '鬼神飞燕击2', '塞迦的加护', '攻击紫烟3', null, '带回', '龙裂', '2', '14', null, '1', '2', '2');
INSERT INTO `feh_character` VALUES ('3', '草原的女爵', '烈火之剑', '琳迪斯', '普通琳', null, null, '../../../resources/images/feh/acter/Lin_F_Normal/face.png', '../../../resources/images/feh/acter/Lin_F_Normal/q.png', '../../../resources/images/feh/acter/Lin_F_Normal/normal.png', '../../../resources/images/feh/acter/Lin_F_Normal/attact.png', '../../../resources/images/feh/acter/Lin_F_Normal/extra.png', '../../../resources/images/feh/acter/Lin_F_Normal/break.png', '46', '51', '42', '18', '24', '37', '28', '37', '26', '29', '索尔 卡提', '死线3', '埋伏3', '防守威吓2', null, '替换', '疾风迅雷', '1', '1', null, '1', null, '1');
INSERT INTO `feh_character` VALUES ('5', '风之女爵', '烈火之剑', '琳迪斯', '传承琳', null, null, '../../../resources/images/feh/acter/Lin_F_Lengend/face.png', '../../../resources/images/feh/acter/Lin_F_Lengend/q.png', '../../../resources/images/feh/acter/Lin_F_Lengend/normal.png', '../../../resources/images/feh/acter/Lin_F_Lengend/attact.png', '../../../resources/images/feh/acter/Lin_F_Lengend/extra.png', '../../../resources/images/feh/acter/Lin_F_Lengend/break.png', '40', '45', '37', '21', '26', '36', '31', '36', '21', '27', '疾弓妙尔葛雷', '塞迦的规矩', '猛攻3', '速度指挥3', null, '防守支援', '太阳', '1', '13', null, '3', null, '3');
INSERT INTO `feh_character` VALUES ('6', '草原的新娘', '烈火之剑', '琳迪斯', '花嫁琳', null, null, '../../../resources/images/feh/acter/Lin_F_Wedding17/face.png', '../../../resources/images/feh/acter/Lin_F_Wedding17/q.png', '../../../resources/images/feh/acter/Lin_F_Wedding17/normal.png', '../../../resources/images/feh/acter/Lin_F_Wedding17/attact.png', '../../../resources/images/feh/acter/Lin_F_Wedding17/extra.png', '../../../resources/images/feh/acter/Lin_F_Wedding17/break.png', '46', '42', '31', '23', '24', '39', '28', '34', '23', '24', '烛光+', '攻击3', '幻惑之杖3', '魔防大纹章2', null, '重生+', '天照', '1', '19', null, '3', null, '4');
INSERT INTO `feh_character` VALUES ('7', '飘荡风中的思绪', '烈火之剑', '琳迪斯', '情人节琳', null, null, '../../../resources/images/feh/acter/Lin_F_Valentine18/face.png', '../../../resources/images/feh/acter/Lin_F_Valentine18/q.png', '../../../resources/images/feh/acter/Lin_F_Valentine18/normal.png', '../../../resources/images/feh/acter/Lin_F_Valentine18/attact.png', '../../../resources/images/feh/acter/Lin_F_Valentine18/extra.png', '../../../resources/images/feh/acter/Lin_F_Valentine18/break.png', '37', '44', '39', '27', '31', '37', '31', '36', '27', '34', '苍蓝之刃+', '攻击速度羁绊3', '猛攻3', '重装备行军3', null, '拉近', '新月', '4', '5', null, '3', null, '2');
INSERT INTO `feh_character` VALUES ('8', '妖艳之花', 'IF', '卡米拉', '普通卡米拉', null, null, '../../../resources/images/feh/acter/Camilla_F_Normal/face.png', '../../../resources/images/feh/acter/Camilla_F_Normal/q.png', '../../../resources/images/feh/acter/Camilla_F_Normal/normal.png', '../../../resources/images/feh/acter/Camilla_F_Normal/attact.png', '../../../resources/images/feh/acter/Camilla_F_Normal/extra.png', '../../../resources/images/feh/acter/Camilla_F_Normal/break.png', '41', '38', '27', '24', '31', '37', '30', '32', '28', '31', '勇者之斧', '飞燕一击', '', '死亡气息3', null, '', '龙裂', '3', '3', null, '1', null, '3');
INSERT INTO `feh_character` VALUES ('9', '国际交流中', 'IF', '卡米拉', '正月卡米拉', null, null, '../../../resources/images/feh/acter/Camilla_F_NewYear18/face.png', '../../../resources/images/feh/acter/Camilla_F_NewYear18/q.png', '../../../resources/images/feh/acter/Camilla_F_NewYear18/normal.png', '../../../resources/images/feh/acter/Camilla_F_NewYear18/attact.png', '../../../resources/images/feh/acter/Camilla_F_NewYear18/extra.png', '../../../resources/images/feh/acter/Camilla_F_NewYear18/break.png', '45', '47', '32', '35', '27', '40', '33', '35', '31', '23', '门松+', '速度防守羁绊3', '', '飞盾纹章', null, '', '龙裂', '3', '1', null, '4', null, '1');
INSERT INTO `feh_character` VALUES ('10', '梦幻之花', 'IF', '卡米拉', '卡米拉（红魔）', null, null, '../../../resources/images/feh/acter/Camilla_F_Dream/face.png', '../../../resources/images/feh/acter/Camilla_F_Dream/q.png', '../../../resources/images/feh/acter/Camilla_F_Dream/normal.png', '../../../resources/images/feh/acter/Camilla_F_Dream/attact.png', '../../../resources/images/feh/acter/Camilla_F_Dream/extra.png', '../../../resources/images/feh/acter/Camilla_F_Dream/break.png', '36', '51', '30', '20', '30', '36', '37', '30', '17', '30', '梦幻之书', '攻击魔防羁绊3', '猛攻3', '飞刃纹章', null, '拉近', '月光', '3', '4', null, '3', null, '1');
INSERT INTO `feh_character` VALUES ('11', '甘甜芬芳之花', 'IF', '卡米拉', '泳衣卡米拉', null, null, '../../../resources/images/feh/acter/Camilla_F_Misuki/face.png', '../../../resources/images/feh/acter/Camilla_F_Misuki/q.png', '../../../resources/images/feh/acter/Camilla_F_Misuki/normal.png', '../../../resources/images/feh/acter/Camilla_F_Misuki/attact.png', '../../../resources/images/feh/acter/Camilla_F_Misuki/extra.png', '../../../resources/images/feh/acter/Camilla_F_Misuki/break.png', '43', '46', '42', '24', '20', '39', '33', '36', '23', '19', '南国果汁+', '鬼神一击3', '编队飞行3', '飞刃鼓舞', null, '拉近', '龙裂', '3', '5', null, '3', '3', '2');
INSERT INTO `feh_character` VALUES ('12', '春色暗夜公主', 'IF', '卡米拉', '兔米拉', null, null, '../../../resources/images/feh/acter/Camilla_F_SpringFes17/face.png', '../../../resources/images/feh/acter/Camilla_F_SpringFes17/q.png', '../../../resources/images/feh/acter/Camilla_F_SpringFes17/normal.png', '../../../resources/images/feh/acter/Camilla_F_SpringFes17/attact.png', '../../../resources/images/feh/acter/Camilla_F_SpringFes17/extra.png', '../../../resources/images/feh/acter/Camilla_F_SpringFes17/break.png', '41', '48', '25', '26', '22', '39', '35', '25', '30', '19', '绿之卵+', '鬼神一击3', '破枪者3', '飞盾纹章', null, '拉近', '月光', '3', '6', null, '4', '3', '3');
INSERT INTO `feh_character` VALUES ('14', '泉之歌姬', '觉醒', '阿库亚', '阿库亚(白夜)', null, null, '../../../resources/images/feh/acter/Aqua_F_Normal/face.png', '../../../resources/images/feh/acter/Aqua_F_Normal/q.png', '../../../resources/images/feh/acter/Aqua_F_Normal/normal.png', '../../../resources/images/feh/acter/Aqua_F_Normal/attact.png', '../../../resources/images/feh/acter/Aqua_F_Normal/extra.png', '../../../resources/images/feh/acter/Aqua_F_Normal/break.png', '41', '44', '34', '21', '29', '36', '31', '33', '21', '28', '苍海之枪+', '强化互克3', '破剑者3', '魔防鼓舞3', null, '再动', '月虹', '1', '2', null, '4', '2', '2');
INSERT INTO `feh_character` VALUES ('15', '庆典之歌姬', '觉醒', '阿库亚', '阿库亚(暗夜)', null, null, '../../../resources/images/feh/acter/Aqua_F_BlackNormal/face.png', '../../../resources/images/feh/acter/Aqua_F_BlackNormal/q.png', '../../../resources/images/feh/acter/Aqua_F_BlackNormal/normal.png', '../../../resources/images/feh/acter/Aqua_F_BlackNormal/attact.png', '../../../resources/images/feh/acter/Aqua_F_BlackNormal/extra.png', '../../../resources/images/feh/acter/Aqua_F_BlackNormal/break.png', '35', '48', '34', '20', '28', '35', '32', '34', '20', '28', '乌尔德', '强化互克3', '救援行路3', '攻击大纹章2', null, '再动', '月虹', '1', '3', null, '1', '0', '3');
INSERT INTO `feh_character` VALUES ('16', '正月的歌姬', '觉醒', '阿库亚', '阿库亚(飞行)', null, null, '../../../resources/images/feh/acter/Aqua_F_NewYear18/face.png', '../../../resources/images/feh/acter/Aqua_F_NewYear18/q.png', '../../../resources/images/feh/acter/Aqua_F_NewYear18/normal.png', '../../../resources/images/feh/acter/Aqua_F_NewYear18/attact.png', '../../../resources/images/feh/acter/Aqua_F_NewYear18/extra.png', '../../../resources/images/feh/acter/Aqua_F_NewYear18/break.png', '42', '44', '32', '29', '26', '37', '30', '35', '22', '26', '羽子板+', '强化互克3', '大地之舞', '飞刃鼓舞', null, '再动', '星影', '3', '3', null, '4', '0', '3');
INSERT INTO `feh_character` VALUES ('17', '幼小的歌姬', '觉醒', '阿库亚', '阿库亚(小孩)', null, null, '../../../resources/images/feh/acter/Aqua_F_Dream/face.png', '../../../resources/images/feh/acter/Aqua_F_Dream/q.png', '../../../resources/images/feh/acter/Aqua_F_Dream/normal.png', '../../../resources/images/feh/acter/Aqua_F_Dream/attact.png', '../../../resources/images/feh/acter/Aqua_F_Dream/extra.png', '../../../resources/images/feh/acter/Aqua_F_Dream/break.png', '32', '43', '26', '16', '22', '37', '30', '35', '22', '26', '泡影之书', '速度魔防羁绊3', '静水之舞', '', null, '再动', '', '1', '6', null, '1', '0', '3');
INSERT INTO `feh_character` VALUES ('18', '透魔的歌姬', '觉醒', '阿库亚', '阿库亚(传承)', null, null, '../../../resources/images/feh/acter/Aqua_F_Legend/face.png', '../../../resources/images/feh/acter/Aqua_F_Legend/q.png', '../../../resources/images/feh/acter/Aqua_F_Legend/normal.png', '../../../resources/images/feh/acter/Aqua_F_Legend/attact.png', '../../../resources/images/feh/acter/Aqua_F_Legend/extra.png', '../../../resources/images/feh/acter/Aqua_F_Legend/break.png', '38', '41', '38', '17', '28', '33', '30', '35', '17', '24', '清冷的法具', '青色死斗 飞行3', '特技飞行', '攻击指挥3', null, '再动', '月光', '3', '5', null, '1', '0', '2');
INSERT INTO `feh_character` VALUES ('19', '伟大的皇女', '英雄', '维罗妮卡', '总选举', null, null, '../../../resources/images/feh/acter/Veronica_F_BravePrincess/face.png', '../../../resources/images/feh/acter/Veronica_F_BravePrincess/q.png', '../../../resources/images/feh/acter/Veronica_F_BravePrincess/normal.png', '../../../resources/images/feh/acter/Veronica_F_BravePrincess/attact.png', '../../../resources/images/feh/acter/Veronica_F_BravePrincess/extra.png', '../../../resources/images/feh/acter/Veronica_F_BravePrincess/break.png', '33', '49', '36', '24', '19', '36', '32', '36', '21', '19', '至高王座之杖', '攻击3', '神罚之杖', '死亡气息3', null, '圣愈+', '业火疾风祝福+', '2', '19', null, '4', null, '4');
INSERT INTO `feh_character` VALUES ('20', '亚斯克王国王子', '英雄', '阿尔冯斯', '', null, null, '../../../resources/images/feh/acter/Alfons_M_Normal/face.png', '../../../resources/images/feh/acter/Alfons_M_Normal/q.png', '../../../resources/images/feh/acter/Alfons_M_Normal/normal.png', '../../../resources/images/feh/acter/Alfons_M_Normal/attact.png', '../../../resources/images/feh/acter/Alfons_M_Normal/extra.png', '../../../resources/images/feh/acter/Alfons_M_Normal/break.png', '43', '51', '25', '32', '22', null, null, null, null, null, '弗尔克范格', '鬼神一击3', '', '攻击纹章3', null, '', '太阳', '1', '1', null, '1', null, '1');
INSERT INTO `feh_character` VALUES ('21', '亚斯克王国公主', '英雄', '夏蓉', '', null, null, '../../../resources/images/feh/acter/Sharon_F_Normal/face.png', '../../../resources/images/feh/acter/Sharon_F_Normal/q.png', '../../../resources/images/feh/acter/Sharon_F_Normal/normal.png', '../../../resources/images/feh/acter/Sharon_F_Normal/attact.png', '../../../resources/images/feh/acter/Sharon_F_Normal/extra.png', '../../../resources/images/feh/acter/Sharon_F_Normal/break.png', '46', '48', '35', '29', '22', null, null, null, null, null, '芬萨里尔', '速度3', '', '防守鼓舞3', null, '攻击支援', '', '1', '2', null, '1', null, '2');
INSERT INTO `feh_character` VALUES ('22', '特务机关队长', '英雄', '安娜', '', null, null, '../../../resources/images/feh/acter/Anna_F_Normal/face.png', '../../../resources/images/feh/acter/Anna_F_Normal/q.png', '../../../resources/images/feh/acter/Anna_F_Normal/normal.png', '../../../resources/images/feh/acter/Anna_F_Normal/attact.png', '../../../resources/images/feh/acter/Anna_F_Normal/extra.png', '../../../resources/images/feh/acter/Anna_F_Normal/break.png', '46', '45', '41', '22', '28', null, null, null, null, null, '诺欧通', '强化互克3', '埋伏3', '魔防纹章2', null, '拉近', '流星', '1', '3', null, '2', null, '3');
INSERT INTO `feh_character` VALUES ('23', '冰之公主', '英雄', '菲预尔姆', '冰公主', null, null, '../../../resources/images/feh/acter/Fjorm_F_Normal/face.png', '../../../resources/images/feh/acter/Fjorm_F_Normal/q.png', '../../../resources/images/feh/acter/Fjorm_F_Normal/normal.png', '../../../resources/images/feh/acter/Fjorm_F_Normal/attact.png', '../../../resources/images/feh/acter/Fjorm_F_Normal/extra.png', '../../../resources/images/feh/acter/Fjorm_F_Normal/break.png', '41', '48', '31', '31', '34', null, null, null, null, null, '雷依普特', '攻击防守羁绊3', '盾之跃动3', '攻击大纹章2', null, '带回', '冰之圣镜', '1', '2', null, '1', '1', '2');
INSERT INTO `feh_character` VALUES ('24', '新年参拜的冰之公主', '英雄', '菲预尔姆', '', null, null, '../../../resources/images/feh/acter/Fjorm_F_NewTraditions/face.png', '../../../resources/images/feh/acter/Fjorm_F_NewTraditions/q.png', '../../../resources/images/feh/acter/Fjorm_F_NewTraditions/normal.png', '../../../resources/images/feh/acter/Fjorm_F_NewTraditions/attact.png', '../../../resources/images/feh/acter/Fjorm_F_NewTraditions/extra.png', '../../../resources/images/feh/acter/Fjorm_F_NewTraditions/break.png', '39', '47', '35', '20', '21', '39', '35', '35', '20', '21', '鸣镝+', '攻击防守羁绊3', '攻击速度连动3', '魔防之波 偶数3', null, '带回', '', '3', '13', null, '1', '0', '3');
INSERT INTO `feh_character` VALUES ('25', '炎剑之鞘', '英雄', '瑞瓦伽伦', '', null, null, '../../../resources/images/feh/acter/Laegjarn_F_SheathedSteel/face.png', '../../../resources/images/feh/acter/Laegjarn_F_SheathedSteel/q.png', '../../../resources/images/feh/acter/Laegjarn_F_SheathedSteel/normal.png', '../../../resources/images/feh/acter/Laegjarn_F_SheathedSteel/attact.png', '../../../resources/images/feh/acter/Laegjarn_F_SheathedSteel/extra.png', '../../../resources/images/feh/acter/Laegjarn_F_SheathedSteel/break.png', '47', '48', '43', '36', '17', '41', '32', '36', '36', '17', '尼乌', '赤色死斗 飞行3', '攻击封杀3', '飞刃纹章', null, '带回', '绯炎', '3', '1', null, '3', '1', '1');
INSERT INTO `feh_character` VALUES ('26', '炎剑', '英雄', '瑞瓦提恩', '', null, null, '../../../resources/images/feh/acter/Laevatain_F_Normal/face.png', '../../../resources/images/feh/acter/Laevatain_F_Normal/q.png', '../../../resources/images/feh/acter/Laevatain_F_Normal/normal.png', '../../../resources/images/feh/acter/Laevatain_F_Normal/attact.png', '../../../resources/images/feh/acter/Laevatain_F_Normal/extra.png', '../../../resources/images/feh/acter/Laevatain_F_Normal/break.png', '45', '62', '37', '33', '17', '39', '37', '31', '34', '22', '瑞瓦提恩', '丝线3', '埋伏3', '速度之波 奇数3', null, '替换', '凶星', '1', '1', null, '1', '2', '1');
INSERT INTO `feh_character` VALUES ('27', '温柔的死神', '英雄', '埃尔', '', null, null, '../../../resources/images/feh/acter/Air_F_Normal/face.png', '../../../resources/images/feh/acter/Air_F_Normal/q.png', '../../../resources/images/feh/acter/Air_F_Normal/normal.png', '../../../resources/images/feh/acter/Air_F_Normal/attact.png', '../../../resources/images/feh/acter/Air_F_Normal/extra.png', '../../../resources/images/feh/acter/Air_F_Normal/break.png', '35', '47', '37', '14', '34', null, null, null, null, null, '利菲亚', '鬼神飞燕击2', '生命护符3', '生命光辉', null, '带回', '冰苍', '3', '18', null, '4', '0', '4');
INSERT INTO `feh_character` VALUES ('28', '夏日射线', '纹章之谜', '琳达', '泳装琳达', null, null, '../../../resources/images/feh/acter/Linde_F_SummerRays/face.png', '../../../resources/images/feh/acter/Linde_F_SummerRays/q.png', '../../../resources/images/feh/acter/Linde_F_SummerRays/normal.png', '../../../resources/images/feh/acter/Linde_F_SummerRays/attact.png', '../../../resources/images/feh/acter/Linde_F_SummerRays/extra.png', '../../../resources/images/feh/acter/Linde_F_SummerRays/break.png', '35', '40', '40', '16', '29', '33', '34', '35', '16', '26', '海星+', '攻击魔防大觉醒3', '破弓者3', '骑盾鼓舞', null, '带回', '龙裂', '2', '18', null, '4', '0', '4');
INSERT INTO `feh_character` VALUES ('29', '海边的龙公主', '纹章之谜', '琪姬', '飞琪姬', null, null, '../../../resources/images/feh/acter/Tiki_F_Beachside/face.png', '../../../resources/images/feh/acter/Tiki_F_Beachside/q.png', '../../../resources/images/feh/acter/Tiki_F_Beachside/normal.png', '../../../resources/images/feh/acter/Tiki_F_Beachside/attact.png', '../../../resources/images/feh/acter/Tiki_F_Beachside/extra.png', '../../../resources/images/feh/acter/Tiki_F_Beachside/break.png', '40', '49', '40', '32', '26', '40', '33', '37', '32', '26', '盛夏吐息', '攻击防守羁绊3', '一击即离', '龙之技巧', null, '', '月虹', '3', '7', null, '4', '0', '1');
INSERT INTO `feh_character` VALUES ('30', '传承龙公主', '纹章之谜', '琪姬', '重装琪姬', null, null, '../../../resources/images/feh/acter/Tiki_F_Legendary/face.png', '../../../resources/images/feh/acter/Tiki_F_Legendary/q.png', '../../../resources/images/feh/acter/Tiki_F_Legendary/normal.png', '../../../resources/images/feh/acter/Tiki_F_Legendary/attact.png', '../../../resources/images/feh/acter/Tiki_F_Legendary/extra.png', '../../../resources/images/feh/acter/Tiki_F_Legendary/break.png', '45', '50', '35', '40', '26', '45', '34', '35', '37', '29', '神雾吐息', '鬼神呼吸', '攻击队形3', '和大家一起', null, '替换', '天空', '4', '8', null, '2', '0', '2');
INSERT INTO `feh_character` VALUES ('31', '女神的神官战士', '索菲亚的复苏', '赛莉卡', '', null, null, '../../../resources/images/feh/acter/Celica_M_Echo/face.png', '../../../resources/images/feh/acter/Celica_M_Echo/q.png', '../../../resources/images/feh/acter/Celica_M_Echo/normal.png', '../../../resources/images/feh/acter/Celica_M_Echo/attact.png', '../../../resources/images/feh/acter/Celica_M_Echo/extra.png', '../../../resources/images/feh/acter/Celica_M_Echo/break.png', '38', '52', '42', '29', '21', null, null, null, null, null, '王家之剑', '鬼神一击4', '狮子连斩', '攻击指挥3', null, '', '流星', '1', '1', null, '2', '0', '1');
INSERT INTO `feh_character` VALUES ('32', '流星的剑姬', '圣战的系谱', '艾伊拉', '', null, null, '../../../resources/images/feh/acter/Ayra_F_Normal/face.png', '../../../resources/images/feh/acter/Ayra_F_Normal/q.png', '../../../resources/images/feh/acter/Ayra_F_Normal/normal.png', '../../../resources/images/feh/acter/Ayra_F_Normal/attact.png', '../../../resources/images/feh/acter/Ayra_F_Normal/extra.png', '../../../resources/images/feh/acter/Ayra_F_Normal/break.png', '42', '51', '46', '31', '21', null, null, null, null, null, '顺闪艾伊拉之剑', '鬼神飞燕击2', '猛攻3', '死亡气息3', null, '带回', '天空', '1', '1', null, '3', '1', '1');
INSERT INTO `feh_character` VALUES ('33', '封炎的青年之狮', '封印之剑', '罗伊', '传承罗伊', null, null, '../../../resources/images/feh/acter/Roy_M_Legend/face.png', '../../../resources/images/feh/acter/Roy_M_Legend/q.png', '../../../resources/images/feh/acter/Roy_M_Legend/normal.png', '../../../resources/images/feh/acter/Roy_M_Legend/attact.png', '../../../resources/images/feh/acter/Roy_M_Legend/extra.png', '../../../resources/images/feh/acter/Roy_M_Legend/break.png', '39', '50', '38', '32', '26', null, null, null, null, null, '守护之剑', '强化增幅3', '回复3', '发挥人类的潜能', null, '带回', '龙穿', '1', '1', null, '4', '0', '1');
INSERT INTO `feh_character` VALUES ('34', '达纳的舞娘', '圣战的系谱', '琳恩', '', null, null, '../../../resources/images/feh/acter/Lean_F_Normal/face.png', '../../../resources/images/feh/acter/Lean_F_Normal/q.png', '../../../resources/images/feh/acter/Lean_F_Normal/normal.png', '../../../resources/images/feh/acter/Lean_F_Normal/attact.png', '../../../resources/images/feh/acter/Lean_F_Normal/extra.png', '../../../resources/images/feh/acter/Lean_F_Normal/break.png', '36', '40', '33', '26', '30', null, null, null, null, null, '守护之剑', '', '业火疾风之舞2', '剑之技巧3', null, '再动', '', '1', '1', null, '4', '0', '1');
INSERT INTO `feh_character` VALUES ('35', '旅行舞娘', '圣战的系谱', '希薇雅', '', null, null, '../../../resources/images/feh/acter/Silvia_F_TravelingDancer/face.png', '../../../resources/images/feh/acter/Silvia_F_TravelingDancer/q.png', '../../../resources/images/feh/acter/Silvia_F_TravelingDancer/normal.png', '../../../resources/images/feh/acter/Silvia_F_TravelingDancer/attact.png', '../../../resources/images/feh/acter/Silvia_F_TravelingDancer/extra.png', '../../../resources/images/feh/acter/Silvia_F_TravelingDancer/break.png', '46', '41', '40', '21', '30', null, null, null, null, null, '巴里亚之剑+', '鬼神明镜架势2', '疾风静水之舞2', '攻击鼓舞3', null, '再动', '', '1', '1', null, '1', '1', '1');
INSERT INTO `feh_character` VALUES ('36', '塔利斯的公主', '纹章之谜', '希达', '', null, null, '../../../resources/images/feh/acter/Sheeda_F_Normal/face.png', '../../../resources/images/feh/acter/Sheeda_F_Normal/q.png', '../../../resources/images/feh/acter/Sheeda_F_Normal/normal.png', '../../../resources/images/feh/acter/Sheeda_F_Normal/attact.png', '../../../resources/images/feh/acter/Sheeda_F_Normal/extra.png', '../../../resources/images/feh/acter/Sheeda_F_Normal/break.png', '36', '45', '37', '21', '34', null, null, null, null, null, '羽翼之剑', '飞燕一击3', '', '飞盾鼓舞', null, '带回', '冰华', '3', '1', null, '1', '1', '1');
INSERT INTO `feh_character` VALUES ('37', '登上巅峰的剑客', '苍炎轨迹', '瓦育', '', null, null, '../../../resources/images/feh/acter/Wayu_F_Normal/face.png', '../../../resources/images/feh/acter/Wayu_F_Normal/q.png', '../../../resources/images/feh/acter/Wayu_F_Normal/normal.png', '../../../resources/images/feh/acter/Wayu_F_Normal/attact.png', '../../../resources/images/feh/acter/Wayu_F_Normal/extra.png', '../../../resources/images/feh/acter/Wayu_F_Normal/break.png', '34', '51', '40', '29', '29', null, null, null, null, null, '气瑞瓦育之剑', '柔剑3', '猛攻3', '攻击威吓3', null, '拉近', '月光', '1', '1', null, '3', '0', '1');
INSERT INTO `feh_character` VALUES ('38', '传承神将', '晓之巫女', '艾克', '传承艾克', null, null, '../../../resources/images/feh/acter/Ike_M_Legend01/face.png', '../../../resources/images/feh/acter/Ike_M_Legend01/q.png', '../../../resources/images/feh/acter/Ike_M_Legend01/normal.png', '../../../resources/images/feh/acter/Ike_M_Legend01/attact.png', '../../../resources/images/feh/acter/Ike_M_Legend01/extra.png', '../../../resources/images/feh/acter/Ike_M_Legend01/break.png', '43', '54', '31', '37', '21', null, null, null, null, null, '瑞格内尔', '明镜呼吸', '攻击防守封印2', '防守指挥3', null, '替换', '苍蓝天空', '1', '1', null, '2', '2', '1');
INSERT INTO `feh_character` VALUES ('39', '害羞的', '觉醒', '奥利薇', '', null, null, '../../../resources/images/feh/acter/Olivie_F_Normal/face.png', '../../../resources/images/feh/acter/Olivie_F_Normal/q.png', '../../../resources/images/feh/acter/Olivie_F_Normal/normal.png', '../../../resources/images/feh/acter/Olivie_F_Normal/attact.png', '../../../resources/images/feh/acter/Olivie_F_Normal/extra.png', '../../../resources/images/feh/acter/Olivie_F_Normal/break.png', '46', '44', '40', '27', '26', null, null, null, null, null, '银剑+', 'HP2', '救援行路3', '攻击鼓舞3', null, '再动', '', '1', '1', null, '3', '1', '1');
INSERT INTO `feh_character` VALUES ('40', '将思恋化为力量', '苍炎轨迹', '艾克', '情人节艾克', null, null, '../../../resources/images/feh/acter/Ike_M_Venlent/face.png', '../../../resources/images/feh/acter/Ike_M_Venlent/q.png', '../../../resources/images/feh/acter/Ike_M_Venlent/normal.png', '../../../resources/images/feh/acter/Ike_M_Venlent/attact.png', '../../../resources/images/feh/acter/Ike_M_Venlent/extra.png', '../../../resources/images/feh/acter/Ike_M_Venlent/break.png', '52', '55', '41', '35', '19', null, null, null, null, null, '祝祭之剑+', '远距离反击', '奥义队形3', '重装行军3', null, '拉近', '苍蓝天空', '4', '1', null, '2', '1', '1');
INSERT INTO `feh_character` VALUES ('41', '四骏之将', '苍炎轨迹', '漆黑骑士', '', null, null, '../../../resources/images/feh/acter/BlackNight_M_Normal/face.png', '../../../resources/images/feh/acter/BlackNight_M_Normal/q.png', '../../../resources/images/feh/acter/BlackNight_M_Normal/normal.png', '../../../resources/images/feh/acter/BlackNight_M_Normal/attact.png', '../../../resources/images/feh/acter/BlackNight_M_Normal/extra.png', '../../../resources/images/feh/acter/BlackNight_M_Normal/break.png', '50', '52', '34', '36', '18', null, null, null, null, null, '艾塔尔德', '金刚架势3', '迎击队形3', '重刃鼓舞', null, '拉近', '漆黑月光', '4', '1', null, '3', '1', null);
INSERT INTO `feh_character` VALUES ('42', '漆黑之将', '晓之巫女', '赛尔吉乌斯', '', null, null, '../../../resources/images/feh/acter/Zelgius_M_Normal/face.png', '../../../resources/images/feh/acter/Zelgius_M_Normal/q.png', '../../../resources/images/feh/acter/Zelgius_M_Normal/normal.png', '../../../resources/images/feh/acter/Zelgius_M_Normal/attact.png', '../../../resources/images/feh/acter/Zelgius_M_Normal/extra.png', '../../../resources/images/feh/acter/Zelgius_M_Normal/break.png', '43', '52', '33', '40', '24', null, null, null, null, null, '艾塔尔德', '鬼神架势3', '转移粉末', '重刃鼓舞', null, '拉近', '漆黑月光', '4', '1', null, '3', null, '1');
INSERT INTO `feh_character` VALUES ('43', '圣骑士', '圣战的系谱', '西格尔特', '', null, null, '../../../resources//images/feh/acter/Siglud_M_Normal/face.png', '../../../resources//images/feh/acter/Siglud_M_Normal/q.png', '../../../resources//images/feh/acter/Siglud_M_Normal/normal.png', '../../../resources//images/feh/acter/Siglud_M_Normal/attact.png', '../../../resources//images/feh/acter/Siglud_M_Normal/extra.png', '../../../resources//images/feh/acter/Siglud_M_Normal/break.png', '44', '48', '32', '34', '21', null, null, null, null, null, '', '近距离防御3', '圣骑士的加护', '骑刃鼓舞', null, '带回', '祈祷', '2', '1', null, '4', null, '1');
INSERT INTO `feh_character` VALUES ('44', '狮子王', '圣战的系谱', '艾尔多尚', '', null, null, '../../../resources//images/feh/acter/Eltshan_M_Normal/face.png', '../../../resources//images/feh/acter/Eltshan_M_Normal/q.png', '../../../resources//images/feh/acter/Eltshan_M_Normal/normal.png', '../../../resources//images/feh/acter/Eltshan_M_Normal/attact.png', '../../../resources//images/feh/acter/Eltshan_M_Normal/extra.png', '../../../resources//images/feh/acter/Eltshan_M_Normal/break.png', '49', '54', '30', '45', '25', null, null, null, null, null, '米斯特汀', '狮子奋迅3', '回复3', '骑刃鼓舞', null, '带回', '爆光', '2', '1', null, '1', '1', '1');
INSERT INTO `feh_character` VALUES ('45', '黑骑士', '圣战的系谱', '阿瑞斯', '小狮子', null, null, '../../../resources//images/feh/acter/Ares_M_lackKnight/face.png', '../../../resources//images/feh/acter/Ares_M_lackKnight/q.png', '../../../resources//images/feh/acter/Ares_M_lackKnight/normal.png', '../../../resources//images/feh/acter/Ares_M_lackKnight/attact.png', '../../../resources//images/feh/acter/Ares_M_lackKnight/extra.png', '../../../resources//images/feh/acter/Ares_M_lackKnight/break.png', '36', '52', '33', '33', '18', null, null, null, null, null, '魔剑米斯特汀', '攻击防守大觉醒3', '防守魔防封印2', '骑刃鼓舞', null, '带回', '卧龙', '2', '1', null, '4', null, '1');
INSERT INTO `feh_character` VALUES ('46', '雷神之剑', '多拉基亚776', '莱因哈特', '', null, null, '../../../resources//images/feh/acter/Reinhardt_M_Normal2/face.png', '../../../resources//images/feh/acter/Reinhardt_M_Normal2/q.png', '../../../resources//images/feh/acter/Reinhardt_M_Normal2/normal.png', '../../../resources//images/feh/acter/Reinhardt_M_Normal2/attact.png', '../../../resources//images/feh/acter/Reinhardt_M_Normal2/extra.png', '../../../resources//images/feh/acter/Reinhardt_M_Normal2/break.png', '41', '52', '18', '33', '28', null, null, null, null, null, '大师之剑', '鬼神一击3', '破斧者3', '骑刃鼓舞', null, '拉近', '凶星', '2', '1', null, '2', '1', '1');
INSERT INTO `feh_character` VALUES ('47', '伟大的勋爵', '封印之剑', '罗伊', '总选举罗伊', null, null, '../../../resources//images/feh/acter/Roy_M_ELECTION01/face.png', '../../../resources//images/feh/acter/Roy_M_ELECTION01/q.png', '../../../resources//images/feh/acter/Roy_M_ELECTION01/normal.png', '../../../resources//images/feh/acter/Roy_M_ELECTION01/attact.png', '../../../resources//images/feh/acter/Roy_M_ELECTION01/extra.png', '../../../resources//images/feh/acter/Roy_M_ELECTION01/break.png', '42', '55', '34', '26', '24', null, null, null, null, null, '烈剑迪朗达尔', '飞燕金刚击2', '猛攻3', '骑刃鼓舞', null, '带回', '流星', '2', '1', null, '4', '1', '1');
INSERT INTO `feh_character` VALUES ('48', '动人的决心', '圣魔光石', '艾莉柯', '', null, null, '../../../resources//images/feh/acter/Eirik_F_Memories/face.png', '../../../resources//images/feh/acter/Eirik_F_Memories/q.png', '../../../resources//images/feh/acter/Eirik_F_Memories/normal.png', '../../../resources//images/feh/acter/Eirik_F_Memories/attact.png', '../../../resources//images/feh/acter/Eirik_F_Memories/extra.png', '../../../resources//images/feh/acter/Eirik_F_Memories/break.png', '38', '53', '36', '27', '21', null, null, null, null, null, '雷剑齐格林德', '攻击速度孤军3', '月亮手镯', '防守之波奇数3', null, '拉近', '月虹', '2', '1', null, '1', null, '1');
INSERT INTO `feh_character` VALUES ('49', '暗夜骑士', 'IF', '马克斯', '', null, null, '../../../resources//images/feh/acter/Marks_M_Normal/face.png', '../../../resources//images/feh/acter/Marks_M_Normal/q.png', '../../../resources//images/feh/acter/Marks_M_Normal/normal.png', '../../../resources//images/feh/acter/Marks_M_Normal/attact.png', '../../../resources//images/feh/acter/Marks_M_Normal/extra.png', '../../../resources//images/feh/acter/Marks_M_Normal/break.png', '44', '48', '24', '37', '17', null, null, null, null, null, '西格弗里德', '金刚一击3', '阻止进军3', '骑刃鼓舞', null, '带回', '烈光', null, '1', null, '4', null, '1');
INSERT INTO `feh_character` VALUES ('50', '霸天的白夜武者', 'IF', '龙马', '', null, null, '../../../resources//images/feh/acter/Ryoma_M_SupremeSamurai/face.png', '../../../resources//images/feh/acter/Ryoma_M_SupremeSamurai/q.png', '../../../resources//images/feh/acter/Ryoma_M_SupremeSamurai/normal.png', '../../../resources//images/feh/acter/Ryoma_M_SupremeSamurai/attact.png', '../../../resources//images/feh/acter/Ryoma_M_SupremeSamurai/extra.png', '../../../resources//images/feh/acter/Ryoma_M_SupremeSamurai/break.png', '43', '51', '41', '28', '20', null, null, null, null, null, '雷神刀', '鬼神飞燕架势2', '武士道', '飞刃纹章', null, '带回', '黎明', '3', '1', null, '1', '1', '1');
INSERT INTO `feh_character` VALUES ('51', '黑暗巫女', '封印之剑', '伊东', '', null, null, '../../../resources//images/feh/acter/Idunn_F_DarkPriestess/face.png', '../../../resources//images/feh/acter/Idunn_F_DarkPriestess/q.png', '../../../resources//images/feh/acter/Idunn_F_DarkPriestess/normal.png', '../../../resources//images/feh/acter/Idunn_F_DarkPriestess/attact.png', '../../../resources//images/feh/acter/Idunn_F_DarkPriestess/extra.png', '../../../resources//images/feh/acter/Idunn_F_DarkPriestess/break.png', '45', '49', '22', '52', '40', null, null, null, null, null, '魔龙吐息', '防守魔防堡垒3', '迎击队形3', '龙盾纹章', null, '替换', '绯炎', '4', '7', null, '3', null, '1');
INSERT INTO `feh_character` VALUES ('52', '纯真的妖怪', '圣魔光石', '梅尔', '圣诞节梅尔', null, null, '../../../resources//images/feh/acter/Mel_F_Halloween/face.png', '../../../resources//images/feh/acter/Mel_F_Halloween/q.png', '../../../resources//images/feh/acter/Mel_F_Halloween/normal.png', '../../../resources//images/feh/acter/Mel_F_Halloween/attact.png', '../../../resources//images/feh/acter/Mel_F_Halloween/extra.png', '../../../resources//images/feh/acter/Mel_F_Halloween/break.png', '46', '58', '20', '45', '34', null, null, null, null, null, '精灵吐息', '防守魔防2', '迎击队形3', '重装行军', null, '迂回', '绯炎', '4', '7', null, '3', null, '1');
INSERT INTO `feh_character` VALUES ('53', '夏日景致的少女', '晓之巫女', '米卡雅', '', null, null, '../../../resources//images/feh/acter/Micaiah_M_SummerDawn/face.png', '../../../resources//images/feh/acter/Micaiah_M_SummerDawn/q.png', '../../../resources//images/feh/acter/Micaiah_M_SummerDawn/normal.png', '../../../resources//images/feh/acter/Micaiah_M_SummerDawn/attact.png', '../../../resources//images/feh/acter/Micaiah_M_SummerDawn/extra.png', '../../../resources//images/feh/acter/Micaiah_M_SummerDawn/break.png', '38', '52', '21', '18', '35', null, null, null, null, null, '晓天的神乐铃', '攻击魔防羁绊3', '破斧者3', '魔防谋策3', null, '再动', '强风', '1', '4', null, '2', '2', '1');
INSERT INTO `feh_character` VALUES ('54', '阴沉的暗影法师', '觉醒', '萨拉', '', null, null, '../../../resources//images/feh/acter/Sallya_F_Normal/face.png', '../../../resources//images/feh/acter/Sallya_F_Normal/q.png', '../../../resources//images/feh/acter/Sallya_F_Normal/normal.png', '../../../resources//images/feh/acter/Sallya_F_Normal/attact.png', '../../../resources//images/feh/acter/Sallya_F_Normal/extra.png', '../../../resources//images/feh/acter/Sallya_F_Normal/break.png', '41', '47', '38', '24', '21', null, null, null, null, null, '萨拉的禁咒', '飞燕一击3', '猛攻3', '魔防纹章3', null, '拉近', '凶星', '1', '4', null, '4', '3', '1');
INSERT INTO `feh_character` VALUES ('55', '热情的新娘', '觉醒', '萨拉', '', null, null, '../../../resources//images/feh/acter/Sallya_F_Obsessive/face.png', '../../../resources//images/feh/acter/Sallya_F_Obsessive/q.png', '../../../resources//images/feh/acter/Sallya_F_Obsessive/normal.png', '../../../resources//images/feh/acter/Sallya_F_Obsessive/attact.png', '../../../resources//images/feh/acter/Sallya_F_Obsessive/extra.png', '../../../resources//images/feh/acter/Sallya_F_Obsessive/break.png', '40', '50', '38', '24', '21', null, null, null, null, null, '穆斯贝尔之炎花', '攻击速度羁绊3', '猛攻3', '防守纹章3', null, '攻击速度支援', '凶星', '1', '4', null, '1', '1', '1');
INSERT INTO `feh_character` VALUES ('56', '普通的女孩', '觉醒', '萨拉', '', null, null, '../../../resources//images/feh/acter/Sallya_F_WinterFes17/face.png', '../../../resources//images/feh/acter/Sallya_F_WinterFes17/q.png', '../../../resources//images/feh/acter/Sallya_F_WinterFes17/normal.png', '../../../resources//images/feh/acter/Sallya_F_WinterFes17/attact.png', '../../../resources//images/feh/acter/Sallya_F_WinterFes17/extra.png', '../../../resources//images/feh/acter/Sallya_F_WinterFes17/break.png', '47', '51', '18', '37', '36', null, null, null, null, null, '烛台+', '近距离反击', '迎击队形3', '重装行军3', null, '替换', '天空', '4', '4', null, '3', '1', '1');
INSERT INTO `feh_character` VALUES ('57', '回忆的善良公主', '圣魔光石', '艾莉柯', '', null, null, '../../../resources//images/feh/acter/Eirik_F_Legend/face.png', '../../../resources//images/feh/acter/Eirik_F_Legend/q.png', '../../../resources//images/feh/acter/Eirik_F_Legend/normal.png', '../../../resources//images/feh/acter/Eirik_F_Legend/attact.png', '../../../resources//images/feh/acter/Eirik_F_Legend/extra.png', '../../../resources//images/feh/acter/Eirik_F_Legend/break.png', '36', '47', '41', '20', '25', null, null, null, null, null, '赤红之书+', '狮子奋迅3', '猛攻3', '骑刃鼓舞', null, '带回', '月虹', '2', '4', null, '3', null, '1');
INSERT INTO `feh_character` VALUES ('58', '情深意重的骑士', '苍炎轨迹', '狄亚马特', '', null, null, '../../../resources//images/feh/acter/Tiamat_F_Venlent/face.png', '../../../resources//images/feh/acter/Tiamat_F_Venlent/q.png', '../../../resources//images/feh/acter/Tiamat_F_Venlent/normal.png', '../../../resources//images/feh/acter/Tiamat_F_Venlent/attact.png', '../../../resources//images/feh/acter/Tiamat_F_Venlent/extra.png', '../../../resources//images/feh/acter/Tiamat_F_Venlent/break.png', '37', '43', '35', '17', '30', null, null, null, null, null, '花圈+', '强化互克3', '攻击魔防联动3', '骑盾鼓舞', null, '替换', '月虹', '2', '4', null, '1', '1', '1');
INSERT INTO `feh_character` VALUES ('59', '奔放的公主', '圣魔光石', '塔娜', '', null, null, '../../../resources//images/feh/acter/Turner_F_NobleandNimble/face.png', '../../../resources//images/feh/acter/Turner_F_NobleandNimble/q.png', '../../../resources//images/feh/acter/Turner_F_NobleandNimble/normal.png', '../../../resources//images/feh/acter/Turner_F_NobleandNimble/attact.png', '../../../resources//images/feh/acter/Turner_F_NobleandNimble/extra.png', '../../../resources//images/feh/acter/Turner_F_NobleandNimble/break.png', '36', '47', '40', '21', '25', null, null, null, null, null, '赤红之书+', '攻击速度的奋击3', '回复3', '飞盾纹章', null, '拉近', '新月', '3', '4', null, '4', '2', '1');
INSERT INTO `feh_character` VALUES ('60', '黑暗游女', '觉醒', '茵巴丝', '', null, null, '../../../resources//images/feh/acter/Aversa_F_Normal/face.png', '../../../resources//images/feh/acter/Aversa_F_Normal/q.png', '../../../resources//images/feh/acter/Aversa_F_Normal/normal.png', '../../../resources//images/feh/acter/Aversa_F_Normal/attact.png', '../../../resources//images/feh/acter/Aversa_F_Normal/extra.png', '../../../resources//images/feh/acter/Aversa_F_Normal/break.png', '36', '47', '40', '21', '25', null, null, null, null, null, '茵巴丝的黑暗', 'HP速度2', '破斧者3', '飞盾纹章', null, '带回', '龙穿', '3', '4', null, '3', null, '1');
INSERT INTO `feh_character` VALUES ('61', '碧空的勇猛王子', '圣魔光石', '艾弗拉姆', '', null, null, '../../../resources//images/feh/acter/Ephraim_M_Normal/face.png', '../../../resources//images/feh/acter/Ephraim_M_Normal/q.png', '../../../resources//images/feh/acter/Ephraim_M_Normal/normal.png', '../../../resources//images/feh/acter/Ephraim_M_Normal/attact.png', '../../../resources//images/feh/acter/Ephraim_M_Normal/extra.png', '../../../resources//images/feh/acter/Ephraim_M_Normal/break.png', '45', '54', '25', '29', '20', null, null, null, null, null, '齐格蒙德', '金刚一击3', '破剑者3', '防守威吓2', null, '', '月虹', '1', '2', null, '2', null, '2');
INSERT INTO `feh_character` VALUES ('62', '传承勇猛王子', '圣魔光石', '艾弗拉姆', '传承艾弗拉姆', null, null, '../../../resources//images/feh/acter/Ephraim_M_Legend01/face.png', '../../../resources//images/feh/acter/Ephraim_M_Legend01/q.png', '../../../resources//images/feh/acter/Ephraim_M_Legend01/normal.png', '../../../resources//images/feh/acter/Ephraim_M_Legend01/attact.png', '../../../resources//images/feh/acter/Ephraim_M_Legend01/extra.png', '../../../resources//images/feh/acter/Ephraim_M_Legend01/break.png', '40', '55', '27', '33', '21', null, null, null, null, null, '炎枪齐格蒙德', '鬼神金刚架势', '太阳手镯', '骑盾鼓舞', null, '带回', '凶星', '2', '2', null, '4', null, '2');
INSERT INTO `feh_character` VALUES ('63', '双圣的勇猛王子', '圣魔光石', '艾弗拉姆', '总选举艾弗拉姆', null, null, '../../../resources//images/feh/acter/Ephraim_M_SacredTwinLord/face.png', '../../../resources//images/feh/acter/Ephraim_M_SacredTwinLord/q.png', '../../../resources//images/feh/acter/Ephraim_M_SacredTwinLord/normal.png', '../../../resources//images/feh/acter/Ephraim_M_SacredTwinLord/attact.png', '../../../resources//images/feh/acter/Ephraim_M_SacredTwinLord/extra.png', '../../../resources//images/feh/acter/Ephraim_M_SacredTwinLord/break.png', '47', '57', '27', '38', '30', null, null, null, null, null, '加姆', '近距离防御3', '奥义队形3', '重装行军3', null, '替换', '龙裂', '4', '3', null, '3', '1', '3');
INSERT INTO `feh_character` VALUES ('64', '伟大的公主', '觉醒', '露琪娜', '传承露琪娜', null, null, '../../../resources//images/feh/acter/Lucina_F_ELECTION01/face.png', '../../../resources//images/feh/acter/Lucina_F_ELECTION01/q.png', '../../../resources//images/feh/acter/Lucina_F_ELECTION01/normal.png', '../../../resources//images/feh/acter/Lucina_F_ELECTION01/attact.png', '../../../resources//images/feh/acter/Lucina_F_ELECTION01/extra.png', '../../../resources//images/feh/acter/Lucina_F_ELECTION01/break.png', '44', '50', '37', '28', '19', null, null, null, null, null, '洁尔诗科古尔', '鬼神金刚击2', '破剑者3', '速度大纹章2', null, '', '天空', '1', '2', null, '2', '1', '2');
INSERT INTO `feh_character` VALUES ('65', '神威射手', '觉醒', '露琪娜', '传承露琪娜', null, null, '../../../resources//images/feh/acter/Lucina_F_GloriousArcher/face.png', '../../../resources//images/feh/acter/Lucina_F_GloriousArcher/q.png', '../../../resources//images/feh/acter/Lucina_F_GloriousArcher/normal.png', '../../../resources//images/feh/acter/Lucina_F_GloriousArcher/attact.png', '../../../resources//images/feh/acter/Lucina_F_GloriousArcher/extra.png', '../../../resources//images/feh/acter/Lucina_F_GloriousArcher/break.png', '41', '48', '40', '25', '20', null, null, null, null, null, '索军', '鬼神飞燕击2', '猛攻3', '近距离警戒3', null, '映照未来的眼眸', '凶星', '1', '12', null, '3', '1', '2');
INSERT INTO `feh_character` VALUES ('66', '爱的奉献', '烈火之剑', '艾利乌德', '', null, null, '../../../resources//images/feh/acter/Eliwood_M_DevotedLove/face.png', '../../../resources//images/feh/acter/Eliwood_M_DevotedLove/q.png', '../../../resources//images/feh/acter/Eliwood_M_DevotedLove/normal.png', '../../../resources//images/feh/acter/Eliwood_M_DevotedLove/attact.png', '../../../resources//images/feh/acter/Eliwood_M_DevotedLove/extra.png', '../../../resources//images/feh/acter/Eliwood_M_DevotedLove/break.png', '47', '52', '32', '29', '29', null, null, null, null, null, '卡萨布兰卡+', '生命业火3', '', '重刃纹章', null, '攻击支援', '', '4', '2', null, '3', null, '2');
INSERT INTO `feh_character` VALUES ('67', '伟大的重骑士', '烈火之剑', '海克托尔', '总选举大海', null, null, '../../../resources//images/feh/acter/Hector_M_BraveWarrior/face.png', '../../../resources//images/feh/acter/Hector_M_BraveWarrior/q.png', '../../../resources//images/feh/acter/Hector_M_BraveWarrior/normal.png', '../../../resources//images/feh/acter/Hector_M_BraveWarrior/attact.png', '../../../resources//images/feh/acter/Hector_M_BraveWarrior/extra.png', '../../../resources//images/feh/acter/Hector_M_BraveWarrior/break.png', '48', '53', '22', '39', '28', null, null, null, null, null, '马尔堤', '奥斯提亚德反击', '攻击队形3', '重刃鼓舞', null, '替换', '天空', '4', '2', null, '3', null, '2');
INSERT INTO `feh_character` VALUES ('68', '怪力的重骑士', 'IF', '艾尔菲', '', null, null, '../../../resources//images/feh/acter/Effie_F_ArmyofOne/face.png', '../../../resources//images/feh/acter/Effie_F_ArmyofOne/q.png', '../../../resources//images/feh/acter/Effie_F_ArmyofOne/normal.png', '../../../resources//images/feh/acter/Effie_F_ArmyofOne/attact.png', '../../../resources//images/feh/acter/Effie_F_ArmyofOne/extra.png', '../../../resources//images/feh/acter/Effie_F_ArmyofOne/break.png', '50', '58', '19', '33', '23', null, null, null, null, null, '银枪+', '鬼神一击3', '防守队形3', '重刃纹章', null, '重击', '萤火', '4', '2', null, '2', null, '2');
INSERT INTO `feh_character` VALUES ('69', '新年参拜德炎之公主', '英雄', '瑞瓦伽伦', '', null, null, '../../../resources//images/feh/acter/Laegjarn_F_NewExperiences/face.png', '../../../resources//images/feh/acter/Laegjarn_F_NewExperiences/q.png', '../../../resources//images/feh/acter/Laegjarn_F_NewExperiences/normal.png', '../../../resources//images/feh/acter/Laegjarn_F_NewExperiences/attact.png', '../../../resources//images/feh/acter/Laegjarn_F_NewExperiences/extra.png', '../../../resources//images/feh/acter/Laegjarn_F_NewExperiences/break.png', '38', '46', '35', '35', '17', null, null, null, null, null, '和伞+', '', '魔防封杀3', '骑刃鼓舞', null, '带回', '', '2', '2', null, '1', null, '2');
INSERT INTO `feh_character` VALUES ('70', '传说中的枪骑士', '多拉基亚776', '芬恩', '', null, null, '../../../resources//images/feh/acter/Finn_M_anceofLegend/face.png', '../../../resources//images/feh/acter/Finn_M_anceofLegend/q.png', '../../../resources//images/feh/acter/Finn_M_anceofLegend/normal.png', '../../../resources//images/feh/acter/Finn_M_anceofLegend/attact.png', '../../../resources//images/feh/acter/Finn_M_anceofLegend/extra.png', '../../../resources//images/feh/acter/Finn_M_anceofLegend/break.png', '40', '44', '28', '34', '18', null, null, null, null, null, '勇者之枪+', '攻击防守2', '', '骑盾鼓舞', null, '拉近', '祈祷', '2', '2', null, '1', null, '2');
INSERT INTO `feh_character` VALUES ('71', '以花占卜的少女', '觉醒', '丝米亚', '', null, null, '../../../resources//images/feh/acter/Sumia_F_MaidofFlowers/face.png', '../../../resources//images/feh/acter/Sumia_F_MaidofFlowers/q.png', '../../../resources//images/feh/acter/Sumia_F_MaidofFlowers/normal.png', '../../../resources//images/feh/acter/Sumia_F_MaidofFlowers/attact.png', '../../../resources//images/feh/acter/Sumia_F_MaidofFlowers/extra.png', '../../../resources//images/feh/acter/Sumia_F_MaidofFlowers/break.png', '49', '45', '41', '35', '26', null, null, null, null, null, '反攻之枪+', '近距离防御3', '攻击防守连动3', '飞刃纹章', null, '带回', '小盾', '3', '2', null, '4', '4', '2');
INSERT INTO `feh_character` VALUES ('72', '赤色战姬', 'IF', '火乃香', '', null, null, '../../../resources//images/feh/acter/Hinoka_F_Normal/face.png', '../../../resources//images/feh/acter/Hinoka_F_Normal/q.png', '../../../resources//images/feh/acter/Hinoka_F_Normal/normal.png', '../../../resources//images/feh/acter/Hinoka_F_Normal/attact.png', '../../../resources//images/feh/acter/Hinoka_F_Normal/extra.png', '../../../resources//images/feh/acter/Hinoka_F_Normal/break.png', '47', '53', '32', '25', '28', null, null, null, null, null, '火乃香的红雉刀', '强化互克3', '破剑者3', '飞刃鼓舞', null, '带回', '太阳', '3', '2', null, '2', '1', '2');
INSERT INTO `feh_character` VALUES ('73', '苍天战姬', 'IF', '火乃香', '', null, null, '../../../resources//images/feh/acter/Hinoka_F_BlueSkyWarrior/face.png', '../../../resources//images/feh/acter/Hinoka_F_BlueSkyWarrior/q.png', '../../../resources//images/feh/acter/Hinoka_F_BlueSkyWarrior/normal.png', '../../../resources//images/feh/acter/Hinoka_F_BlueSkyWarrior/attact.png', '../../../resources//images/feh/acter/Hinoka_F_BlueSkyWarrior/extra.png', '../../../resources//images/feh/acter/Hinoka_F_BlueSkyWarrior/break.png', '37', '46', '38', '20', '25', null, null, null, null, null, '战姬的和弓', '攻击速度羁绊3', '编队飞行3', '飞刃纹章', null, '拉近', '月光', '3', '14', null, '1', null, '4');
INSERT INTO `feh_character` VALUES ('74', '邪眼之主', '晓之巫女', '妮凯', '', null, null, '../../../resources//images/feh/acter/Nailah_F_UnflinchingEye/face.png', '../../../resources//images/feh/acter/Nailah_F_UnflinchingEye/q.png', '../../../resources//images/feh/acter/Nailah_F_UnflinchingEye/normal.png', '../../../resources//images/feh/acter/Nailah_F_UnflinchingEye/attact.png', '../../../resources//images/feh/acter/Nailah_F_UnflinchingEye/extra.png', '../../../resources//images/feh/acter/Nailah_F_UnflinchingEye/break.png', '40', '45', '37', '32', '23', null, null, null, null, null, '狼女王之牙', '远距离反击', '识破无法反击3', '邪眼', null, '', '', '1', '21', null, '2', null, '2');
INSERT INTO `feh_character` VALUES ('75', '荣耀的塔戈埃尔', '觉醒', '贝尔贝特', '', null, null, '../../../resources//images/feh/acter/Panne_F_ProudTaguel/face.png', '../../../resources//images/feh/acter/Panne_F_ProudTaguel/q.png', '../../../resources//images/feh/acter/Panne_F_ProudTaguel/normal.png', '../../../resources//images/feh/acter/Panne_F_ProudTaguel/attact.png', '../../../resources//images/feh/acter/Panne_F_ProudTaguel/extra.png', '../../../resources//images/feh/acter/Panne_F_ProudTaguel/break.png', '41', '43', '34', '30', '23', null, null, null, null, null, '塔戈埃尔的爪牙', '', '速度封杀3', '防守紫烟3', null, '', '流星', '2', '21', null, '2', null, '2');
INSERT INTO `feh_character` VALUES ('76', '嬉闹狐妖', 'IF', '绢', '', null, null, '../../../resources//images/feh/acter/Selkie_F_FreeSpirit/face.png', '../../../resources//images/feh/acter/Selkie_F_FreeSpirit/q.png', '../../../resources//images/feh/acter/Selkie_F_FreeSpirit/normal.png', '../../../resources//images/feh/acter/Selkie_F_FreeSpirit/attact.png', '../../../resources//images/feh/acter/Selkie_F_FreeSpirit/extra.png', '../../../resources//images/feh/acter/Selkie_F_FreeSpirit/break.png', '35', '43', '38', '16', '41', null, null, null, null, null, '狐妖之女的爪牙', '攻击速度羁绊3', '攻击扰乱3', '魔防之波 偶数3', null, '', '冰苍', '2', '21', null, '2', null, '2');
INSERT INTO `feh_character` VALUES ('77', '雷神', '圣战的系谱', '伊修达尔', '虚假的雷神', null, null, '../../../resources//images/feh/acter/Ishtar_F_ThunderGoddess/face.png', '../../../resources//images/feh/acter/Ishtar_F_ThunderGoddess/q.png', '../../../resources//images/feh/acter/Ishtar_F_ThunderGoddess/normal.png', '../../../resources//images/feh/acter/Ishtar_F_ThunderGoddess/attact.png', '../../../resources//images/feh/acter/Ishtar_F_ThunderGoddess/extra.png', '../../../resources//images/feh/acter/Ishtar_F_ThunderGoddess/break.png', '41', '50', '42', '19', '28', null, null, null, null, null, '雷神之锤', '鬼神飞燕击2', '猛攻3', '攻击之波奇数3', null, '拉近', '月虹', '1', '5', null, '1', '6', '2');
INSERT INTO `feh_character` VALUES ('78', '深蓝的歌手', 'IF', '诗格莱', '', null, null, '../../../resources//images/feh/acter/Shigure_M_DarkSkySinger/face.png', '../../../resources//images/feh/acter/Shigure_M_DarkSkySinger/q.png', '../../../resources//images/feh/acter/Shigure_M_DarkSkySinger/normal.png', '../../../resources//images/feh/acter/Shigure_M_DarkSkySinger/attact.png', '../../../resources//images/feh/acter/Shigure_M_DarkSkySinger/extra.png', '../../../resources//images/feh/acter/Shigure_M_DarkSkySinger/break.png', '37', '44', '29', '24', '24', null, null, null, null, null, '舞会乐章+', 'HP2', '破赤魔者3', '青魔技巧3', null, '再动', '', '1', '5', null, '4', null, '2');
INSERT INTO `feh_character` VALUES ('79', '少女心的悦动', 'IF', '奥菲利亚', '', null, null, '../../../resources//images/feh/acter/Ophelia_F_Normal/face.png', '../../../resources//images/feh/acter/Ophelia_F_Normal/q.png', '../../../resources//images/feh/acter/Ophelia_F_Normal/normal.png', '../../../resources//images/feh/acter/Ophelia_F_Normal/attact.png', '../../../resources//images/feh/acter/Ophelia_F_Normal/extra.png', '../../../resources//images/feh/acter/Ophelia_F_Normal/break.png', '38', '55', '33', '17', '23', null, null, null, null, null, '魔书米斯特丁', '鬼神金刚击2', '魔防封杀3', '防守大纹章2', null, '带回', '烈光', '1', '5', null, '1', null, '2');
INSERT INTO `feh_character` VALUES ('83', '春色的白骑士', '纹章之谜', '卡秋雅', '', null, null, '../../../resources//images/feh/acter/Katua_F_SpringFes18/face.png', '../../../resources//images/feh/acter/Katua_F_SpringFes18/q.png', '../../../resources//images/feh/acter/Katua_F_SpringFes18/normal.png', '../../../resources//images/feh/acter/Katua_F_SpringFes18/attact.png', '../../../resources//images/feh/acter/Katua_F_SpringFes18/extra.png', '../../../resources//images/feh/acter/Katua_F_SpringFes18/break.png', '36', '42', '35', '18', '26', null, null, null, null, null, '苍蓝之刃+', '飞燕一击3', '猛攻3', '骑刃鼓舞', null, '拉近', '月虹', '2', '5', null, '4', null, '2');
INSERT INTO `feh_character` VALUES ('85', '白骑的次女', '纹章之谜', '卡秋雅', '', null, null, '../../../resources//images/feh/acter/Katua_F_Normal/face.png', '../../../resources//images/feh/acter/Katua_F_Normal/q.png', '../../../resources//images/feh/acter/Katua_F_Normal/normal.png', '../../../resources//images/feh/acter/Katua_F_Normal/attact.png', '../../../resources//images/feh/acter/Katua_F_Normal/extra.png', '../../../resources//images/feh/acter/Katua_F_Normal/break.png', '40', '50', '35', '29', '25', null, null, null, null, null, '白骑的直枪', '飞燕一击3', '破剑者3', '飞盾鼓舞', null, '带回', '月光', '3', '2', null, '4', '1', '2');
INSERT INTO `feh_character` VALUES ('86', '白骑的幺女', '纹章之谜', '爱丝特', '', null, null, '../../../resources//images/feh/acter/Est_F_Normal/face.png', '../../../resources//images/feh/acter/Est_F_Normal/q.png', '../../../resources//images/feh/acter/Est_F_Normal/normal.png', '../../../resources//images/feh/acter/Est_F_Normal/attact.png', '../../../resources//images/feh/acter/Est_F_Normal/extra.png', '../../../resources//images/feh/acter/Est_F_Normal/break.png', '38', '55', '31', '25', '33', null, null, null, null, null, '白骑的短枪', '鬼神一击3', '破枪者3', '飞盾纹章', null, '带回', '星影', '3', '2', null, '1', '3', '2');
INSERT INTO `feh_character` VALUES ('87', '雷神的亲信', '多拉基亚776', '莱因哈特', '真实的雷神', null, null, '../../../resources//images/feh/acter/Reinhardt_M_Normal/face.png', '../../../resources//images/feh/acter/Reinhardt_M_Normal/q.png', '../../../resources//images/feh/acter/Reinhardt_M_Normal/normal.png', '../../../resources//images/feh/acter/Reinhardt_M_Normal/attact.png', '../../../resources//images/feh/acter/Reinhardt_M_Normal/extra.png', '../../../resources//images/feh/acter/Reinhardt_M_Normal/break.png', '43', '46', '20', '29', '27', null, null, null, null, null, '神雷', '鬼神一击3', '破枪者3', '骑刃纹章', null, '拉近', '烈雷', '2', '5', null, '1', '5', '2');
INSERT INTO `feh_character` VALUES ('88', '蓝色魔道骑士', '多拉基亚776', '欧尔玟', '', null, null, '../../../resources//images/feh/acter/Olwen_F_Normal/face.png', '../../../resources//images/feh/acter/Olwen_F_Normal/q.png', '../../../resources//images/feh/acter/Olwen_F_Normal/normal.png', '../../../resources//images/feh/acter/Olwen_F_Normal/attact.png', '../../../resources//images/feh/acter/Olwen_F_Normal/extra.png', '../../../resources//images/feh/acter/Olwen_F_Normal/break.png', '35', '40', '30', '20', '31', null, null, null, null, null, '神雷', '强化互克3', '破赤魔者', '骑盾鼓舞', null, '带回', '天空', '2', '5', null, '2', '2', '2');
INSERT INTO `feh_character` VALUES ('89', '绿色魔道骑士', '多拉基亚776', '欧尔玟', '', null, null, '../../../resources//images/feh/acter/Olwen_F_RighteousKnight/face.png', '../../../resources//images/feh/acter/Olwen_F_RighteousKnight/q.png', '../../../resources//images/feh/acter/Olwen_F_RighteousKnight/normal.png', '../../../resources//images/feh/acter/Olwen_F_RighteousKnight/attact.png', '../../../resources//images/feh/acter/Olwen_F_RighteousKnight/extra.png', '../../../resources//images/feh/acter/Olwen_F_RighteousKnight/break.png', '35', '45', '39', '19', '28', null, null, null, null, null, '雷旋之书', '鬼神飞燕击2', '猛攻3', '骑盾纹章', null, '带回', '太阳', '2', '6', null, '2', '2', '3');
INSERT INTO `feh_character` VALUES ('90', '来自异界的少女', '觉醒', '马可', '', null, null, '../../../resources//images/feh/acter/Morgan_F_LassfromAfar/face.png', '../../../resources//images/feh/acter/Morgan_F_LassfromAfar/q.png', '../../../resources//images/feh/acter/Morgan_F_LassfromAfar/normal.png', '../../../resources//images/feh/acter/Morgan_F_LassfromAfar/attact.png', '../../../resources//images/feh/acter/Morgan_F_LassfromAfar/extra.png', '../../../resources//images/feh/acter/Morgan_F_LassfromAfar/break.png', '39', '49', '30', '16', '33', null, null, null, null, null, '苍蓝海蛇+', '鬼神明镜架势2', '', '攻击谋策3', null, '', '冰点', '3', '5', null, '3', null, '2');
INSERT INTO `feh_character` VALUES ('91', '第一次的暑假', 'IF', '神威', '', null, null, '../../../resources//images/feh/acter/Kamui_F_Swim17/face.png', '../../../resources//images/feh/acter/Kamui_F_Swim17/q.png', '../../../resources//images/feh/acter/Kamui_F_Swim17/normal.png', '../../../resources//images/feh/acter/Kamui_F_Swim17/attact.png', '../../../resources//images/feh/acter/Kamui_F_Swim17/extra.png', '../../../resources//images/feh/acter/Kamui_F_Swim17/break.png', '39', '43', '36', '19', '26', null, null, null, null, null, '热带鱼之书', '飞燕明镜击2', '猛攻3', '飞盾鼓舞', null, '拉近', '龙穿', '3', '5', null, '4', null, '2');
INSERT INTO `feh_character` VALUES ('92', '炎祸之魂的悸哭', 'IF', '神威', '', null, null, '../../../resources//images/feh/acter/Kamui_F_Wailing Soul/face.png', '../../../resources//images/feh/acter/Kamui_F_Wailing Soul/q.png', '../../../resources//images/feh/acter/Kamui_F_Wailing Soul/normal.png', '../../../resources//images/feh/acter/Kamui_F_Wailing Soul/attact.png', '../../../resources//images/feh/acter/Kamui_F_Wailing Soul/extra.png', '../../../resources//images/feh/acter/Kamui_F_Wailing Soul/break.png', '43', '48', '37', '31', '30', null, null, null, null, null, '暴乱吐息', '攻击速度孤军3', '恐慌错乱3', '', null, '拉近', '龙穿', '1', '10', null, '1', null, '4');
INSERT INTO `feh_character` VALUES ('93', '梦想的公主', 'IF', '神威', '', null, null, '../../../resources//images/feh/acter/Kamui_F_Dream/face.png', '../../../resources//images/feh/acter/Kamui_F_Dream/q.png', '../../../resources//images/feh/acter/Kamui_F_Dream/normal.png', '../../../resources//images/feh/acter/Kamui_F_Dream/attact.png', '../../../resources//images/feh/acter/Kamui_F_Dream/extra.png', '../../../resources//images/feh/acter/Kamui_F_Dream/break.png', '38', '47', '37', '35', '27', null, null, null, null, null, '水之飞沫', '攻击速度羁绊3', '', '龙盾鼓舞', null, '攻击速度支援+', '龙裂', '1', '9', null, '1', null, '3');
INSERT INTO `feh_character` VALUES ('94', '伟大的佣兵', '苍炎轨迹', '艾克', '总选举', null, null, '../../../resources//images/feh/acter/Ike_M_ELECTION01/face.png', '../../../resources//images/feh/acter/Ike_M_ELECTION01/q.png', '../../../resources//images/feh/acter/Ike_M_ELECTION01/normal.png', '../../../resources//images/feh/acter/Ike_M_ELECTION01/attact.png', '../../../resources//images/feh/acter/Ike_M_ELECTION01/extra.png', '../../../resources//images/feh/acter/Ike_M_ELECTION01/break.png', '17', '26', '5', '10', '5', null, null, null, null, null, '乌尔邦', '金刚呼吸', '贝欧克的加护', '防守威吓3', null, '带回', '天空', '1', '3', null, '1', null, '3');
INSERT INTO `feh_character` VALUES ('95', '佣兵团的副团长', '苍炎轨迹', '狄亚马特', '', null, null, '../../../resources//images/feh/acter/Tiamat_F_Normal/face.png', '../../../resources//images/feh/acter/Tiamat_F_Normal/q.png', '../../../resources//images/feh/acter/Tiamat_F_Normal/normal.png', '../../../resources//images/feh/acter/Tiamat_F_Normal/attact.png', '../../../resources//images/feh/acter/Tiamat_F_Normal/extra.png', '../../../resources//images/feh/acter/Tiamat_F_Normal/break.png', '43', '48', '38', '25', '31', null, null, null, null, null, '佣兵团的战斧', '强化互克3', '破枪者3', '骑刃鼓舞', null, '拉近', '凶星', '2', '3', null, '4', '2', '3');
INSERT INTO `feh_character` VALUES ('96', '纯白王子', '晓之巫女', '琉希昂', '', null, null, '../../../resources//images/feh/acter/Reyson_M_WhitePrince/face.png', '../../../resources//images/feh/acter/Reyson_M_WhitePrince/q.png', '../../../resources//images/feh/acter/Reyson_M_WhitePrince/normal.png', '../../../resources//images/feh/acter/Reyson_M_WhitePrince/attact.png', '../../../resources//images/feh/acter/Reyson_M_WhitePrince/extra.png', '../../../resources//images/feh/acter/Reyson_M_WhitePrince/break.png', '37', '43', '37', '28', '22', null, null, null, null, null, '白鹭之翼', '飞燕金刚架势2', '救援行路3', '兽盾鼓舞', null, '再动', '', '3', '22', null, '2', '0', '3');
INSERT INTO `feh_character` VALUES ('97', '微笑的赠礼', '封印之剑', '法', '', null, null, '../../../resources//images/feh/acter/Fa_F_Xmas/face.png', '../../../resources//images/feh/acter/Fa_F_Xmas/q.png', '../../../resources//images/feh/acter/Fa_F_Xmas/normal.png', '../../../resources//images/feh/acter/Fa_F_Xmas/attact.png', '../../../resources//images/feh/acter/Fa_F_Xmas/extra.png', '../../../resources//images/feh/acter/Fa_F_Xmas/break.png', '45', '49', '26', '30', '45', null, null, null, null, null, '绮罗星吐息+', '防守魔防的羁绊3', '迎击队形3', '重盾纹章', null, '替换', '月光', '4', '9', null, '3', '0', '3');
INSERT INTO `feh_character` VALUES ('98', '邪龙现身', '觉醒', '鲁弗莱', '', null, null, '../../../resources//images/feh/acter/Robin_M_FellReincarnation/face.png', '../../../resources//images/feh/acter/Robin_M_FellReincarnation/q.png', '../../../resources//images/feh/acter/Robin_M_FellReincarnation/normal.png', '../../../resources//images/feh/acter/Robin_M_FellReincarnation/attact.png', '../../../resources//images/feh/acter/Robin_M_FellReincarnation/extra.png', '../../../resources//images/feh/acter/Robin_M_FellReincarnation/break.png', '52', '57', '24', '38', '27', null, null, null, null, null, '邪龙吐息', '防守3', '迎击队形3', '重盾纹章', null, '替换', '华炎', '4', '9', null, '2', '1', '3');
INSERT INTO `feh_character` VALUES ('99', '邪龙应身', '觉醒', '鲁弗莱', '', null, null, '../../../resources//images/feh/acter/Robin_F_FellReincarnation/face.png', '../../../resources//images/feh/acter/Robin_F_FellReincarnation/q.png', '../../../resources//images/feh/acter/Robin_F_FellReincarnation/normal.png', '../../../resources//images/feh/acter/Robin_F_FellReincarnation/attact.png', '../../../resources//images/feh/acter/Robin_F_FellReincarnation/extra.png', '../../../resources//images/feh/acter/Robin_F_FellReincarnation/break.png', '41', '48', '39', '30', '25', null, null, null, null, null, '邪龙吐息', '邪龙之鳞', '埋伏3', '飞刃纹章', null, '替换', '天空', '3', '10', null, '2', '1', '4');
INSERT INTO `feh_character` VALUES ('100', '收获祭的女忍者', 'IF', '阳炎', '', null, null, '../../../resources//images/feh/acter/Kagero_F_BeverageNinja/face.png', '../../../resources//images/feh/acter/Kagero_F_BeverageNinja/q.png', '../../../resources//images/feh/acter/Kagero_F_BeverageNinja/normal.png', '../../../resources//images/feh/acter/Kagero_F_BeverageNinja/attact.png', '../../../resources//images/feh/acter/Kagero_F_BeverageNinja/extra.png', '../../../resources//images/feh/acter/Kagero_F_BeverageNinja/break.png', '18', '24', '4', '9', '9', null, null, null, null, null, '玻璃瓶果汁+', '鬼神明镜击2', '攻击队形3', '攻击之波偶数3', null, '替换', '龙裂', '4', '17', null, '2', null, '3');
INSERT INTO `feh_character` VALUES ('101', '春色的女忍者', '', '阳炎', '', null, null, '../../../resources//images/feh/acter/Kagerou_F_SpringFes18/face.png', '../../../resources//images/feh/acter/Kagerou_F_SpringFes18/q.png', '../../../resources//images/feh/acter/Kagerou_F_SpringFes18/normal.png', '../../../resources//images/feh/acter/Kagerou_F_SpringFes18/attact.png', '../../../resources//images/feh/acter/Kagerou_F_SpringFes18/extra.png', '../../../resources//images/feh/acter/Kagerou_F_SpringFes18/break.png', '33', '47', '34', '21', '27', null, null, null, null, null, '致命卡罗特+', '速度魔防羁绊3', '荣誉之喜悦', '攻击纹章3', null, '带回', '星影', '3', '18', null, '4', null, '4');
INSERT INTO `feh_character` VALUES ('102', '夏季天空的公主', '晓之巫女', '艾琳西亚', '', null, null, '../../../resources//images/feh/acter/Erincia_F_EstivalPrincess/face.png', '../../../resources//images/feh/acter/Erincia_F_EstivalPrincess/q.png', '../../../resources//images/feh/acter/Erincia_F_EstivalPrincess/normal.png', '../../../resources//images/feh/acter/Erincia_F_EstivalPrincess/attact.png', '../../../resources//images/feh/acter/Erincia_F_EstivalPrincess/extra.png', '../../../resources//images/feh/acter/Erincia_F_EstivalPrincess/break.png', '36', '41', '35', '26', '18', null, null, null, null, null, '绿云舞扇+', '攻击速度的奋击3', '疾风大地之舞', '魔防大纹章2', null, '再动', '', '1', '17', null, '1', null, '3');
INSERT INTO `feh_character` VALUES ('103', '魔道娇子', '烈火之剑', '尼诺', '', null, null, '../../../resources//images/feh/acter/Nino_F_Normal/face.png', '../../../resources//images/feh/acter/Nino_F_Normal/q.png', '../../../resources//images/feh/acter/Nino_F_Normal/normal.png', '../../../resources//images/feh/acter/Nino_F_Normal/attact.png', '../../../resources//images/feh/acter/Nino_F_Normal/extra.png', '../../../resources//images/feh/acter/Nino_F_Normal/break.png', '38', '55', '44', '29', '34', null, null, null, null, null, '艾莉丝之书', '狮子奋迅3', '猛攻3', '攻击鼓舞3', null, '速度魔防支援', '天空', '1', '6', null, '1', '10', '3');
INSERT INTO `feh_character` VALUES ('104', '幽暗的白花', '烈火之剑', '尼诺', '', null, null, '../../../resources//images/feh/acter/Nino_F_PaleFlower/face.png', '../../../resources//images/feh/acter/Nino_F_PaleFlower/q.png', '../../../resources//images/feh/acter/Nino_F_PaleFlower/normal.png', '../../../resources//images/feh/acter/Nino_F_PaleFlower/attact.png', '../../../resources//images/feh/acter/Nino_F_PaleFlower/extra.png', '../../../resources//images/feh/acter/Nino_F_PaleFlower/break.png', '36', '43', '41', '17', '25', null, null, null, null, null, '翠绿之书+', '鬼神飞燕击2', '猛攻3', '飞盾纹章', null, '拉近', '月虹', '3', '6', null, '3', '0', '3');
INSERT INTO `feh_character` VALUES ('105', '苍穹的舞者', '觉醒', '阿兹尔', '', null, null, '../../../resources//images/feh/acter/Inigo_M_IndigoDancer/face.png', '../../../resources//images/feh/acter/Inigo_M_IndigoDancer/q.png', '../../../resources//images/feh/acter/Inigo_M_IndigoDancer/normal.png', '../../../resources//images/feh/acter/Inigo_M_IndigoDancer/attact.png', '../../../resources//images/feh/acter/Inigo_M_IndigoDancer/extra.png', '../../../resources//images/feh/acter/Inigo_M_IndigoDancer/break.png', '39', '40', '30', '25', '23', null, null, null, null, null, '舞会之环+', '', '疾风之舞3', '攻击鼓舞3', null, '再动', '', '1', '6', null, '2', null, '3');
INSERT INTO `feh_character` VALUES ('106', '滋味酸甜的赠礼', '封印之剑', '莉莉娜', '', null, null, '../../../resources//images/feh/acter/Lilina_F_Valentine18/face.png', '../../../resources//images/feh/acter/Lilina_F_Valentine18/q.png', '../../../resources//images/feh/acter/Lilina_F_Valentine18/normal.png', '../../../resources//images/feh/acter/Lilina_F_Valentine18/attact.png', '../../../resources//images/feh/acter/Lilina_F_Valentine18/extra.png', '../../../resources//images/feh/acter/Lilina_F_Valentine18/break.png', '43', '50', '26', '20', '26', null, null, null, null, null, '绿之礼品箱+', 'HP攻击2', '破枪者3', '攻击指挥3', null, '拉近', '碎火', '2', '6', null, '2', null, '3');
INSERT INTO `feh_character` VALUES ('107', '王国之女', '封印之剑', '瑟西利亚', '', null, null, '../../../resources//images/feh/acter/Secilia_F_Normal/face.png', '../../../resources//images/feh/acter/Secilia_F_Normal/q.png', '../../../resources//images/feh/acter/Secilia_F_Normal/normal.png', '../../../resources//images/feh/acter/Secilia_F_Normal/attact.png', '../../../resources//images/feh/acter/Secilia_F_Normal/extra.png', '../../../resources//images/feh/acter/Secilia_F_Normal/break.png', '41', '53', '37', '29', '36', null, null, null, null, null, '翠绿之刃+', '狮子奋迅3', '猛攻3', '骑盾纹章', null, '速度防守支援', '天空', '2', '6', null, '4', '10', '3');
INSERT INTO `feh_character` VALUES ('108', '新娘打扮的神使', '苍炎轨迹', '莎娜琪', '', null, null, '../../../resources//images/feh/acter/Sanaki_F_ApostleinWhite/face.png', '../../../resources//images/feh/acter/Sanaki_F_ApostleinWhite/q.png', '../../../resources//images/feh/acter/Sanaki_F_ApostleinWhite/normal.png', '../../../resources//images/feh/acter/Sanaki_F_ApostleinWhite/attact.png', '../../../resources//images/feh/acter/Sanaki_F_ApostleinWhite/extra.png', '../../../resources//images/feh/acter/Sanaki_F_ApostleinWhite/break.png', '35', '53', '26', '19', '33', null, null, null, null, null, '尼福尔之冰花', '攻击魔防羁绊3', '猛攻3', '飞盾纹章', null, '拉近', '太阳', '3', '6', null, '2', null, '3');
INSERT INTO `feh_character` VALUES ('109', '苏醒的负之女神', '晓之巫女', '芸娜', '', null, null, '../../../resources//images/feh/acter/Yune_F_haosGoddess/face.png', '../../../resources//images/feh/acter/Yune_F_haosGoddess/q.png', '../../../resources//images/feh/acter/Yune_F_haosGoddess/normal.png', '../../../resources//images/feh/acter/Yune_F_haosGoddess/attact.png', '../../../resources//images/feh/acter/Yune_F_haosGoddess/extra.png', '../../../resources//images/feh/acter/Yune_F_haosGoddess/break.png', '41', '47', '23', '15', '42', null, null, null, null, null, '负之力', '攻击魔防', '魔防扰乱3', '吾之名为混沌', null, '带回', '冰华', '3', '6', null, '2', null, '3');
INSERT INTO `feh_character` VALUES ('110', '加利亚的狮子王', '晓之巫女', '凯内基斯', '', null, null, '../../../resources//images/feh/acter/Caineghis_M_GalliaLionKing/face.png', '../../../resources//images/feh/acter/Caineghis_M_GalliaLionKing/q.png', '../../../resources//images/feh/acter/Caineghis_M_GalliaLionKing/normal.png', '../../../resources//images/feh/acter/Caineghis_M_GalliaLionKing/attact.png', '../../../resources//images/feh/acter/Caineghis_M_GalliaLionKing/extra.png', '../../../resources//images/feh/acter/Caineghis_M_GalliaLionKing/break.png', '50', '54', '20', '37', '30', null, null, null, null, null, '狮子王的爪牙', '远距离防御3', '迎击队形3', '远距离警戒3', null, '替换', '绯炎', '4', '23', null, '2', null, '4');
INSERT INTO `feh_character` VALUES ('111', '美丽的歌姬', '晓之巫女', '莉娅妮', '', null, null, '../../../resources//images/feh/acter/Leanne_F_ForestSong/face.png', '../../../resources//images/feh/acter/Leanne_F_ForestSong/q.png', '../../../resources//images/feh/acter/Leanne_F_ForestSong/normal.png', '../../../resources//images/feh/acter/Leanne_F_ForestSong/attact.png', '../../../resources//images/feh/acter/Leanne_F_ForestSong/extra.png', '../../../resources//images/feh/acter/Leanne_F_ForestSong/break.png', '36', '44', '37', '16', '34', null, null, null, null, null, '白鹭之翼', '鬼神明镜架势2', '编队飞行3', '兽刃鼓舞', null, '再动', '', '3', '23', null, '2', null, '4');
INSERT INTO `feh_character` VALUES ('112', '力之神', '索菲亚的复苏', '多玛', '', null, null, '../../../resources//images/feh/acter/Duma_M_GodofStrength/face.png', '../../../resources//images/feh/acter/Duma_M_GodofStrength/q.png', '../../../resources//images/feh/acter/Duma_M_GodofStrength/normal.png', '../../../resources//images/feh/acter/Duma_M_GodofStrength/attact.png', '../../../resources//images/feh/acter/Duma_M_GodofStrength/extra.png', '../../../resources//images/feh/acter/Duma_M_GodofStrength/break.png', '48', '63', '18', '34', '31', null, null, null, null, null, '邪神吐息', '防守魔防孤军3', '攻击队形3', '超级地震', null, '替换', '龙裂', '4', '10', null, '4', null, '4');
INSERT INTO `feh_character` VALUES ('113', '春祭嬉戏', '英雄', '洛基', '', null, null, '../../../resources//images/feh/acter/Loki_F_pringTrickster/face.png', '../../../resources//images/feh/acter/Loki_F_pringTrickster/q.png', '../../../resources//images/feh/acter/Loki_F_pringTrickster/normal.png', '../../../resources//images/feh/acter/Loki_F_pringTrickster/attact.png', '../../../resources//images/feh/acter/Loki_F_pringTrickster/extra.png', '../../../resources//images/feh/acter/Loki_F_pringTrickster/break.png', '41', '43', '36', '27', '25', null, null, null, null, null, '春之妖弓', '飞燕一击3', '编队飞行3', '飞刃纹章', null, '带回', '月光', '3', '14', null, null, null, '4');
INSERT INTO `feh_character` VALUES ('114', '温泉蒸汽的秘密', 'IF', '卡米拉', '', null, null, '../../../resources//images/feh/acter/Camilla_F_Furo/face.png', '../../../resources//images/feh/acter/Camilla_F_Furo/q.png', '../../../resources//images/feh/acter/Camilla_F_Furo/normal.png', '../../../resources//images/feh/acter/Camilla_F_Furo/attact.png', '../../../resources//images/feh/acter/Camilla_F_Furo/extra.png', '../../../resources//images/feh/acter/Camilla_F_Furo/break.png', '38', '47', '37', '17', '28', null, null, null, null, null, '束口袋', '攻击速度2', '', '飞刃鼓舞', null, '', '星影', '3', '18', null, null, null, '4');
INSERT INTO `feh_character` VALUES ('115', '庆典的舞姬', '觉醒', '奥利薇', '', null, null, '../../../resources//images/feh/acter/Olivie_F_Festival/face.png', '../../../resources//images/feh/acter/Olivie_F_Festival/q.png', '../../../resources//images/feh/acter/Olivie_F_Festival/normal.png', '../../../resources//images/feh/acter/Olivie_F_Festival/attact.png', '../../../resources//images/feh/acter/Olivie_F_Festival/extra.png', '../../../resources//images/feh/acter/Olivie_F_Festival/break.png', '38', '38', '31', '16', '28', null, null, null, null, null, '舞会折扇+', '远距离防御3', '业火之舞3', '攻击纹章3', null, '再动', '', '1', '18', null, '2', null, '4');
INSERT INTO `feh_character` VALUES ('116', '冬祭的导览', '封印之剑', '瑟西利亚', '', null, null, '../../../resources//images/feh/acter/Secilia_F_Xmas/face.png', '../../../resources//images/feh/acter/Secilia_F_Xmas/q.png', '../../../resources//images/feh/acter/Secilia_F_Xmas/normal.png', '../../../resources//images/feh/acter/Secilia_F_Xmas/attact.png', '../../../resources//images/feh/acter/Secilia_F_Xmas/extra.png', '../../../resources//images/feh/acter/Secilia_F_Xmas/break.png', '41', '47', '23', '30', '36', null, null, null, null, null, '冬祭之靴+', '攻击魔防羁绊3', '防守队形3', '防守谋策3', null, '替换', '冰苍', '4', '18', null, '1', null, '4');
INSERT INTO `feh_character` VALUES ('117', '拂过梦境的慈母', 'IF', '水琴', '', null, null, '../../../resources//images/feh/acter/Mitsukoto_F_Normal/face.png', '../../../resources//images/feh/acter/Mitsukoto_F_Normal/q.png', '../../../resources//images/feh/acter/Mitsukoto_F_Normal/normal.png', '../../../resources//images/feh/acter/Mitsukoto_F_Normal/attact.png', '../../../resources//images/feh/acter/Mitsukoto_F_Normal/extra.png', '../../../resources//images/feh/acter/Mitsukoto_F_Normal/break.png', '34', '46', '32', '20', '30', null, null, null, null, null, '闪烁+', '攻击魔防大觉醒3', '', '步行之刚击3', null, '殉教+', '祈祷', '1', '19', null, '1', null, '4');
INSERT INTO `feh_character` VALUES ('118', '温柔之雪', '圣魔光石', '艾莉柯', '', null, null, '../../../resources//images/feh/acter/Eirik_F_Xmas/face.png', '../../../resources//images/feh/acter/Eirik_F_Xmas/q.png', '../../../resources//images/feh/acter/Eirik_F_Xmas/normal.png', '../../../resources//images/feh/acter/Eirik_F_Xmas/attact.png', '../../../resources//images/feh/acter/Eirik_F_Xmas/extra.png', '../../../resources//images/feh/acter/Eirik_F_Xmas/break.png', '39', '54', '23', '30', '34', null, null, null, null, null, '提灯之杖+', '攻击3', '幻惑之杖3', '重刃鼓舞', null, '休息+', '天照', '4', '19', null, '3', null, '4');
INSERT INTO `feh_character` VALUES ('119', '野丫头公主', '圣战的系谱', '艾丝琳', '', null, null, '../../../resources//images/feh/acter/Asilin_F_Normal/face.png', '../../../resources//images/feh/acter/Asilin_F_Normal/q.png', '../../../resources//images/feh/acter/Asilin_F_Normal/normal.png', '../../../resources//images/feh/acter/Asilin_F_Normal/attact.png', '../../../resources//images/feh/acter/Asilin_F_Normal/extra.png', '../../../resources//images/feh/acter/Asilin_F_Normal/break.png', '38', '40', '34', '26', '20', null, null, null, null, null, '恐惧+', '速度防守羁绊3', '奉献之喜悦3', '骑盾鼓舞', null, '远程圣疗+', '天照', '3', '19', null, '4', null, '4');
INSERT INTO `feh_character` VALUES ('120', '最喜欢麻薯汤', 'IF', '拓海', '', null, null, '../../../resources//images/feh/acter/Takumi_M_PrinceofSoup/face.png', '../../../resources//images/feh/acter/Takumi_M_PrinceofSoup/q.png', '../../../resources//images/feh/acter/Takumi_M_PrinceofSoup/normal.png', '../../../resources//images/feh/acter/Takumi_M_PrinceofSoup/attact.png', '../../../resources//images/feh/acter/Takumi_M_PrinceofSoup/extra.png', '../../../resources//images/feh/acter/Takumi_M_PrinceofSoup/break.png', '42', '49', '34', '13', '30', null, null, null, null, null, '镜饼麻薯+', '攻击魔防羁绊3', '破弓者3', '', null, '', '月虹', '1', '18', null, '1', null, '4');
INSERT INTO `feh_character` VALUES ('121', '古风之忍', 'IF', '阳炎', '', null, null, '../../../resources//images/feh/acter/Kagero_F_HonorableNinja/face.png', '../../../resources//images/feh/acter/Kagero_F_HonorableNinja/q.png', '../../../resources//images/feh/acter/Kagero_F_HonorableNinja/normal.png', '../../../resources//images/feh/acter/Kagero_F_HonorableNinja/attact.png', '../../../resources//images/feh/acter/Kagero_F_HonorableNinja/extra.png', '../../../resources//images/feh/acter/Kagero_F_HonorableNinja/break.png', null, null, null, null, null, null, null, null, null, null, '秘毒暗器', '明镜一击3', '破暗器者3', '', null, '', '血仇', '1', '18', null, null, null, '4');
INSERT INTO `feh_character` VALUES ('122', '神龙王', '觉醒', '那迦', '', null, null, '../../../resources//images/feh/acter/Naga_Dragon Divinity/face.png', '../../../resources//images/feh/acter/Naga_Dragon Divinity/q.png', '../../../resources//images/feh/acter/Naga_Dragon Divinity/normal.png', '../../../resources//images/feh/acter/Naga_Dragon Divinity/attact.png', '../../../resources//images/feh/acter/Naga_Dragon Divinity/extra.png', '../../../resources//images/feh/acter/Naga_Dragon Divinity/break.png', '38', '53', '37', '34', '26', null, null, null, null, null, '神龙王吐息', '攻击速度的攻城战3', '速度封杀3', '神龙王之牙', null, '带回', '月光', '3', '8', null, null, '2', '2');
INSERT INTO `feh_character` VALUES ('123', '真挚的思恋', '晓之巫女', '塔妮丝', '', null, null, '../../../resources//images/feh/acter/Tanith_Forthright Heart/face.png', '../../../resources//images/feh/acter/Tanith_Forthright Heart/q.png', '../../../resources//images/feh/acter/Tanith_Forthright Heart/normal.png', '../../../resources//images/feh/acter/Tanith_Forthright Heart/attact.png', '../../../resources//images/feh/acter/Tanith_Forthright Heart/extra.png', '../../../resources//images/feh/acter/Tanith_Forthright Heart/break.png', '37', '51', '36', '33', '18', null, null, null, null, null, '花柱+', '鬼神飞燕击2', '救援行路3', '飞盾鼓舞', null, '带回', '月光', '3', '2', null, '4', '0', '2');
INSERT INTO `feh_character` VALUES ('124', '忠义的新娘', '晓之巫女', '希葛伦', '', null, null, '../../../resources//images/feh/acter/Sigrun_Steadfast Bride/face.png', '../../../resources//images/feh/acter/Sigrun_Steadfast Bride/q.png', '../../../resources//images/feh/acter/Sigrun_Steadfast Bride/normal.png', '../../../resources//images/feh/acter/Sigrun_Steadfast Bride/attact.png', '../../../resources//images/feh/acter/Sigrun_Steadfast Bride/extra.png', '../../../resources//images/feh/acter/Sigrun_Steadfast Bride/break.png', '39', '45', '38', '23', '31', null, null, null, null, null, '蛋糕刀+', '速度防守的守城战3', '', '前导传令.天3', null, '拉近', '星影', '3', '1', null, '4', '0', '1');
INSERT INTO `feh_character` VALUES ('125', '永恒的奉献', '烈火之剑', '露易丝', '', null, null, '../../../resources//images/feh/acter/Louise_Eternal Devotion/face.png', '../../../resources//images/feh/acter/Louise_Eternal Devotion/q.png', '../../../resources//images/feh/acter/Louise_Eternal Devotion/normal.png', '../../../resources//images/feh/acter/Louise_Eternal Devotion/attact.png', '../../../resources//images/feh/acter/Louise_Eternal Devotion/extra.png', '../../../resources//images/feh/acter/Louise_Eternal Devotion/break.png', '41', '43', '36', '17', '31', null, null, null, null, null, '祝福之花弓+', '攻击速度羁绊3', '破赤魔者', '骑刃鼓舞', null, '带回', '新月', '2', '14', null, '4', '1', '4');
INSERT INTO `feh_character` VALUES ('126', '盛夏的女爵', '烈火之剑', '琳迪斯', '', null, null, '../../../resources//images/feh/acter/Lin_F_LadyOfTheBeach/face.png', '../../../resources//images/feh/acter/Lin_F_LadyOfTheBeach/q.png', '../../../resources//images/feh/acter/Lin_F_LadyOfTheBeach/normal.png', '../../../resources//images/feh/acter/Lin_F_LadyOfTheBeach/attact.png', '../../../resources//images/feh/acter/Lin_F_LadyOfTheBeach/extra.png', '../../../resources//images/feh/acter/Lin_F_LadyOfTheBeach/break.png', '37', '47', '44', '17', '27', null, null, null, null, null, '远海之苍弓', '鬼神金刚瞬击', '攻击速度连动3', '远距离警戒3', null, '带回', '', '3', '12', null, null, null, '2');
INSERT INTO `feh_character` VALUES ('127', '夏日的苍鸦', '烈火之剑', '乌露丝拉', '', null, null, '../../../resources//images/feh/acter/Ursula_F_ClearBlueCrow/face.png', '../../../resources//images/feh/acter/Ursula_F_ClearBlueCrow/q.png', '../../../resources//images/feh/acter/Ursula_F_ClearBlueCrow/normal.png', '../../../resources//images/feh/acter/Ursula_F_ClearBlueCrow/attact.png', '../../../resources//images/feh/acter/Ursula_F_ClearBlueCrow/extra.png', '../../../resources//images/feh/acter/Ursula_F_ClearBlueCrow/break.png', '37', '49', '37', '16', '28', null, null, null, null, null, '贝壳匕首+', '', '防守魔防大共谋3', '魔防之波 偶数3', null, '', '', '2', '18', null, null, '1', '4');
INSERT INTO `feh_character` VALUES ('128', '传承英雄王', '纹章之谜', '马尔斯', '', null, null, '../../../resources//images/feh/acter/Marth_Hero_King/face.png', '../../../resources//images/feh/acter/Marth_Hero_King/q.png', '../../../resources//images/feh/acter/Marth_Hero_King/normal.png', '../../../resources//images/feh/acter/Marth_Hero_King/attact.png', '../../../resources//images/feh/acter/Marth_Hero_King/extra.png', '../../../resources//images/feh/acter/Marth_Hero_King/break.png', '41', '54', '40', '33', '21', null, null, null, null, null, '神剑法尔西昂', '攻击速度羁绊3', '封印之盾', '步行的柔击3', null, '', '龙裂', '1', '1', null, '2', '2', '1');
INSERT INTO `feh_character` VALUES ('129', '瓦莲的舞娘', '', '菲娜', '', null, null, '../../../resources//images/feh/acter/Phina_Roving_Dancer/face.png', '../../../resources//images/feh/acter/Phina_Roving_Dancer/q.png', '../../../resources//images/feh/acter/Phina_Roving_Dancer/normal.png', '../../../resources//images/feh/acter/Phina_Roving_Dancer/attact.png', '../../../resources//images/feh/acter/Phina_Roving_Dancer/extra.png', '../../../resources//images/feh/acter/Phina_Roving_Dancer/break.png', '41', '54', '41', '26', '23', null, null, null, null, null, '刺剑', '速度防守密集', '大地净水之舞2', '', null, '再动', '', '1', '1', null, null, '1', '1');
INSERT INTO `feh_character` VALUES ('130', '冰刃王子', '', '佛利兹', '', null, null, '../../../resources//images/feh/acter/Hríd_Icy_Blade/face.png', '../../../resources//images/feh/acter/Hríd_Icy_Blade/q.png', '../../../resources//images/feh/acter/Hríd_Icy_Blade/normal.png', '../../../resources//images/feh/acter/Hríd_Icy_Blade/attact.png', '../../../resources//images/feh/acter/Hríd_Icy_Blade/extra.png', '../../../resources//images/feh/acter/Hríd_Icy_Blade/break.png', '41', '60', '17', '36', '22', null, null, null, null, null, '吉欧尔', '远距离反击', '冻结之封印', '攻击紫烟', null, '带回', '月虹', '2', '1', null, '3', '0', '1');
INSERT INTO `feh_character` VALUES ('131', '迎春的冰之王子', '英雄', '佛利兹', '', null, null, '../../../resources//images/feh/acter/Hríd_Resolute_Prince/face.png', '../../../resources//images/feh/acter/Hríd_Resolute_Prince/q.png', '../../../resources//images/feh/acter/Hríd_Resolute_Prince/normal.png', '../../../resources//images/feh/acter/Hríd_Resolute_Prince/attact.png', '../../../resources//images/feh/acter/Hríd_Resolute_Prince/extra.png', '../../../resources//images/feh/acter/Hríd_Resolute_Prince/break.png', '41', '60', '17', '36', '22', null, null, null, null, null, '迎春之剑', '攻击防守羁绊3', '回击3', '攻击鼓舞4', null, '替换', '', '3', '1', null, '3', '0', '1');
INSERT INTO `feh_character` VALUES ('132', '盛夏的伊利亚骑士', '', '菲奥拉', '', null, null, '../../../resources//images/feh/acter/Fiora_F_Defrosted_Illian/face.png', '../../../resources//images/feh/acter/Fiora_F_Defrosted_Illian/q.png', '../../../resources//images/feh/acter/Fiora_F_Defrosted_Illian/normal.png', '../../../resources//images/feh/acter/Fiora_F_Defrosted_Illian/attact.png', '../../../resources//images/feh/acter/Fiora_F_Defrosted_Illian/extra.png', '../../../resources//images/feh/acter/Fiora_F_Defrosted_Illian/break.png', '42', '47', '39', '26', '28', null, null, null, null, null, '阳伞+', '', '速度魔防连动3', '攻击紫烟3', null, '替换', '', '3', '1', null, '4', '1', '1');
INSERT INTO `feh_character` VALUES ('133', '伊利斯的圣骑士', '', '库洛武', '', null, null, '../../../resources//images/feh/acter/Chrom_M_Knight_Exalt/face.png', '../../../resources//images/feh/acter/Chrom_M_Knight_Exalt/q.png', '../../../resources//images/feh/acter/Chrom_M_Knight_Exalt/normal.png', '../../../resources//images/feh/acter/Chrom_M_Knight_Exalt/attact.png', '../../../resources//images/feh/acter/Chrom_M_Knight_Exalt/extra.png', '../../../resources//images/feh/acter/Chrom_M_Knight_Exalt/break.png', '44', '53', '31', '37', '20', null, null, null, null, null, '封剑法尔西昂', '狮子奋迅3', '防守封杀3', '剑之技巧3', null, '', '月光', '2', '1', null, '3', '0', '1');
INSERT INTO `feh_character` VALUES ('134', '沉默的村姑', '', '涅菲妮', '', null, null, '../../../resources//images/feh/acter/Nepenee_F_Normal/face.png', '../../../resources//images/feh/acter/Nepenee_F_Normal/q.png', '../../../resources//images/feh/acter/Nepenee_F_Normal/normal.png', '../../../resources//images/feh/acter/Nepenee_F_Normal/attact.png', '../../../resources//images/feh/acter/Nepenee_F_Normal/extra.png', '../../../resources//images/feh/acter/Nepenee_F_Normal/break.png', '41', '53', '38', '35', '20', null, null, null, null, null, '义勇之枪', '攻击速度2', '愤怒3', '攻击紫烟3', null, '带回', '夕阳', '1', '2', null, '1', '2', '2');
INSERT INTO `feh_character` VALUES ('135', '翱翔天际的公主', '', '塔娜', '', null, null, '../../../resources//images/feh/acter/Tana_F_WingedPrincess/face.png', '../../../resources//images/feh/acter/Tana_F_WingedPrincess/q.png', '../../../resources//images/feh/acter/Tana_F_WingedPrincess/normal.png', '../../../resources//images/feh/acter/Tana_F_WingedPrincess/attact.png', '../../../resources//images/feh/acter/Tana_F_WingedPrincess/extra.png', '../../../resources//images/feh/acter/Tana_F_WingedPrincess/break.png', '40', '50', '38', '24', '25', null, null, null, null, null, '维德佛尔尼尔', '速度防守2', '', '空中前导3', null, '', '月虹', '3', '2', null, '4', '0', '2');
INSERT INTO `feh_character` VALUES ('136', '忠义的天马骑士', '', '希葛伦', '', null, null, '../../../resources//images/feh/acter/Sigrun_F_LoyalProtector/face.png', '../../../resources//images/feh/acter/Sigrun_F_LoyalProtector/q.png', '../../../resources//images/feh/acter/Sigrun_F_LoyalProtector/normal.png', '../../../resources//images/feh/acter/Sigrun_F_LoyalProtector/attact.png', '../../../resources//images/feh/acter/Sigrun_F_LoyalProtector/extra.png', '../../../resources//images/feh/acter/Sigrun_F_LoyalProtector/break.png', '44', '46', '38', '32', '35', null, null, null, null, null, '反攻之枪+', '飞燕金刚架势2', '攻击防守连动3', '飞刃鼓舞', null, '替换', '', '3', '2', null, '4', '1', '2');
INSERT INTO `feh_character` VALUES ('137', '海边的策士', '', '鲁弗莱', '', null, null, '../../../resources//images/feh/acter/Robin_F_SeasideTactician/face.png', '../../../resources//images/feh/acter/Robin_F_SeasideTactician/q.png', '../../../resources//images/feh/acter/Robin_F_SeasideTactician/normal.png', '../../../resources//images/feh/acter/Robin_F_SeasideTactician/attact.png', '../../../resources//images/feh/acter/Robin_F_SeasideTactician/extra.png', '../../../resources//images/feh/acter/Robin_F_SeasideTactician/break.png', '41', '52', '34', '30', '30', null, null, null, null, null, '捕鱼叉+', 'HP防守2', '', '枪之技巧3', null, '带回', '', '1', '2', null, '4', '0', '2');
INSERT INTO `feh_character` VALUES ('138', '光之圣公主', '', '拉切尔', '', null, null, '../../../resources//images/feh/acter/Arachel_F_PrincessOfLight/face.png', '../../../resources//images/feh/acter/Arachel_F_PrincessOfLight/q.png', '../../../resources//images/feh/acter/Arachel_F_PrincessOfLight/normal.png', '../../../resources//images/feh/acter/Arachel_F_PrincessOfLight/attact.png', '../../../resources//images/feh/acter/Arachel_F_PrincessOfLight/extra.png', '../../../resources//images/feh/acter/Arachel_F_PrincessOfLight/break.png', '33', '50', '31', '16', '31', null, null, null, null, null, '伊瓦尔蒂', '', '回复3', '魔防指挥3', null, '', '爆光', '2', '5', null, null, null, '2');
INSERT INTO `feh_character` VALUES ('139', '回忆的舞姬', '', '莉奈雅', '', null, null, '../../../resources//images/feh/acter/Rinea_F_ReminiscentBelle/face.png', '../../../resources//images/feh/acter/Rinea_F_ReminiscentBelle/q.png', '../../../resources//images/feh/acter/Rinea_F_ReminiscentBelle/normal.png', '../../../resources//images/feh/acter/Rinea_F_ReminiscentBelle/attact.png', '../../../resources//images/feh/acter/Rinea_F_ReminiscentBelle/extra.png', '../../../resources//images/feh/acter/Rinea_F_ReminiscentBelle/break.png', '40', '43', '35', '23', '28', null, null, null, null, null, '伊瓦尔蒂', '金刚明镜击2', '业火静水之舞2', '防守大纹章2', null, '再动', '', '1', '5', null, null, '1', '2');
INSERT INTO `feh_character` VALUES ('140', '宿命的巫女', '', '妮妮安', '', null, null, '../../../resources//images/feh/acter/Ninian_F_Normal/face.png', '../../../resources//images/feh/acter/Ninian_F_Normal/q.png', '../../../resources//images/feh/acter/Ninian_F_Normal/normal.png', '../../../resources//images/feh/acter/Ninian_F_Normal/attact.png', '../../../resources//images/feh/acter/Ninian_F_Normal/extra.png', '../../../resources//images/feh/acter/Ninian_F_Normal/break.png', '42', '37', '33', '23', '27', null, null, null, null, null, '光之吐息+', '强化互克3', '脱离路线3', '龙盾鼓舞', null, '再动', '', '1', '8', null, null, '0', '2');
INSERT INTO `feh_character` VALUES ('141', '奥斯提亚的勇将', '', '海克托尔', '', null, null, '../../../resources//images/feh/acter/Hector_M_GeneralofOstia/face.png', '../../../resources//images/feh/acter/Hector_M_GeneralofOstia/q.png', '../../../resources//images/feh/acter/Hector_M_GeneralofOstia/normal.png', '../../../resources//images/feh/acter/Hector_M_GeneralofOstia/attact.png', '../../../resources//images/feh/acter/Hector_M_GeneralofOstia/extra.png', '../../../resources//images/feh/acter/Hector_M_GeneralofOstia/break.png', '49', '55', '37', '19', '27', null, '24', null, null, null, '阿尔玛兹', '远距离反击', '攻击队形3', '重刃纹章', null, '替换', '大盾', '4', '3', null, null, '0', '3');
INSERT INTO `feh_character` VALUES ('142', '晓之女王', '', '米卡雅', '', null, null, '../../../resources//images/feh/acter/Micaiah_F_QueenOfDawn/face.png', '../../../resources//images/feh/acter/Micaiah_F_QueenOfDawn/q.png', '../../../resources//images/feh/acter/Micaiah_F_QueenOfDawn/normal.png', '../../../resources//images/feh/acter/Micaiah_F_QueenOfDawn/attact.png', '../../../resources//images/feh/acter/Micaiah_F_QueenOfDawn/extra.png', '../../../resources//images/feh/acter/Micaiah_F_QueenOfDawn/break.png', '37', '51', '28', '17', '44', null, '24', null, null, null, '破晓之光', '攻击魔防羁绊4', '芸娜的低语', '前导传令 地3', null, '带回', '冰华', '3', '6', null, null, '1', '3');
INSERT INTO `feh_character` VALUES ('143', '纯洁的思恋', '', '密丝特', '', null, null, '../../../resources//images/feh/acter/Mist_F_PurestSpirit/face.png', '../../../resources//images/feh/acter/Mist_F_PurestSpirit/q.png', '../../../resources//images/feh/acter/Mist_F_PurestSpirit/normal.png', '../../../resources//images/feh/acter/Mist_F_PurestSpirit/attact.png', '../../../resources//images/feh/acter/Mist_F_PurestSpirit/extra.png', '../../../resources//images/feh/acter/Mist_F_PurestSpirit/break.png', '42', '43', '36', '17', '23', null, '24', null, null, null, '绿之花篮', '鬼神飞燕击2', '魔防共谋3', '绿魔之技巧3', null, '防守魔防支援+', '', '2', '6', null, null, '0', '3');
INSERT INTO `feh_character` VALUES ('144', '神龙王的化身', '', '娜琪', '', null, null, '../../../resources//images/feh/acter/Nagi_F_DragonAvatar/face.png', '../../../resources//images/feh/acter/Nagi_F_DragonAvatar/q.png', '../../../resources//images/feh/acter/Nagi_F_DragonAvatar/normal.png', '../../../resources//images/feh/acter/Nagi_F_DragonAvatar/attact.png', '../../../resources//images/feh/acter/Nagi_F_DragonAvatar/extra.png', '../../../resources//images/feh/acter/Nagi_F_DragonAvatar/break.png', '49', '53', '19', '33', '41', null, null, null, null, null, '异空吐息', '远距离反击', '奥义队形3', '重刃纹章', null, '迂回', '太阳', '4', '9', null, null, '0', '3');
INSERT INTO `feh_character` VALUES ('145', '沉睡的龙公主', '', '琪姬', '', null, null, '../../../resources//images/feh/acter/Tiki_F_TorpidDragon/face.png', '../../../resources//images/feh/acter/Tiki_F_TorpidDragon/q.png', '../../../resources//images/feh/acter/Tiki_F_TorpidDragon/normal.png', '../../../resources//images/feh/acter/Tiki_F_TorpidDragon/attact.png', '../../../resources//images/feh/acter/Tiki_F_TorpidDragon/extra.png', '../../../resources//images/feh/acter/Tiki_F_TorpidDragon/break.png', '46', '56', '34', '38', '28', null, null, null, null, null, '断绝吐息', '攻击速度大觉醒3', '奥义队形3', '孤单的梦', null, '防守魔防支援', '华炎', '4', '10', null, '2', '1', '4');
INSERT INTO `feh_character` VALUES ('146', '照亮暗夜的月光', '', '卡米拉', '', null, null, '../../../resources//images/feh/acter/Camilla_F_LightOfNohr/face.png', '../../../resources//images/feh/acter/Camilla_F_LightOfNohr/q.png', '../../../resources//images/feh/acter/Camilla_F_LightOfNohr/normal.png', '../../../resources//images/feh/acter/Camilla_F_LightOfNohr/attact.png', '../../../resources//images/feh/acter/Camilla_F_LightOfNohr/extra.png', '../../../resources//images/feh/acter/Camilla_F_LightOfNohr/break.png', '30', '47', '37', '21', '25', null, null, null, null, null, '桑格里德之杖', '攻击速度的奋击4', '神罚之杖', '攻击指挥3', null, '休息+', '天照', '3', '19', null, '4', '0', '4');
INSERT INTO `feh_character` VALUES ('147', '初梦的微笑', '', '斯利兹', '', null, null, '../../../resources//images/feh/acter/Gunnthrá_F_YearsFirstDream/face.png', '../../../resources//images/feh/acter/Gunnthrá_F_YearsFirstDream/q.png', '../../../resources//images/feh/acter/Gunnthrá_F_YearsFirstDream/normal.png', '../../../resources//images/feh/acter/Gunnthrá_F_YearsFirstDream/attact.png', '../../../resources//images/feh/acter/Gunnthrá_F_YearsFirstDream/extra.png', '../../../resources//images/feh/acter/Gunnthrá_F_YearsFirstDream/break.png', '39', '54', '41', '27', '26', null, null, null, null, null, '冰神刀', '鬼神飞燕击2', '猛攻3', '速度相互鼓舞', null, '带回', '凶星', '3', '1', null, null, '1', '1');
INSERT INTO `feh_character` VALUES ('148', '夏日光景的微笑', '', '斯利兹', '', null, null, '../../../resources//images/feh/acter/Gunnthrá_F_BeamingSmile/face.png', '../../../resources//images/feh/acter/Gunnthrá_F_BeamingSmile/q.png', '../../../resources//images/feh/acter/Gunnthrá_F_BeamingSmile/normal.png', '../../../resources//images/feh/acter/Gunnthrá_F_BeamingSmile/attact.png', '../../../resources//images/feh/acter/Gunnthrá_F_BeamingSmile/extra.png', '../../../resources//images/feh/acter/Gunnthrá_F_BeamingSmile/break.png', '41', '46', '34', '20', '24', null, null, null, null, null, '南国果实+', '速度魔防的攻城战3', '解除陷阱33', '攻击鼓舞3', null, '防守魔防支援+', '', '2', '18', null, '3', '0', '4');

-- ----------------------------
-- Table structure for `feh_character_master`
-- ----------------------------
DROP TABLE IF EXISTS `feh_character_master`;
CREATE TABLE `feh_character_master` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CHARACTER_NAME` varchar(10) NOT NULL,
  `CHARACTER_ORIGIN` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feh_character_master
-- ----------------------------
INSERT INTO `feh_character_master` VALUES ('1', '琳迪斯', '烈火之剑');
INSERT INTO `feh_character_master` VALUES ('3', '卡米拉', 'IF');
INSERT INTO `feh_character_master` VALUES ('4', '阿库亚', '觉醒');
INSERT INTO `feh_character_master` VALUES ('5', '维罗妮卡', '英雄');
INSERT INTO `feh_character_master` VALUES ('6', '阿尔冯斯', '英雄');
INSERT INTO `feh_character_master` VALUES ('7', '夏蓉', '英雄');
INSERT INTO `feh_character_master` VALUES ('8', '安娜', '英雄');
INSERT INTO `feh_character_master` VALUES ('9', '菲预尔姆', '英雄');
INSERT INTO `feh_character_master` VALUES ('10', '瑞瓦伽伦', '英雄');
INSERT INTO `feh_character_master` VALUES ('11', '瑞瓦提恩', '英雄');
INSERT INTO `feh_character_master` VALUES ('12', '埃尔', '英雄');
INSERT INTO `feh_character_master` VALUES ('13', '琳达', '纹章之谜');
INSERT INTO `feh_character_master` VALUES ('14', '琪姬', '纹章之谜');
INSERT INTO `feh_character_master` VALUES ('15', '赛莉卡', '索菲亚的复苏');
INSERT INTO `feh_character_master` VALUES ('16', '艾伊拉', '圣战的系谱');
INSERT INTO `feh_character_master` VALUES ('17', '罗伊', '封印之剑');
INSERT INTO `feh_character_master` VALUES ('18', '琳恩', '圣战的系谱');
INSERT INTO `feh_character_master` VALUES ('19', '希薇雅', '圣战的系谱');
INSERT INTO `feh_character_master` VALUES ('20', '希达', '纹章之谜');
INSERT INTO `feh_character_master` VALUES ('21', '瓦育', '苍炎轨迹');
INSERT INTO `feh_character_master` VALUES ('22', '艾克', '晓之巫女');
INSERT INTO `feh_character_master` VALUES ('23', '奥利薇', '觉醒');
INSERT INTO `feh_character_master` VALUES ('24', '艾克', '苍炎轨迹');
INSERT INTO `feh_character_master` VALUES ('25', '漆黑骑士', '苍炎轨迹');
INSERT INTO `feh_character_master` VALUES ('26', '赛尔吉乌斯', '晓之巫女');
INSERT INTO `feh_character_master` VALUES ('27', '西格尔特', '圣战的系谱');
INSERT INTO `feh_character_master` VALUES ('28', '艾尔多尚', '圣战的系谱');
INSERT INTO `feh_character_master` VALUES ('29', '阿瑞斯', '圣战的系谱');
INSERT INTO `feh_character_master` VALUES ('30', '莱因哈特', '多拉基亚776');
INSERT INTO `feh_character_master` VALUES ('31', '艾莉柯', '圣魔光石');
INSERT INTO `feh_character_master` VALUES ('32', '马克斯', 'IF');
INSERT INTO `feh_character_master` VALUES ('33', '龙马', 'IF');
INSERT INTO `feh_character_master` VALUES ('34', '伊东', '封印之剑');
INSERT INTO `feh_character_master` VALUES ('35', '梅尔', '圣魔光石');
INSERT INTO `feh_character_master` VALUES ('36', '米卡雅', '晓之巫女');
INSERT INTO `feh_character_master` VALUES ('37', '萨拉', '觉醒');
INSERT INTO `feh_character_master` VALUES ('38', '狄亚马特', '苍炎轨迹');
INSERT INTO `feh_character_master` VALUES ('39', '塔娜', '圣魔光石');
INSERT INTO `feh_character_master` VALUES ('40', '茵巴丝', '觉醒');
INSERT INTO `feh_character_master` VALUES ('41', '艾弗拉姆', '圣魔光石');
INSERT INTO `feh_character_master` VALUES ('42', '露琪娜', '觉醒');
INSERT INTO `feh_character_master` VALUES ('43', '艾利乌德', '烈火之剑');
INSERT INTO `feh_character_master` VALUES ('44', '海克托尔', '烈火之剑');
INSERT INTO `feh_character_master` VALUES ('45', '艾尔菲', 'IF');
INSERT INTO `feh_character_master` VALUES ('46', '芬恩', '多拉基亚776');
INSERT INTO `feh_character_master` VALUES ('47', '丝米亚', '觉醒');
INSERT INTO `feh_character_master` VALUES ('48', '火乃香', 'IF');
INSERT INTO `feh_character_master` VALUES ('49', '妮凯', '晓之巫女');
INSERT INTO `feh_character_master` VALUES ('50', '贝尔贝特', '觉醒');
INSERT INTO `feh_character_master` VALUES ('51', '绢', 'IF');
INSERT INTO `feh_character_master` VALUES ('52', '伊修达尔', '圣战的系谱');
INSERT INTO `feh_character_master` VALUES ('53', '诗格莱', 'IF');
INSERT INTO `feh_character_master` VALUES ('54', '奥菲利亚', 'IF');
INSERT INTO `feh_character_master` VALUES ('59', '卡秋雅', '纹章之谜');
INSERT INTO `feh_character_master` VALUES ('60', '爱丝特', '纹章之谜');
INSERT INTO `feh_character_master` VALUES ('61', '欧尔玟', '多拉基亚776');
INSERT INTO `feh_character_master` VALUES ('62', '马可', '觉醒');
INSERT INTO `feh_character_master` VALUES ('63', '神威', 'IF');
INSERT INTO `feh_character_master` VALUES ('64', '琉希昂', '晓之巫女');
INSERT INTO `feh_character_master` VALUES ('65', '法', '封印之剑');
INSERT INTO `feh_character_master` VALUES ('66', '鲁弗莱', '觉醒');
INSERT INTO `feh_character_master` VALUES ('67', '阳炎', 'IF');
INSERT INTO `feh_character_master` VALUES ('68', '艾琳西亚', '晓之巫女');
INSERT INTO `feh_character_master` VALUES ('69', '尼诺', '烈火之剑');
INSERT INTO `feh_character_master` VALUES ('70', '阿兹尔', '觉醒');
INSERT INTO `feh_character_master` VALUES ('71', '莉莉娜', '封印之剑');
INSERT INTO `feh_character_master` VALUES ('72', '瑟西利亚', '封印之剑');
INSERT INTO `feh_character_master` VALUES ('73', '莎娜琪', '苍炎轨迹');
INSERT INTO `feh_character_master` VALUES ('74', '芸娜', '晓之巫女');
INSERT INTO `feh_character_master` VALUES ('75', '凯内基斯', '晓之巫女');
INSERT INTO `feh_character_master` VALUES ('76', '莉娅妮', '晓之巫女');
INSERT INTO `feh_character_master` VALUES ('77', '多玛', '索菲亚的复苏');
INSERT INTO `feh_character_master` VALUES ('78', '洛基', '英雄');
INSERT INTO `feh_character_master` VALUES ('79', '水琴', 'IF');
INSERT INTO `feh_character_master` VALUES ('80', '艾丝琳', '圣战的系谱');
INSERT INTO `feh_character_master` VALUES ('81', '拓海', 'IF');
INSERT INTO `feh_character_master` VALUES ('82', '那迦', '觉醒');
INSERT INTO `feh_character_master` VALUES ('83', '塔妮丝', '晓之巫女');
INSERT INTO `feh_character_master` VALUES ('84', '希葛伦', '晓之巫女');
INSERT INTO `feh_character_master` VALUES ('85', '露易丝', '烈火之剑');
INSERT INTO `feh_character_master` VALUES ('86', '乌露丝拉', '烈火之剑');
INSERT INTO `feh_character_master` VALUES ('87', '马尔斯', '纹章之谜');
INSERT INTO `feh_character_master` VALUES ('88', '菲娜', '纹章之谜');
INSERT INTO `feh_character_master` VALUES ('89', '佛利兹', '英雄');
INSERT INTO `feh_character_master` VALUES ('90', '菲奥拉', '烈火之剑');
INSERT INTO `feh_character_master` VALUES ('91', '库洛武', '觉醒');
INSERT INTO `feh_character_master` VALUES ('92', '涅菲妮', '苍炎轨迹');
INSERT INTO `feh_character_master` VALUES ('93', '拉切尔', '圣魔光石');
INSERT INTO `feh_character_master` VALUES ('94', '莉奈雅', '索菲亚的复苏');
INSERT INTO `feh_character_master` VALUES ('95', '妮妮安', '烈火之剑');
INSERT INTO `feh_character_master` VALUES ('96', '密丝特', '苍炎轨迹');
INSERT INTO `feh_character_master` VALUES ('97', '娜琪', '纹章之谜');
INSERT INTO `feh_character_master` VALUES ('98', '斯利兹', '英雄');

-- ----------------------------
-- Table structure for `feh_content_master`
-- ----------------------------
DROP TABLE IF EXISTS `feh_content_master`;
CREATE TABLE `feh_content_master` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CATEGORY_ID` varchar(10) NOT NULL,
  `CATEGORY_NAME` varchar(10) NOT NULL,
  `CODE_ID` varchar(10) NOT NULL,
  `CODE_NAME` varchar(10) NOT NULL,
  `CODE_NAME_IMG` varchar(150) DEFAULT NULL,
  `CM_ORDER` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feh_content_master
-- ----------------------------
INSERT INTO `feh_content_master` VALUES ('1', '0001', '武器属性', '1', '红剑', '../../../resources/images/feh/i_fire_sword.png', null);
INSERT INTO `feh_content_master` VALUES ('2', '0001', '武器属性', '2', '蓝枪', '../../../resources/images/feh/i_thunder_spear.png', null);
INSERT INTO `feh_content_master` VALUES ('3', '0001', '武器属性', '3', '绿斧', '../../../resources/images/feh/i_wind_ax.png', null);
INSERT INTO `feh_content_master` VALUES ('4', '0001', '武器属性', '4', '红魔法书', '../../../resources/images/feh/i_fire_magic.png', null);
INSERT INTO `feh_content_master` VALUES ('5', '0001', '武器属性', '5', '蓝魔法书', '../../../resources/images/feh/i_thunder_magic.png', null);
INSERT INTO `feh_content_master` VALUES ('6', '0001', '武器属性', '6', '绿魔法书', '../../../resources/images/feh/i_wind_magic.png', null);
INSERT INTO `feh_content_master` VALUES ('7', '0001', '武器属性', '7', '红色龙息', '../../../resources/images/feh/i_fire_dragon.png', null);
INSERT INTO `feh_content_master` VALUES ('8', '0001', '武器属性', '8', '蓝色龙息', '../../../resources/images/feh/i_thunder_dragon.png', null);
INSERT INTO `feh_content_master` VALUES ('9', '0001', '武器属性', '9', '绿色龙息', '../../../resources/images/feh/i_wind_dragon.png', null);
INSERT INTO `feh_content_master` VALUES ('10', '0001', '武器属性', '10', '无色龙息', '../../../resources/images/feh/i_none_dragon.png', null);
INSERT INTO `feh_content_master` VALUES ('11', '0001', '武器属性', '11', '红色弓', '../../../resources/images/feh/i_fire_arrow.png', null);
INSERT INTO `feh_content_master` VALUES ('12', '0001', '武器属性', '12', '蓝色弓', '../../../resources/images/feh/i_thunder_arrow.png', null);
INSERT INTO `feh_content_master` VALUES ('13', '0001', '武器属性', '13', '绿色弓', '../../../resources/images/feh/i_wind_arrow.png', null);
INSERT INTO `feh_content_master` VALUES ('14', '0001', '武器属性', '14', '无色弓', '../../../resources/images/feh/i_none_arrow.png', null);
INSERT INTO `feh_content_master` VALUES ('15', '0001', '武器属性', '15', '红色暗器', '../../../resources/images/feh/i_fire_assassin.png', null);
INSERT INTO `feh_content_master` VALUES ('16', '0001', '武器属性', '16', '蓝色暗器', '../../../resources/images/feh/i_thunder_assassin.png', null);
INSERT INTO `feh_content_master` VALUES ('17', '0001', '武器属性', '17', '绿色暗器', '../../../resources/images/feh/i_wind_assassin.png', null);
INSERT INTO `feh_content_master` VALUES ('18', '0001', '武器属性', '18', '无色暗器', '../../../resources/images/feh/i_none_assassin.png', null);
INSERT INTO `feh_content_master` VALUES ('19', '0001', '武器属性', '19', '无色杖', '../../../resources/images/feh/i_none_wand.png', null);
INSERT INTO `feh_content_master` VALUES ('20', '0002', '移动方式', '1', '步行', '../../../resources/images/feh/i_type_pawn.png', null);
INSERT INTO `feh_content_master` VALUES ('21', '0002', '移动方式', '2', '骑兵', '../../../resources/images/feh/i_type_knight.png', null);
INSERT INTO `feh_content_master` VALUES ('22', '0002', '移动方式', '3', '飞行', '../../../resources/images/feh/i_type_fly.png', null);
INSERT INTO `feh_content_master` VALUES ('23', '0002', '移动方式', '4', '重装', '../../../resources/images/feh/i_type_armor.png', null);
INSERT INTO `feh_content_master` VALUES ('24', '0003', '祝福', '1', '水', '../../../resources/images/feh/i_BlessA.png', null);
INSERT INTO `feh_content_master` VALUES ('25', '0003', '祝福', '2', '火', '../../../resources/images/feh/i_BlessF.png', null);
INSERT INTO `feh_content_master` VALUES ('26', '0003', '祝福', '3', '风', '../../../resources/images/feh/i_BlessW.png', null);
INSERT INTO `feh_content_master` VALUES ('27', '0003', '祝福', '4', '土', '../../../resources/images/feh/i_BlessE.png', null);
INSERT INTO `feh_content_master` VALUES ('28', '0003', '祝福', '5', '光', '', null);
INSERT INTO `feh_content_master` VALUES ('29', '0003', '祝福', '6', '暗', '', null);
INSERT INTO `feh_content_master` VALUES ('30', '0004', '作品名', '1', '暗之龙与光之剑', null, null);
INSERT INTO `feh_content_master` VALUES ('31', '0004', '作品名', '2', '纹章之谜', null, null);
INSERT INTO `feh_content_master` VALUES ('32', '0004', '作品名', '3', '索菲亚的复苏', null, null);
INSERT INTO `feh_content_master` VALUES ('33', '0004', '作品名', '4', '圣战的系谱', null, null);
INSERT INTO `feh_content_master` VALUES ('34', '0004', '作品名', '5', '多拉基亚776', null, null);
INSERT INTO `feh_content_master` VALUES ('35', '0004', '作品名', '6', '封印之剑', null, null);
INSERT INTO `feh_content_master` VALUES ('36', '0004', '作品名', '7', '烈火之剑', null, null);
INSERT INTO `feh_content_master` VALUES ('37', '0004', '作品名', '8', '圣魔光石', null, null);
INSERT INTO `feh_content_master` VALUES ('38', '0004', '作品名', '9', '苍炎轨迹', null, null);
INSERT INTO `feh_content_master` VALUES ('39', '0004', '作品名', '10', '晓之巫女', null, null);
INSERT INTO `feh_content_master` VALUES ('40', '0004', '作品名', '11', '觉醒', null, null);
INSERT INTO `feh_content_master` VALUES ('41', '0004', '作品名', '13', '英雄', '', null);
INSERT INTO `feh_content_master` VALUES ('42', '0004', '作品名', '12', 'IF', null, null);
INSERT INTO `feh_content_master` VALUES ('43', '0001', '武器属性', '20', '红色兽族', '../../../resources/images/feh/i_fire_beast.png', null);
INSERT INTO `feh_content_master` VALUES ('44', '0001', '武器属性', '21', '蓝色兽族', '../../../resources/images/feh/i_thunder_beast.png', null);
INSERT INTO `feh_content_master` VALUES ('45', '0001', '武器属性', '22', '绿色兽族', '../../../resources/images/feh/i_wind_beast.png', null);
INSERT INTO `feh_content_master` VALUES ('46', '0001', '武器属性', '23', '无色兽族', '../../../resources/images/feh/i_none_beast.png', null);

-- ----------------------------
-- Table structure for `feh_skill_master`
-- ----------------------------
DROP TABLE IF EXISTS `feh_skill_master`;
CREATE TABLE `feh_skill_master` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SKILL_TYPE` varchar(10) NOT NULL,
  `SKILL_NAME` varchar(20) NOT NULL,
  `SKILL_COLOUR` varchar(10) DEFAULT NULL,
  `SKILL_EXTEND` int(11) DEFAULT NULL,
  `SKILL_POWER` int(11) DEFAULT NULL,
  `SKILL_INFO` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=404 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feh_skill_master
-- ----------------------------
INSERT INTO `feh_skill_master` VALUES ('1', 'A', '鬼神飞燕击2', null, '1', null, '由自己发动攻击时，战斗中攻击及速度+4');
INSERT INTO `feh_skill_master` VALUES ('2', 'B', '塞迦的加护', null, '0', null, '对方为剑枪斧时，敌人无法反击');
INSERT INTO `feh_skill_master` VALUES ('3', 'C', '攻击紫烟3', null, '1', null, '战斗后，对方周围2格内的敌人攻击-7');
INSERT INTO `feh_skill_master` VALUES ('4', 'W', '妙尔葛雷', '无色弓', '0', '14', '克制飞行 速度+3，敌人为魔法兵种时抵消+强化状态');
INSERT INTO `feh_skill_master` VALUES ('5', 'S', '带回', null, '1', null, '让我方移动至自己的后方');
INSERT INTO `feh_skill_master` VALUES ('6', 'E', '龙裂', null, '1', null, '增加攻击30%的奥义伤害(3)');
INSERT INTO `feh_skill_master` VALUES ('7', 'D', '锻炼之证 攻击3', null, '1', '3', '攻击+3');
INSERT INTO `feh_skill_master` VALUES ('8', 'A', '死线3', null, '1', '3', '攻击速度+5，防御魔防-5');
INSERT INTO `feh_skill_master` VALUES ('9', 'B', '埋伏3', null, '1', null, 'HP低于75%，受到攻击时抢先反击');
INSERT INTO `feh_skill_master` VALUES ('10', 'C', '防守威吓2', null, '1', null, '回合开始时，周围2格敌人防守-4');
INSERT INTO `feh_skill_master` VALUES ('11', 'W', '索尔 卡提', '红剑', '0', '18', 'HP+5，HP低于75%，发动攻击时可立即追击');
INSERT INTO `feh_skill_master` VALUES ('12', 'S', '替换', null, '1', null, '替换自己和队友位置');
INSERT INTO `feh_skill_master` VALUES ('13', 'E', '疾风迅雷', null, '0', null, '再次行动');
INSERT INTO `feh_skill_master` VALUES ('26', 'A', '塞迦的规矩', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('27', 'B', '猛攻3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('28', 'C', '速度指挥3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('29', 'E', '太阳', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('30', 'S', '防守支援', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('31', 'W', '疾弓妙尔葛雷', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('32', 'A', '攻击3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('33', 'B', '幻惑之杖3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('34', 'C', '魔防大纹章2', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('35', 'E', '天照', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('36', 'S', '重生+', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('37', 'W', '烛光+', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('38', 'A', '攻击速度羁绊3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('39', 'C', '重装备行军3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('40', 'E', '新月', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('41', 'S', '拉近', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('42', 'W', '苍蓝之刃+', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('43', 'A', '飞燕一击3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('45', 'C', '死亡气息3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('47', 'W', '勇者之斧', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('48', 'A', '速度防守羁绊3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('49', 'C', '飞盾纹章', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('50', 'W', '门松+', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('51', 'A', '攻击魔防羁绊3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('52', 'C', '飞刃纹章', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('53', 'E', '月光', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('54', 'W', '梦幻之书', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('55', 'A', '鬼神一击3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('56', 'B', '编队飞行3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('57', 'C', '飞刃鼓舞', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('58', 'W', '南国果汁+', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('59', 'B', '破枪者3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('60', 'W', '绿之卵+', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('61', 'A', '强化互克3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('62', 'B', '破剑者3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('63', 'C', '魔防鼓舞3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('64', 'E', '月虹', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('65', 'S', '再动', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('66', 'W', '苍海之枪+', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('67', 'B', '救援行路3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('68', 'C', '攻击大纹章2', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('69', 'W', '乌尔德', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('70', 'B', '大地之舞', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('71', 'E', '星影', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('72', 'W', '羽子板+', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('73', 'A', '速度魔防羁绊3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('74', 'B', '静水之舞', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('75', 'W', '泡影之书', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('76', 'A', '青色死斗 飞行3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('77', 'B', '特技飞行', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('78', 'C', '攻击指挥3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('79', 'W', '清冷的法具', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('80', 'B', '神罚之杖', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('81', 'E', '业火疾风祝福+', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('82', 'S', '圣愈+', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('83', 'W', '至高王座之杖', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('84', 'C', '攻击纹章3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('85', 'W', '弗尔克范格', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('86', 'A', '速度3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('87', 'C', '防守鼓舞3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('88', 'S', '攻击支援', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('89', 'W', '芬萨里尔', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('90', 'C', '魔防纹章2', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('91', 'E', '流星', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('92', 'W', '诺欧通', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('93', 'A', '攻击防守羁绊3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('94', 'B', '盾之跃动3', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('95', 'E', '冰之圣镜', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('96', 'W', '雷依普特', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('97', 'B', '攻击速度连动3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('98', 'C', '魔防之波 偶数3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('99', 'W', '鸣镝+', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('100', 'A', '赤色死斗 飞行3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('101', 'B', '攻击封杀3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('102', 'E', '绯炎', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('103', 'W', '尼乌', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('105', 'C', '速度之波 奇数3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('106', 'E', '凶星', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('107', 'W', '瑞瓦提恩', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('108', 'B', '生命护符3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('109', 'C', '生命光辉', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('110', 'E', '冰苍', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('111', 'W', '利菲亚', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('112', 'A', '攻击魔防大觉醒3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('113', 'B', '破弓者3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('114', 'C', '骑盾鼓舞', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('115', 'W', '海星+', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('116', 'B', '一击即离', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('117', 'C', '龙之技巧', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('118', 'W', '盛夏吐息', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('119', 'A', '鬼神呼吸', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('120', 'B', '攻击队形3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('121', 'C', '和大家一起', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('122', 'E', '天空', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('123', 'W', '神雾吐息', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('124', 'A', '鬼神一击4', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('125', 'B', '狮子连斩', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('126', 'W', '王家之剑', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('127', 'W', '顺闪艾伊拉之剑', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('128', 'A', '强化增幅3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('129', 'B', '回复3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('130', 'C', '发挥人类的潜能', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('131', 'E', '龙穿', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('132', 'W', '守护之剑', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('133', 'B', '业火疾风之舞2', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('134', 'C', '剑之技巧3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('135', 'A', '鬼神明镜架势2', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('136', 'B', '疾风静水之舞2', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('137', 'C', '攻击鼓舞3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('138', 'W', '巴里亚之剑+', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('140', 'C', '飞盾鼓舞', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('141', 'E', '冰华', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('142', 'W', '羽翼之剑', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('143', 'A', '柔剑3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('144', 'C', '攻击威吓3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('145', 'W', '气瑞瓦育之剑', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('146', 'A', '明镜呼吸', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('147', 'B', '攻击防守封印2', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('148', 'C', '防守指挥3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('149', 'E', '苍蓝天空', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('150', 'W', '瑞格内尔', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('151', 'A', 'HP2', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('152', 'W', '银剑+', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('153', 'A', '远距离反击', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('154', 'B', '奥义队形3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('155', 'C', '重装行军3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('156', 'W', '祝祭之剑+', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('157', 'A', '金刚架势3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('158', 'B', '迎击队形3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('159', 'C', '重刃鼓舞', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('160', 'E', '漆黑月光', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('161', 'W', '艾塔尔德', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('162', 'A', '鬼神架势3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('163', 'B', '转移粉末', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('164', 'A', '近距离防御3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('165', 'B', '圣骑士的加护', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('166', 'C', '骑刃鼓舞', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('167', 'E', '祈祷', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('168', 'A', '狮子奋迅3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('169', 'E', '爆光', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('170', 'W', '米斯特汀', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('171', 'A', '攻击防守大觉醒3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('172', 'B', '防守魔防封印2', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('173', 'E', '卧龙', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('174', 'W', '魔剑米斯特汀', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('175', 'B', '破斧者3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('176', 'W', '大师之剑', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('177', 'A', '飞燕金刚击2', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('178', 'W', '烈剑迪朗达尔', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('179', 'A', '攻击速度孤军3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('180', 'B', '月亮手镯', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('181', 'C', '防守之波奇数3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('182', 'W', '雷剑齐格林德', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('183', 'A', '金刚一击3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('184', 'B', '阻止进军3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('185', 'E', '烈光', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('186', 'W', '西格弗里德', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('187', 'A', '鬼神飞燕架势2', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('188', 'B', '武士道', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('189', 'E', '黎明', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('190', 'W', '雷神刀', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('191', 'A', '防守魔防堡垒3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('192', 'C', '龙盾纹章', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('193', 'W', '魔龙吐息', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('194', 'A', '防守魔防2', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('196', 'S', '迂回', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('197', 'W', '精灵吐息', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('198', 'C', '魔防谋策3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('199', 'E', '强风', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('200', 'W', '晓天的神乐铃', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('201', 'C', '魔防纹章3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('202', 'W', '萨拉的禁咒', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('203', 'C', '防守纹章3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('204', 'S', '攻击速度支援', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('205', 'W', '穆斯贝尔之炎花', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('206', 'A', '近距离反击', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('207', 'W', '烛台+', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('208', 'W', '赤红之书+', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('209', 'B', '攻击魔防联动3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('210', 'W', '花圈+', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('211', 'A', '攻击速度的奋击3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('212', 'A', 'HP速度2', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('213', 'W', '茵巴丝的黑暗', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('214', 'W', '齐格蒙德', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('215', 'A', '鬼神金刚架势', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('216', 'B', '太阳手镯', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('217', 'W', '炎枪齐格蒙德', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('218', 'W', '加姆', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('219', 'A', '鬼神金刚击2', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('220', 'C', '速度大纹章2', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('221', 'W', '洁尔诗科古尔', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('222', 'C', '近距离警戒3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('223', 'S', '映照未来的眼眸', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('224', 'W', '索军', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('225', 'A', '生命业火3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('226', 'C', '重刃纹章', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('227', 'W', '卡萨布兰卡+', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('228', 'A', '奥斯提亚德反击', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('229', 'W', '马尔堤', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('230', 'B', '防守队形3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('231', 'E', '萤火', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('232', 'S', '重击', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('233', 'W', '银枪+', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('234', 'B', '魔防封杀3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('235', 'W', '和伞+', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('236', 'A', '攻击防守2', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('237', 'W', '勇者之枪+', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('238', 'B', '攻击防守连动3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('239', 'E', '小盾', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('240', 'W', '反攻之枪+', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('241', 'W', '火乃香的红雉刀', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('242', 'W', '战姬的和弓', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('243', 'B', '识破无法反击3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('244', 'C', '邪眼', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('245', 'W', '狼女王之牙', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('246', 'B', '速度封杀3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('247', 'C', '防守紫烟3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('248', 'W', '塔戈埃尔的爪牙', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('249', 'B', '攻击扰乱3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('250', 'W', '狐妖之女的爪牙', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('251', 'C', '攻击之波奇数3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('252', 'W', '雷神之锤', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('253', 'B', '破赤魔者3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('254', 'C', '青魔技巧3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('255', 'W', '舞会乐章+', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('256', 'C', '防守大纹章2', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('257', 'W', '魔书米斯特丁', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('258', 'W', '白骑的短枪', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('259', 'C', '骑刃纹章', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('260', 'E', '烈雷', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('261', 'W', '神雷', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('262', 'B', '破赤魔者', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('263', 'C', '骑盾纹章', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('264', 'W', '雷旋之书', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('265', 'C', '攻击谋策3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('266', 'E', '冰点', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('267', 'W', '苍蓝海蛇+', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('268', 'A', '飞燕明镜击2', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('269', 'W', '热带鱼之书', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('270', 'B', '恐慌错乱3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('271', 'W', '暴乱吐息', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('272', 'C', '龙盾鼓舞', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('273', 'S', '攻击速度支援+', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('274', 'W', '水之飞沫', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('275', 'A', '金刚呼吸', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('276', 'B', '贝欧克的加护', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('277', 'C', '防守威吓3', null, '1', null, null);
INSERT INTO `feh_skill_master` VALUES ('278', 'W', '乌尔邦', null, '0', null, null);
INSERT INTO `feh_skill_master` VALUES ('279', 'W', '佣兵团的战斧', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('280', 'A', '飞燕金刚架势2', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('281', 'C', '兽盾鼓舞', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('282', 'W', '白鹭之翼', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('283', 'A', '防守魔防的羁绊3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('284', 'C', '重盾纹章', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('285', 'W', '绮罗星吐息+', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('286', 'A', '防守3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('287', 'E', '华炎', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('288', 'W', '邪龙吐息', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('289', 'A', '邪龙之鳞', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('290', 'A', '鬼神明镜击2', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('291', 'C', '攻击之波偶数3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('292', 'W', '玻璃瓶果汁+', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('293', 'B', '荣誉之喜悦', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('294', 'W', '致命卡罗特+', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('295', 'B', '疾风大地之舞', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('296', 'W', '绿云舞扇+', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('297', 'S', '速度魔防支援', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('298', 'W', '艾莉丝之书', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('299', 'W', '翠绿之书+', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('300', 'B', '疾风之舞3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('301', 'W', '舞会之环+', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('302', 'A', 'HP攻击2', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('303', 'E', '碎火', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('304', 'W', '绿之礼品箱+', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('305', 'S', '速度防守支援', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('306', 'W', '翠绿之刃+', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('307', 'W', '尼福尔之冰花', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('308', 'A', '攻击魔防', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('309', 'B', '魔防扰乱3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('310', 'C', '吾之名为混沌', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('311', 'W', '负之力', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('312', 'A', '远距离防御3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('313', 'C', '远距离警戒3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('314', 'W', '狮子王的爪牙', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('315', 'C', '兽刃鼓舞', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('316', 'A', '防守魔防孤军3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('317', 'C', '超级地震', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('318', 'W', '邪神吐息', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('319', 'W', '春之妖弓', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('320', 'A', '攻击速度2', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('321', 'W', '束口袋', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('322', 'B', '业火之舞3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('323', 'W', '舞会折扇+', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('324', 'C', '防守谋策3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('325', 'W', '冬祭之靴+', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('326', 'C', '步行之刚击3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('327', 'S', '殉教+', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('328', 'W', '闪烁+', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('329', 'S', '休息+', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('330', 'W', '提灯之杖+', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('331', 'B', '奉献之喜悦3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('332', 'S', '远程圣疗+', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('333', 'W', '恐惧+', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('334', 'W', '镜饼麻薯+', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('335', 'A', '明镜一击3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('336', 'B', '破暗器者3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('337', 'E', '血仇', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('338', 'W', '秘毒暗器', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('339', 'A', '攻击速度的攻城战3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('340', 'C', '神龙王之牙', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('341', 'W', '神龙王吐息', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('342', 'W', '花柱+', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('343', 'A', '速度防守的守城战3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('344', 'C', '前导传令.天3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('345', 'W', '蛋糕刀+', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('346', 'W', '祝福之花弓+', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('347', 'A', '鬼神金刚瞬击', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('348', 'W', '远海之苍弓', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('349', 'B', '防守魔防大共谋3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('350', 'W', '贝壳匕首+', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('351', 'B', '封印之盾', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('352', 'C', '步行的柔击3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('353', 'W', '神剑法尔西昂', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('354', 'A', '速度防守密集', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('355', 'B', '大地净水之舞2', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('356', 'W', '刺剑', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('357', 'B', '冻结之封印', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('358', 'C', '攻击紫烟', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('359', 'W', '吉欧尔', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('360', 'B', '回击3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('361', 'C', '攻击鼓舞4', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('362', 'W', '迎春之剑', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('363', 'B', '速度魔防连动3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('364', 'W', '阳伞+', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('365', 'B', '防守封杀3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('366', 'W', '封剑法尔西昂', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('367', 'B', '愤怒3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('368', 'E', '夕阳', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('369', 'W', '义勇之枪', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('370', 'A', '速度防守2', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('371', 'C', '空中前导3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('372', 'W', '维德佛尔尼尔', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('373', 'A', 'HP防守2', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('374', 'C', '枪之技巧3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('375', 'W', '捕鱼叉+', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('376', 'C', '魔防指挥3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('377', 'W', '伊瓦尔蒂', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('378', 'A', '金刚明镜击2', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('379', 'B', '业火静水之舞2', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('380', 'B', '脱离路线3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('381', 'W', '光之吐息+', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('382', 'E', '大盾', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('383', 'W', '阿尔玛兹', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('384', 'A', '攻击魔防羁绊4', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('385', 'B', '芸娜的低语', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('386', 'C', '前导传令 地3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('387', 'W', '破晓之光', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('388', 'B', '魔防共谋3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('389', 'C', '绿魔之技巧3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('390', 'S', '防守魔防支援+', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('391', 'W', '绿之花篮', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('392', 'W', '异空吐息', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('393', 'A', '攻击速度大觉醒3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('394', 'C', '孤单的梦', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('395', 'S', '防守魔防支援', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('396', 'W', '断绝吐息', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('397', 'A', '攻击速度的奋击4', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('398', 'W', '桑格里德之杖', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('399', 'C', '速度相互鼓舞', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('400', 'W', '冰神刀', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('401', 'A', '速度魔防的攻城战3', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('402', 'B', '解除陷阱33', null, null, null, null);
INSERT INTO `feh_skill_master` VALUES ('403', 'W', '南国果实+', null, null, null, null);

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `ID` int(8) NOT NULL AUTO_INCREMENT,
  `MENU_NAME` varchar(20) DEFAULT NULL,
  `MENU_LEVEL` varchar(1) DEFAULT NULL,
  `PARENT_MENU` varchar(1) DEFAULT NULL,
  `MENU_URL` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------

-- ----------------------------
-- Table structure for `oracle_chapter_tips`
-- ----------------------------
DROP TABLE IF EXISTS `oracle_chapter_tips`;
CREATE TABLE `oracle_chapter_tips` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CHAPTER_ID` varchar(5) DEFAULT NULL,
  `CHAPTER_NAME` varchar(20) DEFAULT NULL,
  `TIP_INFO` varchar(1000) DEFAULT NULL,
  `KEY_WORD` varchar(20) DEFAULT NULL,
  `RANK` int(2) DEFAULT '1',
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDATE_DATE` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oracle_chapter_tips
-- ----------------------------
INSERT INTO `oracle_chapter_tips` VALUES ('1', '1-1', '关系型数据库基本知识', 'Database Management System:数据库管理系统', 'DBMS', null, '2019-11-09 18:54:43', null);
INSERT INTO `oracle_chapter_tips` VALUES ('2', '1-1', '关系型数据库基本知识', '用数据的值来关联多个被数据分割的表', '关系型数据', null, '2019-11-09 18:54:43', null);
INSERT INTO `oracle_chapter_tips` VALUES ('3', '1-1', '关系型数据库基本知识', '表由行ROW列COLUMN构成;交叉的地方叫单元格FIELD;单元格内没有存入数据情况称为null;null和空格或0不一样', '关系型数据', null, '2019-11-09 18:54:43', null);
INSERT INTO `oracle_chapter_tips` VALUES ('4', '1-2', 'SQL概要', 'Data Manipulation Language:数据操作语言', 'DML', null, '2019-11-09 18:54:43', null);
INSERT INTO `oracle_chapter_tips` VALUES ('5', '1-2', 'SQL概要', 'Data Definition Language:数据定义语言', 'DDL', null, '2019-11-09 18:54:43', null);
INSERT INTO `oracle_chapter_tips` VALUES ('6', '1-2', 'SQL概要', 'Data ControlDefinition Language:数据控制语言', 'DCL', null, '2019-11-09 18:54:43', null);
INSERT INTO `oracle_chapter_tips` VALUES ('7', '1-2', 'SQL概要', '数据库事务,トランザクション', 'transaction', null, '2019-11-09 18:54:43', null);
INSERT INTO `oracle_chapter_tips` VALUES ('8', '2-1', 'select文基本', '查找表特定列功能叫做[射影]', '射影', '1', '2019-11-09 18:54:43', null);
INSERT INTO `oracle_chapter_tips` VALUES ('9', '2-1', 'select文基本', '查找表特定行功能叫做[选择]', '选择', '1', '2019-11-09 18:54:43', null);
INSERT INTO `oracle_chapter_tips` VALUES ('10', '2-1', 'select文基本', '查询复数表的功能叫[结合]', '结合', '1', '2019-11-09 18:54:43', null);
INSERT INTO `oracle_chapter_tips` VALUES ('11', '2-1', 'select文基本', 'DESCRIBE命令可以查看表结构', 'DESCRIBE', '1', '2019-11-09 18:54:43', null);
INSERT INTO `oracle_chapter_tips` VALUES ('12', '2-2', 'select句各种指定方法', '对null值进行计算结果仍是null', 'NULL', '5', '2019-11-09 18:54:43', null);
INSERT INTO `oracle_chapter_tips` VALUES ('13', '2-2', 'select句各种指定方法', '列别名使用空格或是特殊字符时,需要用双引号括起来', '特殊字符处理', '5', '2019-11-09 18:54:43', null);
INSERT INTO `oracle_chapter_tips` VALUES ('14', '2-2', 'select句各种指定方法', '显示或拼接字符串或日期等文字时需要用单引号括起来', '特殊字符处理', '5', '2019-11-09 18:54:43', null);
INSERT INTO `oracle_chapter_tips` VALUES ('15', '2-2', 'select句各种指定方法', '代替引用符(q)可以把一些SQL专用的特殊符号不进行识别,而是作为文字列显示', '代替引用符(q)', '6', '2019-11-09 18:54:43', null);
INSERT INTO `oracle_chapter_tips` VALUES ('16', '2-2', 'select句各种指定方法', '需要使用对括号进行指定()[]{}<>都可以,但要成对出现', '代替引用符(q)', '6', '2019-11-09 18:54:43', null);
INSERT INTO `oracle_chapter_tips` VALUES ('17', '2-2', 'select句各种指定方法', '去除重复列,select句中只能出现一次', 'DISTINCT', '4', '2019-11-09 18:54:43', null);
INSERT INTO `oracle_chapter_tips` VALUES ('18', '3-1', '查询条件', '限制满足条件的行表示', 'WHERE', '1', '2019-11-09 18:54:43', null);
INSERT INTO `oracle_chapter_tips` VALUES ('19', '3-1', '查询条件', '条件式里区别大小写,区别日期格式,不可以使用列别名', null, '4', '2019-11-09 18:54:43', null);
INSERT INTO `oracle_chapter_tips` VALUES ('20', '3-1', '查询条件', 'between包括境界值,not between不包括境界值', 'BETWEEN', '5', '2019-11-09 18:54:43', null);
INSERT INTO `oracle_chapter_tips` VALUES ('21', '3-1', '查询条件', '使用ESCAPE可以把%或_作为文字列进行检索', 'ESCAPE', '6', '2019-11-09 18:54:43', null);
INSERT INTO `oracle_chapter_tips` VALUES ('22', '3-1', '查询条件', '对null值的列使用=或<>会报错', 'NULL', '5', '2019-11-09 18:54:43', null);
INSERT INTO `oracle_chapter_tips` VALUES ('23', '3-2', '伦理验算子', '伦理验算优先顺序not>and>or', null, '5', '2019-11-09 18:54:43', null);
INSERT INTO `oracle_chapter_tips` VALUES ('24', '3-2', '伦理验算子', '使用in和or,在性能上没有区别', null, '5', '2019-11-09 18:54:43', null);
INSERT INTO `oracle_chapter_tips` VALUES ('25', '3-3', '查询结果排序', '在select句中最后使用,可以使用列别名,列的位置', 'ORDER BY', '1', '2019-11-09 18:54:43', null);
INSERT INTO `oracle_chapter_tips` VALUES ('26', '3-3', '查询结果排序', 'null值被认为是最大,可以使用nulls first或nulls last进行调整', 'NULL', '1', '2019-11-09 18:54:43', null);

-- ----------------------------
-- Table structure for `oracle_keyword`
-- ----------------------------
DROP TABLE IF EXISTS `oracle_keyword`;
CREATE TABLE `oracle_keyword` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TIPS_ID` int(11) DEFAULT NULL,
  `KEY_WORD` varchar(50) DEFAULT NULL,
  `FUNCTION_FLG` tinyint(1) DEFAULT NULL,
  `GRAMMAR` varchar(100) DEFAULT NULL,
  `EXAMPLE_TEXT` varchar(100) DEFAULT NULL,
  `EXAMPLE_RESULT` varchar(100) DEFAULT NULL,
  `INFO` varchar(1000) DEFAULT NULL,
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDATE_DATE` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oracle_keyword
-- ----------------------------
INSERT INTO `oracle_keyword` VALUES ('1', '4', 'DML', '0', null, null, null, 'SELECT,UPDATE,INSERT,DELETE,MARGE', '2019-10-14 23:01:46', '2019-10-14 23:01:46');
INSERT INTO `oracle_keyword` VALUES ('2', '5', 'DDL', '0', null, null, null, 'CREATE,ALTER,DROP,RENAME,TRUNCATE,COMMENT', '2019-10-14 23:02:47', '2019-10-14 23:02:47');
INSERT INTO `oracle_keyword` VALUES ('3', '6', 'DCL', '0', null, null, null, 'GRANT,REVOKE', '2019-10-14 23:03:32', '2019-10-14 23:03:32');
INSERT INTO `oracle_keyword` VALUES ('4', '7', 'transaction', '0', null, null, null, 'COMMIT,ROLLBACK,SAVEPOINT', '2019-10-14 23:04:11', '2019-10-14 23:04:11');

-- ----------------------------
-- Table structure for `user_t`
-- ----------------------------
DROP TABLE IF EXISTS `user_t`;
CREATE TABLE `user_t` (
  `ID` int(8) DEFAULT NULL,
  `USER_NAME` varchar(20) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  `AGE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_t
-- ----------------------------

-- ----------------------------
-- Table structure for `xenoblade_blade`
-- ----------------------------
DROP TABLE IF EXISTS `xenoblade_blade`;
CREATE TABLE `xenoblade_blade` (
  `BLADE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `BLADE_NAME` varchar(20) DEFAULT NULL,
  `BLADE_TYPE` varchar(5) DEFAULT NULL,
  `BLADE_WEAPON` varchar(10) DEFAULT NULL,
  `BLADE_ATTR` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`BLADE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xenoblade_blade
-- ----------------------------

-- ----------------------------
-- Table structure for `xenoblade_monster`
-- ----------------------------
DROP TABLE IF EXISTS `xenoblade_monster`;
CREATE TABLE `xenoblade_monster` (
  `MONSTER_NAME` varchar(15) NOT NULL,
  `MONSTER_LEVEL` int(11) DEFAULT NULL,
  `MONSTER_PLACE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`MONSTER_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xenoblade_monster
-- ----------------------------

-- ----------------------------
-- Table structure for `xenoblade_skill`
-- ----------------------------
DROP TABLE IF EXISTS `xenoblade_skill`;
CREATE TABLE `xenoblade_skill` (
  `BLADE_ID` int(11) DEFAULT NULL,
  `SKILL_B_LEVEL1` varchar(40) DEFAULT NULL,
  `SKILL_B_LEVEL2` varchar(40) DEFAULT NULL,
  `SKILL_B_LEVEL3` varchar(40) DEFAULT NULL,
  `SKILL_B_LEVEL4` varchar(40) DEFAULT NULL,
  `SKILL_B_LEVEL5` varchar(40) DEFAULT NULL,
  `SKILL_C_LEVEL1` varchar(40) DEFAULT NULL,
  `SKILL_C_LEVEL2` varchar(40) DEFAULT NULL,
  `SKILL_C_LEVEL3` varchar(40) DEFAULT NULL,
  `SKILL_C_LEVEL4` varchar(40) DEFAULT NULL,
  `SKILL_C_LEVEL5` varchar(40) DEFAULT NULL,
  `SKILL_D_LEVEL1` varchar(40) DEFAULT NULL,
  `SKILL_D_LEVEL2` varchar(40) DEFAULT NULL,
  `SKILL_D_LEVEL3` varchar(40) DEFAULT NULL,
  `SKILL_D_LEVEL4` varchar(40) DEFAULT NULL,
  `SKILL_D_LEVEL5` varchar(40) DEFAULT NULL,
  `SKILL_E_LEVEL1` varchar(40) DEFAULT NULL,
  `SKILL_E_LEVEL2` varchar(40) DEFAULT NULL,
  `SKILL_E_LEVEL3` varchar(40) DEFAULT NULL,
  `SKILL_E_LEVEL4` varchar(40) DEFAULT NULL,
  `SKILL_E_LEVEL5` varchar(40) DEFAULT NULL,
  `SKILL_F_LEVEL1` varchar(40) DEFAULT NULL,
  `SKILL_F_LEVEL2` varchar(40) DEFAULT NULL,
  `SKILL_F_LEVEL3` varchar(40) DEFAULT NULL,
  `SKILL_F_LEVEL4` varchar(40) DEFAULT NULL,
  `SKILL_F_LEVEL5` varchar(40) DEFAULT NULL,
  `SKILL_G_LEVEL1` varchar(40) DEFAULT NULL,
  `SKILL_G_LEVEL2` varchar(40) DEFAULT NULL,
  `SKILL_G_LEVEL3` varchar(40) DEFAULT NULL,
  `SKILL_G_LEVEL4` varchar(40) DEFAULT NULL,
  `SKILL_G_LEVEL5` varchar(40) DEFAULT NULL,
  `SKILL_H_LEVEL1` varchar(40) DEFAULT NULL,
  `SKILL_H_LEVEL2` varchar(40) DEFAULT NULL,
  `SKILL_H_LEVEL3` varchar(40) DEFAULT NULL,
  `SKILL_H_LEVEL4` varchar(40) DEFAULT NULL,
  `SKILL_H_LEVEL5` varchar(40) DEFAULT NULL,
  `SKILL_I_LEVEL1` varchar(40) DEFAULT NULL,
  `SKILL_I_LEVEL2` varchar(40) DEFAULT NULL,
  `SKILL_I_LEVEL3` varchar(40) DEFAULT NULL,
  `SKILL_I_LEVEL4` varchar(40) DEFAULT NULL,
  `SKILL_I_LEVEL5` varchar(40) DEFAULT NULL,
  `SKILL_J_LEVEL1` varchar(40) DEFAULT NULL,
  `SKILL_J_LEVEL2` varchar(40) DEFAULT NULL,
  `SKILL_J_LEVEL3` varchar(40) DEFAULT NULL,
  `SKILL_J_LEVEL4` varchar(40) DEFAULT NULL,
  `SKILL_J_LEVEL5` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xenoblade_skill
-- ----------------------------
DROP TRIGGER IF EXISTS `feh_acter_master`;
DELIMITER ;;
CREATE TRIGGER `feh_acter_master` AFTER INSERT ON `feh_character` FOR EACH ROW BEGIN
  IF NEW.CHARACTER_ORIGIN IS NOT NULL AND NEW.CHARACTER_BASENAME IS NOT NULL
        THEN
     IF (SELECT ID FROM FEH_CHARACTER_MASTER WHERE CHARACTER_ORIGIN = NEW.CHARACTER_ORIGIN AND CHARACTER_NAME = NEW.CHARACTER_BASENAME) IS NULL
            THEN INSERT INTO FEH_CHARACTER_MASTER(CHARACTER_ORIGIN,CHARACTER_NAME) VALUES (NEW.CHARACTER_ORIGIN,NEW.CHARACTER_BASENAME);
     END IF;
  END IF;
    IF NEW.CHARACTER_SKILL_A IS NOT NULL AND NEW.CHARACTER_SKILL_A <> ''
        THEN
            IF (SELECT SKILL_NAME FROM FEH_SKILL_MASTER WHERE SKILL_TYPE = 'A' AND SKILL_NAME = NEW.CHARACTER_SKILL_A) IS NULL
                THEN INSERT INTO FEH_SKILL_MASTER (SKILL_TYPE,SKILL_NAME) VALUES ('A',NEW.CHARACTER_SKILL_A);
            END IF;
    END IF;
    IF NEW.CHARACTER_SKILL_B IS NOT NULL AND NEW.CHARACTER_SKILL_B <> ''
        THEN
            IF (SELECT SKILL_NAME FROM FEH_SKILL_MASTER WHERE SKILL_TYPE = 'B' AND SKILL_NAME = NEW.CHARACTER_SKILL_B) IS NULL
                THEN INSERT INTO FEH_SKILL_MASTER (SKILL_TYPE,SKILL_NAME) VALUES ('B',NEW.CHARACTER_SKILL_B);
            END IF;
    END IF;
    IF NEW.CHARACTER_SKILL_C IS NOT NULL AND NEW.CHARACTER_SKILL_C <> ''
        THEN
            IF (SELECT SKILL_NAME FROM FEH_SKILL_MASTER WHERE SKILL_TYPE = 'C' AND SKILL_NAME = NEW.CHARACTER_SKILL_C) IS NULL
                THEN INSERT INTO FEH_SKILL_MASTER (SKILL_TYPE,SKILL_NAME) VALUES ('C',NEW.CHARACTER_SKILL_C);
            END IF;
    END IF;
    IF NEW.CHARACTER_SKILL_D IS NOT NULL AND NEW.CHARACTER_SKILL_D <> ''
        THEN
            IF (SELECT SKILL_NAME FROM FEH_SKILL_MASTER WHERE SKILL_TYPE = 'D' AND SKILL_NAME = NEW.CHARACTER_SKILL_D) IS NULL
                THEN INSERT INTO FEH_SKILL_MASTER (SKILL_TYPE,SKILL_NAME) VALUES ('D',NEW.CHARACTER_SKILL_D);
            END IF;
    END IF;
    IF NEW.CHARACTER_SKILL_E IS NOT NULL AND NEW.CHARACTER_SKILL_E <> ''
        THEN
            IF (SELECT SKILL_NAME FROM FEH_SKILL_MASTER WHERE SKILL_TYPE = 'E' AND SKILL_NAME = NEW.CHARACTER_SKILL_E) IS NULL
                THEN INSERT INTO FEH_SKILL_MASTER (SKILL_TYPE,SKILL_NAME) VALUES ('E',NEW.CHARACTER_SKILL_E);
            END IF;
    END IF;
    IF NEW.CHARACTER_SKILL_S IS NOT NULL AND NEW.CHARACTER_SKILL_S <> ''
        THEN
            IF (SELECT SKILL_NAME FROM FEH_SKILL_MASTER WHERE SKILL_TYPE = 'S' AND SKILL_NAME = NEW.CHARACTER_SKILL_S) IS NULL
                THEN INSERT INTO FEH_SKILL_MASTER (SKILL_TYPE,SKILL_NAME) VALUES ('S',NEW.CHARACTER_SKILL_S);
            END IF;
    END IF;
    IF NEW.CHARACTER_WEAPON IS NOT NULL AND NEW.CHARACTER_WEAPON <> ''
        THEN
            IF (SELECT SKILL_NAME FROM FEH_SKILL_MASTER WHERE SKILL_TYPE = 'W' AND SKILL_NAME = NEW.CHARACTER_WEAPON) IS NULL
                THEN INSERT INTO FEH_SKILL_MASTER (SKILL_TYPE,SKILL_NAME) VALUES ('W',NEW.CHARACTER_WEAPON);
            END IF;
    END IF;
END
;;
DELIMITER ;

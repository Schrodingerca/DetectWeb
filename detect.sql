/*
 Navicat Premium Data Transfer

 Source Server         : localhost 8.0
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : localhost:3306
 Source Schema         : detect

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 04/03/2024 17:27:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `username`) USING BTREE,
  INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (2, '123', '设施类');
INSERT INTO `category` VALUES (3, '123', '动物类');
INSERT INTO `category` VALUES (4, '123', '食物和饮料类');
INSERT INTO `category` VALUES (5, '123', '家用物品类');
INSERT INTO `category` VALUES (23, '123', '交通类');
INSERT INTO `category` VALUES (29, 'admin', '动物');
INSERT INTO `category` VALUES (31, 'admin', '食物和水果');
INSERT INTO `category` VALUES (32, 'admin', '厨房用品');
INSERT INTO `category` VALUES (33, 'admin', '公共设施');
INSERT INTO `category` VALUES (34, 'admin', '交通工具');
INSERT INTO `category` VALUES (35, 'admin', '家居用品');
INSERT INTO `category` VALUES (36, 'admin', '运功器材');

-- ----------------------------
-- Table structure for imglist
-- ----------------------------
DROP TABLE IF EXISTS `imglist`;
CREATE TABLE `imglist`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `imgFile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_ci NOT NULL,
  `classes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `imgName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `detectTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of imglist
-- ----------------------------
INSERT INTO `imglist` VALUES (17, '123', 'File/image/detect/Transportation/bicycle_motorcycle.jpg', 'Transportation', 'bicycle,motorcycle', '2023年11月28日 14:56');
INSERT INTO `imglist` VALUES (19, '123', 'File/image/detect/facilityOrItem/sports ball_tennis racket_person.jpg', 'facilityOrItem', 'sports ball,tennis racket,person', '2023年11月29日 10:00');
INSERT INTO `imglist` VALUES (20, '123', 'File/image/detect/facilityOrItem/person_person_baseball bat_sports ball.jpg', 'facilityOrItem', 'person,person,baseball bat,sports ball', '2023年11月29日 10:04');
INSERT INTO `imglist` VALUES (21, '123', 'File/image/detect/Transportation/airplane.jpg', 'Transportation', 'airplane', '2023年12月07日 11:39');
INSERT INTO `imglist` VALUES (25, 'admin', 'File/image/detect/Animal/cow_cow.jpg', 'Animal', 'cow,cow', '2024年02月28日 10:32');
INSERT INTO `imglist` VALUES (42, 'admin', 'File/image/detect/Transportation/train.jpg', 'Transportation', 'train', '2024年03月04日 16:23');
INSERT INTO `imglist` VALUES (43, 'admin', 'File/image/detect/facilityOrItem/tennis racket_person.jpg', 'facilityOrItem', 'tennis racket,person', '2024年03月04日 16:23');
INSERT INTO `imglist` VALUES (44, 'admin', 'File/image/detect/Transportation/parking meter_parking meter_parking meter.jpg', 'Transportation', 'parking meter,parking meter,parking meter', '2024年03月04日 16:23');
INSERT INTO `imglist` VALUES (45, 'admin', 'File/image/detect/FoodAndBeverage/pizza_dining table_fork.jpg', 'FoodAndBeverage', 'pizza,dining table,fork', '2024年03月04日 16:23');
INSERT INTO `imglist` VALUES (46, 'admin', 'File/image/detect/Animal/cat.jpg', 'Animal', 'cat', '2024年03月04日 16:24');
INSERT INTO `imglist` VALUES (47, 'admin', 'File/image/detect/Transportation/car_car_car_car_car_car_car_car_car_stop sign.jpg', 'Transportation', 'car,car,car,car,car,car,car,car,car,stop sign', '2024年03月04日 16:24');
INSERT INTO `imglist` VALUES (48, 'admin', 'File/image/detect/Animal/zebra.jpg', 'Animal', 'zebra', '2024年03月04日 16:24');
INSERT INTO `imglist` VALUES (49, 'admin', 'File/image/detect/Transportation/person_person_bus_car_person_car_car_car_car_car_car_bus.jpg', 'Transportation', 'person,person,bus,car,person,car,car,car,car,car,car,bus', '2024年03月04日 16:24');
INSERT INTO `imglist` VALUES (50, 'admin', 'File/image/detect/FurnitureAndHousehold/clock_clock.jpg', 'FurnitureAndHousehold', 'clock,clock', '2024年03月04日 16:24');
INSERT INTO `imglist` VALUES (51, 'admin', 'File/image/detect/FurnitureAndHousehold/clock.jpg', 'FurnitureAndHousehold', 'clock', '2024年03月04日 16:25');

-- ----------------------------
-- Table structure for photolist
-- ----------------------------
DROP TABLE IF EXISTS `photolist`;
CREATE TABLE `photolist`  (
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `subcategory_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `img_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of photolist
-- ----------------------------
INSERT INTO `photolist` VALUES ('admin', 1, '动物类', '马', 'File/image/photoGallery/动物类/马/000000000090.jpg');
INSERT INTO `photolist` VALUES ('admin', 4, '公共设施', '停车标志', 'File/image/photoGallery/公共设施/停车标志/000000000771.jpg');
INSERT INTO `photolist` VALUES ('admin', 5, '动物类', '大象', 'File/image/photoGallery/动物类/大象/000000001371.jpg');
INSERT INTO `photolist` VALUES ('admin', 6, '公共设施', '消防栓', 'File/image/photoGallery/公共设施/消防栓/000000041004.jpg');
INSERT INTO `photolist` VALUES ('admin', 7, '动物类', '鸟', 'File/image/photoGallery/动物类/鸟/000000215646.jpg');
INSERT INTO `photolist` VALUES ('admin', 8, '家居用品', '时钟', 'File/image/photoGallery/家居用品/时钟/000000005771.jpg');
INSERT INTO `photolist` VALUES ('admin', 9, '动物类', '猫', 'File/image/photoGallery/动物类/猫/000000001773.jpg');
INSERT INTO `photolist` VALUES ('admin', 10, '家居用品', '马桶', 'File/image/photoGallery/家居用品/马桶/000000005980.jpg');
INSERT INTO `photolist` VALUES ('admin', 11, '食物和水果', '披萨', 'File/image/photoGallery/食物和水果/披萨/000000058010.jpg');
INSERT INTO `photolist` VALUES ('admin', 12, '交通工具', '摩托车', 'File/image/photoGallery/交通工具/摩托车/000000001482.jpg');
INSERT INTO `photolist` VALUES ('admin', 13, '动物类', '牛', 'File/image/photoGallery/动物类/牛/000000090153.jpg');
INSERT INTO `photolist` VALUES ('admin', 14, '食物和水果', '香蕉', 'File/image/photoGallery/食物和水果/香蕉/000000194629.jpg');
INSERT INTO `photolist` VALUES ('admin', 15, '运功器材', '棒球棒', 'File/image/photoGallery/运功器材/棒球棒/棒球棒.jpg');
INSERT INTO `photolist` VALUES ('admin', 16, '运功器材', '棒球手套', 'File/image/photoGallery/运功器材/棒球手套/棒球手套.jpg');
INSERT INTO `photolist` VALUES ('admin', 17, '家居用品', '背包', 'File/image/photoGallery/家居用品/背包/背包.jpg');
INSERT INTO `photolist` VALUES ('admin', 18, '厨房用品', '冰箱', 'File/image/photoGallery/厨房用品/冰箱/冰箱.jpg');
INSERT INTO `photolist` VALUES ('admin', 19, '厨房用品', '餐桌', 'File/image/photoGallery/厨房用品/餐桌/餐桌.jpg');
INSERT INTO `photolist` VALUES ('admin', 20, '交通工具', '船', 'File/image/photoGallery/交通工具/船/船.jpg');
INSERT INTO `photolist` VALUES ('admin', 21, '家居用品', '吹风机', 'File/image/photoGallery/家居用品/吹风机/吹风机.jpg');
INSERT INTO `photolist` VALUES ('admin', 22, '食物和水果', '蛋糕', 'File/image/photoGallery/食物和水果/蛋糕/蛋糕.jpg');
INSERT INTO `photolist` VALUES ('admin', 23, '家居用品', '电视', 'File/image/photoGallery/家居用品/电视/电视.jpg');
INSERT INTO `photolist` VALUES ('admin', 24, '运功器材', '飞盘', 'File/image/photoGallery/运功器材/飞盘/飞盘.jpg');
INSERT INTO `photolist` VALUES ('admin', 25, '运功器材', '风筝', 'File/image/photoGallery/运功器材/风筝/风筝.jpg');
INSERT INTO `photolist` VALUES ('admin', 26, '食物和水果', '胡萝卜', 'File/image/photoGallery/食物和水果/胡萝卜/胡萝卜.jpg');
INSERT INTO `photolist` VALUES ('admin', 27, '厨房用品', '酒杯', 'File/image/photoGallery/厨房用品/酒杯/酒杯.jpg');
INSERT INTO `photolist` VALUES ('admin', 28, '厨房用品', '烤面包机', 'File/image/photoGallery/厨房用品/烤面包机/烤面包机.jpg');
INSERT INTO `photolist` VALUES ('admin', 29, '食物和水果', '热狗', 'File/image/photoGallery/食物和水果/热狗/热狗.jpg');
INSERT INTO `photolist` VALUES ('admin', 30, '公共设施', '长凳', 'File/image/photoGallery/公共设施/长凳/长凳.jpg');
INSERT INTO `photolist` VALUES ('admin', 31, '交通工具', '自行车', 'File/image/photoGallery/交通工具/自行车/自行车.jpg');

-- ----------------------------
-- Table structure for photopath
-- ----------------------------
DROP TABLE IF EXISTS `photopath`;
CREATE TABLE `photopath`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `category_id` int NOT NULL,
  `subcategory_id` int NOT NULL,
  `imgPath` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE,
  INDEX `subcategory_id`(`subcategory_id`) USING BTREE,
  CONSTRAINT `category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `subcategory_id` FOREIGN KEY (`subcategory_id`) REFERENCES `subcategory` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of photopath
-- ----------------------------
INSERT INTO `photopath` VALUES (7, '123', 3, 6, 'File/image/photoGallery/动物类/狗/000000000229.jpg');
INSERT INTO `photopath` VALUES (54, 'admin', 33, 91, 'File/image/photoGallery/公共设施/停车标志/000000000771.jpg');
INSERT INTO `photopath` VALUES (55, 'admin', 29, 74, 'File/image/photoGallery/动物类/大象/000000001371.jpg');
INSERT INTO `photopath` VALUES (56, 'admin', 33, 58, 'File/image/photoGallery/公共设施/消防栓/000000041004.jpg');
INSERT INTO `photopath` VALUES (57, 'admin', 29, 60, 'File/image/photoGallery/动物类/鸟/000000215646.jpg');
INSERT INTO `photopath` VALUES (58, 'admin', 35, 117, 'File/image/photoGallery/家居用品/时钟/000000005771.jpg');
INSERT INTO `photopath` VALUES (59, 'admin', 29, 54, 'File/image/photoGallery/动物类/猫/000000001773.jpg');
INSERT INTO `photopath` VALUES (60, 'admin', 35, 110, 'File/image/photoGallery/家居用品/马桶/000000005980.jpg');
INSERT INTO `photopath` VALUES (61, 'admin', 31, 81, 'File/image/photoGallery/食物和水果/披萨/000000058010.jpg');
INSERT INTO `photopath` VALUES (62, 'admin', 34, 100, 'File/image/photoGallery/交通工具/摩托车/000000001482.jpg');
INSERT INTO `photopath` VALUES (63, 'admin', 29, 73, 'File/image/photoGallery/动物类/牛/000000090153.jpg');
INSERT INTO `photopath` VALUES (64, 'admin', 31, 56, 'File/image/photoGallery/食物和水果/香蕉/000000194629.jpg');
INSERT INTO `photopath` VALUES (65, 'admin', 36, 127, 'File/image/photoGallery/运功器材/棒球棒/棒球棒.jpg');
INSERT INTO `photopath` VALUES (66, 'admin', 36, 128, 'File/image/photoGallery/运功器材/棒球手套/棒球手套.jpg');
INSERT INTO `photopath` VALUES (67, 'admin', 35, 132, 'File/image/photoGallery/家居用品/背包/背包.jpg');
INSERT INTO `photopath` VALUES (68, 'admin', 32, 90, 'File/image/photoGallery/厨房用品/冰箱/冰箱.jpg');
INSERT INTO `photopath` VALUES (69, 'admin', 32, 86, 'File/image/photoGallery/厨房用品/餐桌/餐桌.jpg');
INSERT INTO `photopath` VALUES (70, 'admin', 34, 102, 'File/image/photoGallery/交通工具/船/船.jpg');
INSERT INTO `photopath` VALUES (71, 'admin', 35, 120, 'File/image/photoGallery/家居用品/吹风机/吹风机.jpg');
INSERT INTO `photopath` VALUES (72, 'admin', 31, 83, 'File/image/photoGallery/食物和水果/蛋糕/蛋糕.jpg');
INSERT INTO `photopath` VALUES (73, 'admin', 35, 111, 'File/image/photoGallery/家居用品/电视/电视.jpg');
INSERT INTO `photopath` VALUES (74, 'admin', 36, 122, 'File/image/photoGallery/运功器材/飞盘/飞盘.jpg');
INSERT INTO `photopath` VALUES (75, 'admin', 36, 126, 'File/image/photoGallery/运功器材/风筝/风筝.jpg');
INSERT INTO `photopath` VALUES (76, 'admin', 31, 78, 'File/image/photoGallery/食物和水果/胡萝卜/胡萝卜.jpg');
INSERT INTO `photopath` VALUES (77, 'admin', 32, 104, 'File/image/photoGallery/厨房用品/酒杯/酒杯.jpg');
INSERT INTO `photopath` VALUES (78, 'admin', 32, 88, 'File/image/photoGallery/厨房用品/烤面包机/烤面包机.jpg');
INSERT INTO `photopath` VALUES (79, 'admin', 31, 80, 'File/image/photoGallery/食物和水果/热狗/热狗.jpg');
INSERT INTO `photopath` VALUES (80, 'admin', 33, 93, 'File/image/photoGallery/公共设施/长凳/长凳.jpg');
INSERT INTO `photopath` VALUES (81, 'admin', 34, 98, 'File/image/photoGallery/交通工具/自行车/自行车.jpg');

-- ----------------------------
-- Table structure for subcategory
-- ----------------------------
DROP TABLE IF EXISTS `subcategory`;
CREATE TABLE `subcategory`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `category_id` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE,
  CONSTRAINT `subcategory_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 135 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subcategory
-- ----------------------------
INSERT INTO `subcategory` VALUES (4, '123', '鸟', 3);
INSERT INTO `subcategory` VALUES (5, '123', '猫', 3);
INSERT INTO `subcategory` VALUES (6, '123', '狗', 3);
INSERT INTO `subcategory` VALUES (8, '123', '长椅', 2);
INSERT INTO `subcategory` VALUES (9, '123', '电视', 5);
INSERT INTO `subcategory` VALUES (10, '123', '香蕉', 4);
INSERT INTO `subcategory` VALUES (11, '123', '苹果', 4);
INSERT INTO `subcategory` VALUES (29, '123', '消防栓', 2);
INSERT INTO `subcategory` VALUES (31, '123', '汽车', 23);
INSERT INTO `subcategory` VALUES (32, '123', '飞机', 23);
INSERT INTO `subcategory` VALUES (54, 'admin', '猫', 29);
INSERT INTO `subcategory` VALUES (56, 'admin', '香蕉', 31);
INSERT INTO `subcategory` VALUES (57, 'admin', '勺子', 32);
INSERT INTO `subcategory` VALUES (58, 'admin', '消防栓', 33);
INSERT INTO `subcategory` VALUES (59, 'admin', '长颈鹿', 29);
INSERT INTO `subcategory` VALUES (60, 'admin', '鸟', 29);
INSERT INTO `subcategory` VALUES (61, 'admin', '狗', 29);
INSERT INTO `subcategory` VALUES (69, 'admin', '飞机', 34);
INSERT INTO `subcategory` VALUES (70, 'admin', '苹果', 31);
INSERT INTO `subcategory` VALUES (71, 'admin', '马', 29);
INSERT INTO `subcategory` VALUES (72, 'admin', '羊', 29);
INSERT INTO `subcategory` VALUES (73, 'admin', '牛', 29);
INSERT INTO `subcategory` VALUES (74, 'admin', '大象', 29);
INSERT INTO `subcategory` VALUES (75, 'admin', '熊', 29);
INSERT INTO `subcategory` VALUES (76, 'admin', '斑马', 29);
INSERT INTO `subcategory` VALUES (77, 'admin', '西兰花', 31);
INSERT INTO `subcategory` VALUES (78, 'admin', '胡萝卜', 31);
INSERT INTO `subcategory` VALUES (79, 'admin', '三明治', 31);
INSERT INTO `subcategory` VALUES (80, 'admin', '热狗', 31);
INSERT INTO `subcategory` VALUES (81, 'admin', '披萨', 31);
INSERT INTO `subcategory` VALUES (82, 'admin', '甜甜圈', 31);
INSERT INTO `subcategory` VALUES (83, 'admin', '蛋糕', 31);
INSERT INTO `subcategory` VALUES (84, 'admin', '橙子', 31);
INSERT INTO `subcategory` VALUES (85, 'admin', '微波炉', 32);
INSERT INTO `subcategory` VALUES (86, 'admin', '餐桌', 32);
INSERT INTO `subcategory` VALUES (87, 'admin', '烤箱', 32);
INSERT INTO `subcategory` VALUES (88, 'admin', '烤面包机', 32);
INSERT INTO `subcategory` VALUES (89, 'admin', '水槽', 32);
INSERT INTO `subcategory` VALUES (90, 'admin', '冰箱', 32);
INSERT INTO `subcategory` VALUES (91, 'admin', '停车标志', 33);
INSERT INTO `subcategory` VALUES (92, 'admin', '停车计时器', 33);
INSERT INTO `subcategory` VALUES (93, 'admin', '长凳', 33);
INSERT INTO `subcategory` VALUES (94, 'admin', '杯子', 32);
INSERT INTO `subcategory` VALUES (95, 'admin', '刀', 32);
INSERT INTO `subcategory` VALUES (96, 'admin', '叉', 32);
INSERT INTO `subcategory` VALUES (97, 'admin', '碗', 32);
INSERT INTO `subcategory` VALUES (98, 'admin', '自行车', 34);
INSERT INTO `subcategory` VALUES (99, 'admin', '汽车', 34);
INSERT INTO `subcategory` VALUES (100, 'admin', '摩托车', 34);
INSERT INTO `subcategory` VALUES (101, 'admin', '公共汽车', 34);
INSERT INTO `subcategory` VALUES (102, 'admin', '船', 34);
INSERT INTO `subcategory` VALUES (103, 'admin', '瓶子', 32);
INSERT INTO `subcategory` VALUES (104, 'admin', '酒杯', 32);
INSERT INTO `subcategory` VALUES (105, 'admin', '椅子', 35);
INSERT INTO `subcategory` VALUES (106, 'admin', '沙发', 35);
INSERT INTO `subcategory` VALUES (107, 'admin', '盆栽', 35);
INSERT INTO `subcategory` VALUES (108, 'admin', '床', 35);
INSERT INTO `subcategory` VALUES (109, 'admin', '餐桌', 35);
INSERT INTO `subcategory` VALUES (110, 'admin', '马桶', 35);
INSERT INTO `subcategory` VALUES (111, 'admin', '电视', 35);
INSERT INTO `subcategory` VALUES (112, 'admin', '笔记本', 35);
INSERT INTO `subcategory` VALUES (113, 'admin', '鼠标', 35);
INSERT INTO `subcategory` VALUES (114, 'admin', '遥控器', 35);
INSERT INTO `subcategory` VALUES (115, 'admin', '键盘', 35);
INSERT INTO `subcategory` VALUES (116, 'admin', '手机', 35);
INSERT INTO `subcategory` VALUES (117, 'admin', '时钟', 35);
INSERT INTO `subcategory` VALUES (118, 'admin', '花瓶', 35);
INSERT INTO `subcategory` VALUES (119, 'admin', '剪刀', 35);
INSERT INTO `subcategory` VALUES (120, 'admin', '吹风机', 35);
INSERT INTO `subcategory` VALUES (121, 'admin', '牙刷', 35);
INSERT INTO `subcategory` VALUES (122, 'admin', '飞盘', 36);
INSERT INTO `subcategory` VALUES (123, 'admin', '网球拍', 36);
INSERT INTO `subcategory` VALUES (124, 'admin', '滑雪板', 36);
INSERT INTO `subcategory` VALUES (125, 'admin', '球', 36);
INSERT INTO `subcategory` VALUES (126, 'admin', '风筝', 36);
INSERT INTO `subcategory` VALUES (127, 'admin', '棒球棒', 36);
INSERT INTO `subcategory` VALUES (128, 'admin', '棒球手套', 36);
INSERT INTO `subcategory` VALUES (129, 'admin', '滑板', 36);
INSERT INTO `subcategory` VALUES (130, 'admin', '冲浪板', 36);
INSERT INTO `subcategory` VALUES (131, 'admin', '雨伞', 35);
INSERT INTO `subcategory` VALUES (132, 'admin', '背包', 35);
INSERT INTO `subcategory` VALUES (133, 'admin', '领带', 35);
INSERT INTO `subcategory` VALUES (134, 'admin', '手提箱', 35);
INSERT INTO `subcategory` VALUES (135, 'admin', '火车', 34);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '123', '123');
INSERT INTO `user` VALUES (2, '11', '11');
INSERT INTO `user` VALUES (4, '2', '2');
INSERT INTO `user` VALUES (8, '1', '1');
INSERT INTO `user` VALUES (13, '13', '13');
INSERT INTO `user` VALUES (21, 'admin', '123456');

SET FOREIGN_KEY_CHECKS = 1;

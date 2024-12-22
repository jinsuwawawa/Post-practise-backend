/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80200
 Source Host           : localhost:3306
 Source Schema         : course_management

 Target Server Type    : MySQL
 Target Server Version : 80200
 File Encoding         : 65001

 Date: 19/12/2024 19:02:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for announcements
-- ----------------------------
DROP TABLE IF EXISTS `announcements`;
CREATE TABLE `announcements`  (
  `announcement_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '公告ID，自增主键',
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '公告标题，不为空',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '公告内容，不为空 ',
  `created_by` int(0) NULL DEFAULT NULL COMMENT '创建者用户ID，外键关联至用户表 ',
  `created_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '记录创建时间 ',
  PRIMARY KEY (`announcement_id`) USING BTREE,
  INDEX `created_by`(`created_by`) USING BTREE,
  CONSTRAINT `announcements_ibfk_1` FOREIGN KEY (`created_by`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '公告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of announcements
-- ----------------------------

-- ----------------------------
-- Table structure for code_repositories
-- ----------------------------
DROP TABLE IF EXISTS `code_repositories`;
CREATE TABLE `code_repositories`  (
  `repo_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '仓库ID，自增主键',
  `repo_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '仓库名称，不为空',
  `repo_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '仓库URL，不为空',
  `created_by` int(0) NULL DEFAULT NULL COMMENT '创建者用户id,外键关联至用户表',
  `created_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '记录创建时间',
  PRIMARY KEY (`repo_id`) USING BTREE,
  INDEX `created_by`(`created_by`) USING BTREE,
  CONSTRAINT `code_repositories_ibfk_1` FOREIGN KEY (`created_by`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '代码仓库表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of code_repositories
-- ----------------------------

-- ----------------------------
-- Table structure for file_storage
-- ----------------------------
DROP TABLE IF EXISTS `file_storage`;
CREATE TABLE `file_storage`  (
  `file_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '文件ID，自增主键',
  `file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件名称，不为空',
  `file_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件路径，不为空',
  `uploader_id` int(0) NULL DEFAULT NULL COMMENT '上传者用户ID，外键关联至用户表',
  `uploaded_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '记录上传时间',
  PRIMARY KEY (`file_id`) USING BTREE,
  INDEX `uploader_id`(`uploader_id`) USING BTREE,
  CONSTRAINT `file_storage_ibfk_1` FOREIGN KEY (`uploader_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '网盘资源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of file_storage
-- ----------------------------

-- ----------------------------
-- Table structure for group_members
-- ----------------------------
DROP TABLE IF EXISTS `group_members`;
CREATE TABLE `group_members`  (
  `group_id` int(0) NOT NULL COMMENT '分组ID，外键关联至分组表 ',
  `user_id` int(0) NOT NULL COMMENT '分组ID，外键关联至分组表 ',
  PRIMARY KEY (`group_id`, `user_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `group_members_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `groups` (`group_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `group_members_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '分组成员关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of group_members
-- ----------------------------
INSERT INTO `group_members` VALUES (1, 1);
INSERT INTO `group_members` VALUES (1, 3);
INSERT INTO `group_members` VALUES (2, 4);

-- ----------------------------
-- Table structure for groups
-- ----------------------------
DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups`  (
  `group_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '分组ID，自增主键 ',
  `group_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '分组名称，不为空 ',
  `group_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '组别',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '分组描述信息',
  `created_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '分组描述信息',
  `max_people` int(0) NULL DEFAULT NULL COMMENT '最大人数',
  PRIMARY KEY (`group_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '分组表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of groups
-- ----------------------------
INSERT INTO `groups` VALUES (1, '第一组', '一号', NULL, '2024-12-19 13:35:54', 8);
INSERT INTO `groups` VALUES (2, '第二组', '二号', NULL, '2024-12-19 14:06:06', 8);

-- ----------------------------
-- Table structure for presentation_times
-- ----------------------------
DROP TABLE IF EXISTS `presentation_times`;
CREATE TABLE `presentation_times`  (
  `time_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '时间ID，自增主键',
  `week_number` int(0) NOT NULL COMMENT '周数，不为空',
  `max_capacity` int(0) NULL DEFAULT 8 COMMENT '每周分享最大人数限制，默认为8',
  `available_slots` int(0) NULL DEFAULT 8 COMMENT '可用分享时间槽数量，默认为8',
  `week_place` int(0) NULL DEFAULT NULL COMMENT '位次',
  PRIMARY KEY (`time_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '分享时间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of presentation_times
-- ----------------------------
INSERT INTO `presentation_times` VALUES (1, 1, 8, 8, 1);
INSERT INTO `presentation_times` VALUES (2, 2, 8, 8, 2);

-- ----------------------------
-- Table structure for resources
-- ----------------------------
DROP TABLE IF EXISTS `resources`;
CREATE TABLE `resources`  (
  `resource_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '资源ID，自增主键',
  `resource_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '资源名称，不为空 ',
  `file_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '资源文件路径，不为空',
  `uploaded_by` int(0) NULL DEFAULT NULL COMMENT '上传者用户ID，外键关联至用户表 ',
  `uploaded_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '记录上传时间',
  PRIMARY KEY (`resource_id`) USING BTREE,
  INDEX `uploaded_by`(`uploaded_by`) USING BTREE,
  CONSTRAINT `resources_ibfk_1` FOREIGN KEY (`uploaded_by`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '资源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resources
-- ----------------------------

-- ----------------------------
-- Table structure for tasks
-- ----------------------------
DROP TABLE IF EXISTS `tasks`;
CREATE TABLE `tasks`  (
  `task_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '任务ID，自增主键',
  `task_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '任务名称，不为空',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '任务描述信息',
  `assigned_to` int(0) NULL DEFAULT NULL COMMENT '被分配给的用户ID，外键关联至用户表',
  `status` enum('todo','in_progress','completed') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'todo' COMMENT '任务状态',
  `created_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '记录创建时间',
  `updated_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '记录创建时间',
  PRIMARY KEY (`task_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '项目任务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tasks
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户ID，自增主键 ',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名，唯一且不为空',
  `password` char(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码哈希值，不为空',
  `email` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户邮箱，唯一且不为空',
  `totp_secret` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'TOTP密钥，用于双因素身份验证',
  `is_active` tinyint(1) NULL DEFAULT 1 COMMENT '用户账号是否激活，默认为真',
  `role` tinyint(0) NOT NULL COMMENT '角色字面量，0组员1组长2管理员',
  `created_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '记录创建时间',
  `updated_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '记录更新时间',
  `is_leader` int(0) NULL DEFAULT 0 COMMENT '是否是组长（1是组长 默认为0）',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表（用户与权限管理模块）' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '吴彦祖', '123456', '1', NULL, 1, 1, '2024-12-19 13:36:23', '2024-12-19 13:59:02', 1);
INSERT INTO `users` VALUES (3, '组员一', '123456', '2', NULL, 1, 1, '2024-12-19 13:58:54', '2024-12-19 13:59:03', 0);
INSERT INTO `users` VALUES (4, '组员二', '123', '3', NULL, 1, 1, '2024-12-19 14:06:43', '2024-12-19 14:08:17', 1);

-- ----------------------------
-- Table structure for week_user
-- ----------------------------
DROP TABLE IF EXISTS `week_user`;
CREATE TABLE `week_user`  (
  `time_id` int(0) NULL DEFAULT NULL,
  `user_id` int(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of week_user
-- ----------------------------
INSERT INTO `week_user` VALUES (1, 1);

SET FOREIGN_KEY_CHECKS = 1;

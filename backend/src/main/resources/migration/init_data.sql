DROP TABLE IF EXISTS user;
CREATE TABLE user (
    `id`            BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `name`          VARCHAR(255) COLLATE utf8_bin NULL DEFAULT NULL COMMENT '姓名',
    `email`         VARCHAR(255) COLLATE utf8_bin NULL DEFAULT NULL COMMENT '邮箱',
    `password`      VARCHAR(255) COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
    `age`           INT(11)                       NULL DEFAULT NULL COMMENT '年龄',
    `updated_at`    datetime                      NULL DEFAULT NULL COMMENT '更新时间',
    `created_at`    datetime                      NULL DEFAULT NULL COMMENT '创建时间',
    `is_delete`     tinyint(1)                         DEFAULT '0'  COMMENT '是否被删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARSET = utf8mb4 COMMENT = '用户表';

DELETE FROM user;
INSERT INTO user (id, name, age, email, password) VALUES
(1, 'Jone', 18, 'test1@baomidou.com', '$2a$10$LxrNJR7YvZxOEfJv9yiqoeEDyPpcpSFoTJ6pjYx0nLWtchBuuZu1S'),
(2, 'Jack', 20, 'test2@baomidou.com', '$2a$10$LxrNJR7YvZxOEfJv9yiqoeEDyPpcpSFoTJ6pjYx0nLWtchBuuZu1S'),
(3, 'Tom', 28, 'test3@baomidou.com', '$2a$10$LxrNJR7YvZxOEfJv9yiqoeEDyPpcpSFoTJ6pjYx0nLWtchBuuZu1S'),
(4, 'Sandy', 21, 'test4@baomidou.com', '$2a$10$LxrNJR7YvZxOEfJv9yiqoeEDyPpcpSFoTJ6pjYx0nLWtchBuuZu1S'),
(5, 'Billie', 24, 'test5@baomidou.com', '$2a$10$LxrNJR7YvZxOEfJv9yiqoeEDyPpcpSFoTJ6pjYx0nLWtchBuuZu1S');

DROP TABLE IF EXISTS role;
CREATE TABLE role (
    `id`            BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `name`          VARCHAR(255) COLLATE utf8_bin NULL DEFAULT NULL COMMENT '角色字段',
    `role_name`     VARCHAR(255) COLLATE utf8_bin NULL DEFAULT NULL COMMENT '角色名称',
    `updated_at`    datetime                      NULL DEFAULT NULL COMMENT '更新时间',
    `created_at`    datetime                      NULL DEFAULT NULL COMMENT '创建时间',
    `is_delete`     tinyint(1)                         DEFAULT '0'  COMMENT '是否被删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARSET = utf8mb4 COMMENT = '角色表';

DELETE FROM role;
INSERT INTO role (id, name, role_name) VALUES
(1, 'admin', '管理员'),
(2, 'visitor', '访客');

DROP TABLE IF EXISTS user_role_association;
CREATE TABLE user_role_association (
    `id`            BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `user_id`       BIGINT(20) NULL DEFAULT NULL COMMENT '用户ID',
    `role_id`       BIGINT(20) NULL DEFAULT NULL COMMENT '角色ID',
    `updated_at`    datetime   NULL DEFAULT NULL COMMENT '更新时间',
    `created_at`    datetime   NULL DEFAULT NULL COMMENT '创建时间',
    `is_delete`     tinyint(1)      DEFAULT '0'  COMMENT '是否被删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARSET = utf8mb4 COMMENT = '用户角色关联表';

DELETE FROM user_role_association;
INSERT INTO user_role_association (id, user_id, role_id) VALUES
(1, 1, 1),
(2, 1, 2);

DROP TABLE IF EXISTS feat;
CREATE TABLE feat (
    `id`            BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `name`          VARCHAR(255) COLLATE utf8_bin NULL DEFAULT NULL COMMENT '功能字段',
    `feat_name`  VARCHAR(255) COLLATE utf8_bin NULL DEFAULT NULL COMMENT '功能名称',
    `updated_at`    datetime                      NULL DEFAULT NULL COMMENT '更新时间',
    `created_at`    datetime                      NULL DEFAULT NULL COMMENT '创建时间',
    `is_delete`     tinyint(1)                         DEFAULT '0'  COMMENT '是否被删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARSET = utf8mb4 COMMENT = '权限功能表';

DELETE FROM feat;
INSERT INTO feat (id, name, feat_name) VALUES
(1, 'user:browse:*', '用户列表浏览权限'),
(2, 'user:edit:*', '用户编辑权限');

DROP TABLE IF EXISTS role_feat_association;
CREATE TABLE role_feat_association (
    `id`            BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `feat_id`    BIGINT(20) NULL DEFAULT NULL COMMENT '用户ID',
    `role_id`       BIGINT(20) NULL DEFAULT NULL COMMENT '角色ID',
    `updated_at`    datetime   NULL DEFAULT NULL COMMENT '更新时间',
    `created_at`    datetime   NULL DEFAULT NULL COMMENT '创建时间',
    `is_delete`     tinyint(1)      DEFAULT '0'  COMMENT '是否被删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARSET = utf8mb4 COMMENT = '角色功能关联表';

DELETE FROM role_feat_association;
INSERT INTO role_feat_association (id, role_id, feat_id) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 2, 1);

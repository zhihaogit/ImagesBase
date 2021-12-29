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
INSERT INTO user (id, name, age, email) VALUES
(1, 'Jone', 18, 'test1@baomidou.com'),
(2, 'Jack', 20, 'test2@baomidou.com'),
(3, 'Tom', 28, 'test3@baomidou.com'),
(4, 'Sandy', 21, 'test4@baomidou.com'),
(5, 'Billie', 24, 'test5@baomidou.com');

DROP TABLE IF EXISTS role;
CREATE TABLE role (
    `id`            BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `name`          VARCHAR(255) COLLATE utf8_bin NULL DEFAULT NULL COMMENT '角色名称',
    `updated_at`    datetime                      NULL DEFAULT NULL COMMENT '更新时间',
    `created_at`    datetime                      NULL DEFAULT NULL COMMENT '创建时间',
    `is_delete`     tinyint(1)                         DEFAULT '0'  COMMENT '是否被删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARSET = utf8mb4 COMMENT = '角色表';

DELETE FROM role;
INSERT INTO role (id, name) VALUES
(1, 'admin'),
(2, 'visitor');

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
(2, 1, 2),
(3, 2, 2);

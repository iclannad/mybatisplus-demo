DROP TABLE IF EXISTS sys_user;

CREATE TABLE sys_user
(
    uid        VARCHAR(128) NOT NULL COMMENT '主键ID',
    user_name  VARCHAR(30)  NULL DEFAULT NULL COMMENT '姓名',
    age        INT          NULL DEFAULT NULL COMMENT '年龄',
    email      VARCHAR(50)  NULL DEFAULT NULL COMMENT '邮箱',
    sex        int               DEFAULT 0 COMMENT '0-male,1-female',
    is_deleted int               DEFAULT 0 COMMENT '逻辑删除',
    PRIMARY KEY (uid)
);
-- 主页帖子信息表
create table if not exists postInfo(
    id int primary key auto_increment,
    createtime datetime DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
    title varchar (100) DEFAULT NULL COMMENT '标题',
    content varchar (500) DEFAULT NULL COMMENT '内容',
    source varchar (10) DEFAULT NULL COMMENT '内容来源',
    source_url varchar (100) DEFAULT NULL COMMENT '来源网站',
    owner_id int DEFAULT NULL COMMENT '发布者id',
    owner_img varchar(100) DEFAULT NULL COMMENT '发布者头像',
    owner_name varchar(20) DEFAULT NULL COMMENT '发布者名字',
    publishtime date DEFAULT NULL COMMENT '发布时间',
    freshtime date DEFAULT NULL COMMENT  '最后刷新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 用户表
create table if not exists user(
    id int primary key auto_increment,
    user_name varchar (20) DEFAULT NULL COMMENT '昵称',
    city varchar(64) DEFAULT NULL COMMENT '城市',
    sex tinyint(2) DEFAULT '-1' COMMENT '0表示女，1表示男',
    user_img varchar(100) DEFAULT NULL COMMENT '头像',
    registertime date DEFAULT NULL COMMENT '注册时间',
    birthday date DEFAULT NULL COMMENT '生日',
    phone varchar(64) DEFAULT NULL COMMENT '手机号',
    sign varchar(524) DEFAULT NULL COMMENT '个人签名'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
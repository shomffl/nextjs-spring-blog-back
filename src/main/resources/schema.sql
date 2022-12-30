create database if not exists blog;

use blog;

create table if not exists blog.post(
    id bigint unsigned not null auto_increment comment "投稿ID",
    title varchar(50) not null comment "タイトル",
    body varchar(200) not null comment "本文",
    create_time datetime not null default current_timestamp comment "作成日時",
    update_time datetime not null default current_timestamp on update current_timestamp comment "更新日時",
    primary key(id)
    )engine innodb character set utf8mb4 comment "商品テーブル";

package me.xueyao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Simon.Xue
 * @date 1/28/21 9:22 AM
 **/
@Entity
@Table(name = "user")
@Getter
@Setter
@Accessors(chain = true)
public class User extends Base {
    @Column(name = "username", columnDefinition = "varchar(32) not null comment '用户名'")
    private String username;
    @Column(name = "password", columnDefinition = "varchar(64) not null comment '密码'")
    private String password;
    @Column(name = "nickname", columnDefinition = "varchar(32) not null default '' comment '昵称'")
    private String nickname;
}

package me.xueyao.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description 用户
 * @author simon
 */
@Data
@Table(name = "user")
@Entity
@Accessors(chain = true)

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition ="int not null auto_increment")
    private String id;

    @ApiModelProperty(value = "用户名")
    @Column(name = "username", columnDefinition = "varchar(64) comment '用户名'")
    private String username;

    @ApiModelProperty(value = "密码")
    @Column(name = "password", columnDefinition = "varchar(255) comment '密码'")
    private String password;

    @ApiModelProperty(value = "盐")
    @Column(name = "salt", columnDefinition = "varchar(64) comment '盐'")
    private String salt;

    @ApiModelProperty(value = "昵称")
    @Column(name = "nickname", columnDefinition = "varchar(64) comment '昵称'")
    private String nickname;

    @ApiModelProperty(value = "手机号")
    @Column(name = "mobile", columnDefinition = "varchar(64) comment '手机号'")
    private String mobile;

    @ApiModelProperty(value = "邮箱")
    @Column(name = "email", columnDefinition = "varchar(64) comment '创建时间'")
    private String email;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_time", columnDefinition = "datetime default current_timestamp comment '创建时间'")
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @Column(name = "update_time", columnDefinition = "datetime default current_timestamp on update current_timestamp comment '更新时间'")
    private LocalDateTime updateTime;

}
package me.xueyao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Simon.Xue
 * @date 1/28/21 9:26 AM
 **/
@Getter
@Setter
@Accessors(chain = true)
@MappedSuperclass
public class Base implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "removed", columnDefinition = "bit(1) default 0 comment '是否删除 0未删除 1删除'")
    private Boolean removed = false;
    @Column(name = "creator", columnDefinition = "varchar(64) not null comment '创建者'")
    private String creator;
    @Column(name = "updater", columnDefinition = "varchar(64) comment '更新者'")
    private String updater;
    @Column(name = "createTime", columnDefinition = "timestamp default current_timestamp comment '创建时间'")
    private Date createTime;
    @Column(name = "updateTime", columnDefinition = "timestamp default current_timestamp on update current_timestamp comment '更新时间'")
    private Date updateTime;
}

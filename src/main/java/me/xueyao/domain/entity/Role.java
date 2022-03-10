package me.xueyao.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description:
 * @author: Simon.Xue
 * @date: 2019-02-17 22:15
 **/
@Data
@Table(name = "role")
@SQLDelete(sql = "update role set use_deleted = 1 where id = ?")
@Entity
@Accessors(chain = true)

@Where(clause = "use_deleted = 0")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition ="int not null auto_increment")
    private Integer id;

    @ApiModelProperty(value = "角色名")
    @Column(name = "role_name", columnDefinition = "varchar(64) comment '角色名'")
    private String roleName;
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

    /**
     * 是否删除 0未删除 1删除
     */
    @ApiModelProperty(value = "是否删除 0未删除 1删除")
    @Column(name = "user_deleted", columnDefinition = "bit(1) default 0 comment '是否删除 0未删除 1删除'")
    private Integer useDeleted;
}

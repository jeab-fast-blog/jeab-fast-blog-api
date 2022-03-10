package me.xueyao.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description:
 * @author: Simon.Xue
 * @date: 2019-02-17 22:20
 **/
@Data
@Table(name = "permission")
@Entity
@SQLDelete(sql = "update permission set use_deleted = 1 where id = ?")

public class Permission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition ="int not null auto_increment")
    private Integer id;
    /**
     * 权限名称
     */
    @ApiModelProperty(value = "权限名称")
    @Column(name = "permission_name", columnDefinition = "varchar(64)  comment '权限名称'")
    private String permissionName;
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

    @ApiModelProperty(value = "是否删除 0未删除 1删除")
    @Column(name = "use_deleted", columnDefinition = "bit(1) default 0 comment '是否删除 0未删除 1删除'")
    private Integer useDeleted;


}

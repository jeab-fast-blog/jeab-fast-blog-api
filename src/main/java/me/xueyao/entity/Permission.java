package me.xueyao.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
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
@DynamicInsert
@DynamicUpdate
public class Permission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ApiModelProperty(value = "")
    private String permissionName;
    @ApiModelProperty(value = "")
    private LocalDateTime createTime;
    @ApiModelProperty(value = "")
    private LocalDateTime updateTime;
    @ApiModelProperty(value = "")
    private Integer useDeleted;


}

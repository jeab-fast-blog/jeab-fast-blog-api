package me.xueyao.entity;

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
@SQLDelete(sql = "update permission set is_deleted = 1 where id = ?")
@DynamicInsert
@DynamicUpdate
public class Permission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String permissionName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer isDeleted;


}

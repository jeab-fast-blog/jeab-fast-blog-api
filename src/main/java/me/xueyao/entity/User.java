package me.xueyao.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @description 用户
 * @author simon
 */
@Data
@Table(name = "user")
@Entity
@Accessors(chain = true)
@DynamicInsert
@DynamicUpdate
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private Integer roleId;

    private String username;

    private String password;

    private String salt;

    private String nickname;

    private String mobile;

    private String email;

    private Date createTime;

    private Date updateTime;

}
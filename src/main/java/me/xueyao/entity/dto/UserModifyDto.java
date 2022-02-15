package me.xueyao.entity.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @description 用户
 * @author simon
 */
@Data
@Accessors(chain = true)
public class UserModifyDto implements Serializable {
    private String id;

    private String username;

    private String nickname;

    private String mobile;

    private String email;

    private Integer roleId;

}
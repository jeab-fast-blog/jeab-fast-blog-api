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
public class UserAddDto implements Serializable {

    private String username;

    private String password;

    private String nickname;

    private String mobile;

    private String email;

}
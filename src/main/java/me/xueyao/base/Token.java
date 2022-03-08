package me.xueyao.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author simonxue
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Token implements Serializable {

    /**
     * 用户系统编号
     */
    private String userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    private String mobile;

    /**
     * 用户登陆时的IP地址，若使用移动蜂窝网络，IP地址限制无效
     */
    private String ip;

}

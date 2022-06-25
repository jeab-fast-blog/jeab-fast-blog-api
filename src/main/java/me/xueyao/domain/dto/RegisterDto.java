package me.xueyao.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * 注册
 * @author Simon.Xue
 * @date 2022-06-24 23:15:15
 **/
@Getter
@Setter
@NoArgsConstructor
public class RegisterDto implements Serializable {
    @NotEmpty(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名")
    private String username;

    @NotEmpty(message = "密码不能为空")
    @ApiModelProperty(value = "密码")
    private String password;

    @NotEmpty(message = "确认密码不能为空")
    @ApiModelProperty(value = "确认密码")
    private String rePassword;
}

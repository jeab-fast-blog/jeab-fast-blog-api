package me.xueyao.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author Simon.Xue
 * @date 2019-12-15 22:31
 **/
@Data
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

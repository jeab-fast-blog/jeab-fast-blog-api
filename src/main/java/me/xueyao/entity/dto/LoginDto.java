package me.xueyao.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author Simon.Xue
 * @date 1/28/21 2:46 PM
 **/
@Getter
@Setter
@NoArgsConstructor
public class LoginDto implements Serializable {
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @NotEmpty(message = "密码不能为空")
    private String password;
}

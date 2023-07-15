package me.xueyao.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author Simon.Xue
 * @date 2023/7/15 07:54
 **/
@Getter
@Setter
@NoArgsConstructor
public class ForgetPasswordDto implements Serializable {
    @NotEmpty(message = "邮箱地址不能为空")
    @ApiModelProperty(value = "邮箱")
    private String email;
}

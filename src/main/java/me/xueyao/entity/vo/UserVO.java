package me.xueyao.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 *
 * @author Simon.Xue
 * @date 1/28/21 9:22 AM
 **/
@Data
@Accessors(chain = true)
public class UserVO implements Serializable {
    private String id;
    private String username;
    private String nickname;
}

package me.xueyao.domain.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @description:
 * @author: Simon.Xue
 * @date: 2019-02-17 22:20
 **/
@Data
@Accessors(chain = true)
public class PermissionVo implements Serializable {
    private Integer id;
    private String permissionName;

}

package me.xueyao.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @description: 常规选项
 * @author: Simon.Xue
 * @date: 2019-02-26 12:37
 **/
@Data
@Accessors(chain = true)
public class OptionGeneralModifyDto implements Serializable {


    private Integer id;
    /**
     * 网站标题
     */
    @ApiModelProperty(value = "网站标题")
    private String siteTitle;
    /**
     * 网站副标题
     */
    @ApiModelProperty(value = "网站副标题")
    private String siteSecondTitle;
    /**
     * 站点地址
     */
    @ApiModelProperty(value = "站点地址")
    private String siteAddress;

}

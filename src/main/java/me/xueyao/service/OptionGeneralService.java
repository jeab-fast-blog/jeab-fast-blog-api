package me.xueyao.service;

import me.xueyao.base.R;
import me.xueyao.entity.dto.OptionGeneralAddDto;
import me.xueyao.entity.dto.OptionGeneralModifyDto;

/**
 * @author Simon.Xue
 * @date 2019-12-01 00:37
 **/
public interface OptionGeneralService {
    /**
     * 添加常规选项
     * @param optionGeneralAddDto
     * @return
     */
    R add(OptionGeneralAddDto optionGeneralAddDto);

    /**
     * 修改常规选项
     * @param optionGeneralModifyDto
     * @return
     */
    R modify(OptionGeneralModifyDto optionGeneralModifyDto);

    /**
     * 删除常规选项
     * @param optionGeneralId
     * @return
     */
    R delete(Integer optionGeneralId);

    /**
     * 查询常规选项详情
     * @param optionGeneralId
     * @return
     */
    R getDetail(Integer optionGeneralId);
}

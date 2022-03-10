package me.xueyao.service;

import me.xueyao.base.R;
import me.xueyao.domain.dto.AttachmentAddDto;
import me.xueyao.domain.dto.AttachmentModifyDto;

/**
 * @author Simon.Xue
 * @date 2022/3/10 2:29 PM
 **/
public interface AttachmentService {

    /**
     * 添加页面
     * @param attachmentAddDto
     * @return
     */
    R add(AttachmentAddDto attachmentAddDto);

    /**
     * 修改页面
     * @param attachmentModifyDto
     * @return
     */
    R modify(AttachmentModifyDto attachmentModifyDto);

    /**
     * 删除页面
     * @param pageId
     * @return
     */
    R delete(Integer pageId);

    /**
     * 查询页面信息
     * @param pageId
     * @return
     */
    R getDetail(Integer pageId);
    /**
     * 页面列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    R list(Integer pageNum, Integer pageSize);
}

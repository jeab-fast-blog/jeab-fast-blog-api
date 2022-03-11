package me.xueyao.service;

import me.xueyao.base.R;
import me.xueyao.domain.dto.AttachmentAddDto;
import me.xueyao.domain.dto.AttachmentModifyDto;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Simon.Xue
 * @date 2022/3/10 2:29 PM
 **/
public interface AttachmentService {

    /**
     * 添加附件
     * @param attachmentAddDto
     * @return
     */
    R add(AttachmentAddDto attachmentAddDto);

    /**
     * 修改附件
     * @param attachmentModifyDto
     * @return
     */
    R modify(AttachmentModifyDto attachmentModifyDto);

    /**
     * 删除附件
     * @param pageId
     * @return
     */
    R delete(Integer pageId);

    /**
     * 查询附件信息
     * @param pageId
     * @return
     */
    R getDetail(Integer pageId);
    /**
     * 附件列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    R list(Integer pageNum, Integer pageSize);

    /**
     * 上传附件
     * @param file
     * @return
     */
    R upload(MultipartFile file);
}

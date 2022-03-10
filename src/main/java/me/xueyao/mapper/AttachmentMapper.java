package me.xueyao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import me.xueyao.domain.entity.Attachment;
import me.xueyao.domain.vo.AttachmentPageVo;
import org.springframework.stereotype.Repository;

/**
 * @author Simon.Xue
 * @date 2022/3/10 2:42 PM
 **/
@Repository
public interface AttachmentMapper extends BaseMapper<Attachment> {
    /**
     * 查询附件列表
     * @param page
     * @return
     */
    IPage<AttachmentPageVo> findAll(Page<AttachmentPageVo> page);
}

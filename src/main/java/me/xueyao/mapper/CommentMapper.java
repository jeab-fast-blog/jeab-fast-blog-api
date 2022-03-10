package me.xueyao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import me.xueyao.domain.entity.Comment;
import me.xueyao.domain.vo.CommentPageVo;
import org.springframework.stereotype.Repository;

/**
 * @author Simon.Xue
 * @date 2022/3/10 2:42 PM
 **/
@Repository
public interface CommentMapper extends BaseMapper<Comment> {
    /**
     * 查询页面列表
     * @param page
     * @return
     */
    IPage<CommentPageVo> findAll(Page<CommentPageVo> page);
}

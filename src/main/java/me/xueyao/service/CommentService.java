package me.xueyao.service;

import me.xueyao.base.R;
import me.xueyao.domain.dto.CommentAddDto;
import me.xueyao.domain.dto.CommentModifyDto;

/**
 * @author Simon.Xue
 * @date 2022/3/10 2:29 PM
 **/
public interface CommentService {

    /**
     * 添加评论
     * @param commentAddDto
     * @return
     */
    R add(CommentAddDto commentAddDto);

    /**
     * 修改评论
     * @param commentModifyDto
     * @return
     */
    R modify(CommentModifyDto commentModifyDto);

    /**
     * 删除评论
     * @param commentId
     * @return
     */
    R delete(Integer commentId);

    /**
     * 查询评论信息
     * @param commentId
     * @return
     */
    R getDetail(Integer commentId);
    /**
     * 评论列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    R list(Integer pageNum, Integer pageSize);
}

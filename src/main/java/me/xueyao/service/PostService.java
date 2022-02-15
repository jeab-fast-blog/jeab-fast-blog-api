package me.xueyao.service;

import me.xueyao.base.R;
import me.xueyao.entity.dto.PostAddDto;
import me.xueyao.entity.dto.PostModifyDto;
import org.springframework.data.domain.Pageable;

/**
 * @author Simon.Xue
 * @date 2019-12-01 00:38
 **/
public interface PostService {
    /**
     * 添加文章
     * @param postAddDto
     * @return
     */
    R add(PostAddDto postAddDto);

    /**
     * 修改文章
     * @param postModifyDto
     * @return
     */
    R modify(PostModifyDto postModifyDto);

    /**
     * 删除文章
     * @param postId
     * @return
     */
    R delete(Integer postId);

    /**
     * 查询文章详情
     * @param postId
     * @return
     */
    R getDetail(Integer postId);

    /**
     * 文章列表
     * @param pageable
     * @return
     */
    R list(Pageable pageable);
}

package me.xueyao.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import me.xueyao.base.R;
import me.xueyao.domain.dto.CommentAddDto;
import me.xueyao.domain.dto.CommentModifyDto;
import me.xueyao.domain.entity.Comment;
import me.xueyao.domain.vo.CommentPageVo;
import me.xueyao.mapper.CommentMapper;
import me.xueyao.repository.CommentRepository;
import me.xueyao.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author Simon.Xue
 * @date 2022/3/10 2:30 PM
 **/
@Slf4j
@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentRepository commentRepository;
    @Resource
    private CommentMapper commentMapper;

    @Override
    public R add(CommentAddDto commentAddDto) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentAddDto, comment);
        commentRepository.save(comment);
        log.info("添加成功");
        return R.ofSuccess("添加成功");
    }

    @Override
    public R modify(CommentModifyDto commentModifyDto) {
        Integer commentId = commentModifyDto.getId();
        Optional<Comment> commentOptional = commentRepository.findById(commentId);
        Comment comment = commentOptional.get();
        BeanUtil.copyProperties(commentModifyDto, comment);
        commentRepository.save(comment);
        log.info("更新评论成功");
        return R.ofSuccess("更新评论成功");
    }

    @Override
    public R delete(Integer commentId) {
        Optional<Comment> commentOptional = commentRepository.findById(commentId);
        if (commentOptional.isPresent()) {
            return R.ofParamError("评论不存在");
        }
        commentRepository.deleteById(commentId);
        return R.ofSuccess("评论删除成功");
    }

    @Override
    public R getDetail(Integer commentId) {
        Optional<Comment> commentOptional = commentRepository.findById(commentId);
        if (!commentOptional.isPresent()) {
            log.warn("id = {},该评论不存在", commentId);
            return R.ofParamError("该评论不存在");
        }
        return R.ofSuccess("查询评论成功", commentOptional.get());
    }

    @Override
    public R list(Integer commentNum, Integer commentSize) {
        Page<CommentPageVo> comment = new Page<>(commentNum, commentSize);
        IPage<CommentPageVo> iPage = commentMapper.findAll(comment);
        return R.ofSuccess("查询成功", iPage);
    }
}

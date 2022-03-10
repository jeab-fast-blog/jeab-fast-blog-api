package me.xueyao.controller;

import io.swagger.annotations.ApiOperation;
import me.xueyao.base.R;
import me.xueyao.domain.dto.CommentAddDto;
import me.xueyao.domain.dto.CommentModifyDto;
import me.xueyao.service.CommentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Simon.Xue
 * @date 2022/3/10 4:41 PM
 **/
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @ApiOperation(value = "创建评论")
    @PostMapping("/add")
    public R add(@Validated @RequestBody CommentAddDto commentAddDto) {
        return commentService.add(commentAddDto);
    }


    @ApiOperation(value = "修改评论")
    @PutMapping("/modify")
    public R modify(@Validated @RequestBody CommentModifyDto commentModifyDto) {
        return commentService.modify(commentModifyDto);
    }

    @ApiOperation(value = "删除评论")
    @DeleteMapping("/delete/{commentId}")
    public R delete(@PathVariable("commentId") Integer commentId) {
        return commentService.delete(commentId);
    }

    @ApiOperation(value = "获得评论详情")
    @GetMapping("/getDetail/{commentId}")
    public R getDetail(@PathVariable("commentId") Integer commentId) {
        return commentService.getDetail(commentId);
    }

    @ApiOperation(value = "评论列表")
    @GetMapping("/list")
    public R list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return commentService.list(pageNum, pageSize);
    }
}

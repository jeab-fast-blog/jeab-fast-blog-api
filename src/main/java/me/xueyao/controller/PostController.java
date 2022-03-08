package me.xueyao.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.xueyao.base.R;
import me.xueyao.entity.dto.PostAddDto;
import me.xueyao.entity.dto.PostModifyDto;
import me.xueyao.service.PostService;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Simon.Xue
 * @date 2019-12-11 13:44
 **/
@Api(tags = "文章管理")
@RestController
@RequestMapping("/post")
public class PostController {
    @Resource
    private PostService postService;

    @ApiOperation(value = "新建文章")
    @PostMapping("/add")
    public R add(@Validated @RequestBody PostAddDto postAddDto) {
        return postService.add(postAddDto);
    }

    @ApiOperation(value = "修改文章")
    @PutMapping("/modify")
    public R modify(@Validated @RequestBody PostModifyDto postModifyDto) {
        return postService.modify(postModifyDto);
    }

    @ApiOperation(value = "删除文章")
    @DeleteMapping("/delete/{postId}")
    public R delete(@PathVariable("postId") Integer postId) {
        return postService.delete(postId);
    }

    @ApiOperation(value = "获得文章详情")
    @GetMapping("/getDetail/{postId}")
    public R getDetail(@PathVariable("postId") Integer postId) {
        return postService.getDetail(postId);
    }

    @ApiOperation(value = "获得文章列表")
    @GetMapping("/list")
    public R list(Pageable pageable) {
        return postService.list(pageable);
    }
}


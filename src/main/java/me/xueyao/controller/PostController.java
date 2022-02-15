package me.xueyao.controller;

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
@RestController
@RequestMapping("/post")
public class PostController {
    @Resource
    private PostService postService;

    @PostMapping("/add")
    public R add(@Validated @RequestBody PostAddDto postAddDto) {
        return postService.add(postAddDto);
    }

    @PutMapping("/modify")
    public R modify(@Validated @RequestBody PostModifyDto postModifyDto) {
        return postService.modify(postModifyDto);
    }

    @DeleteMapping("/delete/{postId}")
    public R delete(@PathVariable("postId") Integer postId) {
        return postService.delete(postId);
    }

    @GetMapping("/getDetail/{postId}")
    public R getDetail(@PathVariable("postId") Integer postId) {
        return postService.getDetail(postId);
    }

    @GetMapping("/list")
    public R list(Pageable pageable) {
        return postService.list(pageable);
    }
}


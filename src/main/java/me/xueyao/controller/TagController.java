package me.xueyao.controller;

import me.xueyao.base.R;
import me.xueyao.entity.dto.TagAddDto;
import me.xueyao.entity.dto.TagModifyDto;
import me.xueyao.service.TagService;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Simon.Xue
 * @date 2019-12-11 13:46
 **/
@RestController
@RequestMapping("/tag")
public class TagController {

    @Resource
    private TagService tagService;

    @PostMapping("/add")
    public R add(@Validated @RequestBody TagAddDto tagAddDto) {
        return tagService.add(tagAddDto);
    }


    @PutMapping("/modify")
    public R modify(@Validated @RequestBody TagModifyDto tagModifyDto) {
        return tagService.modify(tagModifyDto);
    }


    @DeleteMapping("/delete/{tagId}")
    public R delete(@PathVariable("tagId") Integer tagId) {
        return tagService.delete(tagId);
    }


    @GetMapping("/getDetail/{tagId}")
    public R getDetail(@PathVariable("tagId") Integer tagId) {
        return tagService.getDetail(tagId);
    }

    @GetMapping("/list")
    public R list(Pageable pageable) {
        return tagService.list(pageable);
    }
}

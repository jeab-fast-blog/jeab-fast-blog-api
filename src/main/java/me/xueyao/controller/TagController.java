package me.xueyao.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "标签管理")
@RestController
@RequestMapping("/tag")
public class TagController {

    @Resource
    private TagService tagService;

    @ApiOperation(value = "添加标签")
    @PostMapping("/add")
    public R add(@Validated @RequestBody TagAddDto tagAddDto) {
        return tagService.add(tagAddDto);
    }


    @ApiOperation(value = "更新标签")
    @PutMapping("/modify")
    public R modify(@Validated @RequestBody TagModifyDto tagModifyDto) {
        return tagService.modify(tagModifyDto);
    }


    @ApiOperation(value = "删除标签")
    @DeleteMapping("/delete/{tagId}")
    public R delete(@PathVariable("tagId") Integer tagId) {
        return tagService.delete(tagId);
    }


    @ApiOperation(value = "查看标签详情")
    @GetMapping("/getDetail/{tagId}")
    public R getDetail(@PathVariable("tagId") Integer tagId) {
        return tagService.getDetail(tagId);
    }

    @ApiOperation(value = "查看标签列表")
    @GetMapping("/list")
    public R list(Pageable pageable) {
        return tagService.list(pageable);
    }
}

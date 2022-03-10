package me.xueyao.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.xueyao.base.R;
import me.xueyao.domain.dto.CustomPageAddDto;
import me.xueyao.domain.dto.CustomPageModifyDto;
import me.xueyao.service.PageService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Simon.Xue
 * @date 2022/3/10 2:28 PM
 **/
@Api(tags = "页面管理")
@RestController
@RequestMapping("/page")
public class CustomPageController {

    @Resource
    private PageService pageService;

    @ApiOperation(value = "创建页面")
    @PostMapping("/add")
    public R add(@Validated @RequestBody CustomPageAddDto customPageAddDto) {
        return pageService.add(customPageAddDto);
    }


    @ApiOperation(value = "修改页面")
    @PostMapping("/modify")
    public R modify(@Validated @RequestBody CustomPageModifyDto customPageModifyDto) {
        return pageService.modify(customPageModifyDto);
    }

    @ApiOperation(value = "删除页面")
    @GetMapping("/delete")
    public R delete(@RequestParam("pageId") Integer pageId) {
        return pageService.delete(pageId);
    }

    @ApiOperation(value = "获得页面详情")
    @GetMapping("/getDetail/{pageId}")
    public R getDetail(@PathVariable("pageId") Integer pageId) {
        return pageService.getDetail(pageId);
    }

    @ApiOperation(value = "页面列表")
    @GetMapping("/list")
    public R list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return pageService.list(pageNum, pageSize);
    }
}

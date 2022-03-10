package me.xueyao.controller;

import io.swagger.annotations.ApiOperation;
import me.xueyao.base.R;
import me.xueyao.domain.dto.AttachmentAddDto;
import me.xueyao.domain.dto.AttachmentModifyDto;
import me.xueyao.service.AttachmentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Simon.Xue
 * @date 2022/3/10 4:41 PM
 **/
@RestController
@RequestMapping("/attach")
public class AttachmentController {

    @Resource
    private AttachmentService attachmentService;

    @ApiOperation(value = "创建附件")
    @PostMapping("/add")
    public R add(@Validated @RequestBody AttachmentAddDto attachmentAddDto) {
        return attachmentService.add(attachmentAddDto);
    }


    @ApiOperation(value = "修改附件")
    @PutMapping("/modify")
    public R modify(@Validated @RequestBody AttachmentModifyDto attachmentModifyDto) {
        return attachmentService.modify(attachmentModifyDto);
    }

    @ApiOperation(value = "删除附件")
    @DeleteMapping("/delete/{pageId}")
    public R delete(@PathVariable("pageId") Integer pageId) {
        return attachmentService.delete(pageId);
    }

    @ApiOperation(value = "获得附件详情")
    @GetMapping("/getDetail/{pageId}")
    public R getDetail(@PathVariable("pageId") Integer pageId) {
        return attachmentService.getDetail(pageId);
    }

    @ApiOperation(value = "附件列表")
    @GetMapping("/list")
    public R list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return attachmentService.list(pageNum, pageSize);
    }
}

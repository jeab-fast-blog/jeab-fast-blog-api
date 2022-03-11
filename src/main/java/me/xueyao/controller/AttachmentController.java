package me.xueyao.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.xueyao.base.R;
import me.xueyao.domain.dto.AttachmentAddDto;
import me.xueyao.domain.dto.AttachmentModifyDto;
import me.xueyao.service.AttachmentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author Simon.Xue
 * @date 2022/3/10 4:41 PM
 **/
@Api(tags = "附件管理")
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


    @ApiOperation(value = "上传附件")
    @PostMapping("/upload")
    public R upload(@RequestParam MultipartFile file) {
        return attachmentService.upload(file);
    }


    @ApiOperation(value = "修改附件")
    @PostMapping("/modify")
    public R modify(@Validated @RequestBody AttachmentModifyDto attachmentModifyDto) {
        return attachmentService.modify(attachmentModifyDto);
    }

    @ApiOperation(value = "删除附件")
    @GetMapping("/delete")
    public R delete(@RequestParam("pageId") Integer pageId) {
        return attachmentService.delete(pageId);
    }

    @ApiOperation(value = "获得附件详情")
    @GetMapping("/getDetail")
    public R getDetail(@RequestParam("pageId") Integer pageId) {
        return attachmentService.getDetail(pageId);
    }

    @ApiOperation(value = "附件列表")
    @GetMapping("/list")
    public R list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return attachmentService.list(pageNum, pageSize);
    }
}

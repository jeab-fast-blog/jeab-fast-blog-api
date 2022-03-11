package me.xueyao.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import me.xueyao.base.R;
import me.xueyao.domain.dto.AttachmentAddDto;
import me.xueyao.domain.dto.AttachmentModifyDto;
import me.xueyao.domain.entity.Attachment;
import me.xueyao.domain.vo.AttachmentPageVo;
import me.xueyao.mapper.AttachmentMapper;
import me.xueyao.repository.AttachmentRepository;
import me.xueyao.service.AttachmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

/**
 * @author Simon.Xue
 * @date 2022/3/10 2:30 PM
 **/
@Slf4j
@Service
public class AttachmentServiceImpl implements AttachmentService {
    @Value("${attach.path}")
    private String path;
    @Resource
    private AttachmentRepository attachmentRepository;
    @Resource
    private AttachmentMapper attachmentMapper;

    @Override
    public R add(AttachmentAddDto attachmentAddDto) {
        Attachment attach = new Attachment();
        BeanUtils.copyProperties(attachmentAddDto, attach);
        attachmentRepository.save(attach);
        log.info("添加成功");
        return R.ofSuccess("添加成功");
    }

    @Override
    public R modify(AttachmentModifyDto attachmentModifyDto) {
        Integer attachId = attachmentModifyDto.getId();
        Optional<Attachment> attachOptional = attachmentRepository.findById(attachId);
        Attachment attach = attachOptional.get();
        BeanUtil.copyProperties(attachmentModifyDto, attach);
        attachmentRepository.save(attach);
        log.info("更新附件成功");
        return R.ofSuccess("更新附件成功");
    }

    @Override
    public R delete(Integer attachId) {
        Optional<Attachment> attachOptional = attachmentRepository.findById(attachId);
        if (attachOptional.isPresent()) {
            return R.ofParamError("附件不存在");
        }
        attachmentRepository.deleteById(attachId);
        return R.ofSuccess("附件删除成功");
    }

    @Override
    public R getDetail(Integer attachId) {
        Optional<Attachment> attachOptional = attachmentRepository.findById(attachId);
        if (!attachOptional.isPresent()) {
            log.warn("id = {},该附件不存在", attachId);
            return R.ofParamError("该附件不存在");
        }
        return R.ofSuccess("查询附件成功", attachOptional.get());
    }

    @Override
    public R list(Integer attachNum, Integer attachSize) {
        Page<AttachmentPageVo> attach = new Page<>(attachNum, attachSize);
        IPage<AttachmentPageVo> iPage = attachmentMapper.findAll(attach);
        return R.ofSuccess("查询成功", iPage);
    }

    @Override
    public R upload(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")-1);
        String filename = UUID.fastUUID() + suffix;
        String filePath = path + filename;
        long size = file.getSize();
        File uploadFile = new File(filePath);

        log.info("上传文件全路径为，{}", filePath);
        try {
            file.transferTo(uploadFile);
        } catch (IOException e) {
            e.printStackTrace();
            log.warn("上传失败，message = {}", e.getMessage());
        }

        // 保存到表中
        Attachment attachment = new Attachment()
                .setFilename(filename)
                .setSuffix(suffix)
                .setOriginalFilename(originalFilename)
                .setFilePath(filePath)
                .setSize(size);
        attachmentRepository.save(attachment);
        return R.ofSuccess("上传文件成功");
    }
}

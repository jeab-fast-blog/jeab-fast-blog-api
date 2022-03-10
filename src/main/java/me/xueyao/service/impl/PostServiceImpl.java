package me.xueyao.service.impl;

import me.xueyao.base.R;
import me.xueyao.domain.entity.Post;
import me.xueyao.domain.dto.PostAddDto;
import me.xueyao.domain.dto.PostModifyDto;
import me.xueyao.repository.PostRepository;
import me.xueyao.service.PostService;
import me.xueyao.util.BeanCompareUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author Simon.Xue
 * @date 2019-12-01 00:44
 **/
@Service("postService")
public class PostServiceImpl implements PostService {
    @Resource
    private PostRepository postRepository;

    @Override
    public R add(PostAddDto postAddDto) {
        Post post = new Post().setPostTitle(postAddDto.getPostTitle());
        Example<Post> postExample = Example.of(post);
        Optional<Post> postOptional = postRepository.findOne(postExample);
        if (postOptional.isPresent()) {
            return R.ofParamError("该文章标题已存在");
        }

        BeanUtils.copyProperties(postAddDto, post);
        postRepository.save(post);
        return R.ofSuccess("添加文章成功");
    }

    @Override
    public R modify(PostModifyDto postModifyDto) {
        Example<Post> postExample = Example.of(new Post().setId(postModifyDto.getId()));
        Optional<Post> postOptional = postRepository.findOne(postExample);
        if (!postOptional.isPresent()) {
            return R.ofParamError("该文章不存在");
        }

        Post post = postOptional.get();
        BeanUtils.copyProperties(postModifyDto, post, BeanCompareUtils.getEmptyPropertyNames(postModifyDto));
        postRepository.save(post);
        return R.ofSuccess("更新文章成功");
    }

    @Override
    public R delete(Integer postId) {
        Optional<Post> postOptional = postRepository.findById(postId);
        if (!postOptional.isPresent()) {
            return R.ofParamError("该文章不存在");
        }

        postRepository.deleteById(postId);
        return R.ofSuccess("删除文章成功");
    }

    @Override
    public R getDetail(Integer postId) {
        Optional<Post> postOptional = postRepository.findById(postId);
        if (!postOptional.isPresent()) {
            return R.ofParamError("该文章不存在");
        }
        return R.ofSuccess("查询文章详情成功", postOptional.get());
    }

    @Override
    public R list(Pageable pageable) {
        Page<Post> postPage = postRepository.findAll(pageable);
        return R.ofSuccess("查询成功", postPage);
    }
}

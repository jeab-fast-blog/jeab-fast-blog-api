package me.xueyao.service.impl;

import me.xueyao.base.R;
import me.xueyao.entity.User;
import me.xueyao.entity.dto.LoginDto;
import me.xueyao.repository.UserRepository;
import me.xueyao.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author Simon.Xue
 * @date 1/28/21 2:50 PM
 **/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;

    @Override
    public R login(LoginDto loginDto) {
        User user = userRepository.findByUsername(loginDto.getUsername());
        if (null == user) {
            return R.ofParam("用户名不存在");
        }
        if (user.getPassword().equals(loginDto.getPassword())) {
            return R.ofSuccess("登录成功", user.getId());
        }
        return R.ofParam("用户名或密码不正确");
    }

    @Override
    public R currentUser(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return R.ofSuccess("查询当前用户信息成功", userOptional.get());
        }

        return R.ofParam("查询当前用户信息失败");
    }
}

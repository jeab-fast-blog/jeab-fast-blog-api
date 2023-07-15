package me.xueyao.repository;

import me.xueyao.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Simon.Xue
 * @date 2019-12-01 00:23
 **/
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    /**
     * 查询用户信息
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 根据手机号查询用户
     * @param phone
     * @return
     */
    User findByMobile(String phone);

    /**
     * 根据邮箱查询用户
     * @param email
     * @return
     */
    User findByEmail(String email);
}

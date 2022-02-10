package me.xueyao.repository;

import me.xueyao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Simon.Xue
 * @date 1/28/21 2:53 PM
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * 查询用户信息
     *
     * @param username 用户名
     * @return
     */
    User findByUsername(String username);
}

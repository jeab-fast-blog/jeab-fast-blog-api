package me.xueyao.repository;

import me.xueyao.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Simon.Xue
 * @date 2019-12-01 00:29
 **/
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}

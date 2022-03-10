package me.xueyao.repository;

import me.xueyao.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Simon.Xue
 * @date 2022/3/10 2:28 PM
 **/
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}

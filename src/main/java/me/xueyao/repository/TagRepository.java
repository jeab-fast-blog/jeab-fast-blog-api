package me.xueyao.repository;

import me.xueyao.domain.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Simon.Xue
 * @date 2019-12-01 00:25
 **/
@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
}

package me.xueyao.repository;

import me.xueyao.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Simon.Xue
 * @date 2019-12-01 00:18
 **/
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

package me.xueyao.repository;

import me.xueyao.domain.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Simon.Xue
 * @date 2022/3/10 2:28 PM
 **/
@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
}

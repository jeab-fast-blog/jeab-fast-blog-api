package me.xueyao.repository;

import me.xueyao.entity.OptionGeneral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Simon.Xue
 * @date 2019-12-01 00:33
 **/
@Repository
public interface OptionGeneralRepository extends JpaRepository<OptionGeneral, Integer> {
}

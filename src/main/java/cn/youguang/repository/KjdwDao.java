package cn.youguang.repository;

import cn.youguang.entity.Hd;
import cn.youguang.entity.Kjdw;
import cn.youguang.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface KjdwDao extends JpaRepository<Kjdw, Long> {
	

    List<Kjdw> findByHdAndDz(Hd hd, User dz);


    List<Kjdw> findByHd(Long id);
}

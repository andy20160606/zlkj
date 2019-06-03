package cn.youguang.repository;

import cn.youguang.entity.Hd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface HdDao extends JpaRepository<Hd, Long> {


    List<Hd> findByKhwybs(String khwybs);
}

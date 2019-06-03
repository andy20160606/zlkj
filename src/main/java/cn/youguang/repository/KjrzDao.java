package cn.youguang.repository;

import cn.youguang.entity.Kjdw;
import cn.youguang.entity.Kjrz;
import cn.youguang.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface KjrzDao extends JpaRepository<Kjrz, Long> {


    Kjrz findByKjrAndKjdw(User kjr, Kjdw kjdw);

    List<Kjrz> findByKjdw(Kjdw kjdw);
}

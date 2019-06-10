package cn.youguang.repository;

import cn.youguang.entity.Hd;
import cn.youguang.entity.User;
import cn.youguang.entity.Yhq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface YhqDao extends JpaRepository<Yhq, Long> {


    Page<Yhq> findByUser(User user, Pageable pagerequest);

    List<Yhq> findByUser(User user);

    List<Yhq> findByHd(Hd hd);

    List<Yhq> findByHdIn(List<Hd> hds);

    Page<Yhq> findByHdIn(List<Hd> hds, Pageable pagerequest);
}

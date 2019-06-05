package cn.youguang.repository;

import cn.youguang.entity.Hd;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;


public interface HdDao extends JpaRepository<Hd, Long> {


    List<Hd> findByKhwybs(String khwybs);

    Page<Hd> findByKhwybsAndStoptimeAfter(String khwybs, Date stoptime, Pageable pageable);

    Page<Hd> findByKhwybs(String khwybs, Pageable pagerequest);

    Page<Hd> findByStoptimeAfter(Date stoptime, Pageable pagerequest);
}

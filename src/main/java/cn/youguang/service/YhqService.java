
package cn.youguang.service;

import cn.youguang.entity.Hd;
import cn.youguang.entity.User;
import cn.youguang.entity.Yhq;
import cn.youguang.repository.HdDao;
import cn.youguang.repository.UserDao;
import cn.youguang.repository.YhqDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Spring Bean的标识.
@Service
@Transactional
public class YhqService {


    @Autowired
    private YhqDao yhqDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private HdDao hdDao;


    public void save(Yhq yhq) {
        yhqDao.save(yhq);
    }


    public Yhq findById(Long id) {
        return yhqDao.findOne(id);
    }





    public List<Yhq> findByHdId(Long hdId) {
        Hd hd = hdDao.findOne(hdId);
        List<Yhq> yhqs = yhqDao.findByHd(hd);
        return yhqs;

    }

    public List<Yhq> findByUserId(Long userId) {
        User user = userDao.findOne(userId);
        List<Yhq> yhqs = yhqDao.findByUser(user);
        return yhqs;
    }
}

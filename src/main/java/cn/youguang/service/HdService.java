
package cn.youguang.service;

import cn.youguang.entity.Hd;
import cn.youguang.entity.User;
import cn.youguang.entity.Yhq;
import cn.youguang.repository.HdDao;
import cn.youguang.repository.UserDao;
import cn.youguang.repository.YhqDao;
import cn.youguang.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

//Spring Bean的标识.
@Service
@Transactional
public class HdService {


    @Autowired
    private YhqDao yhqDao;

    @Autowired
    private UserDao userDao;


    @Autowired
    private HdDao hdDao;


    public void save(Hd hd) {
        hdDao.save(hd);
    }


    public Hd findById(Long id) {


        return hdDao.findOne(id);
    }


    public void findDataTables(PageInfo pageInfo) {

        Page<Yhq> yhqs;
        Long userId = (Long) pageInfo.getCondition().get("userId");


        if (userId != null) {
            User user = userDao.findById(userId);
            yhqs = yhqDao.findByUser(user, pageInfo.getPagerequest());
        } else {
            yhqs = yhqDao.findAll(pageInfo.getPagerequest());
        }


        pageInfo.setRows(yhqs.getContent());
        pageInfo.setTotal(yhqs.getTotalElements());


    }

    public List<Yhq> findList(Map<String, Object> condition) {

        Long userId = (Long) condition.get("userId");
        List<Yhq> yhqs;
        if (userId != null) {
            User user = userDao.findById(userId);
            yhqs = yhqDao.findByUser(user);
        } else {
            yhqs = yhqDao.findAll();
        }

        return yhqs;

    }


    public List<Hd> findByKhwybs(String khwybs) {
        return hdDao.findByKhwybs(khwybs);
    }
}

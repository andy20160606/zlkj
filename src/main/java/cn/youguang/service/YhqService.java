
package cn.youguang.service;

import cn.youguang.entity.Hd;
import cn.youguang.entity.User;
import cn.youguang.entity.Yhq;
import cn.youguang.repository.HdDao;
import cn.youguang.repository.UserDao;
import cn.youguang.repository.YhqDao;
import cn.youguang.util.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    public List<Yhq> findByHds(List<Hd> hds) {
        return yhqDao.findByHdIn(hds);
    }

    public void findDataTables(PageInfo pageInfo) {

        String khwybs = (String) pageInfo.getCondition().get("khwybs");


        Page<Yhq> yhqs;


        if (StringUtils.isNotEmpty(khwybs)) {
            List<Hd> hds = hdDao.findByKhwybs(khwybs);

            yhqs = yhqDao.findByHdIn(hds,pageInfo.getPagerequest());

        }else {
            yhqs = yhqDao.findAll(pageInfo.getPagerequest());
        }


       pageInfo.finishFromJpaPages(yhqs);


    }
}

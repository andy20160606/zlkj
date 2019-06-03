
package cn.youguang.service;

import cn.youguang.entity.Kjdw;
import cn.youguang.entity.Kjrz;
import cn.youguang.entity.User;
import cn.youguang.entity.Yhq;
import cn.youguang.repository.KjdwDao;
import cn.youguang.repository.KjrzDao;
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
public class KjrzService {


    @Autowired
    private YhqDao yhqDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private KjdwDao kjdwDao;


    @Autowired
    private KjrzDao kjrzDao;





    public List<Kjrz> findByKjdwId(Long kjdwId) {
        Kjdw kjdw = kjdwDao.findOne(kjdwId);

        List<Kjrz> kjrzs = kjrzDao.findByKjdw(kjdw);



        return kjrzs;
    }
}

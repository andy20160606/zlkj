
package cn.youguang.service;

import cn.youguang.entity.*;
import cn.youguang.repository.*;
import cn.youguang.util.PageInfo;
import cn.youguang.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

//Spring Bean的标识.
@Service
@Transactional
public class KjdwService {


    @Autowired
    private YhqDao yhqDao;


    @Autowired
    private KjdwDao kjdwDao;

    @Autowired
    private HdDao hdDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private KjrzDao kjrzDao;


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


    public List<Kjdw> findByHdIdAndDzId(Long hdId, Long dzId) {
        if (hdId == null || dzId == null) {
            return null;
        }

        Hd hd = hdDao.findOne(hdId);
        User dz = userDao.findById(dzId);
        return kjdwDao.findByHdAndDz(hd, dz);
    }

    public void save(Kjdw kjdw) {
        kjdwDao.save(kjdw);
    }

    public Kjdw findById(Long kjdwId) {


        return kjdwDao.findOne(kjdwId);
    }


    /**
     * 首先判定该队伍是否已经成功砍价了
     * 判定该用户是否还可以给该队伍进行砍价
     *
     * @param userId
     * @param kjdwId
     */
    public Result kj(@NotNull Long userId, @NotNull Long kjdwId) {


        Result result = new Result();

        Kjdw kjdw = kjdwDao.findOne(kjdwId);
        Hd hd = kjdw.getHd();


        // 若活动过期则无法参与砍价
        if (hd.getStoptime().before(new Date())) {
            result.setMsg("活动时间已过期，无法帮助队长砍价了");
            return result;
        }


        if (kjdw.getSykjje() <= 0) {
            result.setMsg("队长已经获取奖励了，不用继续砍价了");
            return result;
        }

        User kjr = userDao.findById(userId);
        Kjrz kjrzDb = kjrzDao.findByKjrAndKjdw(kjr, kjdw);
        if (kjrzDb != null) {
            result.setMsg("已经为队长砍过价，请不要重复砍价");
            return result;
        }


        Kjrz kjrz = new Kjrz();

        kjrz.setHd(kjdw.getHd());
        kjrz.setKjdw(kjdw);
        kjrz.setKjje(kjdw.getHd().getDykjje());
        kjrz.setKjr(kjr);
        kjrz.setKjqj(kjdw.getDqkjdj());
        kjrz.setKjhj(kjdw.getDqkjdj() - kjrz.getKjje());
        kjrz.setKjsj(new Date());
        kjrzDao.save(kjrz);
        kjdw.setDqkjdj(kjdw.getDqkjdj() - kjrz.getKjje());
        kjdw.setYkjje(kjdw.getYkjje() + kjrz.getKjje());
        kjdw.setSykjje(kjdw.getSykjje() - kjrz.getKjje());
        kjdwDao.save(kjdw);
        result.setMsg("砍价成功");


        hd.setCykjrs(hd.getCykjrs() + 1);

        //发放优惠券给队长
        if (kjdw.getDqkjdj() <= kjdw.getHd().getDj()) {
            hd.setHjrs(hd.getHjrs() + 1);
            result.setMsg("砍价成功，并且队长已经获取奖励了，赶快通知队长吧");
            Yhq yhq = new Yhq();
            yhq.setHd(kjdw.getHd());
            yhq.setJe(kjdw.getHd().getYj() - kjdw.getHd().getDj());
            yhq.setUser(kjdw.getDz());
            yhq.setYhm(System.currentTimeMillis() + "");
            yhq.setHqsj(new Date());
            yhqDao.save(yhq);
        }

        //更新hd信息
        hdDao.save(hd);


        return result;
    }

    public List<Kjdw> findByHdId(Long id) {
        return kjdwDao.findByHd(id);
    }

    public Result checkCanJoinHdByDzIdAndHdId(Long dzId, Long hdId) {

        Result result = new Result();
        Hd hd = hdDao.findOne(hdId);

        if (hd.getHjrs() >= hd.getHjcs()) {
            result.setMsg("获奖人数已达到上线不能继续参与了");
            result.setSuccess(false);
            return result;
        }


        List<Kjdw> kjdws = findByHdIdAndDzId(hdId, dzId);


        if (kjdws.size() < hd.getHjcs()) {
            result.setSuccess(true);
        } else {
            result.setSuccess(false);
            result.setMsg("队伍最多参与次数已达到限制，不可继续参与了");
        }
        return result;

    }
}

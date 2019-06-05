
package cn.youguang.service;

import cn.youguang.entity.Hd;
import cn.youguang.entity.User;
import cn.youguang.entity.Yhq;
import cn.youguang.repository.HdDao;
import cn.youguang.repository.UserDao;
import cn.youguang.repository.YhqDao;
import cn.youguang.util.PageInfo;
import cn.youguang.util.Result;
import cn.youguang.util.StringUtil;
import com.sun.istack.internal.NotNull;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

        Page<Hd> hds;
        String khwybs = (String) pageInfo.getCondition().get("khwybs");
        Date stoptime = (Date) pageInfo.getCondition().get("stoptime");

        if (StringUtils.isNotEmpty(khwybs) && stoptime != null) {

            hds = hdDao.findByKhwybsAndStoptimeAfter(khwybs, stoptime, pageInfo.getPagerequest());

        } else if (StringUtils.isNotEmpty(khwybs)) {
            hds = hdDao.findByKhwybs(khwybs, pageInfo.getPagerequest());
        } else if (stoptime != null) {
            hds = hdDao.findByStoptimeAfter(stoptime, pageInfo.getPagerequest());
        } else {
            hds = hdDao.findAll(pageInfo.getPagerequest());
        }
        pageInfo.setRows(hds.getContent());
        pageInfo.setTotal(hds.getTotalElements());
        pageInfo.setTotalPages(hds.getTotalPages());
    }


    public Result ppllrsByHdId(@NotNull Long hdId) {
        Result result = new Result();

        Hd hd = hdDao.findOne(hdId);
        hd.setLlrs(hd.getLlrs() + 1);
        hdDao.save(hd);
        result.setSuccess(true);
        return result;
    }

    public Result pphjrsByHdId(@NotNull Long hdId) {
        Result result = new Result();

        Hd hd = hdDao.findOne(hdId);
        hd.setHjrs(hd.getHjcs() + 1);
        hdDao.save(hd);
        result.setSuccess(true);
        return result;
    }

    public Result ppcykjrsByHdId(@NotNull Long hdId) {
        Result result = new Result();

        Hd hd = hdDao.findOne(hdId);
        hd.setCykjrs(hd.getCykjrs() + 1);
        hdDao.save(hd);
        result.setSuccess(true);
        return result;
    }


}

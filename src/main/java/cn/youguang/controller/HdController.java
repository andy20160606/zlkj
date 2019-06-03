package cn.youguang.controller;


import cn.youguang.entity.Hd;
import cn.youguang.entity.Info;
import cn.youguang.entity.Kjdw;
import cn.youguang.service.HdService;
import cn.youguang.service.InfoService;
import cn.youguang.service.KjdwService;
import cn.youguang.util.Result;
import cn.youguang.util.StringUtils;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @description：活动管理
 */
@Controller
@RequestMapping("/hd")
@Api(value = "活动Controller", tags = {"活动操作接口"})
public class HdController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); // true:允许输入空值，false:不能为空值
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(HdController.class);


    @Autowired
    private HdService hdService;


    @Autowired
    private KjdwService kjdwService;


    /**
     * 添加活动
     *
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Result add(@RequestBody Hd hd) {

        Result result = new Result();
        try {
            hdService.save(hd);
            result.setMsg("添加活动成功");
            result.setSuccess(true);
        } catch (Exception e) {
            result.setMsg(e.getMessage());

        }

        return result;

    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(@RequestBody Hd hd) {

        Result result = new Result();
        try {
            List<Kjdw> kjdws = kjdwService.findByHdId(hd.getId());
            if (kjdws != null && !kjdws.isEmpty()) {
                result.setMsg("已经有队伍进行砍价活动，无法进行修改");
                return result;
            }
            hdService.save(hd);
            result.setMsg("修改活动成功");
            result.setSuccess(true);
        } catch (Exception e) {
            result.setMsg(e.getMessage());
        }

        return result;

    }


    /**
     * @param
     * @return
     */
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    @ResponseBody
    public Result findById(@RequestParam Long id) {
        Result result = new Result();
        try {

            Hd hd = hdService.findById(id);
            result.setObj(hd);
            result.setSuccess(true);
        } catch (RuntimeException e) {
            result.setMsg(e.getMessage());

        }
        return result;
    }


    /**
     * @param
     * @return
     */
    @RequestMapping(value = "/findByKhwybs", method = RequestMethod.GET)
    @ResponseBody
    public Result findById(@RequestParam String khwybs) {
        Result result = new Result();
        try {

            List<Hd> hds = hdService.findByKhwybs(khwybs);
            result.setObj(hds);
            result.setSuccess(true);
        } catch (RuntimeException e) {
            result.setMsg(e.getMessage());

        }
        return result;
    }


    @RequestMapping(value = "/checkJoinHdByUserId", method = RequestMethod.GET)
    @ResponseBody
    public Result checkJoinHdByUserId(@RequestParam Long dzId, @RequestParam Long hdId) {
        Result result = new Result();
        try {
            List<Kjdw> kjdws = kjdwService.findByHdIdAndDzId(hdId, dzId);
            if (kjdws.size() > 0) {
                result.setObj(true);
            }
            result.setSuccess(true);
        } catch (RuntimeException e) {
            result.setMsg(e.getMessage());

        }
        return result;
    }


}

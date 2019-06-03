package cn.youguang.controller;


import cn.youguang.entity.Hd;
import cn.youguang.entity.Kjdw;
import cn.youguang.entity.User;
import cn.youguang.service.HdService;
import cn.youguang.service.KjdwService;
import cn.youguang.service.UserService;
import cn.youguang.util.Result;
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
@RequestMapping("/kjdw")
@Api(value = "砍价队伍Controller", tags = {"砍价队伍接口"})
public class KjdwController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); // true:允许输入空值，false:不能为空值
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(KjdwController.class);


    @Autowired
    private HdService hdService;


    @Autowired
    private KjdwService kjdwService;

    @Autowired
    private UserService userService;

    /**
     * 添加砍价队伍
     *
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Result add(@RequestParam Long hdId,@RequestParam Long dzId,@RequestBody Kjdw kjdw) {

        Result result = new Result();
        try {
            Hd hd = hdService.findById(hdId);
            User dz = userService.findUserById(dzId);
            kjdw.setDz(dz);
            kjdw.setHd(hd);
            kjdw.setDwcjsj(new Date());
            kjdwService.save(kjdw);
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
            hdService.save(hd);
            result.setMsg("添加活动成功");
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


    @RequestMapping(value = "/checkJoinHdByUserId", method = RequestMethod.GET)
    @ResponseBody
    public Result checkJoinHdByUserId(@RequestParam Long dzId, @RequestParam Long hdId) {
        Result result = new Result();
        try {
            List<Kjdw> kjdws = kjdwService.findByHdIdAndDzId(hdId, dzId);
            if(kjdws.size() > 0){
                result.setObj(true);
            }
            result.setSuccess(true);
        } catch (RuntimeException e) {
            result.setMsg(e.getMessage());

        }
        return result;
    }


}

package cn.youguang.controller;


import cn.youguang.entity.Hd;
import cn.youguang.entity.Kjdw;
import cn.youguang.entity.User;
import cn.youguang.entity.Yhq;
import cn.youguang.service.HdService;
import cn.youguang.service.KjdwService;
import cn.youguang.service.UserService;
import cn.youguang.service.YhqService;
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
@RequestMapping("/yhq")
@Api(value = "优惠券Controller", tags = {"优惠券管理接口"})
public class YhqController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); // true:允许输入空值，false:不能为空值
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(YhqController.class);



    @Autowired
    private YhqService yhqService;

    /**
     * @param
     * @return
     */
    @RequestMapping(value = "/findByHdId", method = RequestMethod.GET)
    @ResponseBody
    public Result findById(@RequestParam Long hdId) {
        Result result = new Result();
        try {

            List<Yhq> yhqs = yhqService.findByHdId(hdId);
            result.setObj(yhqs);
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
    @RequestMapping(value = "/findByUserId", method = RequestMethod.GET)
    @ResponseBody
    public Result findByUserId(@RequestParam Long userId) {
        Result result = new Result();
        try {

            List<Yhq> yhqs = yhqService.findByUserId(userId);
            result.setObj(yhqs);
            result.setSuccess(true);
        } catch (RuntimeException e) {
            result.setMsg(e.getMessage());

        }
        return result;
    }



}

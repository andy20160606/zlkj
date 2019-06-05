package cn.youguang.controller;


import cn.youguang.entity.Kjrz;
import cn.youguang.service.HdService;
import cn.youguang.service.KjdwService;
import cn.youguang.service.KjrzService;
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
@RequestMapping("/kjrz")
@Api(value = "砍价日志Controller", tags = {"砍价日志接口"})
public class KjrzController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); // true:允许输入空值，false:不能为空值
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(KjrzController.class);





    @Autowired
    private KjdwService kjdwService;



    @Autowired
    private KjrzService kjrzService;

    /**
     * 进行砍价
     *
     * @return
     */
    @RequestMapping(value = "/kj", method = RequestMethod.POST)
    @ResponseBody
    public Result kj(@RequestParam Long userId, @RequestParam Long kjdwId) {

        Result result = new Result();
        try {
            result = kjdwService.kj(userId, kjdwId);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setMsg(e.getMessage());

        }
        return result;

    }


    /**
     *
     * 查询砍价队伍下的砍价日志
     * @param
     * @return
     */
    @RequestMapping(value = "/findByKjdwId", method = RequestMethod.GET)
    @ResponseBody
    public Result findByKjdwId(@RequestParam Long kjdwId) {
        Result result = new Result();
        try {
            List<Kjrz> kjrzs = kjrzService.findByKjdwId(kjdwId);
            result.setObj(kjrzs);
            result.setSuccess(true);
        } catch (RuntimeException e) {
            result.setMsg(e.getMessage());

        }
        return result;
    }



}

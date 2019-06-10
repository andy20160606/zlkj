package cn.youguang.controller;


import cn.youguang.entity.Hd;
import cn.youguang.entity.Kjdw;
import cn.youguang.entity.User;
import cn.youguang.service.HdService;
import cn.youguang.service.KjdwService;
import cn.youguang.service.UserService;
import cn.youguang.util.QrCodeCreateUtil;
import cn.youguang.util.Result;
import cn.youguang.util.VerifyCodeUtil;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import weixin.popular.api.QrcodeAPI;
import weixin.popular.api.TokenAPI;
import weixin.popular.bean.qrcode.QrcodeTicket;
import weixin.popular.bean.token.Token;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @description：砍价队伍管理
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
    public Result add(@RequestParam Long hdId, @RequestParam Long dzId, @RequestBody(required = false) Kjdw kjdw) {

        Result result = new Result();
        try {

            result = kjdwService.checkCanJoinHdByDzIdAndHdId(dzId, hdId);
            if (!result.isSuccess()) {
                return result;
            }

            Hd hd = hdService.findById(hdId);
            User dz = userService.findUserById(dzId);
            kjdw.setDz(dz);
            kjdw.setHd(hd);
            kjdw.setDwcjsj(new Date());
            kjdw.setDqkjdj(hd.getYj());
            kjdw.setYkjje(0.0);
            kjdw.setSykjje(hd.getYj() - hd.getDj());
            kjdwService.save(kjdw);
            result.setMsg("创建队伍成功");
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
            Kjdw kjdw = kjdwService.findById(id);
            result.setObj(kjdw);
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
    @RequestMapping(value = "/findListByHdId", method = RequestMethod.GET)
    @ResponseBody
    public Result findListByHdId(@RequestParam Long hdId) {
        Result result = new Result();
        try {

            List<Kjdw> kjdws = kjdwService.findByHdId(hdId);
            result.setObj(kjdws);
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
    @RequestMapping(value = "/findListByHdIdAndDzId", method = RequestMethod.GET)
    @ResponseBody
    public Result findListByHdIdAndDzId(@RequestParam Long hdId,@RequestParam Long dzId) {
        Result result = new Result();
        try {

            List<Kjdw> kjdws = kjdwService.findByHdIdAndDzId(hdId,dzId);
            result.setObj(kjdws);
            result.setSuccess(true);
        } catch (RuntimeException e) {
            result.setMsg(e.getMessage());

        }
        return result;
    }




    @RequestMapping(value = "/checkCanJoinHdByDzIdAndHdId", method = RequestMethod.GET)
    @ResponseBody
    public Result checkJoinHdByDzIdAndHdId(@RequestParam Long dzId, @RequestParam Long hdId) {
        Result result = new Result();
        try {
            result = kjdwService.checkCanJoinHdByDzIdAndHdId(dzId, hdId);
        } catch (RuntimeException e) {
            result.setMsg(e.getMessage());

        }
        return result;
    }


}

package cn.youguang.controller;


import cn.youguang.entity.Hd;
import cn.youguang.entity.Info;
import cn.youguang.entity.Kjdw;
import cn.youguang.entity.Role;
import cn.youguang.service.HdService;
import cn.youguang.service.InfoService;
import cn.youguang.service.KjdwService;
import cn.youguang.util.PageInfo;
import cn.youguang.util.Result;
import cn.youguang.util.StringUtil;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            hd.setLlrs(0); //初始化设置参与人数为0
            hd.setCykjrs(0); //初始化设置参与砍价人数为0
            hd.setHjrs(0); //初始化设置已获奖人数为0
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


    @RequestMapping(value = "/ppllrsByHdId", method = RequestMethod.GET)
    @ResponseBody
    public Result ppllrsByHdId(@RequestParam Long hdId) {

        Result result = new Result();
        try {

            result = hdService.ppllrsByHdId(hdId);

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
     * @return
     */
    @RequestMapping(value = "/dataTables", method = RequestMethod.GET)//, )
    @ResponseBody
    public PageInfo dataTables(@ModelAttribute PageInfo pageInfo, @RequestParam String khwybs, @RequestParam Date stoptime) {
//        PageInfo pageInfo = new PageInfo(page, rows, sort, order);
        Map<String, Object> condition = new HashMap<String, Object>();


        if (StringUtils.isNotEmpty(khwybs)) {
            condition.put("khwybs", khwybs);
        }
        if (StringUtils.isNotBlank(khwybs)) {
            condition.put("stoptime", stoptime);
        }
        pageInfo.setCondition(condition);

        hdService.findDataTables(pageInfo);
        return pageInfo;
    }


}

package cn.youguang.controller;


import cn.youguang.entity.Hd;
import cn.youguang.entity.Yhq;
import cn.youguang.service.HdService;
import cn.youguang.service.YhqService;
import cn.youguang.util.PageInfo;
import cn.youguang.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
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
 * @description：优惠券管理
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
    private HdService hdService;

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
    @RequestMapping(value = "/dataTables", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo dataTables(@RequestParam String khwybs ,@ModelAttribute PageInfo pageInfo ) {

        Map<String, Object> condition = new HashMap<String, Object>();
        try {

            if (StringUtils.isNotEmpty(khwybs)) {
                condition.put("khwybs", khwybs);
            }
            pageInfo.setCondition(condition);
            yhqService.findDataTables(pageInfo);

        } catch (RuntimeException e) {

        }
        return pageInfo;
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


    @ApiOperation(value = "使用优惠券")
    @RequestMapping(value = "use", method = RequestMethod.POST)
    @ResponseBody
    public Result use(@ApiParam(name = "id", value = "id") @RequestBody Long id) {


        Result result = new Result();

        try {
            Yhq yhq = yhqService.findById(id);
            if (yhq.getYxzt() != null && yhq.getYxzt() == 1) {
                result.setMsg("优惠券已使用过，不可重复使用");
                return result;
            }
            yhq.setYxzt(0);  //有效状态
            yhq.setSysj(new Date());
            yhqService.save(yhq);
            result.setMsg("优惠券使用成功");
            result.setSuccess(true);
        } catch (Exception e) {
            result.setMsg(e.getMessage());
        }
        return result;

    }


}

package cn.youguang.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "t_hd")
@Data
public class Hd extends IdEntity {


    private String hdmc;  //活动名称

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date starttime;  //活动开始时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date stoptime;  //活动结束时间

    private Integer hdts; //活动天数

    private String dwmc;  //单位名称

    private String dwdz;  //单位地址

    private String lxfs;  //联系方式

    private String hdgz; //活动规则

    private String hdjs; //活动介绍

    private String cpmc; //产品名称

    private String cptp; //产品图片

    private String cpjs; //产品介绍

    @NotNull
    private String cpsl;  //产品数量

    @NotNull
    private Double yj; //原价

    @NotNull
    private Double dj; //现价

    @NotNull
    private Double dykjje; //队员砍价金额大小

    @NotNull
    private Integer hjcs; //获奖次数

    @NotNull
    private String khwybs;//客户唯一标识

    private Integer hjrs; //已获奖人数

    private Integer cykjrs; //参与砍价人数 指的是 参加砍价的人数

    private Integer llrs;//  浏览人数


}

package cn.youguang.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "t_hd")
@Data
public class Hd extends IdEntity {


    private String hdmc;

    private Date starttime;

    private Date stoptime;

    private Integer hdts;

    private String dwmc;  //单位名称

    private String dwdz;  //单位地址

    private String lxfs;  //联系方式

    private String hdgz; //活动规则

    private String hdjs; //活动介绍

    private String cptp; //产品图片

    private String cpjs; //产品介绍

    private String cpsl;  //产品数量

    private Double yj; //原价

    private Double dj; //现价

    private Double dykjje; //队员砍价金额大小

    private Integer hjcs; //获奖次数

    private String khwybs;//客户唯一标识


}

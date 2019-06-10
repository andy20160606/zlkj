package cn.youguang.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "t_kjrz")  //砍价日志
@Data
public class Kjrz extends IdEntity {


    @ManyToOne
    @NotNull
    private User kjr;  //砍价人

    @ManyToOne
    @NotNull
    private Kjdw kjdw;  //所属砍价队伍

    private Double kjqj;//砍价前价格

    private Double kjhj;//砍价后价格

    private Double kjje; //砍价金额

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date kjsj;//砍价时间

    @ManyToOne
    @NotNull
    private Hd hd;  //砍价日志所属活动 方便判定 用户是否为这个活动砍过价




}

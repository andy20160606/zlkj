package cn.youguang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "t_yhq")
@Data
public class Yhq extends IdEntity {

    private Double je; //优惠券金额


    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date ksrq; //开始日期

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date jsrq; //结束日期

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date hqsj;   //获取优惠券日期

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date sysj;  //优惠券使用时间

    private String yhm;  //优惠码

    private Integer yxzt;//有效状态 0为使用过了  1为可使用


    @ManyToOne
    private User user;


    @ManyToOne
    private Hd hd;


}

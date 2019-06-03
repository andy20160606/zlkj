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
    private Date hqsj;

    private String yhm;  //优惠码

    private Integer yxzt;//有效状态

    @ManyToOne
    @JsonIgnore
    private User user;


    @ManyToOne
    private Hd hd;






}

package cn.youguang.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "t_kjdw")
@Data
public class Kjdw extends IdEntity{


    @ManyToOne
    private Hd hd;

    @ManyToOne
    private User dz;// 队长

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dwcjsj; //队伍创建时间

    private Double dqkjdj;//当前砍价低价  当砍价低价低于商品低价时 完成队伍砍价 每次有队友进行砍价时砍价低价降低

    private Double ykjje; //已砍价金额

    private Double sykjje; //剩余砍价金额





}

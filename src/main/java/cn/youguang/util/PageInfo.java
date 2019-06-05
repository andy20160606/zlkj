package cn.youguang.util;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

/**
 * @description：分页实体类 (结合jqery easyui)
 * @author：Wangzhixuan
 * @date：2015年4月23日 上午1:41:46
 */
public class PageInfo {

    private final static int PAGESIZE = 10; //默认显示的记录数 

    private long total; // 总记录 
    private List rows; //显示的记录  


    @JsonIgnore
    private int from;
    @JsonIgnore
    private int size;

    private int nowpage; // 当前页 

    private int pagesize; // 每页显示的记录数


    private int totalPages; //总页数
    @JsonIgnore
    private Map<String, Object> condition; //查询条件

    @JsonIgnore
    private String sort = "id";// 排序字段
    @JsonIgnore
    private String order = "asc";// asc，desc mybatis Order 关键字


    public PageInfo() {
    }

    //构造方法
    public PageInfo(int nowpage, int pagesize) {
        //计算当前页  
        if (nowpage < 0) {
            this.nowpage = 1;
        } else {
            //当前页
            this.nowpage = nowpage;
        }
        //记录每页显示的记录数  
        if (pagesize < 0) {
            this.pagesize = PAGESIZE;
        } else {
            this.pagesize = pagesize;
        }
        //计算开始的记录和结束的记录  
        this.from = (this.nowpage - 1) * this.pagesize;
        this.size = this.pagesize;
    }

    // 构造方法
    public PageInfo(int nowpage, int pagesize, String sort, String order) {
        // 计算当前页  
        if (nowpage < 0) {
            this.nowpage = 1;
        } else {
            // 当前页
            this.nowpage = nowpage;
        }
        // 记录每页显示的记录数  
        if (pagesize < 0) {
            this.pagesize = PAGESIZE;
        } else {
            this.pagesize = pagesize;
        }
        // 计算开始的记录和结束的记录  
        this.from = (this.nowpage - 1) * this.pagesize;
        this.size = this.pagesize;
        // 排序字段，正序还是反序
        this.sort = sort;
        this.order = order;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }




    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNowpage() {
        return nowpage;
    }

    public void setNowpage(int nowpage) {
        this.nowpage = nowpage;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public Map<String, Object> getCondition() {
        return condition;
    }

    public void setCondition(Map<String, Object> condition) {
        this.condition = condition;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }


    /**
     * 分页排序选项
     *
     * @return
     */
    public Pageable getPagerequest() {
        Sort prsort;
        if ("asc".equals(order)) {
            prsort = new Sort(new Order(Direction.ASC, this.sort));
        } else {
            prsort = new Sort(new Order(Direction.DESC, this.sort));
        }

        return new PageRequest(nowpage - 1, pagesize, prsort);
    }

    @JsonIgnore
    public Sort getJpaSort() {
        if ("asc".equals(order)) {
            return new Sort(new Order(Direction.ASC, this.sort));
        } else {
            return new Sort(new Order(Direction.DESC, this.sort));
        }
    }


    @Override
    public String toString() {
        return "PageInfo [total=" + total + ", rows=" + rows + ", from=" + from + ", size=" + size + ", nowpage="
                + nowpage + ", pagesize=" + pagesize + ", condition=" + condition + ", sort=" + sort + ", order="
                + order + "]";
    }

    public static int getPAGESIZE() {
        return PAGESIZE;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void finishFromJpaPages(Page page) {
        this.setTotal(page.getTotalElements());
        this.setRows(page.getContent());
        this.setTotalPages(page.getTotalPages());

    }
}

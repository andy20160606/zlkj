package cn.youguang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_user", uniqueConstraints = {@UniqueConstraint(columnNames = "wxopenid")})
public class User extends IdEntity {


    private String loginname;

    @JsonIgnore
    private String loginpass;
    private String username;

    private String usertype; //用户类型
    private Integer sex;
    private Integer age;
    private Integer status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdate;
    private String phone;


    private String wxopenid;


    private String nickname;

    private String city;

    private String procince;

    private String country;


    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Role> roles;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Organization> orgs;




    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getLoginpass() {
        return loginpass;
    }

    public void setLoginpass(String loginpass) {
        this.loginpass = loginpass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Organization> getOrgs() {
        return orgs;
    }

    public void setOrgs(List<Organization> orgs) {
        this.orgs = orgs;
    }

    public String getWxopenid() {
        return wxopenid;
    }

    public void setWxopenid(String wxopenid) {
        this.wxopenid = wxopenid;
    }



    //    public String getOrgids() {
//        String ret = null;
//        for (Organization organization : orgs) {
//            if (ret == null)
//                ret = organization.getId().toString();
//            else
//                ret = ret + "," + organization.getId();
//        }
//        return ret;
//    }
//
//    public String getRoleids() {
//        String ret = null;
//        for (Role role : roles) {
//            if (ret == null)
//                ret = role.getId().toString();
//            else
//                ret = ret + "," + role.getId();
//        }
//        return ret;
//    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProcince() {
        return procince;
    }

    public void setProcince(String procince) {
        this.procince = procince;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

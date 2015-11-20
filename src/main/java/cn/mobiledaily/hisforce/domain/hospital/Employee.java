package cn.mobiledaily.hisforce.domain.hospital;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Johnson on 2015/11/14.
 */
@Entity
public class Employee implements Serializable, UserDetails {
    private static final long serialVersionUID = -8079886415414235473L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    private Long hospitalId;
    private String name;
    private String mobile;
    private String password;
    private Date createDate = new Date();
    private Double maxDiscountRate;
    private Integer gender;
    private Long department;
    private String role;
    private String headPic;
    private Integer clinic;
    private Date birthday;
    private String contact;
    private String contactMobile;
    private Long jobTitle;
    private int status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    @JsonIgnore
    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return mobile;
    }

    @Override
    @JsonIgnore
    @Transient
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    @JsonIgnore
    @Transient
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    @JsonIgnore
    @Transient
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    @JsonIgnore
    @Transient
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Double getMaxDiscountRate() {
        return maxDiscountRate;
    }

    public void setMaxDiscountRate(Double maxDiscountRate) {
        this.maxDiscountRate = maxDiscountRate;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Long getDepartment() {
        return department;
    }

    public void setDepartment(Long department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public Integer getClinic() {
        return clinic;
    }

    public void setClinic(Integer clinic) {
        this.clinic = clinic;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public Long getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(Long jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

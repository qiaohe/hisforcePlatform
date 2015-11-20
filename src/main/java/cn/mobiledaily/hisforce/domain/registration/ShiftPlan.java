package cn.mobiledaily.hisforce.domain.registration;

import cn.mobiledaily.hisforce.domain.hospital.Employee;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Johnson on 2015/11/14.
 */
@Entity
public class ShiftPlan implements Serializable {
    private static final long serialVersionUID = -3900310979082003190L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long hospitalId;
    private Long creator;
    private Date createDate = new Date();
    private Long shitPeriod;
    private Long doctorId;
    private Integer quantity;
    @Temporal(TemporalType.DATE)
    private Date day;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getShitPeriod() {
        return shitPeriod;
    }

    public void setShitPeriod(Long shitPeriod) {
        this.shitPeriod = shitPeriod;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public ShiftPlan createBy(Employee employee) {
        setCreateDate(new Date());
        setCreator(employee.getId());
        setHospitalId(employee.getHospitalId());
        return this;
    }
}

package cn.mobiledaily.hisforce.domain.registration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Johnson on 2015/11/18.
 */
@Entity
public class Registration implements Serializable {
    private static final long serialVersionUID = -7808867207856738562L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long doctorId;
    private String doctorName;
    private Long hospitalId;
    private Long patientBasicInfoId;
    private String patientName;
    private String patientMobile;
    private Integer shiftPeriod;
    private Long departmentId;
    private String departmentName;
    private String recommender;
    private Double registrationFee;
    private Integer outPatientType;
    private Integer payementType;
    private Date registerDate;
    private Date createDate;
    private Date updateDate;
    private Date finishDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Long getPatientBasicInfoId() {
        return patientBasicInfoId;
    }

    public void setPatientBasicInfoId(Long patientBasicInfoId) {
        this.patientBasicInfoId = patientBasicInfoId;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientMobile() {
        return patientMobile;
    }

    public void setPatientMobile(String patientMobile) {
        this.patientMobile = patientMobile;
    }

    public Integer getShiftPeriod() {
        return shiftPeriod;
    }

    public void setShiftPeriod(Integer shiftPeriod) {
        this.shiftPeriod = shiftPeriod;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getRecommender() {
        return recommender;
    }

    public void setRecommender(String recommender) {
        this.recommender = recommender;
    }

    public Double getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(Double registrationFee) {
        this.registrationFee = registrationFee;
    }

    public Integer getOutPatientType() {
        return outPatientType;
    }

    public void setOutPatientType(Integer outPatientType) {
        this.outPatientType = outPatientType;
    }

    public Integer getPayementType() {
        return payementType;
    }

    public void setPayementType(Integer payementType) {
        this.payementType = payementType;
    }
}

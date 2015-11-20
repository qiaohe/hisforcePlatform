package cn.mobiledaily.hisforce.domain.patient;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Johnson on 2015/11/14.
 */
@Entity
public class Patient implements Serializable {
    private static final long serialVersionUID = 5558727364485371790L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long hospitalId;
    private String source;
    private String recommender;
    private Date createDate;
    private String memberCardNo;
    private Integer memberType;
    private Double balance;
    private Long groupId;
    private String groupName;
    private Long patientBasicInfoId;

    public Patient() {

    }

    public Patient(Long hospitalId, String recommender, Long patientBasicInfoId) {
        this();
        this.hospitalId = hospitalId;
        this.recommender = recommender;
        this.balance = 0.0d;
        this.patientBasicInfoId = patientBasicInfoId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getRecommender() {
        return recommender;
    }

    public void setRecommender(String recommender) {
        this.recommender = recommender;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getMemberCardNo() {
        return memberCardNo;
    }

    public void setMemberCardNo(String memberCardNo) {
        this.memberCardNo = memberCardNo;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Long getPatientBasicInfoId() {
        return patientBasicInfoId;
    }

    public void setPatientBasicInfoId(Long patientBasicInfoId) {
        this.patientBasicInfoId = patientBasicInfoId;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }
}

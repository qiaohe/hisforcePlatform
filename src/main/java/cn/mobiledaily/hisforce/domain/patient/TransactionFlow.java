package cn.mobiledaily.hisforce.domain.patient;

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
public class TransactionFlow implements Serializable {
    private static final long serialVersionUID = 4495330174598898840L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long hospitalId;
    private Long patientId;
    private int type;
    private Double amount;
    private Date createDate = new Date();

    public TransactionFlow() {

    }

    public TransactionFlow(Long hospitalId, Long patientId, int type, Double amount) {
        this();
        this.hospitalId = hospitalId;
        this.patientId = patientId;
        this.type = type;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}

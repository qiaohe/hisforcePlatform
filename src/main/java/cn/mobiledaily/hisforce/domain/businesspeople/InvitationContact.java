package cn.mobiledaily.hisforce.domain.businesspeople;

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
public class InvitationContact implements Serializable {
    private static final long serialVersionUID = 5610175738673771953L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mobile;
    private String name;
    private Date createDate;
    private Long businessPeopleId;
    private String source;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getBusinessPeopleId() {
        return businessPeopleId;
    }

    public void setBusinessPeopleId(Long businessPeopleId) {
        this.businessPeopleId = businessPeopleId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}

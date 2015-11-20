package cn.mobiledaily.hisforce.domain.businesspeople;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Johnson on 2015/11/19.
 */
@Entity
public class Performance implements Serializable {
    private static final long serialVersionUID = -2667427130756369651L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long businessPeopleId;
    private Integer plannedCount;
    private Integer count;
    private String yearMonth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBusinessPeopleId() {
        return businessPeopleId;
    }

    public void setBusinessPeopleId(Long businessPeopleId) {
        this.businessPeopleId = businessPeopleId;
    }

    public Integer getPlannedCount() {
        return plannedCount;
    }

    public void setPlannedCount(Integer plannedCount) {
        this.plannedCount = plannedCount;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }
}

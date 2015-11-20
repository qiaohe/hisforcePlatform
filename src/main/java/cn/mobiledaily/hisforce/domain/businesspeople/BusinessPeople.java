package cn.mobiledaily.hisforce.domain.businesspeople;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Johnson on 2015/11/14.
 */
@Entity
public class BusinessPeople implements Serializable {
    private static final long serialVersionUID = 6613196323622975904L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}

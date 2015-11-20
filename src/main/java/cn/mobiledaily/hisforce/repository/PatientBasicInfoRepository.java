package cn.mobiledaily.hisforce.repository;

import cn.mobiledaily.hisforce.domain.patient.PatientBasicInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Johnson on 2015/11/18.
 */
public interface PatientBasicInfoRepository extends JpaRepository<PatientBasicInfo, Long> {
}

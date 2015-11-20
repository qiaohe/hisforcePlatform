package cn.mobiledaily.hisforce.repository;

import cn.mobiledaily.hisforce.domain.hospital.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Johnson on 2015/11/15.
 */
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}

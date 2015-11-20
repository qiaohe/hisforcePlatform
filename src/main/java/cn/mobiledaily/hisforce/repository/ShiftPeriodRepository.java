package cn.mobiledaily.hisforce.repository;

import cn.mobiledaily.hisforce.domain.registration.ShiftPeriod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Johnson on 2015/11/17.
 */
public interface ShiftPeriodRepository extends JpaRepository<ShiftPeriod, Long> {
    public List<ShiftPeriod> findByHospitalId(Long hospitalId);
}

package cn.mobiledaily.hisforce.repository;

import cn.mobiledaily.hisforce.domain.registration.ShiftPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Johnson on 2015/11/17.
 */
public interface ShiftPlanRepository extends JpaRepository<ShiftPlan, Long> {
    public List<ShiftPlan> findByDoctorId(Long doctorId);
}

package cn.mobiledaily.hisforce.repository;

import cn.mobiledaily.hisforce.domain.hospital.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Johnson on 2015/11/15.
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public List<Department> findByHospitalId(Long hospitalId);
}

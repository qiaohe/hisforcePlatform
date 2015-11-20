package cn.mobiledaily.hisforce.repository;

import cn.mobiledaily.hisforce.domain.hospital.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Johnson on 2015/11/16.
 */
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    public List<Doctor> findByHospitalId(Long hospitalId);

    public List<Doctor> findByHospitalIdAndDepartmentId(Long hospitalId, Long departmentId);

}

package cn.mobiledaily.hisforce.repository;

import cn.mobiledaily.hisforce.domain.hospital.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Johnson on 2015/11/14.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public List<Employee> findByHospitalId(Long hospitalId);

    public Employee findByMobileAndHospitalId(String mobile, Long hospitalId);

    @Query("from Employee e where e.hospitalId = ? and e.department = ?")
    public List<Employee> findByDepartment(Long hospitalId, Long departmentId);
}

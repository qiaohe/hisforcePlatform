package cn.mobiledaily.hisforce.service;

import cn.mobiledaily.hisforce.domain.hospital.Employee;

import java.util.List;

/**
 * Created by Johnson on 2015/11/14.
 */
public interface EmployeeService {
    public Employee create(Employee employee);

    public void delete(Long empId);

    public List<Employee> getByHospitalId(Long hospitalId);

    public Employee update(Employee employee);

    public boolean remove(Long employeeId);

    public List<Employee> getByDepartment(Long hospitalId, Long departmentId);

}

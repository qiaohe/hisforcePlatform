package cn.mobiledaily.hisforce.service;

import cn.mobiledaily.hisforce.common.Util;
import cn.mobiledaily.hisforce.domain.hospital.Employee;
import cn.mobiledaily.hisforce.repository.EmployeeRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Johnson on 2015/11/14.
 */
@Service(value = "employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Inject
    private EmployeeRepository employeeRepository;
    @Inject
    private PasswordEncoder passwordEncoder;

    @Override
    public Employee create(Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employee.setStatus(0);
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Long empId) {
        employeeRepository.delete(empId);
    }

    @Override
    public List<Employee> getByHospitalId(Long hospitalId) {
        return employeeRepository.findByHospitalId(hospitalId);
    }

    @Override
    public Employee update(Employee employee) {
        if (StringUtils.isNotEmpty(employee.getPassword()))
            employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        Employee emp = employeeRepository.findOne(employee.getId());
        BeanUtils.copyProperties(employee, emp, Util.getNullPropertyNames(employee));
        return employeeRepository.save(emp);
    }

    @Override
    public boolean remove(Long employeeId) {
        employeeRepository.delete(employeeId);
        return true;
    }

    @Override
    public List<Employee> getByDepartment(Long hospitalId, Long departmentId) {
        return employeeRepository.findByDepartment(hospitalId, departmentId);
    }
}

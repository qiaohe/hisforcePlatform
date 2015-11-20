package cn.mobiledaily.hisforce.service;

import cn.mobiledaily.hisforce.common.Util;
import cn.mobiledaily.hisforce.domain.*;
import cn.mobiledaily.hisforce.domain.hospital.Department;
import cn.mobiledaily.hisforce.domain.hospital.Doctor;
import cn.mobiledaily.hisforce.domain.hospital.Employee;
import cn.mobiledaily.hisforce.domain.hospital.Hospital;
import cn.mobiledaily.hisforce.domain.registration.ShiftPeriod;
import cn.mobiledaily.hisforce.domain.registration.ShiftPlan;
import cn.mobiledaily.hisforce.repository.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 * Created by Johnson on 2015/11/15.
 */
@Service(value = "hospitalService")
public class HospitalServiceImpl implements HospitalService {
    @Inject
    private HospitalRepository hospitalRepository;
    @Inject
    private DepartmentRepository departmentRepository;
    @Inject
    private DoctorRepository doctorRepository;
    @Inject
    private EmployeeRepository employeeRepository;
    @Inject
    private ShiftPeriodRepository shiftPeriodRepository;
    @Inject
    private ShiftPlanRepository shiftPlanRepository;
    @Inject
    private ArticleRepository articleRepository;

    @Override
    public Hospital getHospitalById(Long hospitalId) {
        return hospitalRepository.findOne(hospitalId);
    }

    @Override
    public Hospital updateHospital(Hospital hospital) {
        Hospital h = hospitalRepository.findOne(hospital.getId());
        BeanUtils.copyProperties(hospital, h, Util.getNullPropertyNames(hospital));
        return hospitalRepository.save(hospital);
    }

    @Override
    public List<Department> getDepartments(Long hospitalId) {
        return departmentRepository.findByHospitalId(hospitalId);
    }

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public boolean removeDepartment(Long departmentId) {
        departmentRepository.delete(departmentId);
        return true;
    }

    @Override
    public Department updateDepartment(Department department) {
        Department dep = departmentRepository.findOne(department.getId());
        BeanUtils.copyProperties(department, dep, Util.getNullPropertyNames(department));
        return departmentRepository.save(department);
    }

    @Override
    public List<Doctor> getDoctors(Long hospitalId) {
        return doctorRepository.findByHospitalId(hospitalId);
    }

    @Override
    public List<Doctor> getDoctors(Long hospitalId, Long departmentId) {
        return doctorRepository.findByHospitalIdAndDepartmentId(hospitalId, departmentId);
    }

    @Override
    public Doctor createDoctor(Doctor doctor) {
        Employee employee = employeeRepository.findOne(doctor.getEmployeeId());
        doctor.setName(employee.getName());
        doctor.setStatus(0);
        doctor.setCreateDate(new Date());
        return doctorRepository.save(doctor);
    }

    @Override
    public boolean removeDoctor(Long doctorId) {
        doctorRepository.delete(doctorId);
        return true;
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) {
        Doctor d = doctorRepository.findOne(doctor.getId());
        BeanUtils.copyProperties(doctor, d, Util.getNullPropertyNames(doctor));
        return doctorRepository.save(doctor);
    }

    @Override
    public List<ShiftPeriod> getShitPeriods(Long hospitalId) {
        return shiftPeriodRepository.findByHospitalId(hospitalId);
    }

    @Override
    public List<ShiftPlan> getShiftPlans(Long doctorId) {
        return shiftPlanRepository.findByDoctorId(doctorId);
    }

    @Override
    public ShiftPlan addShiftPlan(ShiftPlan shiftPlan) {
        return shiftPlanRepository.save(shiftPlan);
    }

    @Override
    public boolean removeShiftPlan(Long planId) {
        shiftPlanRepository.delete(planId);
        return true;
    }

    @Override
    public Article addArticle(Article article) {
        article.init();
        return articleRepository.save(article);
    }

    @Override
    public boolean removeArticle(Long articleId) {
        articleRepository.delete(articleId);
        return true;
    }

    @Override
    public List<Article> getArticles(Long hospitalId) {
        return articleRepository.findByHospitalId(hospitalId);
    }

    @Override
    public Article updateArticle(Article article) {
        Article ac = articleRepository.findOne(article.getId());
        BeanUtils.copyProperties(article, ac, Util.getNullPropertyNames(article));
        return articleRepository.save(ac);
    }
}

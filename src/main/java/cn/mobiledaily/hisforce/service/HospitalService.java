package cn.mobiledaily.hisforce.service;

import cn.mobiledaily.hisforce.domain.*;
import cn.mobiledaily.hisforce.domain.hospital.Department;
import cn.mobiledaily.hisforce.domain.hospital.Doctor;
import cn.mobiledaily.hisforce.domain.hospital.Hospital;
import cn.mobiledaily.hisforce.domain.registration.ShiftPeriod;
import cn.mobiledaily.hisforce.domain.registration.ShiftPlan;

import java.util.List;

/**
 * Created by Johnson on 2015/11/15.
 */
public interface HospitalService {
    public Hospital getHospitalById(Long hospitalId);

    public Hospital updateHospital(Hospital hospital);

    public List<Department> getDepartments(Long hospitalId);

    public Department createDepartment(Department department);

    public boolean removeDepartment(Long departmentId);

    public Department updateDepartment(Department department);

    public List<Doctor> getDoctors(Long hospitalId);

    public List<Doctor> getDoctors(Long hospitalId, Long departmentId);

    public Doctor createDoctor(Doctor doctor);

    public boolean removeDoctor(Long doctorId);

    public Doctor updateDoctor(Doctor doctor);

    public List<ShiftPeriod> getShitPeriods(Long hospitalId);

    public List<ShiftPlan> getShiftPlans(Long doctorId);

    public ShiftPlan addShiftPlan(ShiftPlan shiftPlan);

    public boolean removeShiftPlan(Long planId);

    public Article addArticle(Article article);

    public boolean removeArticle(Long articleId);

    public List<Article> getArticles(Long hospitalId);

    public Article updateArticle(Article article);

}

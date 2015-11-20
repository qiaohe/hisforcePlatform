package cn.mobiledaily.hisforce.web;

import cn.mobiledaily.hisforce.common.Result;
import cn.mobiledaily.hisforce.domain.*;
import cn.mobiledaily.hisforce.domain.hospital.Department;
import cn.mobiledaily.hisforce.domain.hospital.Employee;
import cn.mobiledaily.hisforce.domain.hospital.Hospital;
import cn.mobiledaily.hisforce.domain.registration.ShiftPlan;
import cn.mobiledaily.hisforce.repository.ShiftPlanRepository;
import cn.mobiledaily.hisforce.service.HospitalService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Created by Johnson on 2015/11/15.
 */
@RestController
public class HospitalController {
    @Inject
    private HospitalService hospitalService;
    @Inject
    private ShiftPlanRepository shiftPlanRepository;

    @RequestMapping(value = "/hospital", method = RequestMethod.GET)
    @ResponseBody
    public Result getHospital() {
        return Result.successResult(hospitalService.getHospitalById(1L));
    }

    @RequestMapping(value = "/hospital", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateHospital(@RequestBody Hospital hospital) {
        return Result.successResult(hospitalService.updateHospital(hospital));
    }

    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    @ResponseBody
    public Result getDepartments(@AuthenticationPrincipal Employee employee) {
        return Result.successResult(hospitalService.getDepartments(employee.getHospitalId()));
    }

    @RequestMapping(value = "/departments", method = RequestMethod.PUT)
    @ResponseBody
    public Result getDepartments(@RequestBody Department department, @AuthenticationPrincipal Employee employee) {
        department.setHospitalId(employee.getHospitalId());
        return Result.successResult(hospitalService.updateDepartment(department));
    }

    @RequestMapping(value = "/departments", method = RequestMethod.POST)
    @ResponseBody
    public Result addDepartment(@RequestBody Department department, @AuthenticationPrincipal Employee employee) {
        department.setHospitalId(employee.getHospitalId());
        return Result.successResult(hospitalService.createDepartment(department));
    }

    @RequestMapping(value = "/departments/{departmentId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result removeDepartment(@PathVariable Long departmentId) {
        return Result.successResult(hospitalService.removeDepartment(departmentId));
    }

    @RequestMapping(value = "/shitPeriods", method = RequestMethod.DELETE)
    @ResponseBody
    public Result getShitPeriods(@AuthenticationPrincipal Employee employee) {
        return Result.successResult(hospitalService.getShitPeriods(employee.getHospitalId()));
    }

    @RequestMapping(value = "/doctors/{doctorId}/shiftPlans", method = RequestMethod.GET)
    @ResponseBody
    public Result getShiftPlans(@PathVariable Long doctorId) {
        return Result.successResult(hospitalService.getShiftPlans(doctorId));
    }

    @RequestMapping(value = "/doctors/{doctorId}/shiftPlans", method = RequestMethod.POST)
    @ResponseBody
    public Result addShiftPlan(@PathVariable Long doctorId, @RequestBody ShiftPlan plan, @AuthenticationPrincipal Employee employee) {
        plan.setDoctorId(doctorId);
        return Result.successResult(hospitalService.addShiftPlan(plan.createBy(employee)));
    }

    @RequestMapping(value = "/doctors/{doctorId}/shiftPlans/{planId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result removeShiftPlan(@PathVariable Long doctorId, @PathVariable Long planId, @AuthenticationPrincipal Employee employee) {
        ShiftPlan plan = shiftPlanRepository.findOne(planId);
        if (plan == null) throw new RuntimeException("shiftPlan.does.not.exists");
        if (!plan.getDoctorId().equals(doctorId)) throw new RuntimeException("shiftPlan.doctor.error");
        return Result.successResult(hospitalService.removeShiftPlan(planId));
    }

    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    @ResponseBody
    public Result getArticles(@AuthenticationPrincipal Employee employee) {
        return Result.successResult(hospitalService.getArticles(employee.getHospitalId()));
    }

    @RequestMapping(value = "/articles/{articleId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result removeArticle(@PathVariable Long articleId, @AuthenticationPrincipal Employee employee) {
        return Result.successResult(hospitalService.removeArticle(articleId));
    }

    @RequestMapping(value = "/articles", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateArticle(@RequestBody Article article, @AuthenticationPrincipal Employee employee) {
        return Result.successResult(hospitalService.updateArticle(article));
    }

    @RequestMapping(value = "/articles", method = RequestMethod.POST)
    @ResponseBody
    public Result addArticle(@RequestBody Article article, @AuthenticationPrincipal Employee employee) {
        article.setHospitalId(employee.getHospitalId());
        article.setCreator(employee.getId());
        return Result.successResult(hospitalService.addArticle(article));
    }

}

package cn.mobiledaily.hisforce.web;

import cn.mobiledaily.hisforce.common.Result;
import cn.mobiledaily.hisforce.domain.hospital.Doctor;
import cn.mobiledaily.hisforce.domain.hospital.Employee;
import cn.mobiledaily.hisforce.service.EmployeeService;
import cn.mobiledaily.hisforce.service.HospitalService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Created by Johnson on 2015/11/14.
 */
@RestController
public class EmployeeController {
    @Inject
    private EmployeeService employeeService;
    @Inject
    private HospitalService hospitalService;

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('admin')")
    public Result createEmployee(@RequestBody Employee employee) {
        return Result.successResult(employeeService.create(employee));
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    @ResponseBody
    public Result getEmployees() {
        return Result.successResult(employeeService.getByHospitalId(1L));
    }

    @RequestMapping(value = "/employees", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateEmployee(@RequestBody Employee employee) {
        return Result.successResult(employeeService.update(employee));
    }

    @RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result removeEmployee(@PathVariable Long employeeId) {
        return Result.successResult(employeeService.remove(employeeId));
    }

    @RequestMapping(value = "/departments/{departmentId}/employees", method = RequestMethod.GET)
    @ResponseBody
    public Result getEmployeesOfDepartment(@PathVariable Long departmentId, @AuthenticationPrincipal Employee employee) {
        return Result.successResult(employeeService.getByDepartment(employee.getHospitalId(), departmentId));
    }

    @RequestMapping(value = "/doctors/{doctorId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result removeDoctor(@PathVariable Long doctorId) {
        return Result.successResult(hospitalService.removeDoctor(doctorId));
    }

    @RequestMapping(value = "/doctors", method = RequestMethod.POST)
    @ResponseBody
    public Result addDoctor(@RequestBody Doctor doctor, @AuthenticationPrincipal Employee employee) {
        doctor.setHospitalId(employee.getHospitalId());
        return Result.successResult(hospitalService.createDoctor(doctor));
    }

    @RequestMapping(value = "/doctors", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateDoctor(@RequestBody Doctor doctor, @AuthenticationPrincipal Employee employee) {
        doctor.setHospitalId(employee.getHospitalId());
        return Result.successResult(hospitalService.updateDoctor(doctor));
    }

    @RequestMapping(value = "/doctors", method = RequestMethod.GET)
    @ResponseBody
    public Result getDoctors(@AuthenticationPrincipal Employee employee) {
        return Result.successResult(hospitalService.getDoctors(employee.getHospitalId()));
    }


}

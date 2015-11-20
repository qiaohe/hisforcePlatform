package cn.mobiledaily.hisforce.web;

import cn.mobiledaily.hisforce.common.Result;
import cn.mobiledaily.hisforce.domain.hospital.Employee;
import cn.mobiledaily.hisforce.domain.patient.PatientBasicInfo;
import cn.mobiledaily.hisforce.domain.registration.Registration;
import cn.mobiledaily.hisforce.service.RegistrationService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Date;

/**
 * Created by Johnson on 2015/11/18.
 */
@RestController
public class RegistrationController {
    @Inject
    private RegistrationService registrationService;

    @RequestMapping(value = "/patients/basicInfo", method = RequestMethod.POST)
    @ResponseBody
    public Result addPatientBasicInfo(@RequestBody PatientBasicInfo basicInfo, @AuthenticationPrincipal Employee employee) {
        basicInfo.setCreateDate(new Date());
        basicInfo.setCreator(employee.getId());
        return Result.successResult(registrationService.createPatientBasicInfo(basicInfo));
    }

    @RequestMapping(value = "/patients/basicInfo/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result removePatientBasicInfo(@PathVariable Long id) {
        return Result.successResult(registrationService.removePatientBasicInfo(id));
    }

    @RequestMapping(value = "/registrations", method = RequestMethod.POST)
    @ResponseBody
    public Result createRegistration(@RequestBody Registration registration, @AuthenticationPrincipal Employee employee) {
        registration.setHospitalId(employee.getHospitalId());
        return Result.successResult(registrationService.createRegistration(registration));
    }
}

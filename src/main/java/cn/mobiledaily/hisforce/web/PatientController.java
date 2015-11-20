package cn.mobiledaily.hisforce.web;

import cn.mobiledaily.hisforce.common.Result;
import cn.mobiledaily.hisforce.domain.hospital.Employee;
import cn.mobiledaily.hisforce.domain.patient.PrepaidHistory;
import cn.mobiledaily.hisforce.service.PatientService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Created by Johnson on 2015/11/18.
 */
@RestController
public class PatientController {
    @Inject
    private PatientService patientService;

    @RequestMapping(value = "/prepaidHistories", method = RequestMethod.POST)
    @ResponseBody
    public Result removeDoctor(@RequestBody PrepaidHistory history, @AuthenticationPrincipal Employee employee) {
        history.setHospitalId(employee.getHospitalId());
        history.setCreator(employee.getId());
        return Result.successResult(patientService.addPrepaidHistory(history));
    }
}

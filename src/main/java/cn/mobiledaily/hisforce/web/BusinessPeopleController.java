package cn.mobiledaily.hisforce.web;

import cn.mobiledaily.hisforce.common.Result;
import cn.mobiledaily.hisforce.domain.businesspeople.Invitation;
import cn.mobiledaily.hisforce.domain.businesspeople.InvitationContact;
import cn.mobiledaily.hisforce.domain.hospital.Employee;
import cn.mobiledaily.hisforce.service.BusinessPeopleService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Created by Johnson on 2015/11/19.
 */
@RestController
public class BusinessPeopleController {
    @Inject
    private BusinessPeopleService businessPeopleService;

    @RequestMapping(value = "/performances", method = RequestMethod.GET)
    @ResponseBody
    public Result getPerformances(@AuthenticationPrincipal Employee employee) {
        return Result.successResult(businessPeopleService.getPerformances(employee.getHospitalId(), employee.getId()));
    }

    @RequestMapping(value = "/invitations", method = RequestMethod.GET)
    @ResponseBody
    public Result getInvitations(@AuthenticationPrincipal Employee employee) {
        return Result.successResult(businessPeopleService.getInvitations(employee.getHospitalId(), employee.getId()));
    }

    @RequestMapping(value = "/invitations", method = RequestMethod.POST)
    @ResponseBody
    public Result addInvitation(@RequestBody Invitation invitation, @AuthenticationPrincipal Employee employee) {
        return Result.successResult(businessPeopleService.addInvitation(invitation));
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.POST)
    @ResponseBody
    public Result addContact(@RequestBody InvitationContact contact, @AuthenticationPrincipal Employee employee) {
        return Result.successResult(businessPeopleService.addContact(contact));
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    @ResponseBody
    public Result getContacts(@AuthenticationPrincipal Employee employee) {
        return Result.successResult(businessPeopleService.getContacts(employee.getHospitalId(), employee.getId()));
    }
}

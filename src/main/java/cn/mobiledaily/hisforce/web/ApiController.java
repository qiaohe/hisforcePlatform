package cn.mobiledaily.hisforce.web;

import cn.mobiledaily.hisforce.common.Result;
import cn.mobiledaily.hisforce.domain.hospital.Employee;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiController {
    @RequestMapping("check-login")
    @ResponseBody
    public Result url(@AuthenticationPrincipal Employee employee) {
        return employee == null ? Result.failResult("login") : Result.successResultWithoutData();
    }
}

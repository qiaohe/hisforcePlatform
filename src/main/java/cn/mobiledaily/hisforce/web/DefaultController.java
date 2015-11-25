package cn.mobiledaily.hisforce.web;

import cn.mobiledaily.hisforce.domain.hospital.Employee;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {
    @RequestMapping("/")
    public String index(@AuthenticationPrincipal Employee employee) {
        if (employee == null) {
            return "login";
        }
        return "index";
    }
}

package cn.mobiledaily.hisforce.common.auth;

import cn.mobiledaily.hisforce.common.Result;
import cn.mobiledaily.hisforce.domain.hospital.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Johnson on 2014/10/27.
 */
@Component(value = "restAuthSuccessHandler")
public class RestAuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Inject
    private ObjectMapper mapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        mapper.writeValue(writer, Result.successResult(new UserToken(request.getSession().getId(), (Employee) authentication.getPrincipal())));
        writer.flush();
    }
}
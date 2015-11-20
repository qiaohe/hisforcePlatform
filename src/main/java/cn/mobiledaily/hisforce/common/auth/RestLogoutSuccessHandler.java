package cn.mobiledaily.hisforce.common.auth;

import cn.mobiledaily.hisforce.common.LocalizedMessageSource;
import cn.mobiledaily.hisforce.common.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by Johnson on 2015/1/26.
 */
@Component(value = "restLogoutSuccessHandler")
public class RestLogoutSuccessHandler extends SecurityContextLogoutHandler {
    @Inject
    private ObjectMapper mapper;
    @Inject
    private LocalizedMessageSource localizedMessageSource;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        printResult(response, Result.successResultWithoutData());
    }

    private void printResult(HttpServletResponse response, Result result) {
        try {
            PrintWriter writer = response.getWriter();
            mapper.writeValue(response.getWriter(), result);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

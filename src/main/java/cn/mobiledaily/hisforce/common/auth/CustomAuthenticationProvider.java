package cn.mobiledaily.hisforce.common.auth;

import cn.mobiledaily.hisforce.domain.hospital.Employee;
import cn.mobiledaily.hisforce.repository.EmployeeRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

/**
 * Created by Johnson on 2015/4/23.
 */
@Component(value = "customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Inject
    private PasswordEncoder passwordEncoder;
    @Inject
    private EmployeeRepository employeeRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        Employee employee = employeeRepository.findByMobileAndHospitalId(name, 1L);
        if (employee == null) throw new BadCredentialsException("user.does.not.exists");
        List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(employee.getRole()));
        if (passwordEncoder.matches(password, employee.getPassword()))
            return new UsernamePasswordAuthenticationToken(employee, password, authorities);
        throw new BadCredentialsException("user.login.user_password.error");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

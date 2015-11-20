package cn.mobiledaily.hisforce.config;

import cn.mobiledaily.hisforce.common.auth.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.inject.Inject;

/**
 * Created by Johnson on 2015/4/22.
 */
@EnableWebSecurity
@Configuration
@ComponentScan(basePackages = "cn.mobiledaily.hisforce.common")
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Inject
    private RestAuthSuccessHandler restAuthSuccessHandler;
    @Inject
    private RestAuthFailureHandler restAuthFailureHandler;
    @Inject
    private CustomAuthenticationProvider customAuthenticationProvider;
    @Inject
    private RestLogoutSuccessHandler restLogoutSuccessHandler;

    @Inject
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthenticationProvider);
    }

    @Override
    @Bean(name = "authenticationManager")
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER).and()
                .authorizeRequests().antMatchers("/api/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/api/login").permitAll()
                .successHandler(restAuthSuccessHandler)
                .failureHandler(restAuthFailureHandler)
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/api/logout")).permitAll()
                .invalidateHttpSession(true)
                .addLogoutHandler(restLogoutSuccessHandler)
                .and().exceptionHandling().authenticationEntryPoint(new UnauthorizedAuthenticationEntryPoint());
    }
}

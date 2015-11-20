package cn.mobiledaily.hisforce.common.auth;

import cn.mobiledaily.hisforce.domain.hospital.Employee;

/**
 * Created by Johnson on 2015/11/15.
 */
public class UserToken {
    private String token;
    private Employee employee;

    public UserToken() {
    }

    public UserToken(String token, Employee employee) {
        this();
        this.token = token;
        this.employee = employee;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

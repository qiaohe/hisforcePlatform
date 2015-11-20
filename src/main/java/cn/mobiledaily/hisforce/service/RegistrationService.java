package cn.mobiledaily.hisforce.service;

import cn.mobiledaily.hisforce.domain.patient.PatientBasicInfo;
import cn.mobiledaily.hisforce.domain.registration.Registration;

/**
 * Created by Johnson on 2015/11/18.
 */
public interface RegistrationService {
    public PatientBasicInfo createPatientBasicInfo(PatientBasicInfo basicInfo);

    public boolean removePatientBasicInfo(Long basicInfoId);

    public Registration createRegistration(Registration registration);

    public Registration updateRegistration(Registration registration);
}

package cn.mobiledaily.hisforce.service;

import cn.mobiledaily.hisforce.common.Keys;
import cn.mobiledaily.hisforce.domain.hospital.Department;
import cn.mobiledaily.hisforce.domain.hospital.Doctor;
import cn.mobiledaily.hisforce.domain.patient.Patient;
import cn.mobiledaily.hisforce.domain.patient.PatientBasicInfo;
import cn.mobiledaily.hisforce.domain.registration.Registration;
import cn.mobiledaily.hisforce.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Date;

/**
 * Created by Johnson on 2015/11/18.
 */
@Service(value = "registrationService")
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
    @Inject
    private PatientBasicInfoRepository patientBasicInfoRepository;
    @Inject
    private PatientRepository patientRepository;
    @Inject
    private DepartmentRepository departmentRepository;
    @Inject
    private DoctorRepository doctorRepository;
    @Inject
    private RegistrationRepository registrationRepository;
    @Inject
    private RedisRepository redisRepository;

    @Override
    public PatientBasicInfo createPatientBasicInfo(PatientBasicInfo basicInfo) {
        return patientBasicInfoRepository.save(basicInfo);
    }

    @Override
    public boolean removePatientBasicInfo(Long basicInfoId) {
        patientBasicInfoRepository.delete(basicInfoId);
        return true;
    }

    @Override
    public Registration createRegistration(Registration registration) {
        Doctor doctor = doctorRepository.findOne(registration.getDoctorId());
        registration.setDoctorName(doctor.getName());
        registration.setRegistrationFee(doctor.getRegistrationFee());
        PatientBasicInfo patientBasicInfo = patientBasicInfoRepository.findOne(registration.getPatientBasicInfoId());
        registration.setPatientMobile(patientBasicInfo.getMobile());
        registration.setRegisterDate(new Date());
        Department department = departmentRepository.findOne(registration.getDepartmentId());
        registration.setDepartmentName(department.getName());
        Patient patient = patientRepository.findByPatientBasicInfoId(registration.getPatientBasicInfoId());
        if (patient == null) {
            patientRepository.save(new Patient(registration.getHospitalId(), registration.getRecommender(), registration.getPatientBasicInfoId()));
        }
        redisRepository.addForZSet(Keys.doctorRegistrationQueue(doctor.getId(), registration.getCreateDate()), registration.getId(), registration.getCreateDate().getTime());
        return registrationRepository.save(registration);
    }

    @Override
    public Registration updateRegistration(Registration registration) {
        return null;
    }
}

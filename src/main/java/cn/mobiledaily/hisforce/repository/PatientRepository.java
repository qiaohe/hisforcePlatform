package cn.mobiledaily.hisforce.repository;

import cn.mobiledaily.hisforce.domain.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Johnson on 2015/11/18.
 */
public interface PatientRepository extends JpaRepository<Patient, Long> {
    public Patient findByPatientBasicInfoId(Long patientBasicInfoId);
}

package cn.mobiledaily.hisforce.service;

import cn.mobiledaily.hisforce.domain.patient.Patient;
import cn.mobiledaily.hisforce.domain.patient.PrepaidHistory;
import cn.mobiledaily.hisforce.domain.patient.TransactionFlow;
import cn.mobiledaily.hisforce.repository.PatientRepository;
import cn.mobiledaily.hisforce.repository.PrepaidHistoryRepository;
import cn.mobiledaily.hisforce.repository.TransactionFlowRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by Johnson on 2015/11/18.
 */
@Service(value = "patientService")
@Transactional
public class PatientServiceImpl implements PatientService {
    @Inject
    private TransactionFlowRepository transactionFlowRepository;
    @Inject
    private PrepaidHistoryRepository prepaidHistoryRepository;
    @Inject
    private PatientRepository patientRepository;

    @Override
    public PrepaidHistory addPrepaidHistory(PrepaidHistory history) {
        TransactionFlow flow = new TransactionFlow(history.getHospitalId(), history.getPatientId(), 1, history.getPaidAmount());
        transactionFlowRepository.save(flow);
        Patient patient = patientRepository.findOne(history.getPatientId());
        patient.setBalance(patient.getBalance() + history.getAmount());
        patientRepository.save(patient);
        return prepaidHistoryRepository.save(history);
    }
}
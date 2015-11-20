package cn.mobiledaily.hisforce.repository;

import cn.mobiledaily.hisforce.domain.patient.TransactionFlow;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Johnson on 2015/11/18.
 */
public interface TransactionFlowRepository extends JpaRepository<TransactionFlow, Long> {
}

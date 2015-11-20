package cn.mobiledaily.hisforce.repository;

import cn.mobiledaily.hisforce.domain.patient.PrepaidHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Johnson on 2015/11/18.
 */
public interface PrepaidHistoryRepository extends JpaRepository<PrepaidHistory, Long> {
}

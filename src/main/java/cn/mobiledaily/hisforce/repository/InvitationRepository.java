package cn.mobiledaily.hisforce.repository;

import cn.mobiledaily.hisforce.domain.businesspeople.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Johnson on 2015/11/19.
 */
public interface InvitationRepository extends JpaRepository<Invitation, Long> {
}

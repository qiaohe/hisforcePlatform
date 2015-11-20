package cn.mobiledaily.hisforce.service;

import cn.mobiledaily.hisforce.domain.businesspeople.Invitation;
import cn.mobiledaily.hisforce.domain.businesspeople.InvitationContact;
import cn.mobiledaily.hisforce.domain.businesspeople.Performance;
import cn.mobiledaily.hisforce.repository.InvitationContactRepository;
import cn.mobiledaily.hisforce.repository.InvitationRepository;
import cn.mobiledaily.hisforce.repository.PerformanceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Johnson on 2015/11/19.
 */
@Service(value = "businessPeopleService")
@Transactional
public class BusinessPeopleServiceImpl implements BusinessPeopleService {
    @Inject
    private PerformanceRepository performanceRepository;
    @Inject
    private InvitationRepository invitationRepository;
    @Inject
    private InvitationContactRepository invitationContactRepository;
    @Override
    public List<Performance> getPerformances(Long hospitalId, Long businessPeopleId) {
        return null;
    }

    @Override
    public InvitationContact addContact(InvitationContact contact) {
        return null;
    }

    @Override
    public List<InvitationContact> getContacts(Long hospitalId, Long businessPeopleId) {
        return null;
    }

    @Override
    public boolean removeContact(Long contactId) {
        return false;
    }

    @Override
    public List<Invitation> getInvitations(Long hospitalId, Long businessPeopleId) {
        return null;
    }

    @Override
    public Invitation addInvitation(Invitation invitation) {
        return null;
    }
}

package cn.mobiledaily.hisforce.service;

import cn.mobiledaily.hisforce.domain.businesspeople.Invitation;
import cn.mobiledaily.hisforce.domain.businesspeople.InvitationContact;
import cn.mobiledaily.hisforce.domain.businesspeople.Performance;

import java.util.List;

/**
 * Created by Johnson on 2015/11/19.
 */
public interface BusinessPeopleService {
    public List<Performance> getPerformances(Long hospitalId, Long businessPeopleId);

    public InvitationContact addContact(InvitationContact contact);

    public List<InvitationContact> getContacts(Long hospitalId, Long businessPeopleId);

    public boolean removeContact(Long contactId);

    public List<Invitation> getInvitations(Long hospitalId, Long businessPeopleId);

    public Invitation addInvitation(Invitation invitation);

}

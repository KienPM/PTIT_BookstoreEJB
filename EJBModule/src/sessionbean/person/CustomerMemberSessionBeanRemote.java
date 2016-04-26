package sessionbean.person;

import javax.ejb.Remote;

import entity.person.CustomerMember;

@Remote
public interface CustomerMemberSessionBeanRemote {
	public CustomerMember checkLogin(String username, String password);
}

package sessionbean.person;

import entity.person.FullName;

import javax.ejb.Remote;

/**
 * Created by Ken on 30/04/2016.
 */
@Remote
public interface FullNameSessionBeanRemote {
    public int save(FullName fullName);
}

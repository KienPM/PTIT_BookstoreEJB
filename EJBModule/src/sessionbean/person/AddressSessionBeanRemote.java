package sessionbean.person;

import entity.person.Address;

import javax.ejb.Remote;

/**
 * Created by Ken on 30/04/2016.
 */
@Remote
public interface AddressSessionBeanRemote {
    public int save(Address address);
}

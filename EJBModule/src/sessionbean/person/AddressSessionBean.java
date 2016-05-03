package sessionbean.person;

import entity.person.Address;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Ken on 30/04/2016.
 */
@Stateless(name = "AddressSessionEJB")
public class AddressSessionBean implements AddressSessionBeanRemote {
    @PersistenceContext(unitName = "BookstoreEJB")
    private EntityManager em;

    public AddressSessionBean() {
    }

    @Override
    public int save(Address address) {
        em.persist(address);
        return address.getId();
    }
}

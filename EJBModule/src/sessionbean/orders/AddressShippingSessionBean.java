package sessionbean.orders;

import entity.orders.AddressShipping;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Ken on 03/05/2016.
 */
@Stateless(name = "AddressShippingSessionEJB")
public class AddressShippingSessionBean implements AddressShippingSessionBeanRemote {
    @PersistenceContext(unitName = "BookstoreEJB")
    private EntityManager em;

    public AddressShippingSessionBean() {
    }

    @Override
    public int save(AddressShipping addressShipping) {
        em.persist(addressShipping);
        return addressShipping.getId();
    }
}

package sessionbean.orders;

import entity.orders.ShippingInfor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Ken on 03/05/2016.
 */
@Stateless(name = "ShippingInforSessionEJB")
public class ShippingInforSessionBean implements ShippingInforSessionBeanRemote {
    @PersistenceContext(unitName = "BookstoreEJB")
    private EntityManager em;

    public ShippingInforSessionBean() {
    }

    @Override
    public int save(ShippingInfor shippingInfor) {
        em.persist(shippingInfor.getAddress());
        em.persist(shippingInfor);
        return shippingInfor.getId();
    }
}

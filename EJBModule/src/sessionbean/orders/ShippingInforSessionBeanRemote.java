package sessionbean.orders;

import entity.orders.ShippingInfor;

import javax.ejb.Remote;

/**
 * Created by Ken on 03/05/2016.
 */
@Remote
public interface ShippingInforSessionBeanRemote {
    public int save(ShippingInfor shippingInfor);
}

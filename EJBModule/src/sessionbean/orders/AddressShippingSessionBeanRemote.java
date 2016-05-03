package sessionbean.orders;

import entity.orders.AddressShipping;

import javax.ejb.Remote;

/**
 * Created by Ken on 03/05/2016.
 */
@Remote
public interface AddressShippingSessionBeanRemote {
    public int save(AddressShipping addressShipping);
}
